package hm;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;

public class Main implements ActionListener{
	
	public Main(){
		//Keret felépítése
		JFrame win = new JFrame("Hüvelyk Matyi árkalkulátora");
		win.setPreferredSize(new Dimension(600, 450));
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		win.setLayout(null);
		
		//Sorok definiálása
		String currency = "Ft";
		Sor s1=new Sor("Rózsa","250","Hétfő");
		Sor s2=new Sor("Tulipán","160","Kedd");
		Sor s3=new Sor("Nárcisz","220","Szerda");
		Sor s4=new Sor("Liliom","350","Csütörtök");
		Sor s5=new Sor("Nefeleics","120","Péntek");
		Sor s6=new Sor("Mergaréta","180","Szombat");
		Sor s7=new Sor("Szegfű","90","Vasárnap");
		
		ArrayList<Sor> al=new ArrayList<Sor>();
		
        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        al.add(s5);
        al.add(s6);
        al.add(s7);
        
        Iterator<Sor> itr=al.iterator();
        
        //Prices
        int[] prices = new int[]{250, 160, 220, 250, 120, 180, 90}; 
        
        //JFormattedTextField (Number formatted text fields)
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); 		//optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); 		//this is the key!!
		numberFormatter.setMinimum(0l); 				//Optional
		
		//Elemek létrehozása
        Sor st=(Sor)itr.next();
		JLabel jl_l1 = new JLabel(st.virag);
		JFormattedTextField lt_t1 = new JFormattedTextField(numberFormatter);
		lt_t1.setText(st.ar);
		JLabel jl_c1 = new JLabel(currency);
		JButton jb_b1 = new JButton(st.hetnap);
		jb_b1.addActionListener(this);
		
		st=(Sor)itr.next();
		JLabel jl_l2 = new JLabel(st.virag);
		JFormattedTextField lt_t2 = new JFormattedTextField(numberFormatter);
		lt_t2.setText(st.ar);
		JLabel jl_c2 = new JLabel(currency);
		JButton jb_b2 = new JButton(st.hetnap);
		jb_b2.addActionListener(this);
		
		st=(Sor)itr.next();
		JLabel jl_l3 = new JLabel(st.virag);
		JFormattedTextField lt_t3 = new JFormattedTextField(numberFormatter);
		lt_t3.setText(st.ar);
		JLabel jl_c3 = new JLabel(currency);
		JButton jb_b3 = new JButton(st.hetnap);
		jb_b3.addActionListener(this);
		
		st=(Sor)itr.next();
		JLabel jl_l4 = new JLabel(st.virag);
		JFormattedTextField lt_t4 = new JFormattedTextField(numberFormatter);
		lt_t4.setText(st.ar);
		JLabel jl_c4 = new JLabel(currency);
		JButton jb_b4 = new JButton(st.hetnap);
		jb_b4.addActionListener(this);
		
		st=(Sor)itr.next();
		JLabel jl_l5 = new JLabel(st.virag);
		JFormattedTextField lt_t5 = new JFormattedTextField(numberFormatter);
		lt_t5.setText(st.ar);
		JLabel jl_c5 = new JLabel(currency);
		JButton jb_b5 = new JButton(st.hetnap);
		jb_b5.addActionListener(this);
		
		st=(Sor)itr.next();
		JLabel jl_l6 = new JLabel(st.virag);
		JFormattedTextField lt_t6 = new JFormattedTextField(numberFormatter);
		lt_t6.setText(st.ar);
		JLabel jl_c6 = new JLabel(currency);
		JButton jb_b6 = new JButton(st.hetnap);
		jb_b6.addActionListener(this);
		
		st=(Sor)itr.next();
		JLabel jl_l7 = new JLabel(st.virag);
		JFormattedTextField lt_t7 = new JFormattedTextField(numberFormatter);
		lt_t7.setText(st.ar);
		JLabel jl_c7 = new JLabel(currency);
		JButton jb_b7 = new JButton(st.hetnap);
		jb_b7.addActionListener(this);
		
		JButton jb_s1 = new JButton("Beállítás");
		JButton jb_s2 = new JButton("Melyik a legolcsóbb?");
		JButton jb_s3 = new JButton("Alkalmaz");
		JButton jb_s4 = new JButton("Kilépés");
		
