package currencyconverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CurrencyConverterMain extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JLabel firstCurrUnit;
	private JLabel secCurrUnit;

	private String[] currencyunits = { "units", "Us Dollar", "Nigerain Naira", "Brazilian Real", "Canadain Dollar",
			"Kenyan Shilling", "Indonesian Rupiah", "Indian Rupee", "Philippine Pisco", "Pakistani Rupee" };

	double US_Dollar = 1.31;
	double Nigerian_Naira = 476.57;
	double Brazilian_Real = 5.47;
	double Canadian_Dollar = 1.71;
	double Kenyan_Shilling = 132.53;
	double Indonesian_Rupiah = 19554.94;
	double Indian_Rupee = 95.21;
	double Phillippine_Pisco = 71.17;
	double Pakistani_Rupee = 162.74;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverterMain frame = new CurrencyConverterMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrencyConverterMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CURRENCY CONVERTER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(267, 21, 192, 14);
		contentPane.add(lblNewLabel);

		JComboBox firstcoun = new JComboBox();
		firstcoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int pos = firstcoun.getSelectedIndex();

				firstCurrUnit.setText(currencyunits[pos]);

			}
		});
		firstcoun.setModel(new DefaultComboBoxModel(new String[] { "Choose One..", "USA", "Nigeria", "Brazil", "Canada",
				"Kenyan", "Indonesia", "India", "Philippine", "Pakistan" }));
		firstcoun.setBounds(91, 103, 133, 30);
		contentPane.add(firstcoun);

		JComboBox secondcoun = new JComboBox();
		secondcoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				int pos = secondcoun.getSelectedIndex();

				secCurrUnit.setText(currencyunits[pos]);

			}
		});
		secondcoun.setModel(new DefaultComboBoxModel(new String[] { "Choose One..", "USA", "Nigeria", "Brazil",
				"Canada", "Kenyan", "Indonesia", "India", "Philippine", "Pakistan", "Canada" }));
		secondcoun.setBounds(477, 103, 133, 30);
		contentPane.add(secondcoun);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setBounds(91, 155, 133, 30);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(477, 155, 133, 30);
		contentPane.add(t2);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(95, 73, 46, 14);
		contentPane.add(lblFrom);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(477, 73, 46, 14);
		contentPane.add(lblTo);

		firstCurrUnit = new JLabel("units");
		firstCurrUnit.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstCurrUnit.setBounds(95, 207, 129, 30);
		contentPane.add(firstCurrUnit);

		secCurrUnit = new JLabel("units");
		secCurrUnit.setFont(new Font("Tahoma", Font.BOLD, 12));
		secCurrUnit.setBounds(481, 207, 129, 30);
		contentPane.add(secCurrUnit);

		JButton btnNewButton = new JButton("CONVERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (firstcoun.getSelectedIndex() == 0 || secondcoun.getSelectedIndex() == 0
						|| t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Value First !!", "Error Message",
							JOptionPane.INFORMATION_MESSAGE);

					return;
				}

				double amounttoChange = Double.parseDouble(t1.getText()); // getting text from t1

				double amountinPounds = 0;
				double amountafterchange = 0.0;

				switch (firstcoun.getSelectedItem().toString()) {

				case "USA":
					amountinPounds = amounttoChange / US_Dollar;
					break;
				case "Nigeria":
					amountinPounds = amounttoChange / Nigerian_Naira;
					break;
				case "Brazil":
					amountinPounds = amounttoChange / Brazilian_Real;
					break;
				case "Canada":
					amountinPounds = amounttoChange / Canadian_Dollar;
					break;
				case "Kenyan":
					amountinPounds = amounttoChange / Kenyan_Shilling;
					break;
				case "Indonesia":
					amountinPounds = amounttoChange / Indonesian_Rupiah;
					break;
				case "India":
					amountinPounds = amounttoChange / Indian_Rupee;
					break;
				case "Philippine":
					amountinPounds = amounttoChange / Phillippine_Pisco;
					break;
				case "Pakistan":
					amountinPounds = amounttoChange / Pakistani_Rupee;
					break;
				default:
					amountinPounds = 0.0;

				}

				switch (secondcoun.getSelectedItem().toString()) {

				case "USA":
					amountafterchange = amountinPounds * US_Dollar;
					break;
				case "Nigeria":
					amountafterchange = amountinPounds * Nigerian_Naira;
					break;
				case "Brazil":
					amountafterchange = amountinPounds * Brazilian_Real;
					break;
				case "Canada":
					amountafterchange = amountinPounds * Canadian_Dollar;
					break;
				case "Kenyan":
					amountafterchange = amountinPounds * Kenyan_Shilling;
					break;
				case "Indonesia":
					amountafterchange = amountinPounds * Indonesian_Rupiah;
					break;
				case "India":
					amountafterchange = amountinPounds * Indian_Rupee;
					break;
				case "Philippine":
					amountafterchange = amountinPounds * Phillippine_Pisco;
					break;
				case "Pakistan":
					amountafterchange = amountinPounds * Pakistani_Rupee;
					break;
				default:
					amountafterchange = amountinPounds * 0.0;

				}

				String value = String.format("%.2f", amountafterchange);

				t2.setText(value);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(309, 284, 112, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				firstcoun.setSelectedIndex(0);
				secondcoun.setSelectedIndex(0);
				t1.setText("");
				t2.setText("");

			}

		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(186, 286, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(461, 284, 89, 23);
		contentPane.add(btnExit);
	}
}
