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
	static JButton [][] arrayButtons = new JButton[11][11];
	static SecondaryGUI sGUI = new SecondaryGUI();
	static ControlPanel cGUI;
	static Player p;
	static Targeting t;
	
	public Board(){
		p = new Player();
	
		cGUI = new ControlPanel(p);
		for(int i =1; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				JButton b = new JButton();


				b =  addButton("", i, j, 1, 1);

				b.setIcon(new ImageIcon("src/img.jpg"));

				arrayButtons[i][j] = b;

			}
		}

	}

	/*	public static void displayShips(int row1, int column1, int row2, int column2) {

		if(row1==row2){


			for(int i=Math.min(column1, column2);i<=Math.max(column1, column2);i++){

				arrayButtons[row1][i].setBackground(Color.BLACK);

			}



		}
		else if(column1==column2){


			for(int i=Math.min(row1, row2);i<=Math.max(row1, row2);i++){

				arrayButtons[i][column1].setBackground(Color.BLACK);

			}



		}





	}*/
	
	public void buttonClicked(JButton b) {
		/*for(int i =1; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				if(p.getGrid().getPoint(i-1, j-1).getHit() && b == arrayButtons[i][j]) {
					arrayButtons[i][j].setBackground(Color.red);
				}
				}
			}*/
	}
	public static void setTargeting(int dif,Player p) {
		
		
		t=new Targeting(dif,p);
		
	}
	public static void guess() {
		
	
		
		try {
			Point pt=t.getNext();
			System.out.println("x " +pt.getX() +" y " +pt.getY());
			p.attack(pt);
			
			if(p.testSunk(pt)) {

				Board.sGUI.messageBox("Your " + p.getShip(p.getPoint(pt).getID()).getName()+" has been sunk!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	public static void updateGUI(Player player) {


		p=player;

		for(int i =1; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				if(p.getGrid().getPoint(i-1, j-1).getID()!=0) {
					arrayButtons[i][j].setBackground(Color.BLACK);
					int shipAtPoint =p.getGrid().getPoint(i-1, j-1).getID(); 
					if(shipAtPoint == 2){
						arrayButtons[i][j].setIcon(new ImageIcon("src/dest.jpg"));

					}else if(shipAtPoint ==3 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/sub.jpg"));

					}else if(shipAtPoint == 4 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/batt.jpg"));

					}else if(shipAtPoint == 5 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/carr.jpg"));

					}else if(shipAtPoint == 6 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/upb.jpg"));

					}else{
						arrayButtons[i][j].setIcon(new ImageIcon(new BufferedImage (299, 168, BufferedImage.TYPE_INT_ARGB)));
					}



				}
				if(p.getGrid().getPoint(i-1, j-1).isGuessed()) {
					arrayButtons[i][j].setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					arrayButtons[i][j].setBackground(Color.WHITE);
				}
				if(p.getGrid().getPoint(i-1, j-1).getHit()) {
					arrayButtons[i][j].setIcon(new ImageIcon("src/img2.jpg"));
					
					if(p.gg()) {
						JOptionPane.showMessageDialog(null,"You have LOST!! Better luck next time!");
						System.exit(0);
					}

					
					}

			}
		}
		


	}
	public static void updateGUI() {


		for(int i =1; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				if(p.getGrid().getPoint(i-1, j-1).getID()!=0) {
					arrayButtons[i][j].setBackground(Color.BLACK);
					int shipAtPoint =p.getGrid().getPoint(i-1, j-1).getID(); 
					if(shipAtPoint == 2){
						arrayButtons[i][j].setIcon(new ImageIcon("src/dest.jpg"));

					}else if(shipAtPoint ==3 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/sub.jpg"));

					}else if(shipAtPoint == 4 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/batt.jpg"));

					}else if(shipAtPoint == 5 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/carr.jpg"));

					}else if(shipAtPoint == 6 ){
						arrayButtons[i][j].setIcon(new ImageIcon("src/upb.jpg"));

					}else{
						arrayButtons[i][j].setIcon(new ImageIcon(new BufferedImage (299, 168, BufferedImage.TYPE_INT_ARGB)));
					}



				}
				if(p.getGrid().getPoint(i-1, j-1).isGuessed()) {
					arrayButtons[i][j].setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					arrayButtons[i][j].setBackground(Color.WHITE);
				}
				if(p.getGrid().getPoint(i-1, j-1).getHit()) {
					arrayButtons[i][j].setIcon(new ImageIcon("src/img2.jpg"));
					
					if(p.gg()) {
						JOptionPane.showMessageDialog(null,"You have LOST!! Better luck next time!");
						System.exit(0);
					}

					
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
