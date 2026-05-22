package com.example.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.hamcrest.Matchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("🔴→🟢→🔧 CREATE: POST /productos debe guardar y devolver JSON")
    void crearProducto() throws Exception {
        String json = """
                {
                    "nombre": "Bufanda lana",
                    "precio": 15.00,
                    "stock": 20
                }
                """;

        mockMvc.perform(post("/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombre").value("Bufanda lana"))
                .andExpect(jsonPath("$.precio").value(15.00))
                .andExpect(jsonPath("$.stock").value(20));
    }

    @Test
    @DisplayName("READ lista: GET /productos debe devolver datos iniciales")
    void listarProductos() throws Exception {
        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", Matchers.hasSize(Matchers.greaterThanOrEqualTo(3))));
    }

    @Test
    @DisplayName("UPDATE: PUT /productos/{id}")
    void actualizarProducto() throws Exception {
        String json = """
                {
                    "nombre": "Camiseta promoción",
                    "precio": 14.99,
                    "stock": 50
                }
                """;

        mockMvc.perform(put("/productos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Camiseta promoción"))
                .andExpect(jsonPath("$.stock").value(50));
    }

    @Test
    @DisplayName("DELETE: DELETE /productos/{id}")
    void eliminarProducto() throws Exception {
        mockMvc.perform(delete("/productos/3"))
                .andExpect(status().isNoContent());
    }
}
