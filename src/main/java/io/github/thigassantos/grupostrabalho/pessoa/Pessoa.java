package io.github.thigassantos.grupostrabalho.pessoa;

import io.github.thigassantos.grupostrabalho.endereco.Endereco;
import io.github.thigassantos.grupostrabalho.grupos.Atuacao;
import io.github.thigassantos.grupostrabalho.telefone.Telefone;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Tygsv
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 65)
    private String nome;
    @Column(nullable = false, length = 250)
    private String email;
    private LocalDate nascimento;
    @Transient
    private Byte idade;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Telefone> telefone; 
    @OneToMany(cascade = CascadeType.ALL)
    private List<Atuacao> atuacao;
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;

        // Derivação da idade
        this.idade = (byte) nascimento.until(
                LocalDate.now(),
                ChronoUnit.YEARS);
    }

    public Byte getIdade() {
        return idade;
    }
   
        public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
 //</editor-fold>

}
