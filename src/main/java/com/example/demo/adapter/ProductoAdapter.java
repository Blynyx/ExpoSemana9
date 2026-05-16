package com.example.demo.adapter;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoAdapter {

    public Producto toModel(ProductoEntity entity) {
        if (entity == null) {
            return null;
        }
        Producto model = new Producto();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setPrecio(entity.getPrecio());
        model.setStock(entity.getStock());
        return model;
    }

    public ProductoEntity toEntity(Producto model) {
        if (model == null) {
            return null;
        }
        ProductoEntity entity = new ProductoEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setPrecio(model.getPrecio());
        entity.setStock(model.getStock());
        return entity;
    }
}
