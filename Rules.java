
//import
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Rules extends JFrame implements ActionListener {

	// declare variables
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	JButton b1, b2;

	// private variables
	private JComboBox difficulty1;

	Rules(String username) {
		super("Rules - SafeCracker");// super is named "Rules - SafeCracker"

		// create and display welcome label
		l1 = new JLabel("Welcome " + username); // display welcome and the password field input the user entered
		l1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		l1.setForeground(SystemColor.textHighlight);
		l1.setBounds(145, 5, 319, 50);
		getContentPane().add(l1);

		// create and add message to frame
		l2 = new JLabel("Please Read Rules Carefully!");
		l2.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l2.setBounds(150, 15, 500, 100);
		getContentPane().add(l2);

		// create and add message to frame
		l3 = new JLabel("Instructions");
		l3.setFont(new Font("CALIBRI", Font.BOLD, 20));
		l3.setBounds(190, 35, 450, 150);
		getContentPane().add(l3);

		// create and add rule 1 to frame
		l4 = new JLabel("20 second time limit for EACH question");
		l4.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l4.setBounds(49, 119, 296, 81);
		getContentPane().add(l4);

		// create and add rule 2 to frame
		l5 = new JLabel("You will have one hint (EasyMode)");
		l5.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l5.setBounds(49, 166, 243, 125);
		getContentPane().add(l5);

		// create and add rule 3 to frame
		l6 = new JLabel("You can only use the hint once (Easy Mode)");
		l6.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l6.setBounds(49, 222, 296, 87);
		getContentPane().add(l6);

		// create and add rule 4 to frame
		l7 = new JLabel("Total 10 questions");
		l7.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l7.setBounds(49, 243, 135, 110);
		getContentPane().add(l7);

		// create and add rule 5 to frame
		l9 = new JLabel("Make sure to complete within given time (20 secs)");
		l9.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l9.setBounds(49, 151, 335, 81);
		getContentPane().add(l9);

		// create and add rule 6 to frame
		l10 = new JLabel("Click submit after completing all questions");
		l10.setFont(new Font("CALIBRI", Font.PLAIN, 16));
		l10.setBounds(49, 290, 296, 81);
		getContentPane().add(l10);

		// create and display the combo box
		String[] difficultyLevel = { "Easy", "Hard" }; // add options easy and hard
		JComboBox difficulty1 = new JComboBox(difficultyLevel); // create combo box
		difficulty1.setBackground(SystemColor.control);
		difficulty1.setBounds(145, 354, 183, 45);
		getContentPane().add(difficulty1); // add to frame

		// create and display the "back" button
		b2 = new JButton("Back");
		b2.setFont(new Font("CALIBRI", Font.BOLD, 20));
		b2.setBounds(122, 424, 100, 30);
		b2.setBackground(SystemColor.activeCaptionBorder);
		b2.setForeground(Color.WHITE);
		getContentPane().add(b2);
		b2.addActionListener(this);

		// create and display the start button
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // if the user clicks start button
				// get the option user chose from combo box
				String selectedLevel = (String) difficulty1.getSelectedItem();
				if (selectedLevel.equals(difficultyLevel[0]))// if selected easy mode
				{
					new QuizDashboard(); // open easy dashboard
					setVisible(false); // get rid of rules frame

				} else { // if selected hard mode
					new QuizDashboardHard(); // open hard dashboard
					setVisible(false); // get rid of rules frame
				}
			}
		});
		btnStart.setFont(new Font("CALIBRI", Font.BOLD, 20));
		btnStart.setBounds(246, 424, 100, 30);
		btnStart.setBackground(SystemColor.activeCaptionBorder);
		btnStart.setForeground(Color.WHITE);
		getContentPane().add(btnStart); // add button to frame

		// create and display colour chooser button
		JButton btnColor = new JButton("Colour");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// if user clicks colour button
				// open colour chooser menu
				Color backgroundColor = JColorChooser.showDialog(null, "Choose background Colour", Color.black);
				getContentPane().setBackground(backgroundColor);// change background colour to user input
			}
		});
		btnColor.setBackground(Color.WHITE);
		btnColor.setBounds(10, 11, 89, 23);
		getContentPane().add(btnColor); // add to frame

		// create rules frame
		getContentPane().setBackground(SystemColor.info);
		setBounds(300, 100, 500, 500);
		getContentPane().setLayout(null);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Rules(""); // open rules frame
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) { // if user clicks "Back' button
			new SafeCracker(); // open a new instance of the login frame
			setVisible(false); // get rid of rules frame
		}
	}
}