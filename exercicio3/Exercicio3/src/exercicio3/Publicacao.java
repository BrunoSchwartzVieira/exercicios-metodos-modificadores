
package exercicio3;

import java.util.ArrayList;
import java.util.List;


public class Publicacao {
private String texto;
    private Usuario usuario;
    private List<Comentario> comentarios;

    public Publicacao(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
        this.comentarios = new ArrayList<>();
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        return "Publicacao{texto='" + texto + "', usuario=" + usuario.getNome() + ", comentarios=" + comentarios + "}";
}
}