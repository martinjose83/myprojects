import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat extends Animal {
//private final int energyHigh =200;
	public Cat(Position pos, Island ilnd) {
		super(pos, 200, ilnd,true,true, 'C');
		setEnergyHigh(300);
	}
	public String toString(){
		return "Cat "+","+ energy+", "+thirsty;
	}
	public Thing searchFood() {
		List<Thing> catFood = new ArrayList<Thing>();
		for(Thing t:ilnd.things) {
			if(((t instanceof Rabit) &&((Rabit)t).getEnergy()<this.getEnergy())||(t instanceof Kiwi)||(t instanceof Rat))catFood.add(t);
			ComparatorNearFood cfood = new ComparatorNearFood(this.getPos());
			Collections.sort(catFood, cfood);
				}
		return catFood.get(0);
		
	}
	
}
