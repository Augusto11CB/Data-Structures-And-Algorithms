Dijkstra’s Algorithm

S = Vértices cuja menor distancia para raiz já é conhecida 
Q = uma fila de prioridade mínima de vértices com distância provisória

```
DIJKSTRA (V,A,w,s)

1. INITIALIZE SINGLE-SOURCE (V,A,s,y)

2. S ← { }

3. Q ← V

4. while Q is not empty do

5.     u ← EXTRACT_MIN(Q)
		
	   if(u == y){
		   if π[u] != NIL or u = s {
				while(u != NIL) {
					S = S ∪ {u}
					u =  π[u]
				}
		   }  
		   break;
	   }

7.     for each vertex v in Adj[u] do

8.         Relax (u,v,w)

====================================================================

INITIALIZE-SINGLE-SOURCE(V,A,s)

1. for cada vértice v ∈ V

2.    d[v] ←∞

3.    π[v] ← NIL

4. d[s] ← 0

====================================================================

RELAX(u,v,w)

1.if d[v]>d[u]+w(u,v) then

2.    d[v] ← d[u]+w(u,v)

3.    π[v] ← u

====================================================================

```