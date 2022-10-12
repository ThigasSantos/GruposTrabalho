package io.github.thigassantos.grupostrabalho.pessoa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tygsv
 */
@Stateless
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")

    private EntityManager entityManager;

    @Override
    public void salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    //QUESTÃO 1 BUSCAR TODOS
    @Override
    public List<Pessoa> buscarTodosTyped() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodosQuery() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodosNamed() {
        return (List<Pessoa>) entityManager.createNamedQuery("Pessoa.buscarTodosNamed", Pessoa.class).getResultList();
    }

    //QUESTÃO 2 BUSCAR NOME
    @Override
    public List<Pessoa> buscarNomeTyped() {

        TypedQuery q = entityManager.createQuery("SELECT p.nome FROM Pessoa p", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarNomeQuery() {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarNomeNamed() {
        return (List<Pessoa>) entityManager.createNamedQuery("Pessoa.buscarNomeNamed", Pessoa.class).getResultList();
    }

    //QUESTÃO 3 BUSCAR NOME e ENDERECO
    public List<Pessoa> buscarNomeEnderecoTyped() {

        TypedQuery q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarNomeEnderecoQuery() {
        Query q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarNomeEnderecoNamed() {
        return (List<Pessoa>) entityManager.createNamedQuery("Pessoa.buscarNomeEnderecoNamed", Pessoa.class).getResultList();
    }
}
