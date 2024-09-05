package exercicio2;

import java.util.HashSet;
import java.util.Set;

public class Funcionario {
    private String nome;
    private double salario;
    private Set<Projeto> projetos;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.projetos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Set<Projeto> getProjetos() {
        return projetos;
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    @Override
    public String toString() {
        return "Funcionario{nome='" + nome + "', salario=" + salario + "}";
    }
}
