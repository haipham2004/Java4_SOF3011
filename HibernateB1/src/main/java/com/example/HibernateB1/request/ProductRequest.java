package com.example.HibernateB1.request;

import com.example.HibernateB1.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequest {
    private int id;
    private String productCode;

    private String productName;

    private long price;

    private String description;

    private Category category;

}
