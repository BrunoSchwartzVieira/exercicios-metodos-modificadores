
import java.util.HashMap;
import java.util.Map;

public class Estoque {

    public static void main(String[] args) {
        Produto produto1 = new Produto("001", "Camiseta", 10, 29.99);
        Produto produto2 = new Produto("002", "Calça", 5, 59.99);

        Fornecedor fornecedor = new Fornecedor("F001", "Fornecedor A", "contato@fornecedor.com");

        Pedido pedido = new Pedido(fornecedor);
        pedido.adicionarProduto(produto1, 20); 
        pedido.adicionarProduto(produto2, 15); 

        pedido.realizarPedidos();

        System.out.println(produto1);
        System.out.println(produto2);
        
    }
    
}
