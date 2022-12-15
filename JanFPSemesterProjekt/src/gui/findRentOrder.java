package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.EDescriptionController;
import controller.EquipmentController;
import db.DataAccessException;
import model.EDescription;
import model.Equipment;
import model.RentOrder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.RentOrderController;

public class findRentOrder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_RID;
	private JTable tableRentOrder;
	DefaultTableModel model;
	private RentOrderController rentOrderController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			findRentOrder dialog = new findRentOrder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public findRentOrder() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRID = new JLabel("Ordrens ID");
			lblRID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblRID.setBounds(80, 27, 103, 14);
			contentPanel.add(lblRID);
		}
		{
			textField_RID = new JTextField();
			textField_RID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_RID.setBounds(241, 24, 86, 20);
			contentPanel.add(textField_RID);
			textField_RID.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 64, 373, 142);
			contentPanel.add(scrollPane);
			{
				tableRentOrder = new JTable();
				tableRentOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
				model = new DefaultTableModel();
				Object[] column = {"Ordrens ID","Lejet Fra","Lejet Til","Leje Dato","Medarbejder ID"};
				model.setColumnIdentifiers(column);
				tableRentOrder.setModel(model);
				
				scrollPane.setViewportView(tableRentOrder);
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
		String serialNumber = textField_RID.getText();
		
		//saleController.addOrderLineByBarcode();
		textField_RID.setText("");
	}
	
	private void updateList() throws DataAccessException{
		// TODO Auto-generated method stub
		rentOrderController = new RentOrderController();
		Object[] rowData = new Object[5];
		rowData[0] = textField_RID.getText();
		int rID = Integer.parseInt( textField_RID.getText());
		RentOrder rentOrder = rentOrderController.findByRID(rID);
		rowData[1] = rentOrder.getRentedFrom();
		rowData[2] = rentOrder.getRentedTo();
		rowData[3] = rentOrder.getRentDate();
		rowData[4] = rentOrder.getEmpID();
		model.addRow(rowData);
	}
}
