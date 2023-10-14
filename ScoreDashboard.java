
//import
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class ScoreDashboard extends JFrame implements ActionListener {

	// declare
	JButton playAgain;

	public ScoreDashboard(int score) throws HeadlessException {

		if (score <= 50) {// if user loses
			// create and display losing message
			JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance()
					.createLabel("You Couldn't Crack the Safe.");
			lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewJgoodiesLabel.setForeground(Color.RED);
			lblNewJgoodiesLabel.setBounds(220, 105, 239, 64);
			getContentPane().add(lblNewJgoodiesLabel);
		} else {// if user wins
				// create and display winning message
			JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("You Cracked the Safe!");
			lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewJgoodiesLabel.setForeground(Color.GREEN);
			lblNewJgoodiesLabel.setBounds(235, 105, 190, 64);
			getContentPane().add(lblNewJgoodiesLabel);
		}

		// create and display thank you message
		JLabel l2 = new JLabel("Thank You For Playing!");
		l2.setBounds(220, 180, 239, 50);
		l2.setForeground(new Color(144, 12, 63));
		l2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		getContentPane().add(l2);

		// create and display play again button
		playAgain = new JButton("Play Again");
		playAgain.setBounds(361, 382, 150, 40);
		playAgain.setBackground(new Color(249, 199, 38));
		playAgain.setFont(new Font("CALIBRI", Font.BOLD, 16));
		playAgain.setForeground(Color.BLACK);
		playAgain.addActionListener(this);
		getContentPane().add(playAgain);

		// create and display label for the score
		JLabel l3 = new JLabel(Integer.toString(score) + "%"); // get score and put into label
		l3.setBounds(280, 250, 400, 100);
		l3.setForeground(SystemColor.activeCaption);
		l3.setFont(new Font("Javanese Text", Font.BOLD, 70));
		getContentPane().add(l3);

		// create and display quit button
		JButton btnQuit = new JButton("Quit");
		btnQuit.setForeground(Color.WHITE);
		btnQuit.setBackground(Color.RED);
		btnQuit.setBounds(169, 382, 150, 39);
		getContentPane().add(btnQuit); // add to frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // if user clicks quit button
				System.exit(0); // exit the program
			}
		});
		btnQuit.setVisible(true);

		// create scoreboard frame
		getContentPane().setBackground(SystemColor.info);
		getContentPane().setLayout(null);
		setBounds(200, 100, 700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ScoreDashboard(0); // open scoreboard frame
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playAgain) { // if user clicks play again button
			new SafeCracker().setVisible(true); // open new instance of login page
			setVisible(false); // get rid of scoreboard frame
		}
	}
}