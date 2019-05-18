import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;


public class VivoLevels extends JFrame implements ActionListener{

	JButton title = new JButton("Level Selection");
	JButton level1 = new JButton("1");
	JButton level2 = new JButton("2");
	JButton level3 = new JButton("3");
	JButton back = new JButton("Back");
	public JLabel backgroundLabel = new JLabel();

	public VivoLevels() {

		setSize(1300,700);
		setLayout(null);
		setTitle("Vivo Level Selection");
		setVisible(true);
		this.setLocationRelativeTo(null);

		title.setBounds(445, 50, 400, 80);
		title.setFont(new Font("Verdana", Font.PLAIN, 36));
		title.setForeground(Color.white);
		title.setOpaque(false);
		title.setContentAreaFilled(false);
		title.setBorderPainted(false);
		
		back.setBounds(100, 50, 100, 60);
		back.setFont(new Font("Verdana", Font.PLAIN, 20));
		back.setForeground(Color.black);

		level1.setBounds(275, 200, 300, 150);
		level1.setFont(new Font("Verdana", Font.PLAIN, 26));
		level1.setForeground(Color.black);

		level2.setBounds(710, 200, 300, 150);
		level2.setFont(new Font("Verdana", Font.PLAIN, 26));
		level2.setForeground(Color.black);

		level3.setBounds(500, 450, 300, 150);
		level3.setFont(new Font("Verdana", Font.PLAIN, 26));
		level3.setForeground(Color.black);

		backgroundLabel.setVisible(true);	
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon("images/background.jpg").getImage().getScaledInstance(1300, 700, 0)));
		backgroundLabel.setBounds(0, 0, 1300, 700);

		level1.addActionListener(this);
		back.addActionListener(this);
		
		add(title);
		add(level1);
		add(level2);
		add(level3);
		add(back);
		add(backgroundLabel);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == level1) {

			setVisible(false);
			new VivoLevel1GUI();
			
			AudioPlayer.player.stop(MainMenu.audio);
	
		} else if (e.getSource() == back) {
			setVisible(false);
			new MainMenu();
		}

	}

}


