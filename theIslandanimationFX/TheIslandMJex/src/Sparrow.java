import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sparrow extends Bird {

	public Sparrow(Position pos, Island ilnd) {
		super('A', pos, ilnd, 'P');
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "Sparrow "+""+ energy+", "+thirsty;
	}
public Thing searchFood() {
	List<Thing> food = new ArrayList<Thing>(10);
	for(Thing t:ilnd.things) {
		if(t instanceof Rat) food.add(t);
		ComparatorNearFood sFood = new ComparatorNearFood(this.getPos());
		Collections.sort(food, sFood);
			}
	return food.get(0);
	
	
	
}
}
