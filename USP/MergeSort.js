function mergeSort (unsortedArray) {
  
  if (unsortedArray.length <= 1) {
    return unsortedArray;
  }
  
  const middle = Math.floor(unsortedArray.length / 2);

  
  const left = unsortedArray.slice(0, middle);
  const right = unsortedArray.slice(middle);

  
  return merge(
    mergeSort(left), mergeSort(right)
  );
}

function merge (left, right) {
  let resultArray = [], leftIndex = 0, rightIndex = 0;

  while (leftIndex < left.length && rightIndex < right.length) {
    if (left[leftIndex] < right[rightIndex]) {
      resultArray.push(left[leftIndex]);
      leftIndex++; // move left array cursor
    } else {
      resultArray.push(right[rightIndex]);
      rightIndex++; // move right array cursor
    }
  }

  return resultArray
          .concat(left.slice(leftIndex))
          .concat(right.slice(rightIndex));
}