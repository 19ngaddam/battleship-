

public class Targeting {

	private int direction; 
	private Point LastPoint;
	private Point Penultimate;
	private int difficulty;
	private Computer P;
	private Grid G;

	public Targeting(int dif, Computer p){
		LastPoint = new Point(0,0);
		Penultimate = null;
		difficulty = dif;
		P = p;
		G = p.getGrid();
	}
	public Point getNext(){
		if(difficulty ==1){
			Point p = SelectRandom();
			Penultimate = LastPoint;
			LastPoint = p;
			return p;
		}
		else if(difficulty == 2){
			if(G.checkHit(LastPoint)){
				int id=LastPoint.getID();
				boolean sunk=P.getShip(id-2).sunk();
				if(sunk){
					Point p = SelectRandom();
					Penultimate = LastPoint;
					LastPoint = p;
					return p;
				}
				else{
					if(direction == 1){
						Point p = new Point(LastPoint.getX(),LastPoint.getY()+1);
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction == 2){
						Point p = new Point(LastPoint.getX()+1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction == 3){
						Point p = new Point(LastPoint.getX(),LastPoint.getY()-1);
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction ==4){
						Point p = new Point(LastPoint.getX()-1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
						return p;					
					}
				}
			}
			else if(G.checkHit(Penultimate)){
				direction++;
				int id=Penultimate.getID();
				boolean sunk=P.getShip(id-2).sunk();
				if(sunk){
					Point p = SelectRandom();
					Penultimate = LastPoint;
					LastPoint = p;
					return p;
				}
				else{
					if(direction == 2){
						Point p = new Point(LastPoint.getX()+1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction == 3){
						Point p = new Point(LastPoint.getX(),LastPoint.getY()-1);
						Penultimate = LastPoint;
						LastPoint = p;
						return p;
					}
					if(direction ==4){
						Point p = new Point(LastPoint.getX()-1,LastPoint.getY());
						Penultimate = LastPoint;
						LastPoint = p;
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
		/*	else if(difficulty == 3){
				//ROHAN
			} */
	return new Point(0,0);//change
	}
	private Point SelectRandom(){
		Point a = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));
		while(G.checkGuessed(a)==true){
			a = new Point((int)Math.round(Math.random()*9),(int)Math.round(Math.random()*9));
			if(G.checkHit(a)){
				direction = 1;
			}
			else{
				direction = 0;
			}

		}

		return a;

	}
}

