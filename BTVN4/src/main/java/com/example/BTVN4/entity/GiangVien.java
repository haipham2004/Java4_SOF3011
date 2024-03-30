package com.example.BTVN4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiangVien {

    public String ID;

    public String ma;

    public String ten;

    public int tuoi;

    public boolean gioiTinh;

    public String diaChi;


}
