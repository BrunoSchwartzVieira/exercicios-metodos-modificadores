
package exercicio3;

import java.util.List;


public class Exercicio3 {

   
    public static void main(String[] args) {
        
      Usuario usuario1 = new Usuario("Alice", "alice@example.com");
        Usuario usuario2 = new Usuario("Bob", "bob@example.com");

        // Usuário Alice cria publicações
        usuario1.criarPublicacao("Olá, mundo!");
        usuario1.criarPublicacao("Meu segundo post.");

        // Usuário Bob cria uma publicação
        usuario2.criarPublicacao("Olá, Alice! Como vai?");

        // Adiciona comentários
        Publicacao publicacaoAlice1 = usuario1.getPublicacoes().get(0);
        Comentario comentario1 = new Comentario("Olá, Alice! Tudo bem?", usuario2);
        publicacaoAlice1.adicionarComentario(comentario1);

        Publicacao publicacaoBob1 = usuario2.getPublicacoes().get(0);
        Comentario comentario2 = new Comentario("Estou bem, e você?", usuario1);
        publicacaoBob1.adicionarComentario(comentario2);

        // Listar publicações de um usuário
        System.out.println("Publicações de Alice:");
        List<Publicacao> publicacoesAlice = usuario1.getPublicacoes();
        for (Publicacao p : publicacoesAlice) {
            System.out.println(p);
        }

        // Exibir publicações de Bob
        System.out.println("\nPublicações de Bob:");
        List<Publicacao> publicacoesBob = usuario2.getPublicacoes();
        for (Publicacao p : publicacoesBob) {
            System.out.println(p);
    }
    
}
}
