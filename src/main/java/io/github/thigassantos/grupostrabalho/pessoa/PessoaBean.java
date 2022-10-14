package io.github.thigassantos.grupostrabalho.pessoa;

import io.github.thigassantos.grupostrabalho.grupos.Grupo;
import java.time.LocalDate;
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
    //<editor-fold defaultstate="collapsed" desc="Questão 1">
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
//</editor-fold>
    
    //QUESTÃO 2 BUSCAR NOME
    //<editor-fold defaultstate="collapsed" desc="Questão 2">
    @Override
    public List<String> buscarNomeTyped() {

        TypedQuery q = entityManager.createQuery("SELECT p.nome FROM Pessoa p", String.class);
        return q.getResultList();
    }

    @Override
    public List<String> buscarNomeQuery() {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<String>) q.getResultList();
    }

    @Override
    public List<String> buscarNomeNamed() {
        return (List<String>) entityManager.createNamedQuery("Pessoa.buscarNomeNamed", String.class).getResultList();
    }
//</editor-fold>
    
    //QUESTÃO 3 BUSCAR NOME E ENDERECO
    //<editor-fold defaultstate="collapsed" desc="Questão 3">
    @Override
    public List<Object[]> buscarNomeEnderecoTyped() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome,p.endereco FROM Pessoa p", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> buscarNomeEnderecoQuery() {
        Query q = entityManager.createQuery("SELECT p.nome,p.endereco FROM Pessoa p");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> buscarNomeEnderecoNamed() {
        return (List<Object[]>) entityManager.createNamedQuery("Pessoa.buscarNomeEnderecoNamed", Object[].class).getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 4 BUSCAR PESSOAS AVENIDA
    //<editor-fold defaultstate="collapsed" desc="Questão 4">
    @Override
    public List<Pessoa> buscarAvenidaTyped() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarAvenidaQuery() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarAvenidaNamed() {
        return (List<Pessoa>) entityManager.createNamedQuery("Pessoa.buscarAvenidaNamed", Pessoa.class).getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 5 BUSCAR PESSOAS QUE NÃO MORAM EM PRAÇA
    //<editor-fold defaultstate="collapsed" desc="Questão 5">
    @Override
    public List<Pessoa> buscarNaoPracaTyped() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarNaoPracaQuery() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarNaoPracaNamed() {
        return (List<Pessoa>) entityManager.createNamedQuery("Pessoa.buscarNaoPracaNamed", Pessoa.class).getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 6 BUSCAR NOME E TELEFONE
    //<editor-fold defaultstate="collapsed" desc="Questão 6">
    @Override
    public List<Object[]> buscarNomeTelefoneTyped() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome,t FROM Pessoa p, IN (p.telefones) t", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> buscarNomeTelefoneQuery() {
        Query q = entityManager.createQuery("SELECT p.nome,t FROM Pessoa p, IN (p.telefones) t");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> buscarNomeTelefoneNamed() {
        return (List<Object[]>) entityManager.createNamedQuery("Pessoa.buscarNomeTelefoneNamed", Object[].class).getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 7 BUSCAR ENTRE DATAS
    //<editor-fold defaultstate="collapsed" desc="Questão 7">
    @Override
    public List<Pessoa> buscarEntreDatas(LocalDate dataInicio, LocalDate dataFim) {
        return (List<Pessoa>) entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :dataInicio AND :dataFim")
                .setParameter("dataInicio", dataInicio).setParameter("dataFim", dataFim).getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 8 BUSCAR PESSOAS ESTADO
    //    <editor-fold defaultstate="collapsed" desc="Questão 8">
    @Override
    public List<Pessoa> buscarDDDRio() {
       return (List<Pessoa>) entityManager.createQuery("SELECT DISTINCT p FROM Pessoa p, IN (p.telefones) t WHERE t.ddd BETWEEN 21 AND 24").getResultList();
    }
    @Override
    public List<Pessoa> buscarDDDParana() {
       return (List<Pessoa>) entityManager.createQuery("SELECT DISTINCT p FROM Pessoa p, IN (p.telefones) t WHERE t.ddd BETWEEN 41 AND 46").getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 9 BUSCAR PESSOAS SEM TELEFONE
    //    <editor-fold defaultstate="collapsed" desc="Questão 9">
    @Override
    public List<Pessoa> buscarSemTelefone() {
       return (List<Pessoa>) entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY").getResultList();
    }
    //</editor-fold>
    
    //QUESTÃO 10 BUSCAR QUANTOS TELEFONES
    //<editor-fold defaultstate="collapsed" desc="Questão 10">
    @Override
    public List<Object[]> buscarQuantosTelefones(){
        return (List<Object[]>)entityManager.createQuery("SELECT p.nome, COUNT(*) FROM Pessoa p, IN (p.telefones) t GROUP BY p.nome").getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 11 BUSCAR QUANTOS GRUPOS INATIVOS
    //<editor-fold defaultstate="collapsed" desc="Questão 11">
    @Override
    public List<Grupo> buscarGruposInativos(){
        return (List<Grupo>)entityManager.createQuery("SELECT g FROM Grupo g WHERE g.ativo = false").getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 12 BUSCAR NOME DOS LIDERES
    //<editor-fold defaultstate="collapsed" desc="Questão 12">
    @Override
    public List<Object[]> buscarLiderGrupos(){
        return (List<Object[]>)entityManager.createQuery("SELECT g.nome,g.lider.nome FROM Grupo g").getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 13 BUSCAR MEMBROS DOS GRUPOS
    //<editor-fold defaultstate="collapsed" desc="Questão 13">
    @Override
    public List<Object[]> buscarMembrosGrupos(String nomeGrupo){
        return (List<Object[]>)entityManager.createQuery("SELECT a.pessoa.nome FROM Atuacao a WHERE a.grupo.nome = :nomeGrupo ORDER BY a.pessoa.nome DESC")
                .setParameter("nomeGrupo", nomeGrupo).getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 14 BUSCAR GRUPOS DO LIDER
    //<editor-fold defaultstate="collapsed" desc="Questão 14">
    @Override
    public List<Grupo> buscarGruposLider(String nomeLider){
        return (List<Grupo>)entityManager.createQuery("SELECT g FROM Pessoa p, IN (p.lideranca) g WHERE p.nome = :nomeLider")
                .setParameter("nomeLider", nomeLider).getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 15 BUSCAR GRUPOS QUE O MEMBRO PARTICIPA
    //<editor-fold defaultstate="collapsed" desc="Questão 15">
    @Override
    public List<Object[]> buscarGrupoMembro(String nomeMembro){
        return (List<Object[]>)entityManager.createQuery("SELECT a.inicio, a.termino, g.nome FROM Atuacao a, IN (a.grupo) g WHERE a.pessoa.nome = :nomeMembro")
                .setParameter("nomeMembro", nomeMembro).getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 16 BUSCAR GRUPOS POR PARTE DO NOME
    //<editor-fold defaultstate="collapsed" desc="Questão 16">
    @Override
    public List<Grupo> buscarGrupoPedacoNome(String pedacoNomeGrupo){
        return (List<Grupo>)entityManager.createQuery("SELECT g FROM Grupo g WHERE g.nome LIKE :pedacoNomeGrupo")
                .setParameter("pedacoNomeGrupo","%"+pedacoNomeGrupo+"%").getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 17 BUSCAR QTD DE MEMBROS DO GRUPO
    //<editor-fold defaultstate="collapsed" desc="Questão 17">
    @Override
    public List<Object[]> buscarGrupoQtdMembros(){
        return (List<Object[]>)entityManager.createQuery("SELECT g.nome,COUNT(DISTINCT a.pessoa.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome").getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 18 BUSCAR GRUPOS POR QTD DE ATUACOES
    //<editor-fold defaultstate="collapsed" desc="Questão 18">
    @Override
    public List<Object[]> buscarGrupoQtdAtuacoes(Long qtdAtuacoes){
        return (List<Object[]>)entityManager.createQuery("SELECT g.nome,COUNT(*) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome HAVING COUNT(*)>=:qtdAtuacoes")
                .setParameter("qtdAtuacoes", qtdAtuacoes).getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 19 BUSCAR MEMBROS A PARTIR DE DATA E GRUPO
    //<editor-fold defaultstate="collapsed" desc="Questão 19">
    @Override
    public List<String> buscarMembroDataGrupo(Long idGrupo, LocalDate dataInicio){
        return (List<String>)entityManager.createQuery("SELECT DISTINCT a.pessoa.nome FROM Atuacao a WHERE a.grupo.id = :idGrupo AND a.inicio >= :dataInicio")
                .setParameter("idGrupo", idGrupo).setParameter("dataInicio", dataInicio).getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 20 BUSCAR MEMBROS A PARTIR DE DATA E GRUPO E MOSTRAR A DATA
    //<editor-fold defaultstate="collapsed" desc="Questão 20">
    @Override
    public List<Object[]> buscarDataMembroGrupos(Long idGrupo, LocalDate dataInicio){
        return (List<Object[]>)entityManager.createQuery("SELECT new io.github.thigassantos.grupostrabalho.grupos.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.grupo.id = :idGrupo AND a.inicio >= :dataInicio ORDER BY a.grupo.nome, a.inicio")
                .setParameter("idGrupo", idGrupo).setParameter("dataInicio", dataInicio).getResultList();
    } 
    @Override
    public List<Object[]> buscarDataMembroGrupos(LocalDate dataInicio){
        return (List<Object[]>)entityManager.createQuery("SELECT new io.github.thigassantos.grupostrabalho.grupos.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.inicio >= :dataInicio ORDER BY a.grupo.nome, a.inicio")
                .setParameter("dataInicio", dataInicio).getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 21 BUSCAR MEMBROS SEM DATA DE TERMINO DA ATUACAO
    //<editor-fold defaultstate="collapsed" desc="Questão 21">
    @Override
    public List<Object[]> buscarMembroSemTermino(){
        return (List<Object[]>)entityManager.createQuery("SELECT a.grupo.nome, a.pessoa.nome FROM Atuacao a WHERE a.termino IS NULL").getResultList();
    }        
    //</editor-fold>
    
    //QUESTÃO 22 BUSCAR MEMBRO LIDER E GRUPO
    //<editor-fold defaultstate="collapsed" desc="Questão 22">
    @Override
    public List<Object[]> buscarLiderMembroGrupo(){
        return (List<Object[]>)entityManager.createQuery("SELECT g.nome, g.lider.nome, p.nome FROM Atuacao a JOIN a.grupo g JOIN a.pessoa p ORDER BY g.nome, g.lider.nome, p.nome").getResultList();
    }        
    //</editor-fold>
}
