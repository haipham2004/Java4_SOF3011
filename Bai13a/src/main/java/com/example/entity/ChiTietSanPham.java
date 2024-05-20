package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Builder
@ToString
@Entity
@Table(name = "chiTietSanPham")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCTSP")
    private int idCTSP;
    @ManyToOne
    @JoinColumn(name = "idThuongHieu")
    private ThuongHieu thuongHieu;
    @Column(name = "soLuongTon")
    private int soLuongTon;
    @Column(name = "donGia")
    private double donGia;
    @Column(name = "ghiChu")
    private String ghiChu;
//    @ManyToOne
//    @Column(name="idSanPham")
//    private int idSanPham;
}
