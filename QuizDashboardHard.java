
//import
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class QuizDashboardHard extends JFrame implements ActionListener {

	// declare variables
	JButton lifeline, next, submit;
	JLabel questionNumber, question;
	JCheckBox opt1, opt2, opt3, opt4;
	ButtonGroup options;

	// initialize
	static int timer = 20;
	static int count = 0;
	static int ans_given = 0;
	static int score = 0;

	// private variables
	private JProgressBar progressBar;
	private int number = 0;

	// 2d array
	String q[][] = new String[10][5];
	String pa[][] = new String[10][1];
	String qa[][] = new String[10][2];

	QuizDashboardHard() {

		super("Hard Mode!");

		// create label for question number
		questionNumber = new JLabel("1. ");
		questionNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		questionNumber.setBounds(31, 250, 40, 30);
		getContentPane().add(questionNumber);

		// placeholder question
		question = new JLabel("What is Your Name?");
		question.setFont(new Font("Tahoma", Font.PLAIN, 18));
		question.setBounds(60, 250, 600, 30);
		getContentPane().add(question);

		// question 1 and its options
		q[0][0] = "What was the first country to give women the right to vote?";
		q[0][1] = "Canada";
		q[0][2] = "New Zealand";
		q[0][3] = "Finland";
		q[0][4] = "Japan";

		// question 2 and its options
		q[1][0] = "Who was the first human to journey into space?";
		q[1][1] = "Alan Shepard";
		q[1][2] = "Neil Armstrong";
		q[1][3] = "Yuri Gagarin";
		q[1][4] = "John Herschel Glenn";

		// question 3 and its options
		q[2][0] = "Mount Kilimanjaro is located in which country?";
		q[2][1] = "Tanzania";
		q[2][2] = "Germany";
		q[2][3] = "Tunsia";
		q[2][4] = "Ireland";

		// question 4 and its options
		q[3][0] = "An interface with no fields or methods is known as?";
		q[3][1] = "Runnable Interface";
		q[3][2] = "Abstract Interface";
		q[3][3] = "Marker Interface";
		q[3][4] = "CharSequence Interface";

		// question 5 and its options
		q[4][0] = "Who was the first to suggest that Daylight Savings Time be implemented?";
		q[4][1] = "Marquis de Lafayette";
		q[4][2] = "Patrick Henry";
		q[4][3] = "Thomas Jefferson";
		q[4][4] = "Benjamin Franklin";

		// question 6 and its options
		q[5][0] = "How many bones are there in the human skeleton?";
		q[5][1] = "216";
		q[5][2] = "206";
		q[5][3] = "208";
		q[5][4] = "204";

		// question 7 and its options
		q[6][0] = "How many keys are there on a standard piano?";
		q[6][1] = "88";
		q[6][2] = "90";
		q[6][3] = "85";
		q[6][4] = "78";

		// question 8 and its options
		q[7][0] = "In java, jar stands for?";
		q[7][1] = "Java Archive Runner";
		q[7][2] = "Java Archive";
		q[7][3] = "Java Application Resource";
		q[7][4] = "Java Application Runner";

		// question 9 and its options
		q[8][0] = "What is the world’s largest city by population?";
		q[8][1] = "Tokyo";
		q[8][2] = "Mexico City";
		q[8][3] = "Delhi";
		q[8][4] = "Shanghai";

		// question 10 and its options
		q[9][0] = "Which country has the largest landmass?";
		q[9][1] = "Russia";
		q[9][2] = "Canada";
		q[9][3] = "USA";
		q[9][4] = "Australia";

		// answers
		qa[0][1] = "New Zealand";
		qa[1][1] = "Yuri Gagarin";
		qa[2][1] = "Tanzania";
		qa[3][1] = "Marker Interface";
		qa[4][1] = "Benjamin Franklin";
		qa[5][1] = "206";
		qa[6][1] = "88";
		qa[7][1] = "Java Archive";
		qa[8][1] = "Tokyo";
		qa[9][1] = "Russia";

		// create and display option 1
		opt1 = new JCheckBox("Option 1");
		opt1.setBounds(60, 300, 300, 30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt1);

		// create and display option 2
		opt2 = new JCheckBox("Option 2");
		opt2.setBounds(60, 340, 300, 30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt2);

		// create and display option 3
		opt3 = new JCheckBox("Option 3");
		opt3.setBounds(60, 380, 300, 30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt3);

		// create and display option 4
		opt4 = new JCheckBox("Option 4");
		opt4.setBounds(60, 420, 300, 30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt4);

		// add options to a group
		options = new ButtonGroup();
		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);

		// create and display next question button
		next = new JButton("Next");
		next.setBounds(60, 500, 100, 30);
		next.setBackground(SystemColor.controlShadow);
		next.setFont(new Font("Calibri", Font.BOLD, 16));
		next.addActionListener(this);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // if next button is pressed
				progressBar.setValue(number); // set value of progress bar
			}
		});
		getContentPane().add(next);//add to frame

		// create and display submit button
		submit = new JButton("Submit");
		submit.setBounds(550, 500, 100, 30);
		submit.setBackground(SystemColor.inactiveCaption);
		submit.setFont(new Font("Calibri", Font.BOLD, 16));
		submit.setForeground(new Color(144, 12, 63));
		submit.setEnabled(false);
		submit.addActionListener(this);
		getContentPane().add(submit);

		// create and display "hard" frame
		getContentPane().setBackground(Color.WHITE);
		setBounds(200, 50, 700, 600);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		start(0);

		// create and display label
		JLabel lblNewLabel = new JLabel(" Progress");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(310, 141, 100, 34);
		this.getContentPane().add(lblNewLabel);

		// create and display label
		JLabel lblEasyMode = new JLabel("    Hard Mode");
		lblEasyMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblEasyMode.setBounds(318, 200, 68, 11);
		this.getContentPane().add(lblEasyMode);

		// create and display progress bar
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		progressBar.setBounds(272, 176, 160, 35);
		getContentPane().add(progressBar);// add to frame
		progressBar.setVisible(true); // make progress bar visible
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) {// if user clicks next
			int response = JOptionPane.showConfirmDialog(null, "Confirm"); // show option panel for confirmation

			if (response == 0) { // if the user inputs yes
				number = number + 10; // increase progress bar value by 10
				progressBar.setValue(number); // set progress bar value
				ans_given = 1;

				// show options
				opt1.setEnabled(true);
				opt2.setEnabled(true);
				opt3.setEnabled(true);
				opt4.setEnabled(true);
				repaint();

				if (options.getSelection() == null) { // if user didn't pick an option
					pa[count][0] = "";
				} else {
					pa[count][0] = options.getSelection().getActionCommand(); // get selected option
				}
				if (count == 8) { // when count reaches final question
					// show the submit button and get rid of next button
					next.setEnabled(false);
					submit.setEnabled(true);
				}
				count++;
				start(count); // do start method

			} else if (response == 2) { // if user inputs cancel
				options.clearSelection();// clears the radio button selection if user clicks cancel
			}
		} else if (e.getSource() == submit) { // if user clicks submit button
			ans_given = 1;
			if (options.getSelection() == null) { // if user didn't select an option for last question
				pa[count][0] = "";
			} else {
				pa[count][0] = options.getSelection().getActionCommand(); // get selected option
			}
			// check and calculate score
			for (int i = 0; i < pa.length; i++) {
				if (pa[i][0].equals(qa[i][1])) {
					score += 10; // if user gets question right, increase score by 10
				} else {
					score += 0;// if user gets question wrong, increase score by 0
				}
			}
			setVisible(false); // get rid of "hard" frame
			new ScoreDashboard(score); // open scoreboard frame
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// create and display timer text
		String time = "Time Left - " + timer;
		g.setColor(new Color(0, 0, 255));
		g.setFont(new Font("Calibri", Font.BOLD, 18));

		// when timer reaches 0 display time up message
		if (timer > 0) {
			g.drawString(time, 560, 480);
		} else {
			g.drawString("Time Up", 560, 480);
		}
		timer--;
		try {
			Thread.sleep(1000);// wait one second
			repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (ans_given == 1) {
			ans_given = 0;
			timer = 20; // set timer to 20 seconds
		} else if (timer < 0) { // if timer runs out
			timer = 20;// set timer to 20 seconds
			number = number + 10; // increase progress bar value by 10
			progressBar.setValue(number);// set progress bar value
			// show options for next question
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);

			if (count == 8) { // when user reaches last question
				next.setEnabled(false);// disable next button
				submit.setEnabled(true); // show submit button
			}

			if (count == 9) {
				if (options.getSelection() == null) { // if user doesn't select an option
					pa[count][0] = "";
				} else {
					pa[count][0] = options.getSelection().getActionCommand(); // get selected option
				}

				// check and calculate score
				for (int i = 0; i < pa.length; i++) {
					if (pa[i][0].equals(qa[i][1])) {
						score += 10; // if user gets question right, increase score by 10
					} else {
						score += 0;// if user gets question wrong, increase score by 0
					}
				}

				setVisible(false); // get rid of "hard" frame
				new ScoreDashboard(score); // open scoreboard frame
			} else {
				if (options.getSelection() == null) {// if user doesn't select an option
					pa[count][0] = "";
				} else {
					pa[count][0] = options.getSelection().getActionCommand();// get selected option
				}
				count++;
				start(count); // do start method
			}
		}
	}

	public void start(int count) {
		questionNumber.setText("" + (count + 1) + "."); // increase question number by 1
		question.setText(q[count][0]); // display question
		// display options
		opt1.setText(q[count][1]);
		opt1.setActionCommand(q[count][1]);
		opt2.setText(q[count][2]);
		opt2.setActionCommand(q[count][2]);
		opt3.setText(q[count][3]);
		opt3.setActionCommand(q[count][3]);
		opt4.setText(q[count][4]);
		opt4.setActionCommand(q[count][4]);
		options.clearSelection(); // clear option selections
	}

	public static void main(String[] args) {
		new QuizDashboardHard();// open "hard" frame
	}

}