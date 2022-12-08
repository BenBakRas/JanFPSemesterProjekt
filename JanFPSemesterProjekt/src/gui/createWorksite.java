package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createWorksite extends JFrame {

	private JPanel contentPane;

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
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToWorksiteMenu();
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreate.setBounds(236, 228, 89, 23);
		contentPane.add(btnCreate);
	}
	public static void backToWorksiteMenu() {
		WorksiteMenu frame = new WorksiteMenu();
		frame.setVisible(true);
	}
	
	
}
