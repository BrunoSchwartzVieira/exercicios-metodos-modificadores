public class Produto {
    private String id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionarEstoque(int qtd) {
        this.quantidade += qtd;
    }

    public void removerEstoque(int qtd) {
        if (qtd <= this.quantidade) {
            this.quantidade -= qtd;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    @Override
    public String toString() {
        return "Produto{id='" + id + "', nome='" + nome + "', quantidade=" + quantidade + ", preco=" + preco + "}";
    }
}
