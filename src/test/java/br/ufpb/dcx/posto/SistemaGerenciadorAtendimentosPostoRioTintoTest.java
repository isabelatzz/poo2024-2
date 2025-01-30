package br.ufpb.dcx.posto;


import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.dcx.isabelaAtendimentos.CategoriaAtendimento;
import br.ufpb.dcx.isabelaAtendimentos.Data;
import br.ufpb.dcx.isabelaAtendimentos.SistemaGerenciadorAtendimentosPostoRioTinto;
import org.junit.jupiter.api.Test;

public class SistemaGerenciadorAtendimentosPostoRioTintoTest {
    @Test

    public void testaCadastroMedico(){
        SistemaGerenciadorAtendimentosPostoRioTinto sitema = new SistemaGerenciadorAtendimentosPostoRioTinto();
        try {
            sitema.cadastrarMedico(11111, "ANA");
            sitema.cadastrarAtendimento("123", CategoriaAtendimento.CARDIOLOGICO, "155.090.224-50",11111, new Data(8,8, 2024)).size()==1);
        }
            //TODO

    }



}
