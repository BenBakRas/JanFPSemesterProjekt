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
import javax.swing.JTable;
import javax.swing.JScrollPane;

import controller.EmployeeController;
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
				model = new DefaultTableModel();
				Object[] column = {"Navn","Adresse","Post Nr.","Telefon Nr.","email","ID"};
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
				JButton btnFindAll = new JButton("Find Alle");
				btnFindAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EmployeeFindAll();
					}
				});
				btnFindAll.setFont(new Font("Tahoma", Font.PLAIN, 12));
				buttonPane.add(btnFindAll);
			}
			{
				JButton btnSeach = new JButton("S\u00F8g");
				btnSeach.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnSeach.setActionCommand("OK");
				buttonPane.add(btnSeach);
				getRootPane().setDefaultButton(btnSeach);
			}
			{
				JButton btnBack = new JButton("Tilbage");
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
	public void EmployeeFindAll() {
		try {
			employeeController = new EmployeeController();
			List<Employee> res = employeeController.findAll();
			for(int i = 0; i < res.size(); i++) {
				
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
