
# SIN5013 - Análise de Algoritmos e Estruturas de Dados 2020/08/31

# Projeto e Análise de Algoritmos

## Algoritmo
É um procedimento computacional bem definido, que recebe um conjunto de valores como entrada e produz um conjunto de valores como saida.

É uma ferramenta para resolver problemas computacionais.

## Problema e instâncias
Um problema é definido por:
- uma descrição dos parâmetros
- uma descrição sobre as propriedades que a resposta deve satisfazer

Uma **instancia de um problema** é obtida ao fixar valores para todos os parâmetros do problema

#### Exemplo
**Problema:** Ordenar uma sequencia a1,a2,...,an de maneira crescente.
- **Entrada:** a1,a2,...,an
- **Saída:** a'1, a'2, ..., a'3
- **Propriedades:** a'1, a'2, ..., a'3 é uma permutação de a1, a2, ..., an tal que a'1<= a'2<=  ... <= a'n

**Instância:** 10 20 5 40 4
						 4 5 10 20 40
 
## Corretude do algoritmo
Um alg. é **correto** (resolve o problema) se, para toda instância de entrada, o algoritmo termina e produz uma saída que satisfaz as propriedades do problema.

### Prova da Corre tude
- Alg. Iterativos: Utiliza-se a técnica dos **invariantes do laço**. Trata-se de uma property que é `true` antes, durante e após a execução do laço;
- Alg. Recursivos: Utiliza-se a técnica de **indução matemática ** no tamanho das instâncias. 

## Consumo de Tempo
Seja `T(n)` o consumo de tempo (no pior caso, ou melgor, ou caso médio) do algoritmo `A`, para instancias de tamanho `n`.

Como pretendemos medir a ordem de grandeza da função de tempo do algoritmo. Precisamos de um modo para comparar funções que considere as suas **velocidade de crescimento**.

O - comparação com ideia de "<="
Θ -  comparação com ideia de ">=" 
Ω -  comparação com ideia de "= "

### Notação O
`O(f(n))` intuitivamente são funções que não crescem mais rápido que `f(n)`

Exemplo: n^2 + 3n - 3 é  `O(n^2)`


- TODO [Finish Lesson](https://youtu.be/ojCAnD7vrOY?list=PLxI8Can9yAHdNN5fpKWRF8bbLG-2P-0LW&t=717)

### Exemplo - Ordenação-por-Inserção 
Rearranjar um vetor A[1 .. n] de modo que ele fique em ordem crescente.
```java
//Ordenação-por-Inserção (A, n)
para j := 2 até n    
	x := A[j]
	i := j−1
	//laço
	enquanto i > 0 e A[i] > x
		A[i+1] := A[i]
		i := i−1
	A[i+1] := x
```

#### Invariantes
- o vetor A[1 .. j−1] é crescente. 
	- Esse invariante é trivialmente verdadeiro na primeira repetição do "para"(pois j = 2 nesse caso). Se o invariante for verdadeiro na última repetição do "para" (quando j = n+1) então nosso problema está resolvido.

#### Analise do Tempo - por atribuição
```java
//Ordenação-por-Inserção (A, n)
para j := 2 até n                //n   
	x := A[j]					 // n-1
	i := j−1                     // n-1
	//laço
	enquanto i > 0 e A[i] > x    //
		A[i+1] := A[i]           // 1+2+3+ ...+ n-1
		i := i−1                 // 1+2+3+ ...+ n-1
	A[i+1] := x                  // n-1
```

**Somando os tempos temos:** n^2 + 3n -3

#### Analise do Tempo - por número de execuções de cada linha
```java
//Ordenação-por-Inserção (A, n)
para j := 2 até n                //n   
	x := A[j]					 // n-1
	i := j−1                     // n-1
	//laço
	enquanto i > 0 e A[i] > x    // 2+3+ ...+ n
		A[i+1] := A[i]           // 1+2+3+ ...+ n-1
		i := i−1                 // 1+2+3+ ...+ n-1
	A[i+1] := x                  // n-1
```

**Somando os tempos temos:** (n^2 + 7n -8) / 2
