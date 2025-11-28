import java.util.Scanner;

/**
 * Classe SystemeReservation
 * Gère l'initialisation des données, la recherche de vols, et l'état des réservations.
 */
public class SystemeReservation {
    
    // Attributs principaux : Le tableau de vols et la matrice de réservation (tableau 2D)
    private Vol[] volsDisponibles; // Tableau de Vols
    private Passager[][] reservations; // Matrice (Tableau 2D) : [Index du Vol][Numéro du Siège] = Passager ou null

    // =================================================================
    // 1. Initialisation du Système (Agrégation et Tableaux)
    // =================================================================

    public void initialiserVols() {
        // Création des compagnies aériennes
        CompagnieAerienne airFrance = new CompagnieAerienne("Air France", "AF");
        CompagnieAerienne royalAirMaroc = new CompagnieAerienne("Royal Air Maroc", "AT");
        CompagnieAerienne singaporeAirlines = new CompagnieAerienne("Singapore Airlines", "SQ");
        CompagnieAerienne airAlgerie = new CompagnieAerienne("Air Algérie", "AH");
        CompagnieAerienne airTunisie = new CompagnieAerienne("Air Tunisie", "TU");
        CompagnieAerienne airSenegal = new CompagnieAerienne("Air Sénégal", "DS");
        
        // Création des vols (Agrégation : chaque vol contient un objet CompagnieAerienne)
        Vol volAF = new Vol("AF001", airFrance, "Paris", "New York", "2025-12-15", 150);
        Vol volAT = new Vol("AT780", royalAirMaroc, "Casablanca", "Paris", "2025-12-16", 120);
        Vol volSQ = new Vol("SQ308", singaporeAirlines, "Singapour", "Londres", "2025-12-17", 250);
        Vol volAH = new Vol("AH600", airAlgerie, "Alger", "Marseille", "2025-12-18", 100);
        Vol volTU = new Vol("TU901", airTunisie, "Tunis", "Rome", "2025-12-19", 90);
        Vol volDS = new Vol("DS301", airSenegal, "Dakar", "New York", "2025-12-21", 110);
        Vol volAF2 = new Vol("AF1400", airFrance, "Paris", "Rome", "2025-12-20", 80);
        
        // Remplissage du tableau de vols
        this.volsDisponibles = new Vol[] { volAF, volAT, volSQ, volAH, volTU, volDS, volAF2 };
        
        // Initialisation de la matrice (taille : nombre de vols x capacitéMax)
        this.reservations = new Passager[volsDisponibles.length][]; 
        
        // Initialisation de la deuxième dimension (sièges) avec une boucle for
        for (int i = 0; i < volsDisponibles.length; i++) {
             // Utilisation du getter getCapaciteMax() pour dimensionner chaque ligne
             this.reservations[i] = new Passager[volsDisponibles[i].getCapaciteMax()];
        }
        
        System.out.println("✅ Système de vols initialisé avec " + volsDisponibles.length + " vols.");
    }

    // =================================================================
    // 2. Recherche de Vol (Utilisation du Scanner et d'une Boucle)
    // =================================================================

    public void rechercherVol(Scanner scanner) {
        System.out.print("Ville de départ souhaitée : ");
        String depart = scanner.nextLine().trim();
        System.out.print("Ville d'arrivée souhaitée : ");
        String arrivee = scanner.nextLine().trim();
        
        System.out.println("\n--- Résultats de la recherche ---");
        boolean trouve = false;
        
        // Boucle 'for-each' pour parcourir le tableau des vols
        for (Vol vol : volsDisponibles) {
            // Utilisation des getters pour la comparaison
            if (vol.getVilleDepart().equalsIgnoreCase(depart) && 
                vol.getVilleArrivee().equalsIgnoreCase(arrivee)) {
                
                int siegesLibres = vol.getCapaciteMax() - compterSiegesOccupes(vol);
                
                System.out.println("------------------------------------");
                System.out.println(vol); // Utilise Vol.toString()
                System.out.println("Sièges disponibles : " + siegesLibres + " / " + vol.getCapaciteMax());
                trouve = true;
            }
        }
        
        if (!trouve) {
            System.out.println("Aucun vol trouvé pour cet itinéraire.");
        }
    }

