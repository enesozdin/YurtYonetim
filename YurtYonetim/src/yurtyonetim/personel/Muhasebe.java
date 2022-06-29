package yurtyonetim.personel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yurtyonetim.mutfakpersonel.MutfakDepo;
import yurtyonetim.ogrenci.OgrenciAidat;
import yurtyonetim.temizlikpersonel.Camasirhane;
import yurtyonetim.temizlikpersonel.TemizlikDepo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Muhasebe extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Muhasebe frame = new Muhasebe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Muhasebe() {
		setTitle("Muhasebe Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMutfakDepo = new JButton("Mutfak Depo");
		btnMutfakDepo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MutfakDepo mdepo= new MutfakDepo();
				mdepo.setVisible(true);
			}
		});
		btnMutfakDepo.setBounds(94, 78, 160, 70);
		contentPane.add(btnMutfakDepo);
		
		JButton btnCamasirhane = new JButton("Çamaşırhane");
		btnCamasirhane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camasirhane cms= new Camasirhane();
				cms.setVisible(true);
			}
		});
		btnCamasirhane.setBounds(298, 78, 160, 70);
		contentPane.add(btnCamasirhane);
		
		JButton btnKantin = new JButton("Kantin");
		btnKantin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kantin knt=new Kantin();
				knt.setVisible(true);
			}
		});
		btnKantin.setBounds(506, 78, 160, 70);
		contentPane.add(btnKantin);
		
		JButton btnOgrenciAidat = new JButton("Öğrenci Aidat");
		btnOgrenciAidat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciAidat ograidat=new OgrenciAidat();
				ograidat.setVisible(true);

			}
		});
		btnOgrenciAidat.setBounds(298, 318, 160, 70);
		contentPane.add(btnOgrenciAidat);
		
		JButton btnTemizlikDepo = new JButton("Temizlik Depo");
		btnTemizlikDepo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemizlikDepo tdepo=new TemizlikDepo();
				tdepo.setVisible(true);

			}
		});
		btnTemizlikDepo.setBounds(94, 207, 160, 70);
		contentPane.add(btnTemizlikDepo);
		
		JButton btnSporSalonu = new JButton("Spor Salonu");
		btnSporSalonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SporSalonu sporsalon=new SporSalonu();
				sporsalon.setVisible(true);

			}
		});
		btnSporSalonu.setBounds(298, 207, 160, 70);
		contentPane.add(btnSporSalonu);
		
		JButton btnNewButton = new JButton("Depo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depo dpo=new Depo();
				dpo.setVisible(true);
			}
		});
		btnNewButton.setBounds(506, 204, 160, 70);
		contentPane.add(btnNewButton);
	}
}
