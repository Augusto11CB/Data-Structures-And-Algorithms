# Atividade 4
## Q1 - Demonstrar que 2n+1 é  Ω(2n).

Afirmação `2^n+1` é `Ω(2n)`.

Prova: Necessário escolher contantes `c` e `n0`, tal que:

                            `2^(n + 1) >= c * 2^n` (para qualquer n >=n0)

Portanto, se escolhido `c = 1` e `n0 = 1`, então a inequação mostra-se verdadeira.

## Q2 - Seja T(n) o número de operações de multiplicação realizadas pelo algoritmo que multiplica as matrizes A e B de tamanho nxn. Pode-se afirmar que T(n) = n3 , T(n) é O(n3), T(n) é Ω(n3) e  T(n) é Θ (n3).  

```
Multiplica(A, B, n)

    para i=1 até n
        para j=1 até n
            C[i,j] = 0
            for k=1 até n
                C[i,j] = C[i,j] + A[i,k] * B[k,j]
    devolva C
```

- [X] Verdadeiro
- [ ] Falso

## Q3 -  n + 1000 é O(n)
- [X] Verdadeiro
- [ ] Falso

## Q4 - 100n² + 10000000 é Ω(n² lg n)
- [X] Verdadeiro
- [ ] Falso

## Q5 - 3n é O(n)
- [ ] Verdadeiro
- [X] Falso