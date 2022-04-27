package kulhavy;

import java.util.Scanner;

/**
 *
 * @author tomas.kulhavy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        Institute liberec = new Institute("Liberec");

        do {
            System.out.println("1 - Přidat stanici");
            System.out.println("2 - Smazat stanici");
            System.out.println("3 - Doplnit polohu stanice");
            System.out.println("4 - Vypsat stanice podle názvu");
            System.out.println("5 - Vypsat stanice podle vzdálenosti k bodu");
            System.out.println("6 - Nejbližší stanice");
            System.out.println("Vyberte si možnost: ");
            int temp = sc.nextInt();
            if(temp == 1) {
                System.out.println("Zadejte název stanice: ");
                String name = sc.nextLine();
                Station station = new Station(name);
                liberec.addStation(station);
            }
            if(temp == 2) {
                System.out.println("Zadejte název stanice: ");
                String name = sc.nextLine();
                liberec.removeStation(name);
            }
            if(temp == 3) {
                System.out.println("Zadejte souřadnice stanice [LONGITUDE]: ");
                double longitude = sc.nextDouble();
                System.out.println("Zadejte souřadnice stanice [LATITUTE]: ");
                double latitute = sc.nextDouble();
                liberec.editStation(station, longitude, latitute);
            }
        } while (quit == false);
    }

}