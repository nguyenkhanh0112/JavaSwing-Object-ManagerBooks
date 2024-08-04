-- stored procedure Tài khoản
create procedure proc_TAIKHOAN_select_all
as
begin
	select * from TAIKHOAN 
end;
go
create procedure proc_TAIKHOAN_select_by_MaTK
	@MaTK varchar(20)
as
begin 
	select * from TAIKHOAN where MaTK = @MaTK;
end;
go
create procedure proc_TAIKHOAN_select_by_TenTK
@TenTK varchar(100)
as
begin
	select * from TAIKHOAN where TenTK = @TenTK
end;
go
create procedure proc_TAIKOAN_insert
	@MaTK varchar(20),
	@TenTK varchar(100),
	@MATKHAU varchar(50),
	@Quyen nvarchar(255),
	@TrangThai int
as
begin
	insert into TAIKHOAN(MaTK,TenTK,MATKHAU,Quyen,TrangThai) values(@MaTK,@TenTK,@MATKHAU,@Quyen,@TrangThai)
end;
go
create proc proc_TAIKHOAN_update
	@MaTK varchar(20),
	@TenTK varchar(100),
	@MATKHAU varchar(50),
	@Quyen nvarchar(255),
	@TrangThai int
as
begin
	update TAIKHOAN set TenTK = @TenTK,MATKHAU = @MATKHAU,Quyen = @Quyen,TrangThai = @TrangThai
	where MaTK = @MaTK
end;
go
create proc proc_TAIKHOANG_delete_by_MaTK
@MaTK varchar(20)
as
begin
	delete from TAIKHOAN where MaTK = @MaTK
end;
go
create proc proc_TAIKHOAN_delete_by_TenTK
@TenTK varchar(100)
as 
begin
	delete from TAIKHOAN where TenTK = @TenTK
end;
go
create proc proc_TAIKHOAN_Check_TKMK
@TenTK varchar(100),@MatKhau varchar(50)
as
begin
	select * from TAIKHOAN where TenTK = @TenTK and MATKHAU = @MatKhau
end;