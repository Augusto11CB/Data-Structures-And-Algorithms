# SIN5013 - Análise de Algoritmos e Estruturas de Dados 2020/09/07

## Encontrando Recorrência
Para calcular o consumo de tempo utilizamos equações de recorrência.

Uma equação de recorrência é uma maneira de **definir uma função por uma expressão em termos dela mesma**.

### Equações de consumo de tempo
Seja T(n) o tempo gasto por um algoritmo particular para uma entrada de tamanho n.

O consumo de tempo é proporcional ao número **operações elementares** (operações de interesse) que o algoritmo executa.

### Exemplo	- Calcular multiplicação de dois números não negativos
```js
function mult(m,n){
	if(n === 0){
		return 0;
	}
	else{ 
		return m + mult(m,n-1);
	}
}
```
```
T(n) = 0     se n = 0

T(n) = 1*T(n-1)+1   se n>0
// '1' * T (n-1) --> '1' número de vezes que a função é chamada recursivamente
// 1*T(n-1)+ '1' --> contagem da operação de interesse
T(n) = Theta(n)
```

### Exemplo - Calcular fatorial de `n`
```js
function fatorial(n){
	if(n === 0) {
		return 1;
	} else {
		return n * fatorial(n-1);
	}
	
}
```
```
T(n) = 0     se n = 0

T(n) = 1*T(n-1)+1   se n>0
// '1' * T (n-1) --> '1' número de vezes que a função é chamada recursivamente
// 1*T(n-1)+ '1' --> '1' contagem da operação de interesse
T(n) = Theta(n)
```

### Exemplo - Calcular Soma Positivos
```js
function somaPositivos(myArray, n){
	if (n === 0) {                                // n=0 +1  n=n +1
		return 0;                                 // n=0 +1
	} else {
		let s = somaPositivos(myArray, n-1);     // n=n +T(n-1)
		if(myArray[n] > 0){                      // n=n +1
			return s + A[n];                     // n=n if(myArray[n] > 0) +1
		} else {
			return s;                     		// n=n if(myArray[n] < 0) +1
		}		
	}
}
```
```
T(n) = 1 + 1 = 2     se n = 0

T(n) = 1*T(n-1) + 1 + 1 + 1 = T(n-1) + 3   se n>0

```

## Divisão e Conquista e Equações de Recorrência
Muitos algoritmos conhecidos têm uma estrutura recursiva.

O problema é dividido recursivamente e suas soluções combinadas para obter uma solução do problema original.

### Passos em cada nível de recursão

- **Divisão**: o problema é dividido em subproblemas menores. Deve ser rápido.
- **Conquista**:
	- os subproblemas são resolvidos recursivamente
	- subproblemas pequenos são resolvidos diretamente.
- **Combinação**: as soluções dos subproblemas são combinadas. Deve ser rápido.
