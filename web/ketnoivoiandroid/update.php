<?php
$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
	mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
$password =$_POST['password'];
$Que_Quan =$_POST['Que_Quan'];
$SDT =$_POST['SDT'];

$sqlEdit="UPDATE Thong_tin_ca_nhan 
                      SET Que_Quan='". $Que_Quan."',
                      password='".$password."',
                      SDT='".$SDT."' WHERE id=4";
            mysql_query($sqlEdit);
?>