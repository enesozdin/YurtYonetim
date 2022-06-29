package yurtyonetim.temizlikpersonel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.giris.Login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemizlikPersonelMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemizlikPersonelMain frame = new TemizlikPersonelMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TemizlikPersonelMain() {
		setTitle("Temizlik Personeli Paneli");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCamasirhane = new JButton("Çamaşırhane");
		btnCamasirhane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camasirhane cmshane=new Camasirhane();
				cmshane.setVisible(true);
			}
		});
		btnCamasirhane.setBounds(133, 182, 160, 70);
		contentPane.add(btnCamasirhane);
		
		JButton btnNewButton = new JButton("Temizlik Depo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemizlikDepo tmzdepo=new TemizlikDepo();
				tmzdepo.setVisible(true);
			}
		});
		btnNewButton.setBounds(350, 182, 160, 70);
		contentPane.add(btnNewButton);
		
	}
}
