import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class VivoLevel1GUI extends JFrame implements ActionListener{

	//	VivoLevel1Panel level1 = new VivoLevel1Panel();

	public static JLabel stafflines = new JLabel();
	public static JLabel background = new JLabel ();

	public static final int CELL_SIZE = 25;
	public static int scoreNumber = 0;
	public static final double GRAVITY = 5;

	public static JLabel eighthNote = new JLabel(new ImageIcon(new ImageIcon("images/eighthNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	public static JLabel quarterNote = new JLabel (new ImageIcon(new ImageIcon("images/quarterNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	public static JLabel halfNote = new JLabel (new ImageIcon(new ImageIcon("images/halfNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	public static JLabel sixteenthNote = new JLabel (new ImageIcon(new ImageIcon("images/sixteenthNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	JLabel[] musicNotes = new JLabel[]{eighthNote, quarterNote, halfNote, sixteenthNote};

	JLabel angleNumber = new JLabel();
	JLabel scoreText = new JLabel("Score: 0");
	JLabel bravo = new JLabel();
	JLabel note = new JLabel();
	JLabel targetNote = new JLabel();

	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton launch = new JButton("LAUNCH!");

	int randNote=0;
	static int randTarget=0;

	Point [] targetNoteLocation = new Point[]{new Point(985, 114), new Point(988, 136), new Point(989, 159), new Point(987,181), 
			new Point(983, 203), new Point(977, 225), new Point(986, 240), new Point(977, 264),
			new Point(993, 292), new Point(980, 312), new Point(987, 327)};

	String [] tone = new String[]{"HighGNote.wav", "HighFNote.wav", "HighENote.wav", "HighDNote.wav", "CNote.wav", 
			"BNote.wav", "ANote.wav", "GNote.wav", "FNote.wav", "ENote.wav", "DNote.wav"};

	public Point startingLocation;
	public double angle = 45;
	public double v0x;
	public double v0y;
	public int tries = 0;
	public int counter = 0;

	public VivoLevel1GUI () {

		frameSetup(); 

	}

	public void frameSetup() {

		//this method formats and adds the images, JLabels, and JButtons onto the frame.
		//It also calls the placeNote method

		System.out.println("setFrame");
		setSize(1300,700);
		setLayout(null);
		setTitle("Level 1");
		this.setLocationRelativeTo(null);
		setVisible(true);


		placeNote();


		scoreText.setBounds(1000 ,450, 200, 200);
		scoreText.setFont(new Font("Serif", Font.PLAIN, 30));

		stafflines.setBounds (900 ,100, 600, 500);
		stafflines.setIcon(new ImageIcon(new ImageIcon("images/stafflines.png").getImage().getScaledInstance(320, 370, 0)));

		background.setIcon(new ImageIcon(new ImageIcon("images/level1background.gif").getImage().getScaledInstance(1300, 700, 0)));
		background.setBounds(0, 0, 1300, 700);//x,y,w,h

		plus.setBounds(CELL_SIZE*2,CELL_SIZE*16,60,60);
		minus.setBounds(CELL_SIZE*2,CELL_SIZE*19,60,60);

		angleNumber.setBounds (CELL_SIZE*2,CELL_SIZE*13,100,100);
		angleNumber.setFont(new Font("Serif", Font.PLAIN, 30));
		angleNumber.setText(angle + "°");

		bravo.setVisible(false);
		bravo.setBounds(550,300,150,30);
		bravo.setFont(new Font("Serif", Font.PLAIN, 30));
		bravo.setText("BRAVO!");

		launch.setBounds(CELL_SIZE*5,CELL_SIZE*23,150,60);
		launch.setFont(new Font("Serif", Font.PLAIN, 20));

		launch.addActionListener(this);
		minus.addActionListener(this);
		plus.addActionListener(this);

		add(launch);
		add(minus);
		add(plus);
		add(scoreText);
		add(bravo);
		add(angleNumber);
		add(stafflines);
		add(background);
	}

	private void placeNote() {

		//this method takes one out of the four random notes from the array and displays it when the frame is called.
		//It also takes a random targetNote location from an array and plots it on a specific coordinate,
		//giving the note a pitch on the staff lines

		randNote = (int)(Math.random()*4); // n is the random number
		note = musicNotes[randNote];
		note.setBounds(CELL_SIZE*5,CELL_SIZE*15,CELL_SIZE*6,CELL_SIZE*6); //x,y,w,h
		note.setVisible(true);
		add(note);

		System.out.println("note Location" + note.getLocation());

		randTarget=(int) (Math.random()*11);
		Point randPoint = targetNoteLocation[randTarget];
		
		System.out.println("randTarget generated " + randTarget);
		
		targetNote = new JLabel(note.getIcon()); //copying the picture of the note for targetNote
		targetNote.setBounds((int)randPoint.getX(), (int)randPoint.getY(), CELL_SIZE*6,CELL_SIZE*6);
		targetNote.setBorder(null);
		targetNote.setVisible(true);
		add(targetNote);

		System.out.println("targetNote Location" + targetNote.getLocation());

		//		note.repaint();
		//		targetNote.repaint();

	}

	public void actionPerformed(ActionEvent e) {

		//this method controls the actions of the JButtons

		if (e.getSource() == plus) {
			increaseAngle();

			String wav_file = "sounds/click.wav";

			InputStream in;			 
			AudioStream audio;


			try {
				in = new FileInputStream(wav_file);				
				audio = new AudioStream(in);
				AudioPlayer.player.start(audio);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == minus) {
			decreaseAngle();

			String wav_file = "sounds/click.wav";

			InputStream in;			 
			AudioStream audio;

			try {
				in = new FileInputStream(wav_file);				
				audio = new AudioStream(in);
				AudioPlayer.player.start(audio);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}

		} else if (e.getSource() == launch) {

			moveNote(note);
			
			String wav_file = "sounds/gliss.wav";

			InputStream in;			 
			AudioStream audio;


			try {
				in = new FileInputStream(wav_file);				
				audio = new AudioStream(in);
				AudioPlayer.player.start(audio);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}


	}



	public void decreaseAngle() { 

		angle -= 1;
		angleNumber.setText(String.valueOf(angle)+"°");

	}

	public void increaseAngle() {	
		angle += 1;
		angleNumber.setText(String.valueOf(angle)+"°");
	}



	private void moveNote(JLabel myNote) {

		//this method contains the projectile equations that move the note across the screen
		//It does this by taking the inputed angle into the set equation and moving the note using a thread
		boolean isHit = false;

		int v0 = 80; // m/s

		v0x = v0 * Math.cos(Math.toRadians(angle)); // get X component 
		v0y = v0 * Math.sin(Math.toRadians(angle)); // get Y component

		System.out.println("Destination X:" + v0x + " Y:" + v0y);

		startingLocation = (Point) note.getLocation().clone(); // current Location

		Thread t = new Thread(){

			public void run(){
				double dx=0;
				double dy=0;
				for (double time = .3; dx<850; time += .4) {

					dx = v0x * time; // get displacement X 
					dy = v0y * time - (0.5 * GRAVITY * Math.pow(time, 2)); // get displacement y		

					note.setBounds((int)startingLocation.getX() + (int)dx, (int)startingLocation.getY() - (int)dy, CELL_SIZE*6,CELL_SIZE*6); //get new location 
					System.out.println("New Location:" + note.getLocation());


					try {
						Thread.sleep(40);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}

					note.repaint();
				}


				if ( 

						//if the user is successful in reaching the target

						note.getLocation().getX() <= targetNote.getLocation().getX() + 3 && 
						note.getLocation().getX() >= targetNote.getLocation().getX() - 3 &&
						note.getLocation().getY() <= targetNote.getLocation().getY() + 3 &&
						note.getLocation().getY() >= targetNote.getLocation().getY() - 3) {

					String wav_file = "sounds/" + tone[randTarget];
				
					System.out.println("randTarget:" + randTarget);
					
					InputStream in;			 
					AudioStream audio;

					// loops it when the song ends
					try {
						in = new FileInputStream(wav_file);				
						audio = new AudioStream(in);
						AudioPlayer.player.start(audio);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					} 
					
					counter++;

					if (tries == 0) {
						scoreNumber+= 10; //increment score
					} else if (tries ==1) {
						scoreNumber+= 5;
					}else {
						scoreNumber +=2;
					}
					scoreText.setText("Score: " + scoreNumber); //display score


					bravo.setVisible(true);


					// Delays the "Bravo" to stay on the screen
					try {
						Thread.sleep(700);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}

					bravo.setVisible(false);

					//place note
					randNote = (int)(Math.random()*4); // n is the random number
					note.setIcon( musicNotes[randNote].getIcon());
					note.setBounds(CELL_SIZE*5,CELL_SIZE*15,CELL_SIZE*6,CELL_SIZE*6); //x,y,w,h

					
					randTarget = (int) (Math.random()*11); //updatnig randTarget variable so that it changes with the new random variable
					Point randPoint = targetNoteLocation[randTarget];
					targetNote.setIcon(note.getIcon()); //copying the picture of the note for targetNote
					targetNote.setBounds((int)randPoint.getX(), (int)randPoint.getY(), CELL_SIZE*6,CELL_SIZE*6);

					System.out.println("targetNote Location" + targetNote.getLocation());

					tries=0;

					if (counter == 15) {
						setVisible(false);
						new VivoLevelCompletion();
					}

				}
				else { //if the user is not successful in reaching the target, the same note goes back to starting position

					tries++;

					try { // Delay the note
						Thread.sleep(900);
					} catch (Exception e1) {

						e1.printStackTrace();

					}

					note.setLocation(startingLocation); //set note to go back to the starting location
				}


			}

		}; //thread ends

		t.start();


	}

}







