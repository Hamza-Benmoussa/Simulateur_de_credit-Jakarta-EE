package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetierImpl;
import metier.ICreditMetier;

import java.io.IOException;
//deuxiem methode de deployement de servlet
@WebServlet(name = "cs" , urlPatterns = {"/contoleur","*.do"})
public class ControleurServlet extends HttpServlet {
    private ICreditMetier metier;
    @Override
    public void init() throws ServletException {
        super.init();
        metier = new CreditMetierImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("creditModel",new CreditModel());
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lire les donnes
        double montant = Double.parseDouble(req.getParameter("montant"));
        double taux = Double.parseDouble(req.getParameter("taux"));
        int duree = Integer.parseInt(req.getParameter("duree"));
        //valider les donnes et stocker les donnes saisir dans le model

        CreditModel creditModel = new CreditModel();
        creditModel.setMontant(montant);
        creditModel.setTaux(taux);
        creditModel.setDuree(duree);

        //faire appel a la coucche metier pour effectuer les traitements

        double resul=metier.calculMesualiteCredit(montant,taux,duree);

        //stocker les resultat dans le modele

        creditModel.setMensualite(resul);

        //stocker le modele dans l'object request

        req.setAttribute("creditModel",creditModel);

        //faire un forward vers le vue jsp

        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
