
package exercicio4;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {

    static class Passageiro {
        private String nome;
        private String email;
        private List<Reserva> reservas;

        public Passageiro(String nome, String email) {
            this.nome = nome;
            this.email = email;
            this.reservas = new ArrayList<>();
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public void adicionarReserva(Reserva reserva) {
            reservas.add(reserva);
        }

        public List<Reserva> getReservas() {
            return reservas;
        }

        @Override
        public String toString() {
            return "Passageiro{" +
                    "nome='" + nome + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    static class Voo {
        private String numero;
        private String destino;
        private int capacidade;
        private List<Reserva> reservas;

        public Voo(String numero, String destino, int capacidade) {
            this.numero = numero;
            this.destino = destino;
            this.capacidade = capacidade;
            this.reservas = new ArrayList<>();
        }

        public String getNumero() {
            return numero;
        }

        public String getDestino() {
            return destino;
        }

        public int getCapacidade() {
            return capacidade;
        }

        public int getAssentosDisponiveis() {
            return capacidade - reservas.size();
        }

        public boolean adicionarReserva(Reserva reserva) {
            if (getAssentosDisponiveis() > 0) {
                reservas.add(reserva);
                return true;
            }
            return false;
        }

        public List<Reserva> getReservas() {
            return reservas;
        }

        @Override
        public String toString() {
            return "Voo{" +
                    "numero='" + numero + '\'' +
                    ", destino='" + destino + '\'' +
                    ", capacidade=" + capacidade +
                    ", assentosDisponiveis=" + getAssentosDisponiveis() +
                    '}';
        }
    }

    
    static class Reserva {
        private Passageiro passageiro;
        private Voo voo;

        public Reserva(Passageiro passageiro, Voo voo) {
            this.passageiro = passageiro;
            this.voo = voo;
            if (voo.adicionarReserva(this)) {
                passageiro.adicionarReserva(this);
            } else {
                throw new RuntimeException("Não há assentos disponíveis para a reserva.");
            }
        }

        public Passageiro getPassageiro() {
            return passageiro;
        }

        public Voo getVoo() {
            return voo;
        }

        @Override
        public String toString() {
            return "Reserva{" +
                    "passageiro=" + passageiro.getNome() +
                    ", voo=" + voo.getNumero() +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Criar passageiros
        Passageiro passageiro1 = new Passageiro("João Silva", "joao.silva@example.com");
        Passageiro passageiro2 = new Passageiro("Maria Oliveira", "maria.oliveira@example.com");

        
        Voo voo1 = new Voo("1234", "São Paulo", 2);
        Voo voo2 = new Voo("5678", "Rio de Janeiro", 1);
        
        try {
            new Reserva(passageiro1, voo1);
            new Reserva(passageiro2, voo1); // Deve funcionar
            new Reserva(passageiro1, voo2); // Deve funcionar
            new Reserva(passageiro2, voo2); // Deve lançar exceção (sem assentos)
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        
        System.out.println("Reservas de João Silva:");
        for (Reserva reserva : passageiro1.getReservas()) {
            System.out.println(reserva);
        }

        System.out.println("\nReservas de Maria Oliveira:");
        for (Reserva reserva : passageiro2.getReservas()) {
            System.out.println(reserva);
        }

        
        System.out.println("\nInformações dos voos:");
        System.out.println(voo1);
        System.out.println(voo2);
    }
}
