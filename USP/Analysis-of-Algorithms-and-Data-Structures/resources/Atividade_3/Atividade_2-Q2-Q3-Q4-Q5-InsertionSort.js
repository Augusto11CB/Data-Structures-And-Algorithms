console.log("Starting InsertionSort");

/*
1 ORDENA-POR-INSERÇÃO (A, n)
2    para j ← 2 até n faça
3          chave ← A[j]
4          i ← j − 1
5         enquanto i ≥ 1 e A[i] > chave faça
6                A[i + 1] ← A[i]
7                i ← i − 1
8         A[i + 1] ← chave

Depois da primeira iteração do algoritmo ORDENA-POR-INSERÇÃO para o vetor A = [4,6,2,10,9,8,15,18,12,5] e n=10, 

o vetor fica assim A = [6,4,2,10,9,8,15,18,12,5].
*/

function insertionSort(myArray, arrayLength) {

    console.log(`[Starting insertionSort] 
                    myArray: ${myArray}  
                    arrayLength: ${arrayLength}\n`
                )
    for (j = 1; j < arrayLength; j++) {
        let key = myArray[j];

        let index = j - 1;

        while (index >= 0 & myArray[index] > key) {
            console.log(`[Inside while] - Index: ${index} Value: ${myArray[index]}`)

            myArray[index + 1] = myArray[index];
            index = index - 1;
            console.log(`[Inside while][End Iteration] Status myArray: ${myArray}`)
        }

        myArray[index + 1] = key;
        console.log(`[End "For" Iteration] Status myArray: ${myArray} - Index: ${index} - J: ${j}`)

    }
}

let myArray = [6, 4, 2, 10, 9, 8, 15, 18, 12, 5];

insertionSort(myArray, myArray.length);


/* 
Q4 - Em qualquer iteração do algoritmo ORDENA-POR-INSERÇÃO o sub-vetor da esquerda da posição “j” está desordenado.
Answer: Falso

Q3 - Em algum passo do algoritmo ORDENA-POR-INSERÇÃO para o vetor A = [4,6,2,10,9,8,15,18,12,5] e n=10, o vetor fica assim A = [2,4,6,8,9,10,12,15,18,5].
Answer: Verdadeiro
 
Q2 - Depois da primeira iteração do algoritmo ORDENA-POR-INSERÇÃO para o vetor A = [4,6,2,10,9,8,15,18,12,5] e n=10, o vetor fica assim A = [6,4,2,10,9,8,15,18,12,5].
Answer: Verdadeiro

*/
