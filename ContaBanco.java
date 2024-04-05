
import java.util.Random;
import java.util.Scanner;

public class ContaBanco {
    public static void main(String[] args) {
        String cadastro = """
                *****************************************
                | Seja bem vindo ao  Bank  Of  java One! |
                *****************************************
                """;

        Scanner scanner = new Scanner(System.in);

        System.out.println(cadastro);

        System.out.println("Digite Seu Nome:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite Sua idade:");
        int idadeCliente = scanner.nextInt();

        if (idadeCliente < 18) {
            System.out.println("Desculpe, é necessário ser maior que 18 anos para se cadastrar.");
        } else {
            System.out.println("Cadastro realizado com sucesso:");
            System.out.println();
            System.out.println("Seja Bem-Vindo ao Bank Of Java One");
            double saldo = 0;
            System.out.println(nomeCliente + "                                           Saldo Atual: R$ " + saldo);
            System.out.println("Tipo de Conta = Corrente");

            int numeroConta = 1000 + new Random().nextInt(9000);
            System.out.println("Numero da Conta = " + numeroConta);

            exibirTelaOpcao(saldo);

            int opcaoEscolhida;
            do {
                System.out.println("Digite A opção desejada");
                opcaoEscolhida = scanner.nextInt();

                switch (opcaoEscolhida) {
                    case 1:
                        saldo = transferirValor(scanner, saldo);
                        break;
                    case 2:
                        saldo = receberValor(scanner, saldo);
                        break;
                    case 3:
                        System.out.println("Saindo do programa. Obrigado por usar o Javabank.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opcaoEscolhida != 3);
        }
    }

    // Função para transferir um valor da conta e retornar o novo saldo
    public static double transferirValor(Scanner scanner, double saldo) {
        System.out.println("Transferir Valor");
        System.out.println("Digite o Valor : ");
        double valorDeTransferencia = scanner.nextDouble();
        if (valorDeTransferencia > saldo) {
            System.out.println("Saldo Insuficiente !");
        } else {
            saldo -= valorDeTransferencia;
            System.out.println("Transferência realizada com sucesso.");
        }
        System.out.println("Novo Saldo: R$ " + saldo);
        exibirTelaOpcao(saldo);
        return saldo;
    }

    // Função para receber um valor na conta e retornar o novo saldo
    public static double receberValor(Scanner scanner, double saldo) {
        System.out.println("Receber Valor");
        System.out.println("Digite o Valor");
        double valorRecebido = scanner.nextDouble();
        saldo += valorRecebido;
        System.out.println("Novo Saldo: R$ " + saldo);
        exibirTelaOpcao(saldo);
        return saldo;
    }

    // Função para exibir a tela de opções com o saldo atualizado
    public static void exibirTelaOpcao(double saldo) {
        String telaOpcao = """
                *************************************************
                |             1- Transferir Valor               |
                |             2- Receber  Valor                 |
                |             3- Sair                           |
                *************************************************
                Saldo Atual: R$ %.2f
                """;
        System.out.printf(telaOpcao, saldo);
    }
}
