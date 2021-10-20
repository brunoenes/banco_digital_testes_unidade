package com.financa.bancodigital.service;

import com.financa.bancodigital.domain.dtos.BancoDTO;

import java.util.List;

public interface BancoService {

    List<BancoDTO> listarBancos();

    BancoDTO salvarBanco(BancoDTO bancoDTO);

    BancoDTO editarBanco(BancoDTO bancoDTO);

    BancoDTO buscarBanco(Long id);
}
