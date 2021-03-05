import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Thing {
	private Position pos;
	private char gPos;
	private char symbol;
	public int d;
	//private String obType;
	public Island ilnd;
	public Thing(char gPos, Position pos,Island ilnd, char symbol) {
		this.pos = pos;
		 this.gPos = gPos;
		this.symbol = symbol;
		this.ilnd = ilnd;
		ilnd.getThings().add(this);
		this.d =(int)(1 +  (Math.random() * 8));
	}
	
	public Thing searchWater() {
		List<Thing> stream = new ArrayList<Thing>(10);
		for(Thing t:ilnd.things) {
			if((t instanceof Stream) ||(t instanceof Stream) )stream.add(t);
			ComparatorNearFood nwtr = new ComparatorNearFood(this.getPos());
			Collections.sort(stream, nwtr);
				}
		return stream.get(0);
		
		
		
	}
	
	
	
	
	public String toString(){
		return this.toString()+" at "+pos;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public Island getIlnd() {
		return ilnd;
	}
	public void setIlnd(Island ilnd) {
		this.ilnd = ilnd;
	}
	public char getSymbol() {
		
		return symbol;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	}
	

