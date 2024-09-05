package exercicio5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class exercicio5 {

class Medico {
    private String nome;
    private String especialidade;

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}

// Classe Paciente
class Paciente {
    private String nome;
    private LocalDate dataNascimento;

    public Paciente(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}

// Classe Consulta
class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime dataHora;

    public Consulta(Medico medico, Paciente paciente, String data, String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.dataHora = LocalDateTime.parse(data + " " + hora, formatter);
        this.medico = medico;
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}

// Classe SistemaClinica
class SistemaClinica {
    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarMedico(String nome, String especialidade) {
        Medico medico = new Medico(nome, especialidade);
        medicos.add(medico);
    }

    public void adicionarPaciente(String nome, String dataNascimento) {
        Paciente paciente = new Paciente(nome, dataNascimento);
        pacientes.add(paciente);
    }

    public void agendarConsulta(String nomeMedico, String nomePaciente, String data, String hora) {
        Optional<Medico> medico = medicos.stream()
                .filter(m -> m.getNome().equals(nomeMedico))
                .findFirst();
        Optional<Paciente> paciente = pacientes.stream()
                .filter(p -> p.getNome().equals(nomePaciente))
                .findFirst();

        if (medico.isPresent() && paciente.isPresent()) {
            Consulta consulta = new Consulta(medico.get(), paciente.get(), data, hora);
            consultas.add(consulta);
            System.out.println("Consulta agendada com sucesso para " + nomePaciente + " com o Dr. " + nomeMedico + " em " + data + " às " + hora + ".");
        } else {
            System.out.println("Médico ou paciente não encontrado.");
        }
    }

    public void listarPacientesMedico(String nomeMedico) {
        List<Paciente> pacientesMedico = consultas.stream()
                .filter(c -> c.getMedico().getNome().equals(nomeMedico))
                .map(Consulta::getPaciente)
                .distinct()
                .collect(Collectors.toList());

        if (!pacientesMedico.isEmpty()) {
            System.out.println("Pacientes do Dr. " + nomeMedico + ":");
            for (Paciente paciente : pacientesMedico) {
                System.out.println("- " + paciente.getNome());
            }
        } else {
            System.out.println("O Dr. " + nomeMedico + " não tem consultas agendadas.");
        }
    }

    public void exibirProximasConsultas() {
        LocalDateTime agora = LocalDateTime.now();
        List<Consulta> consultasFuturas = consultas.stream()
                .filter(c -> c.getDataHora().isAfter(agora))
                .sorted((c1, c2) -> c1.getDataHora().compareTo(c2.getDataHora()))
                .collect(Collectors.toList());

        if (!consultasFuturas.isEmpty()) {
            System.out.println("Próximas consultas:");
            for (Consulta consulta : consultasFuturas) {
                System.out.println("Paciente: " + consulta.getPaciente().getNome() + ", Médico: " + consulta.getMedico().getNome() + ", Data e Hora: " + consulta.getDataHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            }
        } else {
            System.out.println("Não há consultas agendadas para os próximos dias.");
        }
    }
    
    public static void main(String[] args) {
        SistemaClinica sistema = new SistemaClinica();

        // Adiciona médicos
        sistema.adicionarMedico("Dr. João", "Cardiologista");
        sistema.adicionarMedico("Dr. Maria", "Dermatologista");

        // Adiciona pacientes
        sistema.adicionarPaciente("Ana Silva", "1985-03-15");
        sistema.adicionarPaciente("Pedro Costa", "1990-07-22");

        // Agenda consultas
        sistema.agendarConsulta("Dr. João", "Ana Silva", "2024-09-10", "14:30");
        sistema.agendarConsulta("Dr. Maria", "Pedro Costa", "2024-09-12", "09:00");

        // Lista pacientes do médico
        sistema.listarPacientesMedico("Dr. João");

        // Exibe próximas consultas
        sistema.exibirProximasConsultas();
    }
}
}

