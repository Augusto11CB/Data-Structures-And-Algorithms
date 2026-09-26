# Answer Q2 and Q3

## Q2 
**Na pilha de execução  quando o algoritmo abaixo é chamado com A=[3,5,4,-1] e n= 4 serão criados apenas espaços de trabalho para SomaPositivos(A,4), SomaPositivos(A,3), SomaPositivos(A,2) e SomaPositivos(A,1).**

```
SomaPositivos(A,n)
se n = 0
    devolva 0

senão s <-- SomaPositivos (A, n - 1)
          se A[n] > 0
               devolva s + A[n]
          senão devolva s
```
- [] true
- [x] false

**Answer:** Falso, pois para se chegar no passo base do algoritmo SomaPositivos, o espaço de trabalho para SomaPositivos(A,0) precisa ser criado.


## Q3
**Algoritmos iterativos em geral possuem maior custo de memória que sua versão recursiva.**

**Answer:** Essa afirmação é falsa, pois a cada chamada recursiva cria-se uma nova instância da função que será executada em um novo espaço de trabalho, e que por sua vez terá suas próprias variáveis, objetos, etc. 

Portanto, como se cria, para cada chamada recursiva, uma nova "instancia" da função (ou em outras palavras um novo espaço de trabalho), isso faz com que o consumo de memória computacional seja maior. 

Tal comportamento é diferente para algoritmos iterativos, que não expandem os "espaços de trabalho" realizando chamadas recursivas.