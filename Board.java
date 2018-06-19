import BreezySwing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
public class SecondaryGUI extends GBFrame {

	static JButton [][] arrayButtons = new JButton[11][11];
	Computer cpu;
	private String hitSound = "C://Users/Admin/workspace-SCHOOL/Battleship/Resources/hitsound.wav";
	private String missSound = "C://Users/Admin/workspace-SCHOOL/Battleship/Resources/misssound.wav";
	private String winSound = "C://Users/Admin/workspace-SCHOOL/Battleship/Resources/winSound.wav";

	URL hitSoundURL, missSoundURL, winSoundURL;
	
	public SecondaryGUI() {

		for(int i = 1; i < arrayButtons.length; i++){
			for(int j = 1; j < arrayButtons[0].length; j++){
				JButton b = new JButton();


				b =  addButton("", i, j, 1, 1);
				b.setIcon(new ImageIcon( new BufferedImage(299, 168, BufferedImage.TYPE_INT_ARGB)));
				b.setBackground(Color.BLUE);
				b.setToolTipText("(" + i + ", " + j + ")");
				arrayButtons[i][j] = b;

				// arrayButtons[i][j].setEnabled(false);
				hitSoundURL = getClass().getResource("C://Users/Admin/workspace-SCHOOL/Battleship/Resources/hitsound.wav");
				missSoundURL = getClass().getResource("C://Users/Admin/workspace-SCHOOL/Battleship/Resources/misssound.wav");
				winSoundURL = getClass().getResource("C://Users/Admin/workspace-SCHOOL/Battleship/Resources/winSound.wav");
						
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
							play(hitSoundURL);
							if(cpu.testSunk(i-1,j-1)) {
								messageBox("You have sunk the enemy's " + cpu.getShip(cpu.getGrid().getPoint(i-1, j-1).getID()).getName());
								if(cpu.gg()) {

									play(winSoundURL);
									messageBox("You have won!! Victory Royale!!");
									
									TimeUnit.SECONDS.sleep(2);
									System.exit(0);
								}

							}

						}

						else{
							temp.setBackground(Color.WHITE);
							play(missSoundURL);
						}
						Board.guess();
						Board.updateGUI();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						messageBox(e.getMessage());
					}

					
				}

			}}







	}
	public JButton [][] getArrayButtons(){
		return arrayButtons;
	}





	public static void play(URL filename)
	  {
	      try
	      {
	          Clip clip = AudioSystem.getClip();
	          clip.open(AudioSystem.getAudioInputStream(filename));
	          clip.start();
	          TimeUnit.SECONDS.sleep(2);
	      }
	      catch (Exception exc)
	      {
	          exc.printStackTrace(System.out);
	      }
	  }





}
