go

use BooksManagement 

go

create procedure proc_PHIEUNHAP_select_all
as
begin
	select *from PHIEUNHAP
end;

go 

create proc proc_PHIEUNHAP_insert 
	@MaPN varchar(20),
	@MaNV varchar(20),
	@MaNCC varchar(20),
	@TrangThai bit,
	@TongTien decimal(10,2),
	@NgayNhap date
as
begin
	insert into PHIEUNHAP(MaPN,MaNV,MaNCC,TrangThai,TongTien,NgayNhap) values (@MaPN,@MaNV,@MaNCC,@TrangThai,@TongTien,@NgayNhap);
end;

go

create proc proc_PHIEUNHAP_update
	@MaPN varchar(20),
	@MaNV varchar(20),
	@MaNCC varchar(20),
	@TrangThai bit,
	@TongTien decimal(10,2),
	@NgayNhap date
as
begin
	update PHIEUNHAP set MaNV = @MaNV ,MaNCC = @MaNCC,TrangThai = @TrangThai,TongTien = @TongTien,NgayNhap = @NgayNhap
	where MaPN = @MaPN
end;

go

create proc proc_PHIEUNHAP_delete
	@MaPN varchar(20)
as
begin
	delete from PHIEUNHAP where MaPN = @MaPN
end;

go 

create proc proc_PHIEUNHAP_search_by_NCC
	@MaNCC varchar(20)
as
begin
	select * from PHIEUNHAP where MaNCC = @MaNCC
end;

go 
create proc proc_PHIEUNHAP_search_by_MaNV
	@MaNV varchar(20)
as
begin
	select * from PHIEUNHAP where MaNV = @MaNV
end;

go

create proc proc_PHIEUNHAP_search_by_KHOANGTIEN
	@Tien1 decimal(10,2),
	@Tien2 decimal(10,2)
as
begin
	select * from PHIEUNHAP where TongTien between @Tien1 and @Tien2
end;

go 
select * from CHITIETPHIEUNHAP
create proc proc_PHIEUNHAP_search_by_KHOANGTG
	@Time1 date,
	@Time2 date
as
begin
	select * from PHIEUNHAP where  NgayNhap between @Time1 and @Time2;
end;

go 
alter proc proc_PHIEUNHAP_search_by_MaPN
	@MaPN varchar(20)
as
begin
	select * from CHITIETPHIEUNHAP where MaPN = @MaPN;
end;
go