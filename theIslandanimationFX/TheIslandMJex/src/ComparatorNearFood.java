import java.util.Comparator;

public class ComparatorNearFood implements Comparator<Thing>{
private int x, y;
	
	public ComparatorNearFood(Position pos) {
		this.x = pos.getX();
		this.y = pos.getY();
	}
	private int distance(int ox, int oy) {
		return Math.abs(ox - x) + Math.abs(oy - y);}
	
	@Override
	public int compare(Thing o1, Thing o2) {
		int d1 = distance(o1.getPos().getX(), o1.getPos().getY());
		int d2 = distance(o2.getPos().getX(), o2.getPos().getY());
		if (d1 < d2)
			return -1;
		if (d1 > d2)
			return 1;
		return 0;
	}
	}
	


