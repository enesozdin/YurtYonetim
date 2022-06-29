package yurtyonetim.giris;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yurtyonetim.database.conn;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtkadi;
	private JPasswordField pswsifre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static boolean isogr=false;
	public SignUp() {
		setTitle("Kayıt Yap");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtkadi = new JTextField();
		txtkadi.setBounds(223, 68, 129, 20);
		contentPane.add(txtkadi);
		txtkadi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
		lblNewLabel.setBounds(115, 71, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSifre = new JLabel("Şifre");
		lblSifre.setBounds(115, 107, 74, 14);
		contentPane.add(lblSifre);
		
		JLabel lblYetki = new JLabel("Yetki");
		lblYetki.setBounds(115, 143, 74, 14);
		contentPane.add(lblYetki);
		
		pswsifre = new JPasswordField();
		pswsifre.setBounds(223, 104, 129, 20);
		contentPane.add(pswsifre);
		
		JComboBox<String> cmbyetki = new JComboBox<String>();
		cmbyetki.setModel(new DefaultComboBoxModel(new String[] {"Temizlik Görevlisi", "Mutfak Görevlisi", "Müdür", "Kantin Görevlisi", "Öğrenci","Salon Görevlisi"}));
		cmbyetki.setBounds(223, 139, 129, 22);
		contentPane.add(cmbyetki);
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn cn= new conn();
				cn.Baglan();
				String sorgu="Insert into t_login(username,authority,pass) values('"+txtkadi.getText()+"','"+cmbyetki.getSelectedItem().toString()+"','"+pswsifre.getText()+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");	
			}
		});
		btnNewButton.setBounds(186, 214, 89, 23);
		contentPane.add(btnNewButton);
	}
}
