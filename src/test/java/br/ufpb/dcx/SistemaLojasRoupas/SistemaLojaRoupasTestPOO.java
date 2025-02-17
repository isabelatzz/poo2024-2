package br.ufpb.dcx.SistemaLojasRoupas;

import br.ufpb.dcx.SistemaLojaRoupas.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaLojaRoupasTestPOO {
    @Test
    public void testeCadastroDeRoupa() {
        SistemaLojaRoupasPOO sistema = new SistemaLojaRoupasPOO();
        try {
            sistema.cadastraRoupa("001", "Camisa polo Azul Masculina", Tamanho.M, 10);
            Roupa r = sistema.pesquisaRoupa("001");
            assertEquals(10, r.getQuantidade());
            sistema.cadastraRoupa("002", "Camisa vermelha feminina", Tamanho.M, 2);
            List<Roupa> roupas = sistema.pesquisaRoupaComDescricaoComecandoCom("Camisa");
            assertEquals(2, roupas.size());
            sistema.alteraQuantidadeDeRoupaNoEstoque("001", 9);
            assertEquals(9, sistema.pesquisaQuantidadeDeRoupaNoEstoque("001"));

        } catch (RoupaJaExisteException | RoupaInexistenteException e) {
            fail("Não deveria lançar essa exceção");
        }


    }
}
