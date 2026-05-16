package com.example.demo.adapter;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAdapter {

    public Usuario toModel(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }
        Usuario model = new Usuario();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setCorreo(entity.getCorreo());
        return model;
    }

    public UsuarioEntity toEntity(Usuario model) {
        if (model == null) {
            return null;
        }
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setCorreo(model.getCorreo());
        return entity;
    }
}
