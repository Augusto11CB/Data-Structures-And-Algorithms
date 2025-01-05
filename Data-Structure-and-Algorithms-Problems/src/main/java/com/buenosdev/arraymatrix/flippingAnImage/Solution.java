package com.buenosdev.arraymatrix.flippingAnImage;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for(int[] row : image){
            flipInvert(row);
        }

        return image;
        
    }

    private void flipInvert(int[] row){
        int start = 0;
        int end = row.length - 1;
        
        while(start<end){
            var aux = row[end];
            row[end] = row[start] == 1 ? 0 : 1;
            row[start] = aux == 1 ? 0:1;
            start++;
            end--;
        }

        if(start == end){
            row[end] = row[end] == 1 ? 0 : 1;
        }
    }
}