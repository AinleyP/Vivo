import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VivoLevelCompletion extends JFrame implements ActionListener{

	JLabel title = new JLabel("Level Complete!");
	JLabel score = new JLabel("Your score is: 0" );
//	JLabel movingNotes = new JLabel();
	JButton level = new JButton("Go Back To Level Selection"); 
	public JLabel backgroundLabel = new JLabel();

	public VivoLevelCompletion (){

		setSize(1300,700);
		setLayout(null);
		setTitle("Vivo Level Completion");
		setVisible(true);
		setResizable(false);
		this.setLocationRelativeTo(null);

		title.setBounds(500, 90, 400, 80);
		title.setFont(new Font("Verdana", Font.PLAIN, 36));
		title.setForeground(Color.white);
		title.setOpaque(false);

		score.setText("Your Score is: "+ VivoLevel1GUI.scoreNumber);
		score.setBounds(460, 500, 400, 80);
		score.setFont(new Font("Verdana", Font.PLAIN, 36));
		score.setForeground(Color.white);
		score.setOpaque(false);

		level.setBounds(440, 600, 400, 70);
		level.setFont(new Font("Verdana", Font.PLAIN, 18));
		level.setForeground(Color.black);
		level.setOpaque(false);

//		movingNotes.setVisible(true);
//		movingNotes.setIcon(new ImageIcon(new ImageIcon("images/movingNotes.gif").getImage().getScaledInstance(400,100, 0)));
//		movingNotes.setBounds(450, 160, 400,100);

		backgroundLabel.setVisible(true);	
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon("images/background.jpg").getImage().getScaledInstance(1300,700, 0)));
		backgroundLabel.setBounds(0, 0, 1300,700);

		level.addActionListener(this);

		add(title);
		add(score);
		add(level);
//		add(movingNotes);
		add(backgroundLabel);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == level) {

			setVisible(false);
			new VivoLevels(); 

		}

	}


}

