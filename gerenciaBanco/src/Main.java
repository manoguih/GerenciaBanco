import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("Informe seu nome: ");
        String nome = Scanner.nextLine();
        System.out.println("Informe seu sobrenome: ");
        String sobrenome = Scanner.nextLine();
        System.out.println("Informe seu CPF: ");
        String cpf = Scanner.nextLine();
        cliente.setDadosPessoais(nome, sobrenome, cpf);

        int init = 0;
        do {
            System.out.println("----------------------------");
            System.out.println("Usuário: " + cliente.getNome() + " " + cliente.getSobrenome());
            System.out.println(" CPF: " + cliente.getCpf());
            System.out.println("----------------------------");
            System.out.println("1. | Consultar Saldo");
            System.out.println("2. | Realizar Saque");
            System.out.println("3. | Realizar Deposito");
            System.out.println("0. | Sair");
            System.out.println("----------------------------");

            Scanner scanner = new Scanner(System.in);
            try {
                if (scanner.hasNextInt()){
                    init = scanner.nextInt();
                }
                else {
                    System.out.println("Letras são inválidas");
                }
            }catch (InputMismatchException e){
                System.out.println("Informe um valor válido");
                scanner.next();
            }
            switch (init){
                case 1 :
                    System.out.println("Seu saldo é: R$" +String.format("%.2f", cliente.getSaldo()));
                    break;
                case 2:
                    System.out.println("Informe o valor que deseja sacar: ");
                   double valorSaque = Scanner.nextDouble();
                   cliente.sacar(valorSaque);
                   break;
                case 3:
                    System.out.println("Informe o valor que deseja depositar: ");
                    double valorDeposito = Scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                default:
                    if(init > 3) {
                        System.out.println("Opção inexistente");
                    }
                    break;
            }
        }while (init !=0);
        System.out.println("Encerrado com sucesso");

    }
}
class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo = 0.0;

    public void setDadosPessoais(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valorDeposito) {
        saldo += valorDeposito;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(double valorSaque) {
        if (valorSaque <= saldo) {
            saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
