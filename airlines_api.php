<?php

$db_name = "id5038794_dbms_project";
$mysql_username = "id5038794_vishal";
$mysql_password = "#Vishal$1";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);


$stmt = $conn->prepare("SELECT * FROM Airlines;");

$stmt->execute();

$stmt->bind_result($airline, $headquarter, $website, $phone_no);

$airlines = array();

while($stmt->fetch()) {
	$temp = array();
	$temp['airline'] = $airline;
	$temp['headquarter'] = $headquarter;
	$temp['website'] = $website;
	$temp['phone_no'] = $phone_no;
	
	array_push($airlines, $temp);
}

echo json_encode($airlines);
?>