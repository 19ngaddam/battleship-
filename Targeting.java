import java.util.ArrayList;

public class Targeting {
	private ArrayList<Point> guesses;
	private int direction; 
	private int difficulty;
	private Player player;
	private Grid grid;
	//Impossible mode
	private ArrayList<Point> two;
	private ArrayList<Point> three;
	private ArrayList<Point> four;
	private ArrayList<Point> five;
	private ArrayList<Point> six;
	private Point hitPoint;
	private int idtofind;
	public Targeting(int dif, Player p){
		idtofind=2;
		player = p;
		grid = player.getGrid();
		difficulty = dif;

		guesses = new ArrayList<Point>();

		two=stealEverything(2);
		three=stealEverything(3);
		four=stealEverything(4);
		five=stealEverything(5);
		six=stealEverything(6);

	}
	public Point getNext() throws Exception{
		if(difficulty ==1){
			Point p = SelectRandom();
			//player.attack(p);
			return p;

		}
		else if(difficulty == 2){
			try {
				if(guesses.isEmpty()){
					Point p = SelectRandom();
					guesses.add(p);
					//player.attack(p);
					return p;
				}
				if(guesses.get(guesses.size()-1).getID()!=0){

					if(player.testSunk(guesses.get(guesses.size()-1))){

						Point p = SelectRandom();

						//player.attack(p);


						guesses.add(player.getPoint(p));

						return p;

					}
					else{

						//Check out of bounds exception
						if(direction == 1){

							if(guesses.get(guesses.size()-1).getX()==0){
								direction++;
							}
							else{

								Point p = new Point(guesses.get(guesses.size()-1).getX()-1,guesses.get(guesses.size()-1).getY());

								//player.attack(p);

								guesses.add(player.getPoint(p));
						
								return p;
							}
						}
						if(direction == 2){
							if(guesses.get(guesses.size()-1).getY()==9){
								direction++;
							}
							else{
								Point p = new Point(guesses.get(guesses.size()-1).getX(),guesses.get(guesses.size()-1).getY()+1);

								//player.attack(p);
							
								guesses.add(player.getPoint(p));
								return p;
							}
						}
						if(direction == 3){
							if(guesses.get(guesses.size()-1).getX()==9){
								direction++;
							}
							else{
								Point p = new Point(guesses.get(guesses.size()-1).getX()+1,guesses.get(guesses.size()-1).getY());

								//player.attack(p);
						
								guesses.add(player.getPoint(p));
								return p;
							}
						}
						if(direction ==4){
							if(guesses.get(guesses.size()-1).getY()==0){
								direction=1;
							}
							else{
								Point p = new Point(guesses.get(guesses.size()-1).getX(),guesses.get(guesses.size()-1).getY()-1);

								//player.attack(p);
							
								guesses.add(player.getPoint(p));

								return p;
							}

						}
					}
				}
				else if(guesses.size()==1){
					Point p = SelectRandom();

					//	player.attack(p);

					guesses.add(player.getPoint(p));
					return p;
				}
				else if(guesses.get(guesses.size()-2).getID()!=0){
					if(player.testSunk(guesses.get(guesses.size()-2))){
						Point p = SelectRandom();

						//player.attack(p);

						guesses.add(player.getPoint(p));
						return p;

					}

					else if(guesses.get(guesses.size()-3).getID()==guesses.get(guesses.size()-2).getID()){
						if(direction ==1){
							direction = 3;
							Point p = new Point(hitPoint.getX()+1,hitPoint.getY());

							//	player.attack(p);
						
							guesses.add(player.getPoint(p));
							return p;	
						}
						if(direction ==2){
							direction = 4;
							Point p = new Point(hitPoint.getX(),hitPoint.getY()-1);
							//	player.attack(p);
						
							guesses.add(player.getPoint(p));
							return p;

						}
						if(direction ==3){
							direction = 1;
							Point p = new Point(hitPoint.getX()-1,hitPoint.getY());
							//player.attack(p);
						
							guesses.add(player.getPoint(p));
							return p;

						}
						if(direction ==4){
							direction = 2;
							Point p = new Point(hitPoint.getX(),hitPoint.getY()+1);

							//player.attack(p);
							
							guesses.add(player.getPoint(p));
							return p;

						}			
					}
					else{
						direction++;
						if(direction == 2){
							if(guesses.get(guesses.size()-1).getY()==9){
								direction++;
							}
							else{
								Point p = new Point(hitPoint.getX(),hitPoint.getY()+1);

								//player.attack(p);
						
								guesses.add(player.getPoint(p));
								return p;
							}
						}
						if(direction == 3){
							if(guesses.get(guesses.size()-1).getX()==9){
								direction++;
							}
							else{
								Point p = new Point(hitPoint.getX()+1,hitPoint.getY());

								//player.attack(p);
					
								guesses.add(player.getPoint(p));
								return p;
							}
						}
						if(direction ==4){
							if(guesses.get(guesses.size()-1).getY()==0){
								direction = 1;
							}
							else{
								Point p = new Point(hitPoint.getX(),hitPoint.getY()+1);

								//player.attack(p);
					
								guesses.add(player.getPoint(p));
								return p;
							}

						}
					}

				}
				else{
					Point p = SelectRandom();

					//player.attack(p);

					guesses.add(player.getPoint(p));
					return p;

				}


			}
			catch(Exception e) {
				return SelectRandom();
			}

		}

		else {
			//ROHAN

			return cheat();
		}
		return null;

	}

	private Point getEmptyPoint() {
		Point p = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));
		while(p.getID()!=0) {
			p = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));
		}
		return p;

	}
	private Point SelectRandom(){
		Point a = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));
		while(player.getGrid().checkGuessed(a)==true){
			a = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));	
		}

		if((player.getPoint(a).getID()!=0)){
			hitPoint = a;
			direction = 1;
		}
		else{
			direction = 0;
		}

		return a;

	}
	private ArrayList<Point > stealEverything(int kys){
		ArrayList<Point> lol=new ArrayList<Point>();
		for(int i=0; i<grid.getAllPoints().length;i++) {

			for(int j=0;j<grid.getAllPoints().length;j++) {
				if(grid.getPoint(i, j).getID()==kys) {
					lol.add(grid.getPoint(i, j));
				}


			}


		}
		return lol;



	}
	private Point cheat() {

		if(idtofind==2) {


			Point temp=two.get(0);
			two.remove(0);
			if(two.size()==0) {
				idtofind++;
			}
			return temp;
		}
		//.
		else if(idtofind==3) {

			Point temp=three.get(0);
			three.remove(0);
			if(three.size()==0) {
				idtofind++;
			}
			return temp;



		}
		else if(idtofind==4) {

			Point temp=four.get(0);
			four.remove(0);
			if(four.size()==0) {
				idtofind++;
			}
			return temp;



		}
		else if(idtofind==5) {



			Point temp=five.get(0);
			five.remove(0);
			if(five.size()==0) {
				idtofind++;
			}
			return temp;

		}
		else if(idtofind==6) {

			Point temp=six.get(0);
			six.remove(0);
			if(six.size()==0) {
				idtofind++;
			}
			return temp;



		}


		return null;

	}
}


