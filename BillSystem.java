import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BillSystem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lblNewLabel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillSystem frame = new BillSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BillSystem() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Bill System");
		lblNewLabel_3.setForeground(new Color(255, 0, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 35));//Times New Roman
		lblNewLabel_3.setBounds(118, 11, 263, 83);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Enter Your Bill units");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(23, 105, 165, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(23, 138, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				String text=;
				String conversionResult="";
				 int units = Integer.parseInt(textField.getText());
				double bill;
				int unit;
				double bil;
				double GST=0;
				double FPA=0;
				int tempUnits=units;
				if(units<100) {
					bill=units*9.6;
				}
				else {
					unit=units-100;
					//unit humare wo hain jin ka rate humara 9.6 se ziada matlb k 100 se ziada jitne bhi hain
					units=units-unit;
					//units humare 100 hain
					bil=unit*12.00;
					//100 se ziada walon ka bill, bil hy
					bill=(units*9.6);
					bill=bill+bil;
				}
				GST=(bill/100)*8;
				FPA=tempUnits*5;
				conversionResult = "<html><p>Electricity units consumed : " + (tempUnits) + "</p><br />";
				conversionResult += "<p>Electricity bill according to units consumed " + (bill) + "</p><br />";
				conversionResult += "<p>GST according to units consumed : " + (GST) + "</p><br />";
				conversionResult += "<p>FPA according to units consumed  : " + (FPA) + "</p><br />";
				conversionResult += "<p>Total Electricity bill you have to pay :" + (bill+FPA+GST) + "</p></html>";
				lblNewLabel_2.setText(conversionResult);
//				lblNewLabel_2.setText("Hello");
			   }
			
			
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setBounds(23, 169, 94, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2.setText(null);
				textField.setText(null);
			}
		});
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setForeground(new Color(25, 25, 112));
		btnNewButton_1.setBounds(129, 169, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Results");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(183, 214, 94, 22);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBackground(new Color(240, 230, 140));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(31, 247, 393, 343);
		contentPane.add(lblNewLabel_2);
	}
}