package kulhavy;

import java.sql.SQLOutput;
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
            System.out.println("============================================");
            System.out.println("1 - Pridat stanici");
            System.out.println("2 - Smazat stanici");
            System.out.println("3 - Doplnit polohu stanice");
            System.out.println("4 - Vypsat stanice podle nazvu");
            System.out.println("5 - Vypsat stanice podle vzdalenosti k bodu");
            System.out.println("6 - Nejblizsi stanice k bodu");
            System.out.println("0 - Exit");
            System.out.println("Vyberte si moznost: ");
            int temp = sc.nextInt();
            switch(temp) {
                case 1:
                    System.out.println("Zadejte nazev stanice: ");
                    String name = sc.next();
                    Station station = new Station(name);
                    liberec.addStation(station);
                    break;
                case 2:
                    System.out.println("Zadejte nazev stanice: ");
                    String nameToRemove = sc.next();
                    liberec.removeStation(nameToRemove);
                    break;
                case 3:
                    System.out.println("Zadejte jmeno stanice, které chcete doplnit udaje: ");
                    String nameOfStation = sc.next();
                    System.out.println("Zadejte souradnice stanice [LONGITUDE]: ");
                    double longitude = sc.nextDouble();
                    System.out.println("Zadejte souradnice stanice [LATITUTE]: ");
                    double latitute = sc.nextDouble();
                    liberec.editStation(nameOfStation, longitude, latitute);
                    break;
                case 4:
                    System.out.println(liberec);
                    break;
                case 5:
                    System.out.println("Zadej zemepisnou delku: ");
                    double longitudeClose = sc.nextDouble();
                    System.out.println("Zadej zemepisnou sirku: ");
                    double latitudeClose = sc.nextDouble();
                    System.out.println(liberec.getNearestStation(longitudeClose, latitudeClose));
                    break;
                case 6:
                    System.out.println("Zadej zemepisnou delku: ");
                    double longitudeClosest = sc.nextDouble();
                    System.out.println("Zadej zemepisnou sirku: ");
                    double latitudeClosest = sc.nextDouble();
                    System.out.println(liberec.get(longitudeClosest, latitudeClosest));
                    break;
                case 0:
                    quit = true;
                default:
                    System.out.println("Nedefinovana akce!");
            }
        } while (quit == false);
    }

}