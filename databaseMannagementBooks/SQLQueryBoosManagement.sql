create database BooksManagement

go

use BooksManagement

go

create table SACH(
	MaSach varchar(20) primary key,
	MaNXB varchar(20),
	MaTL varchar(20),
	MaTG varchar(20),
	TenSach nvarchar(255),
	NamXB int,
	SoLuong int,
	DonGia decimal(10,2),
	AnhSach nvarchar(255)
	)

	go

create table NHAXUATBAN(
	MaNXB varchar(20) primary key,
	TenNXB nvarchar(255),
	DiaChi nvarchar(255),
	SoDienThoai varchar(15),
	Email varchar(255)
	)
	go
create table THELOAI(
	MaTL varchar(20) primary key,
	TenTL nvarchar(255),
	MoTa TEXT
	)
	go
create table TACGIA(
	MaTG varchar(20) primary key,
	TenTacGia nvarchar(255),
	NgaySinh Date,
	QuocTich nvarchar(100),
	TieuSu TEXT
	)
	go
	

create table NHANVIEN(
	MaNV varchar(20) primary key,
	HoNV nvarchar(255),
	TenNV nvarchar(255),
	ChucVu nvarchar(100),
	Email varchar(255),
	SDT   varchar(15),
	Luong Decimal(10,2),
	Phai nvarchar(10),
	NgaySinh date
	)
	go
create table KHACHHANG(
	MaKH varchar(20) primary key,
	HoKH nvarchar(255),
	TenKH nvarchar(255),
	SDT varchar(15),
	Email varchar(255),
	Phai nvarchar(10),
	TongChi decimal(10,2),
	NgaySinh date
	)
	go
create table GIAMGIA(
	MaGG varchar(20) primary key,
	TenCT nvarchar(255),
	LoaiCT nvarchar(255),
	NgaBD Date,
	NgayKT date
	)
	go

create table CTGIAMGIA(
	MaGG varchar(20),
	MaSach varchar(20),
	PhanTramGG decimal(5,2),
	primary key(MaGG,MaSach)
	)
	go
create table HOADON(
	MaHD varchar(20) primary key,
	MaKH varchar(20),
	MaNV varchar(20),
	MaGG varchar(20),
	NgayLap date,
	TongTien decimal(10,2),
	GiamGia decimal(5,2),
	ThanhTien decimal(10,2)
	)
go

create table CHITIETHOADON(
	MaHD varchar(20),
	MaSach varchar(20),
	TenSach nvarchar(255),
	Soluong int,
	DonGia decimal(10,2),
	GiamGia decimal(5,2),
	ThanhTien decimal(10,2),
	primary key(MaHD,MaSach)
	)
	go
create table NHACUNGCAP(
	MaNCC varchar(20) primary key,
	TenNCC nvarchar(255),
	DiaChi nvarchar(255),
	SDT varchar(15),
	Email varchar(100),
	NguoiLienHe nvarchar(255)
	)
	GO
create table PHIEUNHAP(
	MaPN varchar(20) Primary key,
	MaNV varchar(20),
	MaNCC varchar(20),
	TrangThai bit,
	TongTien decimal(10,2),
	NgayNhap date
	)
	go
create table CHITIETPHIEUNHAP(
	MaCTPN varchar(20) primary key,
	MaPN varchar(20),
	MaSach varchar(20),
	DonGia decimal(10,2),
	Soluong int,
	ThanhTien decimal(10,2)
	)
	go
create table TAIKHOAN(
	MaTK varchar(20) primary key,
	TenTK varchar(100),
	MATKHAU varchar(50),
	Quyen nvarchar(255),
	TrangThai int
	)

