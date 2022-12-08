package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EmployeeMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMenu frame = new EmployeeMenu();
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
	public EmployeeMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCansel = new JButton("Cancel");
		btnCansel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCansel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMain();
				dispose();
			}
		});
		btnCansel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCansel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCreateEmployee();
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreate.setBounds(10, 90, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFindEmployee();
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFind.setBounds(10, 124, 89, 23);
		contentPane.add(btnFind);
		
		JLabel lblNewLabel = new JLabel("Medarbejder Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(90, 11, 250, 50);
		contentPane.add(lblNewLabel);
	}
	public static void backToMain() {
		Main frame = new Main();
		frame.setVisible(true);
	}
	public static void openCreateEmployee() {
		createEmployee frame = new createEmployee();
		frame.setVisible(true);
	}
	public static void openFindEmployee() {
		findEmployee dialog = new findEmployee();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
