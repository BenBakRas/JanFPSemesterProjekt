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
		setBounds(100, 100, 450, 300);
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
					int eID;
					eID = Integer.parseInt(textEID.getText());
					String eName = textEName.getText();
					String model = textModel.getText();
					//EDescription CurrEDescription;
					//CurrEDescription = eDescriptionController.createEDescription(eName, model, eID);
					
					boolean wasInsertedOK = eDescriptionController.insertEDescription(eName, model);
					
					
					System.out.println("wasInsertedOK");
					//int serialNumber;
					//serialNumber = Integer.parseInt(textField_serialNumber.getText());
					//String eState = textField_eState.getText();
					
					////equipment = equipmentController.createEquipment(serialNumber, eState, CurrEDescription);
					
					//System.out.println(CurrEDescription.toString());
					//System.out.println(equipment.toString());
					
					
					
					
				} catch (DataAccessException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(57, 186, 112, 23);
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
				
				
			}
		});
		btnCreateEquipment.setBounds(294, 145, 89, 23);
		panel.add(btnCreateEquipment);
		
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
