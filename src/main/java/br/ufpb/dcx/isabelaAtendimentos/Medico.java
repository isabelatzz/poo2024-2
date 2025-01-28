package br.ufpb.dcx.isabelaAtendimentos;

public class Medico {
    private String crmMedico;
    private String nomeMedico;


    public Medico(String crmMedico, String nomeMedico) {
        this.crmMedico = crmMedico;
        this.nomeMedico = this.nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crmMedico='" + crmMedico + '\'' +
                ", nomeMedico='" + nomeMedico + '\'' +
                '}';
    }
}
