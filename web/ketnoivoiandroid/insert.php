<?php
$link = mysqli_connect("sql304.freevnn.com", "freev_16066123", "123456", "freev_16066123_quanlybenhnhan");
//check connection
if($link == flase){
	die("ERROR: Could not connect. " . mysqli_connect_error());
}
// Attempt insert query execution
$username = $_POST['username'];
$password =$_POST['password'];
$phone =$_POST['phone'];
$address =$_POST['address'];
$email =$_POST['email'];
$sql = "INSERT INTO Thong_tin_ca_nhan (username, password,phone,address,email) VALUES ('$username','$password ','$phone','$address','$email')";
if(mysqli_query($link, $sql)){
   echo "Records added successfully.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// Close connection
mysqli_close($link);

?>	