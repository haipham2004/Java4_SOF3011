package com.example.OnTapDTO1s.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class BanRequest {

    private int id;

    private String ma;

    private String ten;

    private String soThich;

    private boolean gioiTinh;

    private int idMoiQuanHe;
}
