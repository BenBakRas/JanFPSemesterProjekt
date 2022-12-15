package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.EDescriptionController;
import controller.EmployeeController;
import controller.EquipmentController;
import db.DataAccessException;
import model.EDescription;
import model.Employee;
import model.Equipment;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class findEquipment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_SerialNumber;
	private JTable tableEquipment;
	DefaultTableModel model;
	private EquipmentController equipmentController;
	private EDescriptionController eDescriptionController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			findEquipment dialog = new findEquipment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public findEquipment() {
		setModal(true);
		setBounds(100, 100, 540, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSerialNumber = new JLabel("Serie nummer:");
			lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSerialNumber.setBounds(90, 25, 89, 14);
			contentPanel.add(lblSerialNumber);
		}
		{
			textField_SerialNumber = new JTextField();
			textField_SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_SerialNumber.setBounds(219, 23, 86, 20);
			contentPanel.add(textField_SerialNumber);
			textField_SerialNumber.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(37, 64, 452, 137);
			contentPanel.add(scrollPane);
			{
				tableEquipment = new JTable();
				tableEquipment.setFont(new Font("Tahoma", Font.PLAIN, 12));
				model = new DefaultTableModel();
				Object[] column = {"Serie Nummer","Navn","Model","Stand","Equipment ID"};
				model.setColumnIdentifiers(column);
				tableEquipment.setModel(model);
				
				scrollPane.setViewportView(tableEquipment);
				
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
	public void addToList() {
		String serialNumber = textField_SerialNumber.getText();
		
		//saleController.addOrderLineByBarcode();
		textField_SerialNumber.setText("");
	}
	
	private void updateList() throws DataAccessException{
		// TODO Auto-generated method stub
		equipmentController = new EquipmentController();
		eDescriptionController = new EDescriptionController();
		Object[] rowData = new Object[3];
		rowData[0] = textField_SerialNumber.getText();
		int serialNumber = Integer.parseInt( textField_SerialNumber.getText());
		Equipment equipment = equipmentController.findBySerialNumber(serialNumber);
		rowData[1] = equipment.geteState();
		rowData[2] = equipment.getDescription().geteID();
		model.addRow(rowData);
	}
}
