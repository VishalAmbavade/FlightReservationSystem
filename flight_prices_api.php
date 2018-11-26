<?php

$db_name = "id5038794_dbms_project";
$mysql_username = "id5038794_vishal";
$mysql_password = "#Vishal$1";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);

$clickeditem = $_GET['clickeditem'];
//$strSQL = "SELECT * FROM table WHERE clickeditem = '$clickeditem'";

$stmt = $conn->prepare("SELECT * FROM flight_prices where flight_no = $clickeditem;");

$stmt->execute();

$stmt->bind_result($airline, $flight_no, $sour, $dest, $ta_name, $ta_code, $ticketPrice);

$airlines = array();

while($stmt->fetch()) {
	$temp = array();
	$temp['airline'] = $airline;
	$temp['flight_no'] = $flight_no;
	$temp['sour'] = $sour;
	$temp['dest'] = $dest;
	$temp['ta_name'] = $ta_name;
	$temp['ta_code'] = $ta_code;
	$temp['ticketPrice'] = $ticketPrice;
	
	array_push($airlines, $temp);
}

echo json_encode($airlines);
?>