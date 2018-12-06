import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;	

public class FatCoefficient extends JFrame implements ActionListener{
	  private JTextField jtfWeight = new JTextField(10);
	  private JTextField jtfHeight = new JTextField(10);
	  private JTextField jtfCofficient = new JTextField(20);
	  private JTextField jtfResult = new JTextField(20);
	  private JButton jbCompute = new JButton("Compute");
	  
	  public static void main(String[ ] args) {
		  FatCoefficient frame = new FatCoefficient( );
		    frame.pack();
		    frame.setTitle("Fat Coefficient");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		  }
	  
	  public FatCoefficient( ) {
		    // Panel p1 to hold labels and text fields
		    JPanel p1 = new JPanel( );
		    p1.setLayout(new GridLayout(4, 2));
		    p1.add(new JLabel("Weight (kg)"));
		    p1.add(jtfWeight);
		    p1.add(new JLabel("Height (m)"));
		    p1.add(jtfHeight);
		    p1.add(new JLabel("Coefficient, good if 15 to 25"));
		    p1.add(jtfCofficient);					
		    jtfCofficient.setEditable(false);
		    p1.add(new JLabel("Result"));						
		    p1.add(jtfResult);
		    jtfResult.setEditable(false);					

		    // Add p1 to the frame
		    this.getContentPane().setLayout(new BorderLayout());
		    this.getContentPane().add(p1,BorderLayout.CENTER);
		    this.getContentPane().add(jbCompute,BorderLayout.SOUTH);

		    // Register listener
		    jbCompute.addActionListener(this);				
		  }
	  
	public void actionPerformed(ActionEvent e) {
		double height = Double.parseDouble(jtfHeight.getText());
		double weight = Double.parseDouble(jtfWeight.getText());
		 NumberFormat nf = NumberFormat.getInstance();
		 nf.setMaximumFractionDigits(18);
		    if (e.getSource() == jbCompute) {
		    double Cofficient = (weight / (height * height));
		    jtfCofficient.setText(nf.format(Cofficient));
		    if (Cofficient > 25){
		    	jtfResult.setText("Too Fat, need to keep fit!");
		    }else if(Cofficient < 15){
		    	jtfResult.setText("Too Thin, need to keep fat!");
		    }else {
		    	jtfResult.setText("Just fit, keep on!");
		    }
		    }
	}
}