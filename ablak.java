import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ablak {
	public static void sleep() {
		try{
			TimeUnit.SECONDS.sleep(3);
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public static void pwdprompt() {
		//Keret felépítése
		JFrame pwdprmt = new JFrame("Password prompt");
		pwdprmt.setPreferredSize(new Dimension(500, 250));
		pwdprmt.setResizable(false);
		pwdprmt.setLocationRelativeTo(null);
		pwdprmt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pwdprmt.setLayout(null);
		
		JLabel label = new JLabel("Jelszó: ");
		label.setBounds(140,75, 150,30);
		label.setFont(new Font("Ubuntu", Font.BOLD, 15));
		JPasswordField password = new JPasswordField();
		password.setBounds(200,75, 150,30);
		password.setFont(new Font("Ubuntu", Font.BOLD, 15));
		JButton submit = new JButton("Belépés");
		submit.setBounds(0,180, 484,30);
		submit.setFont(new Font("Ubuntu", Font.BOLD, 15));
		
		//Elemek ablakhoz adása
		pwdprmt.add(label);
		pwdprmt.add(password);
		pwdprmt.add(submit);
		
		//Ablak lezárása/összeállítása
		pwdprmt.pack();
		pwdprmt.setLocationRelativeTo(null);
		pwdprmt.setVisible(true);
		
		//ActioListener
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String predefinatedpassword = "Pa2sw0rd";
				String pwd = String.valueOf(password.getPassword());
				if(predefinatedpassword.equals(pwd)) {
					Color color=new Color(129,255,122);
					password.setBackground(color);
					if(true)
					sleep();
					pwdprmt.setVisible(false);
					headandties();
				}else {
					Color color=new Color(255,61,81);
					password.setBackground(color);
					password.setText("");
				}
			}
		});
	}
	
	public static void headandties() {
		//Keret felépítése
		JFrame hat = new JFrame("Flip coin");
		hat.setPreferredSize(new Dimension(500, 250));
		hat.setResizable(false);
		hat.setLocationRelativeTo(null);
		hat.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		hat.setLayout(null);
		
		//Ablak elemek
		JButton flip = new JButton("Érme feldobása");
		flip.setBounds(0,0, 484,211);
		flip.setFont(new Font("Ubuntu", Font.BOLD, 15));
		JLabel headorties = new JLabel("", SwingConstants.CENTER);
		headorties.setBounds(0,0, 484,211);
		headorties.setFont(new Font("Ubuntu", Font.BOLD, 15));
		JButton newflip = new JButton("Új érme dobás");
		newflip.setBounds(0,180, 484,30);
		newflip.setFont(new Font("Ubuntu", Font.BOLD, 15));
		newflip.setVisible(false);
		
		
		//Elemek ablakhoz adása
		hat.add(headorties);
		hat.add(flip);
		hat.add(newflip);
		
		//Ablak lezárása/összeállítása
		hat.pack();
		hat.setLocationRelativeTo(null);
		hat.setVisible(true);
		
		//ActioListener
		flip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				flip.setVisible(false);
				Random r = new Random();
				int min = 0;
				int max = 100;
				int rnd = r.nextInt(max-min) + min;
				if(rnd<=50) {
					headorties.setText("FEJ");
				}else {
					headorties.setText("ÍRÁS");
				}
				newflip.setVisible(true);
			}
		});
		
		newflip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				headorties.setText("");
				flip.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		pwdprompt();
	}

}
