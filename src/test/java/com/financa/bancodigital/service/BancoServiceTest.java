package com.financa.bancodigital.service;

import com.financa.bancodigital.builder.BancoBuilder;
import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.domain.entities.Banco;
import com.financa.bancodigital.domain.mappers.BancoMapper;
import com.financa.bancodigital.domain.repository.BancoRepository;
import com.financa.bancodigital.exception.BancoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BancoServiceTest {

    @InjectMocks
    private BancoServiceImpl bancoService;

    @Mock
    private BancoRepository bancoRepository;

    @Mock
    private BancoMapper bancoMapper;

    BancoBuilder bancoBuilder = new BancoBuilder();

    @Test
    @DisplayName("Lista todos os bancos")
    void listarBancosSucesso() {

        List<BancoDTO> bancosDTO = bancoBuilder.construirListBancosDTO();
        List<Banco> bancos = bancoBuilder.construirListBancos();

        when(bancoRepository.findAll()).thenReturn(bancos);
        when(bancoMapper.toDto(bancos)).thenReturn(bancosDTO);

        List<BancoDTO> bancosResut = bancoService.listarBancos();

        assertEquals(bancosDTO.size(), bancosResut.size());
        assertEquals(bancosDTO, bancosResut);

    }

    @Test
    @DisplayName("Salvar o banco na base de dados")
    void salvarBancoSucesso() {

        BancoDTO bancoDTO = bancoBuilder.construirBancoDTO();
        BancoDTO bancoIdDTO = bancoBuilder.construirBancoDTO();
        bancoDTO.setId(null);
        Banco banco = bancoBuilder.construirBanco();
        Banco bancoId = bancoBuilder.construirBanco();
        banco.setId(null);

        when(bancoMapper.toEntity(bancoDTO)).thenReturn(banco);
        when(bancoRepository.save(banco)).thenReturn(bancoId);
        when(bancoMapper.toDto(bancoId)).thenReturn(bancoIdDTO);

        BancoDTO bancoResut = bancoService.salvarBanco(bancoDTO);

        assertEquals(bancoIdDTO, bancoResut);

    }

    @Test
    @DisplayName("Erro ao salvar banco - nome completo vazio")
    void salvarBancoErroNomeVazio() {

        BancoDTO bancoDTO = bancoBuilder.construirBancoDTO();
        bancoDTO.setNomeCompleto(null);

        try{
            bancoService.salvarBanco(bancoDTO);
        } catch (BancoException bancoException) {
            assertEquals(BancoException.getNomeCompletoVazio(), bancoException.getMessage());
        }

    }

    @Test
    @DisplayName("Buscar banco - sucesso")
    void buscarBancoSucesso() {

        BancoDTO bancoDTO = bancoBuilder.construirBancoDTO();
        Banco banco = bancoBuilder.construirBanco();

        Optional<Banco> optionalBanco = Optional.of(banco);

        when(bancoRepository.findById(bancoDTO.getId())).thenReturn(optionalBanco);
        when(bancoMapper.toDto(optionalBanco.get())).thenReturn(bancoDTO);

        BancoDTO bancoResut = bancoService.buscarBanco(bancoDTO.getId());

        assertEquals(bancoDTO, bancoResut);

    }

}
