package yurtyonetim.giris;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yurtyonetim.database.conn;
import yurtyonetim.mudur.AdminPanel;
import yurtyonetim.mutfakpersonel.MutfakDepo;
import yurtyonetim.mutfakpersonel.MutfakMain;
import yurtyonetim.ogrenci.OgrenciMain;
import yurtyonetim.personel.Kantin;
import yurtyonetim.personel.SporSalonu;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import yurtyonetim.temizlikpersonel.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtkadi;
	private JPasswordField pswsifre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static String yetki;
	public static String ad;
	public Login() {
		setTitle("Giriş");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtkadi = new JTextField();
		txtkadi.setBounds(230, 69, 142, 20);
		contentPane.add(txtkadi);
		txtkadi.setColumns(10);
		ad=txtkadi.getText();
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı:");
		lblNewLabel.setBounds(128, 72, 77, 14);
		contentPane.add(lblNewLabel);
		
		pswsifre = new JPasswordField();
		pswsifre.setBounds(230, 120, 142, 20);
		contentPane.add(pswsifre);
		
		JLabel lblNewLabel_1 = new JLabel("Şifre:");
		lblNewLabel_1.setBounds(128, 123, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
		    conn cn=new conn();
		    String pass=pswsifre.getText();;
		    String kadi = txtkadi.getText();
			String sorgu="Select count (username) as giris from t_login where username='"+kadi+"' and pass='"+pass+"'";
			String sorgu2="Select authority from t_login where username='"+txtkadi.getText()+"' And pass='"+pswsifre.getText()+"'";
			
			cn.Baglan();
			ResultSet rs=cn.Getir(sorgu);
			ResultSet rs1=cn.girisyetkisi(sorgu2);
			
			
			while (rs.next()) {
				
				if (rs.getInt("giris")==1) {
					setVisible(false);
					}
				}
			while (rs1.next()) {
				 yetki=rs1.getString("authority");
				if (yetki.equals("Temizlik Görevlisi")) 
				{
					TemizlikPersonelMain frmpm=new TemizlikPersonelMain();
					frmpm.setVisible(true);
					setVisible(false);
				}
				if (yetki.equals("Müdür")) {
					AdminPanel adminpnl=new AdminPanel();
					adminpnl.setVisible(true);
					setVisible(false);
				}
				if (yetki.equals("Mutfak Görevlisi")) {
					MutfakMain mtfmain=new MutfakMain();
					mtfmain.setVisible(true);
					setVisible(false);
				}
				if (yetki.equals("Öğrenci")) {
					OgrenciMain ogrmain=new OgrenciMain();
					ogrmain.setVisible(true);
					setVisible(false);
				}
				if (yetki.equals("Kantin Görevlisi")) {
					Kantin knt=new Kantin();
					knt.setVisible(true);
					setVisible(false);
				}
				if(yetki.equals("Salon Görevlisi")) {
				SporSalonu sporsalon=new SporSalonu();
				sporsalon.setVisible(true);
				setVisible(false);
			}
			}
				}
				
				catch(SQLException ex){
					System.out.println(ex);
			}
			}
		});
		btnGiris.setBounds(252, 187, 89, 23);
		contentPane.add(btnGiris);
	}
	

}
