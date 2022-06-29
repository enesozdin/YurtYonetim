package yurtyonetim.mudur;
import yurtyonetim.personel.Depo;
import yurtyonetim.personel.Kantin;
import yurtyonetim.personel.Muhasebe;
import yurtyonetim.personel.SporSalonu;
import yurtyonetim.temizlikpersonel.*;
import yurtyonetim.giris.*;
import yurtyonetim.mutfakpersonel.MutfakMain;
import yurtyonetim.ogrenci.OgrenciAidat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalTextFieldUI;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import javax.swing.JLabel;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	String kadi;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminPanel() {
		setTitle("Yönetici Paneli");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOgrYerlesim = new JButton("Öğrenci Dizilişi");
		btnOgrYerlesim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciYerlesim ogryerles=new OgrenciYerlesim();
				ogryerles.setVisible(true);
			}
		});
		btnOgrYerlesim.setBounds(33, 255, 159, 70);
		contentPane.add(btnOgrYerlesim);
		
		JButton btnMuhasebe = new JButton("Muhasebe Paneli");
		btnMuhasebe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Muhasebe muhasebe=new Muhasebe();
				muhasebe.setVisible(true);
			}
		});
		btnMuhasebe.setBounds(330, 108, 160, 70);
		contentPane.add(btnMuhasebe);
		
		
		JButton btnKayit = new JButton("Kayıt Yap");
		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sgnup=new SignUp();
				sgnup.setVisible(true);
			}
		});
		btnKayit.setBounds(760, 11, 102, 23);
		contentPane.add(btnKayit);
		
		JButton btnNewButton = new JButton("Personel Tablo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PersonelTablo ptbl=new PersonelTablo();
			ptbl.setVisible(true);			}
		});
		btnNewButton.setBounds(331, 255, 159, 70);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mutfak Paneli");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MutfakMain mtfmain=new MutfakMain();
				mtfmain.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(33, 108, 159, 70);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Temizlik Paneli");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemizlikPersonelMain tmzper=new TemizlikPersonelMain();			
			tmzper.setVisible(true);	
			}
		});
		btnNewButton_2.setBounds(608, 108, 160, 70);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Öğrencı Yerleştir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciOdaYerlestir ogryerlestir= new OgrenciOdaYerlestir();
				ogryerlestir.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(609, 257, 159, 67);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Öğrenci Tablo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciTablo ogrtbl=new OgrenciTablo();
				ogrtbl.setVisible(true);
				}
		});
		btnNewButton_4.setBounds(330, 424, 159, 70);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Aidat Kontrol");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciAidat ograidat=new OgrenciAidat();
				ograidat.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(33, 424, 159, 70);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Aidat Ekle");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciAidatKayit ograidatekle=new OgrenciAidatKayit();
				ograidatekle.setVisible(true);			}
		});
		btnNewButton_6.setBounds(608, 424, 160, 70);
		contentPane.add(btnNewButton_6);
	}
}
