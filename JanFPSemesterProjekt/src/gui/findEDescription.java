package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.WorksiteController;
import db.DataAccessException;
import model.EDescription;
import model.Worksite;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.EDescriptionController;

public class findEDescription extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_EID;
	private JTable tableDecription;
	DefaultTableModel model;
	private EDescriptionController eDescriptionController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			findEDescription dialog = new findEDescription();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public findEDescription() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblID = new JLabel("ID:");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblID.setBounds(109, 29, 46, 14);
			contentPanel.add(lblID);
		}
		{
			textField_EID = new JTextField();
			textField_EID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_EID.setBounds(197, 26, 86, 20);
			contentPanel.add(textField_EID);
			textField_EID.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 70, 377, 134);
			contentPanel.add(scrollPane);
			{
				tableDecription = new JTable();
				tableDecription.setFont(new Font("Tahoma", Font.PLAIN, 12));
				model = new DefaultTableModel();
				Object[] column = {"ID","Navn","model"};
				model.setColumnIdentifiers(column);
				tableDecription.setModel(model);
				
				scrollPane.setViewportView(tableDecription);
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
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				btnSeach.setActionCommand("OK");
				buttonPane.add(btnSeach);
				getRootPane().setDefaultButton(btnSeach);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void addToList() {
		String wID = textField_EID.getText();
		
		//saleController.addOrderLineByBarcode();
		textField_EID.setText("");
	}
	
	private void updateList() throws DataAccessException{
		// TODO Auto-generated method stub
		eDescriptionController = new EDescriptionController();
		Object[] rowData = new Object[3];
		rowData[0] = textField_EID.getText();
		int eID = Integer.parseInt( textField_EID.getText());
		EDescription eDescription = eDescriptionController.findByEID(eID);
		rowData[1] = eDescription.geteName();
		rowData[2] = eDescription.getModel();
		model.addRow(rowData);
	}
}
