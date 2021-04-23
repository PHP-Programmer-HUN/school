import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Megoldas {
	
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> years)
    {
  
        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();
  
        // Add the elements to set
        set.addAll(years);
  
        // Clear the list
        years.clear();
  
        // add the elements of set
        // with no duplicates to the list
        years.addAll(set);
  
        // return the list
        return years;
    }

	public static void main(String[] args) {
		ArrayList<Datalist> al=new ArrayList<Datalist>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		
		try (FileInputStream fis = new FileInputStream("EUcsatlakozas.txt");
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			    BufferedReader reader = new BufferedReader(isr)) {
			    String str;
			    while ((str = reader.readLine()) != null) {
			    	al.add(new Datalist(str.split(";")[0],str.split(";")[1]));
			    	years.add(Integer.parseInt(str.split(";")[1].split("\\.")[0]));
			    }
			    
			    Iterator itr=al.iterator();
			    			    
			    int count_join = 0;
			    String hu_join_date = "";
			    boolean join_may = false;
			    String join_ans = "";
			    int join_last_date = 0;
			    String join_last_cname = "";
			    while(itr.hasNext()){  
			    	Datalist st=(Datalist)itr.next();
			    	if (Integer.parseInt(st.date.split("\\.")[0]) == 2007) {
			    		count_join++;
					}
			    	if (st.cname.toLowerCase().equals("magyarország")) {
			    		hu_join_date = st.date;
			    	}
			    	if (Integer.parseInt(st.date.split("\\.")[1]) == 05) {
			    		join_may = true;
					}
			    	if(join_may == true) {
			    		join_ans = "Májusban volt csatlakozás!";
				    }else {
				    	join_ans = "Májusban nem volt csatlakozás!";
				    }
			    	if (Integer.parseInt(st.date.split("\\.")[0]) > join_last_date) {
			    		join_last_date = Integer.parseInt(st.date.split("\\.")[0]);
			    		join_last_cname = st.cname;
					}
		        }
			    //ArrayList<Integer> newList = removeDuplicates(years);
			    System.out.println("3. feladat: EU tagállamainak száma: "+al.size()+" db");
			    System.out.println("4. feladat: 2007-ben "+count_join+" ország csatlakozott.");
			    System.out.println("5. feladat: Magyarország csatlakozásának dátuma: "+hu_join_date);
			    System.out.println("6. feladat: "+join_ans);
			    System.out.println("7. feladat: Legutoljára csatlakozott ország: "+join_last_cname);
			    System.out.println("8. feladat: Statisztika");
			    Set<Integer> set = new HashSet<Integer>(years);
			    for (Integer r : set) {
			        System.out.println("\t"+r + " - " + Collections.frequency(years, r)+" ország");
			    }
			    
			    
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Datalist{  
    String cname;
    String date;
    Datalist(String cname,String date){  
        this.cname=cname;
        this.date=date;
    }  
} 