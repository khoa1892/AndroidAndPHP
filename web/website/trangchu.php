<meta charset="utf-8" />
<body>
<h1 align="center" style="background-color:#0FF">Quản Lý Bệnh Nhân </h1>
</body>
<html>
    <head>
        <title>Quản Lý Bệnh Nhân</title>
    </head>
    <body>
        <div align="center">
            <form action="index.php" method="get">
                Search: <input type="text" name="search" />
                <input type="submit" name="ok" value="search" />
            </form>
        </div>
        <hr />
        <?php
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
                echo "Yeu cau nhap du lieu vao o trong </br>";
            } else {
                // Ngược lại nếu người dùng nhập liệu thì tiến hành xứ lý show dữ liệu.
                // Nếu $num > 0 hoặc $search khác rỗng tức là có dữ liệu mối show ra nhé, ngược lại thì báo lỗi.
                if ($num > 0 && $search != "") {
 
                    // Dùng $num để đếm số dòng trả về.
                    echo "$num ket qua tra ve voi tu khoa <b>$search</b>";
                    // Vòng lặp while & mysql_fetch_assoc dùng để lấy toàn bộ dữ liệu có trong table và trả về dữ liệu ở dạng array.
                    while ($row = mysql_fetch_assoc($sql)) {
                        $Ho_Va_Ten = $row['Ho_Va_Ten'];
                        $STT = $row['STT'];
                        $Que_Quan = $row['Que_Quan'];
                        $SDT = $row['SDT'];
                   
 
                        echo "<br /><h2>Ho ten: $Ho_Va_Ten</h2><br />STT: $STT</br />Dia Chi: $Que_Quan</br />SDT: $SDT</br />";
                    }
                } else {
                    echo "Khong tim thay ket qua! </br>";
                }
            }
        }
        ?>  
    </body>
</html>
<?php
    echo "<a href='insertweb.php?id=".$value['id']."'>thêm Bệnh Nhân </a> </br>";
    echo "<a href='list.php?id=".$value['id']."'> Danh Sách </a> </br>";
    echo "<a href='listDoctor.php?id=".$value['id']."'> Danh Sách Cho Bác Sĩ </a> </br>";
?>
