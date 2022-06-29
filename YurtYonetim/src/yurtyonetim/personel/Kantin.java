package yurtyonetim.personel;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Kantin extends JFrame {

	private JPanel contentPane;
	private JTable tblkantin;
	private JButton btnEkle;
	private JButton btnGuncelle;
	private JButton btnSıl;
	private JLabel lblMarka;
	private JLabel lblModel;
	private JLabel lblAdet;
	private JTextField txtmarka;
	private JTextField txtmodel;
	private JTextField txtfiyat;
	private JLabel lblNewLabel;
	private JLabel lblid;
	private JTextField txtadet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kantin frame = new Kantin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Kantin() {
		setTitle("Kantin");
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
		
		tblkantin = new JTable();
		tblkantin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tblkantin.getModel();
			        int row=tblkantin.getSelectedRow();
			       
			       	lblid.setText(tblkantin.getValueAt(row, 0).toString());
			        txtmarka.setText(tblkantin.getValueAt(row, 1).toString());
			        txtmodel.setText(tblkantin.getValueAt(row, 2).toString());
			        txtadet.setText(tblkantin.getValueAt(row, 3).toString());
			        txtfiyat.setText(tblkantin.getValueAt(row, 4).toString());
			}
		});
		tblkantin.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marka", "Model", "Adet","Fiyat"
			}
		));
		scrollPane.setViewportView(tblkantin);
		
		btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				int adet=Integer.parseInt(txtadet.getText());
				int toplam=Integer.parseInt(txtfiyat.getText());
				int genelleme = adet*toplam;
				
				
				String sorgu="Insert into t_kantin(marka,model,adet,fiyat) values('"+txtmarka.getText()+"','"+txtmodel.getText()+"','"+txtadet.getText()+"','"+genelleme+"') ";
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
				String sorgu="Update public.t_kantin set marka='"+txtmarka.getText()+"',model='"+txtmodel.getText()+"',adet='"+txtadet.getText()+"',fiyat='"+txtfiyat.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnGuncelle.setBounds(125, 160, 90, 20);
		contentPane.add(btnGuncelle);
		
		btnSıl = new JButton("Sil");
		btnSıl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblkantin.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_kantin WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        temizle();
			        getirme();
			}
		});
		btnSıl.setBounds(240, 160, 90, 20);
		contentPane.add(btnSıl);
		
		lblMarka = new JLabel("Marka");
		lblMarka.setBounds(10, 20, 50, 15);
		contentPane.add(lblMarka);
		
		lblModel = new JLabel("Model");
		lblModel.setBounds(10, 50, 50, 15);
		contentPane.add(lblModel);
		
		lblAdet = new JLabel("Adet");
		lblAdet.setBounds(10, 80, 50, 15);
		contentPane.add(lblAdet);
		
		txtmarka = new JTextField();
		txtmarka.setBounds(66, 18, 150, 20);
		contentPane.add(txtmarka);
		txtmarka.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setBounds(66, 47, 150, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
		
		txtfiyat = new JTextField();
		txtfiyat.setBounds(66, 107, 150, 20);
		contentPane.add(txtfiyat);
		txtfiyat.setColumns(10);
		
		lblNewLabel = new JLabel("Fiyat");
		lblNewLabel.setBounds(10, 110, 50, 15);
		contentPane.add(lblNewLabel);
		
		lblid = new JLabel("New label");
		lblid.setBounds(0, 0, 0, 0);
		contentPane.add(lblid);
		
		txtadet = new JTextField();
		txtadet.setBounds(66, 80, 150, 20);
		contentPane.add(txtadet);
		txtadet.setColumns(10);
	}
	private void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblkantin.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void getirme() {

		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_kantin";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
		        Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tblkantin.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
