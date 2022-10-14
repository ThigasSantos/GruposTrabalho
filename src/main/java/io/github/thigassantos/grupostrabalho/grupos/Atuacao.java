package io.github.thigassantos.grupostrabalho.grupos;

import io.github.thigassantos.grupostrabalho.pessoa.Pessoa;
import java.io.Serializable;
import java.time.LocalDate;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author tygsv
 */
@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate inicio;
    private LocalDate termino;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonbTransient
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonbTransient
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    public Atuacao() {
    }

    public Atuacao(LocalDate inicio, LocalDate termino, Grupo grupo) {
        this.inicio = inicio;
        this.termino = termino;
        this.grupo = grupo;
    }

    public Atuacao(LocalDate inicio, Grupo grupo) {
        this.inicio = inicio;
        this.grupo = grupo;
    }

    
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
//</editor-fold>

}