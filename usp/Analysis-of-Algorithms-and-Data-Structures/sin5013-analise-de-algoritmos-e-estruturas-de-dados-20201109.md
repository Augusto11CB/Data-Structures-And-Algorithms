# SIN5013 - Análise de Algoritmos e Estruturas de Dados 20201102

## Grafos
### Conceitos basicos
Um grafo é uma abstração que permite codificar relacionamentos entre pares de objetos (definição informal).

**Em que:**
- Os objetos são os vértices do grafo.
- Os relacionamentos são as arestas do grafo.

Ex:
- Obj: Cidades | Relacionamento: Voo comercial entre duas cidades
- Obj: Web Page | Relacionamento: Link de uma web page para outra

**Motivação** 
- Quantos caminhos existem para ir da cidade x até a cidade y?
- Qual é o menor caminho entre x e y?
- Existe um caminho para ir de uma cidade a outra?
Vértices: cidades
Arestas: estradas entre as cidades

### Definição de Grafo
Formalmente um grafo G é definido por:

`G=(V,A)`

**Em que:**
– V é o conjunto de vértices
– A é o conjunto de arestas

#### Grafo Direcionado
Um grafo direcionado G é um par (V,A), em que:

– V é um conjunto finito de vértices
– A é uma relação binária em V (i.e., uma aresta é um par ordenado de  vértices)

#### Grau de um Vértice em grafos Direcionados
- **Grau de saída:** número de arestas que saem do vértice.
- **Grau de entrada:** número de arestas que chegam no vértice.
- **Grau de um vértice:** grau de saída + grau de entrada.

#### Grafo Não Direcionado
Um grafo não direcionado G é um par (V, A), em que:

– O conjunto de arestas A é constituído de pares de vértices não ordenados.
– As arestas (u, v) e (v , u) são consideradas como uma única aresta.
- A relação de adjacência é simétrica. Self-loops não são permitidos.

#### Grau de um Vértice em grafos Não Direcionados
- O grau de um vértice é o número de arestas que incidem nele.

### Grafos Densos
#### Representação Mais Indicada - Matriz de Adjacências
- TODO - Slide 27

### Grafos Esparsos
#### Representação Mais Indicada - Coleção de Listas de Adjacências
Os vértices de uma lista de adjacência são, em geral, armazenados em uma ordem arbitrária.

A soma dos comprimentos de todas as listas de adjacência
- Se G é um grafo orientado é: `|A|`
- Se G é um grafo não orientado é: `2*|A|`
O espaço requerido por essa representação é:

`O(|V| + |A|)` - Pois haverá uma coleção de tamanho `V` e haverão listas cujo a soma total para o pior caso (grafo não orientado) será `2*|A|`

#### Conclusão Grafos Esparsos e lista de Adjacências
Representação mais adequada para grafos esparsos ( quando |A| é muito menor do que |V|2).

É compacta e usualmente utilizada na maioria das aplicações.

**Desvantagem:** pode consumir O(|V|) para determinar se existe uma aresta entre o vértice i e o vértice j, pois podem existir O(|V|) vértices na lista de adjacentes do vértice i. 

## Busca em Grafos
### Motivação
**Problema fundamental em grafos:**
Como explorar um grafo de forma sistemática?

Muitas aplicações são abstraídas como problemas de busca.
Os algoritmos de busca em grafos são a base de vários algoritmos mais gerais em grafos. 

### Busca em Largura - Breadth-First-Search (BFS)

Seja G = (V , A) e um vértice s, o algoritmo de busca em largura (breadth-first-search - BFS) percorre as arestas de G descobrindo todos os vértices atingíveis a partir de s.

BFS determina a distância (em número de arestas) de cada um desses vértices a s.

**Antes de encontrar um vértice à distância k+1 de s, todos os vértices à distância k são encontrados.**

BFS produz uma árvore BFS com raiz em s, que contém todos os vértices acessíveis determinando o caminho mais curto (caminho que contém o número mínimo de arestas) de s a t (em que t é um vértice acessível).

#### BFS - Pseudo-Codigo
```java
BFS(V, A, s)
1. for each u in V − {s} ▷ para cada vértice u em V exceto s
2.      color[u] ← WHITE ▷ no início todos os vértices são brancos
3.      d[u] ← infinity
4.      π[u] ← NIL
5. color[s] ← GRAY ▷ Vértice origem descoberto
6. d[s] ← 0
7. π[s] ← NIL
8. Q ← {}
9. ENQUEUE(Q, s) ▷ Colocar o vértice origem na fila Q
10 while Q is non-empty ▷ Enquanto existam vértices cinzas
11.     u ← DEQUEUE(Q) ▷ i.e., u = primeiro(Q)
12.     for each v adjacent to u ▷ para cada vértice adjacente a u
13.         if color[v] = WHITE ▷ se é branco (ele ainda não foi descoberto)
14.         then color[v] ← GRAY
15.              d[v] ← d[u] + 1
16.              π[v] ← u ▷ pai de v é o nó que levou à descoberta de v
17.              ENQUEUE(Q, v)
18.     color[u] ← BLACK ▷ os vizinhos de u já foram examinados
```

- (10 - 18) 
    - Cada vértice é colocado na fila no maximo uma vez e portanto retirado da fila no máximo uma vez
    - As operações DEQUEUE e ENQUEUE demoram tempo O(1). Assim o tempo total de operações na fila é: O(V)
    - A lista de adjacencias de cada vertice é examidado somente quando o vértice é desenfileirado, a lista de adjacências de cada vertice é examinada no maximo uma vez
    - Assim o tempo gasto na varredura total das listas de adjacencia é O(A)
    - O tempo gasto na varredura total das listas de adjacências é: O
- (1 - 9)
    - A inicialização é O(V)

#### Tempo BFS
O tempo total da busca em largura é O(V+A)

TODO - Get Print Slide 6


### Busca em Profundidade - DFS