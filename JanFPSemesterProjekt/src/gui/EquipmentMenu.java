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

public class EquipmentMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentMenu frame = new EquipmentMenu();
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
	public EquipmentMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCreateEquipment();
			}
		});
		btnCreate.setBounds(10, 90, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFindEquipment();
			}
		});
		btnFind.setBounds(10, 124, 89, 23);
		contentPane.add(btnFind);
		
		JLabel lblEquipmentMenu = new JLabel("V\u00E6rkt\u00F8js Menu");
		lblEquipmentMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipmentMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEquipmentMenu.setBounds(90, 11, 250, 50);
		contentPane.add(lblEquipmentMenu);
	}
	public static void backToMain() {
		Main frame = new Main();
		frame.setVisible(true);
	}
	public static void openFindEquipment() {
		findEquipment dialog = new findEquipment();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	public static void openCreateEquipment() {
		createEquipment frame = new createEquipment();
		frame.setVisible(true);
	}
}
