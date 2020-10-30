Valor final(V), numero moedas(M)

M moedas 

6 6 

1,2,5,3,7,3

23 43 23(24) 43 2 3 11 57


#########################
ValOt(i-1,V)    se valor[i]>V
max(ValOt(i-1,V), ValOt(i-1,Y-valor[i])+valor[i]) se w[i]<=Y

mochila (w,v,i,V)
    se i=0 ou V=0
        devolva 0
    //não é possível colocar o objeto
    se w[i]>V
        devolva mochila (w,v,i-1,V)
    //é possível colocar o objeto
    naousa=mochila (w,v,i-1,Y)
    usa=mochila (w,v,i-1,Y-w[i])+v[i]
    devolva max {naousa,usa}
##########################

// TODO Adaptar problema mochila para pegar o valor certo

mochila (v',M,V)
1,2,5,3,7,3
 // Inicializar Matriz 'ValOt' com 0
	// Linhas = M
	// Colunas = V
    para i ← 1 até M faça
        para Y ← 1 até V faça
            se v'[i]>Y
                ValOt[i,Y] ← ValOt[i-1,Y]
            senão naousa ← ValOt[i-1,Y]
                  usa ← ValOt[i-1,Y-v'[i]] + v'[i]
                 ValOt[i,Y]←max{naousa,usa}
    devolva ValOt[n,W]

respostaMochila (v',M,V,ValOt)
    Y ← V
    para i ← M até 1 faça
        se ValOt[i,Y]= ValOt[i-1,Y]
            x[i] ←0
        senão x[i] ←1
              Y ← Y - v'[i]
    devolva x