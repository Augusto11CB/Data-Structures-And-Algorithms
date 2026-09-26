package aug.bueno;

import java.util.Arrays;
import java.util.Objects;


/*
 *
 * Para realizar os testes da implementação, localize o método main() na classe HeapOperations. Dentro do método é possivel
 * inserir o array que deve-se retirar os maiores elementos, bem como a declaração da variavel que representará a quantidade
 * dos maiores elementos que serão extraidos.
 *
 * O resultado da operação é exibido na tela após a execução;
 *
 * Exemplo:
 *
 *     input:
 *     array = [40, 20, 15, 35, 80, 71, 16, 21, 70]
 *     numero de maiores elementos para extrair = 5
 *
 *
 *     output = Exibindo Array de Maiores: [80, 71, 70, 40, 20]
 *
 *
 * Considerações
 *
 * 1. Uma exception do tipo IllegalArgumentException será lançada caso o array informado seja nulo ou vazio
 * 2. Uma exception do tipo IllegalArgumentException será lançada caso o arrayLength seja menor que o numero de elementos que se deseja retirar
 *
 * */

public class HeapOperationsV2 {


    public int[] maiores(final int[] myArray, final int arrayLength, final int numberOfBiggestElements) {

        if (isArrayNullOrEmpty(myArray) || arrayLength < 0 || arrayLength < numberOfBiggestElements) {
            throw new IllegalArgumentException("Array não pode ser null ou vazio e numberOfBiggestElements não pode ser maior que arrayLength");
        }

        final int[] biggest = new int[numberOfBiggestElements];

        buildMaxHeap(myArray, arrayLength);


        for (int i = 0; i < numberOfBiggestElements; i++) {
            biggest[i] = heapExtractMax(myArray, arrayLength - i);
        }

        return biggest;
    }

    public int heapExtractMax(final int[] myArray, final int arrayLength) {

        if (isArrayNullOrEmpty(myArray) || arrayLength < 0) {
            throw new IllegalArgumentException("Objeto ArrayWrapper deve conter um array que não seja null ou vazio");
        }

        final int max = myArray[0];
        myArray[0] = myArray[arrayLength - 1];

        maxHeapify(myArray, arrayLength - 1, 0);

        return max;
    }

    public void buildMaxHeap(final int[] myArray, final int arrayLength) {

        if (!isArrayNullOrEmpty(myArray) && arrayLength >= 0) {

            int halfSize = arrayLength / 2;

            for (int indexs = halfSize; indexs >= 0; indexs--) {
                maxHeapify(myArray, arrayLength, indexs);
            }
        }
    }

    public void maxHeapify(final int[] myArray, final int arrayLength, final int indexs) {

        if (!isArrayNullOrEmpty(myArray) && arrayLength >= 0) {

            int leftHeap = indexs == 0 ? ((2 * (indexs + 1)) - 1) : ((2 * indexs) + 1);
            int rightHeap = indexs == 0 ? ((2 * (indexs + 1))) : ((2 * indexs) + 2);

            int biggest = indexs;


            if ((leftHeap < arrayLength) && (myArray[leftHeap] > myArray[indexs])) {
                biggest = leftHeap;
            }

            if ((rightHeap < arrayLength) && (myArray[rightHeap] > myArray[biggest])) {
                biggest = rightHeap;
            }

            if (biggest != indexs) {
                int aux = myArray[biggest];
                myArray[biggest] = myArray[indexs];
                myArray[indexs] = aux;

                maxHeapify(myArray, arrayLength, biggest);
            }
        }
    }

    private boolean isArrayNullOrEmpty(final int[] myArray) {
        return Objects.isNull(myArray) || myArray.length < 1;
    }

    public static void main(String[] args) {

//        int[] myArray = {13, 46, 17, 34, 41, 15, 14, 23, 30, 21, 10, 12};
        int[] myArray = {40, 20, 15, 35, 80, 71, 16, 21, 70};

        int numeroDeMaioresElementosParaExtrair = 2;

        HeapOperationsV2 heapOperations = new HeapOperationsV2();

        int[] biggestElements = heapOperations.maiores(myArray, myArray.length, numeroDeMaioresElementosParaExtrair);

        System.out.println("Exibindo Array de Maiores: " + Arrays.toString(biggestElements));
    }

}