-- khóa ngo?i b?ng sách
alter table SACH add constraint SACH_MaNXB foreign key (MaNXB) references NHAXUATBAN(MaNXB);
alter table SACH add constraint SACH_MaTL foreign key(MaTL) references THELOAI(MaTL);
alter table SACH add constraint SACH_MaTG foreign key(MaTG) references TACGIA(MaTG);
-- khóa ngo?i b?ng hóa ??n
alter table HOADON add constraint HOADON_MaKH foreign key(MaKH) references KHACHHANG(MaKH);
alter table HOADON add constraint HOADON_MaNV foreign key(MaNV) references NHANVIEN(MaNV);
alter table HOADON add constraint HOADON_MaGG foreign key(MaGG) references GIAMGIA(MaGG);
--khóa ngo?i b?ng chi ti?t gi?m giá
alter table CTGIAMGIA add constraint CTGIAMGIA_MaGG foreign key (MaGG) references GIAMGIA(MaGG);
alter table CTGIAMGIA add constraint CTGIAMGIA_MaSACH foreign key (MaSach) references SACH(MaSach);
--khóa ngo?i b?ng phi?u nh?p 
alter table PHIEUNHAP add constraint PHIEUNHAP_MaNV foreign key(MaNV) references NHANVIEN(MaNV);
alter table PHIEUNHAP add constraint PHIEUNHAP_MaNCC foreign key(MaNCC) references NHACUNGCAP(MaNCC);
-- khóa ngo?i b?ng CT phi?u nh?p
alter table CHITIETPHIEUNHAP add constraint CHITIETPHIEUNHAP_MaPN foreign key(MaPN) references PHIEUNHAP(MaPN);
alter table CHITIETPHIEUNHAP add constraint CHITIETPHIEUNHAP_MaSach foreign key(MaSach) references SACH(MaSach);
-- b?ng chi ti?t hóa ??n 
alter table CHITIETHOADON add constraint CHITIETHOADON_MaHD foreign key(MaHD) references HOADON(MaHD);
alter table CHITIETHOADON add constraint CHITIETHOADON_MaSach foreign key(MaSach) references SACH(MaSach);
	
-- nh?p d? li?u b?ng sách
insert into SACH(MaSach,MaNXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia) values 
('S001','NXB01','TL04','TG01',N'Sống như một cây',2019,50,85.00),
('S002','NXB02','TL05','TG02',N'Sống xanh',2020,60,75.00),
('S003','NXB03','TL02','TG03',N'Tôi thấy hoa vàng trên cỏ xanh',2010,70,90.00),
('S004','NXB02','TL02','TG04',N'Nhà giả kim',2006,80,150.00),
('S005','NXB01','TL01','TG05',N'Dế mèn phưu luu ký',1941,100,75.00),
('S006','NXB02','TL02','TG06',N'Truyện kiều',1820,40,200.00),
('S007','NXB05','TL02','TG07',N'Sổ đỏ',1936,50,95.00),
('S008','NXB02','TL02','TG08',N'Hồn trương ba,da hàng thịt',1981,30,80.00),
('S009','NXB05','TL02','TG09',N'Hà nội mùa phượng hoàng',1990,60,110.00),
('S010','NXB02','TL02','TG10',N'Lão hạc',1943,90,50.00),
('S011','NXB02','TL02','TG11',N'Tắt đèn',1939,70,60.00),
('S012','NXB02','TL02','TG10',N'Chí phèo',1941,80,55.00),
('S013','NXB03','TL02','TG12',N'Đất rừng phương nam',1957,50,85.00),
('S014','NXB02','TL02','TG07',N'Vợ chồng A phủ',1934,40,90.00),
('S015','NXB03','TL02','TG03',N'Bên kia bầu trời',1995,60,70.00),
('S016','NXB02','TL02','TG13',N'Chiếc lá cuối cùng',1907,50,65.00),
('S017','NXB01','TL01','TG05',N'Dễ mèn phưu lưu kí - ngoại truyện',1941,100,75.00),
('S018','NXB05','TL02','TG14',N'Chuyện ma việt nam',2015,30,90.00),
('S019','NXB03','TL02','TG15',N'Hai số phận',1982,40,95.00),
('S020','NXB03','TL02','TG16',N'Lễ hội nhưng con ma',2018,20,100.00);

-- Nhập dữ liệu bảng NXB
insert into NHAXUATBAN(MaNXB,TenNXB,DiaChi,SoDienThoai,Email) values 
('NXB01',N'Nhà xuất bản kim đồng',N'55 Quang Trung, Quận Hai Bà Trưng, Hà Nội','024 3943 4736','info@kimdong.vn'),
('NXB02',N'Nhà xuất bản văn học',N'56-58 Trần Hưng Đạo, Quận Hoàn Kiếm, Hà Nội','024 3943 4741','info@vanhoc.vn'),
('NXB05',N'Nhà xuất bản hội nhà văn',N'65 Nguyễn Du, Quận Hai Bà Trưng, Hà Nội','024 3943 4739','info@hoinhavan.vn'),
('NXB03',N'Nhà xuất bản trẻ',N'161B Lý Chính Thắng, Quận 3, TP. Hồ Chí Minh','028 3843 4923','info@nxbtre.com.vn');

--nhập dữ liệu bảng thể loại

