USE [master]
GO
/****** Object:  Database [QLLUONG]    Script Date: 12/12/2023 5:20:26 PM ******/
CREATE DATABASE [QLLUONG]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLLUONG', FILENAME = N'D:\data ptud\QLLUONG.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLLUONG_log', FILENAME = N'D:\data ptud\QLLUONG_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
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
ALTER DATABASE [QLLUONG] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLLUONG] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLLUONG] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLLUONG]
GO
/****** Object:  Table [dbo].[BangChamCongCongNhan]    Script Date: 12/12/2023 5:20:26 PM ******/
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
	[soSPLamDuocTrongGioTangCa] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangChamCongCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 12/12/2023 5:20:26 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangluongCongNhan]    Script Date: 12/12/2023 5:20:26 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangluongNhanVien]    Script Date: 12/12/2023 5:20:26 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongDoanSanPham]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongDoanSanPham](
	[maCongDoan] [char](10) NOT NULL,
	[tenCongDoan] [nvarchar](20) NULL,
	[ngayBatDau] [datetime] NULL,
	[soLuongSanPham] [int] NULL,
	[donGia] [money] NULL,
	[trangThai] [bit] NULL,
	[maSP] [char](10) NULL,
	[ngayChiaCongDoan] [datetime] NULL,
	[chuyenMon] [nvarchar](20) NULL,
	[trangThaiPhanCong] [bit] NULL,
	[soLuongHoanThanh] [int] NULL,
	[doUuTien] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhan]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongNhan](
	[maCongNhan] [char](10) NOT NULL,
	[trinhDoChuyenMon] [float] NULL,
	[ngaySinh] [datetime] NULL,
	[ten] [nvarchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](50) NULL,
	[ngayThamGia] [datetime] NULL,
	[trangThai] [bit] NULL,
	[sDT] [varchar](15) NULL,
	[xuong] [nvarchar](25) NULL,
	[luongPhuCap] [float] NULL,
	[chuyenMon] [nvarchar](15) NULL,
	[hinhanhcn] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [char](10) NOT NULL,
	[luongCoBan] [money] NULL,
	[ngaySinh] [datetime] NULL,
	[ten] [nvarchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](50) NULL,
	[chucDanh] [nvarchar](30) NULL,
	[ngayThamGia] [datetime] NULL,
	[hsLuong] [float] NULL,
	[ThueThuNhapCaNhan] [float] NULL,
	[sDT] [varchar](15) NULL,
	[email] [varchar](40) NULL,
	[luongPhuCap] [float] NULL,
	[phongBan] [nvarchar](15) NULL,
	[hinhanhnv] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanCongCongDoan]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanCongCongDoan](
	[soLuongCongDoanPhanCong] [int] NULL,
	[maPCCD] [char](10) NOT NULL,
	[maCD] [char](10) NULL,
	[maCN] [char](10) NULL,
	[ngayBatDau] [date] NULL,
	[maSP] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPCCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuLuong]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuLuong](
	[maPhieuLuong] [char](10) NOT NULL,
	[ngayNhanLuong] [datetime] NULL,
	[thucLanh] [float] NULL,
	[maBangLuong] [char](10) NULL,
	[ten] [nvarchar](30) NULL,
	[maNhanVien] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [char](10) NOT NULL,
	[tenSanPham] [nvarchar](20) NULL,
	[soLuongCongDoan] [int] NULL,
	[soLuong] [int] NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/12/2023 5:20:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [char](10) NOT NULL,
	[matKhau] [varchar](50) NULL,
 CONSTRAINT [PK__TaiKhoan__7A22625E50A73340] PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0001 ', 27, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1030, 0, 700, N'CN0001    ', 70)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0002 ', 22, 4, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 800, 2, NULL, N'CN0002    ', 60)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0003 ', 26, 1, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1100, 1, NULL, N'CN0003    ', 50)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0004 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0004    ', 50)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0006 ', 25, 1, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1400, 1, NULL, N'CN0006    ', 59)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0007 ', 25, 2, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1000, 1, NULL, N'CN0007    ', 58)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0008 ', 22, 4, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 800, 4, NULL, N'CN0008    ', 56)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0009 ', 27, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1100, 0, NULL, N'CN0009    ', 46)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0010 ', 23, 3, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1360, 1, NULL, N'CN0010    ', 45)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0011 ', 26, 2, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1300, 1, NULL, N'CN0011    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0012 ', 25, 1, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1400, 0, NULL, N'CN0012    ', 68)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0013 ', 27, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1000, 0, NULL, N'CN0013    ', 79)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0014 ', 22, 4, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 800, 3, NULL, N'CN0014    ', 5)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0015 ', 27, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1100, 0, NULL, N'CN0015    ', 79)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0016 ', 24, 2, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1200, 1, NULL, N'CN0016    ', 79)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0017 ', 27, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1300, 0, NULL, N'CN0017    ', 79)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0018 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1400, 0, NULL, N'CN0018    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0019 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1000, 0, NULL, N'CN0019    ', 57)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0020 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0020    ', 57)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1001 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 870, 2, 600, N'CN0001    ', 57)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1002 ', 22, 4, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1000, 2, NULL, N'CN0002    ', 79)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1003 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1100, 1, NULL, N'CN0003    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1004 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0004    ', 56)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1006 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1500, 0, NULL, N'CN0006    ', 76)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1007 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1000, 0, NULL, N'CN0007    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1008 ', 23, 3, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1000, 3, NULL, N'CN0008    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1009 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0009    ', 89)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1010 ', 24, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1632, 1, NULL, N'CN0010    ', 98)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1011 ', 24, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1300, 1, NULL, N'CN0011    ', 89)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1012 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1100, 0, NULL, N'CN0012    ', 89)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1013 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1000, 0, NULL, N'CN0013    ', 76)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1014 ', 22, 4, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 800, 3, NULL, N'CN0014    ', 56)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1015 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1100, 0, NULL, N'CN0015    ', 56)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1016 ', 24, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1200, 1, NULL, N'CN0016    ', 46)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1017 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0017    ', 88)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1018 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 900, 0, NULL, N'CN0018    ', 6)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1019 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1000, 0, NULL, N'CN0019    ', 87)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1021 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1700, 0, NULL, N'CN0020    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2001 ', 21, 5, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1300, 2, NULL, N'CN0001    ', 56)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2002 ', 22, 4, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1200, 2, NULL, N'CN0002    ', 78)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2003 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1100, 1, NULL, N'CN0003    ', 54)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2004 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0004    ', 57)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2006 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1300, 0, NULL, N'CN0006    ', 78)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2007 ', 24, 2, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1000, 2, NULL, N'CN0007    ', 68)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2008 ', 23, 3, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1000, 3, NULL, N'CN0008    ', 56)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2009 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0009    ', 68)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2010 ', 24, 2, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1600, 2, NULL, N'CN0010    ', 89)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2011 ', 23, 3, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1300, 2, NULL, N'CN0011    ', 78)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2012 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1200, 0, NULL, N'CN0012    ', 79)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2013 ', 24, 2, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1700, 1, NULL, N'CN0013    ', 65)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2014 ', 22, 4, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1200, 3, NULL, N'CN0014    ', 78)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2015 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1100, 0, NULL, N'CN0015    ', 68)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2016 ', 23, 3, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 800, 3, NULL, N'CN0016    ', 68)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2017 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 200, 0, NULL, N'CN0017    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2018 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 500, 0, NULL, N'CN0018    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2019 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1000, 0, NULL, N'CN0019    ', 78)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2020 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1600, 0, NULL, N'CN0020    ', 67)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3001 ', 26, 3, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 829, 1, NULL, N'CN0001    ', 57)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3002 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1500, 1, NULL, N'CN0002    ', 75)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3003 ', 25, 4, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 700, 1, NULL, N'CN0003    ', 57)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3004 ', 26, 0, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1000, 2, NULL, N'CN0004    ', 78)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3006 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 570, 0, NULL, N'CN0006    ', 34)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3007 ', 24, 5, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1000, 2, NULL, N'CN0007    ', 2)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3008 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0008    ', 32)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3009 ', 21, 7, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1600, 1, NULL, N'CN0009    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3010 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 664, 2, NULL, N'CN0010    ', 32)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3011 ', 23, 8, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 700, 2, NULL, N'CN0011    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3012 ', 23, 2, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0012    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3013 ', 23, 5, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 700, 2, NULL, N'CN0013    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3014 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0014    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3015 ', 24, 5, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1410, 1, NULL, N'CN0015    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3016 ', 22, 4, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 800, 3, NULL, N'CN0016    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3017 ', 24, 5, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 700, 1, NULL, N'CN0017    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3018 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1500, 0, NULL, N'CN0018    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3019 ', 24, 2, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 1300, 0, NULL, N'CN0019    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3020 ', 25, 1, CAST(N'2023-11-29T00:00:00.000' AS DateTime), 900, 0, NULL, N'CN0020    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4001 ', 13, 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 829, 0, NULL, N'CN0001    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4002 ', 14, 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 850, 1, NULL, N'CN0002    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4003 ', 12, 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 720, 0, NULL, N'CN0003    ', 5)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4004 ', 12, 4, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 900, 2, NULL, N'CN0004    ', 45)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4006 ', 14, 2, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 570, 0, NULL, N'CN0006    ', 45)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4007 ', 11, 4, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 700, 1, NULL, N'CN0007    ', 45)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4008 ', 17, 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0008    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4009 ', 9, 5, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 600, 0, NULL, N'CN0009    ', 70)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4010 ', 16, 1, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 664, 2, NULL, N'CN0010    ', 23)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4011 ', 13, 6, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0011    ', 21)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4012 ', 14, 2, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0012    ', 12)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4013 ', 11, 4, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 700, 1, NULL, N'CN0013    ', 11)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4014 ', 11, 2, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0014    ', 11)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4015 ', 11, 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 410, 0, NULL, N'CN0015    ', 11)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4016 ', 11, 4, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 800, 3, NULL, N'CN0016    ', 12)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4017 ', 11, 3, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0017    ', 13)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4018 ', 14, 1, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500, 0, NULL, N'CN0018    ', 13)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4019 ', 12, 2, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 398, 0, NULL, N'CN0019    ', 16)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN4020 ', 11, 0, CAST(N'2023-12-12T00:00:00.000' AS DateTime), 900, 0, NULL, N'CN0020    ', 23)
