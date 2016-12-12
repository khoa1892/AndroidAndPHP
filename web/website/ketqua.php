<?php 
	$id= $_GET['id'];
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
	mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
$sql="SELECT * FROM Thong_tin_ca_nhan WHERE id=' " .$id. " ' ";
	$query = mysql_query($sql);
	$data=mysql_fetch_assoc($query);
	$benh_ly=$Xet_Nghiem=$Nhom_mau=$Can_nang=$Chieu_cao= "";
	if(isset($_POST['ok'])){
		if($_POST['benh_ly']==null){
			$errorGender="Vui Lòng Nhập Bệnh Lý";
		}else{
			$benh_ly=$_POST['benh_ly'];
		}
		if($_POST['Xet_Nghiem']==null){
			$errorDate="Vui Lòng Nhập Kết Quả Xét Nghiệm";
		}else{
			$Xet_Nghiem=$_POST['Xet_Nghiem'];
		}
		if($_POST['Nhom_mau']==null){
			$errorAddress="Vui Lòng Nhập Nhóm Máu";
		}else{
			$Nhom_mau=$_POST['Nhom_mau'];
		}
		if($_POST['Chieu_cao']==null){
			$errorEmail="Vui Lòng Nhập Kết Quả Huyết Áp";
		}else{
			$Chieu_cao=$_POST['Chieu_cao'];
		}
if($_POST['Can_nang']==null){
			$errorPhone="Vui Lòng Nhập Cân Nặng";
		}else{
			$Can_nang=$_POST['Can_nang'];
		}
		if($benh_ly && $Xet_Nghiem && $Nhom_mau && $Can_nang&& $Chieu_cao){
			$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
			$sql="INSERT INTO Ket_qua_lam_san(Ho_Va_Ten,Xet_Nghiem,benh_ly,Nhom_mau,Can_nang,Chieu_cao,SDT) 
					VALUES('".$data['Ho_Va_Ten']."','".$Xet_Nghiem."','".$benh_ly."','".$Nhom_mau."','".$Can_nang."','".$Chieu_cao."','".$data['SDT']."')";
			mysql_query($sql);
header("location:list.php");
		}
	}

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kết Quả Khám Bệnh</title>
<link rel="shortcut icon" href="http://phongkham2.freevnn.com/website/pictures/logo5.png"/>
<link rel="stylesheet" type="text/css" href="http://phongkham2.freevnn.com/website/style/view.css" media="all">
<script type="text/javascript" src="http://phongkham2.freevnn.com/website/style/view.js"></script>

</head>
<body id="main_body" >
	
	<img id="top" src="http://phongkham2.freevnn.com/website/style/top.png" alt="">
	<div id="form_container">
		<h1><a>Kết Quả Khám Bệnh</a></h1>
		<form id="form_1030969" class="appnitro"  method="post" action="">
					<div class="form_description">
			<h2>Kết Quả Khám Bệnh</h2>
			<p>Nhập Đầy Đủ Thông Tin</p>
		</div>						
			<ul >	
			<form action="" method="post">
					<li id="li_1" >
		<label class="description" for="element_1">Họ Và Tên </label>
		<div>
			<input id="element_1" name="Ho_Va_Ten" class="element text medium" type="text" maxlength="255" value="<?php echo $data['Ho_Va_Ten']; ?>"/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorName) ? $errorName : "" ?>
	</span>
	</br>
<li id="li_7" >
		<label class="description" for="element_1">SĐT</label>
		<div>
			<input id="element_1" name="SDT" class="element text medium" type="text" maxlength="255" value="<?php echo $data['SDT']; ?>"/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorName) ? $errorName : "" ?>
	</span>
	</br>

		</li>		<li id="li_2" >
		<label class="description" for="element_2">Bệnh Lý
 </label>
		<div>
			<input id="element_2" name="benh_ly" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorGender) ? $errorGender : "" ?>
	</span>
	</br>
        </li>		<li id="li_6" >
		<label class="description" for="element_6">Kết Quả Xét Nghiệm
 </label>
		<div>
			<input id="element_6" name="Xet_Nghiem" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorDate) ? $errorDate : "" ?>
	</span>
	</br>
        </li>		<li id="li_5" >
		<label class="description" for="element_5">Nhóm Máu</label>
		<div>
			<input id="element_5" name="Nhom_mau" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorAddress) ? $errorAddress : "" ?>
	</span>
	</br>
		</li>		<li id="li_3" >
		<label class="description" for="element_3">Huyết áp</label>
		<div>
			<input id="element_3" name="Chieu_cao" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorEmail) ? $errorEmail : "" ?>
	</span>
	</br>
		</li>
			</li>		<li id="li_4" >
		<label class="description" for="element_4">Cân Nặng</label>
		<div>
			<input id="element_4" name="Can_nang" class="element text medium" type="text" maxlength="255" value=""/> 
		</div>
		<span class='error'>
	<?php  echo isset($errorPhone) ? $errorPhone : "" ?>
	</span>
		</li>
					<li class="buttons">		    
				<input type="submit" name="ok" value="thêm">
		</li>
			</ul>
		</form>	
		<div id="footer">
			Generated by <a href="http://www.phpform.org">pForm</a>
		</div>
	</div>
	<img id="bottom" src="http://phongkham2.freevnn.com/website/style/bottom.png" alt="">
	</body>
</html>	