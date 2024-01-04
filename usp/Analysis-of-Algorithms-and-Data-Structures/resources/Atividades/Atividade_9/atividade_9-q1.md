# Answer Q1

## Q1
Escreva um pseudocódigo que, dados n inteiros com valores entre 1 e k, pré-processe esses
inteiros e então (descontado o tempo do pré-processamento) responda perguntas da forma:

“dados a, b, quantos dos n inteiros estão no intervalo [a , b]?”

A resposta a esse tipo de perguntas deve ser feita em tempo O(1) e o pré-processamento deve ser feito em tempo O(n+k).

**Answer:** 

```
preProcessing(A, k)
    B = getArray(k)

    FOR i=1 TO k                                 Θ(k)
        B[i]=0                                   Θ(k)

    FOR j=1 TO A.length                          Θ(n)
        B(A[j]) = B(A[j]) + 1                    Θ(n)
    
    FOR i=2 TO k                                 Θ(k)       
        B[i]=B[i]+B[i-1]                         Θ(k)

    return B                                     Θ(1)

// preProcessing Total = Θ(k+n)

getNumberOfIntegersIntoRange(A, a, b, k)

    B = preProcessing(A,k)                       Θ(k+n)

    return B[b] - B[a-1]                         O(1)

```