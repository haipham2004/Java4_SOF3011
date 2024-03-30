CREATE DATABASE BTVNBuoi11s;
go
USE BTVNBuoi11s;
go
CREATE TABLE GiangVien (
	id BIGINT IDENTITY NOT NULL,
	ma varchar(100) NULL,
	ten nvarchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	dia_chi nvarchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (id)
)

CREATE TABLE TaiKhoan (
	username varchar(100) NOT NULL,
	password varchar(100) NULL,
	CONSTRAINT tai_khoan_PK PRIMARY KEY (username)
)
INSERT INTO GiangVien VALUES 
('Ma02',N'Tâm',20,0,N'Nghệ An'),
('Ma01',N'Hải',20,1,N'Ninh Bình')
INSERT INTO TaiKhoan VALUES 
('Haipnph','Hoilamgia')
SELECT*FROM GiangVien
DROP TABLE GiangVien