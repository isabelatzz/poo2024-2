package br.ufpb.dcx.SistemaLojaRoupas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {
    private Map<String, Roupa> roupasMap;


    public SistemaLojaRoupasPOO() {
        this.roupasMap = new HashMap<>();
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaJaExisteException("Roupa já cadastrada: " + codigoRoupa);
        } else {
            Roupa roupa = new Roupa(codigoRoupa, descricao, tamanho, quantidade);
            this.roupasMap.put(codigoRoupa, roupa);
        }
    }

    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanho){
        List<Roupa> roupas = new ArrayList<>();
        for (Roupa r : this.roupasMap.values()) {
            if (r.getTamanho() == tamanho) {
                roupas.add(r);
            }
        }
        return roupas;
    }

    @Override
    public List<Roupa> pesquisaRoupaComDescricaoComecandoCom (String prefixoDescricao){
        List<Roupa> roupas = new ArrayList<>();
        for (Roupa r : this.roupasMap.values()) {
            if (r.getDescricao().startsWith(prefixoDescricao)) {
                roupas.add(r);
            }
        }
        return roupas;
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa)
            throws RoupaInexistenteException {
        for (Roupa r : this.roupasMap.values()) {
            if (r.getCodigo().equals(codigoRoupa)) {
                return r.getTamanho();
            }
        }
        return null;
    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException{
        if (!this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaInexistenteException("Não existe roupa com esse código");
        } else {
            Roupa r = this.roupasMap.get(codigoRoupa);
            r.setQuantidade(novaQuantidade);
        }
    }

    @Override
    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException{
        if (!this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaInexistenteException("Não existe roupa com esse código");
        }

        Roupa r = this.roupasMap.get(codigoRoupa);
        return r.getQuantidade();
    }

    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException{
        Roupa r = this.roupasMap.get(codigoRoupa);
        if (r == null) {
            throw new RoupaInexistenteException("Não existe roupa com esse código");
        }
        return r;
    }

}
