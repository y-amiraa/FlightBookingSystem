import java.util.Scanner;

/**
 * ceci est la classe SystemeReservation
 * elle gère la logique principale, les tableaux, les matrices et les boucles.
 */
public class SystemeReservation {
    
    // attributs de la classe : ce sont les structures de données principales
    private Vol[] volsDisponibles; // ceci est un tableau de vols (l'agrégation des objets Vol)
    private Passager[][] reservations; // ceci est la matrice (tableau 2D) qui gère les sièges.
                                     // chaque ligne correspond à un vol, chaque colonne à un siège.

    // méthode d'initialisation des données de base
    public void initialiserVols() {
      
        // on crée les objets CompagnieAerienne
        CompagnieAerienne airFrance = new CompagnieAerienne("Air France", "AF");
        CompagnieAerienne royalAirMaroc = new CompagnieAerienne("Royal Air Maroc", "AT");
        CompagnieAerienne singaporeAirlines = new CompagnieAerienne("Singapore Airlines", "SQ");
        CompagnieAerienne airAlgerie = new CompagnieAerienne("Air Algérie", "AH");
        CompagnieAerienne airTunisie = new CompagnieAerienne("Air Tunisie", "TU");
        CompagnieAerienne airSenegal = new CompagnieAerienne("Air Sénégal", "DS");
        
        // on crée les objets Vol, en les associant à une compagnie
        Vol volAF = new Vol("AF001", airFrance, "Paris", "New York", "2025-12-15", 150);
        Vol volAT = new Vol("AT780", royalAirMaroc, "Casablanca", "Paris", "2025-12-16", 120);
        Vol volSQ = new Vol("SQ308", singaporeAirlines, "Singapour", "Londres", "2025-12-17", 250);
        Vol volAH = new Vol("AH600", airAlgerie, "Alger", "Marseille", "2025-12-18", 100);
        Vol volTU = new Vol("TU901", airTunisie, "Tunis", "Rome", "2025-12-19", 90);
        Vol volDS = new Vol("DS301", airSenegal, "Dakar", "New York", "2025-12-21", 110);
        Vol volAF2 = new Vol("AF1400", airFrance, "Paris", "Rome", "2025-12-20", 80);
        
        // on remplit le tableau de vols disponibles
        this.volsDisponibles = new Vol[] { volAF, volAT, volSQ, volAH, volTU, volDS, volAF2 };
        
        // on initialise la matrice de réservation (nombre de lignes = nombre de vols)
        this.reservations = new Passager[volsDisponibles.length][]; 
        
        // on initialise la deuxième dimension de la matrice (les colonnes = les sièges)
        for (int i = 0; i < volsDisponibles.length; i++) {
             // la taille de la ligne (le nombre de sièges) dépend de la capacité de chaque vol
             this.reservations[i] = new Passager[volsDisponibles[i].getCapaciteMax()];
        }
        
        System.out.println("Système de vols initialisé avec " + volsDisponibles.length + " vols.");
    }

    // méthode pour rechercher des vols selon l'itinéraire
    public void rechercherVol(Scanner scanner) {
        System.out.print("Ville de départ souhaitée : ");
        String depart = scanner.nextLine().trim(); // on utilise le scanner pour lire l'entrée
        System.out.print("Ville d'arrivée souhaitée : ");
        String arrivee = scanner.nextLine().trim();
        
        System.out.println("\n--- Résultats de la recherche ---");
        boolean trouve = false;
        
        // boucle 'for-each' pour parcourir tout le tableau de vols
        for (Vol vol : volsDisponibles) {
            
            // on utilise les getters pour comparer l'entrée utilisateur avec les attributs du vol
            if (vol.getVilleDepart().equalsIgnoreCase(depart) && 
                vol.getVilleArrivee().equalsIgnoreCase(arrivee)) {
                
                int siegesLibres = vol.getCapaciteMax() - compterSiegesOccupes(vol);
                
                System.out.println("------------------------------------");
                System.out.println(vol); 
                System.out.println("Sièges disponibles : " + siegesLibres + " / " + vol.getCapaciteMax());
                trouve = true;
            }
        }
        
        if (!trouve) {
            System.out.println("Aucun vol trouvé pour cet itinéraire.");
        }
    }

