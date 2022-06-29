package yurtyonetim.mudur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OgrenciAidatKayit extends JFrame {

	private JPanel contentPane;
	private JTextField txtisim;
	private JTextField txtsoyisim;
	private JTextField txtucret;
	private JTable tblaidat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciAidatKayit frame = new OgrenciAidatKayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OgrenciAidatKayit() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		setTitle("Öğrenci Aidat Ekleme");
		
		conn cn= new conn();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Soyisim:");
		lblNewLabel_1.setBounds(10, 50, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ögrenci Oda:");
		lblNewLabel_2.setBounds(10, 110, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ücret");
		lblNewLabel_3.setBounds(10, 140, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ay:");
		lblNewLabel_4.setBounds(10, 80, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Isim:");
		lblNewLabel_5.setBounds(10, 20, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtisim = new JTextField();
		txtisim.setBounds(90, 17, 136, 20);
		contentPane.add(txtisim);
		txtisim.setColumns(10);
		
		txtsoyisim = new JTextField();
		txtsoyisim.setBounds(90, 47, 136, 20);
		contentPane.add(txtsoyisim);
		txtsoyisim.setColumns(10);
		
		JComboBox cmbay = new JComboBox();
		cmbay.setModel(new DefaultComboBoxModel(new String[] {"Ay Seçiniz", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"}));
		cmbay.setBounds(90, 78, 136, 22);
		contentPane.add(cmbay);
		
		JComboBox cmbogroda = new JComboBox();
		cmbogroda.setModel(new DefaultComboBoxModel(new String[] {"Oda Seçiniz", "101", "102", "103", "201", "202", "203", "301", "302", "303", "401", "402", "403", "501", "502", "503"}));
		cmbogroda.setBounds(90, 107, 136, 22);
		contentPane.add(cmbogroda);
		
		txtucret = new JTextField();
		txtucret.setBounds(90, 136, 136, 20);
		contentPane.add(txtucret);
		txtucret.setColumns(10);
		
		JLabel lblid = new JLabel("");
		lblid.setBounds(646, 36, 0, 14);
		contentPane.add(lblid);
		
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(10, 210, 665, 240);
		contentPane.add(scrollPane);
		
		tblaidat = new JTable();
		tblaidat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tblaidat.getModel();
			        int row=tblaidat.getSelectedRow();
			        
			       	lblid.setText(tblaidat.getValueAt(row, 0).toString());
			        txtisim.setText(tblaidat.getValueAt(row, 1).toString());
			        txtsoyisim.setText(tblaidat.getValueAt(row, 2).toString());
			        cmbay.setSelectedItem(tblaidat.getValueAt(row, 3).toString());
			        cmbogroda.setSelectedItem(tblaidat.getValueAt(row, 4).toString());
			        txtucret.setText(tblaidat.getValueAt(row, 5).toString());
			}
		});
		tblaidat.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Isim", "Soyisim", "Ay", "Öğrenci Oda", "Ücret"
			}
		));
		scrollPane.setViewportView(tblaidat);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int genelleme=Integer.parseInt(txtucret.getText());
				cn.Baglan();
				String sorgu="Insert into t_ograidat(isim,soyisim,ay,ogroda,ucret) values('"+txtisim.getText()+"','"+txtsoyisim.getText()+"','"+cmbay.getSelectedItem().toString()+"','"+cmbogroda.getSelectedItem()+"','"+txtucret.getText()+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");		
				
				temizle();
				getirme();
			}
		});
		btnNewButton.setBounds(10, 170, 90, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Güncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_ograidate set isim='"+txtisim.getText()+"',soyisim='"+txtsoyisim.getText()+"',ay='"+cmbay.getSelectedItem().toString()+"',ogroda='"+cmbogroda.getSelectedItem().toString()+"'ucret,='"+txtucret.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnNewButton_1.setBounds(125, 170, 90, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblaidat.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_ograidat WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        getirme();
			}
		});
		btnNewButton_2.setBounds(240, 170, 90, 20);
		contentPane.add(btnNewButton_2);

	}
	
	public void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblaidat.getModel();
		model.getDataVector().removeAllElements();
	}
	public void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_ograidat";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String isim=rs.getString("isim");
				String soyisim=rs.getString("soyisim");
				String ay=rs.getString("ay");
				Integer ogroda=rs.getInt("ogroda");
				Integer ucret=rs.getInt("ucret");
				Object [] list= {id,isim,soyisim,ay,ogroda,ucret};
		        	DefaultTableModel tbl=(DefaultTableModel) tblaidat.getModel();
		        	tbl.addRow(list);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
