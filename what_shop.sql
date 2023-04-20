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
create table domain(
id_domain int auto_increment primary key,
name varchar(50)
);
create table branch(
id_branch int primary key auto_increment,
name_branch varchar(45) not null,
address_branch varchar(255) not null,
area_branch double not null,
is_delete bit,
id_domain int,
foreign key(id_domain) references domain(id_domain)
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
is_delete bit,
foreign key(id_position) references positions(id_position),
foreign key(id_diploma) references diploma(id_diploma),
foreign key(id_branch) references branch(id_branch)
);
create table watch(
id_watch int primary key auto_increment,
name_watch varchar(255) not null,
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
is_delete bit,
foreign key(id_type_watch) references type_watch(id_type_watch),
foreign key(id_manufacturer) references manufacturer(id_manufacturer)
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
    user_id int auto_increment primary key,
    user_name VARCHAR(45),
    encryted_password VARCHAR(255) NOT NULL,
    enabled bit default 1
);
create table app_role
(
    role_id int AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(10) NOT NULL UNIQUE
);
create table user_role
(
    id int auto_increment primary key ,
    user_id int,
    role_id int,
    foreign key (user_id) references app_user(user_id),
    foreign key (role_id) references app_role(role_id)
);
create table customer(
id_customer int primary key auto_increment,
name_customer varchar(45) not null,
date_of_birth date not null,
address varchar(255) not null,
email_customer varchar(255) not null unique,
phone_number varchar(45) not null unique,
id_type_cus int,
user_id int not null ,
foreign key(user_id) references app_user(user_id),
foreign key(id_type_cus) references type_customer(id_type_cus)
);

