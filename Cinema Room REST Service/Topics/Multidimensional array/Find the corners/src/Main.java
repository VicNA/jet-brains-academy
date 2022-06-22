class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int height = twoDimArray.length - 1;
        int width = twoDimArray[0].length - 1;

        System.out.println(twoDimArray[0][0] + " " + twoDimArray[0][width]);

        width = twoDimArray[height].length - 1;
        System.out.println(twoDimArray[height][0] + " " + twoDimArray[height][width]);
    }
}