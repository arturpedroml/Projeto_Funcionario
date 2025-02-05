package projetofuncionario;
/**
 *
 * @author Artur
 */
import java.time.LocalDate; // Para trabalhar com datas (ano, mês, dia)

// Definição da classe Pessoa
public class Pessoa {
    // Atributos da classe Pessoa
    private String nome;
    private LocalDate dataNascimento;

    // Construtor da classe Pessoa
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Métodos getters para acessar os atributos

    // Retorna o nome da pessoa
    public String getNome() {
        return nome;
    }

    // Retorna a data de nascimento da pessoa
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
