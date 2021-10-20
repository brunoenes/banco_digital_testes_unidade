package com.financa.bancodigital.domain.mappers;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.domain.entities.Banco;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;

@Component
@Mapper(componentModel = "spring")
public interface BancoMapper extends  BaseEntityMapper<BancoDTO, Banco>{
}
