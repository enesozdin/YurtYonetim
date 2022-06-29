package yurtyonetim.mudur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OgrenciTablo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtad;
	private JTextField txtsoyad;
	private JTextField txtcinsiyet;
	private JTextField txtdgmtrh;
	private JTextField txtyakin;
	private JTextField txtyakintel;
	private JTextField txttelefon;
	private JTextField txtoda;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciTablo frame = new OgrenciTablo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OgrenciTablo() {
		setTitle("Öğrenci Tablosu");
		
		conn cn=new conn();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 830, 203);
		contentPane.add(scrollPane);
		
		txtad = new JTextField();
		txtad.setBounds(95, 11, 86, 20);
		contentPane.add(txtad);
		txtad.setColumns(10);
		
		txtsoyad = new JTextField();
		txtsoyad.setBounds(279, 11, 86, 20);
		contentPane.add(txtsoyad);
		txtsoyad.setColumns(10);
		
		txtcinsiyet = new JTextField();
		txtcinsiyet.setBounds(459, 11, 86, 20);
		contentPane.add(txtcinsiyet);
		txtcinsiyet.setColumns(10);
		
		txtdgmtrh = new JTextField();
		txtdgmtrh.setBounds(459, 67, 86, 20);
		contentPane.add(txtdgmtrh);
		txtdgmtrh.setColumns(10);
		
		txtyakin = new JTextField();
		txtyakin.setBounds(95, 116, 86, 20);
		contentPane.add(txtyakin);
		txtyakin.setColumns(10);
		
		txtyakintel = new JTextField();
		txtyakintel.setBounds(279, 116, 86, 20);
		contentPane.add(txtyakintel);
		txtyakintel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ad");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(223, 14, 46, 14);
		contentPane.add(lblSoyad);
		
		JLabel lblNewLabel_1 = new JLabel("Cinsiyet");
		lblNewLabel_1.setBounds(375, 14, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		txttelefon = new JTextField();
		txttelefon.setColumns(10);
		txttelefon.setBounds(95, 66, 86, 20);
		contentPane.add(txttelefon);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon");
		lblNewLabel_2.setBounds(10, 69, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtoda = new JTextField();
		txtoda.setBounds(279, 67, 86, 20);
		contentPane.add(txtoda);
		txtoda.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Oda");
		lblNewLabel_3.setBounds(223, 69, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Doğum Tarihi");
		lblNewLabel_4.setBounds(375, 70, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Yakını");
		lblNewLabel_5.setBounds(10, 119, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(754, 70, -1, 14);
		contentPane.add(lblid);
		
		lblNewLabel_6 = new JLabel("Yakın Tel.");
		lblNewLabel_6.setBounds(201, 119, 68, 14);
		contentPane.add(lblNewLabel_6);
		
						table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   DefaultTableModel model=(DefaultTableModel) table.getModel();
				     int row=table.getSelectedRow();
				     lblid.setText(table.getValueAt(row,0).toString());
				     txtad.setText(table.getValueAt(row,1).toString());
				     txtsoyad.setText(table.getValueAt(row, 2).toString());
				     txtcinsiyet.setText(table.getValueAt(row, 3).toString());
				     txtdgmtrh.setText(table.getValueAt(row, 4).toString());
				     txttelefon.setText(table.getValueAt(row, 5).toString());
				     txtoda.setText(table.getValueAt(row, 6).toString());
				     txtyakin.setText(table.getValueAt(row, 7).toString());
				     txtyakintel.setText(table.getValueAt(row, 8).toString());
			}
		});
		btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				String sorgu="Insert into t_ogrenci(ad,soyad,cinsiyet,dogumtarih,oda,telefon,yakin,yakintel) values('"+txtad.getText()+"','"+txtsoyad.getText()+"','"+txtcinsiyet.getText()+"','"+txtdgmtrh.getText()+"','"+txtoda.getText()+"''"+txttelefon.getText()+"','"+txtyakin.getText()+"','"+txtyakintel.getText()+"') ";
				cn.Ekle(sorgu);
				temizle();
				getirme();
			}
		});
		btnNewButton.setBounds(92, 181, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Güncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_ogrenci set ad='"+txtad.getText()+"',soyad='"+txtsoyad.getText()+"',cinsiyet='"+txtcinsiyet.getText()+"',dogumtarih='"+txtdgmtrh.getText()+"',telefon='"+txttelefon.getText()+"',oda='"+txtoda.getText()+"',yakin='"+txtyakin.getText()+"',yakintel='"+txtyakintel.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		
		btnNewButton_1.setBounds(276, 181, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Sil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)table.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_ogrenci WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        getirme();
			}
		});
		btnNewButton_2.setBounds(456, 181, 89, 23);
		contentPane.add(btnNewButton_2);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Ad", "Soyad", "Cinsiyet", "Dogum Tarih", "Oda" ,"Telefon","Yakin", "Yakin tel"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	private void temizle() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
	
	private void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_ogrenci";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String ad=rs.getString("ad");
				String soyad=rs.getString("soyad");
				String cinsiyet=rs.getString("cinsiyet");
				String dogumtarih=rs.getString("dogumtarih");
				String oda=rs.getString("oda");
				Integer telefon=rs.getInt("telefon");
				String yakin=rs.getString("yakin");
				Integer yakintel=rs.getInt("yakintel");
		        Object [] list= {id,ad,soyad,cinsiyet,dogumtarih,oda,telefon,yakin,yakintel};
		        	DefaultTableModel tbl=(DefaultTableModel) table.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
