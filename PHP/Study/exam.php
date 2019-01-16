<?php

// Uppgift 1
try
{
    $dsn = "mysql: host=localhost;dbname=database"
    $username = "webuser";
    $password = "webpassword";
    $options = array( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
    $db = new PDO( $dsn, $username, $password, $options );

    $sql = "SELECT id, title FROM tblSong";
    $statement = $db->prepare( $sql );
    $statement->execute();
    $songs = $statement->fetchAll();
    foreach( $songs as $song )
    {
        echo "<option value='" . $song[ "id" ] . "'>" . $song[ "title" ] . "</option>";
    }

    $statement = null;
}
catch( PDOException $e )
{
    throw $e;
}

// Uppgft 2
try
{
    $sql = "SELECT text, insertdate FROM tblComment, tblSong WHERE tblComment.songid = tblSong.id";

}
