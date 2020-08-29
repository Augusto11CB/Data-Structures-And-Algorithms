console.log("Starting BinarySearch");

let findIndex = function binarySearch(myArray, start, end, targetValue) {
    console.log("-------------");
    console.log(`start: ${start}`);
    console.log(`end: ${end}`);
    console.log(`targetValue: ${targetValue}`);

    if (start === end) {
        return start;
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

let myArray = [1, 3, 4, 4, 6, 7];
let start = 0;
let end = myArray.length - 1;

let index = findIndex(myArray, start, end, 5);

console.log(`bestIndex: ${index}`);

console.log("Ending BinarySearch");