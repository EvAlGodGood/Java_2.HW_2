import org.w3c.dom.ls.LSOutput;
//1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
//        10 3 1 2
//        2 3 2 2
//        5 6 7 1
//        300 3 1 0
//        Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
//2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
//3. Ваши методы должны бросить исключения в случаях:
//    Если размер матрицы, полученной из строки, не равен 4x4;
//    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
// 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
// 5. * Написать собственные классы исключений для каждого из случаев
public class Main {
    //public String[][] arrFin;
    //public String str;
    public static int sum;

    public static void main(String[] args) {
        sum = 0;
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] arrFin = new String[4][4];
        try {
            arrGen(str, arrFin);
            arrOut(arrFin);
            System.out.println(arithmetic(arrFin));
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Пользователь ввел некоректную строку (лишний символ), не удается \n" +
                    " создать массив 4 на 4.");
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("Пользователь ввел в строке букву или знак препинания, не удается \n" +
                    "преобразовать данный символ в число и произвести вычисления.");
            e.printStackTrace();
        }

    }

    public static void arrGen (String str, String [][] arrFin) throws ArrayIndexOutOfBoundsException{ //перевод строки в "двумерный" массив
        String[] arrStr = str.split("\n");
        for (int i = 0; i<arrStr.length; i++){
            String[] arr = arrStr[i].split(" ");
            for (int j = 0; j<arr.length; j++){
                arrFin[i][j] = arr[j];
            }
        }
    }

    public static void arrOut (String[][] arrFin) { //вывод массива
        for (int i = 0; i < arrFin.length; i++) {
            for (int j = 0; j < arrFin[i].length; j++) {
                System.out.printf("%s\t\t", arrFin[i][j]);
            }
            System.out.println();
        }
    }

    public static int arithmetic (String[][] arrFin) throws NumberFormatException{ //подсчет
        for (int i = 0; i < arrFin.length; i++) {
            for (int j = 0; j < arrFin[i].length; j++) {
                sum = sum + Integer.parseInt(arrFin[i][j]);
            }
        }
        return sum/2;
    }
}