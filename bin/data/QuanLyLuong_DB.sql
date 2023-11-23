USE [master]
GO
/****** Object:  Database [QLLUONG]    Script Date: 11/15/2023 3:28:34 PM ******/
CREATE DATABASE [QLLUONG]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLLUONG', FILENAME = N'D:\Desktop\Kỳ1_23-24\Phát Triển Ứng Dụng\CK\DB\QLLUONG.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLLUONG_log', FILENAME = N'D:\Desktop\Kỳ1_23-24\Phát Triển Ứng Dụng\CK\DB\QLLUONG_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
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
EXEC sys.sp_db_vardecimal_storage_format N'QLLUONG', N'ON'
GO
ALTER DATABASE [QLLUONG] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLLUONG] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLLUONG]
GO
/****** Object:  Table [dbo].[BangChamCongCongNhan]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[BangluongCongNhan]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[BangluongNhanVien]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[CongDoanSanPham]    Script Date: 11/15/2023 3:28:34 PM ******/
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
PRIMARY KEY CLUSTERED 
(
	[maCongDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhan]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[PhanCongCongDoan]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[PhieuLuong]    Script Date: 11/15/2023 3:28:34 PM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/15/2023 3:28:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [char](10) NOT NULL,
	[tenSanPham] [nvarchar](20) NULL,
	[soLuongCongDoan] [int] NULL,
	[soLuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/15/2023 3:28:34 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0001 ', 28, 1, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2030, 0, 700, N'CN0001    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0002 ', 22, 7, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1800, 2, NULL, N'CN0002    ', 800)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0003 ', 25, 3, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2100, 1, NULL, N'CN0003    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0004 ', 26, 1, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0004    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0005 ', 23, 3, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2300, 3, NULL, N'CN0005    ', 900)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0006 ', 25, 3, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2400, 1, NULL, N'CN0006    ', 850)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0007 ', 24, 4, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2000, 1, NULL, N'CN0007    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0008 ', 22, 6, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1800, 4, NULL, N'CN0008    ', 800)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0009 ', 26, 2, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2100, 0, NULL, N'CN0009    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0010 ', 25, 3, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2200, 1, NULL, N'CN0010    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0011 ', 24, 3, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2300, 1, NULL, N'CN0011    ', 900)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0012 ', 25, 1, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2400, 0, NULL, N'CN0012    ', 850)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0013 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2000, 0, NULL, N'CN0013    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0014 ', 22, 4, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1800, 3, NULL, N'CN0014    ', 800)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0015 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2100, 0, NULL, N'CN0015    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0016 ', 24, 2, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2200, 1, NULL, N'CN0016    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0017 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2300, 0, NULL, N'CN0017    ', 900)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0018 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2400, 0, NULL, N'CN0018    ', 850)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0019 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 2000, 0, NULL, N'CN0019    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN0020 ', 26, 0, CAST(N'2023-10-29T00:00:00.000' AS DateTime), 1800, 0, NULL, N'CN0020    ', 800)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1001 ', 25, 6, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1870, 2, 600, N'CN0001    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1002 ', 22, 7, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2000, 2, NULL, N'CN0002    ', 500)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1003 ', 25, 3, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2100, 1, NULL, N'CN0003    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1004 ', 26, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0004    ', 250)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1005 ', 23, 3, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2700, 3, NULL, N'CN0005    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1006 ', 26, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2500, 0, NULL, N'CN0006    ', 150)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1007 ', 26, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2000, 0, NULL, N'CN0007    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1008 ', 23, 5, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2000, 3, NULL, N'CN0008    ', 300)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1009 ', 26, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0009    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1010 ', 23, 5, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2600, 1, NULL, N'CN0010    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1011 ', 24, 3, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2300, 1, NULL, N'CN0011    ', 900)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1012 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2100, 0, NULL, N'CN0012    ', 650)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1013 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2000, 0, NULL, N'CN0013    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1014 ', 22, 4, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1800, 3, NULL, N'CN0014    ', 800)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1015 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2100, 0, NULL, N'CN0015    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1016 ', 24, 2, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2200, 1, NULL, N'CN0016    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1017 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0017    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1018 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2900, 0, NULL, N'CN0018    ', 850)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1019 ', 25, 1, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 2000, 0, NULL, N'CN0019    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN1021 ', 26, 0, CAST(N'2023-08-29T00:00:00.000' AS DateTime), 1700, 0, NULL, N'CN0020    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2001 ', 21, 7, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2300, 2, NULL, N'CN0001    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2002 ', 22, 7, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2200, 2, NULL, N'CN0002    ', 500)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2003 ', 26, 2, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2100, 1, NULL, N'CN0003    ', 300)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2004 ', 26, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0004    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2005 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2700, 0, NULL, N'CN0005    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2006 ', 25, 3, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2300, 0, NULL, N'CN0006    ', 550)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2007 ', 24, 4, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2000, 2, NULL, N'CN0007    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2008 ', 23, 5, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2000, 3, NULL, N'CN0008    ', 300)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2009 ', 26, 2, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0009    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2010 ', 23, 5, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2600, 2, NULL, N'CN0010    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2011 ', 23, 4, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2300, 2, NULL, N'CN0011    ', 900)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2012 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0012    ', 650)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2013 ', 24, 2, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2700, 1, NULL, N'CN0013    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2014 ', 22, 4, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1800, 3, NULL, N'CN0014    ', 800)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2015 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2100, 0, NULL, N'CN0015    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2016 ', 23, 3, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 1800, 3, NULL, N'CN0016    ', 750)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2017 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2200, 0, NULL, N'CN0017    ', 600)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2018 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2500, 0, NULL, N'CN0018    ', 850)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2019 ', 25, 1, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 3000, 0, NULL, N'CN0019    ', 700)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN2020 ', 26, 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), 2600, 0, NULL, N'CN0020    ', 400)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3001 ', 14, 5, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 829, 0, NULL, N'CN0001    ', 200)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3002 ', 11, 4, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 850, 1, NULL, N'CN0002    ', 120)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3003 ', 11, 8, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 720, 0, NULL, N'CN0003    ', 90)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3004 ', 9, 4, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 900, 2, NULL, N'CN0004    ', 70)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3005 ', 11, 0, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0005    ', 90)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3006 ', 11, 3, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 570, 0, NULL, N'CN0006    ', 150)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3007 ', 10, 9, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 700, 1, NULL, N'CN0007    ', 200)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3008 ', 11, 3, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0008    ', 300)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3009 ', 8, 11, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 600, 0, NULL, N'CN0009    ', 70)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3010 ', 8, 6, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 600, 2, NULL, N'CN0010    ', 75)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3011 ', 11, 4, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0011    ', 90)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3012 ', 10, 1, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0012    ', 65)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3013 ', 10, 1, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 700, 1, NULL, N'CN0013    ', 120)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3014 ', 11, 0, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 800, 0, NULL, N'CN0014    ', 80)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3015 ', 10, 1, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 410, 0, NULL, N'CN0015    ', 60)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3016 ', 8, 3, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 800, 3, NULL, N'CN0016    ', 0)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3017 ', 10, 1, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 700, 0, NULL, N'CN0017    ', 60)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3018 ', 11, 0, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 500, 0, NULL, N'CN0018    ', 85)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3019 ', 10, 1, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 300, 0, NULL, N'CN0019    ', 70)
