import BreezySwing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class SecondaryGUI extends GBFrame {

	static JButton [][] arrayButtons = new JButton[11][11];
	Computer cpu;
	public SecondaryGUI() {

		for(int i = 1; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				JButton b = new JButton();


				b =  addButton("", i, j, 1, 1);
				b.setIcon(new ImageIcon( new BufferedImage(299, 168, BufferedImage.TYPE_INT_ARGB)));
				b.setBackground(Color.BLUE);
				arrayButtons[i][j] = b;

				// arrayButtons[i][j].setEnabled(false);


			}

		}
	
		try {
			cpu=new Computer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			messageBox(e.getMessage());
		}


	}

	public void buttonClicked(JButton b){
		for(int i =0; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){

				JButton temp;
				if(arrayButtons[i][j]==b){

					temp=b;




					try {
						cpu.getGrid().attack(i-1, j-1);
					
				
						if(cpu.getGrid().checkHit(i-1, j-1)){
							//messageBox(""+cpu.getGrid().getPoint(i-1, j-1).getID());
							temp.setBackground(Color.RED);
							cpu.getShip(cpu.getGrid().getPoint(i-1, j-1).getID()).hitShip();
							if(cpu.testSunk(i-1,j-1)) {
								messageBox("You have sunk the enemy's " + cpu.getShip(cpu.getGrid().getPoint(i-1, j-1).getID()).getName());
								if(cpu.gg()) {
									
									messageBox("You have won!! Victory Royale!!");
									System.exit(0);
								}
							}
						}
						else{
							temp.setBackground(Color.WHITE);
						}
						Board.guess();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						messageBox(e.getMessage());
					}
					
				}
			}

		}







	}
	public JButton [][] getArrayButtons(){
		return arrayButtons;
	}











}
