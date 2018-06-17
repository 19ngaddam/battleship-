import java.util.ArrayList;

public class Targeting {

	private int direction; 
	private Point LastPoint;
	private Point Penultimate;
	private int difficulty;
	private Player P;
	private Grid G;
	//Impossible mode
	private ArrayList<Point> two;
	private ArrayList<Point> three;
	private ArrayList<Point> four;
	private ArrayList<Point> five;
	private ArrayList<Point> six;
	private int idtofind;
	public Targeting(int dif, Player p){
		idtofind=2;
		P = p;
		G = p.getGrid();
		LastPoint = getEmptyPoint();
		Penultimate = getEmptyPoint();
		difficulty = dif;

		two=stealEverything(2);
		three=stealEverything(3);
		four=stealEverything(4);
		five=stealEverything(5);
		six=stealEverything(6);

	}
	public Point getNext(){
		if(difficulty ==1){
			Point p = SelectRandom();
			Penultimate = LastPoint;
			LastPoint = p;
			return p;

		}
		else if(difficulty == 2){
			if((LastPoint).getID()!=0){
				System.out.println("Hit");
				boolean sunk=P.testSunk(LastPoint);
				if(sunk){
					Point p = SelectRandom();
					Penultimate = LastPoint;
					LastPoint = p;
					return p;
				}
				else{
					//Check out of bounds exception
					if(direction == 1){
						Point p = new Point(LastPoint.getX()-1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction == 2){
						Point p = new Point(LastPoint.getX(),LastPoint.getY()+1);
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction == 3){
						Point p = new Point(LastPoint.getX()+1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction ==4){
						Point p = new Point(LastPoint.getX(),LastPoint.getY()-1);
						Penultimate = LastPoint;
						LastPoint = p;
						return p;					
					}
				}
			}
			else if(Penultimate.getID()!=0 ){
				direction++;

				boolean sunk=P.testSunk(Penultimate);
				if(sunk){
					Point p = SelectRandom();
					Penultimate = LastPoint;
					LastPoint = p;
					//P.attack(p);
					return p;
				}
				else{
					if(direction == 2){
						Point p = new Point(LastPoint.getX(),LastPoint.getY()+1);
						Penultimate = LastPoint;
						LastPoint = p;
						//P.attack(p);
						return p;
					}
					if(direction == 3){
						Point p = new Point(LastPoint.getX()-1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
						//P.attack(p);
						return p;
					}
					if(direction ==4){

						Point p = new Point(LastPoint.getX(),LastPoint.getY()-1);
						Penultimate = LastPoint;
						LastPoint = p;
						//P.attack(p);
						return p;					
					}
				}
			}

			else{
				Point p = SelectRandom();
				Penultimate = LastPoint;
				LastPoint = p;
				return p;
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
		while(G.checkGuessed(a)==true){
			a = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));	
		}
		if((a).getID()!=0){
			direction = 1;
		}
		else{
			direction = 0;
		}

		Penultimate = LastPoint;
		LastPoint = a;
		return a;

	}
	private ArrayList<Point > stealEverything(int kys){
		ArrayList<Point> rohanisanigger=new ArrayList<Point>();
		for(int i=0; i<G.getAllPoints().length;i++) {

			for(int j=0;j<G.getAllPoints().length;j++) {
				if(G.getPoint(i, j).getID()==kys) {
					rohanisanigger.add(G.getPoint(i, j));
				}


			}


		}
		return rohanisanigger;



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

		/*	for(int i=cheatpoint.getX();i<G.getAllPoints().length;i++) {
			for(int j=cheatpoint.getY();j<G.getAllPoints().length;j++ ) {
				Point pt=G.getPoint(i, j);
				if(pt.getID()==idtofind) {
					if(pt.getY()==9) {
						cheatpoint = new Point(0,pt.getX()+1);
					}
					else {
						cheatpoint = new Point(pt.getX(),pt.getY()+1);
					}



					return pt;
				}
			}
		}



		cheatpoint=new Point(0,0);
		idtofind++;
		for(int i=cheatpoint.getX();i<G.getAllPoints().length;i++) {
			for(int j=cheatpoint.getY();j<G.getAllPoints().length;j++ ) {
				Point pt=G.getPoint(i, j);
				if(pt.getID()==idtofind) {
					if(pt.getY()==9) {
						cheatpoint = new Point(pt.getX()+1,0);
					}
					else {
						cheatpoint = new Point(pt.getX(),pt.getY()+1);
					}

					return pt;
				}
			}
		}*/



		return null;

	}
}

