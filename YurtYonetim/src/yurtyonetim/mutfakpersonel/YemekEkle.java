package yurtyonetim.mutfakpersonel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class YemekEkle extends JFrame {

	private JPanel contentPane;
	private JTextField txtyemek1;
	private JTextField txtyemek2;
	private JTextField txtyemek3;
	private JTextField txtyemek4;
	private JTextField txtyemek5;
	private JTable tblyemek;
	private JTextField txttarih;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YemekEkle frame = new YemekEkle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public YemekEkle() {
		setTitle("Yemek Ekle");
		conn cn=new conn();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getirme();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Yemek 1");
		lblNewLabel.setBounds(10, 56, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblYemek = new JLabel("Yemek 2");
		lblYemek.setBounds(10, 81, 76, 14);
		contentPane.add(lblYemek);
		
		JLabel lblYemek_1 = new JLabel("Yemek 3");
		lblYemek_1.setBounds(10, 106, 76, 14);
		contentPane.add(lblYemek_1);
		
		JLabel lblYemek_2 = new JLabel("Yemek 4");
		lblYemek_2.setBounds(10, 131, 76, 14);
		contentPane.add(lblYemek_2);
		
		JLabel lblYemek_3 = new JLabel("Yemek 5");
		lblYemek_3.setBounds(10, 156, 76, 14);
		contentPane.add(lblYemek_3);
		
		txtyemek1 = new JTextField();
		txtyemek1.setBounds(113, 53, 171, 20);
		contentPane.add(txtyemek1);
		txtyemek1.setColumns(10);
		
		txtyemek2 = new JTextField();
		txtyemek2.setColumns(10);
		txtyemek2.setBounds(113, 78, 171, 20);
		contentPane.add(txtyemek2);
		
		txtyemek3 = new JTextField();
		txtyemek3.setColumns(10);
		txtyemek3.setBounds(113, 103, 171, 20);
		contentPane.add(txtyemek3);
		
		txtyemek4 = new JTextField();
		txtyemek4.setColumns(10);
		txtyemek4.setBounds(113, 128, 171, 20);
		contentPane.add(txtyemek4);
		
		txtyemek5 = new JTextField();
		txtyemek5.setColumns(10);
		txtyemek5.setBounds(113, 153, 171, 20);
		contentPane.add(txtyemek5);
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(646, 386, 0, 0);
		contentPane.add(lblid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 616, 185);
		contentPane.add(scrollPane);
		
		tblyemek = new JTable();
		tblyemek.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) tblyemek.getModel();
			        int row=tblyemek.getSelectedRow();
			       
			       	lblid.setText(tblyemek.getValueAt(row, 0).toString());
			        txttarih.setText(tblyemek.getValueAt(row, 1).toString());
			        txtyemek1.setText(tblyemek.getValueAt(row, 2).toString());
			        txtyemek2.setText(tblyemek.getValueAt(row, 3).toString());
			        txtyemek3.setText(tblyemek.getValueAt(row, 4).toString());
			        txtyemek4.setText(tblyemek.getValueAt(row, 5).toString());
			        txtyemek5.setText(tblyemek.getValueAt(row, 6).toString());
			}
		});
		tblyemek.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Tarih", "Yemek 1", "Yemek 2", "Yemek 3", "Yemek 4", "Yemek 5"
			}
		));
		scrollPane.setViewportView(tblyemek);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				String sorgu="Insert into t_yemekliste(tarih,yemek1,yemek2,yemek3,yemek4,yemek5) values('"+txttarih.getText()+"','"+txtyemek1.getText()+"','"+txtyemek2.getText()+"','"+txtyemek3.getText()+"','"+txtyemek4.getText()+"','"+txtyemek5.getText()+"') ";
				cn.Ekle(sorgu);
				temizle();
				getirme();
			}
		});
		btnEkle.setBounds(20, 181, 89, 23);
		contentPane.add(btnEkle);
		
		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_yemekliste set tarih='"+txttarih.getText()+"','"+txtyemek1.getText()+"','"+txtyemek2.getText()+"','"+txtyemek3.getText()+"','"+txtyemek4.getText()+"','"+txtyemek5.getText()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnGuncelle.setBounds(136, 181, 89, 23);
		contentPane.add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)tblyemek.getModel();
			        conn cn=new conn();
			        cn.Baglan();
			        String sorgu="DELETE FROM public.t_yemekliste WHERE id='"+Integer.parseInt(lblid.getText())+"'";
			        cn.Sil(sorgu);
			        model.getDataVector().removeAllElements();
			        getirme();
			}
		});
		btnSil.setBounds(271, 181, 89, 23);
		contentPane.add(btnSil);
		
		txttarih = new JTextField();
		txttarih.setBounds(113, 31, 171, 20);
		contentPane.add(txttarih);
		txttarih.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tarih");
		lblNewLabel_1.setBounds(10, 31, 76, 14);
		contentPane.add(lblNewLabel_1);
		

	}
	
	private void temizle() {
		DefaultTableModel model=(DefaultTableModel) tblyemek.getModel();
		model.getDataVector().removeAllElements();
	}
	
	private void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_yemekliste";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("id");
				String tarih=rs.getString("tarih");
				String yemek1=rs.getString("yemek1");
				String yemek2=rs.getString("yemek2");
				String yemek3=rs.getString("yemek3");
				String yemek4=rs.getString("yemek4");
				String yemek5=rs.getString("yemek5");
		        Object [] list= {id,tarih,yemek1,yemek2,yemek3,yemek4,yemek5};
		        	DefaultTableModel tbl=(DefaultTableModel) tblyemek.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
