import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class BibliotecaVirtual {

    private static class Autor {
        private String nome;

        public Autor(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    private static class Livro {
        private String titulo;
        private Autor autor;
        private int anoPublicacao;
        private boolean emprestado;

        public Livro(String titulo, Autor autor, int anoPublicacao) {
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
            this.emprestado = false;
        }

        public String getTitulo() {
            return titulo;
        }

        public Autor getAutor() {
            return autor;
        }

        public int getAnoPublicacao() {
            return anoPublicacao;
        }

        public boolean isEmprestado() {
            return emprestado;
        }

        public void setEmprestado(boolean emprestado) {
            this.emprestado = emprestado;
        }
    }

    
    private static class Usuario {
        private String nome;

        public Usuario(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    private static class Emprestimo {
        private Livro livro;
        private Usuario usuario;
        private LocalDate dataEmprestimo;
        private LocalDate dataDevolucao;

        public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
            this.livro = livro;
            this.usuario = usuario;
            this.dataEmprestimo = dataEmprestimo;
            this.dataDevolucao = dataDevolucao;
        }

        public Livro getLivro() {
            return livro;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        public LocalDate getDataDevolucao() {
            return dataDevolucao;
        }
    }

    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    
    public void adicionarLivro(String titulo, Autor autor, int anoPublicacao) {
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    
    public void adicionarUsuario(String nome) {
        usuarios.add(new Usuario(nome));
    }

    public void realizarEmprestimo(String tituloLivro, String nomeUsuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        Optional<Livro> livroOpt = livros.stream()
                .filter(l -> l.getTitulo().equals(tituloLivro) && !l.isEmprestado())
                .findFirst();
        Optional<Usuario> usuarioOpt = usuarios.stream()
                .filter(u -> u.getNome().equals(nomeUsuario))
                .findFirst();

        if (livroOpt.isPresent() && usuarioOpt.isPresent()) {
            Livro livro = livroOpt.get();
            Usuario usuario = usuarioOpt.get();
            emprestimos.add(new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao));
            livro.setEmprestado(true);
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Livro ou usuário não encontrado ou o livro já está emprestado.");
        }
    }

    
    public void calcularMultasPorAtraso(LocalDate dataAtual) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataDevolucao().isBefore(dataAtual)) {
                long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), dataAtual);
                double multa = diasAtraso * 1.00; // 1.00 unidade monetária por dia de atraso
                System.out.println("Usuário: " + emprestimo.getUsuario().getNome() +
                        ", Livro: " + emprestimo.getLivro().getTitulo() +
                        ", Multa: R$ " + multa);
            }
        }
    }

    public void listarLivrosMaisPopulares() {
        Map<Livro, Long> contagemEmprestimos = emprestimos.stream()
                .collect(Collectors.groupingBy(Emprestimo::getLivro, Collectors.counting()));

        List<Map.Entry<Livro, Long>> livrosPopulares = contagemEmprestimos.entrySet().stream()
                .sorted(Map.Entry.<Livro, Long>comparingByValue().reversed())
                .collect(Collectors.toList());

        System.out.println("Livros mais populares:");
        for (Map.Entry<Livro, Long> entry : livrosPopulares) {
            Livro livro = entry.getKey();
            long quantidade = entry.getValue();
            System.out.println("- Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor().getNome() + ", Quantidade de Empréstimos: " + quantidade);
        }
    }

    
    public static void main(String[] args) {
        BibliotecaVirtual biblioteca = new BibliotecaVirtual();

        Autor autorGeorgeOrwell = new Autor("George Orwell");
        Autor autorJkRowling = new Autor("J.K. Rowling");

        biblioteca.adicionarLivro("1984", autorGeorgeOrwell, 1949);
        biblioteca.adicionarLivro("Harry Potter e a Pedra Filosofal", autorJkRowling, 1997);

        biblioteca.adicionarUsuario("João");
        biblioteca.adicionarUsuario("Maria");

        biblioteca.realizarEmprestimo("1984", "João", LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 15));
        biblioteca.realizarEmprestimo("Harry Potter e a Pedra Filosofal", "Maria", LocalDate.of(2024, 8, 5), LocalDate.of(2024, 8, 20));

        biblioteca.calcularMultasPorAtraso(LocalDate.of(2024, 8, 18));

        biblioteca.listarLivrosMaisPopulares();
    }
}
