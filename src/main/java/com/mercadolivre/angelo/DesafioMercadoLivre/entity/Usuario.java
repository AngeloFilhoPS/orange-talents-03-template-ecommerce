package com.mercadolivre.angelo.DesafioMercadoLivre.entity;

import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.SenhaLimpa;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String login;

    @NotNull
    @NotBlank
    @Size(min = 6)
    private String senha;

    @NotNull
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public Usuario(){}

    /*
     * @param email formato de email
     * @param senha string em texto limpo*/

    public Usuario(@Email
                   @NotNull
                   @NotBlank String login,
                   @NotNull
                   @Valid
                   SenhaLimpa senhaLimpa
                   ){
        Assert.isTrue(StringUtils.hasLength(login),"login não pode estar em branco");
        Assert.notNull(senhaLimpa,"não poder ser nulo");
        this.login=login;
        this.senha= senhaLimpa.hash();

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
