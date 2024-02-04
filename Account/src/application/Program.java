package application;

import entitites.Account;
import exceptions.BusinessException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Banco do Amor");
        System.out.println("Informe os dados da conta");

        System.out.print("Número: ");
        int number = sc.nextInt();

        sc.nextLine();
        System.out.print("Titular: ");
        String holder = sc.nextLine();

        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();

        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println("Que operação você deseja realizar?");
        System.out.println("[0] Sair\n[1] Depositar\n[2] Sacar\n[3] Consultar Saldo");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                System.out.println("Quanto você deseja depositar?");
                double amountDeposit = sc.nextDouble();
                acc.deposit(amountDeposit);
                System.out.printf("Valor de R$ %.2f depositado com sucesso!%n", amountDeposit);
                System.out.printf("Novo saldo: R$ %.2f%n", acc.getBalance());
                break;
            case 2:
                System.out.print("Quanto você deseja sacar ? ");
                double amountWithdraw = sc.nextDouble();
                try {
                    acc.withdraw(amountWithdraw);
                    System.out.printf("Novo saldo: R$ %.2f%n", acc.getBalance());
                } catch (BusinessException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println("Seu saldo é de R$ " + acc.getBalance());
                break;
            default:
                System.out.println("Opção inválida");
        }
        sc.close();
    }
}
