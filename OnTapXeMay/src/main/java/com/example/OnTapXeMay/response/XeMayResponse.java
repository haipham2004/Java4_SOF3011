package com.example.OnTapXeMay.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class XeMayResponse {

    private int id;

    private String ma;

    private String ten;

    private String moTa;

    private int soLuong;

    private String tenLoaiXeMay;

    private int idloaiXeMay;
}
