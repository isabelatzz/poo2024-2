package br.ufpb.dcx.atividadeQuatro;

public class DisciplinaInexistenteException extends RuntimeException {
    public DisciplinaInexistenteException(String message) {
        super(message);
    }
}
