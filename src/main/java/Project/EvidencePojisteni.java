package Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidencePojisteni {
    private List<Pojisteny> seznamPojisteny;

    //konstruktor tridy
    public EvidencePojisteni() {
        seznamPojisteny = new ArrayList<>();
    }

    public void pridejPojisteneho(Pojisteny pojisteny) {
        seznamPojisteny.add(pojisteny);
        System.out.println("Data byla ulozena.");
    }

    public void vypisVsechnyPojistene() {
        System.out.println("-----------------------------");
        System.out.println("Evidence pojistenych");
        System.out.println("-----------------------------");
        for (Pojisteny pojisteny : seznamPojisteny) {
            System.out.println(pojisteny);
        }
    }

    public void vyhledejPojisteneho(String jmeno, String prijmeni) {
        System.out.println("-----------------------------");
        System.out.println("Evidence pojistenych");
        System.out.println("-----------------------------");
        for (Pojisteny pojisteny : seznamPojisteny) {
            if (pojisteny.getJmeno().equalsIgnoreCase(jmeno) && pojisteny.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println(pojisteny);
                return;
            }
        }
        System.out.println("Pojisteny s danym jmenem a prijmenim nebyl nalezen.");
    }

    public static void main(String[] args) {
        EvidencePojisteni evidence = new EvidencePojisteni();
        Scanner sc = new Scanner(System.in);
        int volba;

        do {
            System.out.println("----------------------------");
            System.out.println("Evidence pojistenych");
            System.out.println("----------------------------");
            System.out.println("Vyberte si akci:");
            System.out.println("1 – Pridat noveho pojisteneho");
            System.out.println("2 – Vypsat vshechny pojistene");
            System.out.println("3 – Vyhledat pojisteneho");
            System.out.println("4 – Konec");
            volba = Integer.parseInt(sc.nextLine());

            switch (volba) {
                case 1:
                    System.out.println("Zadejte jmeno pojisteneho:");
                    String jmeno = sc.nextLine();
                    System.out.println("Zadejte prijmeni:");
                    String prijmeni = sc.nextLine();
                    System.out.println("Zadejte telefonni cislo:");
                    String telefon = sc.nextLine();
                    System.out.println("Zadejte vek:");
                    int vek = Integer.parseInt(sc.nextLine());

                    Pojisteny novyPojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
                    evidence.pridejPojisteneho(novyPojisteny);
                    break;

                case 2:
                    evidence.vypisVsechnyPojistene();
                    break;

                case 3:
                    System.out.println("Zadejte jmeno:");
                    jmeno = sc.nextLine();
                    System.out.println("Zadejte prijmeni:");
                    prijmeni = sc.nextLine();
                    evidence.vyhledejPojisteneho(jmeno, prijmeni);
                    break;

                case 4:
                    System.out.println("Konec programu.");
                    break;

                default:
                    System.out.println("Neplatna volba.");
            }
        } while (volba != 4);
    }
}