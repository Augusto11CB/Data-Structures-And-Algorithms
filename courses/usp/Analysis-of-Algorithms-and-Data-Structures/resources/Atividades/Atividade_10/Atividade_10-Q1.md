# Problema - Jogo Gruntz
O mapa consiste de N linhas e M colunas, que divide o mapa em uma grade de N * M células. Cada uma dessas células, com exceção da célula central, contém uma seta desenhada, que indica para uma de quatro direções – Esquerda, Cima, Direita ou Baixo.

O objetivo do jogo é posicionar o personagem em alguma das células que constituem a borda do mapa, e fazer que o mesmo chegue até o centro do mapa, marcado com um x. As regras para se mover no jogo seguem a lógica das setas: O personagem só pode mover na direção que a seta aponta.

Ou seja, se o personagem está na célula [x, y] (linha x, coluna y), e nesta célula há uma seta apontada para a direita, a única célula que ele poderá alcançar dali será a célula [x, y+1], caso a mesma esteja dentro dos limites do mapa (caso não esteja, ele sairá do mapa, e perde o jogo).

Para facilitar, decidiu-se que poderia fazer K inversões de setas. Ao inverter uma seta, a mesma passa a apontar a direção oposta a qual ela apontava. Ou seja, se ela apontava para a Direita, ela apontará para a Esquerda, e vice-versa. O mesmo vale para Cima e Baixo.

## Entrada - Descrição
Haverá diversos casos de teste. Cada caso de teste inicia com três inteiros N, M e K (3 ≤ N, M < 100, 0 ≤ K ≤ 100, N e M são ímpares), representando, respectivamente, a quantidade de linhas e a quantidades de colunas do mapa, e o número máximo de inversões permitidas.

A seguir haverá N linhas, cada uma contendo M caracteres, que representarão o mapa desenhado. O caractere da linha i e coluna j indica que na célula [i, j] do mapa há:

'>' – Uma seta apontando para a Direita.
'<' – Uma seta apontando para a Esquerda.
'^' – Uma seta apontando para a Cima.
'v' – Uma seta apontando para a Baixo.
'x' – A célula de destino (a qual estará sempre no centro do mapa).
O último caso de teste é identificado quando N = M = K = 0, o qual não deve ser processado.

## Saída - Descrição
Para cada caso de teste deverá ser impressa uma linha, contendo a palavra “Sim” caso seja possível posicionar o personagem em uma das células da borda do mapa de tal forma que ele seja guiado até a célula de destino, fazendo no máximo K inversões de setas, ou “Nao” caso contrário.

## Exemplo de Entrada e ## Exemplo de Saída

### Case I
```
5 5 0
>>v<<
>>v<<
>>x<<
>>^<<
>>^<<
```

**saída: **
`yes`

### Case II
```
5 5 1
>>v<<
^^^>>
^^x^^
vvv>>
>>^<<
```

**saída: **
`yes`

### Case III
Interrompe

```
0 0 0
```

## PseudoCodigo
```java

FIND-PATH(x, y)

if (x,y outside maze) 
    return tryInvert()
    
if(alreadyMarkedAsPartOfSolution) 
    return false

if (x,y is goal) {
    return true
}

mark x,y as part of solution path

switch:
    case ">":
        if(FIND-PATH(">".of(x,y)) == true) {
            return true;
        }
        else {
            return(FIND-PATH(invertOf(">").of(x,y)))
        }
        break;
    case "<":
        if(FIND-PATH("<".of(x,y)) == true) {
            return true;
        }
        else {
            return(FIND-PATH(invertOf("<").of(x,y)))
        }
        break;
    case "v":
        if(FIND-PATH("v".of(x,y)) == true) {
            return true;
        }
        else {
            return(FIND-PATH(invertOf("v").of(x,y)))
        }
        break;
    case "^":
        if(FIND-PATH("^".of(x,y)) == true) {
            return true;
        }
        else {
            return(FIND-PATH(invertOf("^").of(x,y)))
        }
        break;
unmark x,y as part of solution path
return false
```

