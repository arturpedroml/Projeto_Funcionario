package projetofuncionario;
/**
 *
 * @author Artur
 */
import java.math.BigDecimal; 
import java.time.LocalDate; // Para trabalhar com datas (ano, mês, dia)

// A classe Funcionario estende a classe Pessoa, herdando seus atributos e métodos
public class Funcionario extends Pessoa {
    // Atributos da classe Funcionario
    private BigDecimal salario;
    private String funcao;

    // Construtor da classe Funcionario
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        // Chama o construtor da classe base (Pessoa)
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Métodos getters e setters para acessar e modificar os atributos

    // Retorna o salário do funcionário
    public BigDecimal getSalario() {
        return salario;
    }

    // Define o salário do funcionário
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    // Retorna a função do funcionário
    public String getFuncao() {
        return funcao;
    }
}

