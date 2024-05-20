package com.example.OnTapXeMay.request;

import com.example.OnTapXeMay.entity.LoaiXeMay;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class XeMayRequest {

    private int id;

    private String ma;

    private String ten;

    private String moTa;

    private int soLuong;

    private int idLoaiXeMay;
}
