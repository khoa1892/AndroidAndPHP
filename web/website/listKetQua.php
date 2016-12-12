<meta charset="utf-8" />
<title> Kết Quả Khám </title>
<link rel="shortcut icon" href="http://phongkham2.freevnn.com/website/pictures/logo5.png"/>
<form action="" method="post">
<body bgcolor="#FFFFFF">
<h1 align="center" style="background-color:#039BE5" >Danh Sách Kết Quả Khám Bệnh</h1>
<input type="submit" value="Quay về trang chủ" name="ok"/></body>
</form>
<?php 
if(isset($_POST['ok'])){
header("location:trangchu1.php");
}
	//connection_aborted
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
	$sql ="SELECT * FROM  Ket_qua_lam_san";
	$query=mysql_query($sql);
	$data=array();
	while($row=mysql_fetch_assoc($query)){
		$data[]=$row;
	}
echo "<div align='center'>";
	echo "<table border='1' width='1000' height='300'>";
	echo "<tr>";
	echo "<td> Họ Và Tên </td>";
echo "<td> SĐT </td>";
	echo "<td> Bệnh Lý </td>";
	echo "<td> Kết Quả Xét Nghiệm </td>";
	echo "<td> Nhóm Máu </td>";
	echo "<td> Huyết Áp </td>";
	echo "<td> Cân Nặng  </td>";
	echo "</tr>";
	foreach($data as $value){
		echo "<tr>";
		echo "<td>".$value['Ho_Va_Ten']."</td>";
		echo "<td>".$value['SDT']."</td>";
		echo "<td>".$value['benh_ly']."</td>";
		echo "<td>".$value['Xet_Nghiem']."</td>";
		echo "<td>".$value['Nhom_mau']."</td>";
		echo "<td>".$value['Chieu_cao']."</td>";
echo "<td>".$value['Can_nang']."</td>";
		echo "</tr>";
	}
	echo"</table>";
echo"</div>";
?>	