package com.example.HibernateB1.service;

import com.example.HibernateB1.entity.Product;
import com.example.HibernateB1.repository.ProductRepository;
import com.example.HibernateB1.request.ProductRequest;

public class ProductServiceImp implements ProductService{
    ProductRepository repo=new ProductRepository();

    @Override
    public boolean add2(ProductRequest prd) {
        Product prds=new Product();
        prds.setProductCode(prd.getProductCode());
        prds.setProductName(prd.getProductName());
        prds.setPrice(prd.getPrice());
        prds.setDescription(prd.getDescription());
        prds.setCategory(prd.getCategory());
        return repo.addProduct(prds);
    }

    public boolean update2(ProductRequest prd) {
        Product prds=new Product();
        prds.setId(prd.getId());
        prds.setProductCode(prd.getProductCode());
        prds.setProductName(prd.getProductName());
        prds.setPrice(prd.getPrice());
        prds.setDescription(prd.getDescription());
        prds.setCategory(prd.getCategory());
        return repo.updateProduct(prds);
    }
//
//    public static void main(String[] args) {
//        ProductServiceImp imp=new ProductServiceImp();
//        Category category=new Category();
//        category.setId(1);
//        ProductRequest prdr=new ProductRequest("code2","name2s",9000,"Xe đẹp",category);
//        imp.add2(prdr);
//    }
}
