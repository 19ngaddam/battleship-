import java.util.*;

public class Computer {
	Grid compboard;
	Ship[] ships; 

	public Computer() throws Exception {


		ships = new Ship[5];


		for(int i=0; i<5;i++){

			ships[i]=new Ship(i+2);
		}
		compboard=new Grid();

	
		
		placeAllShips();








	}




	public void placeAllShips() throws Exception{

		int i=0;	

		while(i<5){


			randomPlacement(ships[i]);

			i++;

		}
	}

	private void randomPlacement(Ship s) throws Exception{
		int length=s.getID();

		double dir;
		int xstarting;
		int ystarting;

		boolean allclear=true;
		do{
			allclear=true;
			dir=Math.random();
			xstarting=(int)Math.random()*9+1;
			ystarting=(int)Math.random()*9+1;



			if(dir<0.5){

				if(ystarting+length>10){
					allclear=false;
				}
				else{

					for(int i=ystarting; i<ystarting+length;i++){


						if(compboard.getPoint(xstarting,i).getID()!=0){
							allclear=false;
						}
					}
				}
			}
			else{
				if(xstarting+length>10){
					allclear=false;
				}
				else{

					for(int i=xstarting; i<xstarting+length;i++)


						if(compboard.getPoint(i,ystarting).getID()!=0){
							allclear=false;
						}

				}

			}


		}while(allclear==false);
		
		if(dir<=0.5){
			compboard.placeShip(xstarting, ystarting, xstarting, ystarting+length, s);
		}
		else{

			compboard.placeShip(xstarting, ystarting, xstarting+length, ystarting, s);
		}
	}


	

	public Grid getGrid(){
		return compboard;
	}



}; i<5;i++){

			ships[i]=new Ship(i+1);
		}


		placeAllShips();








	}




	private void placeAllShips() throws Exception{

		int i=0;	

		while(i<5){


			randomPlacement(ships[i]);

			i++;

		}
	}

	private void randomPlacement(Ship s) throws Exception{
		int length=s.getID();

		double dir;
		int xstarting;
		int ystarting;

		boolean allclear=true;
		do{

			dir=Math.random();
			xstarting=(int)Math.random()*9+1;
			ystarting=(int)Math.random()*9+1;



			if(dir<=0.5){

				if(ystarting+length>10){
					allclear=false;
				}
				else{

					for(int i=ystarting; i<ystarting+length;i++)


						if(compboard.getPoint(xstarting,i).getID()!=0){
							allclear=false;
						}

				}
			}
			else{
				if(xstarting+length>10){
					allclear=false;
				}
				else{

					for(int i=xstarting; i<xstarting+length;i++)


						if(compboard.getPoint(i,ystarting).getID()!=0){
							allclear=false;
						}

				}

			}


		}while(allclear==false);
		
		if(dir<=0.5){
			compboard.placeShip(xstarting, ystarting, xstarting, ystarting+length, s);
		}
		else{

			compboard.placeShip(xstarting, ystarting, xstarting+length, ystarting, s);
		}
	}


	

	public Grid getGrid(){
		return compboard;
	}



}