insert into THELOAI(MaTL,TenTL,MoTa) values 
('TL01',N'Sách thiếu nhi',N'Sách thiếu nhi bao gồm các tác phẩm được viết dành riêng cho trẻ em. Nội dung thường đơn giản, dễ hiểu, có hình ảnh minh họa đẹp mắt và chứa đựng các bài học đạo đức, kỹ năng sống cơ bản phù hợp với lứa tuổi trẻ em.'),
('TL02',N'Văn học',N'Sách thuộc thể loại văn học bao gồm các tác phẩm văn chương như tiểu thuyết, truyện ngắn, và thơ.'),
('TL04',N'Tâm lý - Tình cảm',N'Sách thuộc thể loại tâm lý - tình cảm thường khai thác các khía cạnh về cảm xúc, tâm lý con người, và các mối quan hệ tình cảm. Những tác phẩm này thường nhằm giúp người đọc hiểu rõ hơn về bản thân và những người xung quanh, cũng như cung cấp những bài học và kinh nghiệm sống quý báu.'),
('TL05',N'Khoa học - Kĩ thuật',N' Sách khoa học - kĩ thuật cung cấp kiến thức về các lĩnh vực khoa học và công nghệ. Nội dung có thể bao gồm từ những phát minh, nghiên cứu khoa học, nguyên lý kỹ thuật, đến các ứng dụng thực tiễn trong đời sống và sản xuất. Thể loại này thường giúp người đọc mở rộng hiểu biết về thế giới tự nhiên và công nghệ hiện đại.');

-- Nhập dữ liệu cho bảng tác giả 
select * from TACGIA
insert into TACGIA(MaTG,TenTacGia,NgaySinh,QuocTich,TieuSu) values 
('TG01',N'Thích Nhất Hạnh','1926-10-11',N'Việt Nam',N'Thích Nhất Hạnh là một thiền sư, nhà văn, nhà hoạt động hòa bình người Việt Nam.'),
('TG02',N'Lê Đức Hậu','1980-03-15',N'Việt Nam',N'Lê Đức Hậu là một tác giả chuyên viết về lối sống xanh và bền vững.'),
('TG03',N'Nguyễn Nhật Ánh','1955-05-07',N'Việt Nam',N'Nguyễn Nhật Ánh là một nhà văn nổi tiếng với các tác phẩm dành cho thiếu nhi và tuổi teen.'),
('TG04',N'Paulo Coelho','1947-08-24',N'Brazil',N'Paulo Coelho là một nhà văn người Brazil, nổi tiếng với tiểu thuyết "Nhà giả kim".'),
('TG05',N'Tô Hoài','1920-09-27',N'Việt Nam',N'Tô Hoài là một nhà văn Việt Nam nổi tiếng với các tác phẩm văn học thiếu nhi.'),
('TG06',N'Nguyễn Du','1765-01-03',N'Việt Nam',N'Nguyễn Du là một đại thi hào của Việt Nam, nổi tiếng với tác phẩm "Truyện Kiều".'),
('TG07',N'Vũ Trọng Phụng','1912-10-20',N'Việt Nam',N'Vũ Trọng Phụng là một nhà văn Việt Nam nổi tiếng với những tác phẩm hiện thực phê phán.'),
('TG08',N'Lưu Quang Vũ','1948-04-17',N'Việt Nam',N'Lưu Quang Vũ là một nhà viết kịch và nhà thơ Việt Nam.'),
('TG09',N'Nguyễn Huy Thiệp','1950-04-29',N'Việt Nam',N'Nguyễn Huy Thiệp là một nhà văn Việt Nam nổi tiếng với các tác phẩm truyện ngắn.'),
('TG10',N'Nam Cao','1915-10-29',N'Việt Nam',N'Nam Cao là một nhà văn hiện thực phê phán của Việt Nam.'),
('TG11',N'Ngô Tất Tố','1894-06-03',N'Việt Nam',N'Ngô Tất Tố là một nhà văn hiện thực và nhà báo nổi tiếng của Việt Nam.'),
('TG12',N'Đoàn Giỏi','1925-05-01',N'Việt Nam',N'Đoàn Giỏi là một nhà văn nổi tiếng với các tác phẩm về thiên nhiên và đời sống người nông dân.'),
('TG13',N'O. Henry','1862-09-11',N'Mỹ',N'O. Henry là bút danh của William Sydney Porter, một nhà văn người Mỹ nổi tiếng với các truyện ngắn.'),
('TG14',N'Trinh Thảo','1978-07-15',N'Việt Nam',N'Trinh Thảo là một tác giả chuyên viết về các câu chuyện ma và hiện tượng huyền bí ở Việt Nam.'),
('TG15',N'Jeffrey Archer','1940-04-15',N'Anh',N'Jeffrey Archer là một nhà văn và chính trị gia người Anh.'),
('TG16',N'Trịnh Thanh Hiền','1983-02-27',N'Việt Nam',N'Trịnh Thanh Hiền là một tác giả trẻ với nhiều tác phẩm về chủ đề huyền bí và kinh dị.');

