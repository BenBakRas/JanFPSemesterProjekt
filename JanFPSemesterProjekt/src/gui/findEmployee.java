package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import controller.EDescriptionController;
import controller.EmployeeController;
import controller.EquipmentController;
import db.DataAccessException;
import model.EDescription;
import model.Employee;
import model.Equipment;

public class findEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_EmployeeID;
	private JTable EmployeeTable;
	DefaultTableModel model;
	private EmployeeController employeeController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			findEmployee dialog = new findEmployee();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public findEmployee() {
		setModal(true);
		setBounds(100, 100, 600, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField_EmployeeID = new JTextField();
			textField_EmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_EmployeeID.setBounds(293, 28, 86, 20);
			contentPanel.add(textField_EmployeeID);
			textField_EmployeeID.setColumns(10);
		}
		{
			JLabel lblEmployeeID = new JLabel("Medarbejder ID:");
			lblEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEmployeeID.setBounds(180, 31, 101, 14);
			contentPanel.add(lblEmployeeID);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(48, 92, 484, 225);
			contentPanel.add(scrollPane);
			{
				EmployeeTable = new JTable();
				EmployeeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
				model = new DefaultTableModel();
				Object[] column = {"Navn","Adresse","Postnummer","Telefonnummer","email","ID"};
				model.setColumnIdentifiers(column);
				EmployeeTable.setModel(model);
				
				scrollPane.setViewportView(EmployeeTable);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSeach = new JButton("S\u00F8g");
				btnSeach.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							updateList();
							addToList();
						} catch (Exception w) {
		                    System.out.println(w);
		                    JOptionPane.showMessageDialog(null,"Fejl ved indtastning","Wrong", JOptionPane.INFORMATION_MESSAGE);
		                    // TODO Auto-generated catch block
		                }
						
					}
				});
				btnSeach.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnSeach.setActionCommand("OK");
				buttonPane.add(btnSeach);
				getRootPane().setDefaultButton(btnSeach);
			}
			{
				JButton btnBack = new JButton("Cancel");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnBack.setActionCommand("Cancel");
				buttonPane.add(btnBack);
			}
		}
	}
	private void updateList() throws DataAccessException{
		try {
		employeeController = new EmployeeController();
		Object[] rowData = new Object[6];
		rowData[5] = textField_EmployeeID.getText();
		int eID = Integer.parseInt( textField_EmployeeID.getText());
		Employee employee = employeeController.findByEID(eID);
		rowData[0] = employee.getName();
		rowData[1] = employee.getAddress();
		rowData[2] = employee.getZipCode();
		rowData[3] = employee.getPhone();
		rowData[4] = employee.getEmail();
		model.addRow(rowData);
		
		} catch (Exception w) {
            System.out.println(w);
            JOptionPane.showMessageDialog(null,"Fejl ved indtastning","Wrong", JOptionPane.INFORMATION_MESSAGE);
            // TODO Auto-generated catch block
        }
	}
	public void addToList() {
		String EmployeeID = textField_EmployeeID.getText();
		
		//saleController.addOrderLineByBarcode();
		textField_EmployeeID.setText("");
	}
}
