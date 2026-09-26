import java.util.Arrays;
import java.util.Objects;


/* * *   Comentários e informações 
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
 *
 * */

public class HeapOperations {


    public int[] maiores(final int[] myArray, final int numberOfBiggestElements) {

        if (isArrayNullOrEmpty(myArray)) {
            throw new IllegalArgumentException("Array não pode ser null ou vazio");
        }

        final int[] biggest = new int[numberOfBiggestElements];

        buildMaxHeap(myArray);

        ArrayWrapper wrapper = new ArrayWrapper(myArray);

        for (int i = 0; i < numberOfBiggestElements; i++) {
            biggest[i] = heapExtractMax(wrapper);
        }

        return biggest;
    }

    public int heapExtractMax(final ArrayWrapper wrapper) {
        // Time consumption O(log(arraySize))

        if (Objects.isNull(wrapper) || isArrayNullOrEmpty(wrapper.getMyArray())) {
            throw new IllegalArgumentException("Objeto ArrayWrapper deve conter um array que não seja null ou vazio");
        }

        final int max = wrapper.getMyArray()[0];

        int[] auxArray = new int[wrapper.getMyArray().length - 1];
        System.arraycopy(wrapper.getMyArray(), 1, auxArray, 0, wrapper.getMyArray().length - 1);
        wrapper.setMyArray(auxArray);

        maxHeapify(wrapper.getMyArray(), 0);

        return max;
    }

    public int heapExtractMax(final int[] myArray) {
        // Time consumption O(log(arraySize))

        if (isArrayNullOrEmpty(myArray)) {
            throw new IllegalArgumentException("Objeto ArrayWrapper deve conter um array que não seja null ou vazio");
        }

        final int max = wrapper.getMyArray()[0];

        int[] auxArray = new int[wrapper.getMyArray().length - 1];
        System.arraycopy(wrapper.getMyArray(), 1, auxArray, 0, wrapper.getMyArray().length - 1);
        wrapper.setMyArray(auxArray);

        maxHeapify(wrapper.getMyArray(), 0);

        return max;
    }


    public void buildMaxHeap(final int[] myArray) {

        if (!isArrayNullOrEmpty(myArray)) {

            int halfSize = myArray.length / 2;

            for (int indexs = halfSize; indexs >= 0; indexs--) {
                maxHeapify(myArray, indexs);
            }
        }
    }

    public void maxHeapify(final int[] myArray, final int indexs) {

        if (!isArrayNullOrEmpty(myArray)) {

            int leftHeap = indexs == 0 ? ((2 * (indexs + 1)) - 1) : ((2 * indexs) + 1);
            int rightHeap = indexs == 0 ? ((2 * (indexs + 1))) : ((2 * indexs) + 2);

            int biggest = indexs;


            if ((leftHeap < myArray.length) && (myArray[leftHeap] > myArray[indexs])) {
                biggest = leftHeap;
            }

            if ((rightHeap < myArray.length) && (myArray[rightHeap] > myArray[biggest])) {
                biggest = rightHeap;
            }

            if (biggest != indexs) {
                int aux = myArray[biggest];
                myArray[biggest] = myArray[indexs];
                myArray[indexs] = aux;

                maxHeapify(myArray, biggest);
            }
        }
    }

    private boolean isArrayNullOrEmpty(final int[] myArray) {
        return Objects.isNull(myArray) || myArray.length < 1;
    }

    /**
     * InnerClass utilitária para armazenar o array utilizado no método heapExtractMax
     */
    public class ArrayWrapper {

        private int[] myArray;

        public ArrayWrapper(int[] myArray) {

            this.myArray = myArray;
        }

        public int[] getMyArray() {
            return myArray;
        }

        public void setMyArray(int[] myArray) {
            this.myArray = myArray;
        }

        public int length() {
            return this.myArray.length;
        }
    }

    public static void main(String[] args) {

//        int[] myArray = {13, 46, 17, 34, 41, 15, 14, 23, 30, 21, 10, 12};
        int[] myArray = {40, 20, 15, 35, 80, 71, 16, 21, 70};

        int numeroDeMaioresElementosParaExtrair = 5;

        HeapOperations heapOperations = new HeapOperations();

        int[] biggestElements = heapOperations.maiores(myArray, numeroDeMaioresElementosParaExtrair);

        System.out.println("Exibindo Array de Maiores: " + Arrays.toString(biggestElements));
    }

}

