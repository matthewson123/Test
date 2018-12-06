import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;	

public class LDLCholesterol extends JFrame implements ActionListener{
	  private JTextField jtfTC = new JTextField(10);
	  private JTextField jtfHDLC = new JTextField(10);
	  private JTextField jtfTG = new JTextField(10);
	  private JTextField jtfLDLC = new JTextField(20);
	  private JButton jbCalculate = new JButton("Calculate");
	  
	  public static void main(String[ ] args) {
		LDLCholesterol frame = new LDLCholesterol( );
		    frame.pack();
		    frame.setTitle("LDL Cholesterol");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		  }
	  
	  public LDLCholesterol( ) {
		    // Panel p1 to hold labels and text fields
		    JPanel p1 = new JPanel( );
		    p1.setLayout(new GridLayout(4, 2));
		    p1.add(new JLabel("Total Cholesterol"));
		    p1.add(jtfTC);
		    p1.add(new JLabel("HDL cholesterol"));
		    p1.add(jtfHDLC);
		    p1.add(new JLabel("triglyceride"));
		    p1.add(jtfTG);					
		    jtfLDLC.setEditable(false);
		    p1.add(new JLabel("LDL cholesterol"));						
		    p1.add(jtfLDLC);
		    jtfLDLC.setEditable(false);					

		    // Add p1 to the frame
		    this.getContentPane().setLayout(new BorderLayout());
		    this.getContentPane().add(p1,BorderLayout.CENTER);
		    this.getContentPane().add(jbCalculate,BorderLayout.SOUTH);

		    // Register listener
		    jbCalculate.addActionListener(this);				
		  }
	  
	public void actionPerformed(ActionEvent e) {
		double tc = Double.parseDouble(jtfTC.getText());
        double hdlc = Double.parseDouble(jtfHDLC.getText());
        double tg = Double.parseDouble(jtfTG.getText());
		 NumberFormat nf = NumberFormat.getInstance();
		 nf.setMaximumFractionDigits(18);
		    if (e.getSource() == jbCalculate) {
		    double LDLCholesterol = (tc - hdlc - tg/5);
		    jtfLDLC.setText(nf.format(LDLCholesterol));
		    }
	}
}