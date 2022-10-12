package io.github.thigassantos.grupostrabalho.grupos;

import io.github.thigassantos.grupostrabalho.pessoa.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author tygsv
 */
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65)
    private String nome;
    private Boolean ativo = true;
    @OneToMany(mappedBy = "grupo",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Atuacao> atuacoes;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonbTransient
    @JoinColumn(name = "lider_id")
    private Pessoa lider;

    
    public Grupo() {
        atuacoes = new java.util.ArrayList<>();
    }

    public Grupo(String nome, Boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

//</editor-fold>
}