package com.financa.bancodigital.domain.mappers;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.domain.entities.Banco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-19T22:22:13-0300",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class BancoMapperImpl implements BancoMapper {

    @Override
    public Banco toEntity(BancoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Banco banco = new Banco();

        banco.setId( dto.getId() );
        banco.setNomeCompleto( dto.getNomeCompleto() );
        banco.setNomeReduzido( dto.getNomeReduzido() );
        banco.setCnpj( dto.getCnpj() );

        return banco;
    }

    @Override
    public BancoDTO toDto(Banco entity) {
        if ( entity == null ) {
            return null;
        }

        BancoDTO bancoDTO = new BancoDTO();

        bancoDTO.setId( entity.getId() );
        bancoDTO.setNomeCompleto( entity.getNomeCompleto() );
        bancoDTO.setNomeReduzido( entity.getNomeReduzido() );
        bancoDTO.setCnpj( entity.getCnpj() );

        return bancoDTO;
    }

    @Override
    public List<Banco> toEntity(List<BancoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Banco> list = new ArrayList<Banco>( dtoList.size() );
        for ( BancoDTO bancoDTO : dtoList ) {
            list.add( toEntity( bancoDTO ) );
        }

        return list;
    }

    @Override
    public List<BancoDTO> toDto(List<Banco> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BancoDTO> list = new ArrayList<BancoDTO>( entityList.size() );
        for ( Banco banco : entityList ) {
            list.add( toDto( banco ) );
        }

        return list;
    }
}
