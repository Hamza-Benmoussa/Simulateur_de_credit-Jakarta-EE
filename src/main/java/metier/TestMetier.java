package metier;

public class TestMetier {
    public static void main(String[] args) {
        CreditMetierImpl creditMetier = new CreditMetierImpl();
        double taux = 4.5;
        double capital = 200000;
        int duree = 240;
        double m= creditMetier.calculMesualiteCredit(capital,taux,duree);
        System.out.println("Lhyt man ahah : "+m);

    }
}
