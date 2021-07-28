import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ScientificCalculator {

	private JFrame frame;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScientificCalculator window = new ScientificCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScientificCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SCIENTIFIC CALCULATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 467, 32);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldResult = new JTextField();
		textFieldResult.setBounds(10, 43, 467, 68);
		frame.getContentPane().add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JButton btnOn = new JButton("ON");
		btnOn.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnOn.setBounds(20, 146, 80, 62);
		frame.getContentPane().add(btnOn);
		
		JButton btnNine = new JButton("9");
		btnNine.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNine.setBounds(200, 365, 80, 62);
		frame.getContentPane().add(btnNine);
		
		JButton btnFour = new JButton("4");
		btnFour.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnFour.setBounds(20, 292, 80, 62);
		frame.getContentPane().add(btnFour);
		
		JButton btnSix = new JButton("6");
		btnSix.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSix.setBounds(200, 292, 80, 62);
		frame.getContentPane().add(btnSix);
		
		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnClear.setBounds(110, 146, 80, 62);
		frame.getContentPane().add(btnClear);
		
		JButton btnZero = new JButton("0");
		btnZero.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnZero.setBounds(20, 463, 80, 62);
		frame.getContentPane().add(btnZero);
		
		JButton btnOne = new JButton("1");
		btnOne.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnOne.setBounds(20, 219, 80, 62);
		frame.getContentPane().add(btnOne);
		
		JButton btnFive = new JButton("5");
		btnFive.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnFive.setBounds(110, 292, 80, 62);
		frame.getContentPane().add(btnFive);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnEqual.setBounds(110, 463, 170, 62);
		frame.getContentPane().add(btnEqual);
		
		JButton btnThree = new JButton("3");
		btnThree.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnThree.setBounds(200, 219, 80, 62);
		frame.getContentPane().add(btnThree);
		
		JButton btnTwo = new JButton("2");
		btnTwo.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnTwo.setBounds(110, 219, 80, 62);
		frame.getContentPane().add(btnTwo);
		
		JButton btnBackSpace = new JButton("DEL");
		btnBackSpace.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnBackSpace.setBounds(200, 146, 80, 62);
		frame.getContentPane().add(btnBackSpace);
		
		JButton btnFunction1 = new JButton("F1");
		btnFunction1.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnFunction1.setBounds(359, 146, 100, 62);
		frame.getContentPane().add(btnFunction1);
		
		JButton btnFunction2 = new JButton("F2");
		btnFunction2.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnFunction2.setBounds(359, 219, 100, 62);
		frame.getContentPane().add(btnFunction2);
		
		JButton btnFunction3 = new JButton("F3");
		btnFunction3.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnFunction3.setBounds(359, 289, 100, 62);
		frame.getContentPane().add(btnFunction3);
		
		JButton btnFunction4 = new JButton("x^y");
		btnFunction4.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnFunction4.setBounds(359, 362, 100, 62);
		frame.getContentPane().add(btnFunction4);
		
		JButton btnEight = new JButton("8");
		btnEight.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnEight.setBounds(110, 365, 80, 62);
		frame.getContentPane().add(btnEight);
		
		JButton btnSeven = new JButton("7");
		btnSeven.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSeven.setBounds(20, 365, 80, 62);
		frame.getContentPane().add(btnSeven);
	}
}
