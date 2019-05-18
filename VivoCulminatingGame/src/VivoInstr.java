
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VivoInstr extends JFrame implements ActionListener{

	JPanel main = new JPanel();
	JLabel label = new JLabel ("How To Play:");
	JButton play = new JButton("Level Selection"); 
	public JLabel backgroundLabel = new JLabel();
	
	JTextArea area = new JTextArea ("Objective: Launch the given music note to the target note on the staff line\n\n"
			+ "-Use the mouse to adjust the angle of projection by clicking the plus and minus button\n\n" +
			"- After you are content with the desired angle, use the mouse to click the LAUNCH! button\n\n" +
			"-The Score is based on the number of tries taken to hit the target note\n\n" +
			"Good Luck!"
			);

	public VivoInstr(){

		setSize(1300,700);
		setLayout(null);
		setTitle("Vivo Intructions Screen");
		setVisible(true);
		this.setLocationRelativeTo(null);

		play.setBounds(510, 580, 300, 70);
		play.setFont(new Font("Verdana", Font.PLAIN, 26));
		play.setForeground(Color.black);

		label.setBounds(550, 75, 400, 80);
		label.setFont(new Font("Verdana", Font.PLAIN, 36));
		label.setForeground(Color.white);

		area.setBounds(410, 200, 500, 330);
		area.setBackground(new Color(0,0,20, 100));
		area.setFont(new Font("Verdana", Font.PLAIN, 20));
		area.setForeground(Color.white);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);

		backgroundLabel.setVisible(true);	
	    backgroundLabel.setIcon(new ImageIcon(new ImageIcon("images/background.jpg").getImage().getScaledInstance(1300,700, 0)));
		backgroundLabel.setBounds(0, 0, 1300, 700);
		
		play.addActionListener(this);
		add(play);
		add(label);
		add(area);
		add(backgroundLabel);


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == play) {

			setVisible(false);
			new VivoLevels();


		}

	}

}




