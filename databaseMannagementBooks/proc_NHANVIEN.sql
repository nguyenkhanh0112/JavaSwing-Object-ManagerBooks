
go
use BooksManagement
go
create proc proc_NHANVIEN_select_all
as
begin
	select *from NHANVIEN
end;

go

create proc proc_NHANVIEN_select_by_MaNV
@MaNV varchar(20)
as
begin
	select * from NHANVIEN where MaNV = @MaNV;
end;

go

create procedure proc_NHANVIEN_update
	@MaNV varchar(20),
	@hoNV nvarchar(255),
	@tenNV nvarchar(255),
	@chucVu nvarchar(100),
	@email varchar(255),
	@sdt   varchar(15),
	@luong Decimal(10,2),
	@phai nvarchar(10),
	@ngaySinh date
as
begin
	update NHANVIEN set HoNV = @hoNV ,TenNV = @tenNV,ChucVu = @chucVu,Email = @email,SDT = @sdt,Luong =@luong,Phai =@phai,NgaySinh =  @ngaysinh where MaNV = @MaNV
end;

go

create proc proc_NHANVIEN_delete
	@MaNV varchar(20)
as
begin
	delete from NHANVIEN where MaNV = @MaNV
end;


go
create proc proc_NHANVIEN_select_by_Luong
	@luong decimal(10,2)
as
begin
	select * from NHANVIEN where Luong <= @luong
end;
go
create proc proc_NHANVIEN_insert
	@MaNV varchar(20),
	@hoNV nvarchar(255),
	@tenNV nvarchar(255),
	@chucVu nvarchar(100),
	@email varchar(255),
	@sdt   varchar(15),
	@luong Decimal(10,2),
	@phai nvarchar(10),
	@ngaySinh date
as
begin
	insert into NHANVIEN(MaNV,HoNV,TenNV,ChucVu,Email,SDT,Luong,Phai,NgaySinh) values (@MaNV,@hoNV,@tenNV,@chucVu,@email,@sdt,@luong,@phai,@ngaySinh);
end;
go

create proc proc_NHANVIEN_search_by_LUONG
	@luong1 decimal(10,2),
	@luong2 decimal(10,2)
as
begin
	select * from NHANVIEN where Luong between @luong1 and @luong2;
end;
