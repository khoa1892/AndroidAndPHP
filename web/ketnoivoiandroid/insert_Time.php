<?php
mysql_query("SET NAMES 'utf8'");
$link = mysqli_connect("sql304.freevnn.com", "freev_16066123", "123456", "freev_16066123_quanlybenhnhan");
//check connection
if($link == flase){
	die("ERROR: Could not connect. " . mysqli_connect_error());
}
// Attempt insert query execution
$Ho_Va_Ten = $_POST['Ho_Va_Ten'];
$SDT =$_POST['SDT'];
$sql = "INSERT INTO Thong_tin_ca_nhan (Ho_Va_Ten,SDT) VALUES ('$Ho_Va_Ten','$SDT')";
if(mysqli_query($link, $sql)){
   echo "Records added successfully.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// Close connection
mysqli_close($link);

?>	