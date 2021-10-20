package com.financa.bancodigital.domain.dtos;

public class BancoDTO {

    private Long id;

    private String nomeCompleto;

    private String nomeReduzido;

    private String cnpj;

    public BancoDTO() {
    }

    public BancoDTO(Long id, String nomeCompleto, String nomeReduzido, String cnpj) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeReduzido = nomeReduzido;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeReduzido() {
        return nomeReduzido;
    }

    public void setNomeReduzido(String nomeReduzido) {
        this.nomeReduzido = nomeReduzido;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
