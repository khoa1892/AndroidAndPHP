<meta charset="utf-8" />
<h1 align="center" style="background-color:#0FF">Chỉnh Sửa Bệnh Nhân</h1>
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
	$id= $_GET['id'];
	$connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
	mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
	$sql="SELECT * FROM Thong_tin_ca_nhan WHERE id=' " .$id. " ' ";
	$query = mysql_query($sql);
	$data=mysql_fetch_assoc($query);
	$Ho_Va_Ten=$Gioi_tinh=$Nam_Sinh=$Que_Quan=$email=$SDT= "";
	if(isset($_POST['ok'])){
		if($_POST['Ho_Va_Ten']==null){
			$errorName="vui long nhap ho va ten";
		}else{
			$Ho_Va_Ten=$_POST['Ho_Va_Ten'];
		}
		if($_POST['Gioi_tinh']==null){
			$errorGender="vui long nhap Gioi_tinh";
		}else{
			$Gioi_tinh=$_POST['Gioi_tinh'];
		}
		if($_POST['Nam_Sinh']==null){
			$errorDate="vui long nhap Nam_Sinh";
		}else{
			$Nam_Sinh=$_POST['Nam_Sinh'];
		}
		if($_POST['Que_Quan']==null){
			$errorAddress="vui long nhap Dia Chi";
		}else{
			$Que_Quan=$_POST['Que_Quan'];
		}
		if($_POST['email']==null){
			$errorEmail="vui long nhap Email";
		}else{
			$email=$_POST['email'];
		}
		if($_POST['SDT']==null){
			$errorPhone="vui long nhap so dien thoai";
		}else{
			$SDT=$_POST['SDT'];
		}
		if($Ho_Va_Ten && $Gioi_tinh && $Nam_Sinh && $Que_Quan && $email && $SDT){
			$sqlEdit="UPDATE Thong_tin_ca_nhan 
                      SET Ho_Va_Ten='".$Ho_Va_Ten."',
                      Gioi_tinh='".$Gioi_tinh."',
                      Nam_Sinh='".$Nam_Sinh."',
                      Que_Quan='". $Que_Quan."',
                      email='".$email."',
                      SDT='".$SDT."' WHERE id='".$id."'
                    ";
            mysql_query($sqlEdit);
    		header("location:list.php");
		}
	}

?>

<form action="" method="post">
	        <label>Họ và tên </label>
	<input type="text" name="Ho_Va_Ten" value="<?php echo $data['Ho_Va_Ten']; ?>"/>
	<span class='error'>
	<?php  echo isset($errorName) ? $errorName : "" ?>
	</span>
	</br>
	<label>Giới tính </label>
	<input type="text" name="Gioi_tinh" value="<?php echo $data['Gioi_tinh']; ?>"/>
	<span class='error'>
	<?php  echo isset($errorGender) ? $errorGender : "" ?>
	</span>
	</br>
	<label>Năm Sinh </label>
	<input type="text" name="Nam_Sinh" value="<?php echo $data['Nam_Sinh']; ?>"/>
	<span class='error'>
	<?php  echo isset($errorDate) ? $errorDate : "" ?>
	</span>
	</br>
	<label>Địa chỉ </label>
	<input type="text" name="Que_Quan" value="<?php echo $data['Que_Quan']; ?>"/>
	<span class='error'>
	<?php  echo isset($errorAddress) ? $errorAddress : "" ?>
	</span>
	</br>
	<label>Email </label>
	<input type="text" name="email" value="<?php echo $data['email']; ?>"/>
	<span class='error'>
	<?php  echo isset($errorEmail) ? $errorEmail : "" ?>
	</span>
	</br>
	<label>SDT </label>
	<input type="text" name="SDT" value="<?php echo $data['SDT']; ?>"/>
	<span class='error'>
	<?php  echo isset($errorPhone) ? $errorPhone : "" ?>
	</span>
	</br>
	<label> &nbsp; </label>
	<input type="submit" name="ok" value="Update">
</form>
	