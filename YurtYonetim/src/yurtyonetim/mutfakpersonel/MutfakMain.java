package yurtyonetim.mutfakpersonel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MutfakMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MutfakMain frame = new MutfakMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MutfakMain() {
		setTitle("Mutfak Paneli");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Mutfak Depo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MutfakDepo mtfdepo=new MutfakDepo();
				mtfdepo.setVisible(true);	
			}
		});
		btnNewButton.setBounds(109, 222, 160, 70);
		contentPane.add(btnNewButton);
		
		JButton btnyemekekle = new JButton("Yemek Ekle");
		btnyemekekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YemekEkle ymkekle=new YemekEkle();
				ymkekle.setVisible(true);
			}
		});
		btnyemekekle.setBounds(577, 222, 160, 70);
		contentPane.add(btnyemekekle);
	}
}
