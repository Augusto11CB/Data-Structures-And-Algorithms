console.log("Starting BinarySearch");

let findIndex = function binarySearch(myArray, start, end, targetValue) {
    console.log("-------------");
    console.log(`start: ${start}`);
    console.log(`end: ${end}`);
    console.log(`targetValue: ${targetValue}`);

    if (start === end) {

        if (myArray[start] === targetValue) {
            return start;
        }
        else return -1;
    }

    midIndex = Math.floor((start + end) / 2);

    console.log(`midIndex: ${midIndex}`);

    if (targetValue <= myArray[midIndex]) {
        return findIndex(myArray, start, midIndex, targetValue);
    } else {
        return findIndex(myArray, midIndex + 1, end, targetValue);
    }

}

// Validation 

let myArray = [5];
let start = 0;
let end = myArray.length - 1;

let index = findIndex(myArray, start, end, 10);

console.log(`bestIndex: ${index}`);

console.log("Ending BinarySearch");