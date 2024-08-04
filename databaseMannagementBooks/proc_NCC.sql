go

use BooksManagement 

go

create procedure proc_NCC_select_all
as
begin
	select * from NHACUNGCAP
end

go

create proc proc_NCC_update
	@MaNCC varchar(20),
	@TenNCC nvarchar(255),
	@DiaChi nvarchar(255),
	@SDT varchar(15),
	@Email varchar(100),
	@NguoiLienHe nvarchar(255)
as
begin
	update NHACUNGCAP set TenNCC = @TenNCC , DiaChi = @DiaChi,SDT = @SDT, Email = @Email, NguoiLienHe = @NguoiLienHe
	where MaNCC = @MaNCC
end

go

create proc proc_NCC_insert
	@MaNCC varchar(20),
	@TenNCC nvarchar(255),
	@DiaChi nvarchar(255),
	@SDT varchar(15),
	@Email varchar(100),
	@NguoiLienHe nvarchar(255)
as
begin 
	insert into NHACUNGCAP(MaNCC,TenNCC,DiaChi,SDT,Email,NguoiLienHe) values (@MaNCC,@TenNCC,@DiaChi,@SDT,@Email,@NguoiLienHe);
end;
go
create proc proc_NCC_delete
	@MaNCC varchar(20)
as
begin
	delete NHACUNGCAP where MaNCC = @MaNCC
end

go

