<?php 
	try {
		sleep(3);
		
		$regnr = strip_tags($_POST["regnr"]);
		
		$datetime = date("Y-m-d H:i:s");
		
		$json = array("datetime" => $datetime, "regnr" => $regnr);
		//throw new Exception("Fel vid anrop till deletecar.php!");
		echo(json_encode($json));
		
	} catch(Exception $e) {
		echo("Fel: " . $e->getMessage() );
	}
	
?>