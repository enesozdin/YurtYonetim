package yurtyonetim.temizlikpersonel;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
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

public class TemizlikDepo extends JFrame {

	private JPanel contentPane;
	private JTable tbltemizdepo;
	private JTextField txtmarka;
	private JTextField txtmodel;
	private JTextField txtfiyat;
	private JTextField txtadet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemizlikDepo frame = new TemizlikDepo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TemizlikDepo() {
		setTitle("Temizlik Deposu");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		conn cn=new conn();
		cn.Baglan();
		
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
		lblid.setBounds(512, 33, 0, 0);
		contentPane.add(lblid);
		
		tbltemizdepo = new JTable();
		tbltemizdepo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tbltemizdepo.getModel();
			        int row=tbltemizdepo.getSelectedRow();
			       
			       	lblid.setText(tbltemizdepo.getValueAt(row, 0).toString());
			        txtmarka.setText(tbltemizdepo.getValueAt(row, 1).toString());
			        txtmodel.setText(tbltemizdepo.getValueAt(row, 2).toString());
			        txtadet.setText(tbltemizdepo.getValueAt(row, 3).toString());
			        txtfiyat.setText(tbltemizdepo.getValueAt(row, 4).toString());
			}
		});
		tbltemizdepo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marka", "Model", "Adet","Fiyat"
			}
		));
		scrollPane.setViewportView(tbltemizdepo);
		
		txtmarka = new JTextField();
		txtmarka.setBounds(66, 17, 150, 20);
		contentPane.add(txtmarka);
		txtmarka.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setBounds(66, 47, 150, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Marka");
		lblNewLabel.setBounds(10, 20, 50, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(10, 50, 50, 15);
		contentPane.add(lblModel);
		
		JLabel lblNewLabel_1 = new JLabel("Adet");
		lblNewLabel_1.setBounds(10, 80, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				int adet=Integer.parseInt(txtadet.getText());
				int fiyat=Integer.parseInt(txtfiyat.getText());
				int toplam=adet*fiyat;
				
				String sorgu="Insert into t_temizlikdepo(marka,model,adet,fiyat) values('"+txtmarka.getText()+"','"+txtmodel.getText()+"','"+txtadet.getText()+"','"+toplam+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");		
				
				temizle();
				getirme();
			}
		});
		btnEkle.setBounds(10, 160, 90, 20);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tbltemizdepo.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_temizlikdepo WHERE marka='"+txtmarka.getText()+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        temizle();
			        getirme();
			}
		});
		btnSil.setBounds(240, 160, 90, 20);
		contentPane.add(btnSil);
		
		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temizle();
				getirme();
			}
		});
		btnGuncelle.setBounds(125, 160, 90, 20);
		contentPane.add(btnGuncelle);
		
		JLabel lblNewLabel_2 = new JLabel("Fiyat");
		lblNewLabel_2.setBounds(10, 110, 50, 15);
		contentPane.add(lblNewLabel_2);
		
		txtfiyat = new JTextField();
		txtfiyat.setBounds(66, 107, 150, 20);
		contentPane.add(txtfiyat);
		txtfiyat.setColumns(10);
		
		txtadet = new JTextField();
		txtadet.setBounds(66, 77, 150, 20);
		contentPane.add(txtadet);
		txtadet.setColumns(10);
		
	}
	
	public void temizle() {
		DefaultTableModel model=(DefaultTableModel) tbltemizdepo.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_temizlikdepo";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
		        Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tbltemizdepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
