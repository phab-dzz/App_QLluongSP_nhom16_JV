USE [master]
GO
/****** Object:  Database [QLLUONG]    Script Date: 10/21/2023 9:04:10 PM ******/
CREATE DATABASE [QLLUONG]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLLUONG', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\QLLUONG.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLLUONG_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\QLLUONG_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
	[coPhep] [bit] NULL,
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
	[coPhep] [bit] NULL,
	[soGioTangCa] [float] NULL,
	[maNhanVien] [char](10) NULL,
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
	[luongThang] [money] NULL,
	[phuCap] [float] NULL,
	[tienThuong] [money] NULL,
	[baoHiemXH] [float] NULL,
	[thucLanh] [float] NULL,
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
	[luongThang] [money] NULL,
	[phuCap] [float] NULL,
	[tienThuong] [money] NULL,
	[baoHiemXH] [float] NULL,
	[thucLanh] [float] NULL,
	[luongCoBan] [money] NULL,
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
	[maBangLuong] [char](10) NOT NULL,
	[maBangChamCongCN] [char](10) NULL,
	[maPhieuLuong] [char](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
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
	[maBangLuong] [char](10) NOT NULL,
	[maBangChamCongNV] [char](10) NULL,
	[maPhieuLuong] [char](10) NULL,
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
ALTER TABLE [dbo].[PhieuLuong]  WITH CHECK ADD FOREIGN KEY([maBangLuong])
REFERENCES [dbo].[BangluongNhanVien] ([maBangLuong])
GO
ALTER TABLE [dbo].[PhieuLuong]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
USE [master]
GO
ALTER DATABASE [QLLUONG] SET  READ_WRITE 
GO
