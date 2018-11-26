<?php 

	try {
	
		sleep(3);
		
		$inModell = strip_tags($_POST["modell"]);
		$inFabrikat = strip_tags($_POST["fabrikat"]);
		$inRegNr = strip_tags($_POST["regnr"]);
		$inDateTime = date("Y-m-d H:i:s");
	
		//throw new Exception("Fel vid anropt till insertcar.php!");
	
		$json = array("outDateTime" => $inDateTime, "outFabrikat" => $inFabrikat, "outModell" => $inModell, "outRegNr" => $inRegNr);
		echo(json_encode($json)); 
		
	} catch(Exception $e) {
		echo("Fel: " . $e->getMessage());
	}
	
?>