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
foreign key(id_type_watch) references type_watch(id_type_watch),
foreign key(id_manufacturer) references manufacturer(id_manufacturer)
);

create table cart(
id_customer int,
id_watch int,
price double,
quantity int,
check_order bit,
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

create table app_user
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(45) NOT NULL UNIQUE ,
    user_pass VARCHAR(45) NOT NULL
);


create table app_role
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(10) NOT NULL UNIQUE
);


create table user_role
(
    user_id INT UNIQUE ,
    role_id INT ,
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (role_id) REFERENCES app_role(id),
    primary key(user_id,role_id)
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
insert into watch(name_watch,price,id_type_watch,id_manufacturer,image,strap_material,diameter,face_color,origin,detail) values
('ĐỒNG HỒ NAM LONGINES MASTER COLLECTION',103500000,1,1,'https://donghoduyanh.com/images/products/2021/07/01/large/l27935577_1625107594.jpg.webp','Thép không gỉ 316L/ Vàng 18K','40mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Caliber L888, 25.200vph, trữ cót 64h. Mặt số đính 13 viên kim cương tổng 0.059 carat.<br>Độ chịu nước:30m<br>Bảo hành chính hãng:5 năm quốc tế'),
('ĐỒNG HỒ NAM HAMILTON KHAKI FIELD TITANIUM',25300000,1,2,'https://donghoduyanh.com/images/products/2023/03/16/large/h70545560_1678959432-copy.png.webp','Vàng 18K','42mm','Xanh lá','Thụy Sỹ','Với kích thước nhỏ hơn, vỏ thiết kế gọn hơn cùng nhiều kiểu dáng và kết cấu có tính thừa kế và đối tượng không chỉ dừng lại ở môi trường quân nhân mà đây có thể là một bước ngoặt lấn sang đối tượng cụ thể khác trong tương lai, các mẫu đồng hồ Hamilton Khaki Field Titanium mới mang đến những cá tính mới, sự hấp dẫn về phong cách và khả năng vận hành đáng tin cậy của một thương hiệu tên tuổi lớn lấy quân sự làm nền tảng xây dựng thương hiệu đồng hồ.<br>Bảo hành chính hãng:2 năm quốc tế'),
('ĐỒNG HỒ NỮ HAMILTON JAZZMASTER OPEN HEART',24860000,1,2,'https://donghoduyanh.com/images/products/2021/11/26/large/h32215840_1637943300.jpg.webp','Dây da','36mm','Xanh lam','Thụy Sĩ','Độ chịu nước:50m.<br>Tính năng khác:Open Heart. Caliber H-10, trữ cót 80h.<br>Bảo hành chính hãng:2 năm quốc tế'),
('ĐỒNG HỒ NAM TISSOT EVERYTIME',8190000,2,3,'https://donghoduyanh.com/images/products/2020/03/17/large/tissot_everytime_t1096101103100.jpg.webp','Thép không gỉ 316L','42mm','Trắng','Thụy Sĩ','Mặt kính:Sapphire<br>Độ chịu nước:30m<br>Bảo hành chính hãng:2 năm Quốc tế'),
('ĐỒNG HỒ NỮ TISSOT BELLISSIMA SMALL',30240000,2,3,'https://donghoduyanh.com/images/products/2022/12/15/large/t1260106111300_1671112173.jpg.webp','Thép không gỉ 316L','26mm','Khảm trai','Thụy Sỹ','Mặt kính:Sapphire<br>Tính năng khác:Lịch ngày.Vỏ đính 47 viên kim cương tổng 0.2021 carat.Sapphire chống lóa.Khối lượng 59g.<br>Độ chịu nước:50m<br>Bảo hành chính hãng:2 năm quốc tế'),
('ĐỒNG HỒ NAM CITIZEN ECO-DRIVE',9020000,3,4,'https://donghoduyanh.com/images/products/2022/11/30/large/bn0157-11x_1669827218.jpg.webp','Dây cao su','44mm','Xanh Lá','Nhật Bản','Tính năng khác:Lịch ngày.<br>Độ chịu nước:200m<br>Bảo hành chính hãng:1 năm quốc tế'),
('ĐỒNG HỒ NAM CASIO EDIFICE EFV-600D',3529000,4,5,'https://donghoduyanh.com/images/products/2023/03/13/large/efv-600d-3cvudf_1678693308.jpg.webp','Thép không gỉ 316L','43.8mm','Xám','Nhật Bản','Tính năng khác:Lịch ngày. Chronograph. Khối lượng 135g.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:1 năm quốc tế'),
('ĐỒNG HỒ NAM LONGINES SPIRIT',86250000,5,1,'https://donghoduyanh.com/images/products/2021/07/26/large/l38204936_1627287978.jpg.webp','Thép không gỉ 316L','42mm','Xanh lam','Thụy Sỹ','Tính năng khác:Lịch ngày. Chronograph. Caliber L688.4, 28.800vph, trữ cót 60h.<br>Độ chịu nước:100m<br>Mặt kính:Sapphire<br>Bảo hành chính hãng:5 năm quốc tế'),
('ĐỒNG HỒ NỮ LONGINES RECORD',139437000,5,1,'https://donghoduyanh.com/images/products/2022/10/26/large/l23205597_1666774761.jpg.webp','Thép không gỉ 316L/ Vàng 18K','26mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Caliber L592.4, 28.800vph, trữ cót 45h. Sapphire chống lóa. Mặt số đính 12 viên kim cương tổng 0.034 carat. Vỏ đính 52 viên kim cương tổng 0.405 carat.<br>Độ chịu nước:30m<br>,Bảo hành chính hãng:5 năm quốc tế'),
('ĐỒNG HỒ NỮ CERTINA DS-8',11950000,6,15,'https://donghoduyanh.com/images/products/2020/03/17/large/dong_ho_certina_ds-8_lady_c0330511111801.jpg.webp','Thép không gỉ 316L','27mm','Khảm trai','Thụy Sỹ','Tính năng khác:Lịch ngày. EOL. PrecidriveTM. Sapphire chống lóa.<br>Mặt kính:Sapphire<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế'),
('ĐỒNG HỒ NAM CERTINA DS-8 MOON PHASE',14710000,6,15,'https://donghoduyanh.com/images/products/2021/01/04/large/dong-ho-certina-c0334573605100_1609729818.jpg.webp','Dây da','41mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Moonphase. Caliber F05.441. Super-LumiNova. Sapphire chống lóa.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế'),
('Apple Watch SE 2022 40mm',7490000,7,11,'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/_/1_258.jpg','Cao Su','40mm','Retina LTPO OLED (1.000 nits)',null,'Tính năng: Có định vị GPS, cài ứng dụng, phát nhạc trên đồng hồ, chế độ luyện tập, hiển thị thông báo điện thoại, tùy chỉnh mặt đồng hồ, nghe gọi trên đồng hồ, nhận cuộc gọi , điều khiển chơi nhạc, kết nối tai nghe'),
('Đồng hồ thông minh Xiaomi Watch S1 Active',4490000,7,13,'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/b/l/blue2.jpg','Silicone','1.43 inch','Amoled','Trung Quốc','17 chế độ thể thao, 19 chế độ chuyên nghiệp.<br>Thực hiện cuộc gọi qua bluetooth<br>Trợ lý ảo Alexa');
