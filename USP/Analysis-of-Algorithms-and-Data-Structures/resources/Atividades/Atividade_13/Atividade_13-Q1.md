Considerando que uma árvore é um grafo conexo e acíclico, modifique o algoritmo DFS (a seguir) para verificar se um grafo com n vértices (dada sua lista de adjacentes) é uma árvore. O algoritmo deve devolver SIM caso o grafo de entrada é uma árvore e NÃO caso contrário.


DFS (V, A)

    for each vertex u in V                

        color[u] ← WHITE

        π[u] ← NIL

    time ← 0

    for each vertex u in V

        if color[u] = WHITE //(?)

            if DFS-Visit(u) = true
                return "NÃO"
    
    result = 0;
    for each vertex u in V
        if π[u] = NIL
            result = result + 1
    
    if result > 1 
        return "NÃO"
    else 
        return "SIM"
 

DFS-Visit(u)

    // Ao invez de tratarmos os vertices "ilhados" na função DFS após chamar o DFS-Visit para todo vertice em V, talvez
    // fosse melhor validar aq mesmo se o vertice um pai; se ele não tiver um pai ele pode ser a raiz ou um vertice ilhado
    // dai além de u, passariamos uma variavel global marcando "quantos vertices órfãos" temos. Se haver mais de 1 significa
    // que além da "raiz" temos esses vertices ilhas
    result = false

    color[u] ← GRAY                         

    time ← time + 1

    d[u] ← time  // tempo em que vertice U é acessado

    for each vertex v adjacent to u   // adicionando adjacentes não visitados na fila 
        
        if color[v] = WHITE 
            π[v] ← u // Adiciona vertice u como parent de v
            
            if DFS-Visit(v) = true // Recursa sobre o vertice adjacente
                result = true
                BREAK
        
        if π[u] != v // é visitado mas não é o parent então tem ciclo, logo não é uma arvore  
                result = true
                BREAK
    
    color[u] ← BLACK
    
    time ← time + 1         

    f[u] ← time
    
    return result