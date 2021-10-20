<?php
    function connectDb ()
    {
        $host = 'localhost';
        $user = 'root';
        $db = 'iut_php';
        $pwd = '';

        try {
            $bdd = new PDO('mysql:host=' . $host . ';dbname=' . $db . ';charset=utf8', $user, $pwd);
            return $bdd;
        } catch (Exception $e) {
            exit('Erreur : ' . $e->getMessage());
        }
    }

?>
<!DOCTYPE html>
<html>
<link href="styles.css" rel="stylesheet">
<head>
    <meta charset="UTF-8">
    <title>SGBD</title>
</head>
<body>

<form method="post" action="#">

    <input type="text" name="nom" id="nom" placeholder="Nom du film" required>

    <input type="number" name="annee" id="annee" placeholder="Année de sortie" required>

    <input type="number" name="score" id="score" placeholder="Score du film" required>

    <input type="number" name="nbVotants" id="nbVotants" placeholder="Nombre de votants">

    <button type="submit">Envoyer</button>

</form>

<br>
<br>

<h3>
    <?php

    if (!empty($_POST)) {

        //Vérifier les données
        if ($_POST['annee'] > 2050 || $_POST['annee'] < 1800) echo 'L\'année n\'est pas valide !';
        else if ($_POST['score'] < 0 || $_POST['score'] > 10) echo 'Le score n\'est pas valide !';
        else {
            //Vérifier si le film existe déjà dans la base de donnée
            $bdd = connectDb();
            $query = $bdd->prepare('SELECT * FROM `film` WHERE nom = ":nom"');
            $query->bindParam(':nom', $_POST['nom']);
            $results = $query->fetchAll();
            if (count($results) > 0)
                //le film existe déjà
                $sqlStmt = 'UPDATE film SET annee = :annee, score = :score, nbVotants = :nbVotants WHERE id == '.$results[0]['id'];
            else
                //il faut rajouter le film
                $sqlStmt = 'INSERT INTO film (nom, annee, score, nbVotants) VALUES (:nom, :annee, :score, :nbVotants)';

            $bdd->prepare($sqlStmt)->execute($_POST);

            echo '<strong>Entrée ajoutée dans la base de donnée !</strong>';
        }
    }
    ?>
</h3>

</body>
</html>
