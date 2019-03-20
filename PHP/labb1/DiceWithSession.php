<!doctype html>
<html lang="en" >

<head>
    <meta charset="utf-8" />
    <title>Roll the dice...</title>
    <link href="style/style.css" rel="stylesheet" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>

<div>

    <?php

    session_start();
    session_regenerate_id(true);

    $disabled = true;

    function deleteSession() {
        // Frigör alla session variabler
        session_unset();
        // Tar bort session kakan
        if (ini_get("session.use_cookies")){
            $data = session_get_cookie_params();
            $path = $data['path'];
            $domain = $data['domain'];
            $secure = $data['secure'];
            $httponly = $data['httponly'];
            $name = session_name();
            setcookie($name, "", time() - 3600, $path, $domain, $secure, $httponly);
        }
        // Förstor session
        session_destroy();
    }

    if(isset($_GET['linkNewGame'])) {

        $_SESSION['nbrOfRounds'] = 0;
        $_SESSION['sumOfAllRounds'] = 0;

        echo 'New Game';

        $disabled = false;
    }

    if(isset($_GET['linkRoll'])){
        include("include/OneDice.php");
        include("include/SixDices.php");

        $sixDices = new SixDices();
        $sixDices -> rollDices();
        $screen = $sixDices->svgDices();
        echo($screen);

        $rounds = $_SESSION["nbrOfRounds"];
        $rounds++;
        $_SESSION["nbrOfRounds"] = $rounds;

        $value = $_SESSION["sumOfAllRounds"];
        $value += $sixDices->sumDices();
        $_SESSION["sumOfAllRounds"] = $value;

        $avg = $value / $rounds;

        echo("<p>Summan är: " . $value . "!</p>");
        echo("<p>Medel är: " . $avg . "!</p>");
        echo("<p>Antal rundor: " . $rounds . "!</p>");

        $disabled = false;
    }

    if(isset($_GET['linkExit'])){
        deleteSession();
        $disabled = true;
    }

    ?>
</div>
<form action="<?php echo($_SERVER["PHP_SELF"]); ?>" method="post">
    <a href="<?php ?>?linkRoll=true" class="btn btn-primary<?php if($disabled){echo(" disableLink");}?>">Roll six dices</a>

    <a href="<?php ?>?linkNewGame=true" class="btn btn-primary">New game</a>

    <!-- // OM disabled än sann på serversidan så sätter vi klassen disableLink -->
    <a href="<?php ?>?linkExit=true" class="btn btn-primary<?php if($disabled){echo(" disableLink");}?>">Exit</a>
</form>
<script src="script/animation.js"></script>
</body>

</html>