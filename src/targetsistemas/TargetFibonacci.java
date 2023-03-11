package targetsistemas;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class TargetFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir o número ao usuário
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        // Calcular a sequência de Fibonacci até o número informado
        int a = 0;
        int b = 1;
        int fibonacci = 0;
        while (fibonacci < numero) {
            fibonacci = a + b;
            a = b;
            b = fibonacci;
        }

        // Verificar se o número informado pertence à sequência de Fibonacci
        if (fibonacci == numero) {
            System.out.printf("O número pertence %d à sequência de Fibonacci. \n", numero);
        } else {
            System.out.printf("O número não pertence à sequência de Fibonacci. \n", numero);
        }
    }
}
