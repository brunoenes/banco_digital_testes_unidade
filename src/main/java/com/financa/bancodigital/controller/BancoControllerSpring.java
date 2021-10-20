package com.financa.bancodigital.controller;

import com.financa.bancodigital.domain.dtos.BancoDTO;
import com.financa.bancodigital.exception.BancoException;
import com.financa.bancodigital.service.BancoServiceSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api-spring")
public class BancoControllerSpring {

    private static final String ENTITY_NAME_V1 = "/v1/banco";

    @Autowired
    private BancoServiceSpring bancoService;


    @GetMapping(ENTITY_NAME_V1)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<BancoDTO>> listarBancos() {
        return ResponseEntity.ok().body(bancoService.listarBancos());
    }

    @PostMapping(ENTITY_NAME_V1)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<BancoDTO> salvarBanco(@RequestBody BancoDTO bancoDTO, HttpServletRequest httpServletRequest) {
        BancoDTO bancoSalvo = bancoService.salvarBanco(bancoDTO);
        return ResponseEntity.created(URI.create(httpServletRequest.getRequestURL().toString() + "/" + bancoSalvo.getId()))
                .body(bancoSalvo);
    }

    @PutMapping(ENTITY_NAME_V1 + "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<BancoDTO> editarBanco(@PathVariable Long id, @RequestBody BancoDTO bancoDTO) {
        if (!bancoDTO.getId().equals(id)) {
            throw new BancoException(BancoException.getIdIncompativelObjeto());
        }
        return ResponseEntity.ok().body(bancoService.editarBanco(bancoDTO));
    }

    @GetMapping(ENTITY_NAME_V1 + "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<BancoDTO> buscarBanco(@PathVariable Long id) {
        return ResponseEntity.ok().body(bancoService.buscarBanco(id));
    }

}
