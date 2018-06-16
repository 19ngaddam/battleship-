public class Point {

	
	
	private int shipID;
	private boolean hit;

	private boolean isGuessed;
	
	private int x;
	private int y;
	
	
	
	public Point(int xc, int yc){
		
		
		x=xc;
		
		y=yc;
		shipID=0;

		hit=false;

		isGuessed=false;


	}
	public void addShip(int ID) throws Exception{

		if(shipID!=0){
			
			throw new Exception("Ship already placed here");
			
			
		}
		
		
		shipID=ID;

		

	}

	public void attack() throws Exception{

		if(isGuessed==true){
			throw new Exception("Point has already been attacked");
		}
		else{
			isGuessed=true;
			if(shipID!=0){

				hit=true;
			}
		}



	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isGuessed(){

		return isGuessed;

	}
	public boolean getHit(){
		return hit;
	}
	public int getID(){
		return shipID;
	}

}
