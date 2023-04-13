drop database if exists shop_watch;
create database shop_watch;
use shop_watch;

create table type_customer(
id_type_cus int primary key auto_increment,
name_type_cus varchar(45) not null
);

create table positions(
id_position int primary key auto_increment,
name_position varchar(45) not null
);

create table diploma(
id_diploma int primary key auto_increment,
name_diploma varchar(255) not null
);

create table type_watch(
id_type_watch int primary key auto_increment,
name_type_watch varchar(255) not null
);

create table manufacturer(
id_manufacturer int primary key auto_increment,
name_manufacturer varchar(45) not null
);

create table branch(
id_branch int primary key auto_increment,
name_branch varchar(45) not null,
address_branch varchar(255) not null,
area_branch double not null
);

create table employee(
id_employee int primary key auto_increment,
name_employee varchar(255) not null,
date_of_birth date not null,
gender varchar(45) not null,
salary double not null,
address varchar(255) not null,
phone_number varchar(45) not null,
email_employee varchar(255) not null,
img text,
id_diploma int,
id_position int,
id_branch int,
foreign key(id_position) references positions(id_position),
foreign key(id_diploma) references diploma(id_diploma),
foreign key(id_branch) references branch(id_branch)
);


create table customer(
id_customer int primary key auto_increment,
name_customer varchar(45) not null,
date_of_birth date not null,
address varchar(255) not null,
email_customer varchar(255) not null unique,
phone_number varchar(45) not null unique,
id_type_cus int,
foreign key(id_type_cus) references type_customer(id_type_cus)
);

create table watch(
id_watch int primary key auto_increment,
name_watch varchar(45) not null,
price int not null,
id_type_watch int,
id_manufacturer int,
image text not null,
strap_material varchar(45) not null, -- chất liệu dây
diameter varchar(45) not null,  -- đường kính mặt 
face_color varchar(45) not null, -- màu sắc
origin varchar(45),  -- xuất xứ
detail text not null,
quantity int,
foreign key(id_type_watch) references type_watch(id_type_watch),
foreign key(id_manufacturer) references manufacturer(id_manufacturer)
);

create table cart(
id_customer int,
id_watch int,
price double,
quantity int,
check_order bit,
image text,
foreign key(id_customer) references customer(id_customer),
foreign key(id_watch) references watch(id_watch),
primary key(id_customer,id_watch)
);

create table order_watch(
id_order int primary key auto_increment,
id_customer int,
date_order date,
total_price int,
foreign key(id_customer) references customer(id_customer)
);

create table order_detail(
id_order int,
id_watch int,
quantity int not null,
price int,
image text,
foreign key(id_order) references order_watch(id_order),
foreign key(id_watch) references watch(id_watch),
primary key(id_order,id_watch)
);


create table manage_product_branch(
id_branch int,
id_watch int,
foreign key(id_branch) references branch(id_branch),
foreign key(id_watch) references watch(id_watch),
primary key(id_branch,id_watch)
);

create table account_user
(
    name_account VARCHAR(45) primary key,
    pass_word VARCHAR(45) NOT NULL
);


create table role_user
(
    id_role INT AUTO_INCREMENT PRIMARY KEY,
    name_role VARCHAR(10) NOT NULL UNIQUE
);


create table account_role
(
    name_account VARCHAR(45)  ,
    id_role INT ,
    FOREIGN KEY (name_account) REFERENCES account_user(name_account),
    FOREIGN KEY (id_role) REFERENCES role_user(id_role),
    primary key(name_account,id_role)
);


insert into type_customer(name_type_cus)
value('Diamond'),
('Paltinium'),
('Gold'),
('Silver'),
('Member');
insert into customer(name_customer, date_of_birth, address, email_customer, phone_number, id_type_cus)
value('Đoàn Thành Tiến','1993-12-03','123 Phan Châu Trinh, Đà Nẳng','tienDoan123@gmail.com','0911899574',1),
('Trần Thị Tín','2000-12-25','45 Đống Đa, Quảng Nam','tinTran345@gmail.com','0918869572',2),
('Ngô Văn Vũ','1991-04-24','60 Nguyễn Huệ, Quảng Nam','VuNgo1994@gmail.com','0816829570',1),
('Nguyễn Phước Thành Nhân','1992-04-11','45 Trần Bá Song, Huế','NhanNguyen1994@gmail.com','0918897575',3),
('Hoàng Tất Đạt','2005-06-15','78 Phan Tứ, Đà Nẳng','NguyenDat123@gmail.com','0911819572',4),
('Nguyễn Thị Ánh Phúc','2001-04-30','89 Chu Văn An, Huế','PhucPham456@gmail.com','0816599576',5),
('Hồ Thị Thu Thảo','1980-12-11','60 Nguyễn Huệ, Hà Nội','Thao241@gmail.com','0918869570',5),
('Phan Ngọc Hải Đăng','1992-08-11','50 Châu Thị Vĩnh Tế, Đà Nẳng','DangGa34@gmail.com','0954839572',3),
('Ngô Định Vũ','2005-01-11','10 Trần Hưng Đạo, Huế','dinhvu24@gmail.com','0973859571',2),
('Hoàng Hữu Đạt','2005-01-11','50 Nguyễn Chí Thanh, Huế, Quảng Nam','datNguyen4@gmail.com','0990829578',5),
('Trần Văn Thanh','2000-09-15','234 Ngô Quyền, Hồ Chí Minh','thanh2000@gmail.com','0987894572',3);

