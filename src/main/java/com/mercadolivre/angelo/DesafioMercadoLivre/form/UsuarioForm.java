package com.mercadolivre.angelo.DesafioMercadoLivre.form;

import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.SenhaLimpa;
import com.mercadolivre.angelo.DesafioMercadoLivre.compartilhado.UniqueValue;
import com.mercadolivre.angelo.DesafioMercadoLivre.entity.Usuario;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UsuarioForm {

    @NotBlank
    @UniqueValue(domainClass = Usuario.class,fieldName = "login")
    private String login;

    @NotBlank
    @Size(min = 6)
    private String senha;



    public UsuarioForm(@NotBlank String login,
                       @NotBlank @Size(min = 6) String senha
                       ){
this.login=login;
this.senha=senha;
    }

    public Usuario converter(){return new Usuario(login,new SenhaLimpa(senha));}

}
