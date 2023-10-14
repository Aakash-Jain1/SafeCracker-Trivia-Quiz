/*
 * Author: Aakash Jain
 * Date: January 20th, 2023
 * Purpose: SafeCracker is a quiz game.
 */
//import
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;

@SuppressWarnings("serial") // get rid of warnings
public class SafeCracker extends JFrame implements ActionListener {

	// declare constants
	JButton btn;
	JPasswordField textf;

	SafeCracker() {
		super("SafeCracker"); // super is named "SafeCracker"

		// create login frame
		getContentPane().setLayout(null);
		setBounds(300, 150, 500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(SystemColor.info);

		// create a new title and display it as "SafeCracker"
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("SafeCracker");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24)); // set the font
		lblNewJgoodiesTitle.setBounds(182, 37, 133, 60); // set label bounds
		getContentPane().add(lblNewJgoodiesTitle); // add label to the frame

		// create a title and display it as "Enter Any Name"
		JLabel l2 = new JLabel("(Enter Any Name)");
		l2.setBounds(210, 156, 118, 13); // set label bounds
		l2.setFont(new Font("Calibri", Font.BOLD, 10)); // set label font
		getContentPane().add(l2); // add to frame

		// create a password field
		textf = new JPasswordField();
		textf.setBounds(128, 132, 236, 25);
		getContentPane().add(textf); // add it to the frame

		// create and display play button
		btn = new JButton("Play!");
		btn.setBounds(264, 180, 100, 30);
		btn.setBackground(Color.GREEN);
		btn.setForeground(Color.white);
		btn.addActionListener(this);
		getContentPane().add(btn); // add to frame

		// create and display quit button
		JButton btnQuit = new JButton("Quit");
		btnQuit.setForeground(Color.WHITE); // set text colour of button to white
		btnQuit.setBackground(Color.RED); // set button to red colour
		btnQuit.setBounds(128, 180, 100, 30);// set bounds
		getContentPane().add(btnQuit); // add button to frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnQuit.addActionListener(new ActionListener() { // if user clicks quit button
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exit the program
			}
		});
		setVisible(true);

		// create a title and display it as "Admin AccessKey"
		JLabel l2_1 = new JLabel("Admin AccessKey:");
		l2_1.setFont(new Font("Calibri", Font.BOLD, 16)); // set font
		l2_1.setBounds(182, 111, 138, 25); // set label bounds
		getContentPane().add(l2_1); // add to frame

		// create and display colour chooser button
		JButton btnColor = new JButton("Colour");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // if user clicks colour button
				// open colour chooser menu
				Color backgroundColor = JColorChooser.showDialog(null, "Choose background Colour", Color.black);
				getContentPane().setBackground(backgroundColor); // change background colour to user input
			}
		});
		btnColor.setBackground(Color.WHITE); // set button colour to white
		btnColor.setBounds(389, 11, 89, 23); // set button bounds
		getContentPane().add(btnColor); // add button to frame
	}

	@SuppressWarnings("deprecation") // get rid of the warnings
	@Override
	public void actionPerformed(ActionEvent e) { // if user clicks button
		if (e.getSource() == btn) { // if user clicks play button
			if ("".equals(textf.getText())) { // if user doesn't put in a String in the password field
				JOptionPane.showMessageDialog(null, "Please Enter Username"); // show popup message
			} else {
				String username = textf.getText(); // get user input from password field
				new Rules(username).setVisible(true); // open the rules frame
				setVisible(false); // close menu/starting frame
			}
		}
	}

	public static void main(String[] args) {
		new SafeCracker();// open SafeCracker
	}
}