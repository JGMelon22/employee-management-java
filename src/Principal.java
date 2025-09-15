import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("=== SISTEMA DE GERENCIAMENTO DE FUNCIONÁRIOS ===");
        System.out.println("Pressione Enter para começar...");

        // Inserir todos os funcionários
        inserirFuncionarios(funcionarios);
        System.out.println("=== FUNCIONÁRIOS INSERIDOS ===");
        imprimirFuncionarios(funcionarios);

        // Remover funcionário "João"
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        System.out.println("\n=== APÓS REMOÇÃO DO JOÃO ===");
        imprimirFuncionarios(funcionarios);

        // Aplicar aumento de 10%
        aplicarAumento(funcionarios, new BigDecimal("0.10"));
        System.out.println("\n=== APÓS AUMENTO DE 10% ===");
        imprimirFuncionarios(funcionarios);

        // Agrupar e imprimir por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);
        System.out.println("\n=== FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ===");
        imprimirPorFuncao(funcionariosPorFuncao);

        // Imprimir aniversariantes dos meses 10 e 12
        System.out.println("\n=== ANIVERSARIANTES DOS MESES 10 E 12 ===");
        imprimirAniversariantes(funcionarios, 10, 12);

        // Funcionário com maior idade
        System.out.println("\n=== FUNCIONÁRIO COM MAIOR IDADE ===");
        imprimirFuncionarioMaiorIdade(funcionarios);

        // Lista em ordem alfabética
        System.out.println("\n=== FUNCIONÁRIOS EM ORDEM ALFABÉTICA ===");
        imprimirOrdemAlfabetica(funcionarios);

        // Total dos salários
        System.out.println("\n=== TOTAL DOS SALÁRIOS ===");
        imprimirTotalSalarios(funcionarios);
    }

    private static void inserirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(f -> {
            String dataFormatada = f.getDataNascimento().format(DATE_FORMATTER);
            String salarioFormatado = DECIMAL_FORMATTER.format(f.getSalario()).replace(",", "X").replace(".", ",").replace("X", ".");
            System.out.printf("Nome: %s, Data Nascimento: %s, Salário: R$ %s, Função: %s%n",
                    f.getNome(), dataFormatada, salarioFormatado, f.getFuncao());
        });
    }

    private static void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentual) {
        funcionarios.forEach(f -> {
            BigDecimal aumento = f.getSalario().multiply(percentual);
            f.setSalario(f.getSalario().add(aumento));
        });
    }

    private static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    private static void imprimirPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> {
                String dataFormatada = f.getDataNascimento().format(DATE_FORMATTER);
                String salarioFormatado = DECIMAL_FORMATTER.format(f.getSalario()).replace(",", "X").replace(".", ",").replace("X", ".");
                System.out.printf("  - %s, %s, R$ %s%n", f.getNome(), dataFormatada, salarioFormatado);
            });
        });
    }

    private static void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
        funcionarios.stream()
                .filter(f -> mesesSet.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> {
                    String dataFormatada = f.getDataNascimento().format(DATE_FORMATTER);
                    System.out.printf("Nome: %s, Data Nascimento: %s%n", f.getNome(), dataFormatada);
                });
    }

    private static void imprimirFuncionarioMaiorIdade(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .max(Comparator.comparing(f -> Period.between(f.getDataNascimento(), LocalDate.now()).getYears()))
                .ifPresent(f -> {
                    int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
                    System.out.printf("Nome: %s, Idade: %d anos%n", f.getNome(), idade);
                });
    }

    private static void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f.getNome()));
    }

    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        String totalFormatado = DECIMAL_FORMATTER.format(total).replace(",", "X").replace(".", ",").replace("X", ".");
        System.out.printf("Total dos salários: R$ %s%n", totalFormatado);
    }
}