/*
Considere o seguinte código recursivo, em que  pot2 é um método que recebe um inteiro e devolve verdadeiro caso o argumento seja uma potência exata de 2, ou falso caso contrário.

*/

function pot2(n) {
       return n && (n & (n - 1)) === 0;
}

function m(n) {

       console.log(n + " ");

       if (n <= 1) return;

       if (pot2(n)) {
              m(n / 2);
              m(n / 2);
       } else if (n % 2 === 0) {
              m(n - 1);
       } else {

              m(n - 2);
       }
}

/**
 * 
 Assinale a alternativa que corretamente indica a saída gerada (isto é, tudo aquilo que é impresso através do System.out.print) para as chamadas m(8), m(11) e m(9), respectivamente:

 A.  1, 1, 2, 1, 1, 2, 4, 1, 1, 2, 1, 1, 2, 4, 8 / 1, 3, 5, 7, 9, 11 / 1, 3, 5, 7, 9 	
 B.  8, 4, 2, 1 / 11, 9, 7, 5, 3, 1 / 9, 7, 5, 3, 1 	
[C.] 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1 / 11, 9, 7, 5, 3, 1 / 9, 7, 5, 3, 1 	
 D.  8, 4, 4, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 / 11, 9, 7, 5, 3, 1 / 9, 7, 5, 3, 1 	
 E.  8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1 / 11, 10, 8, 6, 4, 2, 0 / 9, 7, 5, 3, 1 	
 F.  Nenhuma das anteriores
 * 
 */

console.log(m(9));
console.log("---------");
console.log(m(11));
console.log("---------");
console.log(m(8));


