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

		int dir;
		//ArrayList<Integer> dir= new ArrayList<Integer>();
	
		int xstarting;
		int ystarting;

		boolean allclear=true;
		do{
			allclear=true;
			dir=(int)Math.round(Math.random()*3);
			xstarting=(int) Math.round(Math.random()*9);
			ystarting=(int)Math.round(Math.random()*9);



			if(dir==0){

				if(ystarting-length<0){
					allclear=false;
				}
				else{

					for(int i=ystarting; i>ystarting-length;i--){


						if(compboard.getPoint(xstarting,i).getID()!=0){
							allclear=false;
						}
					}
				}
			}
			else if(dir==1){
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
			else if(dir==2){
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
				if(xstarting-length<0){
					allclear=false;
				}
				else{

					for(int i=xstarting; i>xstarting-length;i--)


						if(compboard.getPoint(i,ystarting).getID()!=0){
							allclear=false;
						}

				}
			}


		}while(allclear==false);
		
		if(dir==0){
			compboard.placeShip(xstarting, ystarting, xstarting, ystarting-length, s);
		}
		else if(dir==1){

			compboard.placeShip(xstarting, ystarting, xstarting+length, ystarting, s);
		}
		else if(dir==2){
			compboard.placeShip(xstarting, ystarting, xstarting, ystarting+length, s);
		}
		else {

			compboard.placeShip(xstarting, ystarting, xstarting-length, ystarting, s);
		}
	}


	

	public Grid getGrid(){
		return compboard;
	}



}
