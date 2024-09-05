
package exercicio2;

import java.util.HashSet;
import java.util.Set;


public class Departamento {
    private String nome;
    private Set<Funcionario> funcionarios;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public double calcularMediaSalarial() {
        if (funcionarios.isEmpty()) {
            return 0;
        }
        double totalSalarial = 0;
        for (Funcionario f : funcionarios) {
            totalSalarial += f.getSalario();
        }
        return totalSalarial / funcionarios.size();
    }

    @Override
    public String toString() {
        return "Departamento{nome='" + nome + "', funcionarios=" + funcionarios + "}";
}

   
}
