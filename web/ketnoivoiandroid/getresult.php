<?php

$con=$con=mysql_connect("sql304.freevnn.com", "freev_16066123","123456");
if(!$con){
 die('could not connect: '.mysql_error());
}
mysql_select_db("freev_16066123_quanlybenhnhan",$con);
$result=mysql_query("SELECT * FROM Ket_qua_lam_san WHERE SDT='0908121045' ");

while($row = mysql_fetch_assoc($result)){
$output[]=$row;
}

print(json_encode($output));

mysql_close($con);
?>	