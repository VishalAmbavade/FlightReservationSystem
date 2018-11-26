<?php 
 
require "conn.php"; 
 
 //creating a query
 $stmt = $conn->prepare("SELECT id, title, shortdesc, rating, price, image FROM products;");
 
 //executing the query 
 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($id, $title, $shortdesc, $rating, $price, $image);
 
 $products = array(); 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 $temp['id'] = $id; 
 $temp['title'] = $title; 
 $temp['shortdesc'] = $shortdesc; 
 $temp['rating'] = $rating; 
 $temp['price'] = $price; 
 $temp['image'] = $image; 
 array_push($products, $temp);
 }
 
 //displaying the result in json format 
 echo json_encode($products);

 ?>