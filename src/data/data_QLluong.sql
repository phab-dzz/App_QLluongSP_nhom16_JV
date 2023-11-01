USE [master]
GO
/****** Object:  Database [QLLUONG]    Script Date: 10/21/2023 9:04:10 PM ******/
CREATE DATABASE [QLLUONG]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLLUONG', FILENAME = N'D:\ptud\dulieu\QLLUONG.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLLUONG_log', FILENAME = N'D:\ptud\dulieu\QLLUONG_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLLUONG] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLLUONG].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLLUONG] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLLUONG] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLLUONG] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLLUONG] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLLUONG] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLLUONG] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLLUONG] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLLUONG] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLLUONG] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLLUONG] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLLUONG] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLLUONG] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLLUONG] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLLUONG] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLLUONG] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLLUONG] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLLUONG] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLLUONG] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLLUONG] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLLUONG] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLLUONG] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLLUONG] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLLUONG] SET RECOVERY FULL 
GO
ALTER DATABASE [QLLUONG] SET  MULTI_USER 
GO
ALTER DATABASE [QLLUONG] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLLUONG] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLLUONG] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLLUONG] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QLLUONG] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLLUONG', N'ON'
GO
USE [QLLUONG]
GO
/****** Object:  Table [dbo].[BangChamCongCongNhan]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongCongNhan](
	[maBangChamCongCN] [char](10) NOT NULL,
	[soNgayLamViec] [int] NULL,
	[soNgayNghi] [int] NULL,
	[ngayChamCong] [datetime] NULL,
	[soLuongHangLamDuoc] [int] NULL,
	[coPhep] [int] NULL,
	[soGioTangCa] [float] NULL,
	[maCN] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangChamCongCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON

GO
CREATE TABLE [dbo].[BangChamCongNhanVien](
	[maBangChamCongNV] [char](10) NOT NULL,
	[soNgayLamViec] [int] NULL,
	[soNgayNghi] [int] NULL,
	[coPhep] [int] NULL,
	[soGioTangCa] [float] NULL,
	[maNhanVien] [char](10) NULL,
	[ngayChamCong] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangChamCongNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangluongCongNhan]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangluongCongNhan](
	[maBangLuong] [char](10) NOT NULL,
	[thoiGian] [date] NOT NULL,
	[luongThang] [money] NULL,
	[phuCap] [float] NULL,
	[tienThuong] [money] NULL,
	[baoHiemXH] [float] NULL,
	[thucLanh] [float] NULL,
	[MaCN] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangluongNhanVien]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangluongNhanVien](
	[maBangLuong] [char](10) NOT NULL,
	[thoiGian] [date] NOT NULL,
	[luongThang] [money] NULL,
	[phuCap] [float] NULL,
	[tienThuong] [money] NULL,
	[baoHiemXH] [float] NULL,
	[thucLanh] [float] NULL,
	[luongCoBan] [money] NULL,
	[MaNV] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongDoanSanPham]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongDoanSanPham](
	[maCongDoan] [char](10) NOT NULL,
	[tenCongDoan] [varchar](20) NULL,
	[ngayBatDau] [datetime] NULL,
	[soLuongSanPham] [int] NULL,
	[donGia] [money] NULL,
	[trangThai] [bit] NULL,
	[maSP] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhan]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongNhan](
	[maCongNhan] [char](10) NOT NULL,
	[trinhDoChuyenMon] [float] NULL,
	[hoDem] [varchar](30) NULL,
	[ten] [varchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [varchar](50) NULL,
	[ngayThamGia] [datetime] NULL,
	[trangThai] [bit] NULL,
	[sDT] [varchar](15) NULL,
	[xuong] [varchar](25) NULL,
	[luongPhuCap] [float] NULL,
	[phongBan] [varchar](15) NULL,
	[hinhanhcn] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE CongNhan
ADD chuyenMon varchar(50) NULL;
GO
ALTER TABLE CongNhan
DROP COLUMN phongBan;
GO

/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [char](10) NOT NULL,
	[luongCoBan] [money] NULL,
	[hoDem] [varchar](30) NULL,
	[ten] [varchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [varchar](50) NULL,
	[chucDanh] [varchar](30) NULL,
	[ngayThamGia] [datetime] NULL,
	[hsLuong] [float] NULL,
	[ThueThuNhapCaNhan] [float] NULL,
	[sDT] [varchar](15) NULL,
	[email] [varchar](40) NULL,
	[luongPhuCap] [float] NULL,
	[phongBan] [varchar](15) NULL,
	[hinhanhnv] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanCongCongDoan]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanCongCongDoan](
	[soLuongCongDoanPhanCong] [int] NULL,
	[maPCCD] [char](10) NOT NULL,
	[maCD] [char](10) NULL,
	[maCN] char(10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPCCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuLuong]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuLuong](
	[maPhieuLuong] [char](10) NOT NULL,
	[ngayNhanLuong] [datetime] NULL,
	[thucLanh] [float] NULL,
	[maBangLuong] [char](10) NULL,
	[ten] [varchar](30) NULL,
	[hoDem] [varchar](50) NULL,
	[maNhanVien] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [char](10) NOT NULL,
	[tenSanPham] [varchar](20) NULL,
	[soLuongCongDoan] [int] NULL,
	[soLuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/21/2023 9:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [char](15) NOT NULL,
	[matKhau] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER DATABASE [QLLUONG] SET  READ_WRITE 


GO

ALTER TABLE BangChamCongCongNhan
ADD FOREIGN KEY (maCN) REFERENCES CongNhan(maCongNhan);
GO

ALTER TABLE PhieuLuong
ADD FOREIGN KEY (maNhanVien) REFERENCES CongNhan(maCongNhan);
GO

ALTER TABLE PhieuLuong 
ADD FOREIGN KEY (maNhanVien) REFERENCES CongNhan(maCongNhan);
GO 

GO
ALTER TABLE PhanCongCongDoan
ADD CONSTRAINT FK_PhanCongCongDoan_CongNhan 
FOREIGN KEY (maCN) REFERENCES CongNhan(maCongNhan);

GO

ALTER TABLE CongDoanSanPham
ADD FOREIGN KEY (maCongDoan) REFERENCES PhanCongCongDoan(maCongDoan);
GO

ALTER TABLE CongDoanSanPham
ADD FOREIGN KEY (maSP) REFERENCES SanPham(maSanPham);
GO
ALTER TABLE BangChamCongNhanVien
ADD CONSTRAINT FK_BangChamCongNhanVien_NhanVien
FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien);
GO
ALTER TABLE BangLuongNhanVien
ADD CONSTRAINT FK_BangLuongNhanVien_NhanVien
FOREIGN KEY (maNV) REFERENCES NhanVien(maNhanVien);
GO
ALTER TABLE PhieuLuong
ADD CONSTRAINT FK_PhieuLuong_NhanVien
FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien);
GO
ALTER TABLE BangLuongCongNhan
ADD CONSTRAINT FK_BangLuongCongNhan_PhieuLuong
FOREIGN KEY (maBangLuong) REFERENCES PhieuLuong(maBangLuong);
GO
ALTER TABLE BangLuongNhanVien
ADD CONSTRAINT FK_BangLuongNhanVien_PhieuLuong
FOREIGN KEY (maBangLuong) REFERENCES PhieuLuong(maBangLuong);

GO
-- Tạo liên kết giữa bảng BangLuongCongNhan và CongNhan
ALTER TABLE BangLuongCongNhan
ADD CONSTRAINT FK_BangLuongCongNhan_CongNhan
FOREIGN KEY (maCN) REFERENCES CongNhan(maCongNhan);
GO

-- Tạo liên kết giữa bảng PhieuLuong và BangLuongCongNhan
ALTER TABLE PhieuLuong
ADD CONSTRAINT FK_PhieuLuong_BangLuongCongNhan
FOREIGN KEY (maBangLuong) REFERENCES BangLuongCongNhan(maBangLuong);
GO

-- Tạo liên kết giữa bảng BangLuongNhanVien và PhieuLuong
ALTER TABLE PhieuLuong
ADD CONSTRAINT FK_BangLuongNhanVien_PhieuLuong
FOREIGN KEY (maBangLuong) REFERENCES BangluongNhanVien(maBangLuong);
GO


GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0001', 8000000, N'Nguyễn', N'Văn Trung', 1, N'16 Nguyễn Văn Nghi, Phường 6, Gò Vấp,Tp HCM', N'Kế Toán', '2000-01-01', 1.86, 575000, '0123456789', 'VanTrung@gmail.com', 3500000, N'Phòng Kế Toán', 'link_hinh_anh1.jpg'),
('NV0002', 9000000, N'Phạm', N'Thị Ngọc', 0, N'18 Lê Lợi,Phường 7, Gò Vấp, Tp HCM', N'Nhân Viên', '2001-02-15', 2.08, 1300000, '0123456789', 'NgocPham@gmail.com', 4000000, N'Phòng Nhân Sự', 'link_hinh_anh2.jpg'),
('NV0003', 7500000, N'Lê', N'Trọng Thành', 1, N'Tp HCM', N'Quản Lý Nhân Sự', '1999-12-10', 2.34, 1050000, '0123456789', 'TrongLe@gmail.com', 3000000, N'Phòng Kế Toán', 'link_hinh_anh3.jpg'),
('NV0010', 9000000, N'Lê', N'Thị Bình', 0, N'Tp HCM', N'Nhân Viên', '2008-07-07', 2.34, 1300000, '0123456789', 'BinhLe@gmail.com', 4000000, N'Phòng Nhân Sự', 'link_hinh_anh10.jpg');
go
-- Thêm 2 quản lý nhân sự
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0011', 9500000, N'Võ', N'Thị Mai', 0, N'202 Lê Lợi, Quận 3, Tp HCM', N'Quản Lý Nhân Sự', '2010-03-20', 2.34, 1248500, '0123456789', 'MaiVo@gmail.com', 4500000, N'Phòng Nhân Sự', 'link_hinh_anh11.jpg');
go
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0012', 9800000, N'Lê', N'Thị Minh', 1, N'257 Phan Đình Phùng, Quận Phú Nhuận, Tp HCM', N'Quản Lý Nhân Sự', '2009-05-15', 2.34, 1331000, '0123456789', 'MinhLe@gmail.com', 4700000, N'Phòng Nhân Sự', 'link_hinh_anh12.jpg');

GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0061', 12000000, N'Nguyễn', N'Thị Lan', 0, N'17 Nguyễn Du, p1, q1, Tp HCM', N'Xưởng trưởng', '2022-01-15', 2.34, 2415500, '0123456789', 'LanNguyen@gmail.com', 5000000, N'Xưởng sản xuất', 'link_hinh_anh61.jpg');
GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0062', 11000000, N'Trần', N'Thị Huệ', 0, N'257 Phan Đình Phùng, Quận Phú Nhuận, Tp HCM', N'Trưởng phòng', '2022-02-20', 2.45, 2106500, '0123456789', 'HueTran@gmail.com', 4800000, N'Phòng Nhân sự', 'link_hinh_anh62.jpg');
GO

INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0063', 10500000, N'Lê', N'Thị Thảo', 0, N'16/12 Nguyen Van Nghi, p5, gv, Tp HCM', N'Xưởng trưởng', '2022-03-25', 2.56, 1937000, '0123456789', 'ThaoLe@gmail.com', 4700000, N'Xưởng sản xuất', 'link_hinh_anh63.jpg');

GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0064', 13000000, N'Phạm', N'Thị Mai', 0, N'334 Tran Dai Nghia, p2, Tp HCM', N'Trưởng phòng', '2022-04-30', 2.67, 2742000, '0123456789', 'MaiPham@gmail.com', 5200000, N'Phòng Nhân sự', 'link_hinh_anh64.jpg');
GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0065', 11500000, N'Dinh', N'Thi Ngoc', 0, N'Tp HCM', N'Nhân Viên', '2021-05-05', 2.78, 2392500, '0123456789', 'NgocDinh@gmail.com', 5000000, N'Kinh Doanh', 'link_hinh_anh65.jpg');
GO

INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0066', 12500000, N'Võ', N'Thị Hà', 0, N'Le Lai, p10, gv, Tp HCM', N'Nhân Viên', '2022-06-10', 2.89, 2575500, '0123456789', 'HaVo@gmail.com', 5100000, N'Kinh Doanh', 'link_hinh_anh66.jpg');

GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0067', 12200000, N'Nguyễn', N'Thị Diễm', 0, N'133 Phan Huy Ich, p17, q7, Tp HCM', N'Nhân Viên', '2022-07-15', 2.91, 2521000, '0123456789', 'DiemNguyen@gmail.com', 5050000, N'Kinh Doanh', 'link_hinh_anh67.jpg');
GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0068', 12800000, N'Đinh', N'Thị Phượng', 0, N'Ton Duc Thang, p9, q Binh Thanh, Tp HCM', N'Nhân Viên', '2022-08-20', 2.76, 2685000, '0123456789', 'PhuongDinh@gmail.com', 5150000, N'Kinh Doanh', 'link_hinh_anh68.jpg');
GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0069', 13500000, N'Vũ', N'Thị Thúy', 0, N'133 Phan Huy Ich, p17, q7,Tp HCM', N'Nhân Viên', '2022-09-25', 2.65, 2937000, '0123456789', 'ThuyVu@gmail.com', 5300000, N'Kinh Doanh', 'link_hinh_anh69.jpg');
GO
INSERT INTO NhanVien (maNhanVien, luongCoBan, hoDem, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, ThueThuNhapCaNhan, sDT, email, luongPhuCap, phongBan, hinhanhnv)
VALUES 
('NV0070', 11800000, N'Lê', N'Thị Hiền', 0, N'133 Phan Huy Ich, p17, q7,Tp HCM', N'Nhân Viên', '2022-10-30', 2.54, 2460500, '0123456789', 'HienLe@gmail.com', 4900000, N' Kinh Doanh', 'link_hinh_anh70.jpg');
GO
-- Thêm 20 công nhân
INSERT INTO CongNhan (maCongNhan, trinhDoChuyenMon, hoDem, ten, gioiTinh, diaChi, ngayThamGia, trangThai, sDT, xuong, chuyenMon, luongPhuCap, hinhanhcn)
VALUES 
('CN0001', 0.0, N'Nguyễn', N'Văn An', 1, N'123 Le loi, Quận 9, Thành Phố HCM', '2022-01-01', 1, '0123456781', N'Xưởng 1', N'Vắt Sổ', 3000000, 'link_hinh_anh1.jpg'),
('CN0002', 0.5, N'Lê', N'Thị Binh', 0, N'456 Huynh Khuong An, Quận GV, Thành Phố HCM', '2022-02-01', 1, '0123456782', N'Xưởng 2', N'Tay Áo', 3100000, 'link_hinh_anh2.jpg'),
('CN0003', 0.8, N'Trần', N'Văn Cao', 1, N'789 Đường GHI, Quận 8, Thành Phố HCM', '2022-03-01', 1, '0123456783', N'Xưởng 1', N'Cổ Áo', 3200000, 'link_hinh_anh3.jpg'),
('CN0004', 1.2, N'Phạm', N'Thị Duy', 0, N'101 Đường Tôn duc thang, Quận 3, Thành Phố HCM', '2022-04-01', 1, '0123456784', N'Xưởng 2', N'Thân Áo', 3300000, 'link_hinh_anh4.jpg'),
('CN0005', 0.0, N'Hồ', N'Thị Em', 1, N'202 Đường Le Lai, Quận GV, Thành Phố HCM', '2022-05-01', 1, '0123456785', N'Xưởng 1', N'Kiểm Tra', 3400000, 'link_hinh_anh5.jpg'),
('CN0006', 0.5, N'Dương', N'Văn Phat', 1, N'303 Đường VWX, Quận YZA, Thành Phố HCM', '2022-06-01', 1, '0123456786', N'Xưởng 2', N'Cắt Vải', 3450000, 'link_hinh_anh6.jpg'),
('CN0007', 0.8, N'Lý', N'Thị Gia', 0, N'404 Đường BCD, Quận EFG, Thành Phố HCM', '2022-07-01', 1, '0123456787', N'Xưởng 1', N'Làm Mẫu', 3550000, 'link_hinh_anh7.jpg'),
('CN0008', 1.2, N'Võ', N'Văn Hi', 1, N'505 Đường HIJ, Quận KLM, Thành Phố HCM', '2022-08-01', 1, '0123456788', N'Xưởng 2', N'Vắt Sổ', 3600000, 'link_hinh_anh8.jpg'),
('CN0009', 0.0, N'Trần', N'Thị Ing', 0, N'606 Đường MNO, Quận PQR, Thành Phố HCM', '2022-09-01', 1, '0123456789', N'Xưởng 1', N'Tay Áo', 3700000, 'link_hinh_anh9.jpg'),
('CN0010', 0.5, N'Lê', N'Văn Giang', 1, N'707 Đường STU, Quận VWX, Thành Phố HCM', '2022-10-01', 1, '0123456790', N'Xưởng 2', N'Cổ Áo', 3800000, 'link_hinh_anh10.jpg'),
('CN0011', 0.8, N'Nguyễn', N'Thị Kkhang', 0, N'808 Đường YZA, Quận BCD, Thành Phố HCM', '2022-11-01', 1, '0123456791', N'Xưởng 1', N'Thân Áo', 3900000, 'link_hinh_anh11.jpg'),
('CN0012', 1.2, N'Hồ', N'Văn Le', 1, N'909 Đường EFG, Quận HIJ, Thành Phố HCM', '2022-12-01', 1, '0123456792', N'Xưởng 2', N'Kiểm Tra', 3950000, 'link_hinh_anh12.jpg'),
('CN0013', 0.0, N'Dương', N'Thị My', 1, N'1010 Đường KLM, Quận NOP, Thành Phố HCM', '2023-01-01', 1, '0123456793', N'Xưởng 1', N'Cắt Vải', 3000000, 'link_hinh_anh13.jpg'),
('CN0014', 0.5, N'Lý', N'Văn Na', 1, N'1111 Đường PQR, Quận STU, Thành Phố HCM', '2023-02-01', 1, '0123456794', N'Xưởng 2', N'Làm Mẫu', 3100000, 'link_hinh_anh14.jpg'),
('CN0015', 0.8, N'Võ', N'Thị Ong', 0, N'1212 Đường VWX, Quận YZA, Thành Phố HCM', '2023-03-01', 1, '0123456795', N'Xưởng 1', N'Vắt Sổ', 3200000, 'link_hinh_anh15.jpg'),
('CN0016', 1.2, N'Phan', N'Văn Phu', 1, N'1313 Đường BCD, Quận EFG, Thành Phố HCM', '2023-04-01', 1, '0123456796', N'Xưởng 2', N'Tay Áo', 3300000, 'link_hinh_anh16.jpg'),
('CN0017', 0.0, N'Thái', N'Thị Quy', 0, N'1414 Đường HIJ, Quận KLM, Thành Phố HCM', '2023-05-01', 1, '0123456797', N'Xưởng 1', N'Cổ Áo', 3400000, 'link_hinh_anh17.jpg'),
('CN0018', 0.5, N'Đinh', N'Văn Rê', 1, N'1515 Đường NOP, Quận PQR, Thành Phố HCM', '2023-06-01', 1, '0123456798', N'Xưởng 2', N'Thân Áo', 3500000, 'link_hinh_anh18.jpg'),
('CN0019', 0.8, N'Đỗ', N'Thị Su', 0, N'1616 Đường STU, Quận VWX, Thành Phố HCM', '2023-07-01', 1, '0123456799', N'Xưởng 1', N'Kiểm Tra', 3600000, 'link_hinh_anh19.jpg'),
('CN0020', 1.2, N'Bùi', N'Văn Thinh', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', '2023-08-01', 1, '0123456700', N'Xưởng 2', N'Cắt Vải', 3700000, 'link_hinh_anh20.jpg');
-- Thêm sản phẩm áo quần vào bảng SanPham với số lượng lớn hơn 400
GO
INSERT INTO SanPham (maSanPham, tenSanPham, soLuongCongDoan, soLuong)
VALUES 
('SP001', 'Áo Polo Nam', 5, 500),
('SP002', 'Áo Sơ Mi Nữ', 4, 450),
('SP003', 'Quần Jean Nam', 6, 550),
('SP004', 'Quần Legging Nữ', 5, 480),
('SP005', 'Áo Thun Trơn Unisex', 6, 600),
('SP006', 'Áo Khoác Nam', 4, 420),
('SP007', 'Quần Shorts Nữ', 6, 700),
('SP008', 'Quần Âu Nam', 3, 460),
('SP009', 'Áo Len Nữ', 6, 430),
('SP010', 'Quần Jogger Nam', 5, 480);
GO
-- Thêm 5 công đoạn cho sản phẩm SP001
INSERT INTO CongDoanSanPham (maCongDoan, tenCongDoan, ngayBatDau, soLuongSanPham, donGia, trangThai, maSP)
VALUES 
('CD001', 'Cắt vải', '2023-11-01', 500, 5000, 1, 'SP001'),
('CD002', 'May áo', '2023-11-05', 480, 5500, 1, 'SP001'),
('CD003', 'May cổ áo', '2023-11-10', 450, 6000, 1, 'SP001'),
('CD004', 'In hình', '2023-11-15', 420, 6500, 1, 'SP001'),
('CD005', 'Kiểm tra chất lượng', '2023-11-20', 400, 7000, 1, 'SP001');
GO
-- Thêm 4 công đoạn cho sản phẩm SP002
INSERT INTO CongDoanSanPham (maCongDoan, tenCongDoan, ngayBatDau, soLuongSanPham, donGia, trangThai, maSP)
VALUES 
('CD006', 'Cắt vải', '2023-11-02', 450, 5200, 1, 'SP002'),
('CD007', 'May áo', '2023-11-06', 430, 5900, 1, 'SP002'),
('CD008', 'May cổ áo', '2023-11-11', 400, 6400, 1, 'SP002'),
('CD009', 'In hình', '2023-11-16', 380, 6900, 1, 'SP002');
-- Thêm 6 công đoạn cho sản phẩm SP003
GO
INSERT INTO CongDoanSanPham (maCongDoan, tenCongDoan, ngayBatDau, soLuongSanPham, donGia, trangThai, maSP)
VALUES 
('CD010', 'Cắt vải', '2023-11-02', 500, 5400, 1, 'SP003'),
('CD011', 'May quần', '2023-11-07', 480, 6100, 1, 'SP003'),
('CD012', 'May túi', '2023-11-12', 460, 6800, 1, 'SP003'),
('CD013', 'May đáy quần', '2023-11-17', 440, 7500, 1, 'SP003'),
('CD014', 'Đính nút', '2023-11-22', 420, 8200, 1, 'SP003'),
('CD015', 'Kiểm tra chất lượng', '2023-11-27', 400, 8900, 1, 'SP003');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0001
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0001', 22, 4, 0, 15, 'NV0001');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0002
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0002', 20, 6, 2, 12, 'NV0002');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0003
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0003', 23, 3, 1, 18, 'NV0003');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0010
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0010', 21, 5, 1, 14, 'NV0010');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0011
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0011', 24, 2, 0, 20, 'NV0011');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0012
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0012', 22, 4, 0, 16, 'NV0012');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0061
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0061', 25, 1, 0, 22, 'NV0061');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0062
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0062', 20, 6, 2, 12, 'NV0062');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0063
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0063', 23, 3, 1, 18, 'NV0063');
GO
-- Thêm dữ liệu chấm công cho nhân viên NV0064
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES ('MCCNV0064', 21, 5, 1, 14, 'NV0064');
GO
-- Chấm công cho các nhân viên từ NV0065 đến NV0070
INSERT INTO BangChamCongNhanVien (maBangChamCongNV, soNgayLamViec, soNgayNghi, coPhep, soGioTangCa, maNhanVien)
VALUES
('MCCNV0065', 22, 4, 1, 5.5, 'NV0065'),
('MCCNV0066', 20, 6, 1, 6.0, 'NV0066'),
('MCCNV0067', 21, 2, 1, 4.5, 'NV0067'),
('MCCNV0068', 26, 0, 0, 5.0, 'NV0068'),
('MCCNV0069', 26, 0, 0, 4.0, 'NV0069'),
('MCCNV0070', 26, 0, 0, 3.5, 'NV0070');
GO
-- Thêm dữ liệu lương cho tất cả nhân viên
INSERT INTO BangluongNhanVien (maBangLuong, thoiGian, luongThang, phuCap, tienThuong, baoHiemXH, thucLanh, luongCoBan, MaNV)
SELECT 
    'BLNV' + RIGHT('0000' + CAST(ROW_NUMBER() OVER (ORDER BY NV.maNhanVien) AS VARCHAR(4)), 4) AS maBangLuong,
    '2023-10-01' AS thoiGian,
	 NV.luongCoBan * NV.hsLuong AS luongThang,
    NV.luongPhuCap AS phuCap,
    0 AS tienThuong,
    4500000 AS baoHiemXH,
    (
        ((NV.luongCoBan * NV.hsLuong) / 26) * (22 - BCC.soNgayNghi) 
        + ((NV.luongCoBan * NV.hsLuong) / 26 / 8) * 2 * BCC.soGioTangCa 
        - (BCC.soNgayNghi - BCC.coPhep) * 150000 
        - NV.ThueThuNhapCaNhan
    ) AS thucLanh,

	    NV.luongCoBan AS luongCoBan,
    NV.maNhanVien AS MaNV
FROM 
    NhanVien NV
JOIN 
    BangChamCongNhanVien BCC ON NV.maNhanVien = BCC.maNhanVien
--WHERE BCC.ngayChamCong BETWEEN '2023-10-01' AND '2023-10-31';
GO
-- Chèn trực tiếp dữ liệu vào bảng PhanCongCongDoan
INSERT INTO PhanCongCongDoan (soLuongCongDoanPhanCong, maPCCD, maCD, maCN)
VALUES
(50, 'PCCD0001', 'CD001', 'CN0001'),
(50, 'PCCD0002', 'CD001', 'CN0002'),
(70, 'PCCD0003', 'CD001', 'CN0003'),
(80, 'PCCD0004', 'CD001', 'CN0004'),
(50, 'PCCD0005', 'CD001', 'CN0005'),
(60, 'PCCD0006', 'CD001', 'CN0006'),
(40, 'PCCD0007', 'CD001', 'CN0007'),
(30, 'PCCD0008', 'CD001', 'CN0008'),
(30, 'PCCD0009', 'CD001', 'CN0009'),
(75, 'PCCD0010', 'CD004', 'CN0010'),
(40, 'PCCD0011', 'CD002', 'CN0001'),
(50, 'PCCD0012', 'CD002', 'CN0002'),
(30, 'PCCD0013', 'CD002', 'CN0003'),
(35, 'PCCD0014', 'CD002', 'CN0004'),
(40, 'PCCD0015', 'CD003', 'CN0005'),
(50, 'PCCD0016', 'CD003', 'CN0006'),
(40, 'PCCD0017', 'CD004', 'CN0007'),
(45, 'PCCD0018', 'CD004', 'CN0008'),
(50, 'PCCD0019', 'CD005', 'CN0009'),
(30, 'PCCD0020', 'CD002', 'CN0010');

-- Chèn dữ liệu vào bảng BangChamCongCongNhan
INSERT INTO BangChamCongCongNhan (maBangChamCongCN, soNgayLamViec, soNgayNghi, ngayChamCong, soLuongHangLamDuoc, coPhep, soGioTangCa, maCN)
VALUES 
-- Công nhân 1
('MCCCN0001', 22, 4, '2023-10-01', 1000, 2, 5.5, 'CN0001'),
-- Công nhân 2
('MCCCN0002', 20, 6, '2023-10-01', 950, 3, 6.0, 'CN0002'),
-- Công nhân 3
('MCCCN0003', 23, 3, '2023-10-01', 980, 1, 4.5, 'CN0003'),
-- Công nhân 4
('MCCCN0004', 21, 5, '2023-10-01', 900, 4, 3.0, 'CN0004'),
-- Công nhân 5
('MCCCN0005', 24, 2, '2023-10-01', 930, 2, 5.0, 'CN0005'),
-- Công nhân 6
('MCCCN0006', 22, 4, '2023-10-01', 970, 1, 6.0, 'CN0006'),
-- Công nhân 7
('MCCCN0007', 20, 6, '2023-10-01', 910, 3, 4.0, 'CN0007'),
-- Công nhân 8
('MCCCN0008', 25, 1, '2023-10-01', 960, 0, 5.5, 'CN0008'),
-- Công nhân 9
('MCCCN0009', 23, 3, '2023-10-01', 920, 1, 6.5, 'CN0009'),
-- Công nhân 10
('MCCCN0010', 22, 4, '2023-10-01', 940, 2, 4.5, 'CN0010'),
-- Công nhân 11
('MCCCN0011', 24, 2, '2023-10-01', 890, 1, 3.5, 'CN0011'),
-- Công nhân 12
('MCCCN0012', 21, 5, '2023-10-01', 950, 4, 5.0, 'CN0012'),
-- Công nhân 13
('MCCCN0013', 26, 0, '2023-10-01', 930, 0, 4.0, 'CN0013'),
-- Công nhân 14
('MCCCN0014', 22, 4, '2023-10-01', 910, 1, 6.5, 'CN0014'),
-- Công nhân 15
('MCCCN0015', 20, 6, '2023-10-01', 980, 3, 5.0, 'CN0015'),
-- Công nhân 16
('MCCCN0016', 25, 1, '2023-10-01', 920, 0, 4.0, 'CN0016'),
-- Công nhân 17
('MCCCN0017', 23, 3, '2023-10-01', 950, 1, 5.5, 'CN0017'),
-- Công nhân 18
('MCCCN0018', 22, 4, '2023-10-01', 910, 2, 3.5, 'CN0018'),
-- Công nhân 19
('MCCCN0019', 21, 5, '2023-10-01', 960, 4, 4.0, 'CN0019'),
-- Công nhân 20
('MCCCN0020', 25, 1, '2023-10-01', 940, 1, 5.5, 'CN0020');
