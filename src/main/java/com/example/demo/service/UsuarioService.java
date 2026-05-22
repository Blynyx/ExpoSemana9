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

    public Usuario crear(Usuario usuario) {
        //UsuarioEntity entity = usuarioAdapter.toEntity(usuario); //F3
        //entity.setId(null); //F3
        //UsuarioEntity guardada = usuarioRepository.save(entity); //F3
        //return usuarioAdapter.toModel(guardada); //F3
        Usuario respuesta = new Usuario();
        //respuesta.setId(99L); //F2
        //respuesta.setNombre(usuario.getNombre()); //F2
        //respuesta.setCorreo(usuario.getCorreo()); //F2
        return respuesta;
    }

    public List<Usuario> listarTodos() {
        //return usuarioRepository.findAll().stream() //F3
        //        .map(usuarioAdapter::toModel) //F3
        //        .toList(); //F3
        //Usuario u1 = new Usuario(); //F2
        //u1.setId(1L); //F2
        //u1.setNombre("Ana Pérez"); //F2
        //u1.setCorreo("ana.perez@ejemplo.com"); //F2
        //Usuario u2 = new Usuario(); //F2
        //u2.setId(2L); //F2
        //u2.setNombre("Luis García"); //F2
        //u2.setCorreo("luis.garcia@ejemplo.com"); //F2
        //return List.of(u1, u2); //F2
        return List.of();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        //return usuarioRepository.findById(id).map(usuarioAdapter::toModel); //F3
        //if (Long.valueOf(1L).equals(id)) { //F2
        //    Usuario u = new Usuario(); //F2
        //    u.setId(1L); //F2
        //    u.setNombre("Ana Pérez"); //F2
        //    u.setCorreo("ana.perez@ejemplo.com"); //F2
        //    return Optional.of(u); //F2
        //} //F2
        //return Optional.empty(); //F2
        return Optional.empty();
    }

    public Optional<Usuario> actualizar(Long id, Usuario datos) {
        //Optional<UsuarioEntity> existente = usuarioRepository.findById(id); //F3
        //if (existente.isEmpty()) { //F3
        //    return Optional.empty(); //F3
        //} //F3
        //UsuarioEntity entity = existente.get(); //F3
        //entity.setNombre(datos.getNombre()); //F3
        //entity.setCorreo(datos.getCorreo()); //F3
        //UsuarioEntity guardada = usuarioRepository.save(entity); //F3
        //return Optional.of(usuarioAdapter.toModel(guardada)); //F3
        //if (Long.valueOf(1L).equals(id)) { //F2
        //    Usuario u = new Usuario(); //F2
        //    u.setId(1L); //F2
        //    u.setNombre(datos.getNombre()); //F2
        //    u.setCorreo(datos.getCorreo()); //F2
        //    return Optional.of(u); //F2
        //} //F2
        //return Optional.empty(); //F2
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        //if (!usuarioRepository.existsById(id)) { //F3
        //    return false; //F3
        //} //F3
        //usuarioRepository.deleteById(id); //F3
        //return true; //F3
        //return true; //F2
        return false;
    }
}
