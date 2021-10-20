package com.financa.bancodigital.controller;

import com.financa.bancodigital.builder.BancoBuilder;
import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.service.BancoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class BancoControllerTestSpring {

    BancoBuilder bancoBuilder = new BancoBuilder();

    @InjectMocks
    private BancoController bancoController;

    @Mock
    private BancoService bancoService;


   /* @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @MockBean
    private BancoService bancoService;*/

  /*  @Test
    @DisplayName("Lista todos os bancos")
    public void listarBancosSucesso() throws Exception {
        List<BancoDTO> bancoDTOList = bancoBuilder.construirListBancosDTO();
        Mockito.when(bancoService.listarBancos()).thenReturn(bancoDTOList);

        List<BancoDTO> bancosDTOResult = jacksonMessageConverter.getObjectMapper().readValue(this.mockMvc.perform(get("/api/v1/banco"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString(),
                jacksonMessageConverter.getObjectMapper().getTypeFactory().constructCollectionType(List.class, BancoDTO.class));


        assertEquals(bancoDTOList.size(), bancosDTOResult.size());

        for (int i = 0; i < bancosDTOResult.size(); i++) {
            assertEquals(bancoDTOList.get(i).getId(), bancosDTOResult.get(i).getId());
            assertEquals(bancoDTOList.get(i).getNomeCompleto(), bancosDTOResult.get(i).getNomeCompleto());
            assertEquals(bancoDTOList.get(i).getNomeReduzido(), bancosDTOResult.get(i).getNomeReduzido());
            assertEquals(bancoDTOList.get(i).getCnpj(), bancosDTOResult.get(i).getCnpj());
        }

    }*/


    @Test
    @DisplayName("Lista todos os bancos")
    public void listarBancosSucesso() throws Exception {
        List<BancoDTO> bancoDTOList = bancoBuilder.construirListBancosDTO();
        Mockito.when(bancoService.listarBancos()).thenReturn(bancoDTOList);

        ResponseEntity<List<BancoDTO>> bancoResult = bancoController.listarBancos();

        assertEquals(bancoDTOList, bancoResult.getBody());
        assertEquals(HttpStatus.OK, bancoResult.getStatusCode());
    }
}