    // méthode pour effectuer une réservation
    public void reserverVol(Scanner scanner) {
        System.out.print("Entrez le numéro du vol à réserver : ");
        String numVol = scanner.nextLine().trim();

        int indexVol = -1;
        // boucle 1 : trouver l'index (la ligne) correspondant au vol demandé
        for (int i = 0; i < volsDisponibles.length; i++) {
            if (volsDisponibles[i].getNumeroVol().equalsIgnoreCase(numVol)) {
                indexVol = i;
                break;
            }
        }

        if (indexVol == -1) {
            System.out.println("Vol non trouvé.");
            return;
        }
        
        Passager[] siegesVol = reservations[indexVol]; // on sélectionne la ligne (le tableau de sièges) de la matrice
        int indexSiegeLibre = -1;
        
        // boucle 2 : trouver le premier siège disponible dans ce tableau (si la case est nulle)
        for (int j = 0; j < siegesVol.length; j++) {
            if (siegesVol[j] == null) {
                indexSiegeLibre = j;
                break;
            }
        }

        if (indexSiegeLibre == -1) {
            System.out.println("Ce vol est complet.");
            return;
        }

        // lecture des détails du nouveau passager avec le scanner
        System.out.print("Nom du passager : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom du passager : ");
        String prenom = scanner.nextLine();
        System.out.print("Numéro de passeport : ");
        String passeport = scanner.nextLine();
        
        // création de l'objet Passager
        Passager nouveauPassager = new Passager(nom, prenom, passeport);
        
        // insertion de l'objet Passager dans la matrice (réservation effective)
        reservations[indexVol][indexSiegeLibre] = nouveauPassager;
        
        System.out.println("\nRéservation réussie !");
        System.out.println("Vol : " + volsDisponibles[indexVol].getNumeroVol());
        System.out.println("Siège attribué : " + (indexSiegeLibre + 1));
    }
    
    // méthode pour afficher l'état de toutes les réservations
    public void afficherReservations() {
        System.out.println("\n===== État des Réservations =====");
        
        // boucle externe : itère sur les lignes (les vols)
        for (int i = 0; i < volsDisponibles.length; i++) {
            Vol vol = volsDisponibles[i];
            Passager[] siegesVol = reservations[i];
            
            System.out.println("\n--- Vol " + vol.getNumeroVol() + " (" + vol.getCompagnie().getNom() + ") ---");
            
            int compteurReservations = 0;
            
            // boucle interne : itère sur les colonnes (les sièges)
            for (int j = 0; j < siegesVol.length; j++) {
                if (siegesVol[j] != null) { // si la case n'est pas null, c'est qu'elle contient un passager
                    
                    // affichage des infos du passager (via ses getters)
                    System.out.println("Siège " + (j + 1) + ": Réservé par " + 
                                       siegesVol[j].getPrenom() + " " + siegesVol[j].getNom() + 
                                       " (Passeport: " + siegesVol[j].getNumeroPasseport() + ")");
                    compteurReservations++;
                }
            }
            
            if (compteurReservations == 0) {
                System.out.println("Aucune réservation enregistrée pour ce vol.");
            }
            System.out.println("Total réservations : " + compteurReservations + " / " + vol.getCapaciteMax());
        }
    }
    
    // méthode utilitaire privée pour compter les sièges occupés d'un vol
    private int compterSiegesOccupes(Vol vol) {
        int indexVol = -1;
        
        // boucle pour trouver l'index de la ligne du vol
        for (int i = 0; i < volsDisponibles.length; i++) {
            if (volsDisponibles[i] == vol) {
                indexVol = i;
                break;
            }
        }
        if (indexVol == -1) return 0; 

        int compteur = 0;
        // boucle pour compter les cases non-null dans la ligne (les réservations)
        for (Passager passager : reservations[indexVol]) {
            if (passager != null) {
                compteur++;
            }
        }
        return compteur;
    }
}
