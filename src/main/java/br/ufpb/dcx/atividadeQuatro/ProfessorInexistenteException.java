package br.ufpb.dcx.atividadeQuatro;

public class ProfessorInexistenteException extends RuntimeException {
    public ProfessorInexistenteException(String message) {
        super(message);
    }
}