-- nhập bảng giam gia
select * from GIAMGIA
INSERT INTO GIAMGIA (MaGG, TenCT, LoaiCT, NgaBD, NgayKT) VALUES
('GG01', N'Khuyến Mãi Mùa Hè', N'Giảm Giá 10%', '2024-06-01', '2024-06-30'),
('GG02', N'Tri Ân Khách Hàng', N'Giảm Giá 15%', '2024-07-01', '2024-07-15'),
('GG03', N'Khuyến Mãi Đầu Năm Học', N'Giảm Giá 20%', '2024-08-15', '2024-09-15'),
('GG04',N'Ngày Sách và Văn Hóa Đọc',N'Giảm Giá 25%','2024-04-15','2024-05-01');
-- nhập bảng chi tiết giảm giá -- chwua nhập

INSERT INTO CTGIAMGIA (MaGG, MaSach, PhanTramGG) VALUES
('GG03', 'S001', 20.00),
('GG02', 'S003', 15.00),
('GG04', 'S005', 25.00),
('GG01','S007',10.00),
('GG01','S010',10.00),
('GG01','S012',10.00),
('GG04','S016',25.00),
('GG04','S019',25.00);


-- Nhập bảng NCC
select * from NHACUNGCAP
INSERT INTO NHACUNGCAP (MaNCC, TenNCC, DiaChi, SDT, Email, NguoiLienHe) VALUES
('NCC01', N'Nhà Xuất Bản Kim Đồng', N'55 Quang Trung, Hai Bà Trưng, Hà Nội', '02438225555', 'kimdong@nxb.com', N'Nguyễn Văn A'),
('NCC02', N'Nhà Xuất Bản Trẻ', N'161B Lý Chính Thắng, Quận 3, TP.HCM', '02839306699', 'nxbtre@nxb.com', N'Phạm Thị B'),
('NCC03', N'Nhà Xuất Bản Giáo Dục', N'81 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội', '02439423343', 'gd@nxb.com', N'Hoàng Văn C'),
('NCC04', N'Nhà Xuất Bản Văn Học', N'27 Hàng Chuối, Hai Bà Trưng, Hà Nội', '02439436688', 'vanhoc@nxb.com', N'Vũ Thị D'),
('NCC05', N'Nhà Xuất Bản Thông Tin và Truyền Thông', N'115 Trần Duy Hưng, Cầu Giấy, Hà Nội', '02435564999', 'tttt@nxb.com', N'Lê Văn E'),
('NCC06',N'Nhà Xuất Bản Hội Nhà Văn',N'39 Tràng Tiền, Hoàn Kiếm, Hà Nội','02438253464',' hoivan@nxb.vn','Nguyễn Thị Cẩm Tú');
-- Nhap bang Nhan vien 
select * from NHANVIEN
INSERT INTO NHANVIEN (MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, NgaySinh) VALUES
('NV001', N'Nguyễn', N'Văn Khánh', N'Quản lý', 'nvanA@example.com', '0987654321', 15000000, N'Nam', '2003-12-01'),
('NV002', N'Trần', N'Thị B', N'Nhân viên', 'ttb@example.com', '0909123456', 8000000, N'Nữ', '2004-09-20'),
('NV003', N'Phạm', N'Văn C', N'Nhân viên', 'pvc@example.com', '0978123456', 8000000, N'Nam', '2005-03-10');

-- nhap bang khanh hang 
INSERT INTO KHACHHANG (MaKH, HoKH, TenKH, SDT, Email, Phai, TongChi, NgaySinh) VALUES
('KH001', N'Nguyễn', N'Thị D', '0987123456', 'ntd@example.com', N'Nữ', 5000000, '1990-07-12'),
('KH002', N'Trần', N'Văn E', '0918123456', 'tve@example.com', N'Nam', 3000000, '1995-05-20'),
('KH003', N'Phạm', N'Thị F', '0978123456', 'ptf@example.com', N'Nữ', 8000000, '1988-10-30');