INSERT [dbo].[BangChamCongCongNhan] ([maBangChamCongCN], [soNgayLamViec], [soNgayNghi], [ngayChamCong], [soLuongHangLamDuoc], [coPhep], [soGioTangCa], [maCN], [soSPLamDuocTrongGioTangCa]) VALUES (N'MCCCN3020 ', 11, 0, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 900, 0, NULL, N'CN0020    ', 0)
GO
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0001 ', 24, 4, 0, 15, N'NV0001    ', CAST(N'2023-08-15T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0002 ', 20, 6, 2, 12, N'NV0002    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0003 ', 24, 4, 1, 18, N'NV0003    ', CAST(N'2023-08-15T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0010 ', 21, 5, 1, 14, N'NV0010    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0011 ', 24, 2, 0, 20, N'NV0011    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0012 ', 22, 4, 0, 16, N'NV0012    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0061 ', 25, 1, 0, 22, N'NV0061    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0062 ', 20, 6, 2, 12, N'NV0062    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0063 ', 23, 3, 1, 18, N'NV0063    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0064 ', 21, 5, 1, 14, N'NV0064    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0065 ', 22, 4, 1, 5.5, N'NV0065    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0066 ', 20, 6, 1, 6, N'NV0066    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0067 ', 21, 2, 1, 4.5, N'NV0067    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0068 ', 26, 0, 0, 5, N'NV0068    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0069 ', 26, 0, 0, 4, N'NV0069    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV0070 ', 26, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1001 ', 26, 0, 0, 40, N'NV0001    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1002 ', 24, 2, 2, 30, N'NV0002    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1003 ', 23, 3, 1, 18, N'NV0003    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1010 ', 26, 0, 0, 30, N'NV0010    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1011 ', 24, 2, 0, 20, N'NV0011    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1012 ', 22, 4, 0, 16, N'NV0012    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1061 ', 25, 1, 0, 22, N'NV0061    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1062 ', 20, 6, 2, 12, N'NV0062    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1063 ', 26, 0, 0, 18, N'NV0063    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1064 ', 25, 1, 1, 40, N'NV0064    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1065 ', 22, 4, 1, 5.5, N'NV0065    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1066 ', 20, 6, 1, 6, N'NV0066    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1067 ', 21, 2, 1, 4.5, N'NV0067    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1068 ', 26, 0, 0, 5, N'NV0068    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV1069 ', 26, 0, 0, 4, N'NV0069    ', CAST(N'2023-09-29T00:00:00.000' AS DateTime))
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
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2101 ', 13, 2, 0, 43, N'NV0001    ', CAST(N'2023-11-14T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2102 ', 11, 0, 0, 30, N'NV0002    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2103 ', 12, 3, 0, 18, N'NV0003    ', CAST(N'2023-11-14T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2110 ', 8, 3, 2, 30, N'NV0010    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2111 ', 11, 0, 0, 20, N'NV0011    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2112 ', 10, 1, 0, 16, N'NV0012    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2161 ', 10, 1, 1, 22, N'NV0061    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2162 ', 11, 0, 0, 12, N'NV0062    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2163 ', 10, 1, 0, 18, N'NV0063    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2164 ', 11, 0, 0, 40, N'NV0064    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2165 ', 11, 0, 0, 5.5, N'NV0065    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2166 ', 10, 1, 1, 6, N'NV0066    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2167 ', 10, 1, 1, 4.5, N'NV0067    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2168 ', 11, 0, 0, 5, N'NV0068    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2169 ', 11, 0, 0, 4, N'NV0069    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
INSERT [dbo].[BangChamCongNhanVien] ([maBangChamCongNV], [soNgayLamViec], [soNgayNghi], [coPhep], [soGioTangCa], [maNhanVien], [ngayChamCong]) VALUES (N'MCCNV2170 ', 11, 0, 0, 3.5, N'NV0070    ', CAST(N'2023-11-10T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0001  ', CAST(N'2023-10-29' AS Date), 10000000.0000, 3000000, 0.0000, 4500000, 13310000, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0002  ', CAST(N'2023-08-29' AS Date), 9350000.0000, 3000000, 0.0000, 4500000, 11910000, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0003  ', CAST(N'2023-09-29' AS Date), 11500000.0000, 3000000, 0.0000, 4500000, 11810000, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0004  ', CAST(N'2023-11-15' AS Date), 3895000.0000, 3000000, 0.0000, 4500000, 13210000, N'CN0001    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0017  ', CAST(N'2023-10-29' AS Date), 17550000.0000, 3100000, 0.0000, 4500000, 17390000, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0018  ', CAST(N'2023-08-29' AS Date), 19500000.0000, 3100000, 0.0000, 4500000, 12710000, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0019  ', CAST(N'2023-09-29' AS Date), 21450000.0000, 3100000, 0.0000, 4500000, 12710000, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0020  ', CAST(N'2023-11-15' AS Date), 7800000.0000, 3100000, 0.0000, 4500000, 14210000, N'CN0002    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0025  ', CAST(N'2023-10-29' AS Date), 20790000.0000, 3200000, 0.0000, 4500000, 13230000, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0026  ', CAST(N'2023-08-29' AS Date), 20790000.0000, 3200000, 0.0000, 4500000, 10590000, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0027  ', CAST(N'2023-09-29' AS Date), 20790000.0000, 3200000, 0.0000, 4500000, 9370000, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0028  ', CAST(N'2023-11-15' AS Date), 7128000.0000, 3200000, 0.0000, 4500000, 12310000, N'CN0003    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0029  ', CAST(N'2023-10-29' AS Date), 29040000.0000, 3300000, 0.0000, 4500000, 16309999.999999996, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0030  ', CAST(N'2023-08-29' AS Date), 29040000.0000, 3300000, 0.0000, 4500000, 9109999.9999999963, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0031  ', CAST(N'2023-09-29' AS Date), 29040000.0000, 3300000, 0.0000, 4500000, 16309999.999999996, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0032  ', CAST(N'2023-11-15' AS Date), 11880000.0000, 3300000, 0.0000, 4500000, 16209999.999999996, N'CN0004    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0037  ', CAST(N'2023-10-29' AS Date), 18000000.0000, 3450000, 0.0000, 4500000, 16010000, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0038  ', CAST(N'2023-08-29' AS Date), 18750000.0000, 3450000, 0.0000, 4500000, 7610000, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0039  ', CAST(N'2023-09-29' AS Date), 17250000.0000, 3450000, 0.0000, 4500000, 12310000, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0040  ', CAST(N'2023-11-15' AS Date), 4275000.0000, 3450000, 0.0000, 4500000, 15810000, N'CN0006    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0041  ', CAST(N'2023-10-29' AS Date), 18000000.0000, 3550000, 0.0000, 4500000, 14310000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0042  ', CAST(N'2023-08-29' AS Date), 18000000.0000, 3550000, 0.0000, 4500000, 14410000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0043  ', CAST(N'2023-09-29' AS Date), 18000000.0000, 3550000, 0.0000, 4500000, 14410000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0044  ', CAST(N'2023-11-15' AS Date), 6300000.0000, 3550000, 0.0000, 4500000, 14110000, N'CN0007    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0049  ', CAST(N'2023-10-29' AS Date), 25740000.0000, 3600000, 0.0000, 4500000, 18589999.999999996, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0050  ', CAST(N'2023-08-29' AS Date), 28600000.0000, 3600000, 0.0000, 4500000, 10789999.999999996, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0051  ', CAST(N'2023-09-29' AS Date), 28600000.0000, 3600000, 0.0000, 4500000, 10789999.999999996, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0052  ', CAST(N'2023-11-15' AS Date), 11440000.0000, 3600000, 0.0000, 4500000, 15510000, N'CN0008    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0057  ', CAST(N'2023-10-29' AS Date), 10500000.0000, 3700000, 0.0000, 4500000, 13510000, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0058  ', CAST(N'2023-08-29' AS Date), 11000000.0000, 3700000, 0.0000, 4500000, 13510000, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0059  ', CAST(N'2023-09-29' AS Date), 11000000.0000, 3700000, 0.0000, 4500000, 13510000, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0060  ', CAST(N'2023-11-15' AS Date), 3000000.0000, 3700000, 0.0000, 4500000, 13310000, N'CN0009    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0065  ', CAST(N'2023-10-29' AS Date), 18150000.0000, 3800000, 0.0000, 4500000, 16410000, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0066  ', CAST(N'2023-08-29' AS Date), 21450000.0000, 3800000, 0.0000, 4500000, 16210000, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0067  ', CAST(N'2023-09-29' AS Date), 21450000.0000, 3800000, 0.0000, 4500000, 16310000, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0068  ', CAST(N'2023-11-15' AS Date), 4950000.0000, 3800000, 0.0000, 4500000, 18010000, N'CN0010    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0073  ', CAST(N'2023-10-29' AS Date), 28980000.0000, 3900000, 0.0000, 4500000, 21730000, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0074  ', CAST(N'2023-08-29' AS Date), 28980000.0000, 3900000, 0.0000, 4500000, 21730000, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0075  ', CAST(N'2023-09-29' AS Date), 28980000.0000, 3900000, 0.0000, 4500000, 21730000, N'CN0011    ')
INSERT [dbo].[BangluongCongNhan] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [MaCN]) VALUES (N'BLCN0076  ', CAST(N'2023-11-15' AS Date), 8820000.0000, 3900000, 0.0000, 4500000, 21630000, N'CN0011    ')
GO
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0001  ', CAST(N'2023-08-15' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 14706538.46153846, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0002  ', CAST(N'2023-09-29' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 20028076.92307692, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0003  ', CAST(N'2023-10-29' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 19305769.230769228, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0004  ', CAST(N'2023-11-14' AS Date), 14880000.0000, 3500000, 0.0000, 4500000, 14706538.46153846, 8000000.0000, N'NV0001    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0005  ', CAST(N'2023-11-10' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 12020000, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0006  ', CAST(N'2023-10-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 21380000, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0007  ', CAST(N'2023-09-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 21380000, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0008  ', CAST(N'2023-08-29' AS Date), 18720000.0000, 4000000, 0.0000, 4500000, 14660000, 9000000.0000, N'NV0002    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0009  ', CAST(N'2023-08-15' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 17737500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0010  ', CAST(N'2023-09-29' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 17212500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0011  ', CAST(N'2023-10-29' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 17212500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0012  ', CAST(N'2023-11-14' AS Date), 17550000.0000, 3000000, 0.0000, 4500000, 17737500, 7500000.0000, N'NV0003    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0013  ', CAST(N'2023-11-10' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 11105000, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0014  ', CAST(N'2023-10-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 23255000, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0015  ', CAST(N'2023-09-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 25835000, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0016  ', CAST(N'2023-08-29' AS Date), 21060000.0000, 4000000, 0.0000, 4500000, 17945000, 9000000.0000, N'NV0010    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0017  ', CAST(N'2023-08-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 23246500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0018  ', CAST(N'2023-09-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 23246500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0019  ', CAST(N'2023-10-29' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 23246500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0020  ', CAST(N'2023-11-10' AS Date), 22230000.0000, 4500000, 0.0000, 4500000, 12431500, 9500000.0000, N'NV0011    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0021  ', CAST(N'2023-11-10' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 10867000, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0022  ', CAST(N'2023-10-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 25129000, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0023  ', CAST(N'2023-09-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 21001000, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0024  ', CAST(N'2023-08-29' AS Date), 22932000.0000, 4700000, 0.0000, 4500000, 21001000, 9800000.0000, N'NV0012    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0025  ', CAST(N'2023-08-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 30374500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0026  ', CAST(N'2023-09-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 30374500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0027  ', CAST(N'2023-10-29' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 30374500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0028  ', CAST(N'2023-11-10' AS Date), 28080000.0000, 5000000, 0.0000, 4500000, 14324500, 12000000.0000, N'NV0061    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0029  ', CAST(N'2023-11-10' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 12405038.461538464, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0030  ', CAST(N'2023-10-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 27953115.384615388, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0031  ', CAST(N'2023-09-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 21133884.61538462, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0032  ', CAST(N'2023-08-29' AS Date), 26950000.0000, 4800000, 0.0000, 4500000, 21133884.61538462, 11000000.0000, N'NV0062    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0033  ', CAST(N'2023-08-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 26193769.230769232, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0034  ', CAST(N'2023-09-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 29595307.692307692, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0035  ', CAST(N'2023-10-29' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 27377615.384615384, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0036  ', CAST(N'2023-11-10' AS Date), 26880000.0000, 4700000, 0.0000, 4500000, 12903769.23076923, 10500000.0000, N'NV0063    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0037  ', CAST(N'2023-11-10' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 25293000, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0038  ', CAST(N'2023-10-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 43983000, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0039  ', CAST(N'2023-09-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 43983000, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0040  ', CAST(N'2023-08-29' AS Date), 34710000.0000, 5200000, 0.0000, 4500000, 29365500, 13000000.0000, N'NV0064    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0041  ', CAST(N'2023-08-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 25899759.615384612, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0042  ', CAST(N'2023-09-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 25899759.615384612, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0043  ', CAST(N'2023-10-29' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 23140528.84615384, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0044  ', CAST(N'2023-11-10' AS Date), 31970000.0000, 5000000, 0.0000, 4500000, 12823990.384615384, 11500000.0000, N'NV0065    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0045  ', CAST(N'2023-11-10' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 13402865.384615386, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0046  ', CAST(N'2023-10-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 26697096.153846156, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0047  ', CAST(N'2023-09-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 26547096.153846156, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0048  ', CAST(N'2023-08-29' AS Date), 36125000.0000, 5100000, 0.0000, 4500000, 26547096.153846156, 12500000.0000, N'NV0066    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0049  ', CAST(N'2023-08-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 27539836.53846154, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0050  ', CAST(N'2023-09-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 27539836.53846154, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0051  ', CAST(N'2023-10-29' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 33151682.692307696, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0052  ', CAST(N'2023-11-10' AS Date), 35502000.0000, 5050000, 0.0000, 4500000, 12669759.615384614, 12200000.0000, N'NV0067    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0053  ', CAST(N'2023-11-10' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 13959923.076923076, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0054  ', CAST(N'2023-10-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 34341461.538461536, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0055  ', CAST(N'2023-09-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 34341461.538461536, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0056  ', CAST(N'2023-08-29' AS Date), 35328000.0000, 5150000, 0.0000, 4500000, 34341461.538461536, 12800000.0000, N'NV0068    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0057  ', CAST(N'2023-08-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 34213961.538461536, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0058  ', CAST(N'2023-09-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 34213961.538461536, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0059  ', CAST(N'2023-10-29' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 34213961.538461536, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0060  ', CAST(N'2023-11-10' AS Date), 35775000.0000, 5300000, 0.0000, 4500000, 13574538.461538462, 13500000.0000, N'NV0069    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0061  ', CAST(N'2023-11-10' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 11228634.615384614, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0062  ', CAST(N'2023-10-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 28520173.076923076, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0063  ', CAST(N'2023-09-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 28520173.076923076, 11800000.0000, N'NV0070    ')
INSERT [dbo].[BangluongNhanVien] ([maBangLuong], [thoiGian], [luongThang], [phuCap], [tienThuong], [baoHiemXH], [thucLanh], [luongCoBan], [MaNV]) VALUES (N'BLNV0064  ', CAST(N'2023-08-29' AS Date), 29972000.0000, 4900000, 0.0000, 4500000, 28520173.076923076, 11800000.0000, N'NV0070    ')
GO
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD001     ', N'Cắt vải', CAST(N'2023-11-01T00:00:00.000' AS DateTime), 500, 5000.0000, 1, N'SP001     ', CAST(N'2023-11-15T00:00:00.000' AS DateTime))
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD002     ', N'May áo', CAST(N'2023-11-05T00:00:00.000' AS DateTime), 480, 5500.0000, 1, N'SP001     ', CAST(N'2023-11-23T00:00:00.000' AS DateTime))
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD003     ', N'May cổ áo', CAST(N'2023-11-10T00:00:00.000' AS DateTime), 450, 6000.0000, 1, N'SP001     ', CAST(N'2023-11-21T00:00:00.000' AS DateTime))
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD004     ', N'In hình', CAST(N'2023-11-15T00:00:00.000' AS DateTime), 420, 6500.0000, 1, N'SP001     ', CAST(N'2023-11-21T00:00:00.000' AS DateTime))
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD005     ', N'Kiểm tra chất lượng', CAST(N'2023-11-20T00:00:00.000' AS DateTime), 400, 7000.0000, 1, N'SP001     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD006     ', N'Cắt vải', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 450, 5200.0000, 1, N'SP002     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD007     ', N'May áo', CAST(N'2023-11-06T00:00:00.000' AS DateTime), 430, 5900.0000, 1, N'SP002     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD008     ', N'May cổ áo', CAST(N'2023-11-11T00:00:00.000' AS DateTime), 400, 6400.0000, 1, N'SP002     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD009     ', N'In hình', CAST(N'2023-11-16T00:00:00.000' AS DateTime), 380, 6900.0000, 1, N'SP002     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD010     ', N'Cắt vải', CAST(N'2023-11-02T00:00:00.000' AS DateTime), 500, 5400.0000, 1, N'SP003     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD011     ', N'May quần', CAST(N'2023-11-07T00:00:00.000' AS DateTime), 480, 6100.0000, 1, N'SP003     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD012     ', N'May túi', CAST(N'2023-11-12T00:00:00.000' AS DateTime), 460, 6800.0000, 1, N'SP003     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD013     ', N'May đáy quần', CAST(N'2023-11-17T00:00:00.000' AS DateTime), 440, 7500.0000, 1, N'SP003     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD014     ', N'Đính nút', CAST(N'2023-11-22T00:00:00.000' AS DateTime), 420, 8200.0000, 1, N'SP003     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD015     ', N'Kiểm tra chất lượng', CAST(N'2023-11-27T00:00:00.000' AS DateTime), 400, 8900.0000, 1, N'SP003     ', NULL)
INSERT [dbo].[CongDoanSanPham] ([maCongDoan], [tenCongDoan], [ngayBatDau], [soLuongSanPham], [donGia], [trangThai], [maSP], [ngayChiaCongDoan]) VALUES (N'CD016     ', N'Áo mưa', CAST(N'2023-11-01T00:00:00.000' AS DateTime), 300, 2000.0000, 1, N'SP002     ', CAST(N'2023-11-15T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0001    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn An', 1, N'123 Le loi, Quận 9, Thành Phố HCM', CAST(N'2022-01-01T00:00:00.000' AS DateTime), 1, N'0123456781', N'Xưởng 1', 3000000, N'Vắt Sổ', N'link_hinh_anh1.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0002    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Binh', 0, N'456 Huynh Khuong An, Quận GV, Thành Phố HCM', CAST(N'2022-02-01T00:00:00.000' AS DateTime), 1, N'0123456782', N'Xưởng 2', 3100000, N'Tay Áo', N'link_hinh_anh2.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0003    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Cao', 1, N'789 Đường GHI, Quận 8, Thành Phố HCM', CAST(N'2022-03-01T00:00:00.000' AS DateTime), 1, N'0123456783', N'Xưởng 1', 3200000, N'Cổ Áo', N'link_hinh_anh3.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0004    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Duy', 0, N'101 Đường Tôn duc thang, Quận 3, Thành Phố HCM', CAST(N'2022-04-01T00:00:00.000' AS DateTime), 1, N'0123456784', N'Xưởng 2', 3300000, N'Thân Áo', N'link_hinh_anh4.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0005    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Em', 1, N'202 Đường Le Lai, Quận GV, Thành Phố HCM', CAST(N'2022-05-01T00:00:00.000' AS DateTime), 1, N'0123456785', N'Xưởng 1', 3400000, N'Kiểm Tra', N'link_hinh_anh5.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0006    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Phat', 1, N'303 Đường VWX, Quận YZA, Thành Phố HCM', CAST(N'2022-06-01T00:00:00.000' AS DateTime), 1, N'0123456786', N'Xưởng 2', 3450000, N'Cắt Vải', N'link_hinh_anh6.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0007    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Gia', 0, N'404 Đường BCD, Quận EFG, Thành Phố HCM', CAST(N'2022-07-01T00:00:00.000' AS DateTime), 1, N'0123456787', N'Xưởng 1', 3550000, N'Làm Mẫu', N'link_hinh_anh7.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0008    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Hi', 1, N'505 Đường HIJ, Quận KLM, Thành Phố HCM', CAST(N'2022-08-01T00:00:00.000' AS DateTime), 1, N'0123456788', N'Xưởng 2', 3600000, N'Vắt Sổ', N'link_hinh_anh8.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0009    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Ing', 0, N'606 Đường MNO, Quận PQR, Thành Phố HCM', CAST(N'2022-09-01T00:00:00.000' AS DateTime), 1, N'0123456789', N'Xưởng 1', 3700000, N'Tay Áo', N'link_hinh_anh9.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0010    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Giang', 1, N'707 Đường STU, Quận VWX, Thành Phố HCM', CAST(N'2022-10-01T00:00:00.000' AS DateTime), 1, N'0123456790', N'Xưởng 2', 3800000, N'Cổ Áo', N'link_hinh_anh10.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0011    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Kkhang', 0, N'808 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2022-11-01T00:00:00.000' AS DateTime), 1, N'0123456791', N'Xưởng 1', 3900000, N'Thân Áo', N'link_hinh_anh11.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0012    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Le', 1, N'909 Đường EFG, Quận HIJ, Thành Phố HCM', CAST(N'2022-12-01T00:00:00.000' AS DateTime), 1, N'0123456792', N'Xưởng 2', 3950000, N'Kiểm Tra', N'link_hinh_anh12.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0013    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị My', 1, N'1010 Đường KLM, Quận NOP, Thành Phố HCM', CAST(N'2023-01-01T00:00:00.000' AS DateTime), 1, N'0123456793', N'Xưởng 1', 3000000, N'Cắt Vải', N'link_hinh_anh13.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0014    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Na', 1, N'1111 Đường PQR, Quận STU, Thành Phố HCM', CAST(N'2023-02-01T00:00:00.000' AS DateTime), 1, N'0123456794', N'Xưởng 2', 3100000, N'Làm Mẫu', N'link_hinh_anh14.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0015    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Ong', 0, N'1212 Đường VWX, Quận YZA, Thành Phố HCM', CAST(N'2023-03-01T00:00:00.000' AS DateTime), 1, N'0123456795', N'Xưởng 1', 3200000, N'Vắt Sổ', N'link_hinh_anh15.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0016    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Phu', 1, N'1313 Đường BCD, Quận EFG, Thành Phố HCM', CAST(N'2023-04-01T00:00:00.000' AS DateTime), 1, N'0123456796', N'Xưởng 2', 3300000, N'Tay Áo', N'link_hinh_anh16.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0017    ', 0, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Quy', 0, N'1414 Đường HIJ, Quận KLM, Thành Phố HCM', CAST(N'2023-05-01T00:00:00.000' AS DateTime), 1, N'0123456797', N'Xưởng 1', 3400000, N'Cổ Áo', N'link_hinh_anh17.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0018    ', 0.5, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Rê', 1, N'1515 Đường NOP, Quận PQR, Thành Phố HCM', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 1, N'0123456798', N'Xưởng 2', 3500000, N'Thân Áo', N'link_hinh_anh18.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0019    ', 0.8, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Thị Su', 0, N'1616 Đường STU, Quận VWX, Thành Phố HCM', CAST(N'2023-07-01T00:00:00.000' AS DateTime), 1, N'0123456799', N'Xưởng 1', 3600000, N'Kiểm Tra', N'link_hinh_anh19.jpg')
INSERT [dbo].[CongNhan] ([maCongNhan], [trinhDoChuyenMon], [ngaySinh], [ten], [gioiTinh], [diaChi], [ngayThamGia], [trangThai], [sDT], [xuong], [luongPhuCap], [chuyenMon], [hinhanhcn]) VALUES (N'CN0020    ', 1.2, CAST(N'1997-01-01T00:00:00.000' AS DateTime), N'Văn Thinh', 1, N'1717 Đường YZA, Quận BCD, Thành Phố HCM', CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'0123456700', N'Xưởng 2', 3700000, N'Cắt Vải', N'link_hinh_anh20.jpg')
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
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (51, N'PCCD0001  ', N'CD001     ', N'CN0001    ', CAST(N'2023-10-21' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (50, N'PCCD0002  ', N'CD001     ', N'CN0002    ', CAST(N'2023-10-22' AS Date), N'SP002     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (70, N'PCCD0003  ', N'CD001     ', N'CN0003    ', CAST(N'2023-10-22' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (60, N'PCCD0006  ', N'CD001     ', N'CN0006    ', CAST(N'2023-10-22' AS Date), N'SP004     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (40, N'PCCD0007  ', N'CD001     ', N'CN0007    ', CAST(N'2023-10-22' AS Date), N'SP003     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (30, N'PCCD0008  ', N'CD001     ', N'CN0008    ', CAST(N'2023-10-22' AS Date), N'SP006     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (30, N'PCCD0009  ', N'CD001     ', N'CN0009    ', CAST(N'2023-10-22' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (32, N'PCCD0010  ', N'CD004     ', N'CN0010    ', CAST(N'2023-10-22' AS Date), N'SP001     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (120, N'PCCD3180  ', N'CD005     ', N'CN0011    ', CAST(N'2023-11-14' AS Date), N'SP004     ')
INSERT [dbo].[PhanCongCongDoan] ([soLuongCongDoanPhanCong], [maPCCD], [maCD], [maCN], [ngayBatDau], [maSP]) VALUES (120, N'PCCD8405  ', N'CD003     ', N'CN0004    ', CAST(N'2023-11-13' AS Date), N'SP002     ')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP001     ', N'Áo Polo Nam', 5, 500)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP002     ', N'Áo Sơ Mi Nữ', 4, 450)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP003     ', N'Quần Jean Nam', 6, 550)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP004     ', N'Quần Legging Nữ', 5, 480)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP005     ', N'Áo Thun Trơn Unisex', 6, 600)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP006     ', N'Áo Khoác Nam', 4, 420)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP007     ', N'Quần Shorts Nữ', 6, 700)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP008     ', N'Quần Âu Nam', 3, 460)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP009     ', N'Áo Len Nữ', 6, 430)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP010     ', N'Quần Jogger Nam', 5, 480)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP011     ', N'Đầm', 4, 200)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongCongDoan], [soLuong]) VALUES (N'SP012     ', N'Khang', 2, 100)
GO
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'KT001          ', N'KT001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'QL001          ', N'QL001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'TP001          ', N'TP001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'XT001          ', N'XT001')
GO
ALTER TABLE [dbo].[BangChamCongCongNhan]  WITH CHECK ADD FOREIGN KEY([maCN])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_BangChamCongNhanVien_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
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
ALTER TABLE [dbo].[CongDoanSanPham]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[PhanCongCongDoan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongDoan_CongDoanSanPham] FOREIGN KEY([maCD])
REFERENCES [dbo].[CongDoanSanPham] ([maCongDoan])
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
