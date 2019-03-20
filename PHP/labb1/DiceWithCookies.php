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

			/*
				För detljerade krav se filmen under inlämningsuppgift 1 på its.

				Användaren har klickat på btnNewGame!
				Kakorna nbrOfRounds och sumOfAllRounds kommer till servern!
				Användaren har klickat på btnRoll och kakorna nbrOfRounds och sumOfAllRounds kommer till servern!
				Användaren har klickat på btnExit!
			*/

			$disabled = true;

			if ( !isset ( $_COOKIE [ 'nbrOfRounds' ] ) && !isset ( $_COOKIE [ 'sumOfAllRounds' ] ) )
			{
				$disabled = true;
			}
			else {
                $disabled = false;
            }

			if ( isset ( $_POST [ 'btnNewGame' ] ) )
			{
			    $value = 0;
                $_COOKIE [ 'nbrOfRounds' ] = $value;
                $_COOKIE [ 'sumOfAllRounds' ] = $value;


                echo "New Game!";
				$disabled = false;
			}

			if ( isset ( $_POST [ 'btnRoll' ] ) )
			{
				$disabled = false;
				include 'include/OneDice.php';
				include 'include/SixDices.php';

				$oSixDices = new SixDices();

				$oSixDices->rollDices();

				$output = $oSixDices->svgDices();
				echo($output);

				$temp = $_COOKIE [ 'sumOfAllRounds' ];
				$temp += $oSixDices->sumDices();

				$rounds = $_COOKIE [ 'nbrOfRounds' ];
				$rounds++;

				$avg = $temp / $rounds;

				setcookie ( "sumOfAllRounds", $temp );
				setcookie ( "nbrOfRounds", $rounds );

				echo("<p>Summan är: " . $temp . "!</p>");
				echo("<p>Medel är: " . $avg . "!</p>");
				echo("<p>Antal rundor: " . $rounds . "!</p>");
			}

			if ( isset ( $_POST [ 'btnExit' ] ) )
			{

					setcookie ( "nbrOfRounds", "", time () - 3600 * 24 * 4, "/" );
					setcookie ( "sumOfAllRounds", "", time () - 3600 * 24 * 40, "/" );
			}

		?>
		</div>
			<form action="<?php echo($_SERVER["PHP_SELF"]); ?>" method="post">
				<input type="submit" <?php if ($disabled){ echo ("disabled"); } ?> name="btnRoll" class="btn btn-primary" value="Roll six dices" />
				<input type="submit" name="btnNewGame" class="btn btn-primary" value="New Game" />
				<input type="submit" <?php if ($disabled){ echo ("disabled"); } ?> name="btnExit" class="btn btn-primary" value="Exit"/>
			</form>
		<script src="script/animation.js"></script>
	</body>

</html>
