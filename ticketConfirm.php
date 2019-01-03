<?php
require "conn.php"; 

$airline = $_POST["airline"];
$flightNo = $_POST["flightNo"];
$source = $_POST["source"];
$destination = $_POST["destination"];
$arrivalTime = $_POST["arrivalTime"];
$deptTime = $_POST["deptTime"];
$name = $_POST["name"];
$phone = $_POST["phone"];
$date = $_POST["date"];
$mail = $_POST["mail"];
$adhaar = $_POST["adhaar"];
$passport = $_POST["passport"];
$Class = $_POST["Class"];
$seats = $_POST["seats"];
$ticketNumber = $_POST["ticketNumber"];
$price = $_POST["price"];


//$mysql_qry0 = mysql_query("select totalSeats
//				from seatMatrix
//				WHERE totalSeats > $seats and flight_no = $flightNo;");


$mysql_qry = "insert into booked_ticket (airline, flight_no, sour, dest, arr_time, dept_time, pass_name, phone_no, travel_date, mail, adhaar_no,passport_no, travel_class, no_of_seats, ticket_no, ticketPrice)
        values('$airline', '$flightNo', '$source', '$destination', '$arrivalTime', '$deptTime', '$name', '$phone', '$date', '$mail', '$adhaar', '$passport', '$Class', '$seats', '$ticketNumber', '$price');";
        
        
$mysql_qry2 = "UPDATE seatMatrix 
SET 
    totalSeats = totalSeats - $seats
WHERE
    flight_no = $flightNo;";


$to = "vaambavade@gmail.com";  
$subject = "Test mail";  
$message . = '<html><body>';
$message . = '<table rules="all" style="border-color: #666;" cellpadding="10">';
$message . ="<tr style='background: #eee;'><td><strong>Attribute</strong> </td><td>Value</td></tr>";
$message . = "<tr><td><strong>Airline</strong> </td><td>"$airline"</td></tr>";
$message . = 
$message . = 
$message . = 
$message . = 

$message . =
			Airline         :$airline";  
$from = "vishalambavade@hotmail.com";  
$headers = "From: $from";  

mail($to,$subject,$message,$headers);  
echo "Mail Sent."; 


if($conn->query($mysql_qry) === TRUE and $conn->query($mysql_qry2) === TRUE){
	echo "Ticket Booked!!!";
}
else {
	echo "Error: " . $mysql_qry . "<br>" .$conn->error;
}
$conn->close();
?>