package com.mercadolivre.angelo.DesafioMercadoLivre.usuarioTest;

import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.UsuarioController;
import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.Usuario;
import com.mercadolivre.angelo.DesafioMercadoLivre.cadastroUsuario.UsuarioForm;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UsuarioController usuarioController;
    private UsuarioForm usuarioForm;
    private Usuario usuario;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController)
                .build();

    }

    @Test
    @DisplayName("Lidando com email duplicado")
    public void proibeEmailDuplicado() throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.post("/usuarios")
        )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());


    }
}
