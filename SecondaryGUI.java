import BreezySwing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class SecondaryGUI extends GBFrame {

	static JButton [][] arrayButtons = new JButton[11][11];
	Computer cpu;
	public SecondaryGUI() {

		for(int i =0; i < arrayButtons.length; i++){
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
						cpu.getGrid().attack(i, j);
					
				
						if(cpu.getGrid().checkHit(i, j)){
							temp.setBackground(Color.RED);


						}
						else{
							temp.setBackground(Color.WHITE);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						messageBox(e.getMessage());
					}
					
				}
			}

		}







	}
	public JButton [][] getArrayButtons(){
		return arrayButtons;
	}


	public void getGuess(int i, int j){

		arrayButtons[i][j].setBackground(Color.GRAY);





	}









}
