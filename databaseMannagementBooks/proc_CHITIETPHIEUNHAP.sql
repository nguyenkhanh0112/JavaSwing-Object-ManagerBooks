go

use BooksManagement

go

 create procedure proc_CHITIETPHIEUNHAP_select_all
 as
 begin
	select * from CHITIETPHIEUNHAP;
end;

go 

create procedure proc_CHITIETPHIEUNHAP_select_by_MaCTPN
	@MaCTPN varchar(20)
as
begin
	select * from CHITIETPHIEUNHAP where MaCTPN = @MaCTPN;
end;

go

create procedure proc_CHITIETPHIEUNHAP_insert
	@MaCTPN varchar(20),
	@MaPN varchar(20),
	@MaSach varchar(20),
	@DonGia decimal(10,2),
	@Soluong int,
	@ThanhTien decimal(10,2)
as
begin
	insert into CHITIETPHIEUNHAP(MaCTPN,MaPN,MaSach,DonGia,Soluong,ThanhTien) values (@MaCTPN,@MaPN,@MaSach,@DonGia,@Soluong,@ThanhTien);
end;

go

create proc proc_CHITIETPHIEUNHAP_update 
	@MaCTPN varchar(20),
	@MaPN varchar(20),
	@MaSach varchar(20),
	@DonGia decimal(10,2),
	@Soluong int,
	@ThanhTien decimal(10,2)
as
begin
	update CHITIETPHIEUNHAP
	set MaPN = @MaPN,MaSach = @MaSach, DonGia =@DonGia, Soluong = @Soluong, ThanhTien = @ThanhTien
	where MaCTPN = @MaCTPN
end;

go 

create proc proc_CHITIETPHIEUNHAP_delete
	@MaCTPN varchar(20)
as
begin
	delete from CHITIETPHIEUNHAP
	where MaCTPN = @MaCTPN
end;

go

create proc proc_CHITITETPHIEUNHAP_search_by_MaSach
	@MaSach varchar(20)
as
begin
	select * from CHITIETPHIEUNHAP where MaSach = @MaSach
end;

go

create proc proc_CHITIETPHIEUNHAP_search_by_DonGia
	@Dongia1 decimal(10,2),
	@Dongia2 decimal(10,2)
as
begin
	select * from CHITIETPHIEUNHAP where DonGia between @Dongia1 and @Dongia2
end;

go 

create proc proc_CHITIETPHIEUNHAP_search_by_TongTien
	@Tong1 decimal(10,2),
	@Tong2 decimal(10,2)
as
begin
	select * from CHITIETPHIEUNHAP where ThanhTien between @Tong1 and @Tong2
end;

go 

