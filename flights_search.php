<?php

$db_name = "id5038794_dbms_project";
$mysql_username = "id5038794_vishal";
$mysql_password = "#Vishal$1";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);

$clickeditem = $_GET['clickeditem'];
$clickeditem2 = $_GET['clickeditem2'];

$stmt = $conn->prepare("SELECT 
    airline,
    flight_no,
    sour,
    (SELECT 
            airport_code
        FROM
            airport_codes
        WHERE
            place = sour) AS sourCode,
    dest,
    (SELECT 
            airport_code
        FROM
            airport_codes
        WHERE
            place = dest) AS destCode,
    arr_time,
    dept_time
FROM
    flights
WHERE sour = $clickeditem
	  and dest = $clickeditem2;");

$stmt->execute();

$stmt->bind_result($airline, $flight_no, $sour, $sourCode ,$dest, $destCode, $arr_time, $dept_time);

$flights = array();

while($stmt->fetch()) {
	$temp = array();
	$temp['airline'] = $airline;
	$temp['flight_no'] = $flight_no;
	$temp['sour'] = $sour;
	$temp['sourCode'] = $sourCode;
	$temp['dest'] = $dest;
	$temp['destCode'] = $destCode;
	$temp['arr_time'] = $arr_time;
	$temp['dept_time'] = $dept_time;

	array_push($flights, $temp);
}

echo json_encode($flights);
?>