package io.github.thigassantos.grupostrabalho.grupos;

import io.github.thigassantos.grupostrabalho.pessoa.Pessoa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Tygsv
 */
@Entity
public class Grupo {

    @Id
    private Long id;
    @Column(nullable = false, length = 65)
    private String nome;
    private Boolean ativo;
    @OneToOne
    private Pessoa lider;

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

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }
    //</editor-fold>    
    
}
