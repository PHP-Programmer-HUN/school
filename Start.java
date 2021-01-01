package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Start {
	static String player1name = "";
	static int player1dicenum = 0;
	static String player2name = "";
	static int player2dicenum = 0;
	static int p1rounds = 10;
	static int p2rounds = 10;
	static int p1hp = 70;
	static int p2hp = 80;
	static boolean active = true;
	static int roundcounter = 1;
	
	public static void settings() throws MalformedURLException {
		//Settings_icon
		String hatter = "https://i.ibb.co/3kdPn2j/background.png";				
		String hos1 = "https://i.ibb.co/GvScvGw/hero1.png";						
		String hos1details = "https://i.ibb.co/p2Z7HTd/70.png";		
		String hos2 = "https://i.ibb.co/7k4xPq0/hero2.png";	
		String hos2details = "https://i.ibb.co/TcYrqrx/80.png";
		String dice = "https://i.ibb.co/17GKF64/dice.png";
		String nextimage = "https://i.ibb.co/gV4r7sH/next.png";
		String startbtnimg = "https://i.ibb.co/DfsDqsk/start.png";
		String retryimg = "https://i.ibb.co/xFpWFZv/retry.png";
		
		//Frame alap beállítások
		JFrame game = new JFrame("Játék beállítása...");
		game.setPreferredSize(new Dimension(1000, 600));
		game.setResizable(false);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		game.setLayout(null);
		
		//Images from WEB
		Image bg = null;
		Image nxt = null;
		Image dc = null;
		Image h1 = null;
		Image h1d = null;
		Image h2 = null;
		Image h2d = null;
		Image sb = null;
		Image re = null;
				
		try {
			bg = ImageIO.read(new URL(hatter));
			h1 = ImageIO.read(new URL(hos1));
			h1d = ImageIO.read(new URL(hos1details));
			h2 = ImageIO.read(new URL(hos2));
			h2d = ImageIO.read(new URL(hos2details));
			dc = ImageIO.read(new URL(dice));
			nxt = ImageIO.read(new URL(nextimage));
			sb = ImageIO.read(new URL(startbtnimg));
			re = ImageIO.read(new URL(retryimg));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//Képek méretezése
		Image bgimg = bg.getScaledInstance(1000, 600,  java.awt.Image.SCALE_SMOOTH);
		Image h1img = h1.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
		Image h1dimg = h1d.getScaledInstance(186, 128,  java.awt.Image.SCALE_SMOOTH);
		Image h2img = h2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
		Image h2dimg = h2d.getScaledInstance(186, 128,  java.awt.Image.SCALE_SMOOTH);
		Image dicebase = dc.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Image nextimagebtn = nxt.getScaledInstance(233, 238, java.awt.Image.SCALE_SMOOTH);
		Image startbtn = sb.getScaledInstance(301, 136, java.awt.Image.SCALE_SMOOTH);
		Image retry = re.getScaledInstance(301, 136, java.awt.Image.SCALE_SMOOTH);
		
		//Elemek létrehozása és beállítása
		JLabel hatterimg = new JLabel(new ImageIcon(bgimg));
		hatterimg.setVisible(true);
		
		JLabel nop1L = new JLabel("1. Játékos neve:", SwingConstants.CENTER);
		JTextField nop1T = new JTextField("Player 1");
		JLabel hos1img = new JLabel(new ImageIcon(h1img));
		JLabel hos1det = new JLabel(new ImageIcon(h1dimg));
		
		JLabel nop2L = new JLabel("2. Játékos neve:", SwingConstants.CENTER);
		JTextField nop2T = new JTextField("Player 2");
		JLabel hos2img = new JLabel(new ImageIcon(h2img));
		JLabel hos2det = new JLabel(new ImageIcon(h2dimg));
		
		JButton next = new JButton(new ImageIcon(nextimagebtn));
		next.setContentAreaFilled( false );
		next.setBorder( null );
		next.setVisible(true);
		
		JButton start = new JButton(new ImageIcon(startbtn));
		start.setContentAreaFilled( false );
		start.setBorder( null );
		start.setVisible(false);
		
		JButton retry_btn = new JButton(new ImageIcon(retry));
		retry_btn.setContentAreaFilled( false );
		retry_btn.setBorder( null );
		retry_btn.setVisible(false);
		
		URL url = new URL("https://i.ibb.co/zVk3WYh/dice.gif");
		JButton throwdice = new JButton(new ImageIcon(url));
		throwdice.setContentAreaFilled( false );
		throwdice.setBorder( null );
		throwdice.setVisible(false);
		
		JLabel p1diceT = new JLabel("Dobott érték:");
		JLabel p1dice = new JLabel(new ImageIcon(dicebase));
		JLabel p1diceN = new JLabel("", SwingConstants.CENTER);
		p1diceT.setVisible(false);
		p1dice.setVisible(false);
		p1diceN.setVisible(false);
		
		JLabel p2diceT = new JLabel("Dobott érték:");
		JLabel p2dice = new JLabel(new ImageIcon(dicebase));
		JLabel p2diceN = new JLabel("", SwingConstants.CENTER);
		p2diceT.setVisible(false);
		p2dice.setVisible(false);
		p2diceN.setVisible(false);
		
		JLabel playerthrowL = new JLabel("Player 1 dob a kockával:", SwingConstants.CENTER);
		playerthrowL.setVisible(false);
		
		JLabel mby = new JLabel("Coded by: Varga Levente");

		
		//Elemek elhelyezkedése
		hatterimg.setBounds(0,0,1000,600);

		nop1L.setBounds(85,50, 180,25);
		nop1T.setBounds(90,80, 180,25);
		hos1img.setBounds(105,120, 150,150);
		hos1det.setBounds(90,280, 186, 128);
		p1diceT.setBounds(125,230, 186, 128);
		p1dice.setBounds(90,300, 186, 128);
		p1diceN.setBounds(90,300, 186, 128);
		
		nop2L.setBounds(690,50, 180,25);
		nop2T.setBounds(690,80, 180,25);
		hos2img.setBounds(710,120, 150,150);
		hos2det.setBounds(690,280, 186, 128);
		p2diceT.setBounds(725,230, 186, 128);
		p2dice.setBounds(690,300, 186, 128);
		p2diceN.setBounds(690,300, 186, 128);
		
		playerthrowL.setBounds(285,35, 400,350);
		
		next.setBounds(380,200, 233,238);
		start.setBounds(340,240, 301,136);
		retry_btn.setBounds(340,240, 301,136);
		throwdice.setBounds(370,200, 233,238);
		
		mby.setBounds(5,535, 250, 22);
		
		//Szövegek formázása
		nop1L.setFont(new Font("Ubuntu", Font.BOLD, 20));
		nop1L.setForeground(Color.BLACK);
		
		nop2L.setFont(new Font("Ubuntu", Font.BOLD, 20));
		nop2L.setForeground(Color.BLACK);

		p1diceT.setFont(new Font("Ubuntu", Font.BOLD, 20));
		p1diceT.setForeground(Color.BLACK);

		p2diceT.setFont(new Font("Ubuntu", Font.BOLD, 20));
		p2diceT.setForeground(Color.BLACK);
		
		p1diceN.setFont(new Font("Ubuntu", Font.BOLD, 25));
		p1diceN.setForeground(Color.BLACK);
		
		p2diceN.setFont(new Font("Ubuntu", Font.BOLD, 25));
		p2diceN.setForeground(Color.BLACK);
		
		playerthrowL.setFont(new Font("Ubuntu", Font.BOLD, 25));
		playerthrowL.setForeground(Color.BLACK);
		
		mby.setFont(new Font("Ubuntu", Font.BOLD, 16));
		mby.setForeground(Color.BLACK);
		
		//Elemek fram-hez adása
		game.add(mby);
		game.add(playerthrowL);
		game.add(p1diceN);
		game.add(p2diceN);
		game.add(nop1L);
		game.add(nop2L);
		game.add(nop1T);
		game.add(nop2T);
		game.add(p1dice);
		game.add(p2dice);
		game.add(p1diceT);
		game.add(p2diceT);
		game.add(hos1img);
		game.add(hos1det);
		game.add(hos2img);
		game.add(hos2det);
		game.add(next);
		game.add(retry_btn);
		game.add(start);
		game.add(throwdice);
		game.add(hatterimg);
		
		
		//Ablak összeállítása
		game.pack();
		game.setLocationRelativeTo(null);
		game.setVisible(true);
		
		//Gomb actionök
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				next.setVisible(false);
				nop1T.setVisible(false);
				nop2T.setVisible(false);
				hos1det.setVisible(false);
				hos2det.setVisible(false);
				
				
				nop1L.setText(nop1T.getText());
				nop1L.setBounds(85,80, 180,25);
				
				nop2L.setText(nop2T.getText());
				nop2L.setBounds(690,80, 180,25);
				
				throwdice.setVisible(true);
				playerthrowL.setVisible(true);
				
				String name = nop1T.getText();
				playerthrowL.setText(name+" dob a kockával:");
			}
		});
		throwdice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rnd = (int)(100.0 * Math.random());
				if(p1diceN.getText().equals("")) {
					p1diceT.setVisible(true);
					p1dice.setVisible(true);
					p1diceN.setVisible(true);
					String name = nop2T.getText();
					playerthrowL.setText(name+" dob a kockával:");
					p1diceN.setText(Integer.toString(rnd));							//rnd
				}else {
					p2diceT.setVisible(true);
					p2dice.setVisible(true);
					p2diceN.setVisible(true);
					p2diceN.setText(Integer.toString(rnd));							//rnd
					
					throwdice.setVisible(false);
					int p1num = Integer.parseInt(p1diceN.getText());
					player1dicenum = p1num;
					int p2num = Integer.parseInt(p2diceN.getText());
					player2dicenum = p2num;
					String p1name = nop1T.getText();
					player1name = nop1T.getText();
					String p2name = nop2T.getText();
					player2name = nop2T.getText();
					
					playerthrowL.setBounds(285,30, 400,350);
					if(p1num>p2num) {
						playerthrowL.setText("A játékot "+p1name+" kezdi.");
						start.setVisible(true);
					}else if(p2num>p1num) {
						playerthrowL.setText("A játékot "+p2name+" kezdi.");
						start.setVisible(true);
					}else {
						playerthrowL.setText("A dobás eredménye megegyezik.");
						retry_btn.setVisible(true);
					}
				}
				
			}
		});
		
		retry_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				retry_btn.setVisible(false);
				throwdice.setVisible(true);
				p1diceN.setText("");
				p2diceN.setText("");
				playerthrowL.setText(nop1T.getText()+" dob a kockával:");
				
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setVisible(false);
				game();
			}
		});
		
	}
	
	public static void game() {
		//Gamelog start
		while(active==true) {
			active = false;
			try {
				BufferedWriter gamelog = new BufferedWriter(new FileWriter("gamelog.log"));
				gamelog.write("****************************************\n");
				gamelog.write("Első játékos: "+player1name+"\n");
				gamelog.write(player1name+" dobott értéke: "+player1dicenum+"\n");
				gamelog.write("****************************************\n");
				gamelog.write("Második játékos: "+player2name+"\n");
				gamelog.write(player2name+" dobott értéke: "+player2dicenum+"\n");
				gamelog.write("****************************************\n\n");
				gamelog.write("Játék történései:\n");
			
			
				//Settings_icon
				String hatter = "https://i.ibb.co/3kdPn2j/background.png";					//Alap kép
				String hos1 = "https://i.ibb.co/GvScvGw/hero1.png";							//Sikeres belépés kép
				String hos2 = "https://i.ibb.co/7k4xPq0/hero2.png";							//Sikertelen belépés kép
				String hitimg = "https://i.ibb.co/4FMGZBf/hit.png";
				String ngame = "https://i.ibb.co/jLNvnjZ/ngame.png";
	
				
				//Keret felépítése
				JFrame game = new JFrame("Játék folyamatban...");
				game.setPreferredSize(new Dimension(1000, 600));
				game.setResizable(false);
				game.setLocationRelativeTo(null);
				game.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				game.setLayout(null);
				
				
				//Images from WEB
				Image bg = null;
				Image hero1 = null;
				Image hero2 = null;
				Image hitim = null;
				Image ngameimg = null;
						
				try {
					bg = ImageIO.read(new URL(hatter));
					hero1 = ImageIO.read(new URL(hos1));
					hero2 = ImageIO.read(new URL(hos2));
					hitim = ImageIO.read(new URL(hitimg));
					ngameimg = ImageIO.read(new URL(ngame));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
				//Képek formázása
				Image bgimg = bg.getScaledInstance(1000, 600,  java.awt.Image.SCALE_SMOOTH);
				Image h1img = hero1.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
				Image h2img = hero2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
				Image hit = hitim.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
				Image newgame = ngameimg.getScaledInstance(264, 105,  java.awt.Image.SCALE_SMOOTH);
				
				
				//Elemek létrehozása
				JLabel hatterimg = new JLabel(new ImageIcon(bgimg));
				JLabel hos1img = new JLabel(new ImageIcon(h1img));
				JLabel hos2img = new JLabel(new ImageIcon(h2img));
				JProgressBar hero1hp;
				hero1hp = new JProgressBar();
				hero1hp.setMinimum(0);
				hero1hp.setMaximum(70);
				hero1hp.setValue(70);
				hero1hp.setStringPainted(true);
				hero1hp.setForeground(Color.red);
				JProgressBar hero2hp;
				hero2hp = new JProgressBar();
				hero2hp.setMinimum(0);
				hero2hp.setMaximum(80);
				hero2hp.setValue(80);
				hero2hp.setStringPainted(true);
				hero2hp.setForeground(Color.red);
				JLabel playerone = new JLabel(player1name, SwingConstants.CENTER);
				JLabel playertwo = new JLabel(player2name, SwingConstants.CENTER);
				
				JLabel win = new JLabel("", SwingConstants.CENTER);
				win.setVisible(true);
				
				JButton p1hit = new JButton(new ImageIcon(hit));
				p1hit.setContentAreaFilled( false );
				p1hit.setBorder( null );
				p1hit.setVisible(false);
				JButton p2hit = new JButton(new ImageIcon(hit));
				p2hit.setContentAreaFilled( false );
				p2hit.setBorder( null );
				p2hit.setVisible(false);
				
				JButton newgamebtn = new JButton(new ImageIcon(newgame));
				newgamebtn.setContentAreaFilled( false );
				newgamebtn.setBorder( null );
				newgamebtn.setVisible(false);
				
				if(player1dicenum>player2dicenum) {
					p1hit.setVisible(true);
				}else {
					p2hit.setVisible(true);
				}
				
				JLabel round = new JLabel("1. KÖR", SwingConstants.CENTER);
				JLabel mby = new JLabel("Coded by: Varga Levente");
				
				
				//Kép láthatóság
				hatterimg.setVisible(true);
				hos1img.setVisible(true);
				hos2img.setVisible(true);
				
				
				//Pozíciók beállítása
				win.setBounds(0,0, 990,400);
				hatterimg.setBounds(0,0, 1000,600);
				hos1img.setBounds(220,350, 150,150);
				hos2img.setBounds(600,350, 150,150);
				p1hit.setBounds(160,350, 150,150);
				p2hit.setBounds(650,350, 150,150);
				hero1hp.setBounds(200,310, 200,25);
				hero2hp.setBounds(570,310, 200,25);
				playerone.setBounds(198,280, 200,25);
				playertwo.setBounds(570,280, 200,25);
				round.setBounds(400,0, 150,40);
				mby.setBounds(5,535, 250, 22);
				newgamebtn.setBounds(350,215, 264,105);
				
				
				//Szöveg fotmázás
				playerone.setFont(new Font("Ubuntu", Font.BOLD, 20));
				playerone.setForeground(Color.BLACK);
				playertwo.setFont(new Font("Ubuntu", Font.BOLD, 20));
				playertwo.setForeground(Color.BLACK);
				round.setFont(new Font("Ubuntu", Font.BOLD, 22));
				round.setForeground(Color.BLACK);
				mby.setFont(new Font("Ubuntu", Font.BOLD, 16));
				mby.setForeground(Color.BLACK);
				win.setFont(new Font("Ubuntu", Font.BOLD, 32));
				win.setForeground(Color.BLACK);
				
				//Framhez adás
				game.add(newgamebtn);
				game.add(win);
				game.add(p1hit);
				game.add(p2hit);
				game.add(round);
				game.add(mby);
				game.add(playerone);
				game.add(playertwo);
				game.add(hero1hp);
				game.add(hero2hp);
				game.add(hos1img);
				game.add(hos2img);
				game.add(hatterimg);
				
				
				//Ablak lezárása/összeállítása
				game.pack();
				game.setLocationRelativeTo(null);
				game.setVisible(true);
		
				
				//Button actions
				p1hit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(player1dicenum<player2dicenum) {
							roundcounter++;
							round.setText(roundcounter+". KÖR");
						}
						String special = "";
						if (p1rounds>0) {
							int critchence = (int)(100.0 * Math.random());
							int misschence = (int)(100.0 * Math.random());
							Random p1r = new Random();
							int p1sebzes = p1r.nextInt(10-6) + 6;
							if(critchence<=30) {
								p1sebzes = p1sebzes+5;
								special += "CRIT (+5) ";
							}
							if(misschence<=20) {
								p1sebzes = 0;
								special += "MISS";
							}
							p2hp = p2hp-p1sebzes;
							hero2hp.setValue(p2hp);
							p1hit.setVisible(false);
							p2hit.setVisible(true);
							try {
								if(!special.equals("")) {
									gamelog.write("["+special+"]\n");
								}
								gamelog.write(player1name+" támadása: -"+p1sebzes+" | "+player2name+" élete lecsökkent: "+p2hp+"\n");
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							p1rounds--;
							if(p2hp<1) {
								p1hit.setVisible(false);
								p2hit.setVisible(false);
								win.setText(player1name+" nyerte a játékot!");
								newgamebtn.setVisible(true);
								try {
									gamelog.write("\n"+player1name+" nyerte a játékot!");
								} catch (IOException e2) {
									e2.printStackTrace();
								}
								try {
									gamelog.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}else {
								p1hit.setVisible(false);
								p2hit.setVisible(true);
							}
						}else {
							p1hit.setVisible(false);
							p2hit.setVisible(false);
							win.setText("Döntetlen játszma!");
							newgamebtn.setVisible(true);
							try {
								gamelog.write("\nDöntetlen játszma!");
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							try {
								gamelog.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				
				p2hit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(player1dicenum>player2dicenum) {
							roundcounter++;
							round.setText(roundcounter+". KÖR");
						}
						String special = "";
						if (p2rounds>0) {
							int critchence = (int)(100.0 * Math.random());
							int misschence = (int)(100.0 * Math.random());
							Random p2r = new Random();
							int p2sebzes = p2r.nextInt(10-6) + 6;
							if(critchence<=30) {
								p2sebzes = p2sebzes+5;
								special += "CRIT (+5) ";
							}
							if(misschence<=20) {
								p2sebzes = 0;
								special += "MISS";
							}
							p1hp = p1hp-p2sebzes;
							try {
								if(!special.equals("")) {
									gamelog.write("["+special+"]\n");
								}
								gamelog.write(player2name+" támadása: -"+p2sebzes+" | "+player1name+" élete lecsökkent: "+p1hp+"\n");
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							hero1hp.setValue(p1hp);
							p2rounds--;
							if(p1hp<1) {
								p2hit.setVisible(false);
								p1hit.setVisible(false);
								win.setText(player2name+" nyerte a játékot!");
								newgamebtn.setVisible(true);
								try {
									gamelog.write("\n"+player2name+" nyerte a játékot!");
								} catch (IOException e2) {
									e2.printStackTrace();
								}
								try {
									gamelog.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}else {
								p2hit.setVisible(false);
								p1hit.setVisible(true);
							}
						}else {
							p1hit.setVisible(false);
							p2hit.setVisible(false);
							win.setText("Döntetlen játszma!");
							newgamebtn.setVisible(true);
							try {
								gamelog.write("\nDöntetlen játszma!");
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							try {
								gamelog.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				
				newgamebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						game.setVisible(false);
						try {
							active = true;
							settings();
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		try {
			settings();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//game();
	}
}