package yurtyonetim.mudur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class IzinOgrenci extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzinOgrenci frame = new IzinOgrenci();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IzinOgrenci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(151, 28, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("İzin Alacak Öğrenci");
		lblNewLabel.setBounds(10, 31, 110, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Gönder");
		btnNewButton.setBounds(173, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Çıkış");
		lblNewLabel_1.setBounds(74, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giriş");
		lblNewLabel_2.setBounds(311, 88, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DatePicker");
		lblNewLabel_3.setBounds(47, 131, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("DatePicker");
		lblNewLabel_3_1.setBounds(300, 131, 57, 14);
		contentPane.add(lblNewLabel_3_1);
		
	}
}
