package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.WorksiteController;
import db.DataAccessException;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class createWorksite extends JFrame {

	private JPanel contentPane;
	private JTextField textField_WAddress;
	private JTextField textField_ZipCode;
	private WorksiteController worksiteController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createWorksite frame = new createWorksite();
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
	public createWorksite() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnCreate = new JButton("Opret");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				worksiteController = new WorksiteController();
				
				
				String zipCode = textField_ZipCode.getText();
				String wAddress = textField_WAddress.getText();
				
				
				boolean wasInsertedOK = worksiteController.insertWorksite(wAddress, zipCode);
				
				dispose();
				
				} catch (Exception w) {
                    System.out.println(w);
                    JOptionPane.showMessageDialog(null,"Fejl ved indtastning","Wrong", JOptionPane.INFORMATION_MESSAGE);
                    // TODO Auto-generated catch block
                }
			}
			
		});
		panel_1.add(btnCreate);
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToWorksiteMenu();
				dispose();
			}
		});
		panel_1.add(btnCancel);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JLabel lblWAddress = new JLabel("Adresse:");
		lblWAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWAddress.setBounds(51, 54, 189, 14);
		panel_4.add(lblWAddress);
		
		textField_WAddress = new JTextField();
		textField_WAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_WAddress.setBounds(265, 51, 86, 20);
		panel_4.add(textField_WAddress);
		textField_WAddress.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Post nummer:");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZipCode.setBounds(51, 92, 189, 14);
		panel_4.add(lblZipCode);
		
		textField_ZipCode = new JTextField();
		textField_ZipCode.setBounds(265, 89, 86, 20);
		panel_4.add(textField_ZipCode);
		textField_ZipCode.setColumns(10);
	}
	public static void backToWorksiteMenu() {
		WorksiteMenu frame = new WorksiteMenu();
		frame.setVisible(true);
	}
}
