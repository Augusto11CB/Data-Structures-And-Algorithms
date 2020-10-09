function maxHeap(myArray, arraySize, indexs) {

    console.log("indexs: " + indexs);

    let leftHeap = indexs === 0 ? ((2 * (indexs + 1)) - 1) : ((2 * indexs) + 1);
    let rightHeap = indexs === 0 ? ((2 * (indexs + 1))) : ((2 * indexs) + 2);

    let biggest = -1;

    console.log("(leftHeap <= arraySize) && (myArray[leftHeap] > myArray[indexs])")
    console.log((leftHeap + " <= " + arraySize) + " && " + (myArray[leftHeap] + ">" + myArray[indexs]))

    if ((leftHeap <= arraySize) && (myArray[leftHeap] > myArray[indexs])) {
        biggest = leftHeap;
    } else {
        biggest = indexs
    }

    console.log("(rightHeap <= arraySize) && (myArray[rightHeap] > myArray[biggest])")
    console.log((rightHeap + " <= " + arraySize) + " && " + (myArray[rightHeap] + ">" + myArray[indexs]))

    if ((rightHeap <= arraySize) && (myArray[rightHeap] > myArray[biggest])) {
        biggest = rightHeap;
    }

    console.log("biggest !== indexs --->" + biggest + "!==" + indexs);

    if (biggest !== indexs) {
        let aux = myArray[biggest];
        myArray[biggest] = myArray[indexs];
        myArray[indexs] = aux;


        console.log("--->" + myArray + "<---");
        maxHeap(myArray, arraySize, biggest);

    }
}

function buildMaxHeap(myArray, arraySize) {

    let halfSize = Math.floor(arraySize / 2);

    for (let indexs = halfSize; indexs >= 0; indexs--) {
        maxHeap(myArray, arraySize, indexs);
    }
}


let myArray = [8, 18, 14, 17, 12, 13, 11, 15, 16];

buildMaxHeap(myArray, myArray.length);
//maxHeap(myArray, myArray.length, 0);

console.log(myArray);