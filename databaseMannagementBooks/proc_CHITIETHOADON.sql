go

use BooksManagement

go

create procedure proc_CHITIETHOADON_select_all
as
begin
	select * from CHITIETHOADON 
end;

go 

create proc proc_CHITIETHOADON_select_by_MaHD
	@MaHD varchar(20)
as
begin
	select * from CHITIETHOADON where MaHD= @MaHD
end;
go

create procedure proc_CHITIETHOADON_insert 
	@MaHD varchar(20),
	@MaSach varchar(20),
	@TenSach nvarchar(255),
	@Soluong int,
	@DonGia decimal(10,2),
	@GiamGia decimal(5,2),
	@ThanhTien decimal(10,2)
as
begin
	insert 
	into CHITIETHOADON(MaHD,MaSach,TenSach,Soluong,DonGia,GiamGia,ThanhTien) 
	values (@MaHD,@MaSach,@TenSach,@Soluong,@DonGia,@GiamGia,@ThanhTien);
end;

go

create proc proc_CHITIETHOADON_update 
	@MaHD varchar(20),
	@MaSach varchar(20),
	@TenSach nvarchar(255),
	@Soluong int,
	@DonGia decimal(10,2),
	@GiamGia decimal(5,2),
	@ThanhTien decimal(10,2)
as
begin
	update CHITIETHOADON 
	set TenSach = @TenSach,Soluong = @Soluong, DonGia = @DonGia, GiamGia = @GiamGia ,ThanhTien = @ThanhTien
	where MaHD = @MaHD and MaSach = @MaSach;
end;

go

create proc proc_CHITIETHOADON_delete
	@MaHD varchar(20),
	@MaSach varchar(20)
as
begin
	delete from CHITIETHOADON where MaHD = @MaHD and MaSach = @MaSach
end;
	
	