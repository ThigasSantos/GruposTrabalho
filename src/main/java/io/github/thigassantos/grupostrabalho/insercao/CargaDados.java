package io.github.thigassantos.grupostrabalho.insercao;

import io.github.thigassantos.grupostrabalho.pessoa.PessoaBeanLocal;
import io.github.thigassantos.grupostrabalho.endereco.*;
import io.github.thigassantos.grupostrabalho.grupos.*;
import io.github.thigassantos.grupostrabalho.pessoa.*;
import io.github.thigassantos.grupostrabalho.telefone.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {

    @Inject
    PessoaBeanLocal pessoaBean;

    @PostConstruct
    @Override
    public void popularBanco() {
        /// POPULAR BANCO COM DADOS DE TESTES
        Grupo estudo1 = new Grupo("Estudo I", false);
        Grupo estudo2 = new Grupo("Estudo II", true);
        Grupo estudo3 = new Grupo("Estudo III", false);
        Grupo estudo4 = new Grupo("Estudo IV", true);

        // Ana Zaira
        Pessoa ana = new Pessoa(
                "Ana Zaira",
                "ana@mail.com",
                LocalDate.of(2001, 1, 1)
        );
        ana.setEndereco(new Endereco(
                TipoLogradouro.RUA,
                "1",
                1111,
                "Humberto"
        ));

        ana.setTelefones(List.of(
                new Telefone((byte) 11, 11111111),
                new Telefone((byte) 12, 12121212),
                new Telefone((byte) 13, 13131313)
        ));

        estudo1.setLider(ana);

        ana.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2011, 1, 1),
                        LocalDate.of(2021, 11, 11),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 1),
                        LocalDate.of(2022, 11, 11),
                        estudo1)
        ));
        
        ana.setLideranca(List.of(estudo1));

        // Beatriz Yana

        Pessoa beatriz = new Pessoa(
                "Beatriz Yana",
                "beatriz@mail.com",
                LocalDate.of(2002, 2, 2)
        );

        beatriz.setEndereco(new Endereco(
                TipoLogradouro.AVENIDA,
                "2",
                2222,
                "Doisberto"
        ));

        beatriz.setTelefones(List.of(
                new Telefone((byte) 22, 22222222)
        ));

        estudo2.setLider(beatriz);
        estudo4.setLider(beatriz);

        beatriz.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        LocalDate.of(2021, 1, 12),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        estudo2),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2012, 1, 14),
                        estudo4)
        ));

        beatriz.setLideranca(List.of(estudo1,estudo2,estudo4));
        
        // Cecília Xerxes
        Pessoa cecilia = new Pessoa(
                "Cecília Xerxes",
                "cecilia@mail.com",
                LocalDate.of(2003, 3, 3)
        );

        cecilia.setEndereco(new Endereco(
                TipoLogradouro.AVENIDA,
                "3",
                3333,
                "Trêsberto"
        ));

        estudo3.setLider(cecilia);

        cecilia.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2013, 1, 3),
                        LocalDate.of(2021, 1, 13),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 3),
                        LocalDate.of(2023, 1, 13),
                        estudo3),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2012, 1, 14),
                        estudo4)
        ));

        cecilia.setLideranca(List.of(estudo1,estudo3));
        
        // Débora Wendel

        Pessoa debora = new Pessoa(
                "Débora Wendel",
                "debora@mail.com",
                LocalDate.of(2004, 4, 4)
        );

        debora.setTelefones(List.of(
                new Telefone((byte) 44, 44444444),
                new Telefone((byte) 45, 45454545)
                )
        );

        debora.setEndereco(new Endereco(
                TipoLogradouro.PRACA,
                "4",
                4444,
                "Quatroberto"
        ));

        debora.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2014, 1, 4),
                        LocalDate.of(2021, 1, 14),
                        estudo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        estudo2),
                new Atuacao(
                        LocalDate.of(2012, 1, 3),
                        LocalDate.of(2023, 1, 13),
                        estudo3),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2012, 1, 14),
                        estudo4)
        ));

   debora.setLideranca(List.of(estudo1,estudo2,estudo3,estudo4));
        
        pessoaBean.salvar(ana);
        pessoaBean.salvar(beatriz);
        pessoaBean.salvar(cecilia);
        pessoaBean.salvar(debora);
    }

}
