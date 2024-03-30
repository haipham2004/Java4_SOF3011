package com.example.Bai4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class SinhVien {

    private String maSoSinhVien;

    private String ten;

    private int tuoi;

    private String diaChi;

    private boolean gioiTinh;


}
