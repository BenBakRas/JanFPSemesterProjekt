package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class deleteEquipment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_SerialNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			deleteEquipment dialog = new deleteEquipment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public deleteEquipment() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSerialNumber = new JLabel("Intast varens  serie nummer:");
			lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSerialNumber.setBounds(42, 109, 163, 14);
			contentPanel.add(lblSerialNumber);
		}
		{
			textField_SerialNumber = new JTextField();
			textField_SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_SerialNumber.setBounds(215, 106, 86, 20);
			contentPanel.add(textField_SerialNumber);
			textField_SerialNumber.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BtnDelete = new JButton("Fjern");
				BtnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				BtnDelete.setActionCommand("OK");
				buttonPane.add(BtnDelete);
				getRootPane().setDefaultButton(BtnDelete);
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

}
