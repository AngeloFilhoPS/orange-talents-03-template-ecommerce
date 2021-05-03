package com.mercadolivre.angelo.DesafioMercadoLivre.cadastroCategoria;

import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaResponse {

        private Long id;
        private String nome;
        private Long mae_id;



        public CategoriaResponse(Categoria categoria){
            this.id= categoria.getId();
            this.nome=categoria.getNome();
            if(categoria.getMae()!=null){
                Categoria categoriaMae = categoria.getMae();
                this.mae_id=categoriaMae.getId();
            }
        }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getMae_id() {
        return mae_id;
    }
}
