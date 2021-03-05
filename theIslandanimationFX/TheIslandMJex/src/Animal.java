import java.util.List;

public class Animal extends Thing {
	int energyHigh;
	public int energy;
	boolean herbi;
	boolean carni;
	int thirsty = 0;

	public Animal(Position pos, int en, Island ilnd, boolean herbi, boolean carni, char sym) {
		super('L', pos, ilnd, sym);
		this.energy = en;
		this.herbi = herbi;
		this.carni = carni;
		// TODO Auto-generated constructor stub
	}

	public void act() {
		Thing wtr = null;
		if (thirsty > 10) {
			wtr = searchWater();
			if (wtr != null)
				moveToWtr(wtr);
		}
		Thing fd = null;
		if (energy < energyHigh / 2) {
			if (this instanceof Rabit)
				fd = ((Rabit) this).searchFood();
			if (this instanceof Cat)
				fd = ((Cat) this).searchFood();
			if (fd != null)
				moveToFood(fd);
		} else
			this.move();
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
		if ((energy <= 0) || (thirsty > 60)) {
			List<Thing> things1 = ilnd.getThings();
			things1.remove(this);
			ilnd.setThings(things1);
			// System.out.println(this + " died of thirsty");
			return;
		}

		setPos(p1);
		return;

	}

	private void drinkWater(Thing wtr) {
		if ((wtr instanceof Stream) || (wtr instanceof WaterPaches))
			thirsty = 0;

	}

	public void moveToFood(Thing fd) {
		int x = this.getPos().getX();
		int y = this.getPos().getY();
		int x1 = fd.getPos().getX();
		int y1 = fd.getPos().getY();
		if (x < x1)
			x++;
		if (x > x1)
			x--;
		if (y < y1)
			y++;
		if (y > y1)
			y--;
		if ((x == x1) && (y == y1)) {
			eatFood(fd);
			return;
		}
		Position p1 = new Position(x, y);
		if (!ilnd.landpositionClear(p1))
			p1 = ilnd.findRandomNearPosition(this);
		this.energy--;
		thirsty++;
		if ((energy <= 0) || (thirsty > 60)) {
			List<Thing> things1 = ilnd.getThings();
			things1.remove(this);
			ilnd.setThings(things1);
			// System.out.println(this + " died of thirsty");
			return;
		}
		setPos(p1);
		return;

	}

	private void eatFood(Thing fd) {
		if (fd instanceof Grass) {
			this.energy += ((Grass) fd).getSize();
		}
		if (fd instanceof Rabit) {
			this.energy += ((Rabit) fd).getEnergy();
		}
		if (fd instanceof Kiwi) {
			this.energy += ((Kiwi) fd).getEnergy();
		}
		List<Thing> things1 = ilnd.getThings();
		things1.remove(fd);
		ilnd.setThings(things1);
		System.out.println(this + " eats " + fd);
		return;

	}

	public void move() {
//System.out.println(energyHigh);
		//Position pos = findNewPosition(this.getPos());
		Position pos = ilnd.findRandomNearPosition(this);
//		this.energy--;
//		thirsty++;
//		if ((energy <= 0) || (thirsty > 60)) {
//			List<Thing> things1 = ilnd.getThings();
//			things1.remove(this);
//			ilnd.setThings(things1);
//			// System.out.println(this + " died of thirsty");
//			return;
//		}
		this.setPos(pos);

	}

	public String toString() {
		return this.toString() + "with energy " + energy;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getEnergyHigh() {
		return energyHigh;
	}

	public void setEnergyHigh(int energyHigh) {
		this.energyHigh = energyHigh;
	}

}
