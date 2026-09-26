/**
 * Quicksort(array A, int startIndex, int endIndex):
        if startIndex < endIndex:
            choose a suitable pivot
            q = Partition(A, startIndex, endIndex, pivot)
            Quicksort(A, startIndex, q - 1)
            Quicksort(A, q + 1, endIndex)

 *  Partition(A, leftEdge, rightEdge, pivot):
        x = A[pivot]
        exchange A[pivot] with A[rightEdge]
        boundary = leftEdge - 1
        for j = leftEdge to rightEdge - 1:
            if A[j] <= x:
                // Move element A[j] into the left side of the partition
                boundary = boundary + 1
                exchange A[boundary] with A[j]
        exchange A[boundary + 1] with A[rightEdge]
        return boundary + 1     
 */