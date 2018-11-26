<?php

define('DB_HOST', 'localhost');
define('DB_USER', 'id5038794_vishal');
define('DB_PASS', '#Vishal$1');
define('DB_NAME', 'id5038794_dbms_project');

$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

if(mysql_connect_errno()) {
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	die();
}

$stmt = $conn->prepare("SELECT airline, flight_no, sour, dest, arr_time, dept_time, arr_date, dept_date FROM flights;");

$stmt->execute();

$stmt->bind_result($airline, $flight_no, $sour, $dest, $dest, $arr_time, $dept_time, $arr_date, $dept_date);

$flights = array();

while($stmt->fetch()) {
	$temp = array();
	$temp['airline'] = $airline;
	$temp['flight_no'] = $flight_no;
	$temp['sour'] = $sour;
	$temp['dest'] = $dest;
	$temp['arr_time'] = $arr_time;
	$temp['dept_time'] = $dept_time;
	$temp['arr_date'] = $arr_date;
	$temp['dept_date'] = $dept_date;

	array_push($flights, $temp);
}

echo json_encode($flights);
?>