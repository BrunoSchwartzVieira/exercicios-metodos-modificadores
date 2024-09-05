
package exercicio2;

import java.util.HashSet;
import java.util.Set;


public class Projeto {
    private String nome;
    private Set<Funcionario> funcionarios;

    public Projeto(String nome) {
        this.nome = nome;
        this.funcionarios = new HashSet<>();
    }

   

    public String getNome() {
        return nome;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        funcionario.adicionarProjeto(this);
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @Override
    public String toString() {
        return "Projeto{nome='" + nome + "', funcionarios=" + funcionarios + "}";
    }

    }


