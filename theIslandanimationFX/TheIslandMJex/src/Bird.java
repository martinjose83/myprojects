import java.util.List;

public class Bird extends Thing {
	public int energy = 55;
	int energyHigh;
	int thirsty;

public Bird(char gPos, Position pos, Island ilnd, char symbol) {
		super(gPos, pos, ilnd, symbol);
		
	}

public void act() {
	Thing fd = null;
	Thing wtr= null;
	if(thirsty> 20) wtr = searchWater();
	if(this instanceof Kiwi && wtr!= null)  ((Kiwi)this). moveToWtr(wtr);
	if(wtr!= null)moveToFood(wtr);
	
	if(energy< energyHigh/2) {
		if(this instanceof Kiwi)  ((Kiwi)this). searchFood();
		if(this instanceof Sparrow)  fd = ((Sparrow)this). searchFood();
		if (fd != null)moveToFood(fd);
	}
	else this.move();
}
public void drinkWater(Thing wtr) {
	if( (wtr instanceof Stream)||(wtr instanceof WaterPaches))
		thirsty=0;}

public void moveToFood(Thing fd) {
	int x = this.getPos().getX();
	int y = this.getPos().getY();
	int x1 = fd.getPos().getX();
	int y1 = fd.getPos().getY();
	if ((x < x1)&&((x1-x)>3))
		x+=3;
	if ((x < x1)&&((x1-x)<3))
		x=x1;
	if ((x > x1)&&((x-x1)>3))
		x-=3;
	if ((x > x1)&&((x-x1)<3))
		x=x1;
	if ((y < y1)&&((y1-y)>3))
		y+=3;
	if ((y < y1)&&((y1-y)<3))
		y=y1;
	if ((y > y1)&&((y-y1)>3))
		y-=3;
	if ((y > y1)&&((y-y1)<3))
		y=y1;
	if ((x == x1) && (y == y1)) {
		eatFood(fd);
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
	return;

}

private void eatFood(Thing fd) {
		this.energy += ((Rat)fd).getEnergy();
}

public void move() {
	Position pos = ilnd.findRandomNearPosition(this);
//	this.energy--;
//	this.thirsty--;
	this.setPos(pos);
	pos = ilnd.findRandomNearPosition(this);
	this.setPos(pos);
}

public int getEnergy() {
	return energy;
}

public void setEnergy(int energy) {
	this.energy = energy;
}

public String toString(){
	return this.toString()+""+ energy+", "+thirsty;
}
}
