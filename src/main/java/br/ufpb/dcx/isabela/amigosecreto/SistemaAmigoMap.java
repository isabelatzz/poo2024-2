package br.ufpb.dcx.isabela.amigosecreto;



import java.util.*;

public class SistemaAmigoMap {
    private Map<String, Mensagem> mensagemMap;
    private Map<String, Amigo> amigoMap;

    public SistemaAmigoMap() {
        this.mensagemMap = new HashMap<>();
        this.amigoMap = new HashMap<>();
    }

    public void cadastraAmigo(String nome, String email) {
        Amigo novoAmigo = new Amigo(nome, email);
        this.amigoMap.put(nome, novoAmigo);
    }

    public Amigo pesquisaAmigo (String email){
        return amigoMap.get(email);
    }












}
