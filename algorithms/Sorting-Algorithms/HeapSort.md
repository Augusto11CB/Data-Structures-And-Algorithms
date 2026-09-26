# HeapSort

## Sorting Strategy
1. Build Max Heap from unordered array; 
2. Find maximum element A[1]; 
3. Swap elements A[n] and A[1]: 
	- now max element is at the end of the array! 
4. Discard node n from heap (by decrementing heap-size variable) 
5. New root may violate max heap property, but its children are max heaps. 
	- Run max_heapify to fix this.
6. Go to Step 2 unless heap is empty.  

## Running time
after n iterations the Heap is empty every iteration involves a swap and a max_heapify operation; hence it takes O(log n) time.

**Overall O(n log n)**

## Algorithm 

```js
function heapSort(myArray){
    
    buildMaxHeap(myArray, myArray.length);

    for(let newSize = myArray.length - 1; newSize > 0; newSize--){
        [myArray[0], myArray[newSize]] = [myArray[newSize], myArray[0]];
        maxHeapify(myArray, newSize - 1, 0);
    }
}
```
