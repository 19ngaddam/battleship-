import java.util.ArrayList;

public class Targeting {
	private ArrayList<Point> guesses;
	private int direction; 
	private int difficulty;
	private Player player;
	private Grid grid;
	//Impossible mode asdasd
	private ArrayList<Point> two;
	private ArrayList<Point> three;
	private ArrayList<Point> four;
	private ArrayList<Point> five;
	private ArrayList<Point> six;
	private Point hitPoint;
	private ArrayList<Point>  possibility;
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
					Point p = getEmptyPoint();
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

								if(player.getPoint(p).isGuessed()) {
									direction++;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}
						}
						if(direction == 2){
							if(guesses.get(guesses.size()-1).getY()==9){
								direction++;
								
							}
							else{
								Point p = new Point(guesses.get(guesses.size()-1).getX(),guesses.get(guesses.size()-1).getY()+1);
								if(player.getPoint(p).isGuessed()) {
									direction++;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}
						}
						if(direction == 3){
							if(guesses.get(guesses.size()-1).getX()==9){
								direction++;
								
							}
							else{
								Point p = new Point(guesses.get(guesses.size()-1).getX()+1,guesses.get(guesses.size()-1).getY());

								if(player.getPoint(p).isGuessed()) {
									direction++;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}
						}
						if(direction ==4){
							if(guesses.get(guesses.size()-1).getY()==0){
								Point p = SelectRandom();
								guesses.add(player.getPoint(p));
								return p;
							}
							else{
								Point p = new Point(guesses.get(guesses.size()-1).getX(),guesses.get(guesses.size()-1).getY()-1);

								if(player.getPoint(p).isGuessed()) {
									Point x = SelectRandom();
									guesses.add(player.getPoint(x));
									return x;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
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

				if(guesses.get(guesses.size()-2).getID()!=0){
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
							if(hitPoint.getY()==9){
								direction++;
							}
							else{
								Point p = new Point(hitPoint.getX(),hitPoint.getY()+1);
								if(player.getPoint(p).isGuessed()) {
									direction++;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}
						}
						if(direction == 3){
							if(hitPoint.getX()==9){
								direction++;
							}
							else{
								Point p = new Point(hitPoint.getX()+1,hitPoint.getY());
								if(player.getPoint(p).isGuessed()) {
									direction++;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}
						}
						if(direction ==4){
							if(hitPoint.getY()==0){
								Point p = SelectRandom();
								guesses.add(player.getPoint(p));
								return p;
							}
							else{
								Point p = new Point(hitPoint.getX(),hitPoint.getY()-1);
								if(player.getPoint(p).isGuessed()) {
									return SelectRandom();
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}

						}
					}
				}
				if(guesses.get(guesses.size()-3).getID()!=0) {
					if(player.testSunk(guesses.get(guesses.size()-3))){
						Point p = SelectRandom();

						//player.attack(p);

						guesses.add(player.getPoint(p));
						return p;

					}
					else{
						direction++;
						if(direction == 3){
							if(hitPoint.getX()==9){
								direction++;
							}
							else{
								Point p = new Point(hitPoint.getX()+1,hitPoint.getY());
								if(player.getPoint(p).isGuessed()) {
									direction++;
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}
						}
						if(direction ==4){
							if(hitPoint.getY()==0){
								Point p = SelectRandom();
								guesses.add(player.getPoint(p));
								return p;
							}
							else{
								Point p = new Point(hitPoint.getX(),hitPoint.getY()-1);
								if(player.getPoint(p).isGuessed()) {
									return SelectRandom();
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
							}

						}
					}

				}
				if(guesses.get(guesses.size()-4).getID()!=0) {
					if(player.testSunk(guesses.get(guesses.size()-4))){
						Point p = SelectRandom();

						//player.attack(p);

						guesses.add(player.getPoint(p));
						return p;

					}

					else{
						direction++;
						if(direction ==4){
							if(hitPoint.getY()==0){
								Point p = SelectRandom();
								guesses.add(player.getPoint(p));
								return p;
							}
							else{
								Point p = new Point(hitPoint.getX(),hitPoint.getY()-1);
								if(player.getPoint(p).isGuessed()) {
									return SelectRandom();
								}
								//player.attack(p);
								else {
									guesses.add(player.getPoint(p));
									return p;
								}
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
				Point pt= SelectRandom();
				guesses.add(pt);
				return pt;
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





	public static boolean isValidPoint(int r, int c) {			
		if (r < 0 || r > 9 || c < 0 || c > 9)
			return false;
		return true;			
	}

	private void testandAdd(Point p){
		if (isValidPoint(p.getX(), p.getY())) {
			if (player.getGrid().checkGuessed(p)==false) {   // not previously visited?
				possibility.add(player.getPoint(p));
			}
		}



	}





	private ArrayList<Point> buildPotential(int dir, Point p){
		if(dir == 0) {
			Point p1 = new Point(p.getX()-1,p.getY());
			testandAdd(p1);
			Point p2 = new Point(p.getX(),p.getY()+1);
			testandAdd(p2);
			Point p3 = new Point(p.getX()+1,p.getY());
			testandAdd(p3);
			Point p4 = new Point(p.getX(),p.getY()-1);
			testandAdd(p4);


		}
		if(dir == 1) {
			Point p1 = new Point(p.getX()-3,p.getY());
			testandAdd(p1);
			Point p2 = new Point(p.getX()-2,p.getY());
			testandAdd(p2);
			Point p3 = new Point(p.getX()-1,p.getY());
			testandAdd(p3);
			Point p4 = new Point(p.getX(),p.getY());
			testandAdd(p4);
			Point p5 = new Point(p.getX()+1,p.getY());
			testandAdd(p1);
			Point p6 = new Point(p.getX()+2,p.getY());
			testandAdd(p2);
			Point p7 = new Point(p.getX()+3,p.getY());
			testandAdd(p3);


		}	
		if(dir == 2) {
			Point p1 = new Point(p.getX()-3,p.getY());
			testandAdd(p1);
			Point p2 = new Point(p.getX()-2,p.getY());
			testandAdd(p2);
			Point p3 = new Point(p.getX()-1,p.getY());
			testandAdd(p3);
			Point p4 = new Point(p.getX(),p.getY());
			testandAdd(p4);
			Point p5 = new Point(p.getX()+1,p.getY());
			testandAdd(p1);
			Point p6 = new Point(p.getX()+2,p.getY());
			testandAdd(p2);
			Point p7 = new Point(p.getX()+3,p.getY());
			testandAdd(p3);

		}	



	}










}


