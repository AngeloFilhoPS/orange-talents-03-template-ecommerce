package com.mercadolivre.angelo.DesafioMercadoLivre.cadastroCategoria;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    Categoria getCategoriaById(Long id);
}
