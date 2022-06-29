package yurtyonetim.temizlikpersonel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import java.awt.FlowLayout;

public class TemizlikKat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemizlikKat frame = new TemizlikKat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static int flag=0;
	public TemizlikKat() {
		JCheckBox chck=null;
		String something;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
if (flag==0) {
	        something=JOptionPane.showInputDialog("Yurdunuz kaç katlı?");
		int abc=Integer.parseInt(something);
		for (int i = 0; i <= abc; i++) {
			chck =new JCheckBox(i+" numaralı kat");
			contentPane.add(chck);
			flag=1;
		}
		if (flag==1) {
			
		}
}



		
	}
}
