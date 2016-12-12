<link rel="shortcut icon" href="http://phongkham2.freevnn.com/website/pictures/logo5.png"/>
<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title> Quản Lý Phòng Khám </title>

	<link rel="stylesheet" href="style/index_style.css">
</head>
<body background="http://phongkham2.freevnn.com/website/pictures/background-css.jpg">
	<div id="titulo">
		<p id="header">Quản Lý Phòng Khám</p>
	</div>
	 <div class="search" align="center" >
            <form action="trangchu1.php" method="get">
                Tìm Kiếm: <input type="text" name="search" />
                <input type="submit" name="ok" value="Tìm Kiếm" />
            </form>
        </div>
</hr>
 <?php
session_start();
        if (isset($_REQUEST['ok'])) {
 
            // Gán hàm addslashes để chống sql injection
            $search = addslashes($_GET['search']);
            // Dùng câu lênh like trong sql và sứ dụng toán tử % của php để tìm kiếm dữ liệu chính xác hơn.
            $query = "select * from Thong_tin_ca_nhan where Ho_Va_Ten like '%$search%'";
 $connect = mysql_connect("sql304.freevnn.com","freev_16066123","123456") or die("Server disconnect");
			mysql_select_db("freev_16066123_quanlybenhnhan",$connect);
 
            // Thực thi câu truy vấn
            $sql = mysql_query($query);
            // Đếm số đong trả về trong sql.
            $num = mysql_num_rows($sql);
 
            // Nếu $search rỗng thì báo lỗi tức là người dùng chưa nhập liệu mà đã nhấn submit.
            if (empty($search)) {
                echo "Yêu Cầu Nhập Vào Ô Trống </br>";
            } else {
                // Ngược lại nếu người dùng nhập liệu thì tiến hành xứ lý show dữ liệu.
                // Nếu $num > 0 hoặc $search khác rỗng tức là có dữ liệu mối show ra nhé, ngược lại thì báo lỗi.
                if ($num > 0 && $search != "") {
 
                    // Dùng $num để đếm số dòng trả về.
                    echo "Có $num Kết Quả :<b>$search</b>";
                    // Vòng lặp while & mysql_fetch_assoc dùng để lấy toàn bộ dữ liệu có trong table và trả về dữ liệu ở dạng array.
                    while ($row = mysql_fetch_assoc($sql)) {
                        $Ho_Va_Ten = $row['Ho_Va_Ten'];
                        $id = $row['id'];
                        $Que_Quan = $row['Que_Quan'];
                        $SDT = $row['SDT'];
                   
 
                        echo "<br /><h2>Họ Và Tên: $Ho_Va_Ten</h2><br />STT: $id</br /> Địa Chỉ: $Que_Quan</br />SĐT: $SDT</br />";
                    }
                } else {
                    echo "Khong tim thay ket qua! </br>";
                }
            }
        }
        ?>  
	<header>
		
		<div class="contenedor" id="uno">
			<a href="insertweb1.php" ><img class="icon" src="http://phongkham2.freevnn.com/website/pictures/icon6.png"></a>
			 <p class="texto">Thêm Bệnh Nhân</p> 
		</div>
		<div class="contenedor" id="dos">
			<a href="list.php" > <img class="icon" src="http://phongkham2.freevnn.com/website/pictures/User.png"></a>
 <p class="texto"> Danh Sách</p>
		</div>

		<div class="contenedor" id="tres">
			<a href="listDoctor.php" ><img class="icon" href="listDoctor.php" src="http://phongkham2.freevnn.com/website/pictures/Doctor.png"></a>

			 <p class="texto"> Danh Sách Đã Khám </p> 
		</div>
<div class="contenedor" id="cuatro">
			<a href="listKetQua.php" ><img class="icon" src="http://phongkham2.freevnn.com/website/pictures/Hospital-Lab-128.png"></a>
			<p class="texto">Kết Quả </p>
		</div>
        <div class="contenedor" id="cinco">
			<a href="thoat.php" ><img class="icon" src="http://phongkham2.freevnn.com/website/pictures/Logout-128.png"></a>
			<p class="texto">Đăng Xuất</p> 
		</div>

</header>
</body>
</html>			
						