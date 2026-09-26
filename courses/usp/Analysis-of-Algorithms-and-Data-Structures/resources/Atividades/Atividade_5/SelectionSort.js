function selectionSort(myArray, n) {
    if (n > 0) {                                    //n=0: +0  
        let postMax = 0;
        for (let i = 1; i < n; i++) {               
            if (myArray[i] > myArray[postMax]) {    // n>0: +(n-1)
                postMax = i;
            }
        }

        if ((n - 1) !== postMax) {
            let temp = myArray[n - 1];
            myArray[n - 1] = myArray[postMax];
            myArray[postMax] = temp;
        }

        selectionSort(myArray, n - 1);              // n>0: +(1*T(n-1))
    }
} 


let myArry = [1,6,3,2,9,12,4];
selectionSort(myArry, myArry.length);
console.log(myArry);

/*
Q1 - Denote por T(n) o número de comparações 'A[i] > A[posMax]' executadas na linha 4 do algoritmo ORDENA-POR-SELEÇÃO(A, n).
T(n)= ____ para n=0
T(n)= ____ para n>0

Answer:
T(n)= 0 para n=0
T(n)= T(n-1) + n - 1 para n>0
*/