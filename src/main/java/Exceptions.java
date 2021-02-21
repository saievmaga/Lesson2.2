


public class Exceptions {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        arr[4][4] = "asdfsdg";
        try {
            try {
                int result = print(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Array Size Exception!");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Array Data Exception!");
            System.out.println("Error in: " + e.i + "x" + e.j);
        }

    }


    public static int print(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int count = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return count;
    }

}
