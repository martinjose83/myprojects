public class WaterPaches extends Geography {

	public WaterPaches(Position pos, Island ilnd) {
		super('L', pos, ilnd,'W');
		// TODO Auto-generated constructor stub
		this.grow();
	}
	
	 static int s= 2000;
	public void grow() {
		
		while(s>0) {
			s--;
			if(ilnd.anyNearPosClear(this.getPos())) {
			Position p = ilnd.findRandomNearPosition(this);
			WaterPaches wp = new WaterPaches(p, ilnd);
			wp.grow();
			}
			else return;
			
		}}
		
	
	public String toString(){
		return "Water Patches at";
	}
}
