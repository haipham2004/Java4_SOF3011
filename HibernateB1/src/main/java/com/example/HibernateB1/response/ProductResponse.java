package com.example.HibernateB1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private long id;

    private String productCode;

    private String productName;

    private String categoryName;

    private String categoryCode;

    private float price;
}
