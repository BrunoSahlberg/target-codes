package targetsistemas;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bruno
 */
public class FaturamentoDistribuidora {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        //Nunca havia usado JSON com Java e resolvi tentar, porém, não deu muito certo.

        // Ler o arquivo JSON
        Gson gson = new Gson();
        FileReader reader = new FileReader("dados.json");
        FaturamentoDiario[] faturamentoDiario = gson.fromJson(reader, FaturamentoDiario[].class);
        reader.close();

        // Encontrar o menor e o maior valor de faturamento diário
        double menorFaturamento = 10000000.00;
        double maiorFaturamento = 0.1;
        double somaFaturamento = 0.0;
        
        int diasComFaturamentoSuperiorMedia = 0;
        int diasNoMes = 0;
        
        for (FaturamentoDiario dia : faturamentoDiario) {
            // Ignorar dias sem faturamento
            if (dia.faturamentoDiario == 0.0) {
                continue; 
            }
            if (dia.faturamentoDiario <= menorFaturamento) {
                menorFaturamento = dia.faturamentoDiario;
            }
            if (dia.faturamentoDiario >= maiorFaturamento) {
                maiorFaturamento = dia.faturamentoDiario;
            }
            somaFaturamento += dia.faturamentoDiario;
            diasNoMes++;
        }

        // Calcular a média mensal
        double mediaMensal = somaFaturamento / diasNoMes;

        // Contar quantos dias tiveram faturamento superior à média
        for (FaturamentoDiario dia : faturamentoDiario) {
            if (dia.faturamentoDiario > mediaMensal) {
                diasComFaturamentoSuperiorMedia++;
            }
        }

        // Imprimir os resultados
        System.out.println("Menor valor de faturamento diário: " + menorFaturamento);
        System.out.println("Maior valor de faturamento diário: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento superior à média: " + diasComFaturamentoSuperiorMedia);
    }

    private static class FaturamentoDiario {

        private double faturamentoDiario;
    }
}
