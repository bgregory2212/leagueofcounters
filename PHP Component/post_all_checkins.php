<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['locone']) && isset($_POST['loctwo']) && isset($_POST['title']) && isset($_POST['details'])&& isset($_POST['pics'])) 
    {
    
    $locone = $_POST['locone'];
    $loctwo = $_POST['loctwo'];
    $title = $_POST['title'];
    $details = $_POST['details'];
    $pics = $_POST['pics'];
    $pics = utf8_encode($pics);
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO checkins(locone, loctwo, title, details, pics) VALUES('$locone', '$loctwo', '$title', '$details', '$pics')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Check-Ins successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}

?>
