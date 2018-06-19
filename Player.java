import BreezySwing.*;
import javax.swing.*;
public class Player {



	Grid playerboard;
	Ship[] ships; 

	public Player() {


		ships = new Ship[5];


		for(int i=0; i<5;i++){

			ships[i]=new Ship(i+2);
		}
		playerboard=new Grid();
	}

	public Player(Player copy) {
		playerboard=copy.getGrid();
		ships=copy.getAllShips();
	}
	public void attack(int x, int y) throws Exception{

		playerboard.attack(x, y);
		int i=playerboard.getPoint(x, y).getID();
		ships[i-1].hitShip();
		/*if(ships[i-1].sunk()==true){

			Board.sGUI.messageBox(ships[i-1].getName()+" has been sunk!");
		}

*/
	}
	public void attack(Point p) throws Exception{
		int x=p.getX();
		int y=p.getY();
		playerboard.attack(x, y);
		int i=playerboard.getPoint(x, y).getID();
		if(playerboard.getPoint(x, y).getID() != 0) {
			this.getShip(i).hitShip();
			/*if(this.getShip(i).sunk()==true){

				Board.sGUI.messageBox("Your " + this.getShip(i).getName()+" has been sunk!");
			}*/
		}



	}


	public Grid getGrid(){
		return playerboard;
	}

	public Ship getShip(int s){

		return ships[s-2];

	}
	public boolean gg() {


		boolean gg=true;
		for(int i=0; i<5;i++) {
			if(ships[i].sunk()==false) {
				gg=false;
			}
		}
		return gg;

	}
	public boolean testSunk(int x, int y) {




		int id=playerboard.getPoint(x, y).getID();
		return ships[id-2].sunk();
	}
	public Point getPoint(Point p) {
		int x=p.getX();
		int y=p.getY();
		
		return playerboard.getPoint(x, y);
		
		
		
	}
	public Ship[] getAllShips() {
		return ships;
	}
	public boolean testSunk(Point p) {

		int x=p.getX();
		int y=p.getY();
				


		int id=playerboard.getPoint(x, y).getID();
		if(id<2) {
			return false;
		}
		else {
		return ships[id-2].sunk();
		}
	}
}
