<?php 
	$Ho_Va_Ten=$Gioi_tinh=$Nam_Sinh=$Que_Quan=$email=$SDT="";
	if(isset($_POST['ok'])){
		if($_POST['Ho_Va_Ten']==""){
			$errorName="vui lòng nhập họ và tên";
		}else{
			$Ho_Va_Ten=$_POST['Ho_Va_Ten'];
		}
		if($_POST['Gioi_tinh']==""){
			$errorGender="vui lòng nhập Giới tính";
		}else{
			$Gioi_tinh=$_POST['Gioi_tinh'];
		}
		if($_POST['Nam_Sinh']==""){
			$errorDate="vui lòng nhập Ngày tháng năm sinh";
		}else{
			$Nam_Sinh=$_POST['Nam_Sinh'];
		}
		if($_POST['Que_Quan']==""){
			$errorAddress="vui lòng nhập Địa Chỉ";
		}else{
			$Que_Quan=$_POST['Que_Quan'];
		}
		if($_POST['email']==""){
			$errorEmail="vui lòng nhập Email";
		}else{
			$email=$_POST['email'];
		}
		if($_POST['SDT']==""){
			$errorPhone="vui long nhập số diện thoại";
		}else{
			$SDT=$_POST['SDT'];
		}
		if($Ho_Va_Ten && $Gioi_tinh && $Nam_Sinh && $Que_Quan && $email && $SDT){
			$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
			$sql="INSERT INTO Thong_tin_ca_nhan (Ho_Va_Ten,Gioi_tinh,Nam_Sinh,Que_Quan,email,SDT) 
					VALUES('".$Ho_Va_Ten."','".$Gioi_tinh."','".$Nam_Sinh."','".$Que_Quan."','".$email."','".$SDT."')";
echo"thêm thành công";
			mysql_query($sql);
		}
	}
    if(isset($_POST['ok1'])){
		if($_POST['Ho_Va_Ten']==""){
			$errorName="vui lòng nhập họ và tên";
		}else{
			$Ho_Va_Ten=$_POST['Ho_Va_Ten'];
		}
		if($_POST['Gioi_tinh']==""){
			$errorGender="vui lòng nhập Giới tính";
		}else{
			$Gioi_tinh=$_POST['Gioi_tinh'];
		}
		if($_POST['Nam_Sinh']==""){
			$errorDate="vui lòng nhập Ngày tháng năm sinh";
		}else{
			$Nam_Sinh=$_POST['Nam_Sinh'];
		}
		if($_POST['Que_Quan']==""){
			$errorAddress="vui lòng nhập Địa Chỉ";
		}else{
			$Que_Quan=$_POST['Que_Quan'];
		}
		if($_POST['email']==""){
			$errorEmail="vui lòng nhập Email";
		}else{
			$email=$_POST['email'];
		}
		if($_POST['SDT']==""){
			$errorPhone="vui long nhập số diện thoại";
		}else{
			$SDT=$_POST['SDT'];
		}
		if($Ho_Va_Ten && $Gioi_tinh && $Nam_Sinh && $Que_Quan && $email && $SDT){
			$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
			$sql="INSERT INTO Danh_Sach_Da_Kham (hovaten,gioitinh,namsinh,diachi,email,sdt) 
					VALUES('".$Ho_Va_Ten."','".$Gioi_tinh."','".$Nam_Sinh."','".$Que_Quan."','".$email."','".$SDT."')";
echo"đã lưu";
			mysql_query($sql);
		}
	}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="http://phongkham2.freevnn.com/website/pictures/logo5.png"/>
<title>Đăng Ký</title>
<link rel="stylesheet" type="text/css" href="http://phongkham2.freevnn.com/website/style/view.css" media="all">
<script type="text/javascript" src="http://phongkham2.freevnn.com/website/style/view.js"></script>
</head>
<body id="main_body" >
 <input type="button" value="Quay lại trang trước" onclick="history.back(-1)" />
	<img id="top" src="http://phongkham2.freevnn.com/website/style/top.png" alt="">
	<div id="form_container">
		<h1><a>Thêm Bệnh Nhân</a></h1>
		<form id="form_1030969" class="appnitro"  method="post" action="">
					<div class="form_description">
			<h2>Thêm Người Dùng</h2>
			<p>Nhập Đầy Đủ Thông Tin</p>
		</div>						
			<ul >	
			<form action="" method="post">
					<li id="li_1" >
		<label class="description" for="element_1">Họ Và Tên </label>
		<div>
			<input id="element_1" name="Ho_Va_Ten" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorName) ? $errorName : "" ?>
	</span>
	</br>
		</li>		<li id="li_2" >
		<label class="description" for="element_2">Giới Tính
 </label>
		<div>
			<input id="element_2" name="Gioi_tinh" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorGender) ? $errorGender : "" ?>
	</span>
	</br>
        </li>		<li id="li_6" >
		<label class="description" for="element_6">Năm Sinh
 </label>
		<div>
			<input id="element_6" name="Nam_Sinh" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorDate) ? $errorDate : "" ?>
	</span>
	</br>
        </li>		<li id="li_5" >
		<label class="description" for="element_5">Địa Chỉ</label>
		<div>
			<input id="element_5" name="Que_Quan" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorAddress) ? $errorAddress : "" ?>
	</span>
	</br>
		</li>		<li id="li_3" >
		<label class="description" for="element_3">Email </label>
		<div>
			<input id="element_3" name="email" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<span class='error'>
	<?php  echo isset($errorEmail) ? $errorEmail : "" ?>
	</span>
	</br>
		</li>
			</li>		<li id="li_4" >
		<label class="description" for="element_4">SĐT</label>
		<div>
			<input id="element_4" name="SDT" class="element text medium" type="text" maxlength="255" value=""/> 
		</div>
		<span class='error'>
	<?php  echo isset($errorPhone) ? $errorPhone : "" ?>
	</span>
		</li>
					<li class="buttons">		    
				<input type="submit" name="ok" value="thêm">
<input type="submit" name="ok1" value="lưu">

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