package yurtyonetim.mudur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import yurtyonetim.database.conn;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class OgrenciOdaYerlestir extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtisim;
	private JTextField txtsoyisim;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciOdaYerlestir frame = new OgrenciOdaYerlestir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public OgrenciOdaYerlestir() {
		setTitle("Odaya Öğrenci Yerleştirme");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
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
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(10, 50, 50, 15);
		contentPane.add(lblSoyad);
		
		JLabel lblOda = new JLabel("Oda");
		lblOda.setBounds(10, 80, 50, 15);
		contentPane.add(lblOda);
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(557, 67, 0, 0);
		contentPane.add(lblid);

		JComboBox cmboda = new JComboBox();
		cmboda.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103", "201", "202", "203", "301", "302", "303", "401", "402", "403", "501", "502", "503"}));
		cmboda.setBounds(63, 76, 150, 22);
		contentPane.add(cmboda);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model=(DefaultTableModel) table.getModel();
			        int row=table.getSelectedRow();
			       
			       	lblid.setText(table.getValueAt(row, 0).toString());
			        txtisim.setText(table.getValueAt(row, 1).toString());
			        txtsoyisim.setText(table.getValueAt(row, 2).toString());
			        cmboda.setSelectedItem(table.getValueAt(row, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ad", "Soyad", "Oda No"
			}
		));
		scrollPane.setViewportView(table);
		
		txtisim = new JTextField();
		txtisim.setBounds(63, 19, 150, 20);
		contentPane.add(txtisim);
		txtisim.setColumns(10);
		
		txtsoyisim = new JTextField();
		txtsoyisim.setBounds(63, 50, 150, 20);
		contentPane.add(txtsoyisim);
		txtsoyisim.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Ad");
		lblNewLabel.setBounds(10, 20, 50, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn.Baglan();
				String sorgu="Insert into t_ogryerles(isim,soyisim,odano) values('"+txtisim.getText()+"','"+txtsoyisim.getText()+"','"+cmboda.getSelectedItem().toString()+"') ";
				cn.Ekle(sorgu);
				JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");
				temizle();
				getirme();
			}
		});
		btnNewButton.setBounds(10, 160, 90, 20);
		contentPane.add(btnNewButton);
		

		JButton btnNewButton_1 = new JButton("Güncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu="Update public.t_ogryerles set isim='"+txtisim.getText()+"',soyisim='"+txtsoyisim.getText()+"',odano='"+cmboda.getSelectedItem().toString()+"' where id="+Integer.parseInt(lblid.getText());
				cn.Guncelle(sorgu);
				temizle();
				getirme();
			}
		});
		btnNewButton_1.setBounds(125, 160, 90, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       DefaultTableModel model=(DefaultTableModel)table.getModel();
		        conn cn=new conn();
		        cn.Baglan();
		        String sorgu="DELETE FROM public.t_ogryerles WHERE id='"+Integer.parseInt(lblid.getText())+"'";
		        cn.Sil(sorgu);
		        model.getDataVector().removeAllElements();
		        temizle();
		        getirme();
			}
		});

		btnNewButton_2.setBounds(240, 160, 90, 20);
		contentPane.add(btnNewButton_2);
		
	}

	private void temizle() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void getirme() {
		conn cn=new conn();
		 cn.Baglan();
		 String sorgu="select * from t_ogryerles";
		 ResultSet rs=cn.Getir(sorgu);
		 try {
			while (rs.next()) {
				Integer id=rs.getInt("ID");
				String isim=rs.getString("isim");
				String soyisim=rs.getString("soyisim");
				Integer odano=rs.getInt("odano");
		        Object [] list= {id,isim,soyisim,odano};
		        	DefaultTableModel tbl=(DefaultTableModel) table.getModel();
		        	tbl.addRow(list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
