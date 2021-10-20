<!DOCTYPE html>
<html>
<link href="styles.css" rel="stylesheet">
<head>
    <meta charset="UTF-8">
    <title>Introduction PHP</title>
</head>
<body>

    <form method="post" action="#">

        <select name="situation" id="situation" required>
            <option value="married">Marrié</option>
            <option value="celib">Célibataire</option>
        </select>

        <input type="number" name="children" id="children" placeholder="Nombre d'enfants" required>

        <input type="number" name="incomes" id="incomes" placeholder="Revenus" required>

        <button type="submit">Envoyer</button>

    </form>

    <br>

    <h3>
    <?php

        if (!empty($_POST)) {

            //configuration
            $parts = 1;
            $levels = array(
                0 => array (
                    'amount' => 0,
                    'percentage' => 0
                ),
                1 => array (
                    'amount' => 10065,
                    'percentage' => 0
                ),
                2 => array (
                    'amount' => 25559,
                    'percentage' => 11
                ),
                3 => array (
                    'amount' => 73369,
                    'percentage' => 30
                ),
                4 => array (
                    'amount' => 157806,
                    'percentage' => 41
                ),
                5 => array (
                    'amount' => 10000000000000000,
                    'percentage' => 45
                )
            );

            //On calcule le nombre de parts en fonction des paramètres donnés
            if ($_POST['situation'] == 'married') $parts++;
            for ($i = 0; $i < $_POST['children']; $i++) $parts += $i < 2 ? 0.5 : 1;

            //=========== CALCUL DE L'IMPOT ===============//

            $incomes = $_POST['incomes'] / $parts;
            $maxLevel = 1;
            $finalTax = 0;

            //on cherche le palier maximum atteignable avec notre revenu divisé par le nombre de parts
            while ($incomes >= $levels[$maxLevel]['amount']) $maxLevel++;

            //on applique le pourcentage sur les tranches complètes
            for ($i = 1; $i <= $maxLevel - 1; $i++) $finalTax += ($levels[$i]['amount'] - ($levels[$i-1]['amount'] - 1)) * ($levels[$i]['percentage']/100);

            //on applique le pourcentage sur le reste
            $finalTax += ($incomes - $levels[$maxLevel - 1]['amount']) * ($levels[$maxLevel]['percentage']/100);

            //on multiplie cette somme par le nombre de parts
            $finalTax *= $parts;

            //affichage final
            echo 'Félications ! Vous devez payer un impôt de : <h2>'.$finalTax.'€</h2>';


        }
    ?>
    </h3>

</body>
</html>