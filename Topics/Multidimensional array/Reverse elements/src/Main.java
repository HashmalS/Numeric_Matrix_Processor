class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        int temp;
        for (int[] ints : twoDimArray) {
            for (int i = 0; i < ints.length / 2; i++) {
                temp = ints[i];
                ints[i] = ints[ints.length - i - 1];
                ints[ints.length - i - 1] = temp;
            }
        }
    }
}