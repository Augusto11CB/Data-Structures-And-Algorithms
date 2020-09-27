function insertion_sort(myArray) {

    var arrayLength = array_length(myArray);
    var i = 1;

    while (i < arrayLength) {

        var key = myArray[i];
        var idToComparer = i - 1;

        while (idToComparer >= 0 && myArray[idToComparer] > key) {

            myArray[idToComparer + 1] = myArray[idToComparer];
            idToComparer = idToComparer - 1;
        }

        myArray[idToComparer+1] = key;
        
        i = i + 1;
    }
}