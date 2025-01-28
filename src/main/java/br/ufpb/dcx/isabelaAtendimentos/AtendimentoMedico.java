package br.ufpb.dcx.isabelaAtendimentos;

public class AtendimentoMedico {
    private String codigoFicha;
    private CategoriaAtendimento categoria;
    private String cpfPaciente;
    private String crmMedico;
    private Data diaAtendimento;

    public AtendimentoMedico(String codigoFicha, CategoriaAtendimento categoria,
                             String cpfPaciente, String crmMedico, Data diaAtendimento) {
        this.codigoFicha = codigoFicha;
        this.categoria = categoria;
        this.cpfPaciente = cpfPaciente;
        this.crmMedico = crmMedico;
        this.diaAtendimento = diaAtendimento;
    }

    public AtendimentoMedico() {
        this("",CategoriaAtendimento.INDEFINIDO, "","",new Data());
    }

    public CategoriaAtendimento getCategoria() {
        return categoria;
    }

    public Data getDiaAtendimento() {
        return diaAtendimento;
    }

    //Demais métodos da classe por aqui …
}
