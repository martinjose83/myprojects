import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Island {
	int height = 600;
	int width = 600;
	public List<Thing> things = new ArrayList<Thing>();

	public Island() {

	}

	
	public void islandNewTurn() {
		for (int i = 0; i < things.size(); i++) {
			Thing t = things.get(i);
			if ((t instanceof Animal) && (!(t instanceof Rat))) {
				((Animal) t).move();
			}
			if ((t instanceof Rat)) {
				((Rat) t).move1();
			}
		if(t instanceof Bird) {
			((Bird)t).move();
		}
//		if(t instanceof Plant) {
//			((Plant)t).grow();
//		}
//		if(t instanceof Grass) {
//			((Grass)t).grow();
//}

		}
	}

	public Position findPosition() {
		int x = (int) (Math.random() * width);
		int y = (int) (Math.random() * height);
		Position p1 = new Position(x, y);
		if (!landpositionClear(p1))
			findPosition();
		return (p1);
	}

	public boolean landpositionClear(Position pos) {
		int x = pos.getX(), y = pos.getY();
		if (x < 10 || x > width-10 || y < 10 || y > height-30)
			return false;
		if (things.size() != 0) {
			for (Thing t : things) {
				if (((t.getPos().getX()) == x) && ((t.getPos().getY()) == y))
					return false;

//			if ((t instanceof Animal || t instanceof Plant || t instanceof WaterPaches|| t instanceof Stream )
//					&& ((t.getPos().getX() == x) && (t.getPos().getY() == y)))
//				return false;
			}}
		return true;
	}

	public Position findRandomNearPosition(Thing th) {
		Position pos = th.getPos();
		int d = th.getD();
		int x = pos.getX();
		int y = pos.getY();

		switch (d) {
		case 1:
			y--;
			break;
		case 2:
			x--;
			y--;
			break;
		case 3:
			x--;
			break;
		case 4:
			x--;
			y++;
			break;
		case 5:
			y++;
			break;
		case 6:
			x++;
			y++;
			break;
		case 7:
			x++;
			break;
		default:
			x++;
			y--;
			break;
		}
		Position p1 = new Position(x, y);
		if ((!this.landpositionClear(p1)) ){ if (anyNearPosClear(pos)) {
			if (d>=1)th.setD(d-1);
			else th.setD(8);
			findRandomNearPosition(th);
		}}
		return (p1);

	}

	
	public boolean anyNearPosClear(Position pos) {
		if (this.landpositionClear(new Position((pos.getX() + 1), (pos.getY()))))
			return true;
		if (this.landpositionClear(new Position((pos.getX() - 1), pos.getY())))
			return true;
		if (this.landpositionClear(new Position((pos.getX()), pos.getY() + 1)))
			return true;
		if (this.landpositionClear(new Position((pos.getX()), pos.getY() - 1)))
			return true;
		if (this.landpositionClear(new Position((pos.getX() + 1), (pos.getY()-1))))
			return true;
		if (this.landpositionClear(new Position((pos.getX()) - 1, pos.getY()-1)))
			return true;
		if (this.landpositionClear(new Position((pos.getX()-1), pos.getY() + 1)))
			return true;
		if (this.landpositionClear(new Position((pos.getX()-1), pos.getY() + 1)))
			return true;
		return false;
	}

	public List<Thing> getThings() {
		return things;
	}

	

	public void setThings(List<Thing> things) {
		this.things = things;
	}

}
