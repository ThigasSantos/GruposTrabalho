package io.github.thigassantos.grupostrabalho.pessoa;

import io.github.thigassantos.grupostrabalho.grupos.Grupo;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tygsv
 */
@Local
public interface PessoaBeanLocal {
    public void salvar(Pessoa pessoa);
    //QUESTÃO 1
    public List<Pessoa> buscarTodosTyped();
    public List<Pessoa> buscarTodosQuery();
    public List<Pessoa> buscarTodosNamed();
    //QUESTÃO 2
    public List<String> buscarNomeTyped();
    public List<String> buscarNomeQuery();
    public List<String> buscarNomeNamed();
    //QUESTÃO 3
    public List<Object[]> buscarNomeEnderecoTyped();
    public List<Object[]> buscarNomeEnderecoQuery();
    public List<Object[]> buscarNomeEnderecoNamed();
    //QUESTÃO 4
    public List<Pessoa> buscarAvenidaTyped();
    public List<Pessoa> buscarAvenidaQuery();
    public List<Pessoa> buscarAvenidaNamed();
    //QUESTÃO 5
    public List<Pessoa> buscarNaoPracaTyped();
    public List<Pessoa> buscarNaoPracaQuery();
    public List<Pessoa> buscarNaoPracaNamed();
    //QUESTÃO 6
    public List<Object[]> buscarNomeTelefoneTyped();
    public List<Object[]> buscarNomeTelefoneQuery();
    public List<Object[]> buscarNomeTelefoneNamed();
    //QUESTÃO 7
    public List<Pessoa> buscarEntreDatas(LocalDate dataInicio, LocalDate dataFim);
    //QUESTÃO 8
    public List<Pessoa> buscarDDDParana();
    public List<Pessoa> buscarDDDRio();
    //QUESTÃO 9
    public List<Pessoa> buscarSemTelefone();
    //QUESTÃO 10
    public List<Object[]> buscarQuantosTelefones();
    //QUESTÃO 11
    public List<Grupo> buscarGruposInativos();
    //QUESTÃO 12
    public List<Object[]> buscarLiderGrupos();
    //QUESTÃO 13
    public List<Object[]> buscarMembrosGrupos(String nomeGrupo);
    //QUESTÃO 14
    public List<Grupo> buscarGruposLider(String nomeLider);
    //QUESTÃO 15
    public List<Object[]> buscarGrupoMembro(String nomeMembro);
    //QUESTÃO 16
    public List<Grupo> buscarGrupoPedacoNome(String pedacoNomeGrupo);
    //QUESTÃO 17
    public List<Object[]> buscarGrupoQtdMembros();
    //QUESTÃO 18
    public List<Object[]> buscarGrupoQtdAtuacoes(Long qtdAtuacoes);
    //QUESTÃO 19
    public List<String> buscarMembroDataGrupo(Long idGrupo, LocalDate dataInicio);
    //QUESTÃO 20
    public List<Object[]> buscarDataMembroGrupos(Long idGrupo, LocalDate dataInicio);
    public List<Object[]> buscarDataMembroGrupos(LocalDate dataInicio);
    //QUESTÃO 21
    public List<Object[]> buscarMembroSemTermino();
    //QUESTÃO 22
    public List<Object[]> buscarLiderMembroGrupo();
}
