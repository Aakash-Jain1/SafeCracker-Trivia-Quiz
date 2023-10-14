
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
import javax.swing.JRadioButton;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class QuizDashboard extends JFrame implements ActionListener {

	// declare variables
	JButton hint, next, submit;
	JLabel questionNumber, question;
	JRadioButton opt1, opt2, opt3, opt4;
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

	QuizDashboard() {

		super("Easy Mode!");

		// create label for question number
		questionNumber = new JLabel("1. ");
		questionNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		questionNumber.setBounds(27, 250, 40, 30);
		getContentPane().add(questionNumber);

		// placeholder question
		question = new JLabel("What is Your Name?");
		question.setFont(new Font("Tahoma", Font.PLAIN, 18));
		question.setBounds(60, 250, 600, 30);
		getContentPane().add(question);

		// question 1 and its options
		q[0][0] = "Who discovered the special theory of relativity?";
		q[0][1] = "Thomas Edison";
		q[0][2] = "Albert Einstein";
		q[0][3] = "Isaac Newton";
		q[0][4] = "Niels Bhor";

		// question 2 and its options
		q[1][0] = "What is the Capital of Canada";
		q[1][1] = "Toronto";
		q[1][2] = "Ottawa";
		q[1][3] = "Montreal";
		q[1][4] = "Vancouver";

		// question 3 and its options
		q[2][0] = "How many states are in the United States";
		q[2][1] = "50";
		q[2][2] = "54";
		q[2][3] = "55";
		q[2][4] = "51";

		// question 4 and its options
		q[3][0] = "How long is an Olympic swimming pool (in meters)?";
		q[3][1] = "150";
		q[3][2] = "100";
		q[3][3] = "50";
		q[3][4] = "200";

		// question 5 and its options
		q[4][0] = "What is the joule a unit of?";
		q[4][1] = "Mass";
		q[4][2] = "Force";
		q[4][3] = "Momentum";
		q[4][4] = "Energy";

		// question 6 and its options
		q[5][0] = "How many wisdom teeth does the average adult have?";
		q[5][1] = "Two";
		q[5][2] = "Four";
		q[5][3] = "Six";
		q[5][4] = "One";

		// question 7 and its options
		q[6][0] = "In which language does konnichiwa mean hello?";
		q[6][1] = "Japanese";
		q[6][2] = "Mandarin Chinese";
		q[6][3] = "Spanish";
		q[6][4] = "French";

		// question 8 and its options
		q[7][0] = "How many oceans are there on Earth?";
		q[7][1] = "Four";
		q[7][2] = "Five";
		q[7][3] = "Seven";
		q[7][4] = "Three";

		// question 9 and its options
		q[8][0] = "In what sport could you win a Heisman trophy?";
		q[8][1] = "American Football";
		q[8][2] = "Ice Hockey";
		q[8][3] = "Basketball";
		q[8][4] = "Tennis";

		// question 10 and its options
		q[9][0] = "What is the chemical symbol for potassium?";
		q[9][1] = "K";
		q[9][2] = "P";
		q[9][3] = "Pt";
		q[9][4] = "Pa";

		// answers
		qa[0][1] = "Albert Einstein";
		qa[1][1] = "Ottawa";
		qa[2][1] = "50";
		qa[3][1] = "50";
		qa[4][1] = "Energy";
		qa[5][1] = "Four";
		qa[6][1] = "Japanese";
		qa[7][1] = "Five";
		qa[8][1] = "American Football";
		qa[9][1] = "K";

		// create and display option 1
		opt1 = new JRadioButton("Option 1");
		opt1.setBounds(60, 300, 300, 30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt1);

		// create and display option 2
		opt2 = new JRadioButton("Option 2");
		opt2.setBounds(60, 340, 300, 30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt2);

		// create and display option 3
		opt3 = new JRadioButton("Option 3");
		opt3.setBounds(60, 380, 300, 30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(opt3);

		// create and display option 4
		opt4 = new JRadioButton("Option 4");
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

		// create and display hint button
		hint = new JButton("50%-50%");
		hint.setBounds(60, 500, 100, 30);
		hint.setBackground(Color.LIGHT_GRAY);
		hint.setFont(new Font("Calibri", Font.BOLD, 16));
		hint.addActionListener(this);
		getContentPane().add(hint);

		// create and display next question button
		next = new JButton("Next");
		next.setBounds(180, 500, 100, 30);
		next.setBackground(Color.LIGHT_GRAY);
		next.setFont(new Font("Calibri", Font.BOLD, 16));
		next.addActionListener(this);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // if next button is pressed
				progressBar.setValue(number); // set value of progress bar

			}
		});
		getContentPane().add(next);// add to frame

		// create and display submit button
		submit = new JButton("Submit");
		submit.setBounds(550, 500, 100, 30);
		submit.setBackground(SystemColor.inactiveCaption);
		submit.setFont(new Font("Calibri", Font.BOLD, 16));
		submit.setForeground(new Color(144, 12, 63));
		submit.setEnabled(false);
		submit.addActionListener(this);
		getContentPane().add(submit);

		// create and display "easy" frame
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
		JLabel lblEasyMode = new JLabel("    Easy Mode");
		lblEasyMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblEasyMode.setBounds(318, 200, 68, 11);
		this.getContentPane().add(lblEasyMode);

		// create and display progress bar
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		progressBar.setBounds(272, 176, 160, 35);
		getContentPane().add(progressBar);// add to frame
		progressBar.setVisible(true);// make progress bar visible

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == next) {// if user clicks next
			int response = JOptionPane.showConfirmDialog(null, "Confirm");// show option panel for confirmation

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
					pa[count][0] = options.getSelection().getActionCommand();// get selected option

				}
				if (count == 8) {// when count reaches final question
					// show the submit button and get rid of next button
					next.setEnabled(false);
					submit.setEnabled(true);
				}
				count++;
				start(count);// do start method

			} else if (response == 2) {// if user inputs cancel
				options.clearSelection();// clears the radio button selection if user clicks cancel
			}
		} else if (e.getSource() == hint) {// if user uses the 50-50 lifeline hint
			if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {// for these questions
				// disable options 2 and 3
				opt2.setEnabled(false);
				opt3.setEnabled(false);
			} else {
				// for every other question disable questions 1 and 4
				opt1.setEnabled(false);
				opt4.setEnabled(false);
			}
			hint.setEnabled(false); // disable hint after one use
		} else if (e.getSource() == submit) { // if user clicks submit button
			ans_given = 1;
			if (options.getSelection() == null) {// if user didn't select an option for last question
				pa[count][0] = "";
			} else {
				pa[count][0] = options.getSelection().getActionCommand();// get selected option
			}

			// check and calculate score
			for (int i = 0; i < pa.length; i++) {
				if (pa[i][0].equals(qa[i][1])) {
					score += 10;// if user gets question right, increase score by 10
				} else {
					score += 0;// if user gets question wrong, increase score by 0
				}
			}
			setVisible(false);// get rid of "hard" frame
			new ScoreDashboard(score);// open scoreboard frame
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
			timer = 20;// set timer to 20 seconds
		} else if (timer < 0) {// if timer runs out
			timer = 20;// set timer to 20 seconds
			number = number + 10;// increase progress bar value by 10
			progressBar.setValue(number);// set progress bar value
			// show options for next question
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);

			if (count == 8) {// when user reaches last question
				next.setEnabled(false);// disable next button
				submit.setEnabled(true);// show submit button
			}

			if (count == 9) {
				if (options.getSelection() == null) {// if user doesn't select an option
					pa[count][0] = "";
				} else {
					pa[count][0] = options.getSelection().getActionCommand();// get selected option
				}

				// check and calculate score
				for (int i = 0; i < pa.length; i++) {
					if (pa[i][0].equals(qa[i][1])) {
						score += 10;// if user gets question right, increase score by 10
					} else {
						score += 0;// if user gets question wrong, increase score by 0
					}
				}

				setVisible(false); // get rid of "easy" frame
				new ScoreDashboard(score);// open scoreboard frame
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
		questionNumber.setText("" + (count + 1) + ".");// increase question number by 1
		question.setText(q[count][0]);// display question
		// display options
		opt1.setText(q[count][1]);
		opt1.setActionCommand(q[count][1]);
		opt2.setText(q[count][2]);
		opt2.setActionCommand(q[count][2]);
		opt3.setText(q[count][3]);
		opt3.setActionCommand(q[count][3]);
		opt4.setText(q[count][4]);
		opt4.setActionCommand(q[count][4]);
		options.clearSelection();// clear option selections
	}

	public static void main(String[] args) {
		new QuizDashboard();// open "easy" frame
	}
}