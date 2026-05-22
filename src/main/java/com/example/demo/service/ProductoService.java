package com.example.demo.service;

import com.example.demo.adapter.ProductoAdapter;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoAdapter productoAdapter;

    public ProductoService(ProductoRepository productoRepository, ProductoAdapter productoAdapter) {
        this.productoRepository = productoRepository;
        this.productoAdapter = productoAdapter;
    }

    public Producto crear(Producto producto) {

        //ProductoEntity entity = productoAdapter.toEntity(producto); //F3
        //entity.setId(null); //F3
        //ProductoEntity guardada = productoRepository.save(entity); //F3
        //return productoAdapter.toModel(guardada); //F3

        Producto respuesta = new Producto();

        //respuesta.setId(1L); //F2
        //respuesta.setNombre(producto.getNombre()); //F2
        //respuesta.setPrecio(producto.getPrecio()); //F2
        //respuesta.setStock(producto.getStock()); //F2

        return respuesta;
    }

    public List<Producto> listarTodos() {

        //return productoRepository.findAll().stream() //F3
        //        .map(productoAdapter::toModel) //F3
        //        .toList(); //F3

        //Producto p1 = new Producto(); //F2
        //p1.setId(1L); //F2
        //p1.setNombre("Camiseta algodón"); //F2
        //p1.setPrecio(new java.math.BigDecimal("19.99")); //F2
        //p1.setStock(40); //F2
        //Producto p2 = new Producto(); //F2
        //p2.setId(2L); //F2
        //p2.setNombre("Pantalón vaquero"); //F2
        //p2.setPrecio(new java.math.BigDecimal("45.50")); //F2
        //p2.setStock(15); //F2
        //Producto p3 = new Producto(); //F2
        //p3.setId(3L); //F2
        //p3.setNombre("Chaqueta de invierno"); //F2
        //p3.setPrecio(new java.math.BigDecimal("89.00")); //F2
        //p3.setStock(8); //F2
        //return List.of(p1, p2, p3); //F2

        return List.of();
    }

    public Optional<Producto> actualizar(Long id, Producto datos) {

        //Optional<ProductoEntity> existente = productoRepository.findById(id); //F3
        //if (existente.isEmpty()) { //F3
        //    return Optional.empty(); //F3
        //} //F3
        //ProductoEntity entity = existente.get(); //F3
        //entity.setNombre(datos.getNombre()); //F3
        //entity.setPrecio(datos.getPrecio()); //F3
        //entity.setStock(datos.getStock()); //F3
        //ProductoEntity guardada = productoRepository.save(entity); //F3
        //return Optional.of(productoAdapter.toModel(guardada)); //F3

        //if (Long.valueOf(1L).equals(id)) { //F2
        //    Producto p = new Producto(); //F2
        //    p.setId(1L); //F2
        //    p.setNombre(datos.getNombre()); //F2
        //    p.setPrecio(datos.getPrecio()); //F2
        //    p.setStock(datos.getStock()); //F2
        //    return Optional.of(p); //F2
        //} //F2
        //return Optional.empty(); //F2

        return Optional.empty();
    }

    public boolean eliminar(Long id) {

        //if (!productoRepository.existsById(id)) { //F3
        //    return false; //F3
        //} //F3
        //productoRepository.deleteById(id); //F3
        //return true; //F3

        //return true; //F2

        return false;
    }
}
