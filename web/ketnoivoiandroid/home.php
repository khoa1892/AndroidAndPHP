<?php
session_start();
$hostname_localhost ="sql304.freevnn.com";
$database_localhost ="freev_16066123_quanlybenhnhan";
$username_localhost ="freev_16066123";
$password_localhost ="123456";
$localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
if(!$_SESSION['user_id']){
	echo "no register";
}else{
	$user_id=inval($_SESSION['user_id']);
	$sql_query = @mysql_query("SELECT * FROM thong_tin WHERE id='{$user_id}'");
	$thong_tin = @mysql_fetch_array( $sql_query ); 
	}
?>