    // =================================================================
    // 3. Réservation de Vol (Utilisation de la Matrice et de Boucles)
    // =================================================================

    public void reserverVol(Scanner scanner) {
        System.out.print("Entrez le numéro du vol à réserver : ");
        String numVol = scanner.nextLine().trim();

        int indexVol = -1;
        // Boucle 1 : Trouver l'index du vol dans le tableau
        for (int i = 0; i < volsDisponibles.length; i++) {
            if (volsDisponibles[i].getNumeroVol().equalsIgnoreCase(numVol)) {
                indexVol = i;
                break;
            }
        }

        if (indexVol == -1) {
            System.out.println("❌ Vol non trouvé.");
            return;
        }
        
        Passager[] siegesVol = reservations[indexVol];
        int indexSiegeLibre = -1;
        
        // Boucle 2 : Trouver le premier siège libre (null) dans la ligne de la matrice
        for (int j = 0; j < siegesVol.length; j++) {
            if (siegesVol[j] == null) {
                indexSiegeLibre = j;
                break;
            }
        }

        if (indexSiegeLibre == -1) {
            System.out.println("❌ Ce vol est complet.");
            return;
        }

        // Lecture des infos du Passager (via Scanner)
        System.out.print("Nom du passager : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom du passager : ");
        String prenom = scanner.nextLine();
        System.out.print("Numéro de passeport : ");
        String passeport = scanner.nextLine();
        
        // Création de l'objet Passager et insertion dans la Matrice
        Passager nouveauPassager = new Passager(nom, prenom, passeport);
        // Affectation dans la Matrice : [Index du Vol][Index du Siège] = Objet Passager
        reservations[indexVol][indexSiegeLibre] = nouveauPassager;
        
        System.out.println("\n✅ Réservation réussie !");
        System.out.println("Vol : " + volsDisponibles[indexVol].getNumeroVol());
        System.out.println("Siège attribué : " + (indexSiegeLibre + 1));
    }
    
    // =================================================================
    // 4. Affichage des Réservations (Utilisation de Boucles Imbriquées)
    // =================================================================

    public void afficherReservations() {
        System.out.println("\n===== État des Réservations =====");
        
        // Boucle externe : itère sur le tableau des vols (lignes de la matrice)
        for (int i = 0; i < volsDisponibles.length; i++) {
            Vol vol = volsDisponibles[i];
            Passager[] siegesVol = reservations[i];
            
            System.out.println("\n--- Vol " + vol.getNumeroVol() + " (" + vol.getCompagnie().getNom() + ") ---");
            
            int compteurReservations = 0;
            
            // Boucle interne : itère sur les sièges (colonnes de la matrice)
            for (int j = 0; j < siegesVol.length; j++) {
                if (siegesVol[j] != null) {
                    // Utilisation des getters sur l'objet Passager
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
    
    // =================================================================
    // Méthode Utilitaire (pour le calcul des places libres)
    // =================================================================

    /**
     * Calcule le nombre de sièges occupés pour un vol donné.
     * @param vol Le vol dont on veut compter les réservations.
     * @return Le nombre de réservations.
     */
    private int compterSiegesOccupes(Vol vol) {
        int indexVol = -1;
        // Trouver l'index du vol dans le tableau
        for (int i = 0; i < volsDisponibles.length; i++) {
            if (volsDisponibles[i] == vol) {
                indexVol = i;
                break;
            }
        }
        if (indexVol == -1) return 0; // Sécurité

        int compteur = 0;
        // Compter les sièges non-null (réservés)
        for (Passager passager : reservations[indexVol]) {
            if (passager != null) {
                compteur++;
            }
        }
        return compteur;
    }
}
