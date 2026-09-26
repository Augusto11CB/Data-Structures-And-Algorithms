# SIN5013 - Análise de Algoritmos e Estruturas de Dados 20201005

## A estrutura de dados Heap

Heap é uma estrutura de dados que pode ser visualizada como uma **árvore binária quase completa**. Cada nó da árvore é ocupado por um elemento e temos as seguintes propriedades:

* A árvore é completa até o **penúltimo nível**
* No último nível as folhas **estão o mais à esquerda** possível
* O conteúdo de um nó é **maior ou igual** que o conteúdo dos nós na subárvore enraizada nele **(max-heap)**
* O conteúdo de um nó é **Menor ou igual** que o conteúdo dos nós na subárvore enraizada nele **(min-heap)**

**As propriedades acima garantem que os valores do heap podem ser armazenados em um array**

## Por que precisamos de algo como Heaps?

Heaps é usado principalmente para obter o valor mínimo ou máximo presente em um heap no tempo O (1).

Aqui está a complexidade de tempo de várias operações realizadas em um heap com n elementos:

* Acesso ao valor min/max: O(1)
* Inserir elemento: O(log n)
* Removendo um elemento: O(log n)

Os Heaps tornam muito rápido o acesso aos elementos de nível de prioridade. A estrutura de dados Priority Queue é implementada usando Heaps.

Casos de uso reais de Heaps:

* O sistema operacional usa heaps para agendar jobs com prioridade. 2.
* O modelo produtor-consumidor pode ser implementado usando heaps para permitir que o consumidor acesse primeiro os elementos de maior prioridade. É usado na implementação da [Blocking Priority Queue](https://www.geeksforgeeks.org/priorityblockingqueue-class-in-java/).

## Representação do Heap no Vetor

Para qualquer nó i

* `2i` é o filho esquerdo de i
* `2i + 1` é o filho direito de i ![enter image description here](../../USP/Analysis-of-Algorithms-and-Data-Structures/heap-no-array-exemplo.png)
* `|_ i/2 _|` é o pai de i
* MAX-HEAP
  * `A[|_ i/2 _|]` >= A\[i] - Garantem que o elemento max está na rais
* Número de nós no nível `p`
  * 2^p
* Altura do maior de um nó `i` é o maior comprimento de um caminho de `i` até a folha
* Altura de um nó `i`:
  * h = `|_log(m/i)`
  * i = número do nó
  * m = número total de nós

## Manutenção da Propriedade de Heap

```
```

### Equação de Recorrência

Seja h a altura do nó `i` e T(h) o consumo de tempo no pior caso

```
```

* **Pior dos casos:** No pior dos casos, o elemento que estamos tentando ajustar para manter a propriedade do HEAP, descerá até o ultimo nível da àrvore, ou seja, a complexidade está relacionada com a altura da àrvore.

### Prova Consumo de Tempo - `O(log(m))`

![consumo-tempo-heap-manutencao](../../USP/Analysis-of-Algorithms-and-Data-Structures/consumo-tempo-heap-manutencao.png)

## Construção de um Max-Heap

## References

\-[Heap JS](https://blog.bitsrc.io/implementing-heaps-in-javascript-c3fbf1cb2e65)
