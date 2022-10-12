package io.github.thigassantos.grupostrabalho.pessoa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tygsv
 */
@Local
public interface PessoaBeanLocal {
    public void salvar(Pessoa pessoa);
    public List<Pessoa> buscarTodosTyped();
    public List<Pessoa> buscarTodosQuery();
    public List<Pessoa> buscarTodosNamed();
    public List<Pessoa> buscarNomeTyped();
    public List<Pessoa> buscarNomeQuery();
    public List<Pessoa> buscarNomeNamed();
    public List<Pessoa> buscarNomeEnderecoTyped();
    public List<Pessoa> buscarNomeEnderecoQuery();
    public List<Pessoa> buscarNomeEnderecoNamed();
}
