
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	Island ilnd = new Island();

	List<Thing> things = ilnd.getThings();

	ArrayList<Circle> wcircles = new ArrayList<Circle>();
	List<Thing> water = new ArrayList<Thing>();
	Map<Circle, Thing> wmap = new HashMap<Circle, Thing>();
	Map<ImageView, Thing> aimap = new HashMap<ImageView, Thing>();
	List<ImageView> aimages = new ArrayList<ImageView>();
	List<ImageView> gimages = new ArrayList<ImageView>();
	List<ImageView> addList = new ArrayList<ImageView>();
	// ImageView iv2 = new ImageView();
	private double x1, x2, y1, y2;

	@Override
	public void start(Stage primaryStage) {
		AnchorPane rightPane = new AnchorPane();
		Group root = new Group();
		BorderPane border = new BorderPane();
		Scene scene = new Scene(root, 800, 600);
		StackPane leftPane = new StackPane();
		try {
//				
			addToIsland(ilnd);
			for (Thing th : things) {
				ImageView imageView = new ImageView();

				if (th instanceof WaterPaches) {
					water.add(th);
					Circle circle = new Circle(th.getPos().getX(), th.getPos().getY(), 7);
					circle.setFill(Color.LIGHTBLUE);
					wcircles.add(circle);
				}
				if (th instanceof Grass) {
					Image image = new Image(new FileInputStream("grass.jpg"));
					imageView.setImage(image);
					imageView.setX(th.getPos().getX());
					imageView.setY(th.getPos().getY());
					imageView.setFitHeight(10);
					imageView.setFitWidth(10);
					imageView.setPreserveRatio(true);
					gimages.add(imageView);
					aimap.put(imageView, th);
				}
				if (th instanceof Stream) {
					water.add(th);
					Circle circle = new Circle(th.getPos().getX(), th.getPos().getY(), 7);
					circle.setFill(Color.LIGHTBLUE);
					wcircles.add(circle);
				}
				if (th instanceof Cat) {
					Image image = new Image(new FileInputStream("cat.png"));
					imageView.setImage(image);
					imageView.setFitHeight(50);
					imageView.setFitWidth(50);
					imageView.setPreserveRatio(true);
					aimages.add(imageView);
					aimap.put(imageView, th);
				}
				if (th instanceof Rabit) {
					Image image = new Image(getClass().getResource("rabit1.png").toExternalForm());
					imageView.setImage(image);
					imageView.setFitHeight(50);
					imageView.setFitWidth(50);
					imageView.setPreserveRatio(true);
					aimages.add(imageView);
					aimap.put(imageView, th);
				}
				if (th instanceof Sparrow) {
					Image image = new Image(getClass().getResource("sparrow2.png").toExternalForm());
					imageView.setImage(image);
					imageView.setFitHeight(50);
					imageView.setFitWidth(50);
					imageView.setPreserveRatio(true);
					aimages.add(imageView);
					aimap.put(imageView, th);
				}
				if (th instanceof Rat) {
					Image image = new Image(getClass().getResource("rat1.png").toExternalForm());
					imageView.setImage(image);
					imageView.setFitHeight(20);
					imageView.setFitWidth(20);
					imageView.setPreserveRatio(true);
					aimages.add(imageView);
					aimap.put(imageView, th);
				}
				if (th instanceof Kiwi) {
					Image image = new Image(getClass().getResource("kiwi1.png").toExternalForm());
					imageView.setImage(image);
					imageView.setFitHeight(35);
					imageView.setFitWidth(35);
					imageView.setPreserveRatio(true);
					aimages.add(imageView);
					aimap.put(imageView, th);
				}

				// MouseControlUtil.makeDragable(imageView);
				imageView.setOnDragDetected(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						Dragboard db = imageView.startDragAndDrop(TransferMode.ANY);
						ClipboardContent content = new ClipboardContent();
						content.putImage(imageView.getImage());
						db.setContent(content);
						event.consume();
						Robot robot = new Robot();
						x1 = robot.getMousePosition().getX();
						y1 = robot.getMousePosition().getY();
					}
				});
				imageView.setOnDragOver(new EventHandler<DragEvent>() {
					public void handle(DragEvent event) {
						Dragboard db = event.getDragboard();
						if (db.hasImage()) {
							event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
						}
						event.consume();

					}
				});

				imageView.setOnDragDropped(new EventHandler<DragEvent>() {
					@Override
					public void handle(DragEvent event) {
						Dragboard db = event.getDragboard();

						if (db.hasImage()) {
							Position posnew = th.getPos();
							posnew.setX((int) event.getX());
							posnew.setY((int) event.getY());

							th.setPos(posnew);

						}

						event.consume();

					}
				});
				imageView.setOnDragDone(new EventHandler<DragEvent>() {
					public void handle(DragEvent event) {

						Dragboard db = event.getDragboard();
						if (db.hasImage()) {
							Position posnew = th.getPos();
							Robot robot = new Robot();
							x2 = robot.getMousePosition().getX();
							y2 = robot.getMousePosition().getY();
							posnew.setX((int) (posnew.getX() - x1 + x2));
							posnew.setY((posnew.getY() + (int) (y2 - y1)));

							th.setPos(posnew);
							imageView.setTranslateX(aimap.get(imageView).getPos().getX());
							imageView.setTranslateY(aimap.get(imageView).getPos().getY());

						}
						event.consume();
					}
				});
			}

			KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t1) {
					ilnd.islandNewTurn();

					for (ImageView imageView : aimages) {

						imageView.setTranslateX(aimap.get(imageView).getPos().getX());
						imageView.setTranslateY(aimap.get(imageView).getPos().getY());
					}

				}
			});

			Timeline t = new Timeline(frame);
			t.setCycleCount(javafx.animation.Animation.INDEFINITE);

			VBox vbox = new VBox();
			Button btn = new Button();
			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					t.play();
					btn.setText("Move");

				}

			});
			Button btn3 = new Button();
			btn3.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					t.stop();

				}
			});

			Button btn1 = new Button();
			Button btn4 = new Button();
