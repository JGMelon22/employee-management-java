import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    }
}
