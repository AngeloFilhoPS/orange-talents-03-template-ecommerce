package com.mercadolivre.angelo.DesafioMercadoLivre.cadastroCategoria;


import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.UsuarioForm;
import com.mercadolivre.angelo.DesafioMercadoLivre.compartilhado.ExistId;
import com.mercadolivre.angelo.DesafioMercadoLivre.compartilhado.UniqueValue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    @NotBlank
    private String nome;
    @ExistId(entity = Categoria.class, campo = "nome")
    private Long idMae;




    public CategoriaForm(@NotBlank String nome,Long
                       idMae){
        this.nome=nome;
        if (idMae!=null){
            this.idMae=idMae;
        }
    }
    public Categoria converter(CategoriaForm form,CategoriaRepository categoriaRepository){
        if(form.getIdMae()==null){
            return new Categoria(nome);
        }
        Categoria categoriaMae = categoriaRepository.getCategoriaById(form.getIdMae());
        return new Categoria(nome, categoriaMae);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdMae() {
        return idMae;
    }

    @Override
    public String toString() {
        return "CategoriaForm{" +
                "nome='" + nome + '\'' +
                ", idMae=" + idMae +
                '}';
    }
}