		JLabel jl_sum = new JLabel("Összesen");
		JTextField jt_sum = new JTextField("");
		JLabel jl_sum_currency = new JLabel(currency);
		
		//Elem helyek meghatározása
		int lb_v = 30;
		int step = 50;
		jl_l1.setBounds(25,lb_v, 70,15);
		lt_t1.setBounds(100,lb_v-4, 100,25);
		jl_c1.setBounds(203,lb_v, 10,15);
		jb_b1.setBounds(240,lb_v-4, 100,25);
		
		lb_v = lb_v+step;
		jl_l2.setBounds(25,lb_v, 70,15);
		lt_t2.setBounds(100,lb_v-4, 100,25);
		jl_c2.setBounds(203,lb_v, 10,15);
		jb_b2.setBounds(240,lb_v-4, 100,25);
		jl_sum.setBounds(360,lb_v-4, 100,25);
		
		lb_v = lb_v+step;
		jl_l3.setBounds(25,lb_v, 70,15);
		lt_t3.setBounds(100,lb_v-4, 100,25);
		jl_c3.setBounds(203,lb_v, 10,15);
		jb_b3.setBounds(240,lb_v-4, 100,25);
		jt_sum.setBounds(360,lb_v-10, 100,35);
		jl_sum_currency.setBounds(470,lb_v-10, 100,35);
		
		lb_v = lb_v+step;
		jl_l4.setBounds(25,lb_v, 70,15);
		lt_t4.setBounds(100,lb_v-4, 100,25);
		jl_c4.setBounds(203,lb_v, 10,15);
		jb_b4.setBounds(240,lb_v-4, 100,25);
		
		lb_v = lb_v+step;
		jl_l5.setBounds(25,lb_v, 70,15);
		lt_t5.setBounds(100,lb_v-4, 100,25);
		jl_c5.setBounds(203,lb_v, 10,15);
		jb_b5.setBounds(240,lb_v-4, 100,25);
		
		lb_v = lb_v+step;
		jl_l6.setBounds(25,lb_v, 70,15);
		lt_t6.setBounds(100,lb_v-4, 100,25);
		jl_c6.setBounds(203,lb_v, 10,15);
		jb_b6.setBounds(240,lb_v-4, 100,25);
		
		lb_v = lb_v+step;
		jl_l7.setBounds(25,lb_v, 70,15);
		lt_t7.setBounds(100,lb_v-4, 100,25);
		jl_c7.setBounds(203,lb_v, 10,15);
		jb_b7.setBounds(240,lb_v-4, 100,25);
		
		lb_v = lb_v+step;
		jb_s1.setBounds(25,lb_v, 100,25);
		jb_s2.setBounds(150,lb_v, 155,25);
		jb_s3.setBounds(150+155+25,lb_v, 100,25);
		jb_s4.setBounds(150+155+25+100+30,lb_v, 100,25);

		//DisableTextField
		lt_t1.setEditable(false);
		lt_t2.setEditable(false);
		lt_t3.setEditable(false);
		lt_t4.setEditable(false);
		lt_t5.setEditable(false);
		lt_t6.setEditable(false);
		lt_t7.setEditable(false);
		
		jt_sum.setEditable(false);
		
		//Elemek formázása
		lt_t1.setHorizontalAlignment(JTextField.RIGHT);
		lt_t2.setHorizontalAlignment(JTextField.RIGHT);
		lt_t3.setHorizontalAlignment(JTextField.RIGHT);
		lt_t4.setHorizontalAlignment(JTextField.RIGHT);
		lt_t5.setHorizontalAlignment(JTextField.RIGHT);
		lt_t6.setHorizontalAlignment(JTextField.RIGHT);
		lt_t7.setHorizontalAlignment(JTextField.RIGHT);
		
		jl_sum.setFont(new Font("Ubuntu", Font.BOLD, 15));
		jl_sum_currency.setFont(new Font("Ubuntu", Font.BOLD, 15));
		
		//Ablakhoz adás
		win.add(jl_l1);
		win.add(jl_l2);
		win.add(jl_l3);
		win.add(jl_l4);
		win.add(jl_l5);
		win.add(jl_l6);
		win.add(jl_l7);
		