-- nhập bảng Phiếu nhập 
INSERT INTO PHIEUNHAP (MaPN, MaNV, MaNCC, TrangThai, TongTien, NgayNhap) VALUES
('PN001', 'NV001', 'NCC01', 1, 15000000, '2024-06-15'),
('PN002', 'NV002', 'NCC02', 1, 8000000, '2024-07-20'),
('PN003', 'NV003', 'NCC03', 1, 10000000, '2024-08-10'),
('PN004', 'NV001', 'NCC04', 1, 12000000, '2024-09-05'),
('PN005', 'NV002', 'NCC05', 1, 9000000, '2024-09-25'),
('PN006', 'NV003', 'NCC06', 1, 11000000, '2024-10-10');


-- nhập bảng CT phiếu nhập
INSERT INTO CHITIETPHIEUNHAP (MaCTPN, MaPN, MaSach, DonGia, Soluong, ThanhTien) VALUES
('CTPN001', 'PN001', 'S001', 80.000, 100, 8000000),
('CTPN002', 'PN001', 'S002', 70.000, 100, 7000000),
('CTPN003', 'PN002', 'S003', 80.000, 50, 4000000),
('CTPN004', 'PN002', 'S004', 100.000, 40, 4000000),
('CTPN005', 'PN003', 'S005', 70.000, 50, 3500000),
('CTPN006', 'PN003', 'S006', 190.000, 34, 6500000),
('CTPN007', 'PN004', 'S007', 90.000, 133, 6300000),
('CTPN008', 'PN005', 'S008', 70.000, 50, 3500000),
('CTPN009', 'PN005', 'S009', 100.000, 55,5500000),
('CTPN010', 'PN006', 'S010', 40.000, 50, 2000000),
('CTPN011', 'PN006', 'S011', 50.000, 100, 2000000),
('CTPN012', 'PN006', 'S012', 50.000, 40, 100000);

-- nhập bảng hóa đơn
-- Thêm dữ liệu vào bảng HOADON

INSERT INTO HOADON (MaHD, MaKH, MaNV, MaGG, NgayLap,TongTien,GiamGia,ThanhTien)
VALUES
    ('HD001', 'KH001', 'NV001', 'GG01', '2024-06-20',175.00 ,30.50,144.50 ),
    ('HD002', 'KH002', 'NV002', 'GG02', '2024-07-25',250.00,25.00,225.00),
    ('HD003', 'KH003', 'NV003', 'GG03', '2024-08-15', 235.00,58.75,176.25);

-- Nhap bang chi tiet hoa don 
INSERT INTO CHITIETHOADON (MaHD, MaSach, TenSach, Soluong, DonGia, GiamGia, ThanhTien)
VALUES
    ('HD001', 'S001', N'Sống như một cây', 1, 85.00, 0.20, 68.00), -- 85 - (85 * 0.20) = 68.00
    ('HD001', 'S003', N'Tôi thấy hoa vàng trên cỏ xanh', 1, 90.00, 0.15, 76.50), -- 90 - (90 * 0.15) = 76.50
    ('HD002', 'S007', N'Số đỏ', 1, 95.00, 0.10, 85.50), -- 95 - (95 * 0.10) = 85.50
    ('HD002', 'S010', N'Lão hạc', 2, 50.00, 0.10, 90.00), -- 2 * (50 - (50 * 0.10)) = 90.00
    ('HD002', 'S012', N'Chí phèo', 1, 55.00, 0.10, 49.50), -- 55 - (55 * 0.10) = 49.50
    ('HD003', 'S005', N'Dế mèn phưu lưu ký', 1, 75.00, 0.25, 56.25), -- 75 - (75 * 0.25) = 56.25
    ('HD003', 'S016', N'Chiếc lá cuối cùng', 1, 65.00, 0.25, 48.75), -- 65 - (65 * 0.25) = 48.75
    ('HD003', 'S019', N'Hai số phận', 1, 95.00, 0.25, 71.25); -- 95 - (95 * 0.25) = 71.25

	select *from TAIKHOAN
	-- nhập bảng tài khoản 
	insert into TAIKHOAN(MaTK,TenTK,MATKHAU,Quyen,TrangThai) values ('TK01','admin','1',N'admin',1)
	select * from HOADON
	select * from PHIEUNHAP where 1 = 1 and MaPN = 'PN001'
	select * from CTGIAMGIA
	select * from CHITIETHOADON
	select * from sach
	select * from CTGIAMGIA
	select * from HOADON where MaHD like 'HD'+'%'

	select * from CHITIETPHIEUNHAP
select *from NHACUNGCAP
select * from NCC
