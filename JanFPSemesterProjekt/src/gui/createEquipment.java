package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EDescriptionController;
import controller.EquipmentController;
import db.DataAccessException;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class createEquipment extends JFrame {

	private JPanel contentPane;
	private JTextField textField_SerialNumber;
	private JTextField textField_State;
	protected EDescriptionController eDescriptionController;
	protected EquipmentController equipmentController;
	private JTextField textEID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createEquipment frame = new createEquipment();
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
	public createEquipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToEquipmentMenu();
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
					eDescriptionController = new EDescriptionController();
					equipmentController = new EquipmentController();
					
					int serialNumber;
					serialNumber = Integer.parseInt(textField_SerialNumber.getText());
					String eState = textField_State.getText();
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
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreate.setBounds(236, 228, 89, 23);
		contentPane.add(btnCreate);
		
		JLabel lblSerialNumber = new JLabel("Serie Nr:");
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerialNumber.setBounds(10, 65, 104, 14);
		contentPane.add(lblSerialNumber);
		
		textField_SerialNumber = new JTextField();
		textField_SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_SerialNumber.setBounds(124, 62, 86, 20);
		contentPane.add(textField_SerialNumber);
		textField_SerialNumber.setColumns(10);
		
		JLabel lblState = new JLabel("Stand:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblState.setBounds(10, 90, 46, 14);
		contentPane.add(lblState);
		
		textField_State = new JTextField();
		textField_State.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_State.setBounds(124, 93, 86, 20);
		contentPane.add(textField_State);
		textField_State.setColumns(10);
		
		textEID = new JTextField();
		textEID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEID.setBounds(124, 31, 86, 20);
		contentPane.add(textEID);
		textEID.setColumns(10);
		
		JLabel lblEID = new JLabel("V\u00E6rkt\u00F8js ID:");
		lblEID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEID.setBounds(10, 35, 89, 14);
		contentPane.add(lblEID);
	}
	public static void backToEquipmentMenu() {
		EquipmentMenu frame = new EquipmentMenu();
		frame.setVisible(true);
	}
}
