package flightbookingsystem;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        
        Vol v = new Vol("AF123", "AirTest", "Paris", "Londres", "2025-12-01T09:00", 150);
        Passager p = new Passager(1, "Dupont", "0600000000");
        boolean added = v.ajouterPassager(p);
        System.out.println(v);
        System.out.println("Passager ajouté: " + added + ", nombre passagers=" + v.nombrePassagers());
    }
}

