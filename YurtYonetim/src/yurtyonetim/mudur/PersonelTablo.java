package yurtyonetim.mudur;

import java.awt.BorderLayout;
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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonelTablo extends JFrame {

	private JPanel contentPane;
	private JTable tblpersonel;
	private JTextField txtad;
	private JTextField txtsoyad;
	private JTextField txtcinsiyet;
	private JTextField txtgiristarih;
	private JTextField txtgorev;
	private JTextField txtmaas;
	private JTextField txttelefon;
	private JLabel lblSoyad;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblid;
	private JTextField txtbolum;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelTablo frame = new PersonelTablo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PersonelTablo() {
		setTitle("Personel Tablosu");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		
		conn cn=new conn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 783, 229);
		contentPane.add(scrollPane);
		
		tblpersonel = new JTable();
		tblpersonel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   DefaultTableModel model=(DefaultTableModel) tblpersonel.getModel();
				     int row=tblpersonel.getSelectedRow();
				     lblid.setText(tblpersonel.getValueAt(row,0).toString());
				     txtad.setText(tblpersonel.getValueAt(row,1).toString());
				     txtsoyad.setText(tblpersonel.getValueAt(row, 2).toString());
				     txtcinsiyet.setText(tblpersonel.getValueAt(row, 3).toString());
				     txttelefon.setText(tblpersonel.getValueAt(row, 4).toString());
				     txtbolum.setText(tblpersonel.getValueAt(row, 5).toString());
				     txtgorev.setText(tblpersonel.getValueAt(row, 6).toString());
				     txtgiristarih.setText(tblpersonel.getValueAt(row, 7).toString());
				     txtmaas.setText(tblpersonel.getValueAt(row, 8).toString());
			}
		});
		tblpersonel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id","Ad", "Soyad", "Cinsiyet", "Telefon", "Bölüm", "Görev", "Giriş Tarihi", "Maaş"
			}
		));
		scrollPane.setViewportView(tblpersonel);
		
		txtad = new JTextField();
		txtad.setBounds(131, 11, 86, 20);
		contentPane.add(txtad);
		txtad.setColumns(10);
		
		txtsoyad = new JTextField();
		txtsoyad.setColumns(10);
		txtsoyad.setBounds(289, 11, 86, 20);
		contentPane.add(txtsoyad);
		
		txtcinsiyet = new JTextField();
		txtcinsiyet.setColumns(10);
		txtcinsiyet.setBounds(485, 11, 86, 20);
		contentPane.add(txtcinsiyet);
		
		txtgiristarih = new JTextField();
		txtgiristarih.setColumns(10);
		txtgiristarih.setBounds(131, 91, 86, 20);
		contentPane.add(txtgiristarih);
		
		txtgorev = new JTextField();
		txtgorev.setColumns(10);
		txtgorev.setBounds(485, 53, 86, 20);
		contentPane.add(txtgorev);
		
		txtmaas = new JTextField();
		txtmaas.setColumns(10);
		txtmaas.setBounds(289, 94, 86, 20);
		contentPane.add(txtmaas);
		
		txttelefon = new JTextField();
		txttelefon.setColumns(10);
		txttelefon.setBounds(131, 53, 86, 20);
		contentPane.add(txttelefon);
		
		JLabel lblNewLabel = new JLabel("Ad");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(227, 14, 46, 14);
		contentPane.add(lblSoyad);
		
		lblNewLabel_1 = new JLabel("Cinsiyet");
		lblNewLabel_1.setBounds(418, 14, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Telefon");
		lblNewLabel_2.setBounds(10, 56, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Bölüm");
		lblNewLabel_3.setBounds(233, 56, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Görev");
		lblNewLabel_4.setBounds(418, 56, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Giriş Tarihi");
		lblNewLabel_5.setBounds(10, 94, 67, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Maaş");
		lblNewLabel_6.setBounds(227, 94, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				String sorgu="Insert into t_personel(ad,soyad,cinsiyet,telefon,bolum,gorev,giristarih,maas) values('"+txtad.getText()+"','"+txtsoyad.getText()+"','"+txtcinsiyet.getText()+"','"+txttelefon.getText()+"','"+txtbolum.getText()+"',"
						+ "'"+txtgorev.getText()+"','"+txtgiristarih.getText()+"','"+txtmaas.getText()+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");		
				
				temizle();
				getirme();
			}
		});
		btnekle.setBounds(115, 142, 89, 23);
		contentPane.add(btnekle);
		
		JButton btnguncelle = new JButton("Güncelle");
		btnguncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_personel set ad='"+txtad.getText()+"',soyad='"+txtsoyad.getText()+"',cinsiyet='"+txtcinsiyet.getText()+"',telefon='"+txttelefon.getText()+"',bolum='"+txtbolum.getText()+"',gorev='"+txtgorev.getText()+"',giristarih='"+txtgiristarih.getText()+"',maas='"+txtmaas.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnguncelle.setBounds(278, 142, 89, 23);
		contentPane.add(btnguncelle);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblpersonel.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_personel WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        getirme();
			}
		});
		btnsil.setBounds(485, 142, 89, 23);
		contentPane.add(btnsil);
		

		
		lblid = new JLabel("New label");
		lblid.setBounds(10, 404, 1, 14);
		contentPane.add(lblid);
		
		txtbolum = new JTextField();
		txtbolum.setBounds(289, 53, 86, 20);
		contentPane.add(txtbolum);
		txtbolum.setColumns(10);
	}
	
	 
	public void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblpersonel.getModel();
		model.getDataVector().removeAllElements();	
	}
	public void getirme() {

		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_personel";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String ad=rs.getString("ad");
				String soyad=rs.getString("soyad");
				String cinsiyet=rs.getString("cinsiyet");
				Integer telefon=rs.getInt("telefon");
				String bolum=rs.getString("bolum");
				String gorev=rs.getString("gorev");
				String giristarih=rs.getString("giristarih");
				Integer maas=rs.getInt("maas");
		        Object [] list= {id,ad,soyad,cinsiyet,telefon,bolum,gorev,giristarih,maas};
		        	DefaultTableModel tbl=(DefaultTableModel) tblpersonel.getModel();
		        	tbl.addRow(list);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
