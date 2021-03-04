import java.util.Scanner;
import java.math.*;

public class Main {
    public static void main(String[] args) {
    int szam;
    boolean prim = true;
    Scanner in = new Scanner(System.in);
    System.out.println("Kérem, hogy gépelje be a számot (0 és 1 nem prímszám)!");
    szam = in.nextInt();
    if (szam == 1 || szam == 0){
        System.out.println(szam + " nem prímszám!");
        prim = false;
    }
    else
        for (int j = 2; j <= Math.sqrt(szam); j++){
            if (szam % j == 0){
            prim = false;
            System.out.println(szam + " nem prímszám!");
            break;
        }
    }
    if(prim == true)
        System.out.print(szam + " prímszám");
    }
}
