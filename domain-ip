package domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class Megoldas {

	public static String domain(String domain, int level) {
		String ret = "";
		String line = domain;
		int helper = domain.length() - domain.replace(".", "").length();
		
		if(helper == 2) {
			line = "nincs.nincs."+domain;
		}else if(helper == 3) {
			line = "nincs."+domain;
		}
		
		if (level == 1){
			ret = line.split("\\.")[4];
        }
        if (level == 2){
        	ret = line.split("\\.")[3];
        }
        if (level == 3){
        	ret = line.split("\\.")[2];
        }
        if (level == 4){
        	ret = line.split("\\.")[1];
        }
        if (level == 5){
        	ret = line.split("\\.")[0];
        }
        return ret;
	}

	public static void main(String[] args) {
		ArrayList<Adatok> data =new ArrayList<Adatok>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("csudh.txt"), StandardCharsets.UTF_8))) {
			String str;
			reader.readLine();
			while ((str = reader.readLine()) != null) {
		    	data.add(new Adatok(str));
		    }
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("3. Feladat: Domainek száma: "+data.size());
		
		System.out.println("5. Feladat: Az első domain felépítése:");
		System.out.println("\t1. szint: "+domain(data.get(0).domain, 1));
		System.out.println("\t2. szint: "+domain(data.get(0).domain, 2));
		System.out.println("\t3. szint: "+domain(data.get(0).domain, 3));
		System.out.println("\t4. szint: "+domain(data.get(0).domain, 4));
		System.out.println("\t5. szint: "+domain(data.get(0).domain, 5));
		
		try {
	    	FileWriter file = new FileWriter("table.html");
	    	file.write("<table><tr><th style='text-align: left'> Ssz</th><th style='text-align: left'> Host domain neve</th><th style='text-align: left'> Host IP címe</th><th style='text-align: left'> 1. szint</th><th style='text-align: left'> 2. szint</th><th style='text-align: left'> 3. szint</th><th style='text-align: left'> 4. szint</th><th style='text-align: left'> 5. szint</th></tr>");
	    	Iterator<Adatok> t9=data.iterator();
	    	int counter = 1;
			while(t9.hasNext()){
				Adatok st=(Adatok)t9.next();
				file.write("<tr><th style='text-align: left'>"+counter+".</th><td>"+st.domain+"</td><td>"+st.ip+"</td><td>"+domain(st.domain, 1)+"</td><td>"+domain(st.domain, 2)+"</td><td>"+domain(st.domain, 3)+"</td><td>"+domain(st.domain, 4)+"</td><td>"+domain(st.domain, 5)+"</td>");
				counter++;
			}
			file.write("</table>");
	    	file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Adatok{  
    String domain;
    String ip;
    Adatok(String input){  
        this.domain=input.split(";")[0];
        this.ip=input.split(";")[1];
    } 
} 
