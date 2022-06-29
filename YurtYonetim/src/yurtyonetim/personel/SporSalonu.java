package yurtyonetim.personel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SporSalonu extends JFrame {

	private JPanel contentPane;
	private JTable tblsporsalonu;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtmarka;
	private JTextField txtmodel;
	private JButton btnEkle;
	private JButton btnGuncelle;
	private JButton btnSil;
	private JLabel lblNewLabel_3;
	private JTextField txtfiyat;
	private JTextField txtadet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SporSalonu frame = new SporSalonu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SporSalonu() {
		setTitle("Spor Salonu");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		conn cn=new conn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 665, 240);
		contentPane.add(scrollPane);
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(452, 298, 0, 0);
		contentPane.add(lblid);
		
		tblsporsalonu = new JTable();
		tblsporsalonu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tblsporsalonu.getModel();
			        int row=tblsporsalonu.getSelectedRow();
			       	lblid.setText(tblsporsalonu.getValueAt(row, 0).toString());
			        txtmarka.setText(tblsporsalonu.getValueAt(row, 1).toString());
			        txtmodel.setText(tblsporsalonu.getValueAt(row, 2).toString());
			        txtadet.setText(tblsporsalonu.getValueAt(row, 3).toString());
			        txtfiyat.setText(tblsporsalonu.getValueAt(row, 4).toString());
			}
		});
		tblsporsalonu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marka", "Model", "Adet","Fiyat"
			}
		));
		scrollPane.setViewportView(tblsporsalonu);
		
		lblNewLabel = new JLabel("Marka");
		lblNewLabel.setBounds(10, 20, 50, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Model");
		lblNewLabel_1.setBounds(10, 49, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Adet");
		lblNewLabel_2.setBounds(10, 80, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtmarka = new JTextField();
		txtmarka.setBounds(70, 17, 150, 20);
		contentPane.add(txtmarka);
		txtmarka.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setBounds(70, 46, 150, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
		
		btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				int adet=Integer.parseInt(txtadet.getText());
				int toplam=Integer.parseInt(txtfiyat.getText());
				int genelleme = adet*toplam;
				String sorgu="Insert into t_sporsalonu(marka,model,adet,fiyat) values('"+txtmarka.getText()+"','"+txtmodel.getText()+"','"+txtadet.getText()+"','"+genelleme+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");		
				temizle();
				getirme();
			}
		});
		btnEkle.setBounds(10, 160, 90, 20);
		contentPane.add(btnEkle);
		
		btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_sporsalonu set marka='"+txtmarka.getText()+"',model='"+txtmodel.getText()+"',adet='"+txtadet.getText()+"',fiyat='"+txtfiyat.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnGuncelle.setBounds(125, 160, 90, 20);
		contentPane.add(btnGuncelle); 
		
		btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblsporsalonu.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_sporsalonu WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        temizle();
			        getirme();
			}
		});
		btnSil.setBounds(240, 160, 90, 20);
		contentPane.add(btnSil);
		
		lblNewLabel_3 = new JLabel("Fiyat");
		lblNewLabel_3.setBounds(10, 110, 50, 15);
		contentPane.add(lblNewLabel_3);
		
		txtfiyat = new JTextField();
		txtfiyat.setBounds(70, 107, 150, 20);
		contentPane.add(txtfiyat);
		txtfiyat.setColumns(10);
		
		txtadet = new JTextField();
		txtadet.setBounds(70, 77, 150, 20);
		contentPane.add(txtadet);
		txtadet.setColumns(10);
		
	}
	private void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblsporsalonu.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void getirme() {

		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_sporsalonu";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
		        Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tblsporsalonu.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
