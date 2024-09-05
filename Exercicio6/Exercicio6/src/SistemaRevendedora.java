import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SistemaRevendedora {
    
    private static class Marca {
        private String nome;

        public Marca(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    
    private static class Carro {
        private String modelo;
        private Marca marca;
        private double preco;
        private Vendedor vendedor;

        public Carro(String modelo, Marca marca, double preco, Vendedor vendedor) {
            this.modelo = modelo;
            this.marca = marca;
            this.preco = preco;
            this.vendedor = vendedor;
        }

        public String getModelo() {
            return modelo;
        }

        public Marca getMarca() {
            return marca;
        }

        public double getPreco() {
            return preco;
        }

        public Vendedor getVendedor() {
            return vendedor;
        }
    }

    // Classe interna para representar Vendedores
    private static class Vendedor {
        private String nome;

        public Vendedor(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    
    private List<Carro> estoque = new ArrayList<>();
    private Map<Marca, List<Carro>> carrosPorMarca = new HashMap<>();
    private Map<Vendedor, List<Carro>> carrosPorVendedor = new HashMap<>();

  
    public void adicionarCarro(String modelo, Marca marca, double preco, Vendedor vendedor) {
        Carro carro = new Carro(modelo, marca, preco, vendedor);
        estoque.add(carro);

       
        carrosPorMarca.computeIfAbsent(marca, k -> new ArrayList<>()).add(carro);

        
        carrosPorVendedor.computeIfAbsent(vendedor, k -> new ArrayList<>()).add(carro);
    }

    
    public void calcularMediaPrecosPorMarca() {
        for (Map.Entry<Marca, List<Carro>> entry : carrosPorMarca.entrySet()) {
            Marca marca = entry.getKey();
            List<Carro> carros = entry.getValue();

            double soma = carros.stream().mapToDouble(Carro::getPreco).sum();
            double media = soma / carros.size();

            System.out.println("Média de preços dos carros da marca " + marca.getNome() + ": R$ " + media);
        }
    }

    
    public void exibirCarrosVendidosPorVendedor(String nomeVendedor) {
        Optional<Vendedor> vendedorOpt = carrosPorVendedor.keySet().stream()
                .filter(v -> v.getNome().equals(nomeVendedor))
                .findFirst();

        if (vendedorOpt.isPresent()) {
            Vendedor vendedor = vendedorOpt.get();
            List<Carro> carrosVendidos = carrosPorVendedor.get(vendedor);

            if (carrosVendidos.isEmpty()) {
                System.out.println("Nenhum carro vendido pelo vendedor " + nomeVendedor);
            } else {
                System.out.println("Carros vendidos pelo vendedor " + nomeVendedor + ":");
                for (Carro carro : carrosVendidos) {
                    System.out.println("- Modelo: " + carro.getModelo() + ", Marca: " + carro.getMarca().getNome() + ", Preço: R$ " + carro.getPreco());
                }
            }
        } else {
            System.out.println("Vendedor " + nomeVendedor + " não encontrado.");
        }
    }

    
    public static void main(String[] args) {
        SistemaRevendedora sistema = new SistemaRevendedora();

        
        Marca marcaFiat = new Marca("Fiat");
        Marca marcaFord = new Marca("Ford");

        
        Vendedor vendedorAna = new Vendedor("Ana");
        Vendedor vendedorCarlos = new Vendedor("Carlos");

        
        sistema.adicionarCarro("Uno", marcaFiat, 30000, vendedorAna);
        sistema.adicionarCarro("Fusca", marcaFiat, 25000, vendedorCarlos);
        sistema.adicionarCarro("Focus", marcaFord, 50000, vendedorAna);
        sistema.adicionarCarro("Fiesta", marcaFord, 40000, vendedorCarlos);

       
        sistema.calcularMediaPrecosPorMarca();

       
        sistema.exibirCarrosVendidosPorVendedor("Ana");
        sistema.exibirCarrosVendidosPorVendedor("Carlos");
    }
}
