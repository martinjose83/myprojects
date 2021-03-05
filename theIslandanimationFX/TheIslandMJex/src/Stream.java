
public class Stream extends Geography {

	public Stream(Position pos, Island ilnd) {
		super('L', pos, ilnd,'S');
		// TODO Auto-generated constructor stub
		grow();
	}
	
	 static int s= 2500;
	public void grow() {
		
		while(s>0) {
			s--;
			if(ilnd.anyNearPosClear(this.getPos())) {
			Position p1 = ilnd.findRandomNearPosition(this);
			Stream st = new Stream(p1, ilnd);
			st.grow();
			}
			else return;
			
		}}
		
	
	public String toString(){
		return "Stream at";
	}
}
