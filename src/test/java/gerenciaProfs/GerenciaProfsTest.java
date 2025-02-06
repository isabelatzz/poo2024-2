package gerenciaProfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GerenciaProfsTest {
    @Test
    public void testaGerenciaProfs(){
        GerenciaProfsTest gerencia = new GerenciaProfsTest();
        try{
            gerencia.cadastraProfessor(123,"João");
            gerencia.cadastraDisciplina(44, "POO");
            gerencia.cadastraInteresseDeProfessorPorDisciplina(123, 44, NivelInteresse.P1);


            Collection<Professor> professoresInteressados = gerencia.getProfessoresInteressadosPorDisciplina(44, NivelInteresse.P1);

           boolean JoaoEncontrado = false;
           for (Professor p: professoresInteressados){
               if (p.getMatricula()== 123 && p.getNome().equals("João")){
                   JoaoEncontrado = true;
                   break;
               }
           }
           assertTrue(JoaoEncontrado, "João está na lista de professores");

            assertEquals(NivelInteresse.P1, gerencia.getNivelInteressePorDisciplina(123,44));








        }









    }





}