GO
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0001 ', 25, 4, 0, 15, N'NV0001    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0002 ', 21, 6, 2, 12, N'NV0002    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0003 ', 25, 4, 1, 18, N'NV0003    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0010 ', 22, 5, 1, 14, N'NV0010    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0011 ', 25, 2, 0, 20, N'NV0011    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0012 ', 23, 4, 0, 16, N'NV0012    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0061 ', 25, 1, 0, 22, N'NV0061    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0062 ', 20, 6, 2, 12, N'NV0062    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0063 ', 23, 3, 1, 18, N'NV0063    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0064 ', 21, 5, 1, 14, N'NV0064    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0065 ', 23, 4, 1, 5.5, N'NV0065    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0066 ', 21, 6, 1, 6, N'NV0066    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0067 ', 22, 2, 1, 4.5, N'NV0067    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0068 ', 27, 0, 0, 5, N'NV0068    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0069 ', 27, 0, 0, 4, N'NV0069    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0070 ', 26, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1001 ', 27, 0, 0, 40, N'NV0001    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1002 ', 25, 2, 2, 30, N'NV0002    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1003 ', 24, 3, 1, 18, N'NV0003    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1010 ', 27, 0, 0, 30, N'NV0010    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1011 ', 25, 2, 0, 20, N'NV0011    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1012 ', 23, 4, 0, 16, N'NV0012    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1061 ', 25, 1, 0, 22, N'NV0061    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1062 ', 20, 6, 2, 12, N'NV0062    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1063 ', 26, 0, 0, 18, N'NV0063    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1064 ', 25, 1, 1, 40, N'NV0064    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1065 ', 23, 4, 1, 5.5, N'NV0065    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1066 ', 21, 6, 1, 6, N'NV0066    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1067 ', 22, 2, 1, 4.5, N'NV0067    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1068 ', 27, 0, 0, 5, N'NV0068    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1069 ', 27, 0, 0, 4, N'NV0069    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1070 ', 26, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1101 ', 25, 1, 0, 40, N'NV0001    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1102 ', 24, 2, 2, 30, N'NV0002    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1103 ', 23, 3, 1, 18, N'NV0003    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1110 ', 23, 3, 2, 30, N'NV0010    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1111 ', 24, 2, 0, 20, N'NV0011    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1112 ', 26, 0, 0, 16, N'NV0012    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1161 ', 25, 1, 0, 22, N'NV0061    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1162 ', 26, 0, 0, 12, N'NV0062    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1163 ', 24, 1, 0, 18, N'NV0063    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1164 ', 25, 1, 1, 40, N'NV0064    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1165 ', 20, 6, 1, 5.5, N'NV0065    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1166 ', 20, 6, 2, 6, N'NV0066    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1167 ', 25, 1, 1, 4.5, N'NV0067    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1168 ', 26, 0, 0, 5, N'NV0068    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1169 ', 26, 0, 0, 4, N'NV0069    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1170 ', 26, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2101 ', 27, 0, 0, 12, N'NV0001    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2102 ', 26, 1, 1, 30, N'NV0002    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2103 ', 27, 0, 0, 18, N'NV0003    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2110 ', 27, 0, 0, 12, N'NV0010    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2111 ', 25, 2, 0, 20, N'NV0011    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2112 ', 26, 1, 1, 16, N'NV0012    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2161 ', 26, 0, 0, 22, N'NV0061    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2162 ', 26, 0, 0, 12, N'NV0062    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2163 ', 25, 1, 0, 18, N'NV0063    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2164 ', 26, 0, 0, 20, N'NV0064    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2165 ', 25, 2, 2, 5.5, N'NV0065    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2166 ', 26, 1, 1, 6, N'NV0066    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2167 ', 26, 1, 1, 4.5, N'NV0067    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2168 ', 27, 0, 0, 5, N'NV0068    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2169 ', 27, 0, 0, 4, N'NV0069    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2170 ', 26, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-11-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3101 ', 13, 0, 0, 2, N'NV0001    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3102 ', 12, 1, 1, 4, N'NV0002    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3103 ', 13, 0, 0, 4, N'NV0003    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3110 ', 13, 0, 0, 5, N'NV0010    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3111 ', 11, 2, 0, 3, N'NV0011    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3112 ', 12, 1, 1, 2, N'NV0012    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3161 ', 12, 0, 0, 2, N'NV0061    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3162 ', 12, 0, 0, 2, N'NV0062    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3163 ', 11, 1, 0, 8, N'NV0063    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3164 ', 12, 0, 0, 2, N'NV0064    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3165 ', 11, 2, 2, 5.5, N'NV0065    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3166 ', 12, 1, 1, 6, N'NV0066    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3167 ', 12, 1, 1, 4.5, N'NV0067    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3168 ', 13, 0, 0, 5, N'NV0068    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3169 ', 13, 0, 0, 4, N'NV0069    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV3170 ', 12, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-12-12T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0001  ', CAST(N'2023-10-29' AS Date), 6077000.0000, 3000000, 0.0000, 4500000, 9269500, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0002  ', CAST(N'2023-10-29' AS Date), 7080000.0000, 3100000, 0.0000, 4500000, 9920600, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0003  ', CAST(N'2023-10-29' AS Date), 12672000.0000, 3200000, 0.0000, 4500000, 14422700, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0004  ', CAST(N'2023-10-29' AS Date), 16896000.0000, 3300000, 0.0000, 4500000, 20964000, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0005  ', CAST(N'2023-10-29' AS Date), 10500000.0000, 3450000, 0.0000, 4500000, 12729000, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0006  ', CAST(N'2023-10-29' AS Date), 9000000.0000, 3550000, 0.0000, 4500000, 11427000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0007  ', CAST(N'2023-10-29' AS Date), 10384000.0000, 3600000, 0.0000, 4500000, 12842860, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0008  ', CAST(N'2023-10-29' AS Date), 10384000.0000, 3600000, 0.0000, 4500000, 12842860, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0009  ', CAST(N'2023-10-29' AS Date), 7040000.0000, 3700000, 0.0000, 4500000, 10481560, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0010  ', CAST(N'2023-10-29' AS Date), 13056000.0000, 3800000, 0.0000, 4500000, 14982300, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0011  ', CAST(N'2023-10-29' AS Date), 16380000.0000, 3900000, 0.0000, 4500000, NULL, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0012  ', CAST(N'2023-10-29' AS Date), 14976000.0000, 3900000, 0.0000, 4500000, NULL, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0013  ', CAST(N'2023-10-29' AS Date), 6160000.0000, 3950000, 0.0000, 4500000, 9434400, N'CN0012    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0014  ', CAST(N'2023-10-29' AS Date), 5200000.0000, 3000000, 0.0000, 4500000, 8474920, N'CN0013    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0015  ', CAST(N'2023-10-29' AS Date), 12672000.0000, 3200000, 0.0000, 4500000, 14868140, N'CN0015    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0016  ', CAST(N'2023-10-29' AS Date), 16896000.0000, 3300000, 0.0000, 4500000, 21309440, N'CN0016    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0017  ', CAST(N'2023-10-29' AS Date), 8320000.0000, 3400000, 0.0000, 4500000, 11338940, N'CN0017    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0018  ', CAST(N'2023-10-29' AS Date), 13440000.0000, 3500000, 0.0000, 4500000, 15591620, N'CN0018    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0019  ', CAST(N'2023-10-29' AS Date), 3600000.0000, 3600000, 0.0000, 4500000, 6862600, N'CN0019    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0020  ', CAST(N'2023-08-29' AS Date), 5133000.0000, 3000000, 0.0000, 4500000, 8335820, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0021  ', CAST(N'2023-08-29' AS Date), 8850000.0000, 3100000, 0.0000, 4500000, 11239640, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0022  ', CAST(N'2023-08-29' AS Date), 12672000.0000, 3200000, 0.0000, 4500000, 14683820, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0023  ', CAST(N'2023-08-29' AS Date), 16896000.0000, 3300000, 0.0000, 4500000, 21056160, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0024  ', CAST(N'2023-08-29' AS Date), 11250000.0000, 3450000, 0.0000, 4500000, 13570500, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0025  ', CAST(N'2023-08-29' AS Date), 9000000.0000, 3550000, 0.0000, 4500000, 11635000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0026  ', CAST(N'2023-08-29' AS Date), 12980000.0000, 3600000, 0.0000, 4500000, 15205220, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0027  ', CAST(N'2023-08-29' AS Date), 12980000.0000, 3600000, 0.0000, 4500000, 15205220, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0028  ', CAST(N'2023-08-29' AS Date), 7680000.0000, 3700000, 0.0000, 4500000, 11203540, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0029  ', CAST(N'2023-08-29' AS Date), 15667200.0000, 3800000, 0.0000, 4500000, 20872480, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0030  ', CAST(N'2023-08-29' AS Date), 16380000.0000, 3900000, 0.0000, 4500000, 21675200, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0031  ', CAST(N'2023-08-29' AS Date), 14976000.0000, 3900000, 0.0000, 4500000, 17475140, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0032  ', CAST(N'2023-08-29' AS Date), 4840000.0000, 3950000, 0.0000, 4500000, 8347200, N'CN0012    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0033  ', CAST(N'2023-08-29' AS Date), 5200000.0000, 3000000, 0.0000, 4500000, 8437480, N'CN0013    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0034  ', CAST(N'2023-08-29' AS Date), 12672000.0000, 3200000, 0.0000, 4500000, 14414860, N'CN0015    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0035  ', CAST(N'2023-08-29' AS Date), 16896000.0000, 3300000, 0.0000, 4500000, 20802560, N'CN0016    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0036  ', CAST(N'2023-08-29' AS Date), 7680000.0000, 3400000, 0.0000, 4500000, 11432680, N'CN0017    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0037  ', CAST(N'2023-08-29' AS Date), 8640000.0000, 3500000, 0.0000, 4500000, 10574660, N'CN0018    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0038  ', CAST(N'2023-08-29' AS Date), 3600000.0000, 3600000, 0.0000, 4500000, 6906600, N'CN0019    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0039  ', CAST(N'2023-09-29' AS Date), 7670000.0000, 3000000, 0.0000, 4500000, 10204960, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0040  ', CAST(N'2023-09-29' AS Date), 10620000.0000, 3100000, 0.0000, 4500000, 12729980, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0041  ', CAST(N'2023-09-29' AS Date), 12672000.0000, 3200000, 0.0000, 4500000, 14584140, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0042  ', CAST(N'2023-09-29' AS Date), 16896000.0000, 3300000, 0.0000, 4500000, 21071520, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0043  ', CAST(N'2023-09-29' AS Date), 9750000.0000, 3450000, 0.0000, 4500000, 12219500, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0044  ', CAST(N'2023-09-29' AS Date), 9000000.0000, 3550000, 0.0000, 4500000, 11647000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0045  ', CAST(N'2023-09-29' AS Date), 12980000.0000, 3600000, 0.0000, 4500000, 15049460, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0046  ', CAST(N'2023-09-29' AS Date), 12980000.0000, 3600000, 0.0000, 4500000, 15049460, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0047  ', CAST(N'2023-09-29' AS Date), 7680000.0000, 3700000, 0.0000, 4500000, 10880980, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0048  ', CAST(N'2023-09-29' AS Date), 15360000.0000, 3800000, 0.0000, 4500000, 20527040, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0049  ', CAST(N'2023-09-29' AS Date), 16380000.0000, 3900000, 0.0000, 4500000, 21490400, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0050  ', CAST(N'2023-09-29' AS Date), 14976000.0000, 3900000, 0.0000, 4500000, 17306180, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0051  ', CAST(N'2023-09-29' AS Date), 5280000.0000, 3950000, 0.0000, 4500000, 8695200, N'CN0012    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0052  ', CAST(N'2023-09-29' AS Date), 8840000.0000, 3000000, 0.0000, 4500000, 10938700, N'CN0013    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0053  ', CAST(N'2023-09-29' AS Date), 12672000.0000, 3200000, 0.0000, 4500000, 14599180, N'CN0015    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0054  ', CAST(N'2023-09-29' AS Date), 11264000.0000, 3300000, 0.0000, 4500000, 13587380, N'CN0016    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0055  ', CAST(N'2023-09-29' AS Date), 1280000.0000, 3400000, 0.0000, 4500000, 5529620, N'CN0017    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0056  ', CAST(N'2023-09-29' AS Date), 4800000.0000, 3500000, 0.0000, 4500000, 8608120, N'CN0018    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0057  ', CAST(N'2023-09-29' AS Date), 3600000.0000, 3600000, 0.0000, 4500000, 6863400, N'CN0019    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0058  ', CAST(N'2023-11-29' AS Date), 4891100.0000, 3000000, 0.0000, 4500000, 7818110, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0059  ', CAST(N'2023-11-29' AS Date), 13275000.0000, 3100000, 0.0000, 4500000, 15144250, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0060  ', CAST(N'2023-11-29' AS Date), 8064000.0000, 3200000, 0.0000, 4500000, 10313420, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0061  ', CAST(N'2023-11-29' AS Date), 14080000.0000, 3300000, 0.0000, 4500000, 16334580, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0062  ', CAST(N'2023-11-29' AS Date), 11775000.0000, 3450000, 0.0000, 4500000, 13412750, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0063  ', CAST(N'2023-11-29' AS Date), 9000000.0000, 3550000, 0.0000, 4500000, 10555000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0064  ', CAST(N'2023-11-29' AS Date), 10384000.0000, 3600000, 0.0000, 4500000, 12403020, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0065  ', CAST(N'2023-11-29' AS Date), 10384000.0000, 3600000, 0.0000, 4500000, 12403020, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0066  ', CAST(N'2023-11-29' AS Date), 10240000.0000, 3700000, 0.0000, 4500000, 11765780, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0067  ', CAST(N'2023-11-29' AS Date), 6374400.0000, 3800000, 0.0000, 4500000, 9857480, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0068  ', CAST(N'2023-11-29' AS Date), 8820000.0000, 3900000, 0.0000, 4500000, 10761900, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0069  ', CAST(N'2023-11-29' AS Date), 8064000.0000, 3900000, 0.0000, 4500000, 10761900, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0070  ', CAST(N'2023-11-29' AS Date), 3080000.0000, 3950000, 0.0000, 4500000, 6346400, N'CN0012    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0071  ', CAST(N'2023-11-29' AS Date), 3640000.0000, 3000000, 0.0000, 4500000, 6072040, N'CN0013    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0072  ', CAST(N'2023-11-29' AS Date), 16243200.0000, 3200000, 0.0000, 4500000, NULL, N'CN0015    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0073  ', CAST(N'2023-11-29' AS Date), 11264000.0000, 3300000, 0.0000, 4500000, 12796180, N'CN0016    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0074  ', CAST(N'2023-11-29' AS Date), 4480000.0000, 3400000, 0.0000, 4500000, 7154280, N'CN0017    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0075  ', CAST(N'2023-11-29' AS Date), 14400000.0000, 3500000, 0.0000, 4500000, 15631780, N'CN0018    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0076  ', CAST(N'2023-11-29' AS Date), 4680000.0000, 3600000, 0.0000, 4500000, 7471400, N'CN0019    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0077  ', CAST(N'2023-12-12' AS Date), 4891100.0000, 3000000, 0.0000, 4500000, 7236670, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0078  ', CAST(N'2023-12-12' AS Date), 7522500.0000, 3100000, 0.0000, 4500000, 9794930, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0079  ', CAST(N'2023-12-12' AS Date), 8294400.0000, 3200000, 0.0000, 4500000, 9710540, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0080  ', CAST(N'2023-12-12' AS Date), 12672000.0000, 3300000, 0.0000, 4500000, 14230900.000000002, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0081  ', CAST(N'2023-12-12' AS Date), 4275000.0000, 3450000, 0.0000, 4500000, 7401500, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0082  ', CAST(N'2023-12-12' AS Date), 6300000.0000, 3550000, 0.0000, 4500000, 9214000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0083  ', CAST(N'2023-12-12' AS Date), 10384000.0000, 3600000, 0.0000, 4500000, 12075580, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0084  ', CAST(N'2023-12-12' AS Date), 10384000.0000, 3600000, 0.0000, 4500000, 12075580, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0085  ', CAST(N'2023-12-12' AS Date), 3840000.0000, 3700000, 0.0000, 4500000, 7470200, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0086  ', CAST(N'2023-12-12' AS Date), 6374400.0000, 3800000, 0.0000, 4500000, 9719240, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0087  ', CAST(N'2023-12-12' AS Date), 8820000.0000, 3900000, 0.0000, 4500000, 10728300, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0088  ', CAST(N'2023-12-12' AS Date), 8064000.0000, 3900000, 0.0000, 4500000, 10728300, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0089  ', CAST(N'2023-12-12' AS Date), 3080000.0000, 3950000, 0.0000, 4500000, 6293600, N'CN0012    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0090  ', CAST(N'2023-12-12' AS Date), 3640000.0000, 3000000, 0.0000, 4500000, 5922280, N'CN0013    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0091  ', CAST(N'2023-12-12' AS Date), 4723200.0000, 3200000, 0.0000, 4500000, 7108840, N'CN0015    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0092  ', CAST(N'2023-12-12' AS Date), 11264000.0000, 3300000, 0.0000, 4500000, 12627220, N'CN0016    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0093  ', CAST(N'2023-12-12' AS Date), 4480000.0000, 3400000, 0.0000, 4500000, 7100680, N'CN0017    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0094  ', CAST(N'2023-12-12' AS Date), 4800000.0000, 3500000, 0.0000, 4500000, 7678680, N'CN0018    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0095  ', CAST(N'2023-12-12' AS Date), 1080000.0000, 3600000, 0.0000, 4500000, 4712460, N'CN0019    ')
GO
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0001  ', CAST(N'2023-08-29' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 14292346.153846152, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0002  ', CAST(N'2023-09-29' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 19613884.615384612, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0003  ', CAST(N'2023-10-29' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 18319269.230769228, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0004  ', CAST(N'2023-11-29' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 15607730.769230768, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0005  ', CAST(N'2023-12-12' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 6164653.8461538451, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0006  ', CAST(N'2023-12-12' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 7573500, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0007  ', CAST(N'2023-11-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 22333500, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0008  ', CAST(N'2023-10-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 20893500, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0009  ', CAST(N'2023-09-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 21613500, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0010  ', CAST(N'2023-08-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 14893500, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0011  ', CAST(N'2023-08-29' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 18521500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0012  ', CAST(N'2023-09-29' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 17996500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0013  ', CAST(N'2023-10-29' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 17321500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0014  ', CAST(N'2023-11-29' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 20321500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0015  ', CAST(N'2023-12-12' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 8509000, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0016  ', CAST(N'2023-12-12' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 9756000, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0017  ', CAST(N'2023-11-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 22513500, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0018  ', CAST(N'2023-10-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 22768500, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0019  ', CAST(N'2023-09-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 26158500, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0020  ', CAST(N'2023-08-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 18268500, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0021  ', CAST(N'2023-08-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 23413500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0022  ', CAST(N'2023-09-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 23413500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0023  ', CAST(N'2023-10-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 22558500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0024  ', CAST(N'2023-11-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 23413500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0025  ', CAST(N'2023-12-12' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 7809750, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0026  ', CAST(N'2023-12-12' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 9013500, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0027  ', CAST(N'2023-11-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 24448500, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0028  ', CAST(N'2023-10-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 24448500, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0029  ', CAST(N'2023-09-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 21202500, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0030  ', CAST(N'2023-08-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 21202500, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0031  ', CAST(N'2023-08-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 26083500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0032  ', CAST(N'2023-09-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 26083500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0033  ', CAST(N'2023-10-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 26083500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0034  ', CAST(N'2023-11-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 27313500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0035  ', CAST(N'2023-12-12' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 21913500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0036  ', CAST(N'2023-12-12' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 21115615.384615391, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0037  ', CAST(N'2023-11-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 23706961.538461544, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0038  ', CAST(N'2023-10-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 23706961.538461544, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0039  ', CAST(N'2023-09-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 16887730.769230772, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0040  ', CAST(N'2023-08-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 16887730.769230772, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0041  ', CAST(N'2023-08-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 21878884.615384616, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0042  ', CAST(N'2023-09-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 25280423.076923076, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0043  ', CAST(N'2023-10-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 24096576.923076924, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0044  ', CAST(N'2023-11-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 24096576.923076924, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0045  ', CAST(N'2023-12-12' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 21511961.53846154, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0046  ', CAST(N'2023-12-12' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 27471000, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0047  ', CAST(N'2023-11-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 33478500, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0048  ', CAST(N'2023-10-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 38818500, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0049  ', CAST(N'2023-09-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 38818500, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0050  ', CAST(N'2023-08-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 24201000, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0051  ', CAST(N'2023-08-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 27210374.999999996, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0052  ', CAST(N'2023-09-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 27210374.999999996, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0053  ', CAST(N'2023-10-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 23221528.84615384, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0054  ', CAST(N'2023-11-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 30119605.769230764, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0055  ', CAST(N'2023-12-12' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 12904990.384615384, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0056  ', CAST(N'2023-12-12' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 16280711.53846154, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0057  ', CAST(N'2023-11-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 35732634.615384616, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0058  ', CAST(N'2023-10-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 26796096.153846156, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0059  ', CAST(N'2023-09-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 28035519.230769232, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0060  ', CAST(N'2023-08-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 28035519.230769232, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0061  ', CAST(N'2023-08-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 29002298.07692308, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0062  ', CAST(N'2023-09-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 29002298.07692308, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0063  ', CAST(N'2023-10-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 33248682.692307696, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0064  ', CAST(N'2023-11-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 34614144.230769232, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0065  ', CAST(N'2023-12-12' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 15497682.692307692, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0066  ', CAST(N'2023-12-12' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 16833461.53846154, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0067  ', CAST(N'2023-11-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 35856230.769230768, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0068  ', CAST(N'2023-10-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 34497461.538461536, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0069  ', CAST(N'2023-09-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 35856230.769230768, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0070  ', CAST(N'2023-08-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 35856230.769230768, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0071  ', CAST(N'2023-08-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 35870423.076923072, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0072  ', CAST(N'2023-09-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 35870423.076923072, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0073  ', CAST(N'2023-10-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 34494461.538461536, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0074  ', CAST(N'2023-11-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 35870423.076923072, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0075  ', CAST(N'2023-12-12' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 16606961.53846154, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0076  ', CAST(N'2023-12-12' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 24028096.153846152, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0077  ', CAST(N'2023-11-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 24028096.153846152, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0078  ', CAST(N'2023-10-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 24028096.153846152, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0079  ', CAST(N'2023-09-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 24028096.153846152, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0080  ', CAST(N'2023-08-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 24028096.153846152, 11800000.0000, N'NV0070    ')
GO
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'          ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD001     ', N'Cắt vải', CAST(N'2023-11-01T00:00:00.000' AS DateTime), 500, 5000.0000, 1, N'SP001     ', CAST(N'2023-11-15T00:00:00.000' AS DateTime), N'Cắt vải', 1, 500, 1)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD002     ', N'May áo', CAST(N'2023-11-05T00:00:00.000' AS DateTime), 480, 5500.0000, 1, N'SP001     ', CAST(N'2023-11-23T00:00:00.000' AS DateTime), N'May kim', 1, 480, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD003     ', N'May cổ áo', CAST(N'2023-11-10T00:00:00.000' AS DateTime), 450, 6000.0000, 1, N'SP001     ', CAST(N'2023-11-21T00:00:00.000' AS DateTime), N'May kim', 1, 450, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD004     ', N'In hình', CAST(N'2023-11-15T00:00:00.000' AS DateTime), 420, 6500.0000, 1, N'SP001     ', CAST(N'2023-11-21T00:00:00.000' AS DateTime), N'In thêu', 1, 420, 3)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD005     ', N'Kiểm tra chất lượng', CAST(N'2023-11-20T00:00:00.000' AS DateTime), 400, 7000.0000, 1, N'SP001     ', NULL, N'Kiểm tra', 1, 400, 4)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD006     ', N'Cắt vải', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 450, 5200.0000, 1, N'SP002     ', NULL, N'Cắt vải', 1, 450, 1)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD007     ', N'May áo', CAST(N'2023-11-06T00:00:00.000' AS DateTime), 200, 5900.0000, 0, N'SP002     ', NULL, N'Vắt sổ', 0, 0, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD008     ', N'May cổ áo', CAST(N'2023-11-11T00:00:00.000' AS DateTime), 400, 6400.0000, 0, N'SP002     ', NULL, N'Vắt sổ', 0, 0, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD009     ', N'In hình', CAST(N'2023-11-16T00:00:00.000' AS DateTime), 380, 6900.0000, 0, N'SP002     ', NULL, N'In thêu', 0, 0, 3)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD010     ', N'Cắt vải', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 500, 5400.0000, 1, N'SP003     ', NULL, N'Cắt vải', 1, 500, 1)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD011     ', N'May quần', CAST(N'2023-11-07T00:00:00.000' AS DateTime), 480, 6100.0000, 1, N'SP003     ', NULL, N'May kim', 1, 480, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD012     ', N'May túi', CAST(N'2023-11-12T00:00:00.000' AS DateTime), 460, 6800.0000, 1, N'SP003     ', NULL, N'Vắt sổ', 1, 460, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD013     ', N'May đáy quần', CAST(N'2023-11-17T00:00:00.000' AS DateTime), 440, 7500.0000, 1, N'SP003     ', NULL, N'Vắt sổ', 1, 440, 2)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD014     ', N'Đính nút', CAST(N'2023-11-22T00:00:00.000' AS DateTime), 420, 8200.0000, 1, N'SP003     ', NULL, N'Đính nút', 1, 500, 3)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD015     ', N'Kiểm tra chất lượng', CAST(N'2023-11-27T00:00:00.000' AS DateTime), 400, 8900.0000, 1, N'SP003     ', NULL, N'Kiểm tra', 1, 500, 4)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan], [chuyenMon], [trangThaiPhanCong], [soLuongHoanThanh], [doUuTien]) VALUES (N'CD016     ', N'Kiểm tra', CAST(N'2023-11-01T00:00:00.000' AS DateTime), 300, 2000.0000, 1, N'SP003     ', CAST(N'2023-11-15T00:00:00.000' AS DateTime), N'Kiểm tra', 1, 500, 4)
GO
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0001    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn An', 1, N'123 Le loi, Quận 9, Thành Phố HCM', CAST(N'2022-01-01T00:00:00.000' AS DateTime), 1, N'0123456781', N'Xưởng 1', 3000000, N'Vắt sổ', N'link_hinh_anh1.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0002    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Binh', 0, N'456 Huynh Khuong An, Quận GV, Thành Phố HCM', CAST(N'2022-02-01T00:00:00.000' AS DateTime), 1, N'0123456782', N'Xưởng 2', 3100000, N'Vắt sổ', N'link_hinh_anh2.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0003    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Cao', 1, N'789 Đường GHI, Quận 8, Thành Phố HCM', CAST(N'2022-03-01T00:00:00.000' AS DateTime), 1, N'0123456783', N'Xưởng 1', 3200000, N'May kim', N'link_hinh_anh3.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0004    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Duy', 0, N'101 Đường Tôn duc thang, Quận 3, Thành Phố HCM', CAST(N'2022-04-01T00:00:00.000' AS DateTime), 1, N'0123456784', N'Xưởng 2', 3300000, N'May kim', N'link_hinh_anh4.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0006    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Bình', 1, N'303 Đường VWX, Quận YZA, Thành Phố HCM', CAST(N'2022-06-01T00:00:00.000' AS DateTime), 1, N'0123456786', N'Xưởng 2', 3450000, N'Cắt vải', N'link_hinh_anh6.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0007    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Gia', 0, N'404 Đường BCD, Quận EFG, Thành Phố HCM', CAST(N'2022-07-01T00:00:00.000' AS DateTime), 1, N'0123456787', N'Xưởng 1', 3550000, N'Làm mẫu', N'link_hinh_anh7.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0008    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Hi', 1, N'505 Đường HIJ, Quận KLM, Thành Phố HCM', CAST(N'2022-08-01T00:00:00.000' AS DateTime), 1, N'0123456788', N'Xưởng 2', 3600000, N'Vắt sổ', N'link_hinh_anh8.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0009    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Ing', 0, N'606 Đường MNO, Quận PQR, Thành Phố HCM', CAST(N'2022-09-01T00:00:00.000' AS DateTime), 1, N'0123456789', N'Xưởng 1', 3700000, N'May kim', N'link_hinh_anh9.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0010    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Giang', 1, N'707 Đường STU, Quận VWX, Thành Phố HCM', CAST(N'2022-10-01T00:00:00.000' AS DateTime), 1, N'0123456790', N'Xưởng 2', 3800000, N'May kim', N'link_hinh_anh10.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0011    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Kkhang', 0, N'808 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2022-11-01T00:00:00.000' AS DateTime), 1, N'0123456791', N'Xưởng 1', 3900000, N'May kim', N'link_hinh_anh11.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0012    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Le', 1, N'909 Đường EFG, Quận HIJ, Thành Phố HCM', CAST(N'2022-12-01T00:00:00.000' AS DateTime), 1, N'0123456792', N'Xưởng 2', 3950000, N'Kiểm Tra', N'link_hinh_anh12.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0013    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị My', 1, N'1010 Đường KLM, Quận NOP, Thành Phố HCM', CAST(N'2023-01-01T00:00:00.000' AS DateTime), 1, N'0123456793', N'Xưởng 1', 3000000, N'Cắt vải', N'link_hinh_anh13.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0014    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Na', 1, N'1111 Đường PQR, Quận STU, Thành Phố HCM', CAST(N'2023-02-01T00:00:00.000' AS DateTime), 1, N'0123456794', N'Xưởng 2', 3100000, N'Làm mẫu', N'link_hinh_anh14.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0015    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Ong', 0, N'1212 Đường VWX, Quận YZA, Thành Phố HCM', CAST(N'2023-03-01T00:00:00.000' AS DateTime), 1, N'0123456795', N'Xưởng 1', 3200000, N'Vắt sổ', N'link_hinh_anh15.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0016    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Phu', 1, N'1313 Đường BCD, Quận EFG, Thành Phố HCM', CAST(N'2023-04-01T00:00:00.000' AS DateTime), 1, N'0123456796', N'Xưởng 2', 3300000, N'Vắt sổ', N'link_hinh_anh16.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0017    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Quy', 0, N'1414 Đường HIJ, Quận KLM, Thành Phố HCM', CAST(N'2023-05-01T00:00:00.000' AS DateTime), 1, N'0123456797', N'Xưởng 1', 3400000, N'Vắt sổ', N'link_hinh_anh17.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0018    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Rê', 1, N'1515 Đường NOP, Quận PQR, Thành Phố HCM', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 1, N'0123456798', N'Xưởng 2', 3500000, N'May kim', N'link_hinh_anh18.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0019    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Su', 0, N'1616 Đường STU, Quận VWX, Thành Phố HCM', CAST(N'2023-07-01T00:00:00.000' AS DateTime), 1, N'0123456799', N'Xưởng 1', 3600000, N'Kiểm tra', N'link_hinh_anh19.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0020    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Thinh', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'Đính nút', N'link_hinh_anh20.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0021    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Thin', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'Đóng gói', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0022    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Phú Khang', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0023    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đức', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0024    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0025    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq1', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0026    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq1', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0027    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq1', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0028    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq1', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0029    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq1', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0030    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Việt Đứcq2', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'In thêu', NULL)
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0001    ', 8000000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Trung', 1, N'16 Nguyễn Văn Nghi, Phường 6, Gò Vấp,Tp HCM', N'Kế Toán', CAST(N'2000-01-01T00:00:00.000' AS DateTime), 1.86, 575000, N'0123456789', N'VanTrung@gmail.com', 3500000, N'Phòng Kế Toán', N'link_hinh_anh1.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0002    ', 9000000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Ngọc', 0, N'18 Lê Lợi,Phường 7, Gò Vấp, Tp HCM', N'Nhân Viên', CAST(N'2001-02-15T00:00:00.000' AS DateTime), 2.08, 1300000, N'0123456789', N'NgocPham@gmail.com', 4000000, N'Phòng Nhân Sự', N'link_hinh_anh2.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0003    ', 7500000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Trọng Thành', 1, N'Tp HCM', N'Quản Lý Nhân Sự', CAST(N'1999-12-10T00:00:00.000' AS DateTime), 2.34, 1050000, N'0123456789', N'TrongLe@gmail.com', 3000000, N'Phòng Kế Toán', N'link_hinh_anh3.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0010    ', 9000000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Bình', 0, N'Tp HCM', N'Nhân Viên', CAST(N'2008-07-07T00:00:00.000' AS DateTime), 2.34, 1300000, N'0123456789', N'BinhLe@gmail.com', 4000000, N'Phòng Nhân Sự', N'link_hinh_anh10.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0011    ', 9500000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Mai', 0, N'202 Lê Lợi, Quận 3, Tp HCM', N'Quản Lý Nhân Sự', CAST(N'2010-03-20T00:00:00.000' AS DateTime), 2.34, 1248500, N'0123456789', N'MaiVo@gmail.com', 4500000, N'Phòng Nhân Sự', N'link_hinh_anh11.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0012    ', 9800000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Minh', 1, N'257 Phan Đình Phùng, Quận Phú Nhuận, Tp HCM', N'Quản Lý Nhân Sự', CAST(N'2009-05-15T00:00:00.000' AS DateTime), 2.34, 1331000, N'0123456789', N'MinhLe@gmail.com', 4700000, N'Phòng Nhân Sự', N'link_hinh_anh12.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0061    ', 12000000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Lan', 0, N'17 Nguyễn Du, p1, q1, Tp HCM', N'Xưởng trưởng', CAST(N'2022-01-15T00:00:00.000' AS DateTime), 2.34, 2415500, N'0123456789', N'LanNguyen@gmail.com', 5000000, N'Xưởng sản xuất', N'link_hinh_anh61.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0062    ', 11000000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Huệ', 0, N'257 Phan Đình Phùng, Quận Phú Nhuận, Tp HCM', N'Trưởng phòng', CAST(N'2022-02-20T00:00:00.000' AS DateTime), 2.45, 2106500, N'0123456789', N'HueTran@gmail.com', 4800000, N'Phòng Nhân sự', N'link_hinh_anh62.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0063    ', 10500000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Thảo', 0, N'16/12 Nguyen Van Nghi, p5, gv, Tp HCM', N'Xưởng trưởng', CAST(N'2022-03-25T00:00:00.000' AS DateTime), 2.56, 1937000, N'0123456789', N'ThaoLe@gmail.com', 4700000, N'Xưởng sản xuất', N'link_hinh_anh63.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0064    ', 13000000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Mai', 0, N'334 Tran Dai Nghia, p2, Tp HCM', N'Trưởng phòng', CAST(N'2022-04-30T00:00:00.000' AS DateTime), 2.67, 2742000, N'0123456789', N'MaiPham@gmail.com', 5200000, N'Phòng Nhân sự', N'link_hinh_anh64.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0065    ', 11500000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thi Ngoc', 0, N'Tp HCM', N'Nhân Viên', CAST(N'2021-05-05T00:00:00.000' AS DateTime), 2.78, 2392500, N'0123456789', N'NgocDinh@gmail.com', 5000000, N'Kinh Doanh', N'link_hinh_anh65.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0066    ', 12500000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Hà', 0, N'Le Lai, p10, gv, Tp HCM', N'Nhân Viên', CAST(N'2022-06-10T00:00:00.000' AS DateTime), 2.89, 2575500, N'0123456789', N'HaVo@gmail.com', 5100000, N'Kinh Doanh', N'link_hinh_anh66.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0067    ', 12200000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Diễm', 0, N'133 Phan Huy Ich, p17, q7, Tp HCM', N'Nhân Viên', CAST(N'2022-07-15T00:00:00.000' AS DateTime), 2.91, 2521000, N'0123456789', N'DiemNguyen@gmail.com', 5050000, N'Kinh Doanh', N'link_hinh_anh67.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0068    ', 12800000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Phượng', 0, N'Ton Duc Thang, p9, q Binh Thanh, Tp HCM', N'Nhân Viên', CAST(N'2022-08-20T00:00:00.000' AS DateTime), 2.76, 2685000, N'0123456789', N'PhuongDinh@gmail.com', 5150000, N'Kinh Doanh', N'link_hinh_anh68.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0069    ', 13500000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Thúy', 0, N'133 Phan Huy Ich, p17, q7,Tp HCM', N'Nhân Viên', CAST(N'2022-09-25T00:00:00.000' AS DateTime), 2.65, 2937000, N'0123456789', N'ThuyVu@gmail.com', 5300000, N'Kinh Doanh', N'link_hinh_anh69.jpg')
INSERT [dbo].[NhanVien] ([maNhanVien], [luongCoBan], [ngaySinh], [ten], [gioiTinh], [diaChi], [chucDanh], [ngayThamGia], [hsLuong], [ThueThuNhapCaNhan], [sDT], [email], [luongPhuCap], [phongBan], [hinhanhnv]) VALUES (N'NV0070    ', 11800000.0000, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Hiền', 0, N'133 Phan Huy Ich, p17, q7,Tp HCM', N'Nhân Viên', CAST(N'2022-10-30T00:00:00.000' AS DateTime), 2.54, 2460500, N'0123456789', N'HienLe@gmail.com', 4900000, N' Kinh Doanh', N'link_hinh_anh70.jpg')
GO
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0001  ', N'CD007     ', N'CN0001    ', CAST(N'2023-12-08' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0002  ', N'CD007     ', N'CN0002    ', CAST(N'2023-12-08' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0003  ', N'CD008     ', N'CN0003    ', CAST(N'2023-10-22' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0006  ', N'CD001     ', N'CN0006    ', CAST(N'2023-10-22' AS Date), N'SP004     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (10, N'PCCD0007  ', N'CD001     ', N'CN0007    ', CAST(N'2023-10-22' AS Date), N'SP003     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0008  ', N'CD007     ', N'CN0008    ', CAST(N'2023-12-08' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0009  ', N'CD008     ', N'CN0009    ', CAST(N'2023-10-22' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0010  ', N'CD008     ', N'CN0010    ', CAST(N'2023-10-22' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD0011  ', N'CD006     ', N'CN0013    ', CAST(N'2023-11-15' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD1084  ', N'CD009     ', N'CN0027    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD1087  ', N'CD008     ', N'CN0017    ', CAST(N'2023-12-08' AS Date), N'SP003     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD1820  ', N'CD009     ', N'CN0024    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD2094  ', N'CD009     ', N'CN0025    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD2135  ', N'CD009     ', N'CN0029    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD2617  ', N'CD008     ', N'CN0016    ', CAST(N'2023-12-08' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD3104  ', N'CD009     ', N'CN0022    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD3180  ', N'CD005     ', N'CN0011    ', CAST(N'2023-11-14' AS Date), N'SP004     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD7083  ', N'CD009     ', N'CN0023    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD7230  ', N'CD009     ', N'CN0030    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD7952  ', N'CD009     ', N'CN0026    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD8405  ', N'CD008     ', N'CN0004    ', CAST(N'2023-11-13' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD8406  ', N'CD007     ', N'CN0008    ', CAST(N'2023-12-08' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD8407  ', N'CD008     ', N'CN0015    ', CAST(N'2023-12-08' AS Date), N'SP003     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD8408  ', N'CD008     ', N'CN0011    ', CAST(N'2023-11-15' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD8409  ', N'CD008     ', N'CN0018    ', CAST(N'2023-11-15' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (0, N'PCCD8831  ', N'CD009     ', N'CN0028    ', CAST(N'2023-12-06' AS Date), N'SP002     ')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP001     ', N'Áo Polo Nam', 5, 500, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP002     ', N'Áo Sơ Mi Nữ', 4, 450, 0)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP003     ', N'Quần Jean Nam', 6, 550, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP004     ', N'Quần Legging Nữ', 5, 480, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP005     ', N'Áo Thun Trơn Unisex', 6, 600, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP006     ', N'Áo Khoác Nam', 4, 420, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP007     ', N'Quần Shorts Nữ', 6, 700, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP008     ', N'Quần Âu Nam', 3, 460, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP009     ', N'Áo Len Nữ', 6, 430, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP010     ', N'Quần Jogger Nam', 5, 480, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP011     ', N'Đầm', 4, 200, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong], [trangThai]) VALUES (N'SP012     ', N'Váy', 2, 100, 1)
GO
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'KT001     ', N'KT001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV0001    ', NULL)
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'QL001     ', N'QL001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'TP001     ', N'TP001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'XT001     ', N'XT001')
GO
ALTER TABLE [dbo].[BangChamCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK__BangChamCo__maCN__4AB81AF0] FOREIGN KEY([maCN])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BangChamCongCongNhan] CHECK CONSTRAINT [FK__BangChamCo__maCN__4AB81AF0]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_BangChamCongNhanVien_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] CHECK CONSTRAINT [FK_BangChamCongNhanVien_NhanVien]
GO
ALTER TABLE [dbo].[BangluongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_BangLuongCongNhan_CongNhan] FOREIGN KEY([MaCN])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[BangluongCongNhan] CHECK CONSTRAINT [FK_BangLuongCongNhan_CongNhan]
GO
ALTER TABLE [dbo].[BangluongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_BangLuongNhanVien_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BangluongNhanVien] CHECK CONSTRAINT [FK_BangLuongNhanVien_NhanVien]
GO
ALTER TABLE [dbo].[CongDoanSanPham]  WITH CHECK ADD  CONSTRAINT [FK__CongDoanSa__maSP__4E88ABD4] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[CongDoanSanPham] CHECK CONSTRAINT [FK__CongDoanSa__maSP__4E88ABD4]
GO
ALTER TABLE [dbo].[PhanCongCongDoan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongDoan_CongDoanSanPham] FOREIGN KEY([maCD])
REFERENCES [dbo].[CongDoanSanPham] ([maCongDoan])
ON UPDATE SET NULL
GO
ALTER TABLE [dbo].[PhanCongCongDoan] CHECK CONSTRAINT [FK_PhanCongCongDoan_CongDoanSanPham]
GO
ALTER TABLE [dbo].[PhanCongCongDoan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongDoan_CongNhan] FOREIGN KEY([maCN])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[PhanCongCongDoan] CHECK CONSTRAINT [FK_PhanCongCongDoan_CongNhan]
GO
ALTER TABLE [dbo].[PhieuLuong]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[PhieuLuong]  WITH CHECK ADD  CONSTRAINT [FK_BangLuongNhanVien_PhieuLuong] FOREIGN KEY([maBangLuong])
REFERENCES [dbo].[BangluongNhanVien] ([maBangLuong])
GO
ALTER TABLE [dbo].[PhieuLuong] CHECK CONSTRAINT [FK_BangLuongNhanVien_PhieuLuong]
GO
ALTER TABLE [dbo].[PhieuLuong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuLuong_BangLuongCongNhan] FOREIGN KEY([maBangLuong])
REFERENCES [dbo].[BangluongCongNhan] ([maBangLuong])
GO
ALTER TABLE [dbo].[PhieuLuong] CHECK CONSTRAINT [FK_PhieuLuong_BangLuongCongNhan]
GO
ALTER TABLE [dbo].[PhieuLuong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuLuong_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuLuong] CHECK CONSTRAINT [FK_PhieuLuong_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QLLUONG] SET  READ_WRITE 
GO
