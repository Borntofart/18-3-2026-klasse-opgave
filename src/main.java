import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    //Erklæret ting
    static int total;
    static Scanner reader1;
    static Scanner reader2;
    static String header1;
    static String header2;

    static ArrayList<Guest> people = new ArrayList<>();
    static ArrayList<Ydelser> price = new ArrayList<>();
//    static ArrayList<Ydelser> total = new ArrayList<>();

    public static void main(String[] args) {

        File fileGuest = new File("data/Forbrugs liste");
        File filePris = new File("data/Pris");

        try {
            reader1 = new Scanner(fileGuest);
            reader2 = new Scanner(filePris);

            header1 = reader1.nextLine();
            header2 = reader2.nextLine();
            while (reader1.hasNextLine()) {
                String line = reader1.nextLine();
                String[] ForbrugsListeData = line.split(",");

                String guestName = ForbrugsListeData[0];
                int paddleboard = Integer.parseInt(ForbrugsListeData[1].trim());
                int breakfast = Integer.parseInt(ForbrugsListeData[2].trim());

                Guest guest = new Guest(guestName, paddleboard, breakfast);
                people.add(guest);
            }

            while (reader2.hasNextLine()) {
                String line = reader2.nextLine();
                String[] PrisListeData = line.split(",");

                String ydelse = PrisListeData [0];
                int pris = Integer.parseInt(PrisListeData[1].trim());

                Ydelser y = new Ydelser(ydelse, pris);
                price.add(y);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }

        int paddlePris = 0;
        int morgenmadPris = 0;

        for (Ydelser y : price) {
            if (y.getName().equalsIgnoreCase("paddleboard")) {
                paddlePris = y.getPris();
            } else if (y.getName().equalsIgnoreCase("morgenmad")) {
                morgenmadPris = y.getPris();
            }
        }

        for (Guest g : people) {
            int total = 0;

            total += g.getAntalPaddleboard() * paddlePris;
            total += g.getAntalMorgenmad() * morgenmadPris;

            System.out.println(g.getName() + " total: " + total + " kr");
        }


//Test Kode
        //displayGuest(people);
        //displayPrice(price);
        calculateTotal(people);
    }

    // Display Metoder
    public static void displayGuest (ArrayList<Guest> people){
        for (Guest s  : people) {
            System.out.println(s);
        }
    }
    public static void displayPrice (ArrayList<Ydelser> price){
        for (Ydelser s  : price) {
            System.out.println(s);
        }
    }
    // Total metode
    public static void calculateTotal(ArrayList<Guest> people) {

        int paddlePris = 0;
        int morgenmadPris = 0;

        //beregn total
        for (Guest g : people) {
            int total = 0;

            total += g.getAntalPaddleboard() * paddlePris;
            total += g.getAntalMorgenmad() * morgenmadPris;

        }
    }
}
