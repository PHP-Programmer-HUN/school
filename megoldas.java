package mohegy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class megoldas {
	public static double labvalt(double meter) {
		double lab = meter*3.280839895;
		return lab;
	}
	
	public static String tizedes(double meter) {
		double lab = meter*3.280839895;
		DecimalFormat decimalFormat = new DecimalFormat("0.#");
		String result = decimalFormat.format(Double.valueOf(lab));
		return result;
	}
	public static void main(String[] args) {
		//2. Feladat
		ArrayList<Datalist> data =new ArrayList<Datalist>();
		ArrayList<String> hegyeg = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("hegyekMo.txt"), StandardCharsets.UTF_8))) {
			String str;
			reader.readLine();
		    while ((str = reader.readLine()) != null) {
		    	//Fájl hiba miatt az összed "ő" karakter kérdőjel ként kerül beolvasásra
		    	str=str.replaceAll("\\?", "ő");
		    	data.add(new Datalist(str));
		    	hegyeg.add(str.split(";")[1]);
		    }
		    reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//3. Feladat
		System.out.println("3. Feladat: Hegycsúcsok száma: "+data.size());
		
		//4. Feladat
		double sum = 0;
		Iterator<Datalist> t4=data.iterator();
		while(t4.hasNext()){
			Datalist st=(Datalist)t4.next();
			sum=sum+st.magassag;
		}
		String avg = String.valueOf(sum/data.size()).replaceAll("\\.", "\\,");
		System.out.println("4. Feladat: Hegycsúcsok átlagos magassága: "+avg);
		
		//5. Feladat
		String legmagasabb_nev = "";
		String legmagasabb_hegyseg = "";
		int legmagasabb_meter = 0;
		Iterator<Datalist> t5=data.iterator();
		while(t5.hasNext()){
			Datalist st=(Datalist)t5.next();
			if (st.magassag>legmagasabb_meter) {
				legmagasabb_nev = st.csucsnev;
				legmagasabb_hegyseg = st.hegyseg;
				legmagasabb_meter = (int) Math.round(st.magassag);
			}
		}
		System.out.println("5. Feladat: A legmagasabb hegycsúcs adatai:");
		System.out.println("\tNév: "+legmagasabb_nev);
		System.out.println("\tHegyseg: "+legmagasabb_hegyseg);
		System.out.println("\tMagasság: "+legmagasabb_meter+" m");
		
		//6. Feladat
		System.out.print("6. Feladat: Kérek egy magasságot: ");
		Scanner userkey = new Scanner(System.in);
		double usr = Double.parseDouble(userkey.nextLine());
		userkey.close();
		boolean vane = false;
		Iterator<Datalist> t6=data.iterator();
		while(t6.hasNext()){
			Datalist st=(Datalist)t6.next();
			if (vane == false && st.magassag>usr && st.hegyseg.toLowerCase().equals("börzsöny")) {
				vane = true;
				break;
			}
		}
		System.out.println(vane?"\tVan "+(int) Math.round(usr)+"m-nél magasabb hegycsúgy a Börzsönyben!":"\tNincs "+(int) Math.round(usr)+"m-nél magasabb hegycsúgy a Börzsönyben!");
		
		//7. Feladat
		int magasabb = 0;
		Iterator<Datalist> t7=data.iterator();
		while(t7.hasNext()){
			Datalist st=(Datalist)t7.next();
			if(labvalt(st.magassag)>3000) {
				magasabb++;
			}
		}
		System.out.println("7. Feladat: 3000 lábnál magasabb hegycsúcsok száma: "+magasabb);
		
		//8. Feladat
		System.out.println("8. Feladat: Hegység statisztika");
		Set<String> set = new HashSet<String>(hegyeg);
	    for (String r : set) {
	        System.out.println("\t"+r + " - " + Collections.frequency(hegyeg, r)+" db");
	    }
	    
	    //9. Feladat
	    System.out.println("9. Feladat: bukk-videk.txt");
	    try {
	    	FileWriter file = new FileWriter("bukk-videk.txt");
	    	file.write("Hegycsúcs neve;Magasság láb");
	    	Iterator<Datalist> t9=data.iterator();
			while(t9.hasNext()){
				Datalist st=(Datalist)t9.next();
				if(st.hegyseg.toLowerCase().equals("bükk-vidék")) {
					
					file.write("\n"+st.csucsnev+";"+tizedes(st.magassag));
				}
			}
	    	file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Datalist{  
    String csucsnev;
    String hegyseg;
    double magassag;
    Datalist(String input){  
        this.csucsnev=input.split(";")[0];
        this.hegyseg=input.split(";")[1];;
        this.magassag=Double.parseDouble(input.split(";")[2]);
    }  
} 