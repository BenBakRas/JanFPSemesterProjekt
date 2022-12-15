package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EmployeeController;
import controller.WorksiteController;
import db.DataAccessException;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class createEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Address;
	private JTextField textField_Phone;
	private JTextField textField_Email;
	private JTextField textField_Position;
	private JTextField textField_WorksiteID;
	private EmployeeController employeeController;
	private WorksiteController worksiteController;
	private JTextField textField_ZipCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createEmployee frame = new createEmployee();
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
	public createEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToEmployeeMenu();
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				employeeController = new EmployeeController();
				worksiteController = new WorksiteController();
				
				
				String name = textField_Name.getText();
				String address = textField_Address.getText();
				String phone = textField_Phone.getText();
				String email = textField_Email.getText();
				String position = textField_Position.getText();
				int wID;
				wID = Integer.parseInt(textField_WorksiteID.getText());
				String zipCode = textField_ZipCode.getText();
				
				boolean wasInsertedOK = employeeController.insertEmployee(name, address, phone, email, zipCode, position, worksiteController.findByWID(wID));
				
				backToEmployeeMenu();
				dispose();
				
				System.out.println("was Inserted OK");
				
				
				} catch (Exception w) {
                    System.out.println(w);
                    JOptionPane.showMessageDialog(null,"Fejl ved indtastning","Wrong", JOptionPane.INFORMATION_MESSAGE);
                    // TODO Auto-generated catch block
                }
			
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreate.setBounds(236, 228, 89, 23);
		contentPane.add(btnCreate);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Name.setBounds(108, 24, 86, 20);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Address.setBounds(303, 24, 86, 20);
		contentPane.add(textField_Address);
		textField_Address.setColumns(10);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Phone.setBounds(303, 55, 86, 20);
		contentPane.add(textField_Phone);
		textField_Phone.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Email.setBounds(108, 55, 86, 20);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblName = new JLabel("Navn:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(10, 28, 78, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 58, 78, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Adresse:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(204, 27, 99, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Telefon Nr:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhone.setBounds(204, 58, 86, 14);
		contentPane.add(lblPhone);
		
		textField_Position = new JTextField();
		textField_Position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Position.setBounds(303, 87, 86, 20);
		contentPane.add(textField_Position);
		textField_Position.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPosition.setBounds(204, 89, 99, 14);
		contentPane.add(lblPosition);
		
		textField_WorksiteID = new JTextField();
		textField_WorksiteID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_WorksiteID.setBounds(108, 86, 86, 20);
		contentPane.add(textField_WorksiteID);
		textField_WorksiteID.setColumns(10);
		
		JLabel lblWorksiteID = new JLabel("Arbejdsplads ID:");
		lblWorksiteID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWorksiteID.setBounds(10, 90, 88, 14);
		contentPane.add(lblWorksiteID);
		
		textField_ZipCode = new JTextField();
		textField_ZipCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_ZipCode.setBounds(108, 117, 86, 20);
		contentPane.add(textField_ZipCode);
		textField_ZipCode.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Post nummer:");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZipCode.setBounds(10, 120, 88, 14);
		contentPane.add(lblZipCode);
	}
	public static void backToEmployeeMenu() {
		EmployeeMenu frame = new EmployeeMenu();
		frame.setVisible(true);
	}
}
