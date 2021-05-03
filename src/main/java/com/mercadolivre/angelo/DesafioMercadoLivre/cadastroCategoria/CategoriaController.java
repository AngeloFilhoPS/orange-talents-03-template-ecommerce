package com.mercadolivre.angelo.DesafioMercadoLivre.cadastroCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository){
        this.categoriaRepository=categoriaRepository;
    }



    @PostMapping
    public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.converter(form, categoriaRepository);
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(new CategoriaResponse(categoria));
    }


}
