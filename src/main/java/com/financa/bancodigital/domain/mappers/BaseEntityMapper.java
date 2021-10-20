package com.financa.bancodigital.domain.mappers;

import java.util.List;

public interface BaseEntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

}
