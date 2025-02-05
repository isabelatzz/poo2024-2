package br.ufpb.dcx.GerenciaProfs;

import br.ufpb.dcx.atividadeQuatro.DisciplinaJaExisteException;
import br.ufpb.dcx.atividadeQuatro.ProfessorInexistenteException;
import br.ufpb.dcx.atividadeQuatro.ProfessorJaExisteException;

public class GerentePreferenciasProfessores implements IProfessoresPrefs {
    private Map<String, Disciplina> disciplinas; //chave é o código da disciplina
    private Map<String, Professor> professores; //chave é a matrícula do professor
    private Map<String, Area> areas; //chave é o código da área
    private Map<Disciplina, RelatorioInteressePorDisciplina> interessesPorDisciplina;
    private Map<Professor, RelatorioInteressePorProfessor> interessesPorProfessor;
    private Map<Area, RelatorioInteressePorArea> interessesPorArea;

    public GerentePreferenciasProfessores() {
        this.disciplinas = new HashMap<String, Disciplina>();
        this.professores = new HashMap<String, Professor>();
        this.interessesPorDisciplina =
                new HashMap<Disciplina, RelatorioInteressePorDisciplina>();
        this.interessesPorProfessor =
                new HashMap<Professor, RelatorioInteressePorProfessor>();
        this.areas = new HashMap<String, Area>();
        this.interessesPorArea = new HashMap<Area, RelatorioInteressePorArea>();
    }

    @Override
    public void cadastraDisciplina(String codDisciplina, String nomeDisciplina)
            throws DisciplinaJaExisteException {
        if (this.disciplinas.containsKey(codDisciplina)) {
            throw new DisciplinaJaExisteException();
        } else {
            Disciplina dis = new Disciplina(codDisciplina, nomeDisciplina);
            this.disciplinas.put(codDisciplina, dis);
            this.interessesPorDisciplina.put(dis, new RelatorioInteressePorDisciplina(dis));
        }
    }

    //a
    public void cadastraProfessor(String matriculaProf, String nomeProf)
        throws ProfessorJaExisteException {
        if (this.professores.containsKey(matriculaProf)) {
            throw new ProfessorJaExisteException("Já existe prof cadastrado");
        } else {
            Professor is = new Professor(matriculaProf, nomeProf);
            this.professores.put(matriculaProf, is);
            this.interessesPorProfessor.put(is, new RelatorioInteressePorProfessor(is));
        }
    }


        //b
        public Professor pesquisaProfessor (String matriculaProf) throws ProfessorInexistenteException {
            Professor p = this.professores.get(matriculaProf);
            if (p == null ){
                throw new ProfessorInexistenteException("Esse prof não existe");

        } else {
                return p;
            }

    }









}



