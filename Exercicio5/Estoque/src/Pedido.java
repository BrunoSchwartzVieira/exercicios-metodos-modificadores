import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Map<Produto, Integer> produtos;
    private Fornecedor fornecedor;

    public Pedido(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        this.produtos = new HashMap<>();
    }

    // Adiciona um produto e a quantidade ao pedido
    public void adicionarProduto(Produto produto, int qtd) {
        produtos.put(produto, qtd);
    }

    // Realiza os pedidos para o fornecedor
    public void realizarPedidos() {
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            fornecedor.fazerPedido(produto, quantidade);
        }
        produtos.clear(); // Limpa a lista após realizar os pedidos
    }

    @Override
    public String toString() {
        return "Pedido{fornecedor=" + fornecedor + ", produtos=" + produtos + "}";
    }
}
