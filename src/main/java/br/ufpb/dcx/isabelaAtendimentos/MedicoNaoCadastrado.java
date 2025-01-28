package br.ufpb.dcx.isabelaAtendimentos;

public class MedicoNaoCadastrado extends RuntimeException {
    public MedicoNaoCadastrado(String message) {
        super(message);
    }
}
