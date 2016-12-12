<meta charset="utf-8" />
<title> Danh Sách Khám Bệnh </title>
<link rel="shortcut icon" href="http://phongkham2.freevnn.com/website/pictures/logo5.png"/>
<form action="" method="post">
<body bgcolor="#FFFFFF">
<h1 align="center" style="background-color:#039BE5" >Danh Sách Bệnh Nhân Trong Ngày </h1>
<input type="submit" value="Quay về trang chủ" name="ok"/></body>
</form>
<?php 
if(isset($_POST['ok'])){
header("location:trangchu1.php");
}
	//connection_aborted
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
	$sql ="SELECT * FROM Thong_tin_ca_nhan";
	$query=mysql_query($sql);
	$data=array();
	while($row=mysql_fetch_assoc($query)){
		$data[]=$row;
	}
echo "<div align='center'>";
	echo "<table border='2' width='1000' height='500'> ";
	echo "<tr>";
    echo "<td> STT </td>";
	echo "<td> Họ Tên </td>";
	echo "<td> Giới Tính </td>";
	echo "<td> Năm Sinh </td>";
	echo "<td> Địa Chỉ </td>";
	echo "<td> Email </td>";
	echo "<td> SDT </td>";
echo "<td> Kết Quả </td>";
	echo "<td> Sửa </td>";
	echo "<td> xóa </td>";
	echo "</tr>";
	foreach($data as $value){
		echo "<tr>";
        echo "<td>".$value['id']."</td>";
		echo "<td>".$value['Ho_Va_Ten']."</td>";
		echo "<td>".$value['Gioi_tinh']."</td>";
		echo "<td>".$value['Nam_Sinh']."</td>";
		echo "<td>".$value['Que_Quan']."</td>";
		echo "<td>".$value['email']."</td>";
		echo "<td>".$value['SDT']."</td>";
echo "<td><a href='ketqua.php?id=".$value['id']."'> Kết Quả </a> </td>";
		echo "<td><a href='update1.php?id=".$value['id']."'> sửa </a> </td>";
		echo "<td><a href='delete.php?id=".$value['id']."'> xóa </a> </td>";
		echo "</tr>";
	}
	echo"</table>";
echo"</div>";
?>		