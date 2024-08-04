go
use BooksManagement
go

create proc proc_SACH_select_all
as
begin
	select * from SACH
end;
go
create proc proc_SACH_select_by_MaSACH
@MaSach varchar(20)
as
begin 
	select * from SACH where MaSach = @MaSach
end;
go
create proc proc_SACH_update
	@MaSach varchar(20), 
	@MaNXB varchar(20),
	@MaTL varchar(20),
	@MaTG varchar(20),
	@TenSach nvarchar(255),
	@NamXB int ,@Soluong int,
	@DonGia decimal(10,2),
	@Anh nvarchar(255)
as
begin
	update SACH set MaNXB =@MaNXB,MaTL = @MaTL,MaTG =@MaTG,TenSach=@TenSach,NamXB =@NamXB,DonGia = @DonGia,AnhSach = @Anh where MaSach =@MaSach;
end;
go 
create proc proc_SACH_insert
	@MaSach varchar(20), 
	@MaNXB varchar(20),
	@MaTL varchar(20),
	@MaTG varchar(20),
	@TenSach nvarchar(255),
	@NamXB int ,@Soluong int,
	@DonGia decimal(10,2),
	@Anh nvarchar(255)
as
begin 
	insert into SACH(MaSach,MaNXB,MaTL,MaTG,TenSach,NamXB,DonGia,AnhSach) values (@MaSach,@MaNXB,@MaTL,@MaTG,@TenSach,@NamXB,@DonGia,@Anh);
end;

go
create proc proc_SACH_delete
	@MaSach varchar(20)
as
begin
	delete from SACH where MaSach = @MaSach;
end;

go 
create proc proc_SACH_search_by_MaTG
	@MaTG varchar(20)
as
begin
	select * from SACH where MaTG = @MaTG;
end;

go


go
create procedure proc_SACH_search
	@MaSach varchar(20) ,
	@MaNXB varchar(20) ,
	@MaTL varchar(20),
	@MaTG varchar(20) ,
	@TenSach varchar(20),
	@KhoangGiaTu decimal(10,2),
	@KhoangGiaDen decimal(10,2),
	@NamXBTu int,
	@NamXBDen int
as
begin
	select * from SACH
	where (MaSach = @MaSach or @MaSach is null) 
	and (MaNXB = @MaNXB or @MaNXB is null)
	and (MaTL = @MaTL or @MaTL is null)
	and (MaTG = @MaTG or @MaTG is null)
	and (TenSach like '%'+ @TenSach +'%' or @TenSach is null)
	and (DonGia >= @KhoangGiaTu or @KhoangGiaTu is null)
	and (DonGia <= @KhoangGiaDen or @KhoangGiaDen is null)
	and (NamXB >= @NamXBTu or @NamXBTu is null) 
-->	and (NamXB <= @NamXBDen or @NamXBDen is null)
end;
go
select * from SACH where NamXB >= 0;

create procedure proc_SACH_ThongKe
as
begin
	select Min(SACH.DonGia) as DonGiaThapNhat,Max(SACH.DonGia) as DonGiaCaoNhat,Count(distinct SACH.MaTL) as SoLoaiSach,COUNT( SACH.MaSach) as TongSoSach from SACH 
end;

go





