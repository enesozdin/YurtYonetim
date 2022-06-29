package yurtyonetim.ogrenci;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OgrenciAidat extends JFrame {

	private JPanel contentPane;
	private JTable tblaidat;
	String name;
	String surname;
	int id;
	JComboBox cmbOgrenciler;
	JComboBox cmbodano;
	conn cn=new conn();	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciAidat frame = new OgrenciAidat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void gel() {
		temizle();
		String gelenisim=cmbOgrenciler.getSelectedItem().toString();
		int bosluk=gelenisim.indexOf(" ");
		String gelen2=gelenisim.substring(0, bosluk);
		String gelen3=gelenisim.substring(bosluk+1,gelenisim.length());
		
		DefaultTableModel model=(DefaultTableModel) tblaidat.getModel();
		String sorgu="Select * from t_ograidat where isim='"+gelen2+"' AND soyisim = '"+gelen3+"'";
		ResultSet rs=cn.Getir(sorgu);
		try {
			while (rs.next()) {
				int id1=rs.getInt("id");
				String isim=rs.getString("isim");
				String soyisim=rs.getString("soyisim");
				String ay=rs.getString("ay");
				int ucret=rs.getInt("ucret");
				Object [] list= {id1,isim,soyisim,ay,ucret};
				model.addRow(list);
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

	ArrayList<String> liste = new ArrayList<String>();
	public OgrenciAidat() {
			
		setTitle("Öğrenci Aidat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		cmbOgrenciler = new JComboBox();
		cmbOgrenciler.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) tblaidat.getModel();
				model.getDataVector().removeAllElements();

			}
			
		});
		cmbOgrenciler.setBounds(63, 52, 117, 22);
		contentPane.add(cmbOgrenciler);
	
		cmbodano = new JComboBox();
		cmbodano.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cmbOgrenciler.removeAllItems();
				cn.Baglan();
				String sorgu2="Select * from t_ograidat where ogroda='"+cmbodano.getSelectedItem().toString()+"'";
				ResultSet rs1=cn.girisyetkisi(sorgu2);
				
				try {
					
					while (rs1.next()) {
						 id=rs1.getInt("id");
							 name=rs1.getString("isim");
							 surname=rs1.getString("soyisim");
							cmbOgrenciler.addItem(name+" "+ surname);
					}
						
				}					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		cmbodano.setModel(new DefaultComboBoxModel(new String[] {"Oda Numarası Seçiniz", "101", "102", "103", "201", "202", "203", "301", "302", "303", "401", "402", "403", "501", "502", "503"}));
		cmbodano.setBounds(63, 19, 117, 22);
		contentPane.add(cmbodano);
		
		
		JLabel lblNewLabel = new JLabel("Öğrenci");
		lblNewLabel.setBounds(10, 56, 46, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 643, 275);
		contentPane.add(scrollPane);
		
		tblaidat = new JTable();
		tblaidat.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"ID", "İsim","Soyisim", "Ay","Ücret"
			}
		));
		scrollPane.setViewportView(tblaidat);
		
		JLabel lblNewLabel_1 = new JLabel("Oda No");
		lblNewLabel_1.setBounds(10, 23, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(551, 159, 0, 0);
		contentPane.add(lblid);
		
		JButton btngel = new JButton("Tabloda Göster");
		btngel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gel();

			}
		});
		btngel.setBounds(32, 99, 148, 23);
		contentPane.add(btngel);
		

	}
	public void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblaidat.getModel();
		model.getDataVector().removeAllElements();
	}
}
