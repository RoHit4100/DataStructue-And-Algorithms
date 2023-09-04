package com.BitwiseOperators.Quetions;

public class FlipImage {
    public static void main(String[] args) {

    }
    public int[][] flipAndInvertImage(int[][] images) {
        for (int[] image : images) {
            for (int i = 0; i < (images[0].length + 1)/2; i++) {
                int temp = image[i] ^ 1;
                image[i] = image[images[0].length - i - 1] ^ 1;
                image[images[0].length - 1- i] = temp;
            }
        }
        return images;
    }
}
