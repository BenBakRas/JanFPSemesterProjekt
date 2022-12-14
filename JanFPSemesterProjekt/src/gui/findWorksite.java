package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.RentOrderController;
import db.DataAccessException;
import model.RentOrder;
import model.Worksite;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.WorksiteController;

public class findWorksite extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_WID;
	private JTable tableWorksite;
	DefaultTableModel model;
	private WorksiteController worksiteController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			findWorksite dialog = new findWorksite();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public findWorksite() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblWID = new JLabel("Arbejdspladsens ID:");
			lblWID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblWID.setBounds(66, 28, 154, 14);
			contentPanel.add(lblWID);
		}
		{
			textField_WID = new JTextField();
			textField_WID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_WID.setBounds(258, 26, 86, 20);
			contentPanel.add(textField_WID);
			textField_WID.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(46, 64, 346, 153);
			contentPanel.add(scrollPane);
			{
				tableWorksite = new JTable();
				tableWorksite.setFont(new Font("Tahoma", Font.PLAIN, 12));
				model = new DefaultTableModel();
				Object[] column = {"ID","Adresse","Postnummer"};
				model.setColumnIdentifiers(column);
				tableWorksite.setModel(model);
				
				scrollPane.setViewportView(tableWorksite);
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
		String wID = textField_WID.getText();
		
		//saleController.addOrderLineByBarcode();
		textField_WID.setText("");
	}
	
	private void updateList() throws DataAccessException{
		// TODO Auto-generated method stub
		worksiteController = new WorksiteController();
		Object[] rowData = new Object[3];
		rowData[0] = textField_WID.getText();
		int wID = Integer.parseInt( textField_WID.getText());
		Worksite worksite = worksiteController.findByWID(wID);
		rowData[1] = worksite.getwAddress();
		rowData[2] = worksite.getZipCode();
		model.addRow(rowData);
	}
}
