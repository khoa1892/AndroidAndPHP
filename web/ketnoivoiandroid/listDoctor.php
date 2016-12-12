<meta charset="utf-8" />

<?php 
	//connection_aborted
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
	$sql ="SELECT * FROM  Thong_tin_ca_nhan";
	$query=mysql_query($sql);
	$data=array();
	while($row=mysql_fetch_assoc($query)){
		$data[]=$row;
	}
	echo "<table border='1' width='700'>";
	echo "<tr>";
	echo "<td> Ho Ten </td>";
	echo "<td> Gioi Tinh </td>";
	echo "<td> Nam Sinh </td>";
	echo "<td> Dia Chi </td>";
	echo "<td> Email </td>";
	echo "<td> SDT </td>";
echo "<td> chuc nang </td>";
	echo "</tr>";
	foreach($data as $value){
		echo "<tr>";
		echo "<td>".$value['Ho_Va_Ten']."</td>";
		echo "<td>".$value['Gioi_tinh']."</td>";
		echo "<td>".$value['Nam_Sinh']."</td>";
		echo "<td>".$value['Que_Quan']."</td>";
		echo "<td>".$value['email']."</td>";
		echo "<td>".$value['SDT']."</td>";
echo "<td><a href='delete.php?id=".$value['id']."'> xoa </a> </td>";
		echo "</tr>";
	}
	echo"</table>";
?>		