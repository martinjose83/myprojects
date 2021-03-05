import java.util.ArrayList;
import java.util.List;

public class Kiwi extends Bird {
	int count =0;
	public Kiwi(Position pos, Island ilnd) {
		super('L', pos, ilnd, 'K');
		energyHigh = 80;
		

		// TODO Auto-generated constructor stub
	}

	public String toString() {

		return "Kiwi "+""+ energy+", "+thirsty;
	}

	public void searchFood() {
		boolean foundFood = false;
		if ((Math.random() * 10) > 3)
			foundFood = true;
		System.out.println(foundFood);
		if (foundFood)
			eatFood();
		this.move();

	}

	public void move() {
		Position pos = ilnd.findRandomNearPosition(this);
		count++;
//		this.energy--;
//		thirsty++;
//		if ((energy <= 0)||(thirsty > 60)){
//			List<Thing> things1 = ilnd.getThings();
//			things1.remove(this);
//			ilnd.setThings(things1);
			//System.out.println(this + " died of thirsty");
			//return;
	//	}
		if(count>=10) {
		this.setPos(pos);count =0;}
		return;

	}

	public void moveToWtr(Thing wtr) {
		int x = this.getPos().getX();
		int y = this.getPos().getY();
		int x1 = wtr.getPos().getX();
		int y1 = wtr.getPos().getY();
		if (x < x1)
			x++;
		if (x > x1)
			x--;
		if (y < y1)
			y++;
		if (y > y1)
			y--;
		if ((x == x1) && (y == y1)) {
			drinkWater(wtr);
			return;
		}
		Position p1 = new Position(x, y);
		if (!ilnd.landpositionClear(p1))
			p1 = ilnd.findRandomNearPosition(this);
		this.energy--;
		thirsty++;
		if ((energy <= 0)||(thirsty > 60)){
			List<Thing> things1 = ilnd.getThings();
			things1.remove(this);
			ilnd.setThings(things1);
			//System.out.println(this + " died of thirsty");
			return;
		}
		setPos(p1);
		// return;

	}

	public void eatFood() {
		int foodSize = (int) (Math.random() * 10);
		if (energy < energyHigh)
			energy += foodSize;

	}
}
