package com.financa.bancodigital.service;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.domain.entities.Banco;
import com.financa.bancodigital.domain.mappers.BancoMapper;
import com.financa.bancodigital.domain.repository.BancoRepository;
import com.financa.bancodigital.exception.BancoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoServiceSpringImpl implements BancoServiceSpring {

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private BancoMapper bancoMapper;


    @Override
    public List<BancoDTO> listarBancos() {
        List<Banco> bancos = bancoRepository.findAll();
        List<BancoDTO> bancosDTO = this.bancoMapper.toDto(bancos);
        return bancosDTO;
    }

    @Override
    public BancoDTO salvarBanco(BancoDTO bancoDTO) {
        if(bancoDTO.getNomeCompleto() == null) {
            throw new BancoException("Nome complento não pode ser vazio.");
        }
        Banco banco = bancoMapper.toEntity(bancoDTO);
        return bancoMapper.toDto(bancoRepository.save(banco));
    }

    @Override
    public BancoDTO editarBanco(BancoDTO bancoDTO) {
        if(bancoDTO.getNomeCompleto() == null) {
            throw new BancoException("Nome complento não pode ser vazio.");
        }
        Banco banco = bancoMapper.toEntity(bancoDTO);
        return bancoMapper.toDto(bancoRepository.save(banco));
    }

    @Override
    public BancoDTO buscarBanco(Long id) {
        Optional<Banco> optionalBanco = bancoRepository.findById(id);
        if(optionalBanco.isEmpty()) {
            throw new BancoException("Banco não encontrado!");
        }
        return bancoMapper.toDto(optionalBanco.get());
    }
}
