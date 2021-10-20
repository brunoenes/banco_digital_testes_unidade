package com.financa.bancodigital.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_completo", length = 200)
    private String nomeCompleto;

    @Column(name = "nome_reduzido", length = 200)
    private String nomeReduzido;

    @Column(name = "cnpj")
    private String cnpj;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(id, banco.id) && Objects.equals(nomeCompleto, banco.nomeCompleto) && Objects.equals(nomeReduzido, banco.nomeReduzido) && Objects.equals(cnpj, banco.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCompleto, nomeReduzido, cnpj);
    }
}
