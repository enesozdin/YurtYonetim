package yurtyonetim.mudur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class OgrenciGirisCikis extends JFrame {

	private JPanel contentPane;
	private JTextField txtSinifAra;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciGirisCikis frame = new OgrenciGirisCikis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OgrenciGirisCikis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 65, 140, 22);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnGiris = new JRadioButton("Giris");
		rdbtnGiris.setBounds(63, 125, 109, 23);
		contentPane.add(rdbtnGiris);
		
		JRadioButton rdbtn = new JRadioButton("Çıkış");
		rdbtn.setBounds(214, 125, 109, 23);
		contentPane.add(rdbtn);
		
		txtSinifAra = new JTextField();
		txtSinifAra.setBounds(104, 11, 140, 20);
		contentPane.add(txtSinifAra);
		txtSinifAra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sınıf Giriniz");
		lblNewLabel.setBounds(10, 14, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Öğrenci Seçiniz");
		lblNewLabel_1.setBounds(10, 69, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnGonder = new JButton("Gönder");
		btnGonder.setBounds(123, 186, 89, 23);
		contentPane.add(btnGonder);
		
		JButton btnAra = new JButton("Ara");
		btnAra.setBounds(268, 10, 89, 23);
		contentPane.add(btnAra);
		
		
	}
}
