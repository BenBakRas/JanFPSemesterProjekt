package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import controller.EmployeeController;
import controller.EDescriptionController;
import controller.EquipmentController;
import controller.RentOrderController;
import controller.WorksiteController;
import db.DataAccessException;
import model.EDescription;
import model.Equipment;

public class createRentOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField_RentedFrom;
	private JTextField textField_RentedTo;
	private JTextField textField_SerialNumber;
	private JTextField textField_EmployeeID;
	private JTable RentedEquipmentTable;
	DefaultTableModel model;
	private EquipmentController equipmentController;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createRentOrder frame = new createRentOrder();
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
	public createRentOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel panelWest2 = new JPanel();
		panelNorth.add(panelWest2, BorderLayout.WEST);
		panelWest2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblRentedTo = new JLabel("Lejet Til:");
		lblRentedTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelWest2.add(lblRentedTo);
		
		JLabel lblInsertRentedTo = new JLabel("");
		lblInsertRentedTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelWest2.add(lblInsertRentedTo);
		
		JPanel panelEast2 = new JPanel();
		panelNorth.add(panelEast2, BorderLayout.EAST);
		panelEast2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblRentedFrom = new JLabel("Lejet Fra:");
		lblRentedFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEast2.add(lblRentedFrom);
		
		JLabel lblInsertRentedFrom = new JLabel("");
		lblInsertRentedFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEast2.add(lblInsertRentedFrom);
		
		JPanel panelCenter2 = new JPanel();
		panelNorth.add(panelCenter2, BorderLayout.CENTER);
		panelCenter2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblEmployeeID = new JLabel("Medarbejder ID:");
		lblEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCenter2.add(lblEmployeeID);
		
		JLabel lblInsertEmployeeID = new JLabel("");
		lblInsertEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCenter2.add(lblInsertEmployeeID);
		
		JPanel panelSouth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("Opret");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelSouth.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSouth.add(btnCancel);
		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		
		Box verticalBox = Box.createVerticalBox();
		panelEast.add(verticalBox);
		
		JButton btnFindWorksite = new JButton("Find Arbejdsplads");
		btnFindWorksite.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox.add(btnFindWorksite);
		
		JButton btnFindEmployee = new JButton("Find Medarbejder");
		btnFindEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox.add(btnFindEmployee);
		
		JButton btnFindEquipment = new JButton("Find V\u00E6rkt\u00F8j");
		btnFindEquipment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox.add(btnFindEquipment);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JLabel lblWriteRentedTO = new JLabel("Lejet Til:");
		lblWriteRentedTO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblWriteEmployeeID = new JLabel("Medarbejder ID:");
		lblWriteEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_RentedFrom = new JTextField();
		textField_RentedFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_RentedFrom.setColumns(10);
		
		textField_RentedTo = new JTextField();
		textField_RentedTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_RentedTo.setColumns(10);
		
		JLabel lblWriteRentedFrom = new JLabel("Lejet Fra:");
		
		textField_SerialNumber = new JTextField();
		textField_SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_SerialNumber.setColumns(10);
		
		JLabel lblWriteSerialNumber = new JLabel("Serie Nummer:");
		
		textField_EmployeeID = new JTextField();
		textField_EmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_EmployeeID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAdd = new JButton("Tilf\u00F8j");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateList();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addToList();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnRemove = new JButton("Fjern V\u00E6rkt\u00F8j");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = RentedEquipmentTable.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCenter.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCenter.createSequentialGroup()
									.addComponent(lblWriteEmployeeID)
									.addGap(18)
									.addComponent(textField_EmployeeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCenter.createSequentialGroup()
									.addComponent(lblWriteRentedTO)
									.addGap(57)
									.addComponent(textField_RentedTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWriteRentedFrom)
								.addComponent(lblWriteSerialNumber))
							.addGap(51)
							.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCenter.createSequentialGroup()
									.addComponent(textField_SerialNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAdd))
								.addComponent(textField_RentedFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCenter.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelCenter.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRemove)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWriteRentedTO)
						.addComponent(textField_RentedTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_RentedFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWriteRentedFrom))
					.addGap(18)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWriteEmployeeID)
						.addComponent(textField_EmployeeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_SerialNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWriteSerialNumber)
						.addComponent(btnAdd))
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRemove)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		RentedEquipmentTable = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Serie Nummer","Navn","Model","Stand","Equipment ID"};
		model.setColumnIdentifiers(column);
		RentedEquipmentTable.setModel(model);
		
		scrollPane.setViewportView(RentedEquipmentTable);
		panelCenter.setLayout(gl_panelCenter);
	
		

	
	}
	public static void backToRentMenu() {
		RentMenu frame = new RentMenu();
		frame.setVisible(true);
	}
	
	public void addToList() {
		String serialNumber = textField_SerialNumber.getText();
	
		//saleController.addOrderLineByBarcode();
		textField_SerialNumber.setText("");
	}
	
	private void updateList() throws DataAccessException{
		// TODO Auto-generated method stub
		Object[] rowData = new Object[5];
		rowData[0] = textField_SerialNumber.getText();
		int serialNumber = Integer.parseInt( textField_SerialNumber.getText());
		equipmentController = new EquipmentController();
		Equipment equipment = equipmentController.findBySerialNumber(serialNumber);
		EDescription eDescription = equipment.getDescription();
		rowData[1] = eDescription.geteName();
		rowData[2] = eDescription.getModel();
		rowData[3] = equipment.geteState();
		rowData[4] = eDescription.geteID();
		model.addRow(rowData);
	}
}