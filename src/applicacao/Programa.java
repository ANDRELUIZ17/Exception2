package applicacao;

import exceptions.BusinessExceptions;
import model.entidade.Conta;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int numero = sc.nextInt();
        System.out.print("Titular da conta: ");
        sc.nextLine();
        String titular = sc.nextLine();
        System.out.print("Saldo da conta: ");
        double saldo = sc.nextInt();
        System.out.print("Limite de saque: ");
        double saqueLimite = sc.nextDouble();

        Conta cc = new Conta(numero, titular, saldo, saqueLimite);

        System.out.println();
        System.out.print("Informe um quantia para sacar: ");
        double montante = sc.nextDouble();

        try {
            cc.saque(montante);
            System.out.printf("Novo saldo: %.2f%n", cc.getSaldo());
        }
        catch (BusinessExceptions e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
