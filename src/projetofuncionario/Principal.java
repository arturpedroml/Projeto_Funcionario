package projetofuncionario;
/**
 *
 * @author Artur
 */
import java.math.BigDecimal; // Para trabalhar com números decimais com alta precisão (ex: salários)
import java.text.NumberFormat; // Para formatar números, incluindo valores monetários, de acordo com a localidade
import java.time.LocalDate; // Para trabalhar com datas (ano, mês, dia)
import java.time.format.DateTimeFormatter; // Para formatar datas em strings específicas
import java.time.temporal.ChronoUnit; // Para realizar operações de tempo, como calcular a idade em anos
import java.util.ArrayList; // Para usar a implementação ArrayList, uma lista redimensionável
import java.util.HashMap; // Para usar a implementação HashMap, um mapa que armazena pares chave-valor
import java.util.Iterator; // Para trabalhar com listas de objetos
import java.util.List; // Para trabalhar com locais (por exemplo, Brasil para formatação de números)
import java.util.Locale; // Para trabalhar com mapas de chave-valor
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        // Criação da lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2022, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover o funcionário "João"
        for (Iterator<Funcionario> iterator = funcionarios.iterator(); iterator.hasNext(); ) {
            Funcionario f = iterator.next();
            // Verifica se o nome do funcionário é "João"
            if (f.getNome().equals("João")) {
                // Remove o funcionário da lista utilizando o iterator
                iterator.remove();
            }
        }
        
        System.out.println("");         
        // 3.3 - Imprimir todos os funcionários
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (Funcionario f : funcionarios) {
            // Formatando a data de nascimento para dd/MM/yyyy
            String dataFormatada = f.getDataNascimento().format(dateFormatter);
            // Formatando o salário com separadores de milhar e vírgula
            String salarioFormatado = currencyFormatter.format(f.getSalario());

            // Imprime as informações formatadas de cada funcionário
            System.out.println("Nome: " + f.getNome() +
                    ", Data de Nascimento: " + dataFormatada +
                    ", Salário: " + salarioFormatado +
                    ", Função: " + f.getFuncao());
        }
        
        System.out.println("");
        // 3.4 - Aumentar salário em 10%
        for (Funcionario f : funcionarios) {
            // Calcula o aumento de 10% no salário atual do funcionário
            BigDecimal aumento = f.getSalario().multiply(new BigDecimal("0.1"));
            BigDecimal salarioAtualizado = f.getSalario().add(aumento);
            // Define o novo salário no objeto Funcionario
            f.setSalario(salarioAtualizado);
        }

        System.out.println("");
        // 3.5 - Agrupar funcionários por função
        // Cria um mapa para armazenar funcionários agrupados por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario f : funcionarios) {
            // Verifica se a função já está no mapa, se não estiver, cria uma nova lista
            if (!funcionariosPorFuncao.containsKey(f.getFuncao())) {
                funcionariosPorFuncao.put(f.getFuncao(), new ArrayList<>());
            }
            // Adiciona o funcionário na lista correspondente à sua função
            funcionariosPorFuncao.get(f.getFuncao()).add(f);
        }
        
        System.out.println("");
        // 3.6 - Imprimir funcionários agrupados por função
        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("Funcionários da função " + funcao + ":");
            for (Funcionario f : funcionariosPorFuncao.get(funcao)) {
                System.out.println(" - " + f.getNome());
            }
        }

        System.out.println("");
        // 3.8 - Imprimir funcionários que fazem aniversário em outubro e dezembro
        for (Funcionario f : funcionarios) {            
            int mesNascimento = f.getDataNascimento().getMonthValue();
            if (mesNascimento == 10 || mesNascimento == 12) {
                System.out.println(f.getNome() + " faz aniversário no mês " + mesNascimento);
            }
        }
        
        System.out.println("");
        // 3.9 - Imprimir funcionário com maior idade
        Funcionario maisVelho = funcionarios.get(0); // Supõe que o primeiro funcionário é o mais velho inicialmente
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) { // Compara a data de nascimento para encontrar o mais velho
                maisVelho = f;
            }
        }
        // Calcula a idade do funcionário mais velho
        long idade = ChronoUnit.YEARS.between(maisVelho.getDataNascimento(), LocalDate.now());
        System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", Idade: " + idade);
        
        System.out.println("");
        // 3.10 - Imprimir lista de funcionários por ordem alfabética
        funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        System.out.println("Funcionários em ordem alfabética:");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome());
        }

        System.out.println("");
        // 3.11 - Imprimir total dos salários dos funcionários
        BigDecimal totalSalarios = BigDecimal.ZERO; // Inicializa o total como zero
        for (Funcionario f : funcionarios) {   
            totalSalarios = totalSalarios.add(f.getSalario()); // Adiciona o salário do funcionário ao total
        }
        // Formata o total dos salários para exibição com vírgula e separador de milhar
        System.out.println("Total dos salários dos funcionários: " + currencyFormatter.format(totalSalarios));

        System.out.println("");
        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00"); // Define o valor do salário mínimo como BigDecimal

        for (Funcionario f : funcionarios) {
            // Divide o salário do funcionário pelo salário mínimo e arredonda para baixo
            int salariosMinimos = f.getSalario().divide(salarioMinimo, BigDecimal.ROUND_DOWN).intValue();
            // Imprime o resultado
            System.out.println(f.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        }
    }
}