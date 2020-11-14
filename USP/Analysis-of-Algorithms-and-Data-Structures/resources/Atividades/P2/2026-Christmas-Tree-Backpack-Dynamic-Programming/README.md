[URI - 2026 - Árvore de Natal](https://www.urionlinejudge.com.br/judge/pt/problems/view/2026)

Talvez tratar o problema de um pacote de peso x ter p itens de peso x/p como fractional-knapsack
- https://www.geeksforgeeks.org/unbounded-fractional-knapsack/
- https://www.geeksforgeeks.org/fractional-knapsack-problem/

Ou talvez tratar o problema como algo que permita a repetição de itens, mas cuidado, oq cada pacote um um numero limitado de itens
- https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

Ou talvez tratar como Existe N itens e uma mochila com capacidade de V. O i-ésimo item tem no máximo n [i] peças disponíveis, e o i-ésimo item tem um peso de w [i] e um valor de v [i].
- https://www.programmersought.com/article/2491624687/



G = # de galhos & # de testes
p = # pacotes               ------- N items 
w = peso suportado pelo galho 1 < W < 1000    ------- V
// virão a seguir P linhas
[número de enfeites do pacote][peso do pacote] ------- [n[i] pieces] [i-th item was w[i]]


for(int i=0; i<N; i++){
        
        for(int j=V; j>=w[i]; j--){ // se o peso do pacote for menor ou igual ao peso suportado pelo galho 
                                    // diminui o peso do galho a cada iteração


            for(int k=1; k<=n[i] && k*w[i]<=j; k++){
                
                f[j] = max(f[j], f[j-k*w[i]] + v[i]*k);

            }
        }
}


