import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class MainMenu extends JFrame implements ActionListener{

	JPanel main = new JPanel();
	JButton title = new JButton("Welcome to Vivo!");
	JButton play = new JButton("Level Selection"); 
	JButton instr = new JButton("Instructions"); 
	public JLabel backgroundLabel = new JLabel();
	public JLabel backgroundMovingLabel = new JLabel();
	public static boolean isMusicOn = false;
	public static AudioStream audio;

	public MainMenu(){

		setSize(1300,700);
		setLayout(null);
		setTitle("Vivo Intro Screen");
		setVisible(true);
		setResizable(false);
		this.setLocationRelativeTo(null);


		if (isMusicOn == false) {

			//add music
			Thread t = new Thread() { // starts thread

				

				public void run(){
					String wav_file = "sounds/backgroundMusic.wav";

					InputStream in;			 

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
				}					
			};

			t.start();			

			isMusicOn = true;
		}


		title.setBounds(355, 120, 600, 90);
		title.setFont(new Font("Verdana", Font.PLAIN, 40));
		title.setForeground(Color.white);
		title.setOpaque(false);
		title.setContentAreaFilled(false);
		title.setBorderPainted(false);

		play.setBounds(440, 480, 400, 100);
		play.setFont(new Font("Verdana", Font.PLAIN, 26));
		play.setForeground(Color.white);
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);

		instr.setBounds(540, 560, 200, 80);
		instr.setFont(new Font("Verdana", Font.PLAIN, 26));
		instr.setForeground(Color.white);
		instr.setOpaque(false);
		instr.setContentAreaFilled(false);
		instr.setBorderPainted(false);

		backgroundLabel.setVisible(true);	
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon("images/background.jpg").getImage().getScaledInstance(1300,700, 0)));
		backgroundLabel.setBounds(0, 0, 1300,700);

		backgroundMovingLabel.setVisible(true);	
		backgroundMovingLabel.setIcon(new ImageIcon(new ImageIcon("images/movingbackground.gif").getImage().getScaledInstance(1300,700, 0)));
		backgroundMovingLabel.setBounds(0, 0, 1300,700);

		play.addActionListener(this);
		instr.addActionListener(this);
		title.addActionListener(this);

		add(play);
		add(instr);
		add(title);
		add(backgroundMovingLabel);
		add(backgroundLabel);


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == play) {

			setVisible(false);
			new VivoLevels();
		}
		else if (e.getSource() == instr) {
			setVisible(false);
			new VivoInstr();
		}

	}

}



