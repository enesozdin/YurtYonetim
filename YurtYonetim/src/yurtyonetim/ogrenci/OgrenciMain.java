package yurtyonetim.ogrenci;

import java.awt.EventQueue;
import yurtyonetim.giris.Login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import yurtyonetim.mutfakpersonel.YemekListe;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OgrenciMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciMain frame = new OgrenciMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OgrenciMain() {
		setTitle("Öğrenci Panel");
		Login lgn=new Login();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnYemekListe = new JButton("Yemek Listesi");
		btnYemekListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YemekListe ymkliste=new YemekListe();
				ymkliste.setVisible(true);
			}
		});
		btnYemekListe.setBounds(168, 193, 160, 70);
		contentPane.add(btnYemekListe);
		
		JButton btnOdenenAidat = new JButton("Ödenen Aidatlar");
		btnOdenenAidat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciAidat ograidat=new OgrenciAidat();
				ograidat.setVisible(true);
			}
		});
		btnOdenenAidat.setBounds(454, 193, 160, 70);
		contentPane.add(btnOdenenAidat);
	}
}
