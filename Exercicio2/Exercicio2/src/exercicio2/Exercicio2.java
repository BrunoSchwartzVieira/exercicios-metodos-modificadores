
package exercicio2;

public class Exercicio2 {

    public static void main(String[] args) {
      Funcionario func1 = new Funcionario("Ana", 5000);
        Funcionario func2 = new Funcionario("Carlos", 6000);
        Funcionario func3 = new Funcionario("Maria", 5500);

       
        Departamento dep1 = new Departamento("TI");
        Departamento dep2 = new Departamento("Marketing");

       
        dep1.adicionarFuncionario(func1);
        dep1.adicionarFuncionario(func2);
        dep2.adicionarFuncionario(func3);

        
        Projeto proj1 = new Projeto("Projeto A");
        Projeto proj2 = new Projeto("Projeto B");

        
        proj1.adicionarFuncionario(func1);
        proj1.adicionarFuncionario(func3);
        proj2.adicionarFuncionario(func2);

        
        System.out.println("Média salarial do departamento de TI: " + dep1.calcularMediaSalarial());
        System.out.println("Média salarial do departamento de Marketing: " + dep2.calcularMediaSalarial());

        
        System.out.println(func1.getNome() + " está trabalhando nos seguintes projetos:");
        for (Projeto p : func1.getProjetos()) {
            System.out.println("  - " + p.getNome());
        }
        System.out.println(func2.getNome() + " está trabalhando nos seguintes projetos:");
        for (Projeto p : func2.getProjetos()) {
            System.out.println("  - " + p.getNome());
    }
}
}
    
    

