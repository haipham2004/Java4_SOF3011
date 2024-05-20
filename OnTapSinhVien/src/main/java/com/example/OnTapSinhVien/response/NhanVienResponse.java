package com.example.OnTapSinhVien.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhanVienResponse {

    private int id;

    private String ma;

    private String ten;

    private String gioiTinh;

    private int idChucVu;

    private String tenChucVu;
}
