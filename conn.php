<?php
$db_name = "id5038794_dbms_project";
$mysql_username = "id5038794_vishal";
$mysql_password = "#Vishal$1";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);
if($conn){
	echo "Successful";
}
else{
	echo "Unsuccessful";
}
?>