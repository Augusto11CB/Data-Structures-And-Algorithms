
# SIN5013 - Análise de Algoritmos e Estruturas de Dados 2020/08/31


## Algoritmo
É um procedimento computacional bem definido, que recebe um conjunto de valores como entrada e produz um conjunto de valores como saida.

É uma ferramenta para resolver problemas computacionais.

## Problema e instâncias
Um problema é definido por:
- uma descrição dos parâmetros
- uma descrição sobre as propriedades que a resposta deve satisfazer

Uma **instancia de um problema** é obtida ao fixar valores para todos os parâmetros do problema

#### Exemplo
**Problema:** Ordenar uma sequencia a1, a2,..., an de maneira crescente.
- **Entrada:** a1,a2,...,an
- **Saída:** a'1, a'2, ..., a'3
- **Propriedades:** a'1, a'2, ..., a'3 é uma permutação de a1, a2, ..., an tal que a'1 <= a'2 <=  ... <= a'n

**Instância:** 
- Input: 10 20 5 40 4
- Output: 4 5 10 20 40
 
## Corretude do algoritmo
Um alg. é **correto** (resolve o problema) se, para toda instância de entrada, o algoritmo termina e produz uma saída que satisfaz as propriedades do problema.

### Prova da Corretude
- Alg. Iterativos: Utiliza-se a técnica dos **invariantes do laço**. *Trata-se de uma property que é `true` antes, durante e após a execução do laço;*
- Alg. Recursivos: Utiliza-se a técnica de **indução matemática ** no tamanho das instâncias. 



