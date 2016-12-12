<meta charset="utf-8" />
<title> Bệnh Nhân </title>
<link rel="shortcut icon" href="http://phongkham2.freevnn.com/website/pictures/logo5.png"/>
<form action="" method="post">
<body bgcolor="#FFFFFF">
<h1 align="center" style="background-color:#039BE5" >Danh Sách Bệnh Nhân Đã Khám</h1>
<input type="submit" value="Quay về trang chủ" name="ok"/></body>
</form>
<?php 
if(isset($_POST['ok'])){
header("location:trangchu1.php");
}
$timeupdate =time();

	//connection_aborted
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
	$sql ="SELECT * FROM  Danh_Sach_Da_Kham";
	$query=mysql_query($sql);
	$data=array();
	while($row=mysql_fetch_assoc($query)){
		$data[]=$row;
	}
echo "<div align='center'>";
	echo "<table border='1' width='1000' height='500'>";
	echo "<tr>";
echo "<td> STT </td>";
	echo "<td> Họ Tên </td>";
	echo "<td> Giới Tinh </td>";
	echo "<td> Năm Sinh </td>";
	echo "<td> Địa Chỉ </td>";
	echo "<td> Email </td>";
	echo "<td> SĐT </td>";
echo "<td> Chức Năng </td>";
	echo "</tr>";
	foreach($data as $value){
		echo "<tr>";
echo "<td>".$value['iduser']."</td>";
		echo "<td>".$value['hovaten']."</td>";
		echo "<td>".$value['gioitinh']."</td>";
		echo "<td>".$value['namsinh']."</td>";
		echo "<td>".$value['quequan']."</td>";
		echo "<td>".$value['email']."</td>";
		echo "<td>".$value['sdt']."</td>";
echo "<td><a href='delete.php?id=".$value['id']."'> xóa </a> </td>";
		echo "</tr>";
	}
	echo"</table>";
echo"</div>";
?>	
