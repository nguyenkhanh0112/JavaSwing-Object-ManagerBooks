go

use BooksManagement

go

create procedure proc_CHITIETGIAMGIA_select_all
as
begin
	select * from CTGIAMGIA
end;

go

create procedure proc_CHITIETGIAMGIA_select_by_MaGG
	@MaGG varchar(20)
as
begin
	select * from CTGIAMGIA where MaGG = @MaGG
end;

go

create procedure proc_CHITIETGIAMGIA_insert
	@MaGG varchar(20),
	@MaSach varchar(20),
	@PhanTramGG decimal(5,2)
as
begin
	insert into CTGIAMGIA(MaGG,MaSach,PhanTramGG) values (@MaGG,@MaSach,@PhanTramGG)
end;

go

create procedure proc_CHITITETGIAMGIA_update
	@MaGG varchar(20),
	@MaSach varchar(20),
	@PhanTramGG decimal(5,2)
as
begin
	update CTGIAMGIA set PhanTramGG = @PhanTramGG where MaGG = @MaGG and MaSach = @MaSach
end;

go

create procedure proc_CHITIETGIAMGIA_delete
	@MaGG varchar(20),
	@MaSach varchar(20)
as
begin 
	delete from CTGIAMGIA where MaGG = @MaGG and MaSach = @MaSach
end;
select * from CTGIAMGIA