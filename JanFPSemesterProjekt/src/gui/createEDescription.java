package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EDescriptionController;
import controller.EquipmentController;
import db.DataAccessException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class createEDescription extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_name;
	private JTextField textField_model;
	private EDescriptionController eDescriptionController;
	private EquipmentController equipmentController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			createEDescription dialog = new createEDescription();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public createEDescription() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("V\u00E6rkt\u00F8jets navn:");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblName.setBounds(46, 55, 154, 14);
			contentPanel.add(lblName);
		}
		{
			textField_name = new JTextField();
			textField_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_name.setBounds(210, 52, 86, 20);
			contentPanel.add(textField_name);
			textField_name.setColumns(10);
		}
		{
			JLabel lblModel = new JLabel("V\u00E6rkt\u00F8jets model:");
			lblModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblModel.setBounds(46, 86, 154, 14);
			contentPanel.add(lblModel);
		}
		{
			textField_model = new JTextField();
			textField_model.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_model.setBounds(210, 83, 86, 20);
			contentPanel.add(textField_model);
			textField_model.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BtnCreate = new JButton("Opret");
				BtnCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							eDescriptionController = new EDescriptionController();
							equipmentController = new EquipmentController();					
							String eName = textField_name.getText();
							String model = textField_model.getText();
							
							boolean wasInsertedOK = eDescriptionController.insertEDescription(eName, model);
							
							
							System.out.println("wasInsertedOK");
							
							dispose();
							
						} catch (Exception w) {
		                    System.out.println(w);
		                    JOptionPane.showMessageDialog(null,"Fejl ved indtastning","Wrong", JOptionPane.INFORMATION_MESSAGE);
		                    // TODO Auto-generated catch block
		                }
						
					}
				});
				BtnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BtnCreate.setActionCommand("OK");
				buttonPane.add(BtnCreate);
				getRootPane().setDefaultButton(BtnCreate);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
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

}
