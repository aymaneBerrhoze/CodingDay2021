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
                        <h3>Inscription</h3>
                        <div class="page-links">
                            <a href="index.jsp">Connexion</a><a href="inscription.jsp" class="active">Inscription</a>
                        </div>
                        <form action="Inscription" method="post">
                            <input class="form-control" type="text" minlength="2" name="prenom" placeholder="Prenom" required>
                            <input class="form-control" type="text"  minlength="2"name="nom" placeholder="Nom" required>
                            <select class="form-control" name="sexe" placeholder="Sexe" required>
                                <option value="Sexe" selected disabled>Sexe</option>
                                <option>M</option>
                                <option>F</option>
                            </select>
                            
                            <div class="form-button">
                                <button id="submit" type="submit" class="ibtn">Enregistrer</button>
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