package Lesson_7.TestTask;

public class Test {
    enum Switcher {ROW, COLUMN}

    enum Order {DIRECT, REVERSE}

    public static void main(String[] args) {
        int rows = 8;
        int columns = 9;
        int[][] arr = new int[rows][columns];

        int iterator = 1;
        int currentRowIndex = 0;
        int currentColIndex = 0;
        int rowsLeft = rows;
        int columnsLeft = columns;

        Switcher current = Switcher.ROW;
        Order currentRowOrder = Order.DIRECT;
        Order currentColOrder = Order.DIRECT;

        while (true){
            if (current == Switcher.ROW) {
                if (currentRowOrder.equals(Order.DIRECT)) {
                    for (int i = currentColIndex, j = 0; j < columnsLeft; j++, i++, iterator++, currentColIndex = i-1) {
                        arr[currentRowIndex][i] = iterator;
                    }
                    if (iterator>rows*columns) break;
                    rowsLeft--;
                    currentRowIndex++;
                    currentRowOrder = Order.REVERSE;
                }else {
                    for (int i = currentColIndex, j = 0; j < columnsLeft; j++, i--, iterator++, currentColIndex = i+1) {
                        arr[currentRowIndex][i] = iterator;
                    }
                    if (iterator>rows*columns) break;

                    currentRowIndex--;
                    rowsLeft--;
                    currentRowOrder = Order.DIRECT;
                }
                current = Switcher.COLUMN;

            }else {
                if (currentColOrder == Order.DIRECT) {
                    for (int i = currentRowIndex, j = 0; j < rowsLeft; j++, i++, iterator++, currentRowIndex = i-1) {
                        arr[i][currentColIndex] = iterator;
                    }
                    if (iterator>rows*columns) break;
                    currentColIndex--;
                    columnsLeft--;
                    currentColOrder = Order.REVERSE;
                }else {
                    for (int i = currentRowIndex, j = 0; j < rowsLeft; j++, i--, iterator++, currentRowIndex = i+1) {
                        arr[i][currentColIndex] = iterator;
                    }
                    if (iterator>rows*columns) break;

                    currentColIndex++;
                    columnsLeft--;
                    currentColOrder = Order.DIRECT;
                }
                current = Switcher.ROW;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");

        }
    }
}
