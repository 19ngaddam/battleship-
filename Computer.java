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
		int sauce;
		int xstarting;
		int ystarting;

		boolean allclear=true;
		do{
			allclear=true;
			
			xstarting=(int) Math.round(Math.random()*9);
			ystarting=(int)Math.round(Math.random()*9);

			dir=((int)Math.round(Math.random()*3));
			sauce=dir;
			int count=0;
			do{
				dir=(sauce+count)%4;
				count++;
				allclear=true;
			
				if(dir==0){

					if(ystarting-length+1<0){
						allclear=false;
					
					}
					else{

						for(int i=ystarting; i>=ystarting-length+1;i--){


							if(compboard.getPoint(xstarting,i).getID()!=0){
								allclear=false;
							
							}
						}
					}
				}
				else if(dir==1){
					if(xstarting+length-1>=10){
						allclear=false;
						
					}
					else{

						for(int i=xstarting; i<=xstarting+length-1;i++)


							if(compboard.getPoint(i,ystarting).getID()!=0){
								allclear=false;
							}

					}

				}
				else if(dir==2){
					if(ystarting+length-1>=10){
						allclear=false;
					}
					else{

						for(int i=ystarting; i<=ystarting+length-1;i++){


							if(compboard.getPoint(xstarting,i).getID()!=0){
								allclear=false;
							}
						}
					}


				}
				else{
					if(xstarting-length+1<0){
						allclear=false;
					}
					else{

						for(int i=xstarting; i>=xstarting-length+1;i--)


							if(compboard.getPoint(i,ystarting).getID()!=0){
								allclear=false;
							}

					}
				}

			}while(allclear==false && count<4); 
		}while(allclear==false);

		if(dir==0){	
			compboard.placeShip(xstarting, ystarting, xstarting, ystarting-length+1, s);
		}
		else if(dir==1){
			
			compboard.placeShip(xstarting, ystarting, xstarting+length-1, ystarting, s);
		}
		else if(dir==2){
			compboard.placeShip(xstarting, ystarting, xstarting, ystarting+length-1, s);
		}
		else {

			compboard.placeShip(xstarting, ystarting, xstarting-length+1, ystarting, s);
		}
	}




	public Grid getGrid(){
		return compboard;
	}

	public Ship getShip(int s){
		
		return ships[s];
		
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
		
		
		
		
		int id=compboard.getPoint(x, y).getID();
		return ships[id-2].sunk();
	}

}
