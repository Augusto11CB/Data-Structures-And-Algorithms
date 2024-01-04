# SIN5013 - Análise de Algoritmos e Estruturas de Dados 2020/09/21

## Solução de Recorrências

### Revisão
Uma recorrência (= _recurrence_) é uma expressão que dá o valor de uma função num dado ponto em termos dos valores da mesma função em pontos anteriores.

### Resolução de Recorrência
Resolver uma recorrência é encontrar uma **fórmula fechada que dê o valor da função diretamente em termos do seu argumento**. Tipicamente, a fórmula fechada é uma combinação de polinômios, quocientes de polinômios, logaritmos, exponenciais, etc.

### Teorema Mestre

### Método da Iteração
Consiste em expandir, isto é, iterar a recorrência e escrevê-la como uma somatória de termos que dependem apenas de `n`.

#### Exemplo 1
**Recorrência**: F(n) = F(n/2) + 3

> A recorrência faz sentido se n pertence ao conjunto {2^ 1, 2^ 2, 2^3}, pois não faz sentido tomar n no conjunto {2, 3, 4, 5, … } pois n/2 não pertence a esse conjunto quando n é ímpar.

**Nova Recorrência**: F(2k) = F(2k−1) + 3

Obtendo a fórmula fechada através do método da iteração:

F(2k)	=	F(2^(k−1)) + 3
 	=	F(2^(k−2)) + 3 + 3
 	=	F(2^(k−3)) + 3 + 3 + 3
 	=	`F(2^(k−k)) + 3k` =  	`F(2^0) + 3k`
 	=	5 + 3k .

Como **k = lg n**, temos
```
F(n) = 5 + 3 lg n.
```

#### Exemplo 2
- TODO

#### Exemple 3
- TODO

#### Exemple 4
![metodo-iteracao-ex1](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/blob/master/USP/Analysis-of-Algorithms-and-Data-Structures/resources/Imagens/metodo-iteracao-ex1.png)

### Árvore de recorrencia 
Neste método, desenhamos uma árvore de recorrência e calculamos o tempo gasto por cada nível da árvore. Por fim, somamos o trabalho realizado em todos os níveis. Para desenhar a árvore de recorrência, partimos da recorrência dada e continuamos desenhando até encontrar um padrão entre os níveis. O padrão é normalmente uma série aritmética ou geométrica.

Para obter o trabalho total, basta somar os números em cada nó.
#### Exemplo 1

```
T(n) = 3T(n/4) + cn2

                  cn2                              
            /      |      \      
       T(n/4)   T(n/4)     T(n/4)
     /   |   \            
 T(n/8) T(n/8) T(n/8)  
 / | \     
```

```
T(n) = 3T(n/4) + cn2

|		                   cn^2    ----------------------- c*n^2
|			            /   |   \       
|	    	           /    |    \                 
|	        	      /     |     \      
log4_n	     c(n/4)^2   c(n/4)^2   c(n/4)^2 ------------- 3/16*c*n^2
|		     /    |    \
|		    /     |     \
|		   /      |      \    
|	c(n/16)^2 c(n/16)^2 c(n/16)^2  ------------------------------ ((3/16)^2)*c*n^2
|	/  |  \     
   .
   .
   .   
  T(1)	T(1)  T(1) .... 
  | -------------------------------- 3^(log4_n)  | -------------------------------- 
```
- Quando chegar no caso base `T(1) = T(n/4^i)`
	- `n = 1 when n/4^i => i = log4_n`
-  O número de nós na profundidade i é `3^i`
- Cada nó na profundidade i = 0, 1 ,. . . , log4_(n - 1) tem custo de `c(n/4^i)^2`
- Cada uma das folhas contribuem com T(1), então temos `3^(log4_n) = N^(log4_3)`
	- nivel 0 -> temos um nó
	- nivel 1 -> temos 3 nós
	- nivel 2 -> temos 9 nós
	- nivel log4_n (ultimo nivel da arvore) -> temos `3^(log4_n)`

![metodo-arvore-exemplo1](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/blob/master/USP/Analysis-of-Algorithms-and-Data-Structures/resources/Imagens/metodo-arvore-exemplo1.png)

#### Exemplo xyz

```
T(n) = T(n/4) + T(n/2) + cn2

                  cn2
            /            \      
       c(n2)/16          c(n2)/4
       /      \            /      \
c(n2)/256   c(n2)/64  c(n2)/64    c(n2)/16
 /    \      /    \    /    \       /    \
```

### Método da Substituição
O método começa com um "chute" para o valor de T(n).

Após isso, é demonstrado por  **indução** que o "chute" está certo.

![metodo-substituicao-exemplo1](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/blob/master/USP/Analysis-of-Algorithms-and-Data-Structures/resources/Imagens/metodo-substituicao-exemplo1.png)

## References
[Recorrência - IME USP](https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/recurrence.html)
[Recurrence - Duke University](https://users.cs.duke.edu/~ola/ap/recurrence.html)
