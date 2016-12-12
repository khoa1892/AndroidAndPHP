<?php
$hostname_localhost ="sql304.freevnn.com";
$database_localhost ="freev_16066123_quanlybenhnhan";
$username_localhost ="freev_16066123";
$password_localhost ="123456";
$localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
or
trigger_error(mysql_error(),E_USER_ERROR);
 
mysql_select_db($database_localhost, $localhost);

$username = $_POST['username'] ;
$password =$_POST['password'] ;
$query_search = "select * from Thong_tin_ca_nhan where username = '".$username."' AND password = '".$password."'";
$query_exec = mysql_query($query_search) or die(mysql_error());
$rows = mysql_num_rows($query_exec);
//echo $rows;
 if($rows == 0) { 
 echo "No Such User Found"; 
 }
 else  {
    echo "User Found"; 
}
?>