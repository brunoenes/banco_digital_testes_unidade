package com.financa.bancodigital.domain.dto;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DTOTest {

    @Test
    void BancoDTOTest() {
        BancoDTO bancoDTO = new BancoDTO(1L, "Banco do Basil", "BB", "05099734000193");
        assertEquals(1L, bancoDTO.getId());
        assertEquals("Banco do Basil", bancoDTO.getNomeCompleto());
        assertEquals("BB", bancoDTO.getNomeReduzido());
        assertEquals("05099734000193", bancoDTO.getCnpj());
    }

}
