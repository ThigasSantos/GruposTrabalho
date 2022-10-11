package io.github.thigassantos.grupostrabalho.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author Tygsv
 */
@Entity
public class Endereco {

    @Id
    private Long id;
    @Enumerated
    private TipoLogradouro tipoLogradouro;
    @Column(nullable = false, length = 150)
    private String logradouro;
    private Integer numero;
    @Column(nullable = false, length = 26)
    private String bairro;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
        public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //</editor-fold>

}
