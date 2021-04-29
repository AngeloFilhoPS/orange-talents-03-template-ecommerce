package com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserResponse> cadastroUsuario(@RequestBody @Valid UsuarioForm form){
    Usuario usuario = form.converter();
    usuario = usuarioRepository.save(usuario);
    return ResponseEntity.ok().body(new UserResponse(usuario));
}

}
