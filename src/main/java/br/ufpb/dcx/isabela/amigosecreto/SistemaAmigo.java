package br.ufpb.dcx.isabela.amigosecreto;


import java.util.*;

public class SistemaAmigo {
        private Map<String, Mensagem> mensagens;
        private Map<String, Amigo> amigos;

        public SistemaAmigo() {
            this.mensagens = new HashMap<>();
            this.amigos = new HashMap<>();
        }

        public void cadastraAmigo(String nome, String email) {
            Amigo novoAmigo = new Amigo(nome, email);
            this.amigos.put(nome, novoAmigo);
        }

        public Amigo pesquisaAmigo(String email) {
            for (Amigo at: this.amigos.values()) {
                if (at.getEmail().equalsIgnoreCase(email)) {
                    return at;
                }
            }
            return null;
        }

        public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
            Amigo remetente = pesquisaAmigo(emailRemetente);
            if (remetente == null) {
                System.out.println("Remetente não encontrado no sistema!");
                return;
            }
            MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
            this.mensagens.put(texto, mensagem);
        }

        public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
            Amigo remetente = pesquisaAmigo(emailRemetente);
            if (remetente == null) {
                System.out.println("Remetente não encontrado no sistema!");
                return;
            }

            MensagemParaAlguem mensagensAlguem = new MensagemParaAlguem(emailRemetente, emailDestinatario, anonima);
            mensagens.put(texto, mensagensAlguem);
        }

        public List<Mensagem> pesquisaMensagemAnonima() {
            List<Mensagem> mensagensAnonimas = new ArrayList<>();

            for (Mensagem mensagem : this.mensagens.values()) {
                if (mensagem.ehAnonima()) {
                    mensagensAnonimas.add(mensagem);
                }
            }
            return mensagensAnonimas;
        }

        public Collection<Mensagem> pesquisaTodasAsMensagens() {
            return mensagens.values();
        }


        public void configuraAmigoSecretoDe(String email, String emailAmigoSorteado) throws AmigoInexistenteException {
            Amigo amigo = pesquisaAmigo(email);
            if (amigo == null){
                throw new AmigoInexistenteException("Amigo com o email " + email + "não encontrado.");
            }

            Amigo amigoSorteado = pesquisaAmigo(emailAmigoSorteado);

            if (amigoSorteado == null) {
                throw new AmigoInexistenteException("Amigo sorteado com o email " + emailAmigoSorteado + "não encontrado.");
            }

            amigo.setEmailAmigoSorteado(emailAmigoSorteado);
            System.out.println("Amigo secreto de: " + amigo.getNome() + " é " + amigoSorteado.getNome());
        }

        public String pesquisaAmigoSecretoDe(String email) throws AmigoInexistenteException, AmigoNaoSorteadoException {
            Amigo amigo = pesquisaAmigo(email);

            if (amigo == null) {
                throw new AmigoInexistenteException("Amigo com e-mail " + email + " não encontrado.");
            }

            String amigoSecretoEmail = amigo.getEmailAmigoSorteado();

            if (amigoSecretoEmail == null) {
                throw new AmigoNaoSorteadoException("Amigo secreto não foi sorteado para " + amigo.getNome() + ".");
            }
            return amigoSecretoEmail;
        }

        public Collection<Amigo> getAmigos() {
            return amigos.values();
        }

    }

