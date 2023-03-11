package targetsistemas;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class InverteString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();
        String palavraInversa = "";
        
        //Percorre a string de trás pra frente e armazena o caractere atual para a string inversa
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInversa += palavra.charAt(i);
        }
        System.out.println("A palavra invertida é: " + palavraInversa);
    }
}
