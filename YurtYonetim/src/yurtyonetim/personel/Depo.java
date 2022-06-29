package yurtyonetim.personel;

import java.awt.EventQueue;
import yurtyonetim.temizlikpersonel.Camasirhane;
import yurtyonetim.mutfakpersonel.MutfakDepo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import yurtyonetim.database.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
public class Depo extends JFrame {

	private JPanel contentPane;
	private JTable tbldepo;
	private JLabel lblid;
	private JLabel lbltopcamasir;
	private JLabel lbltopmutfak;
	private JLabel lbltopkantin;
	private JLabel lbltopsporsalonu;
	private JLabel lbltoptemizlikdepo;
	public float fiyatcamasirhane;
	public float fiyatmutfakdepo;
	private JLabel lbltop;
	private float fiyatkantin;
	private float fiyattemizlik;
	private float fiyatsporsalonu;
	private JLabel lblaidat;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Depo frame = new Depo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int genelucret;
	float genelleme;
	float sontoplam;
	private JButton btnNewButton_1;
	private JTextField txttarih;
	
	public Depo() {

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
				getirmemutfak();
				getirmecamasirhane();
				getirmekantin();
				getirmesporsalonu();
				getirmetemizlikdepo();
				fiyattoplacamasirhane();
				fiyattoplamutfakdepo();
				fiyattoplakantin();
				fiyattoplatemizlik();
				fiyattoplasporsalonu();
				aidatgetir();			
				sonuc();

			}
		});
		
		