create table cart(
id_customer int,
id_watch int,
price double,
quantity int,
check_order bit,
check_delete bit,
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


insert into type_customer(name_type_cus)
value('Đồng'),
('Bạc'),
('Vàng'),
('Bạch kim'),
('Kim cương');

insert into app_role
value(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');


insert into app_user(user_name, encryted_password, enabled)
value('admin123456','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('tin.tran123','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('vanvu5678','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('nhannguyen267','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('dat.hoang273','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('AnhPhuc628','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('thao.hoang233','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('dang.hai145','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('ngovu123','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('huudat728','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('van.thanh289','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('Lien.si123','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('nhuHoang123','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('tranTung784','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('thanh.liem849','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('van.hoang567','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1),
('phung.vo147','$2a$12$mHnfm/gnPDXKIpUCnCLNtuQ0cTYRQgahxL/Lr7r5PwrvFE2kzMowy', 1);

insert into user_role(user_id, role_id)
value(1,1),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2),
(11,2),
(12,2),
(13,2),
(14,2),
(15,2),
(16,2),
(17,2);

insert into customer(name_customer, date_of_birth, address, email_customer, phone_number, id_type_cus, user_id)
value('Đoàn Thành Tiến','1993-12-03','123 Phan Châu Trinh, Đà Nẳng','tienDoan123@gmail.com','0911899574',1,1),
('Trần Thị Tín','2000-12-25','45 Đống Đa, Quảng Nam','tinTran345@gmail.com','0918869572',1,2),
('Ngô Văn Vũ','1991-04-24','60 Nguyễn Huệ, Quảng Nam','VuNgo1994@gmail.com','0816829570',1,3),
('Nguyễn Phước Thành Nhân','1992-04-11','45 Trần Bá Song, Huế','NhanNguyen1994@gmail.com','0918897575',1,4),
('Hoàng Tất Đạt','2005-06-15','78 Phan Tứ, Đà Nẳng','NguyenDat123@gmail.com','0911819572',1,5),
('Nguyễn Thị Ánh Phúc','2001-04-30','89 Chu Văn An, Huế','PhucPham456@gmail.com','0816599576', 5,6),
('Hồ Thị Thu Thảo','1980-12-11','60 Nguyễn Huệ, Hà Nội','Thao241@gmail.com','0918869570',2,7),
('Phan Ngọc Hải Đăng','1992-08-11','50 Châu Thị Vĩnh Tế, Đà Nẳng','DangGa34@gmail.com','0954839572',3,8),
('Ngô Định Vũ','2005-01-11','10 Trần Hưng Đạo, Huế','dinhvu24@gmail.com','0973859571',2,9),
('Hoàng Hữu Đạt','2005-01-11','50 Nguyễn Chí Thanh, Huế, Quảng Nam','datNguyen4@gmail.com','0990829578',4,10),
('Trần Văn Thanh','2001-08-15','234 Ngô Quyền, Hồ Chí Minh','thanh2000@gmail.com','0987898172',1,11),
('Ngô Sỉ Liên','1995-09-15','234 Trần Hưng Đạo, Hồ Chí Minh','lien.si2001@gmail.com','0984894572',1,12),
('Trần Như Hoàng','1990-10-15','123 Ngô Quyền, Hà Nội','hoang.nhu1993@gmail.com','0987898972',1,13),
('Hoàng Thanh Tùng','2003-10-15','234 Đống Đa, Quảng Nam','thung.thanh3392@gmail.com','0987004572',1,14),
('Thanh Liêm','2004-09-10','20 Phan Thúc Duyện, Đà Nẳng','lien.thanh123@gmail.com','0987890072',1,15),
('Võ Văn Hoàng','1990-09-10','20 Châu Thị Vĩnh Tế, Đà Nẳng','Hoang.vo123@gmail.com','0987889272',1,16),
('Võ Trọng Phụng','2001-02-15','234 Lê Lợi, Hồ Chí Minh','phung.vo378@gmail.com','0986194572',1,17);



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



insert into watch(name_watch,price,id_type_watch,id_manufacturer,image,strap_material,diameter,face_color,origin,detail,quantity,is_delete) values
('ĐỒNG HỒ NAM LONGINES MASTER COLLECTION',103500000,1,1,'https://donghoduyanh.com/images/products/2021/07/01/large/l27935577_1625107594.jpg.webp','Thép không gỉ 316L/ Vàng 18K','40mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Caliber L888, 25.200vph, trữ cót 64h. Mặt số đính 13 viên kim cương tổng 0.059 carat.<br>Độ chịu nước:30m<br>Bảo hành chính hãng:5 năm quốc tế',20,0),
('ĐỒNG HỒ NAM HAMILTON KHAKI FIELD TITANIUM',25300000,1,2,'https://donghoduyanh.com/images/products/2023/03/16/large/h70545560_1678959432-copy.png.webp','Vàng 18K','42mm','Xanh lá','Thụy Sỹ','Với kích thước nhỏ hơn, vỏ thiết kế gọn hơn cùng nhiều kiểu dáng và kết cấu có tính thừa kế và đối tượng không chỉ dừng lại ở môi trường quân nhân mà đây có thể là một bước ngoặt lấn sang đối tượng cụ thể khác trong tương lai, các mẫu đồng hồ Hamilton Khaki Field Titanium mới mang đến những cá tính mới, sự hấp dẫn về phong cách và khả năng vận hành đáng tin cậy của một thương hiệu tên tuổi lớn lấy quân sự làm nền tảng xây dựng thương hiệu đồng hồ.<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ HAMILTON JAZZMASTER OPEN HEART',24860000,1,2,'https://donghoduyanh.com/images/products/2021/11/26/large/h32215840_1637943300.jpg.webp','Dây da','36mm','Xanh lam','Thụy Sĩ','Độ chịu nước:50m.<br>Tính năng khác:Open Heart. Caliber H-10, trữ cót 80h.<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ CITIZEN C7',8177000,1,4,'https://donghoduyanh.com/images/products/2020/10/24/large/dong-ho-citizen-nh8390-11x_1603509681.jpg.webp','Dây da','40mm','Đỏ','Nhật Bản','Citizen C7 NH8390-11X hồi sinh thiết kế đồng hồ Crystal Seven cổ điển với một vài nét hiện đại. Màu sắc của vỏ và dây đeo là sự kết hợp đồng điệu, mặt đáy trong suốt mang lại cái nhìn tinh tế về bộ chuyển động tự động Calibre 8200 với 40h dự trữ năng lượng.',20,0),
('TITONI MISS LOVELY',31003000,1,10,'https://donghoduyanh.com/images/products/2022/05/31/large/23978-srg-stc-622_1653966642.jpg.webp','Dây da','33.5mm','Khảm trai','Thuỵ Sỹ','Độ chịu nước:50m<br>Chất liệu vỏ:Thép không gỉ 316L<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM TISSOT EVERYTIME',8190000,2,3,'https://donghoduyanh.com/images/products/2020/03/17/large/tissot_everytime_t1096101103100.jpg.webp','Thép không gỉ 316L','42mm','Trắng','Thụy Sĩ','Mặt kính:Sapphire<br>Độ chịu nước:30m<br>Bảo hành chính hãng:2 năm Quốc tế',20,0),
('ĐỒNG HỒ NỮ TISSOT BELLISSIMA SMALL',30240000,2,3,'https://donghoduyanh.com/images/products/2022/12/15/large/t1260106111300_1671112173.jpg.webp','Thép không gỉ 316L','26mm','Khảm trai','Thụy Sỹ','Mặt kính:Sapphire<br>Tính năng khác:Lịch ngày.Vỏ đính 47 viên kim cương tổng 0.2021 carat.Sapphire chống lóa.Khối lượng 59g.<br>Độ chịu nước:50m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('DANIEL WELLINGTON QUADRO PRESSED MELROSE PEARL',3002400,2,9,'https://donghoduyanh.com/images/products/2022/03/08/large/quadro-pressed-melrose_1646709447.jpg.webp','Thép không gỉ 316L dạng lưới','20mm - 26mm','Khảm trai','Thuỵ Điển','Độ chịu nước:30m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('DANIEL WELLINGTON PETITE CORAL',4075000,2,9,'https://donghoduyanh.com/images/products/2022/03/08/large/quadro-pressed-rouge-recovered_1646733728.jpg.webp','Dây dù','28mm','Hồng','Thuỵ Điển','Độ chịu nước:30m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM FOSSIL INSCRIPTION',4890000,2,7,'https://donghoduyanh.com/images/products/2022/11/29/large/fs5933_1669706388.jpg.webp','Thép không gỉ 316L','42mm','Đen','Mỹ','Tính năng khác:Lịch ngày.<br>Bảo hành chính hãng:2 năm quốc tế<br>Độ chịu nước:50m',20,0),
('ĐỒNG HỒ NỮ CITIZEN ECO-DRIVE',10085000,3,4,'https://donghoduyanh.com/images/products/2022/11/30/large/em0860-51d_1669821349.jpg.webp','Thép không gỉ 316L dạng lắc','25mm','Khảm trai','Nhật Bản','Độ chịu nước:50m<br>Bảo hành chính hãng:1 năm quốc tế',20,0),
('ĐỒNG HỒ CITIZEN',8500000,3,4,'https://donghoduyanh.com/images/products/2020/03/17/large/dong_ho_citizen_ca7008-11e4261.jpg.webp','Dây da','42.5mm','Đen','Nhật Bản','Độ chịu nước:100m<br>Tính năng khác:ECO-DRIVE hấp thụ năng lượng từ ánh sáng. Chức năng bấm giờ thể thao<br>Bảo hành chính hãng:1 năm quốc tế',20,0),
('ĐỒNG HỒ NAM FOSSIL MINIMALIST SOLAR FS5840',3636000,3,7,'https://donghoduyanh.com/images/products/2022/11/29/large/fs5840_1669733221.jpg.webp','Dây da','22mm','Đen','Mỹ','Tính năng khác:Lịch ngày.<br>Độ chịu nước:50m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM CITIZEN ECO-DRIVE',9020000,3,4,'https://donghoduyanh.com/images/products/2022/11/30/large/bn0157-11x_1669827218.jpg.webp','Dây cao su','44mm','Xanh Lá','Nhật Bản','Tính năng khác:Lịch ngày.<br>Độ chịu nước:200m<br>Bảo hành chính hãng:1 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ CITIZEN EM0770-52Y',9660000,3,4,'https://donghoduyanh.com/images/products/2020/07/03/large/dong-ho-citizen-em0770-52y_1593746770.jpg.webp','Thép không gỉ 316L','31mm','Đen','Nhật Bản','Độ chịu nước:50m<br>Bảo hành chính hãng:1 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ TISSOT DRESSPORT',61600000,4,3,'https://donghoduyanh.com/images/products/2020/03/17/large/tissot_dressport_t0502176711701.jpg.webp','Dây da','35mm','Trắng','Thụy Sỹ','Tính năng khác:Lịch ngày. Vành đính kim cương.<br>Độ chịu nước:30m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ TISSOT PR 100 SPORT CHIC',16800000,4,3,'https://donghoduyanh.com/images/products/2020/07/29/large/t1019173303100_1596007037.jpg.webp','Thép không gỉ 316L dạng lưới','38mm','Hồng','Thụy Sỹ','Tính năng khác:Lịch ngày. Chronograph<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM FOSSIL NEUTRA',5180000,4,7,'https://donghoduyanh.com/images/products/2022/12/07/large/fs5699_1670429893.jpg.webp','Thép không gỉ 316L dạng lưới','44mm','Đen','Mỹ','Tính năng khác:Lịch ngày. Chronograph.<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM TISSOT SUPERSPORT CHRONO',14180000,4,3,'https://donghoduyanh.com/images/products/2022/03/30/large/t1256173705101_1648628387.jpg.webp','Dây dù','45.5mm','Đen','Thụy Sỹ','Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM CASIO EDIFICE EFV-600D',3529000,4,5,'https://donghoduyanh.com/images/products/2023/03/13/large/efv-600d-3cvudf_1678693308.jpg.webp','Thép không gỉ 316L','43.8mm','Xám','Nhật Bản','Tính năng khác:Lịch ngày. Chronograph. Khối lượng 135g.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:1 năm quốc tế',20,0),
('ĐỒNG HỒ NAM LONGINES SPIRIT',86250000,5,1,'https://donghoduyanh.com/images/products/2021/07/26/large/l38204936_1627287978.jpg.webp','Thép không gỉ 316L','42mm','Xanh lam','Thụy Sỹ','Tính năng khác:Lịch ngày. Chronograph. Caliber L688.4, 28.800vph, trữ cót 60h.<br>Độ chịu nước:100m<br>Mặt kính:Sapphire<br>Bảo hành chính hãng:5 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ LONGINES RECORD',139437000,5,1,'https://donghoduyanh.com/images/products/2022/10/26/large/l23205597_1666774761.jpg.webp','Thép không gỉ 316L/ Vàng 18K','26mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Caliber L592.4, 28.800vph, trữ cót 45h. Sapphire chống lóa. Mặt số đính 12 viên kim cương tổng 0.034 carat. Vỏ đính 52 viên kim cương tổng 0.405 carat.<br>Độ chịu nước:30m<br>,Bảo hành chính hãng:5 năm quốc tế',20,0),
('ĐỒNG HỒ NAM TITONI MASTER',61388000,5,10,'https://donghoduyanh.com/images/products/2022/09/30/large/94388-s-676_1664545180.jpg.webp','Thép không gỉ 316L','41mm','Xanh lam','Thuỵ Sỹ','Tính năng khác:Lịch ngày. Đồng hồ báo năng lượng. Caliber Sellita SW470, 26 chân kính, trữ cót 40h. Sapphire chống lóa.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ LONGINES RECORD COLLECTION',66125000,5,1,'https://donghoduyanh.com/images/products/2021/10/04/large/l23204872_1633340930.jpg.webp','Dây da','26mm','Trắng','Thụy Sỹ','Tính năng khác:Lịch ngày. Mặt số đính 12 viên kim cương tổng 0.034 Carats. Caliber L592.4, 28.800vph, trữ cót 45h. Sapphire chống lóa<br>Bảo hành chính hãng:5 năm quốc tế',20,0),
('ĐỒNG HỒ NAM TITONI SEASCOPER',46800000,5,10,'https://donghoduyanh.com/images/products/2022/11/23/large/83300-s-be-t4-706_1669214150.jpg.webp','Dây dù','42mm','Đen','Thụy Sỹ','Độ chịu nước:300m<br>Tính năng khác:Lịch ngày. Caliber Sellita SW200-1, 26 chân kính, 28.800vph, trữ cót 38h. Ceramic Bezel.<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ CERTINA DS-8',11950000,6,15,'https://donghoduyanh.com/images/products/2020/03/17/large/dong_ho_certina_ds-8_lady_c0330511111801.jpg.webp','Thép không gỉ 316L','27mm','Khảm trai','Thụy Sỹ','Tính năng khác:Lịch ngày. EOL. PrecidriveTM. Sapphire chống lóa.<br>Mặt kính:Sapphire<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM CERTINA DS-8 MOON PHASE',14710000,6,15,'https://donghoduyanh.com/images/products/2021/01/04/large/dong-ho-certina-c0334573605100_1609729818.jpg.webp','Dây da','41mm','Đen','Thụy Sỹ','Tính năng khác:Lịch ngày. Moonphase. Caliber F05.441. Super-LumiNova. Sapphire chống lóa.<br>Độ chịu nước:100m<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NAM CERTINA DS PODIUM CHRONOMETER',19010000,6,15,'https://donghoduyanh.com/images/products/2020/03/17/large/dong_ho_certina_ds_podium_cchronometer_c0346541104700.jpg.webp','Thép không gỉ 316L','42mm','Xanh lam','Thụy Sỹ','Độ chịu nước:100m<br>Tính năng khác:Lịch ngày. Chronograph. Tachymetre. PrecidriveTM. EOL. Super-LumiNova. Sapphire chống lóa<br>Bảo hành chính hãng:2 năm quốc tế',20,0),
('ĐỒNG HỒ NỮ CERTINA DS-8 MOON PHASE',13480000,6,15,'https://donghoduyanh.com/images/products/2021/06/21/large/c0332571111800_1624247019.jpg.webp','Thép không gỉ 316L','32.5mm','Khảm trai','Thụy Sỹ','Độ chịu nước:100m<br>Tính năng khác:Lịch ngày. Moonphase. PrecidriveTM. EOL.<br>Bảo hành chính hãng:3 năm quốc tế',20,0),
('TISSOT PR 100 GENT COSC',18550000,6,3,'https://donghoduyanh.com/images/products/2020/03/17/large/tissot_pr_100_gent_cosc_t1014512203100.jpg.webp','Thép không gỉ 316L mạ vàng công nghệ PVD','39mm','Trắng','Thuỵ Sỹ','Độ chịu nước:100m<br>Tính năng khác:Lịch ngày. QUARTZ CHRONOMETER COSC. Sai số 10giây/ năm<br>Bảo hành chính hãng:3 năm quốc tế',20,0),
('Đồng hồ thông minh Huawei Watch Fit 2',3290000,7,14,'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/h/u/huawei-band.jpg','Silicone','1.74 inch','Màn hình Amoled','Trung Quốc','Tính năng: Có định vị GPS, Màn hình luôn hiển thị, Tùy chỉnh mặt đồng hồ, Nghe gọi trên đồng hồ, Nhận cuộc gọi',20,0),
('Đồng hồ thông minh Huawei Watch GT Cyber viền nhựa',5990000,7,14,'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/h/u/huawei_12_.png','Cao Su','1.32 inches','Kính cường lực','Trung Quốc','Tính năng:Có định vị GPS, Cài ứng dụng, Phát nhạc trên đồng hồ, Chế độ luyện tập, Hiển thị thông báo điện thoại, Tùy chỉnh mặt đồng hồ, Nghe gọi trên đồng hồ, Điều khiển chơi nhạc, Kết nối tai nghe',20,0),
('Samsung Galaxy Watch 5',5490000,7,12,'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/a/sansung_1__2.png','Silicone','40 mm','Xám Graphite, Bạc, Hồng vàng',null,'Hỗ trợ sức khỏe<br>Hỗ trợ hơn 90 chế độ tập luyện thể thao.<br>Hỗ trợ đo Sp02, đo nhịp tim, huyết áp.<br>Cải thiện cảm biến theo dõi lộ trình tập luyện, theo dõi giấc ngủ',20,0),
('Apple Watch SE 2022 40mm',7490000,7,11,'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/_/1_258.jpg','Cao Su','40mm','Retina LTPO OLED (1.000 nits)',null,'Tính năng: Có định vị GPS, cài ứng dụng, phát nhạc trên đồng hồ, chế độ luyện tập, hiển thị thông báo điện thoại, tùy chỉnh mặt đồng hồ, nghe gọi trên đồng hồ, nhận cuộc gọi , điều khiển chơi nhạc, kết nối tai nghe',20,0),
('Đồng hồ thông minh Xiaomi Watch S1 Active',4490000,7,13,'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/b/l/blue2.jpg','Silicone','1.43 inch','Amoled','Trung Quốc','17 chế độ thể thao, 19 chế độ chuyên nghiệp.<br>Thực hiện cuộc gọi qua bluetooth<br>Trợ lý ảo Alexa',20,0);

insert into domain(name) values ('Miền Bắc') , ('Miền Trung') , ('Miền Nam');

insert into employee(name_employee,date_of_birth,gender,salary,address,phone_number,email_employee,img,id_diploma,id_position ,id_branch , is_delete )
values
('Nguyễn Văn An','1970-11-07','Nam','5000','295 Nguyễn Tất Thành, Đà Nẵng','0901234121','annguyen@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,1 , 0),
('Lê Văn Bình','1997-04-09','Nam','2000','22 Yên Bái, Đà Nẵng','0934212314','binhlv@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,2 ,0),
('Hồ Thị Yến','1995-12-12','Nữ','3000','K234/11 Điện Biên Phủ, Gia Lai','0412352315','thiyen@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,3 , 0),
('Võ Công Toản','1980-04-04','Nam','1000','77 Hoàng Diệu, Quảng Trị','0374443232','toan0404@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,3 , 0),
('Nguyễn Bỉnh Phát','1999-12-09','Nam','500','43 Yên Bái, Đà Nẵng','0902341231','phatphat@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',1,1,2 , 0),
('Khúc Nguyễn An Nghi','2000-11-08','Nam','5000','294 Nguyễn Tất Thành, Đà Nẵng','0978653213','annghi20@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,1,0),
('Nguyễn Hữu Hà','1993-01-01','Nam','3000','4 Nguyễn Chí Thanh, Huế','0941234553','nhh0101@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,2,0),
('Nguyễn Hà Đông','1989-09-03','Nam','2000','111 Hùng Vương, Hà Nội','0642123111','donghanguyen@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,3,0),
('Tòng Hoang','1982-09-03','Nam','1000','213 Hàm Nghi, Đà Nẵng','0245144444','hoangtong@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,3,0),
('Nguyễn Công Đạo','1994-01-08','Nam','500','6 Hoà Khánh, Đồng Nai','0988767111','nguyencongdao12@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',2,2,2,0),
('Nguyễn Thị Hào','1970-11-07','Nữ','5000','23 Nguyễn Hoàng, Đà Nẵng','0945423362','thihao07@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,1,0),
('Phạm Xuân Diệu','1992-08-08','Nam','3000','K77/22 Thái Phiên, Quảng Trị','0954333333','xuandieu92@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,2,0),
('Trương Đình Nghệ','1989-12-11','Nam','2000','K323/12 Ông Ích Khiêm, Vinh','0373213122','nghenhan2702@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,3,0),
('Dương Văn Quan','1981-07-08','Nam','1000','K453/12 Lê Lợi, Đà Nẵng','0490039241','duongquan@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,3,0),
('Hoàng Trần Nhi Nhi','1995-12-09','Nữ','500','224 Lý Thái Tổ, Gia Lai','0312345678','nhinhi123@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',3,3,2,0),
('Tôn Nữ Mộc Châu','2005-12-06','Nữ','5000','37 Yên Thế, Đà Nẵng','0988888844','tonnuchau@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,1,0),
('Nguyễn Mỹ Kim','1984-04-08','Nữ','3000','K123/45 Lê Lợi, Hồ Chí Minh','0912345698','kimcuong84@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,2,0),
('Nguyễn Thị Hào','1999-04-08','Nữ','2000','55 Nguyễn Văn Linh, Kon Tum','0763212345','haohao99@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,3,0),
('Trần Đại Danh','1994-07-01','Nam','1000','24 Lý Thường Kiệt, Quảng Ngãi','0643343433','danhhai99@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,2,0),
('Nguyễn Tâm Đắc','1989-07-01','Nam','500','22 Ngô Quyền, Đà Nẵng','0987654321','dactam@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',4,4,3,0),
('Trần Thị Dung','1989-12-11','Nữ','5000','88 Hồ Nghinh, Đà Nẵng','0907326463','dungtran@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1,0),
('Nguyễn Phan Bảo Hoàng','1998-11-11','Nam','3000','22 Phan Thanh, Đà Nẵng','0998311563','hoangbaophan@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1,0),
('Nguyễn Thị Bích Ngọc','1996-10-11','Nữ','2000','121 Tố Hữu, Đà Nẵng','0903111563','bichngoc@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1,0),
('Tạ Đình Vũ Đàm','1997-07-11','Nam','1000','111 Phan Tứ, Đà Nẵng','0905323563','damvuta@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1,0),
('Nguyễn Thị Hương Trà','1999-02-11','Nữ','500','453 Bạch Đằng, Đà Nẵng','0909124863','huongtra@gmail.com','https://giaydabongtot.com/wp-content/uploads/2020/10/Hinh-nen-ronaldo-cr7-may-tinh-laptop-3-scaled.jpg',5,5,1,0);
select sum(price) from cart where id_customer =1 and check_order=1;

insert into branch (name_branch , address_branch , area_branch , id_domain , is_delete) values ('Chi nhánh Hà Nội' , '310 Xã Đàn, Phường Phương Liên, Quận Đống Đa, Hà Nội' , 50.0 , 1 , 0) ,
('Chi nhánh Đà Nẵng' , '71 Nguyễn Lương Bằng, Hòa Khánh, Liên Chiểu, Đà Nẵng' , 50.0 , 2 , 0) ,
('Chi nhánh Hồ Chí minh' , '64 Võ Thị Sáu, phường Tân Định, quận 1, TP. HCM' , 50.0 , 3 , 0) ,
('Chi nhánh Hải Phòng' , '342 P.Tô Hiệu , Hà Nam , Hải Phòng' , 50.0 , 1 , 0),
('Chi nhánh Quảng Trị' , '342 P.Tô Hiệu , Quảng Trị' , 50.0 , 1 , 0),
('Chi nhánh Tây Nguyên' , '342 P.Tô Hiệu , Tây Nguyên' , 50.0 , 1 , 0),
('Chi nhánh Dak Lak' , '342 P.Tô Hiệu , Dak Lak' , 50.0 , 1 , 0),
('Chi nhánh Bắc Kạn' , '342 P.Tô Hiệu , Bắc Kạn' , 50.0 , 1 , 0),
('Chi nhánh Cà Mau' , '342 P.Tô Hiệu , Cà Mau' , 50.0 , 1 , 0),
('Chi nhánh Lạng Sơn' , '342 P.Tô Hiệu , Hà Nam , Lạng Sơn' , 50.0 , 1 , 0),
('Chi nhánh Cao Bằng' , '342 P.Tô Hiệu , Hà Nam , Cao Bằng' , 50.0 , 1 , 0),
('Chi nhánh Sơn La' , '342 P.Tô Hiệu , Sơn La' , 50.0 , 1 , 0),
('Chi nhánh Ninh Bình' , '342 P.Tô Hiệu , Ninh Bình' , 50.0 , 1 , 0),
('Chi nhánh Nghệ An' , '342 P.Tô Hiệu , Nghệ An' , 50.0 , 1 , 0),
('Chi nhánh Long An' , '342 P.Tô Hiệu , Long An' , 50.0 , 1 , 0),
('Chi nhánh Bình Định' , '342 P.Tô Hiệu , Bình Định' , 50.0 , 1 , 0),
('Chi nhánh Quảng Nam' , '32 Nguyễn Huệ , Quảng Nam' , 50.0 , 2 , 0),
('Chi nhánh Bình Dương' , '64 Quang Trung , Bình Dương' , 50.0 , 3 , 0),
('Chi nhánh Huế' , '21 Hương Thuỷ , Hà Nam , Huế' , 50.0 , 2 , 0),
('Chi nhánh Đà Lạt' , '321 P.Tô Hoài , Hà Nam , Đà Lạt' , 50.0 , 1 , 0);

insert into manage_product_branch values (1,2),(1,1),(1,3),(1,4),(1,5),(2,6),(2,7),(2,8),(2,9),(3,1),(3,4),(3,6),(3,7),(4,1),(4,4),(4,5),(4,6);


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





