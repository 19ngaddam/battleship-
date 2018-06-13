import BreezySwing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.swing.*;
import javax.swing.border.*;

import javax.swing.*;

public class Board extends GBFrame{
	JButton [][] arrayButtons = new JButton[11][11];
	static SecondaryGUI sGUI = new SecondaryGUI();
	static ControlPanel cGUI;
	Player p;

	public Board(){
		p = new Player();
		cGUI = new ControlPanel(p);
		for(int i =0; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				JButton b = new JButton();


				b =  addButton("", i, j, 1, 1);

				b.setIcon(new ImageIcon("src/img.jpg"));

				b.setBackground(Color.BLUE);
				arrayButtons[i][j] = b;
			}
		}

	}




	public void buttonClicked(JButton buttonObj){
		for(int i = 0; i < arrayButtons.length; i++){
			for(int j = 0; j < arrayButtons[i].length; j++){
				if(buttonObj == arrayButtons[i][j]){

					arrayButtons[i][j].setIcon(new ImageIcon("src/img2.jpg"));
					sGUI.getGuess(i, j);

				}
			}
			
		}

	}


	/**
	 * Main Method
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		Board GUI = new Board();
		sGUI.setSize(400, 400);
		sGUI.setVisible(true);
		GUI.setSize(600, 600);
		GUI.setVisible(true);
		cGUI.setSize(250, 100);
		cGUI.setVisible(true);
		cGUI.setLocation(470, 200);
		GUI.setLocation(0, 395);
		sGUI.setLocation(80,0);



	}

}

