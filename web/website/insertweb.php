<meta charset="utf-8" />
<h1 align="center">Thêm Bệnh Nhân</h1>
<style type="text/css">
	label{
		float: left;
		width: 100px;

	}
	input{
		margin-bottom: 5px;
	}
	.error{
		color: red;
	}

</style>
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
			$sql="INSERT INTO Thong_tin_ca_nhan (Ho_Va_Ten,Gioi_tinh,Nam_Sinh, Que_Quan,email,SDT) 
					VALUES('".$Ho_Va_Ten."','".$Gioi_tinh."','".$Nam_Sinh."','".$Que_Quan."','".$email."','".$SDT."')";
			mysql_query($sql);
			echo" <h2> them thanh cong </h2>";
		}
	}

?>

<form action="" method="post">
	<label  >Họ và tên </label> 	<input type="text" name="Ho_Va_Ten" value=""/>
	<span class='error'>
	<?php  echo isset($errorName) ? $errorName : "" ?>
	</span>
	</br>
	<label>Giới tính </label>
	<input type="text" name="Gioi_tinh" value=""/>
	<span class='error'>
	<?php  echo isset($errorGender) ? $errorGender : "" ?>
	</span>
	</br>
	<label>Năm Sinh </label>
	<input type="text" name="Nam_Sinh" value=""/>
	<span class='error'>
	<?php  echo isset($errorDate) ? $errorDate : "" ?>
	</span>
	</br>
	<label>Địa chỉ </label>
	<input type="text" name="Que_Quan" value=""/>
	<span class='error'>
	<?php  echo isset($errorAddress) ? $errorAddress : "" ?>
	</span>
	</br>
	<label>Email </label>
	<input type="text" name="email" value=""/>
	<span class='error'>
	<?php  echo isset($errorEmail) ? $errorEmail : "" ?>
	</span>
	</br>
	<label>SDT </label>
	<input type="text" name="SDT" value=""/>
	<span class='error'>
	<?php  echo isset($errorPhone) ? $errorPhone : "" ?>
	</span>
	</br>
	<label> &nbsp; </label>
	<input type="submit" name="ok" value="thêm">
	</div>
</form>	
