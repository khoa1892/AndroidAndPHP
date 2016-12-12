<?php

$con=$con=mysql_connect("sql304.freevnn.com", "freev_16066123","123456");
if(!$con){
 die('could not connect: '.mysql_error());
}
mysql_select_db("freev_16066123_quanlybenhnhan",$con);
$result=mysql_query("SELECT Ho_Va_Ten,Tien_Kham,Tien_Xet_Nghiem,Tien_Thuoc,Thu_Tuc,Tong FROM Vien_Phi WHERE Ho_Va_Ten='Mai Dang Khoa'");

while($row = mysql_fetch_assoc($result)){
$output[]=$row;
}

print(json_encode($output));

mysql_close($con);
?>	