package br.ufpb.dcx.isabelaAtendimentos;

public class AtendimentoJaCadastrado extends RuntimeException {
    public AtendimentoJaCadastrado(String message) {
        super(message);
    }
}
