# SIN5013 - Análise de Algoritmos e Estruturas de Dados 20201026

## Programação Dinâmica 

2026(dinâmica), 3095(guloso), 3107(caminhos mínimos), 1790(grafos), 1843(tentativa e erro), 2720 (ordenação), 2115

## Algoritmos Gulosos
Algoritmos gulosos são algoritmos que constroem uma solução "pedaço por pedaço", sempre escolhendo a próxima peça que oferece o benefício mais óbvio e imediato.

Algoritmos gulosos são em geral mais eficientes do que outras técnicas, como a programação dinâmica. Mas os algoritmos Greedy nem sempre podem ser aplicados. 

Por exemplo, o problema da [mochila fracionária](http://www.cs.binghamton.edu/~dima/cs333/knapsack.ppt) pode ser resolvido usando Greedy, mas o problema da [mochila binária](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/) não pode ser resolvido usando Algoritmos gulosos.

### Características desta técnica:
- Costuma ser aplicada a problemas de otimização: encontrar soluções viáveis que sejam ótimas de acordo com uma função objetivo. 
- Baseia-se na extensão de soluções parciais: escolhe-se a que propicia o maior ganho imediato (daí o nome de “guloso”; mais propriamente, “ganancioso”).
- Não proporciona necessariamente uma solução ótima: é preciso uma demonstração para cada problema. Por outro lado, basta um contraexemplo para verificar que falha.

Exemplos: Dijkstra, Kruskal e Prim.

### Características do problema para que o algoritmo guloso seja aplicado 
- Subestrutura ótima: se uma solução ótima para o problema contém em seu interior soluções ótimas para subproblemas.
- Propriedade de escolha gulosa: um problema tem essa propriedade se uma solução globalmente ótima pode ser alcançada fazendo-se uma escolha localmente ótima (gulosa).


### Etapas para projetar um algoritmo guloso
1. Modelar o problema de modo que fazemos uma escolha gulosa restando apenas um subproblema para ser resolvido.
2. Provar que sempre existe uma solução ótima para o problema original que usa a escolha gulosa de modo que essa escolha é segura.
3. Demonstrar que tendo feito uma escolha gulosa o que resta é um subproblema com a seguinte propriedade: se combinamos uma solução ótima para o subproblema com escolha gulosa que fizemos, chegamos a uma solução ótima para o problema original.


