package io.github.thigassantos.grupostrabalho.grupos;

import io.github.thigassantos.grupostrabalho.pessoa.Pessoa;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Tygsv
 */
@Entity
public class Atuacao {

    @Id
    private Long id;
    private LocalDate inicio;
    private LocalDate termino;
    @OneToOne
    private Grupo grupo;
    @OneToOne
    private Pessoa pessoa;
    
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
