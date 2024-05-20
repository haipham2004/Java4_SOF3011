package com.example.OnTapDTO1s.response;

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
public class BanResponse {

    private int id;

    private String ma;

    private String ten;

    private String soThich;

    private boolean gioiTinh;

    private String maMoiQuanHe;

    private String tenMoiQuanHe;
}
