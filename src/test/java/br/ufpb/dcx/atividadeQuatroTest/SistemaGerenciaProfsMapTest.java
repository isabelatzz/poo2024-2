package br.ufpb.dcx.atividadeQuatroTest;

import br.ufpb.dcx.atividadeQuatro.DisciplinaJaExisteException;
import br.ufpb.dcx.atividadeQuatro.ProfessorJaExisteException;
import br.ufpb.dcx.atividadeQuatro.SistemaGerenciaProfs;
import br.ufpb.dcx.atividadeQuatro.SistemaGerenciaProfsMap;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaGerenciaProfsMapTest {

    @Test
    public void testaCadastroProfs(){
        SistemaGerenciaProfsMap sistema = new SistemaGerenciaProfsMap();
        try{
            //I
            sistema.cadastraProfessor(111, "José");
            //II
            List<String> disciplinasDeJose = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertTrue(disciplinasDeJose.size()==0);
            assertEquals(0, disciplinasDeJose.size());
            //III
            List<Horario> horariosDisciplina = new LinkedList<>();
            Horario horarioAula1 = new Horario(DiaDaSemana.TERCA, 10, 12);
            horariosDisciplina.add(horarioAula1);
            Horario horarioAula2 = new Horario(DiaDaSemana.TERCA, 13, 15);
            horariosDisciplina.add(horarioAula2);

            sistema.cadastraDisciplina("POO", 22, 111, horariosDisciplina);

            //IV
            List <String> disciplinasJoseDepois = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertEquals(1, disciplinasJoseDepois.size());
            assertTrue(disciplinasJoseDepois.get(0).equals("POO"));



        } catch (ProfessorJaExisteException | DisciplinaJaExisteException e){
            e.printStackTrace();
            fail("N era pra falhar viu bbs");
        }

    }
}
