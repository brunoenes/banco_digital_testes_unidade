package com.financa.bancodigital.builder;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.domain.entities.Banco;

import java.util.ArrayList;
import java.util.List;

public class BancoBuilder {

    private static final Long DEFAULT_ID = 1L;
    private static final String DEFAULT_NOME_COMPLETO = "Banco do Brasil";
    private static final String DEFAULT_NOME_REDUZIDO = "BB";
    private static final String DEFAULT_CNPJ = "05099734000193";

    private static final Long AUX_ID = 2L;
    private static final String AUX_NOME_COMPLETO = "Banco Itau";
    private static final String AUX_NOME_REDUZIDO = "Itau";
    private static final String AUX_CNPJ = "64509663000119";

    public BancoDTO construirBancoDTO() {
        return new BancoDTO(DEFAULT_ID, DEFAULT_NOME_COMPLETO, DEFAULT_NOME_REDUZIDO, DEFAULT_CNPJ);
    }

    public BancoDTO construirBancoAuxDTO() {
        return new BancoDTO(AUX_ID, AUX_NOME_COMPLETO, AUX_NOME_REDUZIDO, AUX_CNPJ);
    }

    public Banco construirBanco() {
        Banco banco = new Banco();
        banco.setId(DEFAULT_ID);
        banco.setNomeCompleto(DEFAULT_NOME_COMPLETO);
        banco.setNomeReduzido(DEFAULT_NOME_REDUZIDO);
        banco.setCnpj(DEFAULT_CNPJ);
        return banco;
    }

    public Banco construirBancoAux() {
        Banco banco = new Banco();
        banco.setId(AUX_ID);
        banco.setNomeCompleto(AUX_NOME_COMPLETO);
        banco.setNomeReduzido(AUX_NOME_REDUZIDO);
        banco.setCnpj(AUX_CNPJ);
        return banco;
    }

    public List<Banco> construirListBancos() {
       List<Banco> bancos = new ArrayList<>();
       bancos.add(construirBanco());
       bancos.add(construirBancoAux());
       return bancos;
    }

    public List<BancoDTO> construirListBancosDTO() {
        List<BancoDTO> bancosDTO = new ArrayList<>();
        bancosDTO.add(construirBancoDTO());
        bancosDTO.add(construirBancoAuxDTO());
        return bancosDTO;
    }

}
