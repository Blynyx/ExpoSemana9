package com.example.demo.service;

import com.example.demo.adapter.UsuarioAdapter;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioAdapter usuarioAdapter;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioAdapter usuarioAdapter) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioAdapter = usuarioAdapter;
    }

    // ══════════════════════════════
    // CREATE — UsuarioControllerTest
    // ══════════════════════════════
    public Usuario crear(Usuario usuario) {
        // ROJO
        return new Usuario();

        // VERDE (F2) — sin repository ni adapter; id temporal para $.id
        //Usuario respuesta = new Usuario();
        //respuesta.setId(99L);
        //respuesta.setNombre(usuario.getNombre());
        //respuesta.setCorreo(usuario.getCorreo());
        //return respuesta;

        // REFACTOR (F3)
        //UsuarioEntity entity = usuarioAdapter.toEntity(usuario);
        //entity.setId(null);
        //UsuarioEntity guardada = usuarioRepository.save(entity);
        //return usuarioAdapter.toModel(guardada);
    }

    // ══════════════════════════════════
    // READ lista — UsuarioControllerTest
    // ══════════════════════════════════
    public List<Usuario> listarTodos() {
        // ROJO
        return List.of();

        // VERDE (F2) — lista temporal fija (data.sql)
        //Usuario u1 = new Usuario();
        //u1.setId(1L);
        //u1.setNombre("Ana Pérez");
        //u1.setCorreo("ana.perez@ejemplo.com");
        //Usuario u2 = new Usuario();
        //u2.setId(2L);
        //u2.setNombre("Luis García");
        //u2.setCorreo("luis.garcia@ejemplo.com");
        //return List.of(u1, u2);

        // REFACTOR (F3)
        //return usuarioRepository.findAll().stream()
        //        .map(usuarioAdapter::toModel)
        //        .toList();
    }

    // ══════════════════════════════
    // UPDATE — UsuarioControllerTest
    // ══════════════════════════════
    public Optional<Usuario> actualizar(Long id, Usuario datos) {
        // ROJO
        return Optional.empty();

        // VERDE (F2) — respuesta temporal sin persistir
        //if (Long.valueOf(1L).equals(id)) {
        //    Usuario u = new Usuario();
        //    u.setId(1L);
        //    u.setNombre(datos.getNombre());
        //    u.setCorreo(datos.getCorreo());
        //    return Optional.of(u);
        //}
        //return Optional.empty();

        // REFACTOR (F3)
        //Optional<UsuarioEntity> existente = usuarioRepository.findById(id);
        //if (existente.isEmpty()) {
        //    return Optional.empty();
        //}
        //UsuarioEntity entity = existente.get();
        //entity.setNombre(datos.getNombre());
        //entity.setCorreo(datos.getCorreo());
        //UsuarioEntity guardada = usuarioRepository.save(entity);
        //return Optional.of(usuarioAdapter.toModel(guardada));
    }

    // ══════════════════════════════
    // DELETE — UsuarioControllerTest
    // ══════════════════════════════
    public boolean eliminar(Long id) {
        // ROJO
        return false;

        // VERDE (F2) — confirma borrado sin repository
        //return true;

        // REFACTOR (F3)
        //if (!usuarioRepository.existsById(id)) {
        //    return false;
        //}
        //usuarioRepository.deleteById(id);
        //return true;
    }
}
