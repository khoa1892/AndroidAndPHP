<?php
	$id= $_GET['id'];
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
	
	$sql="DELETE FROM Thong_tin_ca_nhan WHERE id='".$id."'";
	mysql_query($sql);
	header("location:list.php");
?>