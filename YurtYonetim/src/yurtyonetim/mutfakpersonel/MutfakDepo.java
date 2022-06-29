package yurtyonetim.mutfakpersonel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MutfakDepo extends JFrame {

	private JPanel contentPane;
	private final JTable tblmutfakdepo = new JTable();
	private JTextField txtmarka;
	private JTextField txtmodel;
	public static JTextField txtfiyat;
	public static Integer fiyatss;
	private JTextField txtadet;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MutfakDepo frame = new MutfakDepo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MutfakDepo() {
		setTitle("Mutfak Depo");
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
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(416, 61, 4, 14);
		contentPane.add(lblid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 665, 240);
		contentPane.add(scrollPane);
		tblmutfakdepo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tblmutfakdepo.getModel();
			        int row=tblmutfakdepo.getSelectedRow();
			       
			       	lblid.setText(tblmutfakdepo.getValueAt(row, 0).toString());
			        txtmarka.setText(tblmutfakdepo.getValueAt(row, 1).toString());
			        txtmodel.setText(tblmutfakdepo.getValueAt(row, 2).toString());
			        txtadet.setText(tblmutfakdepo.getValueAt(row, 3).toString());
			        txtfiyat.setText(tblmutfakdepo.getValueAt(row, 4).toString());
			}
		});
		tblmutfakdepo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marka", "Model", "Adet","Fiyat"
			}
		));
		scrollPane.setViewportView(tblmutfakdepo);
		
		JLabel lblNewLabel1 = new JLabel("Model");
		lblNewLabel1.setBounds(10, 50, 50, 15);
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel = new JLabel("Marka");
		lblNewLabel.setBounds(10, 20, 50, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adet");
		lblNewLabel_1.setBounds(10, 80, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		txtmarka = new JTextField();
		txtmarka.setBounds(53, 17, 150, 20);
		contentPane.add(txtmarka);
		txtmarka.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setBounds(53, 47, 150, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				int adet=Integer.parseInt(txtadet.getText());
				int fiyat=Integer.parseInt(txtfiyat.getText());
				int toplam=adet*fiyat;
				
				String sorgu="Insert into t_mutfakdepo(marka,model,adet,fiyat) values('"+txtmarka.getText()+"','"+txtmodel.getText()+"','"+adet+"','"+toplam+"') ";
				cn.Ekle(sorgu);
				temizle();
				getirme();
			}
		});
		btnEkle.setBounds(10, 160, 90, 20);
		contentPane.add(btnEkle);
		
		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");		
				String sorgu="Update public.t_mutfakdepo set marka='"+txtmarka.getText()+"',model='"+txtmodel.getText()+"',adet='"+txtadet.getText()+"',fiyat='"+txtfiyat.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnGuncelle.setBounds(125, 160, 90, 20);
		contentPane.add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblmutfakdepo.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_mutfakdepo WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        temizle();
			        getirme();
			}
		});
		btnSil.setBounds(240, 160, 90, 20);
		contentPane.add(btnSil);
		
		txtfiyat = new JTextField();
		txtfiyat.setBounds(53, 106, 150, 20);
		contentPane.add(txtfiyat);
		txtfiyat.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fiyat");
		lblNewLabel_2.setBounds(10, 110, 50, 15);
		contentPane.add(lblNewLabel_2);
		
		txtadet = new JTextField();
		txtadet.setBounds(53, 77, 150, 20);
		contentPane.add(txtadet);
		txtadet.setColumns(10);

	}
		private void temizle() {
			DefaultTableModel model=(DefaultTableModel) tblmutfakdepo.getModel();
			model.getDataVector().removeAllElements();
		}
	
	private void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_mutfakdepo";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("id");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
		        Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tblmutfakdepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}