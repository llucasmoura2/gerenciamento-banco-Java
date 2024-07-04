import java.util.Scanner;
/**
 *
 * @author llucasmoura2
 */



public class GerenciaBanco1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria contaBancaria = new ContaBancaria();

        String nome, sobrenome, cpf;
        
        System.out.println("------------------------------------------");

        System.out.println("Seja Bem-vindo ao TalqueiBank!");

        System.out.println("Informe seu nome:");
        nome = scanner.nextLine();
        

        System.out.println("Informe seu sobrenome:");
        sobrenome = scanner.nextLine();

        System.out.println("Informe seu cpf:");
        cpf = scanner.nextLine();
        

        contaBancaria.setPersonalInfo(nome, sobrenome, cpf);

        int opcao;
        do {
            displayMenu(nome, sobrenome);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: R$" + contaBancaria.consultarSaldo());
                    break;
                case 2:
                    System.out.println("Informe o valor do depósito: R$");
                    double deposito = scanner.nextDouble();
                    contaBancaria.deposito(deposito);
                    System.out.print("seu novo saldo é R$ " + contaBancaria.consultarSaldo());
                    break;
                case 3:
                    System.out.println("Informe o valor do saque: R$");
                    double saque = scanner.nextDouble();
                    contaBancaria.saque(saque);
                    System.out.println("seu novo saldo é R$ " + contaBancaria.consultarSaldo());
                    break;
                case 4:
                    System.out.println("Encerrando o uso da aplicação. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void displayMenu(String nome, String sobrenome){
        System.out.println("Seja bem-vindo(a)" + nome + " " + sobrenome + "!");
        System.out.println("----------------------------------");
        System.out.println("\nMenu:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Encerrar");
        System.out.println("Escolha uma opção: ");
        System.out.println("----------------------------------");
    }
}

class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public void setPersonalInfo(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
    }

    public void saque(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }
}