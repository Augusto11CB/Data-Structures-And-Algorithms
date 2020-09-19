function powerB(c, n) {
    if (n === 1) {                     // n=0: nothing
        return c;
    }

    let q = Math.floor(n / 2);

    return powerB(c, q) * powerB(c, q); // n-1: 1 + 2*T(n/2)   


}

console.log(powerB(2, 10));

/*
Q2 - No seguinte algoritmo suponha que n é uma potência de 2 e T(n) é o 'número de multiplicações executadas' pelo algoritmo potB.
T(n)= ____ para n=0
T(n)= ____ para n>0

Answer:
T(n)= 0 para n=0
T(n)= 2T(n/2) + 1 para n>0

- 2T(n/2) + '1'- vem da multiplicação
*/