//			btn4.setText("Cat");
			Button btn5 = new Button();
			btn5.setText("Back");
			btn1.setText("Add Objects");
			btn1.setOnAction(event -> {
				leftPane.getChildren().clear();
				VBox vbox1 = addThings();
				vbox1.getChildren().add(btn4);

				leftPane.getChildren().addAll(vbox1, btn5);
			});
			btn4.setOnAction(arg0event2 -> {
				Bounds bIS = rightPane.localToScreen(rightPane.getBoundsInLocal());

				System.out.println(rightPane.getLayoutX() + " , " + rightPane.getLayoutY() + " , " + bIS.getMinX()
						+ " , " + bIS.getMinY());
			});
			btn5.setOnAction(event1 -> {
				leftPane.getChildren().clear();
				leftPane.getChildren().add(vbox);
				vbox.setAlignment(Pos.CENTER);

			});
			Button btn2 = new Button();
			btn2.setOnAction(event -> {
				primaryStage.close();
			});

			btn.setText("Start");
			btn2.setText("Close");
			btn3.setText("Pause");
			btn.setPrefSize(100, 25);
			btn1.setPrefSize(100, 25);
			btn2.setPrefSize(100, 25);
			btn3.setPrefSize(100, 25);
			vbox.setSpacing(5);
			vbox.getChildren().addAll(btn, btn1, btn2, btn3);

			leftPane.setStyle("-fx-background-color: black;");

			// rightPane.setPadding(arg0 );
			rightPane.getChildren().addAll(wcircles);
			rightPane.getChildren().addAll(aimages);
			rightPane.getChildren().addAll(gimages);
			SplitPane splitPane = new SplitPane();
			splitPane.setPrefSize(800, 600);
			splitPane.getItems().addAll(leftPane, rightPane);
			splitPane.setDividerPositions(0.15);

			leftPane.getChildren().add(vbox);
			vbox.setAlignment(Pos.CENTER);

			root.getChildren().addAll(border, splitPane);

			primaryStage.setTitle("Hello Animation");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private VBox addThings() {
		VBox vbox1 = new VBox();
		return vbox1;
	}

	public void addToIsland(Island ilnd) {
		Position p1 = ilnd.findPosition();
		Stream st = new Stream(p1, ilnd);
		Position p2 = ilnd.findPosition();
		WaterPaches wp = new WaterPaches(p2, ilnd);
		new Grass(ilnd.findPosition(), ilnd);
		new Grass(ilnd.findPosition(), ilnd);
		new Grass(ilnd.findPosition(), ilnd);
		new Rat(ilnd.findPosition(), ilnd);
		new Rat(ilnd.findPosition(), ilnd);
		new Rat(ilnd.findPosition(), ilnd);
		new Rat(ilnd.findPosition(), ilnd);
		new Rat(ilnd.findPosition(), ilnd);
		new Rat(ilnd.findPosition(), ilnd);
		for (int i = 0; i < 10; i++) {
			switch (1 + (int) (Math.random() * 6)) {
			case 1:
				new Rabit(ilnd.findPosition(), ilnd);
				break;
			case 2:
				new Rabit(ilnd.findPosition(), ilnd);
				break;
			case 3:
				new Kiwi(ilnd.findPosition(), ilnd);
				break;
			case 4:
				new Cat(ilnd.findPosition(), ilnd);
			case 5:
				new Sparrow(ilnd.findPosition(), ilnd);
			default:
				new Grass(ilnd.findPosition(), ilnd);
				break;
			}

		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
