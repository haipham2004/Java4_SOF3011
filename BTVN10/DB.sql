CREATE DATABASE BTVNBuoi10;
go
USE BTVNBuoi10;
go
CREATE TABLE giang_vien (
	id BIGINT IDENTITY NOT NULL,
	mssv varchar(100) NULL ,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	que_quan nvarchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (id)
)
INSERT INTO giang_vien VALUES
('GV01',N'Tâm',20,0,N'Nghệ An'),
('GV02',N'Hải',19,0,N'Ninh Bình')
DROP TABLE giang_vien