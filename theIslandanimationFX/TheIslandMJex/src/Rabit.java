import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rabit extends Animal {
	//private final int energyHigh = 100;
	public Rabit(Position pos, Island ilnd) {
		super(pos, 150, ilnd,true,false ,'R');
		super.setEnergyHigh(200);
	}
	
public Thing searchFood(){
	List<Thing> food = new ArrayList<Thing>(10);
	for(Thing t:ilnd.things) {
		if((t instanceof Grass) &&((Grass)t).getSize()>5)food.add(t);
		ComparatorNearFood nfood = new ComparatorNearFood(this.getPos());
		Collections.sort(food, nfood);
			}
	return food.get(0);
	
}
	public String toString(){
		return "Rabit"+""+ energy+", "+thirsty;
	}
	
}
