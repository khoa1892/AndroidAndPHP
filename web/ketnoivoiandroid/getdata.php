<?php

$con=$con=mysql_connect("sql304.freevnn.com", "freev_16066123","123456");
if(!$con){
 die('could not connect: '.mysql_error());
}
mysql_select_db("freev_16066123_quanlybenhnhan",$con);
$result=mysql_query("SELECT * FROM Thong_tin_ca_nhan ");

while($row = mysql_fetch_assoc($result)){
$output[]=$row;
}

print(json_encode($output));

mysql_close($con);
?>	