		win.add(lt_t1);
		win.add(lt_t2);
		win.add(lt_t3);
		win.add(lt_t4);
		win.add(lt_t5);
		win.add(lt_t6);
		win.add(lt_t7);
		
		win.add(jl_c1);
		win.add(jl_c2);
		win.add(jl_c3);
		win.add(jl_c4);
		win.add(jl_c5);
		win.add(jl_c6);
		win.add(jl_c7);
		
		win.add(jb_b1);
		win.add(jb_b2);
		win.add(jb_b3);
		win.add(jb_b4);
		win.add(jb_b5);
		win.add(jb_b6);
		win.add(jb_b7);
		
		win.add(jb_s1);
		win.add(jb_s2);
		win.add(jb_s3);
		win.add(jb_s4);
		
		win.add(jl_sum);
		win.add(jt_sum);
		win.add(jl_sum_currency);
		
		//Ablak lezárása/összeállítása
		win.pack();
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		
		jb_s1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager.put("OptionPane.noButtonText", "NEM"); UIManager.put("OptionPane.yesButtonText", "IGEN");
				int input = JOptionPane.showConfirmDialog(null, "Biztosan meg akarod változtatni az árakat?", "Figyelmeztetés", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (input == JOptionPane.YES_OPTION) {
					lt_t1.setEditable(true);
					lt_t2.setEditable(true);
					lt_t3.setEditable(true);
					lt_t4.setEditable(true);
					lt_t5.setEditable(true);
					lt_t6.setEditable(true);
					lt_t7.setEditable(true);
					jb_b1.setEnabled(false);
					jb_b2.setEnabled(false);
					jb_b3.setEnabled(false);
					jb_b4.setEnabled(false);
					jb_b5.setEnabled(false);
					jb_b6.setEnabled(false);
					jb_b7.setEnabled(false);
					jb_s1.setEnabled(false);
					jb_s2.setEnabled(false);
					JLabel msgLabel = new JLabel("Mostantól változtathatóak az árak. \n Az új árak alkalmazásához kattintson az alkalmaz gombra!", JLabel.CENTER);
					JOptionPane.showMessageDialog(null, msgLabel, "Információ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		jb_s3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lt_t1.setEditable(false);
				lt_t2.setEditable(false);
				lt_t3.setEditable(false);
				lt_t4.setEditable(false);
				lt_t5.setEditable(false);
				lt_t6.setEditable(false);
				lt_t7.setEditable(false);
				jb_b1.setEnabled(true);
				jb_b2.setEnabled(true);
				jb_b3.setEnabled(true);
				jb_b4.setEnabled(true);
				jb_b5.setEnabled(true);
				jb_b6.setEnabled(true);
				jb_b7.setEnabled(true);
				jb_s1.setEnabled(true);
				jb_s2.setEnabled(true);
				prices[0] = Integer.parseInt(lt_t1.getText());
				prices[1] = Integer.parseInt(lt_t2.getText());
				prices[2] = Integer.parseInt(lt_t3.getText());
				prices[3] = Integer.parseInt(lt_t4.getText());
				prices[4] = Integer.parseInt(lt_t5.getText());
				prices[5] = Integer.parseInt(lt_t6.getText());
				prices[6] = Integer.parseInt(lt_t7.getText());
			}
		});
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	public void actionPerformed(ActionEvent e){
		switch(e.getActionCommand()){
			case "Hétfő":
				System.out.println("Hétfő");
				break;
			case "Kedd":
				System.out.println("Kedd");
				break;
			case "Szerda":
				System.out.println("Szerda");
				break;
			case "Csütörtök":
				System.out.println("Csütörtök");
				break;
			case "Péntek":
				System.out.println("Péntek");
				break;
			case "Szombat":
				System.out.println("Szombat");
				break;
			case "Vasárnap":
				System.out.println("Vasárnap");
				break;
		}
	}
}

class Sor{  
    String virag;  
    String ar;  
    String hetnap;  
    Sor(String virag,String ar, String hetnap){  
        this.virag=virag;  
        this.ar=ar;  
        this.hetnap=hetnap;  
    }  
} 