insert into branch (name_branch , address_branch , area_branch) values ('Chi nhánh Hà Nội' , '310 Xã Đàn, Phường Phương Liên, Quận Đống Đa, Hà Nội' , 50.0) ,
('Chi nhánh Đà Nẵng' , '71 Nguyễn Lương Bằng, Hòa Khánh, Liên Chiểu, Đà Nẵng' , 50.0) ,
('Chi nhánh Hồ Chí minh' , '64 Võ Thị Sáu, phường Tân Định, quận 1, TP. HCM' , 50.0) ,
('Chi nhánh Hải Phòng' , '342 P.Tô Hiệu , Hà Nam , Hải Phòng' , 50.0);

insert into type_watch(name_type_watch) values
('Đồng hồ cơ – Automatic'),
('Đồng hồ Quartz '),
('Eco-Drive (Năng lượng ánh sáng)'),
('Quartz Chronograph (Máy pin bấm giờ thể thao)'),
('Automatic Chronometer (Máy cơ tự động chuẩn COSC)'),
('Quartz Chronometer (Máy pin chuẩn COSC)'),
('Đồng hồ thông minh');
insert into manufacturer(name_manufacturer) values
('LONGINES'),
('HAMILTON'),
('TISSOT'),
('CITIZEN'),
('CASIO'),  
('CALVIN KLEIN'),  
('FOSSIL'),      
('MICHAEL KORS'), 
('DANIEL WELLINGTON'),  
('TITONI'),        
('APPLE'),         
('SAMSUNG'),       
('XIAOMI'),        
('HUAWEI'),
('CERTINA');      
insert into watch(name_watch,price,id_type_watch,id_manufacturer,image,strap_material,diameter,face_color,origin,detail,quantity) values
('ĐỒNG HỒ NAM LONGINES MASTER COLLECTION',103500000,1,1,'https://donghoduyanh.com/images/products/2021/07/01/large/l27935577_1625107594.jpg.webp','Thép không gỉ 316L/ Vàng 18K','40mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Caliber L888, 25.200vph, trữ cót 64h. Mặt số đính 13 viên kim cương tổng 0.059 carat.<br>Độ chịu nước:30m<br>Bảo hành chính hãng:5 năm quốc tế',10),
('ĐỒNG HỒ NAM HAMILTON KHAKI FIELD TITANIUM',25300000,1,2,'https://donghoduyanh.com/images/products/2023/03/16/large/h70545560_1678959432-copy.png.webp','Vàng 18K','42mm','Xanh lá','Thụy Sỹ','Với kích thước nhỏ hơn, vỏ thiết kế gọn hơn cùng nhiều kiểu dáng và kết cấu có tính thừa kế và đối tượng không chỉ dừng lại ở môi trường quân nhân mà đây có thể là một bước ngoặt lấn sang đối tượng cụ thể khác trong tương lai, các mẫu đồng hồ Hamilton Khaki Field Titanium mới mang đến những cá tính mới, sự hấp dẫn về phong cách và khả năng vận hành đáng tin cậy của một thương hiệu tên tuổi lớn lấy quân sự làm nền tảng xây dựng thương hiệu đồng hồ.<br>Bảo hành chính hãng:2 năm quốc tế',20),
('ĐỒNG HỒ NỮ HAMILTON JAZZMASTER OPEN HEART',24860000,1,2,'https://donghoduyanh.com/images/products/2021/11/26/large/h32215840_1637943300.jpg.webp','Dây da','36mm','Xanh lam','Thụy Sĩ','Độ chịu nước:50m.<br>Tính năng khác:Open Heart. Caliber H-10, trữ cót 80h.<br>Bảo hành chính hãng:2 năm quốc tế',15),
('ĐỒNG HỒ NAM TISSOT EVERYTIME',8190000,2,3,'https://donghoduyanh.com/images/products/2020/03/17/large/tissot_everytime_t1096101103100.jpg.webp','Thép không gỉ 316L','42mm','Trắng','Thụy Sĩ','Mặt kính:Sapphire<br>Độ chịu nước:30m<br>Bảo hành chính hãng:2 năm Quốc tế',10),
('ĐỒNG HỒ NỮ TISSOT BELLISSIMA SMALL',30240000,2,3,'https://donghoduyanh.com/images/products/2022/12/15/large/t1260106111300_1671112173.jpg.webp','Thép không gỉ 316L','26mm','Khảm trai','Thụy Sỹ','Mặt kính:Sapphire<br>Tính năng khác:Lịch ngày.Vỏ đính 47 viên kim cương tổng 0.2021 carat.Sapphire chống lóa.Khối lượng 59g.<br>Độ chịu nước:50m<br>Bảo hành chính hãng:2 năm quốc tế',20),
('ĐỒNG HỒ NAM CITIZEN ECO-DRIVE',9020000,3,4,'https://donghoduyanh.com/images/products/2022/11/30/large/bn0157-11x_1669827218.jpg.webp','Dây cao su','44mm','Xanh Lá','Nhật Bản','Tính năng khác:Lịch ngày.<br>Độ chịu nước:200m<br>Bảo hành chính hãng:1 năm quốc tế',30),
('ĐỒNG HỒ NAM CASIO EDIFICE EFV-600D',3529000,4,5,'https://donghoduyanh.com/images/products/2023/03/13/large/efv-600d-3cvudf_1678693308.jpg.webp','Thép không gỉ 316L','43.8mm','Xám','Nhật Bản','Tính năng khác:Lịch ngày. Chronograph. Khối lượng 135g.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:1 năm quốc tế',30),
('ĐỒNG HỒ NAM LONGINES SPIRIT',86250000,5,1,'https://donghoduyanh.com/images/products/2021/07/26/large/l38204936_1627287978.jpg.webp','Thép không gỉ 316L','42mm','Xanh lam','Thụy Sỹ','Tính năng khác:Lịch ngày. Chronograph. Caliber L688.4, 28.800vph, trữ cót 60h.<br>Độ chịu nước:100m<br>Mặt kính:Sapphire<br>Bảo hành chính hãng:5 năm quốc tế',30),
('ĐỒNG HỒ NỮ LONGINES RECORD',139437000,5,1,'https://donghoduyanh.com/images/products/2022/10/26/large/l23205597_1666774761.jpg.webp','Thép không gỉ 316L/ Vàng 18K','26mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Caliber L592.4, 28.800vph, trữ cót 45h. Sapphire chống lóa. Mặt số đính 12 viên kim cương tổng 0.034 carat. Vỏ đính 52 viên kim cương tổng 0.405 carat.<br>Độ chịu nước:30m<br>,Bảo hành chính hãng:5 năm quốc tế',20),
('ĐỒNG HỒ NỮ CERTINA DS-8',11950000,6,15,'https://donghoduyanh.com/images/products/2020/03/17/large/dong_ho_certina_ds-8_lady_c0330511111801.jpg.webp','Thép không gỉ 316L','27mm','Khảm trai','Thụy Sỹ','Tính năng khác:Lịch ngày. EOL. PrecidriveTM. Sapphire chống lóa.<br>Mặt kính:Sapphire<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',20),
('ĐỒNG HỒ NAM CERTINA DS-8 MOON PHASE',14710000,6,15,'https://donghoduyanh.com/images/products/2021/01/04/large/dong-ho-certina-c0334573605100_1609729818.jpg.webp','Dây da','41mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Moonphase. Caliber F05.441. Super-LumiNova. Sapphire chống lóa.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',30),
('Apple Watch SE 2022 40mm',7490000,7,11,'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/_/1_258.jpg','Cao Su','40mm','Retina LTPO OLED (1.000 nits)',null,'Tính năng: Có định vị GPS, cài ứng dụng, phát nhạc trên đồng hồ, chế độ luyện tập, hiển thị thông báo điện thoại, tùy chỉnh mặt đồng hồ, nghe gọi trên đồng hồ, nhận cuộc gọi , điều khiển chơi nhạc, kết nối tai nghe',10),
('Đồng hồ thông minh Xiaomi Watch S1 Active',4490000,7,13,'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/b/l/blue2.jpg','Silicone','1.43 inch','Amoled','Trung Quốc','17 chế độ thể thao, 19 chế độ chuyên nghiệp.<br>Thực hiện cuộc gọi qua bluetooth<br>Trợ lý ảo Alexa',30);

