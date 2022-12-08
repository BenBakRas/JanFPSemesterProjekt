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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RentMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentMenu frame = new RentMenu();
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
	public RentMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRentMenu = new JLabel("Rent Menu");
		lblRentMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRentMenu.setBounds(90, 11, 250, 50);
		contentPane.add(lblRentMenu);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMain();
				dispose();
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCreateRentOrder();
			}
		});
		btnCreate.setBounds(10, 90, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFindRentOrder();
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFind.setBounds(10, 124, 89, 23);
		contentPane.add(btnFind);
	}
	public static void backToMain() {
		Main frame = new Main();
		frame.setVisible(true);
	}
	public static void openCreateRentOrder() {
		createRentOrder dialog = new createRentOrder();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	public static void openFindRentOrder() {
		findRentOrder dialog = new findRentOrder();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
