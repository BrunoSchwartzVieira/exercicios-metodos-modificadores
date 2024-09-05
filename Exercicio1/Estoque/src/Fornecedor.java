
public class Fornecedor {
    private String id;
    private String nome;
    private String contato;

    public Fornecedor(String id, String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public void fazerPedido(Produto produto, int qtd) {
        System.out.println("Pedido de " + qtd + " unidades do produto " + produto.getNome() + " feito ao fornecedor " + nome);
    }

    @Override
    public String toString() {
        return "Fornecedor{id='" + id + "', nome='" + nome + "', contato='" + contato + "'}";
    }
}