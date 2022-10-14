package io.github.thigassantos.grupostrabalho.pessoa;

import io.github.thigassantos.grupostrabalho.telefone.Telefone;
import io.github.thigassantos.grupostrabalho.grupos.Atuacao;
import io.github.thigassantos.grupostrabalho.endereco.Endereco;
import io.github.thigassantos.grupostrabalho.grupos.Grupo;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author tygsv
 */
@Entity
@NamedQueries({@NamedQuery(name = "Pessoa.buscarTodosNamed",query = "SELECT p FROM Pessoa p"),
               @NamedQuery(name = "Pessoa.buscarNomeNamed",query = "SELECT p.nome FROM Pessoa p"),
               @NamedQuery(name = "Pessoa.buscarNomeEnderecoNamed",query = "SELECT p.nome,p.endereco FROM Pessoa p"),
               @NamedQuery(name = "Pessoa.buscarAvenidaNamed",query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro=1"),
               @NamedQuery(name = "Pessoa.buscarNaoPracaNamed",query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro!=2"),
               @NamedQuery(name = "Pessoa.buscarNomeTelefoneNamed",query = "SELECT p.nome,t FROM Pessoa p, IN (p.telefones) t")})
public class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 65)
    private String nome;
    @Column(length = 250)
    private String email;
    private LocalDate nascimento;
    @Transient
    private Byte idade;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="pessoa_id")
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Atuacao> atuacoes;
    @OneToMany(mappedBy = "lider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> lideranca;

    public Pessoa() {
    }
    
    public Pessoa(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Pessoa(String nome, String email, LocalDate nascimento, Endereco endereco, List<Telefone> telefones) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.telefones = telefones;
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
        this.idade = (byte) nascimento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public Byte getIdade() {
        return idade;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        atuacoes.forEach(atuacao-> atuacao.setPessoa(this));
        this.atuacoes = atuacoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Grupo> getLideranca() {
        return lideranca;
    }

    public void setLideranca(List<Grupo> lideranca) {
        this.lideranca = lideranca;
    } 
//</editor-fold>

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", nascimento=" + nascimento + ", endereco=" + endereco + '}';
    }

    
}