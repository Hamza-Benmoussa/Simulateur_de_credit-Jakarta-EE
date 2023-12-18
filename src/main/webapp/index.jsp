<%@ page import="web.CreditModel" %>
<%
    // JSP standard
    CreditModel model = (CreditModel) request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Credit bancaire</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <h5 class="card-header bg-primary text-white">Simulation du credit</h5>
        <div class="card-body">
            <form action="calculerMendualite.do" method="post">
                <div class="form-group row">
                    <label>Montant :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="montant" name="montant" value="<%=model.getMontant()%>"></div>
                </div>
                <div class="form-group row">
                    <label>Taux :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="taux" name="taux" value="<%=model.getTaux()%>">

                    </div>
                </div>
                <div class="form-group row">
                    <label >Duree :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="duree" name="duree" value="<%=model.getDuree()%>">
                    </div>
                </div>
                        <button class="btn btn-danger">Calculer</button>


            </form>
        </div>
        <div class="card-footer">
            <label>Mensualite :</label>
            <label><%= model.getMensualite() %></label>
        </div>
    </div>
</div>
</body>
</html>
