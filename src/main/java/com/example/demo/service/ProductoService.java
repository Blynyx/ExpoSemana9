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

    // ═══════════════════════════════
    // CREATE — ProductoControllerTest
    // ═══════════════════════════════
    public Producto crear(Producto producto) {
        // ROJO — activo por defecto
        return new Producto();

        // VERDE (F2) — sin repository ni adapter
        //Producto respuesta = new Producto();
        //respuesta.setId(1L);
        //respuesta.setNombre(producto.getNombre());
        //respuesta.setPrecio(producto.getPrecio());
        //respuesta.setStock(producto.getStock());
        //return respuesta;

        // REFACTOR (F3) — repository + adapter + H2
        //ProductoEntity entity = productoAdapter.toEntity(producto);
        //entity.setId(null);
        //ProductoEntity guardada = productoRepository.save(entity);
        //return productoAdapter.toModel(guardada);
    }

    // ═══════════════════════════════════
    // READ lista — ProductoControllerTest
    // ═══════════════════════════════════
    public List<Producto> listarTodos() {
        // ROJO
        return List.of();

        // VERDE (F2) — lista temporal fija (datos de data.sql)
        //Producto p1 = new Producto();
        //p1.setId(1L);
        //p1.setNombre("Camiseta algodón");
        //p1.setPrecio(new java.math.BigDecimal("19.99"));
        //p1.setStock(40);
        //Producto p2 = new Producto();
        //p2.setId(2L);
        //p2.setNombre("Pantalón vaquero");
        //p2.setPrecio(new java.math.BigDecimal("45.50"));
        //p2.setStock(15);
        //Producto p3 = new Producto();
        //p3.setId(3L);
        //p3.setNombre("Chaqueta de invierno");
        //p3.setPrecio(new java.math.BigDecimal("89.00"));
        //p3.setStock(8);
        //return List.of(p1, p2, p3);

        // REFACTOR (F3)
        //return productoRepository.findAll().stream()
        //        .map(productoAdapter::toModel)
        //        .toList();
    }

    // ═══════════════════════════════
    // UPDATE — ProductoControllerTest
    // ═══════════════════════════════
    public Optional<Producto> actualizar(Long id, Producto datos) {
        // ROJO
        return Optional.empty();

        // VERDE (F2) — respuesta temporal sin persistir
        //if (Long.valueOf(1L).equals(id)) {
        //    Producto p = new Producto();
        //    p.setId(1L);
        //    p.setNombre(datos.getNombre());
        //    p.setPrecio(datos.getPrecio());
        //    p.setStock(datos.getStock());
        //    return Optional.of(p);
        //}
        //return Optional.empty();

        // REFACTOR (F3)
        //Optional<ProductoEntity> existente = productoRepository.findById(id);
        //if (existente.isEmpty()) {
        //    return Optional.empty();
        //}
        //ProductoEntity entity = existente.get();
        //entity.setNombre(datos.getNombre());
        //entity.setPrecio(datos.getPrecio());
        //entity.setStock(datos.getStock());
        //ProductoEntity guardada = productoRepository.save(entity);
        //return Optional.of(productoAdapter.toModel(guardada));
    }

    // ═══════════════════════════════
    // DELETE — ProductoControllerTest
    // ═══════════════════════════════
    public boolean eliminar(Long id) {
        // ROJO
        return false;

        // VERDE (F2) — confirma borrado sin repository
        //return true;

        // REFACTOR (F3)
        //if (!productoRepository.existsById(id)) {
        //    return false;
        //}
        //productoRepository.deleteById(id);
        //return true;
    }
}
