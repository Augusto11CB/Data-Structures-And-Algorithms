# SIN5013 - Análise de Algoritmos e Estruturas de Dados 2020/10/12

## Cota Superior 
A notação O é utilizada para indicar o limite superior (cota superior) de problemas.

A cota superior de um problema pode mudar se alguém descobrir um outro algoritmo melhor.

A cota superior é o tempo do melhor algoritmo conhecido para o problema.

## Cota Inferior
A cota inferior é o número de operações mínimo que requer qualquer algoritmo para resolver um problema.

Se um algoritmo atinge a cota inferior, dizemos que o algoritmo é assintoticamente ótimo.

#### Introdução 
Existem algoritmos que podem ordenar n números no tempo O(nlgn).

O algoritmo Mergesort e Heapsort alcançam esse limite e o Quicksort o alcança na média. Eles são algoritmos baseados em comparações.

**Existem algoritmos melhores**
Não, se o algoritmo se baseia em comparações.

**Algoritmo baseado em comparações é:**
Um algoritmo baseia-se em comparações se o fluxo de controle do algoritmo para um vetor *depende apenas do resultado das comparações entre os elementos do vetor.*

**Qualquer algoritmo baseado em comparações deve efetuar Ω (nlogn)**
Para demonstrar a cota inferior, deve-se representar os algoritmos de ordenação por uma árvore (binária) de decisão.

#### Árvore Binária de Decisão
Seja A um algoritmo de ordenação arbitrário. Seja a1,...,an  uma sequência arbitrária de  números que são uma entrada de A.

Os `nós internos` da árvore são rotulados por pares de elementos da sequência, isto é `ai :aj` e representa uma comparação feita pelo algoritmo.

Cada uma das arestas do nó é rotulada por `≤` e `>`.

Cada `folha` é rotulada por uma `permutação de 1 a n`, que é a permutação produzida pelo algoritmo como saída, quando essa folha é atingida.

A árvore indica a ordem em que os elementos da sequência são comparados durante a execução do algoritmo A.
 
O rótulo da raiz da árvore corresponde à primeira comparação efetuada pelo algoritmo. A subárvore esquerda da raiz descreve as comparações subsequentes supondo que ai ≤ aj

##### Exemplo Árvore Decisão

![exemplo-arvore-decisao](exemplo-arvore-decisao.png)

Cada uma das 3!=6 permutações aparece nas folhas. Espera-se o mesmo para um n arbitrário.

Se uma permutação não aparecesse, então o algoritmo não conseguiria ordenar a correspondente sequência de entrada.

- **Toda árvore que representa uma algoritmo de ordenação deve ter pelo menos n! folhas.**

**Qual o número de comparações no pior caso?** 
O **número de comparações que o algoritmo faz** no pior dos casos é exatamente a **altura da árvore** de decisão.

O **número de folhas de uma árvore binária de decisão de altura h** é menor ou igual a `2^h`.  Além disso, toda árvore que representa um **algoritmo de ordenação deve ter pelo menos n! folhas.**
 
```
n! ≤ número de folhas ≤ 2h
```

#### Prova da Cota Inferior
![prova-cota-inferior](prova-cota-inferior.png)

    T(n) é Ω(nlogn)

#### Conclusão
Todo  algoritmo de ordenação baseada em comparações faz `Ω(nlogn)` comparações no pior caso.


## Ordenação em Tempo Linear
1. Ordenação Por Contagem
2.	RadixSort
3. BucketSort
 
Esses algoritmos utilizam outras operações diferentes da operação de comparação para determinar a sequência ordenada. Logo, o limite inferior Ω(nlogn) não se aplica para eles.

## Ordenação por Contagem
Suponha que sabemos que os elementos que desejamos ordenar são inteiros no intervalo [0,k].

A ideia básica é determinar para cada elemento x do vetor, o número de elementos menores que x. Essa informação pode ser usada para inserir o elemento x diretamente em sua posição no arranjo de saída.

**ex**: Se 20 elementos são menores que x, então colocaremos x na posição 21.

**Entrada, Saída e Algoritmo Features**
A entrada é um vetor A[1,...,n] e a saída é um vetor B[1,...n] com os elementos de A[1,...,n] em ordem crescente.

O algoritmo usa um vetor auxiliar C para contar quantos números têm de cada um e para determinar a posição em que o elemento deve ser colocado.

### Pseudo-código
```js
COUNTING-SORT (A, B, n, k)
1 para i ← 0 até k faça                  Θ(k)
2     C[i] ← 0 							 Θ(k)
3 para j ← 1 até n faça					   Θ(n)
4     C[A[j]] ← C[A[j]] + 1                Θ(n)
5 para i ← 1 até k faça                  Θ(k)
6     C[i] ← C[i] + C[i − 1]             Θ(k)
                                  //acumulamos os números em C. Assim, C[i] terá o número de elementos da 
								 //entrada que são menores que ou iguais a i.
7 para j ← n decrescendo até 1 faça         Θ(n)
8     B[C[A[j]]] ← A[j]						Θ(n)
9     C[A[j]] ← C[A[j]] − 1					Θ(n)
										TOTAL = Θ(k+n)
```

**Array A**
| 4 | 3 | 4 | 3 | 1 | 0 | 3 |
|---|---|---|---|---|---|---|

**Array C Resultado Após Linha 3-4**

| número no array A | 0 | 1 | 2 | 3 | 4 |
|-------------------|---|---|---|---|---|
|contador do # elemt| 1 | 1 | 0 | 3 | 2 |


**Array Acumulador C Resultado Após Linha 5-6**
| número no array A | 0 | 1 | 2 | 3 | 4 |
|-------------------|---|---|---|---|---|
| acumulador        | 1 | 2 | 2 | 5 | 7 |


### Consumo de Tempo 
TOTAL = Θ(k+n)

## 2.	RadixSort
Suponha que sabemos que os elementos que desejamos ordenar têm **d dígitos**.

A ideia básica é **ordenar em função dos dígitos**, um de cada vez, **começando pelo dígito menos significativo**. Desse modo, apenas d passagens pela lista são necessárias para fazer a ordenação.

![enter image description here](radixsort-example.png)

### Pseudo-código
```js
RADIX-SORT (A, n, d)
1 para i ← 1 até d faça            Θ(d)
2 ordene A[1 . . n] pelo dígito i  Θ(d(n+k)) // Se cada dígito está no intervalo de 0 a k-1 
								             // e k não é muito grande podemos usar a ordenação por contagem.
								   TOTAL: Se d é uma constante e k=O(n), Radixsort é linear.
```

### Consumo de Tempo 
TOTAL = O(n)

## BucketSort
Suponha que sabemos que os elementos que desejamos ordenar foram gerados aleatoriamente de forma uniforme no intervalo [0,1).

- A ideia básica é:
- Dividir o intervalo em n buckets.
- Distribuir os n números entre os buckets.
- Ordenar os números em cada bucket usando ordenação por inserção.

### Consumo de Tempo 
Se as entradas forem uniformemente distribuídas, então o número esperado de elementos em cada bucket é Θ (1). Logo o consumo de tempo esperado para ordenar cada bucket é Θ(1).
 
Logo, o consumo de tempo do Bucketsort é Θ(n).
