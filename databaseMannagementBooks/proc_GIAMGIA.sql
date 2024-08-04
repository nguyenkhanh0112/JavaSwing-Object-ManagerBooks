go

use BooksManagement

go

create procedure proc_GIAMGIA_select_all
as
begin
	select * from GIAMGIA
end;

go

create proc proc_GIAMGIA_select_by_MaGG
	@MaGG varchar(20)
as
begin
	select * from GIAMGIA where MaGG = @MaGG
end;

go 

create proc proc_GIAMGIA_insert
	@MaGG varchar(20),
	@TenCT nvarchar(255),
	@LoaiCT nvarchar(255),
	@NgaBD Date,
	@NgayKT date
as
begin
	insert into GIAMGIA(MaGG,TenCT,LoaiCT,NgaBD,NgayKT) values (@MaGG,@TenCT,@LoaiCT,@NgaBD,@NgayKT)
end;

go

create proc proc_GIAMGIA_update 
	@MaGG varchar(20),
	@TenCT nvarchar(255),
	@LoaiCT nvarchar(255),
	@NgaBD Date,
	@NgayKT date
as
begin
	update GIAMGIA set TenCT = @TenCT,LoaiCT = @LoaiCT,NgaBD = @NgaBD, NgayKT = @NgayKT where MaGG = @MaGG
end;
go

create proc proc_GIAMGIA_delete
	@MaGG varchar(20)
as
begin
	delete from GIAMGIA where MaGG = @MaGG
end;
go
create proc proc_GIAMGIA_search_NgayBD
	@TGBD date
as
begin 
	select * from GIAMGIA where NgaBD = @TGBD;
end;

go

create proc proc_GIAMGIA_search_NgayKT
	@TGKT date
as
begin	
	delete from GIAMGIA where NgayKT = @TGKT
end;

go

