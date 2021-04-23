import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Megoldas {

	public static void main(String[] args) {
		ArrayList<Datalist> al=new ArrayList<Datalist>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		
		//File input and set Charset to UFT-8
		try (FileInputStream fis = new FileInputStream("EUcsatlakozas.txt"); InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isr)) {
			String str;
			//Fill Lists
			while ((str = reader.readLine()) != null) {
				al.add(new Datalist(str.split(";")[0],str.split(";")[1]));
			    	years.add(Integer.parseInt(str.split(";")[1].split("\\.")[0]));
			}
			    
			    Iterator<Datalist> itr=al.iterator();
			    
			    //Helper variables
			    int count_join = 0;
			    String hu_join_date = "";
			    boolean join_may = false;
			    int join_last_date = 0;
			    String join_last_cname = "";
				
			    //Main cycle
			    while(itr.hasNext()){  
			    	Datalist st=(Datalist)itr.next();
			    	if (st.year == 2007) {
			    		count_join++;
				}
			    	if (st.cname.toLowerCase().equals("magyarország")) {
			    		hu_join_date = st.date;
			    	}
			    	if (st.month == 05) {
			    		join_may = true;
			    	}
			    	if (st.year > join_last_date) {
			    		join_last_date = st.year;
			    		join_last_cname = st.cname;
			    	}
			    }
			    
			    //End prints
			    System.out.println("3. feladat: EU tagállamainak száma: "+al.size()+" db");
			    System.out.println("4. feladat: 2007-ben "+count_join+" ország csatlakozott.");
			    System.out.println("5. feladat: Magyarország csatlakozásának dátuma: "+hu_join_date);
			    System.out.println(join_may ? "6. feladat: Májusban volt csatlakozás!" : "6. feladat: Májusban nem volt csatlakozás!");
			    System.out.println("7. feladat: Legutoljára csatlakozott ország: "+join_last_cname);
			    System.out.println("8. feladat: Statisztika");
			    //Simple HashSet and foreach for statistics
			    Set<Integer> set = new HashSet<Integer>(years);
			    for (Integer r : set) {
				//Pint every years in the file with Collections
			        System.out.println("\t"+r + " - " + Collections.frequency(years, r)+" ország");
			    }
			    
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

//Data class / split date
class Datalist{  
    String cname;	//Country name
    String date; 	//Full date 0000.00.00
    int year;		//Year 	0000
    int month;		//Month 00
    int day;		//Day 	00
    Datalist(String cname,String date){  
        this.cname=cname;
        this.date=date;
        this.year=Integer.parseInt(date.split("\\.")[0]);
        this.month=Integer.parseInt(date.split("\\.")[1]);
        this.day=Integer.parseInt(date.split("\\.")[2]);
    }  
} 
