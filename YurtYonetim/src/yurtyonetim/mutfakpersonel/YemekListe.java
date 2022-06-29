package yurtyonetim.mutfakpersonel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YemekListe extends JFrame {

	private JPanel contentPane;
	private JTable tblListe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YemekListe frame = new YemekListe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public YemekListe() {
		setTitle("Yemek Listesi");
		conn cn=new conn();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 694, 388);
		contentPane.add(scrollPane);
		
		tblListe = new JTable();
		tblListe.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Tarih", "Yemek 1", "Yemek 2", "Yemek 3", "Yemek 4","Yemek 5"
			}
		));
		scrollPane.setViewportView(tblListe);
	}
	public void getirme() {

		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_yemekliste";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				String tarih=rs.getString("tarih");
				String yemek1=rs.getString("yemek1");
				String yemek2=rs.getString("yemek2");
				String yemek3=rs.getString("yemek3");
				String yemek4=rs.getString("yemek4");
				String yemek5=rs.getString("yemek5");
		        Object [] list= {tarih,yemek1,yemek2,yemek3,yemek4,yemek5};
		        	DefaultTableModel tbl=(DefaultTableModel) tblListe.getModel();
		        	tbl.addRow(list);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
