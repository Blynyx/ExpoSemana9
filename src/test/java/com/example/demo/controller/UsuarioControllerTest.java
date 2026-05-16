package com.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("🔴→🟢→🔧 CREATE: POST /usuarios")
    void crearUsuario() throws Exception {
        String json = """
                {
                    "nombre": "María López",
                    "correo": "maria.lopez@ejemplo.com"
                }
                """;

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombre").value("María López"))
                .andExpect(jsonPath("$.correo").value("maria.lopez@ejemplo.com"));
    }

    @Test
    @DisplayName("READ lista: GET /usuarios")
    void listarUsuarios() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", Matchers.hasSize(Matchers.greaterThanOrEqualTo(2))));
    }

    @Test
    @DisplayName("UPDATE: PUT /usuarios/{id}")
    void actualizarUsuario() throws Exception {
        String json = """
                {
                    "nombre": "Ana Pérez Ruiz",
                    "correo": "ana.ruiz@ejemplo.com"
                }
                """;

        mockMvc.perform(put("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.correo").value("ana.ruiz@ejemplo.com"));
    }

    @Test
    @DisplayName("DELETE: DELETE /usuarios/{id}")
    void eliminarUsuario() throws Exception {
        String json = """
                {
                    "nombre": "Usuario temporal",
                    "correo": "temporal@ejemplo.com"
                }
                """;

        String respuesta = mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        JsonNode nodo = new ObjectMapper().readTree(respuesta);
        long nuevoId = nodo.get("id").asLong();

        mockMvc.perform(delete("/usuarios/" + nuevoId))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/usuarios/" + nuevoId))
                .andExpect(status().isNotFound());
    }
}
