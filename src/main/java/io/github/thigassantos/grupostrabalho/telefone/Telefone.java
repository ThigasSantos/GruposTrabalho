package io.github.thigassantos.grupostrabalho.telefone;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Tygsv
 */
@Entity
public class Telefone {

    @Id
    private Long id;
    private Byte ddd;
    private Integer numero;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    //</editor-fold>
    
}
