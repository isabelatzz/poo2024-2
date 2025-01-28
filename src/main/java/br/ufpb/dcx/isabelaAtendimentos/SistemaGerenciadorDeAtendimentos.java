package br.ufpb.dcx.isabelaAtendimentos;

import java.util.Collection;


public interface SistemaGerenciadorDeAtendimentos {
    public void cadastrarMedico(String crmMedico, String nomeMedico)
            throws MedicoJaCadastrado
            ;
    public int contaAtendimentosDeMedicoNoMes(String crmMedico,
                                              int mes, int ano);
    public void cadastrarAtendimento(String codigoFicha,
                                     CategoriaAtendimento categoria, String cpfPaciente, String crmMedico, Data diaAtendimento) throws MedicoNaoCadastradoException, AtendimentoJaCadastradoException;
    public AtendimentoMedico pesquisaAtendimento(String codigoFicha)
            throws AtendimentoNaoCadastradoException;
    public Collection<AtendimentoMedico> pesquisaAtendimentosDoDia(
            Data diaAtendimento);
    public int contaAtendimentosDaCategoria(CategoriaAtendimento categoria);
}

