function heapSort(myArray){
    
    buildMaxHeap(myArray, myArray.length);

    for(let newSize = myArray.length - 1; newSize > 0; newSize--){
        [myArray[0], myArray[newSize]] = [myArray[newSize], myArray[0]];
        maxHeapify(myArray, newSize, 0);
    }
}

function buildMaxHeap(myArray, arrayLength){
    
        let halfSize = Math.floor(arrayLength / 2);

        for (let indexs = halfSize; indexs >= 0; indexs--) {
            maxHeapify(myArray, arrayLength, indexs);
        }    
}

function maxHeapify(myArray, arrayLength, indexs){
    
    let leftHeap = indexs === 0 ? ((2 * (indexs + 1)) - 1) : ((2 * indexs) + 1);
    let rightHeap = indexs === 0 ? ((2 * (indexs + 1))) : ((2 * indexs) + 2);

    let biggest = indexs;


    if ((leftHeap < arrayLength) && (myArray[leftHeap] > myArray[indexs])) {
        biggest = leftHeap;
    }

    if ((rightHeap < arrayLength) && (myArray[rightHeap] > myArray[biggest])) {
        biggest = rightHeap;
    }

    if (biggest != indexs) {
        let aux = myArray[biggest];
        myArray[biggest] = myArray[indexs];
        myArray[indexs] = aux;

        maxHeapify(myArray, arrayLength, biggest);
    }
}

/**
 * JS Tips and Tricks
 * Given the array arr = [1,2,3,4], you can swap values in one line now like so:
 * [arr[0], arr[1]] = [arr[1], arr[0]];
 * 
 */

//let myArray = [8, 18, 14, 17, 12, 13, 11, 15, 16];
let myArray = [13, 46, 17, 34, 41, 15, 14, 23, 30, 21, 10, 12];
//let myArray = [1, 2, 3, 4, 5, 6, 7, 8, 9];

heapSort(myArray);
//maxHeap(myArray, myArray.length, 0);

console.log(myArray);