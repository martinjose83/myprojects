
public class Grass extends Geography {
private int size = 2;
	public Grass( Position pos, Island ilnd) {
		super('L', pos, ilnd,'G');
		// TODO Auto-generated constructor stub
	}
	public void grow() {
		if(size<20)size++;
		if(size>=20) {
			if(ilnd.anyNearPosClear(this.getPos())) {
			Position p1 = ilnd.findRandomNearPosition(this);
			new Grass(p1, ilnd);
			}
			
		}
		
	}
	public String toString(){
		return "Grass";
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
