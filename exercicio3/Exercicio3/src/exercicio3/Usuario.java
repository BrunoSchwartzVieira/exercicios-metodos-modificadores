
package exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
     private String nome;
    private String email;
    private List<Publicacao> publicacoes;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.publicacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void criarPublicacao(String texto) {
        Publicacao novaPublicacao = new Publicacao(texto, this);
        publicacoes.add(novaPublicacao);
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + "', email='" + email + "', publicacoes=" + publicacoes + "}";
    }
}


