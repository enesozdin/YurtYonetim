package yurtyonetim.mudur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import yurtyonetim.database.conn;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class OgrenciYerlesim extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciYerlesim frame = new OgrenciYerlesim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	ArrayList<String> liste = new ArrayList<String>();
	
	public OgrenciYerlesim() {
		setTitle("Öğrenci Yerleşimi");
		conn cn=new conn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oda Numarası");
		lblNewLabel.setBounds(102, 46, 81, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblogr1 = new JLabel("Boş");
		lblogr1.setBounds(10, 134, 119, 14);
		contentPane.add(lblogr1);
		
		JLabel lblogr2 = new JLabel("Boş");
		lblogr2.setBounds(139, 134, 112, 14);
		contentPane.add(lblogr2);
		
		JLabel lblogr3 = new JLabel("Boş");
		lblogr3.setBounds(261, 134, 119, 14);
		contentPane.add(lblogr3);
		
		JLabel lblogr4 = new JLabel("Boş");
		lblogr4.setBounds(395, 134, 130, 14);
		contentPane.add(lblogr4);
		
		JLabel lblogr5 = new JLabel("Boş");
		lblogr5.setBounds(535, 134, 115, 14);
		contentPane.add(lblogr5);
		
		JComboBox cmbodano = new JComboBox();
		cmbodano.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			lblogr1.setText("Boş");
			lblogr2.setText("Boş");
			lblogr3.setText("Boş");
			lblogr4.setText("Boş");
			lblogr5.setText("Boş");
			cn.Baglan();
				String sorgu2="Select isim from t_ogryerles where odano='"+cmbodano.getSelectedItem()+"'";
				ResultSet rs1=cn.girisyetkisi(sorgu2);
				try {
					int z = 0;
					while (rs1.next()) {
						//System.out.println(rs1.getString("isim"));
						 String name=sorgu2;
							String yetki=rs1.getString("isim");
							//System.out.println(yetki);
						   System.out.println(yetki);
							liste.add(yetki);
							
						
							if (z==0) {
								lblogr1.setText(yetki);
							}else if (z==1) {
								lblogr2.setText(yetki);
							}else if (z==2) {
								lblogr3.setText(yetki);
							}else if (z==3) {
								lblogr4.setText(yetki);
							}else if (z==4) {
								lblogr5.setText(yetki);
							}
						   z++;
											}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		cmbodano.setModel(new DefaultComboBoxModel(new String[] {"Oda Numarası Seçiniz","101", "102", "103", "201", "202", "203", "301", "302", "303", "401", "402", "403", "501", "502", "503"}));
		cmbodano.setBounds(227, 42, 220, 22);
		cmbodano.setSelectedItem("Oda Numarası Seçiniz");
		contentPane.add(cmbodano);
		
	}

}
