<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>iofrm</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/fontawesome-all.min.css">
    <link rel="stylesheet" type="text/css" href="css/iofrm-style.css">
    <link rel="stylesheet" type="text/css" href="css/iofrm-theme1.css">
</head>
<body>
    <div class="form-body" class="container-fluid">
        
        <div class="row">
            <div class="img-holder">
                <div class="bg"></div>
                <div class="info-holder">

                </div>
            </div>
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Connexion</h3>
                        <div class="page-links">
                            <a href=index.jsp" class="active">Connexion</a><a href="inscription.jsp">Inscription</a>
                        </div>
                        <form action="Connexion" method="post"> 
                            <input class="form-control" type="text" name="prenom" placeholder="Prenom" required>
                            <input class="form-control" type="text" name="nom" placeholder="Nom" required>
                            <div class="form-button">
                                <button id="submit" type="submit" class="ibtn">Connexion</button>
                            </div>
                            <div class="form-button">
                            <c:if test="${testA==1}">
					          <div class="container-login100-form-btn m-t-32">
					        <strong style="color : #F6323E "> ${eA} </strong>
					         </div>
					         </c:if>
					         </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>