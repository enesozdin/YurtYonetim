package yurtyonetim.temizlikpersonel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import yurtyonetim.database.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Camasirhane extends JFrame {

	private JPanel contentPane;
	private JTextField txtmarka;
	private JTextField txtmodel;
	private JTable tblcamasir;
	public static JTextField txtfiyat;
	private JComboBox cmbadet;
	public static Integer fiyats;
	private JTextField txtadet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				
				try {
					Camasirhane frame = new Camasirhane();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Camasirhane() {
		
		setTitle("Çamaşırhane");
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
		
		txtmarka = new JTextField();
		txtmarka.setBounds(68, 19, 150, 20);
		contentPane.add(txtmarka);
		txtmarka.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setBounds(68, 47, 150, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Marka");
		lblNewLabel.setBounds(10, 20, 50, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Model");
		lblNewLabel_1.setBounds(10, 50, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adet");
		lblNewLabel_2.setBounds(10, 80, 50, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.setBounds(10, 160, 90, 20);
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				int adet=Integer.parseInt(txtadet.getText());
				int fiyat=Integer.parseInt(txtfiyat.getText());
				int genelleme=adet*fiyat;
				String sorgu="Insert into t_camasirhane(marka,model,adet,fiyat) values('"+txtmarka.getText()+"','"+txtmodel.getText()+"','"+txtadet.getText()+"','"+genelleme+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");		
				
				temizle();
				getirme();
			}});
		contentPane.add(btnekle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 665, 240);
		contentPane.add(scrollPane);
		
		JLabel lblid = new JLabel("");
				
		tblcamasir = new JTable();
		tblcamasir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tblcamasir.getModel();
			        int row=tblcamasir.getSelectedRow();
			        
			       	lblid.setText(tblcamasir.getValueAt(row, 0).toString());
			        txtmarka.setText(tblcamasir.getValueAt(row, 1).toString());
			        txtmodel.setText(tblcamasir.getValueAt(row, 2).toString());
			        txtadet.setText(tblcamasir.getValueAt(row, 3).toString());
			        txtfiyat.setText(tblcamasir.getValueAt(row, 4).toString());
				
			}
		});
		tblcamasir.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marka", "Model", "Adet", "Fiyat"
			}
		));
		scrollPane.setViewportView(tblcamasir);
		

lblid.setBounds(417, 449, 2, 14);
contentPane.add(lblid);
		
		JButton btnguncelle = new JButton("Güncelle");
		btnguncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_camasirhane set marka='"+txtmarka.getText()+"',model='"+txtmodel.getText()+"',adet='"+txtadet.getText()+"',fiyat='"+txtfiyat.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});

		btnguncelle.setBounds(125, 160, 90, 20);
		contentPane.add(btnguncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblcamasir.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_camasirhane WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        getirme();
			}
		});
		btnSil.setBounds(240, 160, 90, 20);
		contentPane.add(btnSil);
		
		JLabel lblNewLabel_3 = new JLabel("Fiyat");
		lblNewLabel_3.setBounds(10, 110, 50, 15);
		contentPane.add(lblNewLabel_3);
		
		txtfiyat = new JTextField();
		txtfiyat.setColumns(10);
		txtfiyat.setBounds(68, 110, 150, 20);
		contentPane.add(txtfiyat);
		
		txtadet = new JTextField();
		txtadet.setBounds(68, 78, 150, 20);
		contentPane.add(txtadet);
		txtadet.setColumns(10);
		
	}
	public void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblcamasir.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_camasirhane";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
				Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tblcamasir.getModel();
		        	tbl.addRow(list);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
