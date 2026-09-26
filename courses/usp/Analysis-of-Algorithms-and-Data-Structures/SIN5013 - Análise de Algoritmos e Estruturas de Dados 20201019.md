# SIN5013 - Análise de Algoritmos e Estruturas de Dados 20201019

## Backtracking
Backtracking ou tentativa e erro é um técnica para encontrar uma ou todas as soluções de um problema de forma recursiva.

Cada solução é construída incrementalmente (passo-a-passo) e a obtenção desta solução pode ser vista como uma sequência de passos ou decisões.

### Onde usar?** 
- Problemas cujas soluções ao caracterizadas por uma sequência de decisões, cada uma delas feita sobre um conjunto de várias possibilidades.
- soluções são representadas por tuplas (vetores) de tamanho fixo ou variável da forma (x1,... , xn).
- uma tupla é dita viável se ela atende ao conjunto de restrições explícitas e implícitas que definem o problema. 
- Solucionar o problema equivale a encontrar uma (ou toda) tupla viável

### Origem do nome
backtracking Durante a execu¸c˜ao de um algoritmo de backtracking, pode-se chegar a um estado cuja seq¨uˆencia de decis˜oes torna vazio o dom´ınio de uma vari´avel da tupla sem que as restri¸c˜oes implicitas tenham sido satisfeitas. Neste caso, o algoritmo retrocede (≡ faz um backtracking), revertendo a ´ultima decis˜ao tomada e escolhendo um novo valor do dom´ınio para uma vari´avel correspondente a ela. Se todas as poss´ıveis escolhas tiverem sido tentadas, o algoritmo retrocede novamente.


### Encontrando uma Solução
- Começamos com uma solução parcial vazia.
-  Em cada momento temos uma solução parcial do problema.
-  Tentamos estender essa solução parcial, isto é, tomar mais uma decisão que nos aproxime da solução.
-  Se encontrarmos uma solução completa, devolvemos a solução.
-  Se não é possível estender a solução parcial, voltamos no caminho e tomamos uma outra decisão

### Pseudocódigo

```
TENTAR (soluçãoParcial)
	se soluçãoParcial = soluçãoCompleta
		devolva SUCESSO
	para cada possibilidade/ação
		se é aceitável
			estender(soluçãoParcial)
			rpta=TENTAR (soluçãoParcial)
			se rpta=SUCESSO
				devolva SUCESSO
			desfazer ação
	devolva INSUCESSO
```

### Passeio do cavalo
Dado um tabuleiro de xadrez `n*n` e uma posição inicial (x0,y0) do tabuleiro, deseja-se encontrar um passeio do cavalo que visite cada casa do tabuleiro uma única vez.

### Problema da Mochila Binária
Um ladrão encontra n itens. Cada item `i` vale `vi` reais e pesa `wi` quilos. Ele quer levar o máximo de valor possível, porém só pode carregar no máximo `W` quilos na mochila.
- TODO Add formula
- em que xi é a quantidade dos itens que está sendo carregado.
