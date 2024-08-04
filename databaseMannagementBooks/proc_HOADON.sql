go 

use BooksManagement

go
create proc proc_HOADON_select_all
as
begin
	select * from HOADON
end;
go
create proc proc_HOADON_select_by_MaHD
	@MaHD varchar(20)
as
begin
	select * from HOADON where MaHD = @MaHD
end;

go

create proc proc_HOADON_insert
	@MaHD varchar(20),
	@MaKH varchar(20),
	@MaNV varchar(20),
	@MaGG varchar(20),
	@NgayLap date,
	@TongTien decimal(10,2),
	@GiamGia decimal(5,2),
	@ThanhTien decimal(10,2)
as
begin
	insert into HOADON(MaHD,MaKH,MaNV,MaGG,NgayLap,TongTien,GiamGia,ThanhTien) values (@MaHD,@MaKH,@MaNV,@MaGG,@NgayLap,@TongTien,@GiamGia,@ThanhTien);
end;
go

create proc proc_HOADON_delete
	@MaHD varchar(20)
as
begin
	delete from HOADON where MaHD = @MaHD;
end;

go 
alter proc proc_HOADON_update
	@MaHD varchar(20),
	@MaKH varchar(20),
	@MaNV varchar(20),
	@MaGG varchar(20),
	@NgayLap date,
	@Tongtien decimal(10,2),
	@GiamGia decimal(10,2),
	@ThanhTien decimal(10,2)
as
begin
	update HOADON 
	set MaKH = @MaKH, MaNV = @MaNV,MaGG = @MaGG,NgayLap = @NgayLap,TongTien = @Tongtien,GiamGia = @GiamGia,ThanhTien = @ThanhTien 
	where MaHD = @MaHD;
end;

go
create proc proc_HOADON_search_by_MaHD
	@MaHD varchar(20)
as
begin
	select * from HOADON where MaHD = @MaHD
end;

go

create proc proc_HOADON_search_by_MaKH
	@MaKH varchar(20)
as
begin
	select * from HOADON where MaKH = @MaKH
end;

go 
create proc proc_HOADON_search_by_MaNV
	@MaNV varchar(20)
as
begin
	select * from HOADON where MaNV = @MaNV
end;

go 
create proc proc_HOADON_search_by_timer
	@date1 date,
	@date2 date
as
begin
	select * from HOADON where NgayLap between @date1 and @date2
end;

go 
create proc proc_HOADON_search_by_THanhtien
	@Thanhtien1 decimal(10,2),
	@Thanhtien2 decimal(10,2)
as
begin
	select * from HOADON where ThanhTien between @Thanhtien1 and @Thanhtien2
end;
go

CREATE PROCEDURE ThemHoaDonVaChiTiet
    @MaNV varchar(20),
    @MaKH varchar(20),
    @NgayLap DATE,
    @TongTien DECIMAL(10, 2),
    @ChiTietHoaDon NVARCHAR(MAX)
AS
BEGIN
    DECLARE @MaHD INT;

    -- B?t d?u giao d?ch
    BEGIN TRANSACTION;

    BEGIN TRY
        -- Thêm hóa don
        INSERT INTO HoaDon (MaNV, MaKH, NgayLap, TongTien)
        VALUES (@MaNV, @MaKH, @NgayLap, @TongTien);

        -- L?y MaHD v?a du?c thêm
        SET @MaHD = SCOPE_IDENTITY();

        -- Thêm chi ti?t hóa don t? JSON
        DECLARE @json NVARCHAR(MAX) = @ChiTietHoaDon;

        INSERT INTO ChiTietHoaDon (MaHD, MaSach, SoLuong, DonGia, ThanhTien)
        SELECT @MaHD, MaSach, SoLuong, DonGia, ThanhTien
        FROM OPENJSON(@json)
        WITH (
            MaSach NVARCHAR(10),
            SoLuong INT,
            DonGia DECIMAL(10, 2),
            ThanhTien DECIMAL(10, 2)
        );

        -- Xác nh?n giao d?ch
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        -- Hu? giao d?ch khi có l?i
        ROLLBACK TRANSACTION;
        THROW;
    END CATCH
END
select * from CHITIETHOADON