//toplamgelir toplamgider geneltoplam 3
			
		
		setTitle("Depo");
		conn cn=new conn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 441, 404);
		contentPane.add(scrollPane);
		
		tbldepo = new JTable();
		tbldepo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marka", "Model", "Adet","Fiyat"
			}
		));
		scrollPane.setViewportView(tbldepo);
		
		lblid = new JLabel("New label");
		lblid.setBounds(545, 251, 0, 0);
		contentPane.add(lblid);
		
		lbltopcamasir = new JLabel("");
		lbltopcamasir.setBounds(459, 46, 243, 14);
		contentPane.add(lbltopcamasir);
		
		lbltopmutfak = new JLabel("");
		lbltopmutfak.setBounds(459, 71, 243, 14);
		contentPane.add(lbltopmutfak);
		
		lbltopkantin = new JLabel("");
		lbltopkantin.setBounds(459, 93, 243, 14);
		contentPane.add(lbltopkantin);
		
		lbltopsporsalonu = new JLabel("");
		lbltopsporsalonu.setBounds(459, 118, 243, 14);
		contentPane.add(lbltopsporsalonu);
		
		lbltoptemizlikdepo = new JLabel("");
		lbltoptemizlikdepo.setBounds(459, 143, 243, 14);
		contentPane.add(lbltoptemizlikdepo);

				lbltop = new JLabel("");
		lbltop.setBounds(465, 316, 191, 14);
		contentPane.add(lbltop);
		
		lblaidat = new JLabel("");
		lblaidat.setBounds(459, 168, 197, 14);
		contentPane.add(lblaidat);
		
		btnNewButton_1 = new JButton("PDF Oluştur");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdf();
			}
		});
		btnNewButton_1.setBounds(456, 427, 115, 23);
		contentPane.add(btnNewButton_1);
		
		txttarih = new JTextField();
		txttarih.setBounds(138, 11, 108, 20);
		contentPane.add(txttarih);
		txttarih.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dosyanın Adını Giriniz:");
		lblNewLabel.setBounds(10, 14, 135, 14);
		contentPane.add(lblNewLabel);
		
	}
	
	public void getirme() {

		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_depo";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
		        Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tbldepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getirmemutfak() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_mutfakdepo";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String marka=rs.getString("marka");
				String model=rs.getString("model");
				String adet=rs.getString("adet");
				Integer fiyat=rs.getInt("fiyat");
		        Object [] list= {id,marka,model,adet,fiyat};
		        	DefaultTableModel tbl=(DefaultTableModel) tbldepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getirmecamasirhane() {
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
		        	DefaultTableModel tbl=(DefaultTableModel) tbldepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aidatgetir() {
		
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select sum(ucret) as aidat from t_ograidat";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
			
				genelucret=rs.getInt("aidat");
		      
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getirmekantin() {
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
		        	DefaultTableModel tbl=(DefaultTableModel) tbldepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getirmesporsalonu() {
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
		        	DefaultTableModel tbl=(DefaultTableModel) tbldepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getirmetemizlikdepo() {
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
		        	DefaultTableModel tbl=(DefaultTableModel) tbldepo.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fiyattoplacamasirhane() {
		conn cn=new conn();
		cn.Baglan();
		String sorgu="Select sum(fiyat) as topfiyat from t_camasirhane";
		ResultSet rs=cn.Getir(sorgu);
		try {
			while (rs.next()) {
				 fiyatcamasirhane=rs.getInt("topfiyat");
				lbltopcamasir.setText("Çamaşırhane Gider: "+fiyatcamasirhane);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void fiyattoplamutfakdepo() {
		conn cn=new conn();
		cn.Baglan();
		String sorgu="Select sum(fiyat) as topfiyat from t_mutfakdepo";
		ResultSet rs=cn.Getir(sorgu);
		try {
			while (rs.next()) {
				fiyatmutfakdepo=rs.getInt("topfiyat");
				lbltopmutfak.setText("Mutfak Gider: "+fiyatmutfakdepo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	public void fiyattoplakantin() {
		conn cn=new conn();
		cn.Baglan();
		String sorgu="Select sum(fiyat) as topfiyat from t_kantin";
		ResultSet rs=cn.Getir(sorgu);
		try {
			while (rs.next()) {
				fiyatkantin=rs.getInt("topfiyat");
				lbltopkantin.setText("Kantin Gider: "+fiyatkantin);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	public void fiyattoplatemizlik() {
		conn cn=new conn();
		cn.Baglan();
		String sorgu="Select sum(fiyat) as topfiyat from t_temizlikdepo";
		ResultSet rs=cn.Getir(sorgu);
		try {
			while (rs.next()) {
				fiyattemizlik=rs.getInt("topfiyat");
				lbltoptemizlikdepo.setText("Temizlik Gider: "+fiyattemizlik);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	public void fiyattoplasporsalonu() {
		conn cn=new conn();
		cn.Baglan();
		String sorgu="Select sum(fiyat) as topfiyat from t_mutfakdepo";
		ResultSet rs=cn.Getir(sorgu);
		try {
			while (rs.next()) {
				fiyatsporsalonu=rs.getInt("topfiyat");
				lbltopsporsalonu.setText("Spor Salonu Gider: "+fiyatsporsalonu);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	public void sonuc() {
		sontoplam=fiyatcamasirhane+fiyatmutfakdepo+fiyatkantin+fiyattemizlik+fiyatsporsalonu;
		 genelleme=genelucret-sontoplam;
		lbltop.setText("Son Para: "+genelleme);

		System.out.println("Son Toplam: "+genelleme);
		lblaidat.setText("Öğrenci Aidatları: "+genelucret);
	}
	
	
	public void pdf()
	{
		Document document=new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(txttarih.getText()+".pdf"));
			
			document.open();
			document.add(new Phrase(""));
			document.add(new Paragraph("Yurt Yönetim Sistemi"));
			PdfPTable table=new PdfPTable(3);
			PdfPCell cell1=new PdfPCell(new Paragraph("Gelirler"));
			PdfPCell cell2=new PdfPCell(new Paragraph("Giderler"));
			PdfPCell cell3=new PdfPCell(new Paragraph("Toplam"));
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(""+genelucret);
			table.addCell(""+sontoplam);
			table.addCell(""+(genelucret-sontoplam));
			document.add(table);
document.close();
float sontoplam;
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
}
