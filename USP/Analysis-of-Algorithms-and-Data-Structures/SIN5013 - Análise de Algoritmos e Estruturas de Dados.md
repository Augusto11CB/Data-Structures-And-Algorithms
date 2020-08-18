# SIN5013 - Análise de Algoritmos e Estruturas de Dados

- Exercícios Semanais - 13 Atividades (Nota + Presença)
	- Eliminar as 3 piores notas - 10 notas consolidadas
- Avaliação Final - T1 & T2 
- Média Final - (T1 + T2 + A)/3
	- MF >= 8 == (A)
- 14H ~ 15H - Plantão de Dúvidas

Pré-Requisito
- Indução Matemática
- Propriedade de Logaritmos e Exponenciais

## Indução Matemática
### Princípio de indução finita
Seja P(n) uma propriedade sobre o numero natural n>=n0, sendo n0 um numero natural fixado (ou seja ele foi dado/escolhido). Para prova provar que P(n) é verdadeiro para todo n>=n0 basta provar:

1 - **Passo base**: A propriedade é valida para n=n0;
2 - **Passo indutivo:** 
	v1 - Para k>n0, *se a propriedade é valida para n=k*, então é valida para n=k+1
	v2 - Para k>n0, *se a propriedade é valida para n=k-1*, então é valida para n=k 

### Indução Forte
Seja P(n) uma propriedade sobre o numero natural n>=n0, sendo n0 um numero natural fixado (ou seja ele foi dado/escolhido). Para prova provar que P(n) é verdadeiro para todo n>=n0 basta provar:

1 - **Passo base**: A propriedade é valida para n=n0;
2 - **Passo indutivo:** 
	v1 - Para k>n0, *se a propriedade é valida para todo n0<=n<=k*, então é valida para n=k+1
	
