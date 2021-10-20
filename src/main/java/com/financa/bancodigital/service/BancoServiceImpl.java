package com.financa.bancodigital.service;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.domain.entities.Banco;
import com.financa.bancodigital.domain.mappers.BancoMapper;
import com.financa.bancodigital.domain.repository.BancoRepository;
import com.financa.bancodigital.exception.BancoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository;

    private final BancoMapper bancoMapper;

    public BancoServiceImpl(BancoRepository bancoRepository, BancoMapper bancoMapper) {
        this.bancoRepository = bancoRepository;
        this.bancoMapper = bancoMapper;
    }

    @Override
    public List<BancoDTO> listarBancos() {
        List<Banco> bancos = bancoRepository.findAll();
        List<BancoDTO> bancosDTO = this.bancoMapper.toDto(bancos);
        return bancosDTO;
    }

    @Override
    public BancoDTO salvarBanco(BancoDTO bancoDTO) {
        if(bancoDTO.getNomeCompleto() == null) {
            throw new BancoException(BancoException.getNomeCompletoVazio());
        }
        Banco banco = bancoMapper.toEntity(bancoDTO);
        return bancoMapper.toDto(bancoRepository.save(banco));
    }

    @Override
    public BancoDTO editarBanco(BancoDTO bancoDTO) {
        if(bancoDTO.getNomeCompleto() == null) {
            throw new BancoException(BancoException.getNomeCompletoVazio());
        }
        Banco banco = bancoMapper.toEntity(bancoDTO);
        return bancoMapper.toDto(bancoRepository.save(banco));
    }

    @Override
    public BancoDTO buscarBanco(Long id) {
        Optional<Banco> optionalBanco = bancoRepository.findById(id);
        if(optionalBanco.isEmpty()) {
            throw new BancoException(BancoException.getBancoNaoEncontrado());
        }
        return bancoMapper.toDto(optionalBanco.get());
    }
}
