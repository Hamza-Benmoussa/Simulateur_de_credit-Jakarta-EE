package metier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditMetierImplTest {
    private ICreditMetier metier;
    @BeforeEach
    void setUp() {
        metier=new CreditMetierImpl();
    }

    @Test
    void calculMesualiteCredit() {
        double capital=200000;
        int duree=240;
        double taux= 4.5;

        double resultatAttendus = 1265.2987;
        double resCalcule= metier.calculMesualiteCredit(capital,taux,duree);
        assertEquals(resultatAttendus,resCalcule,0.0001);
    }
}