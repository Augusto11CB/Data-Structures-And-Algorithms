package aug.bueno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 *
 * O presente problema usou uma abordagem muito próxima da abordagem utilizada para resolver o problema da mochila booleana
 * da aula de Programação Dinâmica. O algoritmo se baseia na utilização de uma matrix para guardar o resultado do calculo da
 * utilização de uma certa moeda ou não. A matrix possui uma linha para cada moeda e as colunas vão de zero até o "valor da compra".
 *
 *
 * A matrix utilizada é uma matrix de booleans, true em uma posição x,y indica que a moeda foi incluida como troco para um valor de compra igual até y;
 *
 * A formula da recorrencia para a solução encontra-se abaixo:
 *
 * caso o valor da moeda seja maior que o valor levado em consideração y, nós utilizamos o resultado da posição ([i-1],y);
 * caso o valor da moeda seja menor ou igual ao levado em consideração y, então pegamos o resultado valueOf(i-1,y-vLinha[i]) + vLinha[i]) e
 * comparamos com o resultado da não inclusão dessa moeda no conjunto de soluções; nesse caso escolhe-se a operação que retorna sucesso (true), ou seja,
 * pode ser dar o troco sem que ultrapasse o limite y.
 *
 * valueOf(i-1,purchaseTotalValue)                                                se vLinha[i]>purchaseTotalValue
 * max(valueOf(i-1,purchaseTotalValue), valueOf(i-1,y-vLinha[i]) + vLinha[i])     se vLinha[i]<=y
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        String[] lineOne = s.readLine().split(" ");

        int purchaseTotalValue = Integer.parseInt(lineOne[0]);

        int[] vLinha = Stream.of(s.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (isThereChange(vLinha, purchaseTotalValue)) {
            System.out.println("S");
        } else {
            System.out.println("N");

        }
    }

    public static boolean isThereChange(int[] vLinha, int purchaseTotalValue) {
        int quantityOfCoins = vLinha.length;

        boolean[][] valueOf = new boolean[quantityOfCoins + 1][purchaseTotalValue + 1];

        for (int i = 0; i <= quantityOfCoins; i++) {
            // Se purchaseTotalValue é igual a zero, então sempre será true, pois existe um conjunto vazio de moedas que pode ser utilizado
            valueOf[i][0] = true;
        }

        for (int i = 1; i <= quantityOfCoins; i++) {

            for (int y = 1; y <= purchaseTotalValue; y++) {


                if (vLinha[i - 1] > y) {
                    // se o valor da moeda for maior que o y (atual valor da compra sendo considerado) //
                    // considere o resultado da utilização do conjunto de moedas até  valueOf[i - 1][y] (incluindo)
                    valueOf[i][y] = valueOf[i - 1][y];

                } else {
                    // verifica qual é a melhor opção a se considerar
                    // 1 - obtem a soma das moedas utilizadas até a linha anterior (valueOf[i - 1][y])
                    // 2 - verifica se é possivel utilizar a moeda atual em conjunto com o subconjunto que dá a soma de y-vLinha[i-1]
                    valueOf[i][y] = valueOf[i - 1][y] || valueOf[i - 1][y - vLinha[i - 1]];

                }
            }
        }
        return valueOf[quantityOfCoins][purchaseTotalValue];
    }

}
