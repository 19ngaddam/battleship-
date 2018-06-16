public class Ship {


	private String name;

	private int ID;//serves as ID the ship and the length





	private int lives;







	public Ship(int id){

		ID=id;

		if(id==2){

			name= "Destroyer";
		}
		else if(id==3){
			name="Submarine";

		}

		else if(id==4){ 
			name="Battleship";
		}
		else if(id==5){ 
			name="Carrier";
		}
		else if(id==6){
			name="Ultimate Patrol Boat";


		}



		lives=ID;
	}

	public String getName(){



		return name;
	}

	public boolean sunk(){

		if (lives<=0)

			return true;

		else
			return false;

	}

	public void hitShip(){


		lives--;

	}
	public int getID(){

		return ID;


	}

	public int getlives(){
		return lives;

	}




}
