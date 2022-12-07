package gui;

import java.awt.BorderLayout;


import controller.EDescriptionController;
import controller.EmployeeController;
import controller.EquipmentController;
import controller.WorksiteController;
import db.DataAccessException;
import model.EDescription;
import model.Equipment;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class test extends JFrame {

	private JPanel contentPane;
	private EmployeeController employeeController;
	private EquipmentController equipmentController;
	private EDescriptionController eDescriptionController;
	private WorksiteController worksiteController;
	private JTextField textEID;
	private JTextField textEName;
	private JTextField textModel;
	private JTextField textField_serialNumber;
	private JTextField textField_eState;
	private JTextField textField_wAddress;
	private JTextField textField_zipCode;
	private JTextField textField_name;
	private JTextField textField_address;
	private JTextField textField_ZipCityCode;
	private JTextField textField_phone;
	private JTextField textField_email;
	private JTextField textField_position;
	private JTextField textField_wID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() throws DataAccessException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(213, 5, 0, 0);
		panel.add(list);
		
		textEID = new JTextField();
		textEID.setBounds(57, 35, 96, 20);
		panel.add(textEID);
		textEID.setColumns(10);
		
		JLabel lbleID = new JLabel("eID");
		lbleID.setBounds(31, 38, 49, 14);
		panel.add(lbleID);
		
		JLabel lblEName = new JLabel("eName");
		lblEName.setBounds(10, 63, 49, 14);
		panel.add(lblEName);
		
		textEName = new JTextField();
		textEName.setBounds(57, 66, 96, 20);
		panel.add(textEName);
		textEName.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(10, 99, 49, 14);
		panel.add(lblModel);
		
		textModel = new JTextField();
		textModel.setBounds(57, 96, 96, 20);
		panel.add(textModel);
		textModel.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Create EDescrption");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					eDescriptionController = new EDescriptionController();
					equipmentController = new EquipmentController();
					//int eID;
					//eID = Integer.parseInt(textEID.getText());
					String eName = textEName.getText();
					String model = textModel.getText();
					//EDescription CurrEDescription;
					//CurrEDescription = eDescriptionController.createEDescription(eName, model, eID);
					
					boolean wasInsertedOK = eDescriptionController.insertEDescription(eName, model);
					
					
					System.out.println("wasInsertedOK");
					
					
				} catch (DataAccessException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(57, 150, 112, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setBounds(206, 38, 75, 14);
		panel.add(lblSerialNumber);
		
		JLabel lblEState = new JLabel("eState");
		lblEState.setBounds(206, 63, 49, 14);
		panel.add(lblEState);
		
		textField_serialNumber = new JTextField();
		textField_serialNumber.setBounds(294, 35, 96, 20);
		panel.add(textField_serialNumber);
		textField_serialNumber.setColumns(10);
		
		textField_eState = new JTextField();
		textField_eState.setBounds(294, 60, 96, 20);
		panel.add(textField_eState);
		textField_eState.setColumns(10);
		
		JButton btnCreateEquipment = new JButton("create EQ");
		btnCreateEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					eDescriptionController = new EDescriptionController();
					equipmentController = new EquipmentController();
					
					int serialNumber;
					serialNumber = Integer.parseInt(textField_serialNumber.getText());
					String eState = textField_eState.getText();
					int eID;
					eID = Integer.parseInt(textEID.getText());
					
					boolean wasInsertedOK = equipmentController.insertEquipment(serialNumber, eState, eDescriptionController.findByEID(eID));
					
					
					System.out.println("wasInsertedOK");
					

				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCreateEquipment.setBounds(294, 95, 89, 23);
		panel.add(btnCreateEquipment);
		
		JButton btnCreateWorksite = new JButton("create Worksite");
		btnCreateWorksite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					worksiteController = new WorksiteController();
					
					
					String zipCode = textField_zipCode.getText();
					String wAddress = textField_wAddress.getText();
					
					
					boolean wasInsertedOK = worksiteController.insertWorksite(wAddress, zipCode);
					
					
					
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCreateWorksite.setBounds(384, 269, 128, 21);
		panel.add(btnCreateWorksite);
		
		JLabel lblNewLabel = new JLabel("wAddress");
		lblNewLabel.setBounds(345, 190, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("zipCode");
		lblNewLabel_1.setBounds(345, 213, 45, 13);
		panel.add(lblNewLabel_1);
		
		textField_wAddress = new JTextField();
		textField_wAddress.setBounds(398, 187, 96, 19);
		panel.add(textField_wAddress);
		textField_wAddress.setColumns(10);
		
		textField_zipCode = new JTextField();
		textField_zipCode.setBounds(400, 210, 96, 19);
		panel.add(textField_zipCode);
		textField_zipCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(505, 38, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(505, 64, 45, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("zipCode");
		lblNewLabel_4.setBounds(505, 87, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("phone");
		lblNewLabel_5.setBounds(505, 110, 45, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("email");
		lblNewLabel_6.setBounds(505, 133, 45, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("position");
		lblNewLabel_7.setBounds(505, 155, 45, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("wID");
		lblNewLabel_8.setBounds(504, 175, 45, 13);
		panel.add(lblNewLabel_8);
		
		textField_name = new JTextField();
		textField_name.setBounds(559, 35, 96, 19);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		textField_address = new JTextField();
		textField_address.setBounds(560, 61, 96, 19);
		panel.add(textField_address);
		textField_address.setColumns(10);
		
		textField_ZipCityCode = new JTextField();
		textField_ZipCityCode.setBounds(559, 84, 96, 19);
		panel.add(textField_ZipCityCode);
		textField_ZipCityCode.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(559, 107, 96, 19);
		panel.add(textField_phone);
		textField_phone.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setBounds(560, 130, 96, 19);
		panel.add(textField_email);
		textField_email.setColumns(10);
		
		textField_position = new JTextField();
		textField_position.setBounds(560, 152, 96, 19);
		panel.add(textField_position);
		textField_position.setColumns(10);
		
		textField_wID = new JTextField();
		textField_wID.setBounds(559, 172, 96, 19);
		panel.add(textField_wID);
		textField_wID.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Create employee");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					employeeController = new EmployeeController();
					worksiteController = new WorksiteController();
					
					
					String name = textField_name.getText();
					String address = textField_address.getText();
					String phone = textField_phone.getText();
					String email = textField_email.getText();
					String zipCode = textField_zipCode.getText();
					String position = textField_position.getText();
					int wID;
					wID = Integer.parseInt(textField_wID.getText());
					
					boolean wasInsertedOK = employeeController.insertEmployee(name, address, phone, email, zipCode, position, worksiteController.findByWID(wID));
					/*
					 * Virker ikke, der skal laves en zipcity klasse til at kunne indsætte zipcode. 
					 * Så den bliver hentet på samme måde same wID
					 */
					//System.out.println(wasInsertedOK);
					System.out.println("was Inserted OK");
					
					
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(569, 209, 85, 21);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int ID = 109;
				int serialNumber = 45;
				int eID = 1;
				int wID = 2001;
				 try {
					employeeController = new EmployeeController();
					//employeeController.findByEID(ID);
					employeeController.findAll();
					 
					//equipmentController = new EquipmentController();
					//equipmentController.findBySerialNumber(serialNumber);
					
					 
					//eDescriptionController = new EDescriptionController();
					//eDescriptionController.findByEID(eID);
					 
					//worksiteController = new WorksiteController();
					// worksiteController.findByWID(wID);
					// worksiteController.findAll();
					 
					 
					 
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panel_1.add(btnNewButton);
	}
}
