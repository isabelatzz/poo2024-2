package br.ufpb.dcx.SistemaLojaRoupas;

import java.util.List;

public interface SistemaLojaRoupas {
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamnhoRoupa);
    public List<Roupa> pesquisaRoupaComDescricaoComecandoCom (String prefixoDescricao);
    String prefixoDescricao);
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa)
            throws RoupaInexistenteException;
    public void cadastraRoupa(String codigoRoupa, String descricao,
                              Tamanho tamanho, int quantidade) throws RoupaJaExisteException;
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa,
                                                 int novaQuantidade) throws RoupaInexistenteException;
    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa)
            throws RoupaInexistenteException;
    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException;

}
