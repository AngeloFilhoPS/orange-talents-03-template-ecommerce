package com.mercadolivre.angelo.DesafioMercadoLivre.form;

import com.mercadolivre.angelo.DesafioMercadoLivre.entity.Usuario;

public class UserResponse {
    private Long id;
    private String login;

    public UserResponse(Usuario usuario){
        this.id= usuario.getId();
        this.login=usuario.getLogin();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
