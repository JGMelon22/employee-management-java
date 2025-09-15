import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
}