insert into diploma(name_diploma)
values
('Giám đốc'),
('Thư kí'),
('Quản lý'),
('Nhân viên bán hàng'),
('Thực tập');
insert into positions(name_position)
values
('Tiến sĩ'),
('Đại học'),
('Cao đẳng'),
('Trung cấp'),
('Không có');
insert into employee(name_employee,date_of_birth,gender,salary,address,phone_number,email_employee,img,id_diploma,id_position ,id_branch )
values
('Nguyễn Văn An','1970-11-07','Nam','5000','295 Nguyễn Tất Thành, Đà Nẵng','0901234121','annguyen@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,1),
('Lê Văn Bình','1997-04-09','Nam','2000','22 Yên Bái, Đà Nẵng','0934212314','binhlv@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,2),
('Hồ Thị Yến','1995-12-12','Nữ','3000','K234/11 Điện Biên Phủ, Gia Lai','0412352315','thiyen@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,3),
('Võ Công Toản','1980-04-04','Nam','1000','77 Hoàng Diệu, Quảng Trị','0374443232','toan0404@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,3),
('Nguyễn Bỉnh Phát','1999-12-09','Nam','500','43 Yên Bái, Đà Nẵng','0902341231','phatphat@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,2),
('Khúc Nguyễn An Nghi','2000-11-08','Nam','5000','294 Nguyễn Tất Thành, Đà Nẵng','0978653213','annghi20@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,1),
('Nguyễn Hữu Hà','1993-01-01','Nam','3000','4 Nguyễn Chí Thanh, Huế','0941234553','nhh0101@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,2),
('Nguyễn Hà Đông','1989-09-03','Nam','2000','111 Hùng Vương, Hà Nội','0642123111','donghanguyen@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,3),
('Tòng Hoang','1982-09-03','Nam','1000','213 Hàm Nghi, Đà Nẵng','0245144444','hoangtong@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,3),
('Nguyễn Công Đạo','1994-01-08','Nam','500','6 Hoà Khánh, Đồng Nai','0988767111','nguyencongdao12@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,2),
('Nguyễn Thị Hào','1970-11-07','Nữ','5000','23 Nguyễn Hoàng, Đà Nẵng','0945423362','thihao07@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,1),
('Phạm Xuân Diệu','1992-08-08','Nam','3000','K77/22 Thái Phiên, Quảng Trị','0954333333','xuandieu92@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,2),
('Trương Đình Nghệ','1989-12-11','Nam','2000','K323/12 Ông Ích Khiêm, Vinh','0373213122','nghenhan2702@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,3),
('Dương Văn Quan','1981-07-08','Nam','1000','K453/12 Lê Lợi, Đà Nẵng','0490039241','duongquan@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,3),
('Hoàng Trần Nhi Nhi','1995-12-09','Nữ','500','224 Lý Thái Tổ, Gia Lai','0312345678','nhinhi123@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,2),
('Tôn Nữ Mộc Châu','2005-12-06','Nữ','5000','37 Yên Thế, Đà Nẵng','0988888844','tonnuchau@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,1),
('Nguyễn Mỹ Kim','1984-04-08','Nữ','3000','K123/45 Lê Lợi, Hồ Chí Minh','0912345698','kimcuong84@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,2),
('Nguyễn Thị Hào','1999-04-08','Nữ','2000','55 Nguyễn Văn Linh, Kon Tum','0763212345','haohao99@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,3),
('Trần Đại Danh','1994-07-01','Nam','1000','24 Lý Thường Kiệt, Quảng Ngãi','0643343433','danhhai99@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,2),
('Nguyễn Tâm Đắc','1989-07-01','Nam','500','22 Ngô Quyền, Đà Nẵng','0987654321','dactam@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,3),
('Trần Thị Dung','1989-12-11','Nữ','5000','88 Hồ Nghinh, Đà Nẵng','0907326463','dungtran@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1),
('Nguyễn Phan Bảo Hoàng','1998-11-11','Nam','3000','22 Phan Thanh, Đà Nẵng','0998311563','hoangbaophan@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1),
('Nguyễn Thị Bích Ngọc','1996-10-11','Nữ','2000','121 Tố Hữu, Đà Nẵng','0903111563','bichngoc@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1),
('Tạ Đình Vũ Đàm','1997-07-11','Nam','1000','111 Phan Tứ, Đà Nẵng','0905323563','damvuta@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1),
('Nguyễn Thị Hương Trà','1999-02-11','Nữ','500','453 Bạch Đằng, Đà Nẵng','0909124863','huongtra@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1);
