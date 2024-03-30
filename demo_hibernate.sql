Create
database Demo_Hibernate
go 
use Demo_Hibernate
go

Create table SanPham
(
    id   int Identity(1,1) primary key,
    ma   varchar(50),
    ten  varchar(50),
    loai varchar(50),
    gia  int
) Insert into SanPham Values('SP001','MSI','PC',12345678),
('SP002','DELL','Laptop',23456789),
('SP003','GIGA','Laptop',34567890)