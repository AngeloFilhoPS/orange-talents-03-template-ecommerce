package com.mercadolivre.angelo.DesafioMercadoLivre.controller;

import com.mercadolivre.angelo.DesafioMercadoLivre.entity.Usuario;
import com.mercadolivre.angelo.DesafioMercadoLivre.form.UserResponse;
import com.mercadolivre.angelo.DesafioMercadoLivre.form.UsuarioForm;
import com.mercadolivre.angelo.DesafioMercadoLivre.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
this.usuarioRepository= usuarioRepository;
    }

@PostMapping
    public String cadastroUsuario(@RequestBody @Valid UsuarioForm form){
    Usuario usuario = form.converter();
    usuario = usuarioRepository.save(usuario);
    return usuario.toString();
}

}
