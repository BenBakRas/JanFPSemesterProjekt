package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRent = new JButton("Leje Menu");
		btnRent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openRentMenu();
				dispose();
				}
		});
		btnRent.setBounds(10, 26, 154, 23);
		contentPane.add(btnRent);
		
		JButton btnEmployee = new JButton("Medarbejder Menu");
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEmployeeMenu();
				dispose();
			}
		});
		btnEmployee.setBounds(10, 60, 154, 23);
		contentPane.add(btnEmployee);
		
		JButton btnEquipment = new JButton("V\u00E6rkt\u00F8js Menu");
		btnEquipment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEquipmentMenu();
				dispose();
			}
		});
		btnEquipment.setBounds(10, 94, 154, 23);
		contentPane.add(btnEquipment);
		
		JButton btnNewButton_3 = new JButton("Arbejdplads Menu");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWorksiteMenu();
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 128, 154, 23);
		contentPane.add(btnNewButton_3);
	}
	public static void openRentMenu() {
		RentMenu frame = new RentMenu();
		frame.setVisible(true);
	}
	public static void openEmployeeMenu() {
		EmployeeMenu frame = new EmployeeMenu();
		frame.setVisible(true);
	}
	public static void openEquipmentMenu() {
		EquipmentMenu frame = new EquipmentMenu();
		frame.setVisible(true);
	}
	public static void openWorksiteMenu() {
		WorksiteMenu frame = new WorksiteMenu();
		frame.setVisible(true);
	}
}
