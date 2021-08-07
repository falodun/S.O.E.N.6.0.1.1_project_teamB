package testCases;
import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Test;

import Controller.CalculationForFunction7;

public class TestCasesForFunction7 {

	@Test
	public void testUpdateData(){
		
		String displayText = "";
		
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(displayText);
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		calculationForFunction7.updateData(jFrame);
		
		assertEquals("Select Base Value first", textFieldResult.getText());
	
	}

	@Test
	public void testFindResultForEmptyInput(){
	
		String displayText = "";
		
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(displayText);
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		
		assertEquals("ERROR: Input value is empty", calculationForFunction7.findResult(jFrame));
	}
	
	@Test
	public void testFindResultForZeroPower(){

		String displayText = "0.0^0.0";
		double baseValue = 0.0;
		double powerValue = 0.0;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		//result calculated with up to 5 decimal places
		assertEquals("1.0", calculationForFunction7.findResult(jFrame).toString() );
	}
	
	@Test
	public void testFindResultForDifferentSyntaxFunction(){

		String displayText = "2.0*3.2";
		double baseValue = 2.0;
		double powerValue = -3.2;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		//result calculated with up to 5 decimal places
		assertEquals("ERROR: This is not of the format: x^y", calculationForFunction7.findResult(jFrame).toString() );
	}
	
	
	@Test
	public void testFindResultForNegativeBaseAndFractionPower(){
		
		String displayText = "-2.0^3.4";
		double baseValue = -2.0;
		double powerValue = 3.4;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		assertEquals("Error: Negative base can not have non-integer powers", calculationForFunction7.findResult(jFrame).toString() );
	}

	@Test
	public void testFindResultForPositivePower(){

		String displayText = "-2.0^3.0";
		double baseValue = -2.0;
		double powerValue = 3.0;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		assertEquals("-8.0", calculationForFunction7.findResult(jFrame).toString() );
	}
	
	@Test
	public void testFindResultForNegativePower(){

		String displayText = "2.0^-3.0";
		double baseValue = 2.0;
		double powerValue = -3.0;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		assertEquals("0.125", calculationForFunction7.findResult(jFrame).toString() );
	}
	
	@Test
	public void testFindResultForFractionPositivePower(){

		String displayText = "2.0^3.2";
		double baseValue = 2.0;
		double powerValue = 3.2;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		//result calculated with up to 5 decimal places
		assertEquals("9.18959", calculationForFunction7.findResult(jFrame).toString() );
	}
	
	@Test
	public void testFindResultForFractionNegativePower(){

		String displayText = "2.0^-3.2";
		double baseValue = 2.0;
		double powerValue = -3.2;
			
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel("Scientific Calculator");
		JTextField textFieldResult = new JTextField();
		
		jFrame.getContentPane().add(textFieldResult);
		textFieldResult.setText(String.valueOf(baseValue));
		
		jFrame.getContentPane().add(jLabel);
		jFrame.getContentPane().add(textFieldResult);
		
		CalculationForFunction7 calculationForFunction7 = new CalculationForFunction7();
		
		Boolean isXUpdated = false;
		
		calculationForFunction7.updateData(jFrame);
		
		isXUpdated = true;
		textFieldResult.setText(String.valueOf(powerValue));
		calculationForFunction7.updateData(jFrame);
		
		textFieldResult.setText(displayText);
		
		//result calculated with up to 5 decimal places
		assertEquals("0.10882", calculationForFunction7.findResult(jFrame).toString() );
	}

}

