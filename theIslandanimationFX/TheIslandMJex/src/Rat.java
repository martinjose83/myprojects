import java.util.List;

public class Rat extends Animal {

	public Rat(Position pos,  Island ilnd) {
		super(pos, 70, ilnd, true, false, 'r');
		
	}
	public String toString(){
		return "Rat "+","+ energy+", "+thirsty;
	}
	public void move1() {
		//System.out.println(energyHigh);
				Position pos = ilnd.findRandomNearPosition(this);
				
				this.setPos(pos);

			}

}
