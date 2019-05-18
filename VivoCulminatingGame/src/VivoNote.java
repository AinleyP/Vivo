import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class VivoNote extends JLabel{
	
	private String name;
	private String value; // half note, quarter note, eighth note, sixteenth note
	private ImageIcon icon;
	private String tone;
	private static final int CELL_SIZE=25;
	
	public static JLabel eighthNote = new JLabel(new ImageIcon(new ImageIcon("images/eighthNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	public static JLabel quarterNote = new JLabel (new ImageIcon(new ImageIcon("images/quarterNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	public static JLabel halfNote = new JLabel (new ImageIcon(new ImageIcon("images/halfNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	public static JLabel sixteenthNote = new JLabel (new ImageIcon(new ImageIcon("images/sixteenthNote.png").getImage().getScaledInstance(CELL_SIZE*6, CELL_SIZE*6, 0)));
	JLabel[] musicNotes = new JLabel[]{eighthNote, quarterNote, halfNote, sixteenthNote};
	private String[] noteNames = new String[]{"A","B","C","D","E","F","G","HD","HE","HF","HG"}; //11
	private String[] noteValues = new String[]{
			"Eighth Note",
			"Quarter Note",
			"Half Note",
			"Sixteenth Note"
			};
	private String[] noteValueImages = new String[]{
			"images/eighthNote.png",
			"images/quarterNote.png",
			"images/halfNote.png",
			"images/sixteenthNote.png"
			};
	
	
	private String[] NOTE_VALUES = new String[]{};
		
	public void ViVoNote() {
		
	}
	
	public void getRandomize() {
		
		
	}

	
	
	public String getTone() {
		return tone;
	}


	public void setTone(String tone) {
		this.tone = tone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public ImageIcon getIcon() {
		return icon;
	}


	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	

}
