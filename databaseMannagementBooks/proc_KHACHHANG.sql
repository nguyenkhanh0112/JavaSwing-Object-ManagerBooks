go
use BooksManagement
go

create procedure proc_KHACHHANG_select_all
as
begin
	select * from KHACHHANG
end;
go

create proc proc_KHACHHANG_select_by_MaKH
	@MaKH varchar(20)
as
begin
	select * from KHACHHANG where MaKH = @MaKH
end;

go

create proc proc_KHACHHANG_insert
	@MaKH varchar(20),
	@HoKH nvarchar(255),
	@TenKH nvarchar(255),
	@Sdt varchar(15),
	@Email varchar(255),
	@Phai nvarchar(10),
	@TongChi decimal(10,2),
	@NgaySinh date
as
begin
	insert into KHACHHANG(MaKH,HoKH,TenKH,SDT,Email,Phai,TongChi,NgaySinh) values (@MaKH,@HoKH,@TenKH,@Sdt,@Email,@Phai,@TongChi,@NgaySinh);
end;

go

create proc proc_KHACHHANG_delete
	@MaKH varchar(20)
as
begin
	delete from KHACHHANG where MaKH = @MaKH;
end;
go
create proc proc_KHACHHANG_update
	@MaKH varchar(20),
	@HoKH nvarchar(255),
	@TenKH nvarchar(255),
	@Sdt varchar(15),
	@Email varchar(255),
	@Phai nvarchar(10),
	@TongChi decimal(10,2),
	@NgaySinh date
as
begin
	update KHACHHANG set HoKH = @HoKH,TenKH=@TenKH,SDT=@Sdt,Email=@Email,Phai=@Phai,TongChi=@TongChi,NgaySinh=@NgaySinh where MaKH = @MaKH;
end;

go

create proc proc_KHACHHANG_search
	@MaKH varchar(20),
	@Phai nvarchar(10)
as
begin
	select * from KHACHHANG where (MaKH like '%'+ @MaKH + '%') and Phai = @Phai;
end;


	