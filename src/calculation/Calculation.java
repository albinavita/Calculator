package calculation;

import java.util.Scanner;

public class Calculation {
    private double res;
    private String str;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculation calculator = new Calculation();
        calculator.count(scanner);
    }

    public void count(Scanner scanner){
        String str1 = readData(scanner);
        if(str1.equals("s")){
            return;
        }
        double first = Double.valueOf(str1);

        while (true){
            readOperation(scanner);
            if(str.equals("s")){
                break;
            }
            if(str.equals("c")){
                first = 0.0;
                res = 0.0;
                count(scanner);
            }
            String str2 = readData(scanner);
            if(str2.equals("s")){
                break;
            }
            if(str2.equals("c")){
                first = 0.0;
                res = 0.0;
                count(scanner);
            }
            double second = Double.valueOf(str2);
            result(str, first, second, scanner);
            first = res;
        }
    }

    //выбор операции
    private void result(String operation, double value1, double value2, Scanner scanner) {
        if(operation.equals("")){
            readOperation(scanner);
        }
        switch (operation) {
            case "+":
                res = (value1 + value2);
                System.out.println("Сумма чисел равна: " + res);
                break;
            case "-":
                res = (value1 - value2);
                System.out.println("Разность чисел равна: " + res);break;
            case "*":
                res = (value1 * value2);
                System.out.println("Произведение чисел равно: " + res);
                break;
            case "/":
                res = (value1 / value2);
                System.out.println(String.format("Часное чисел равно: %.2f", res));
                break;
            default:
                System.out.println("Такая операция не предусмотрена");

        }
    }
    //ввод значения
    private String readData(Scanner scanner) {
        System.out.println("Введите число");
        String str = scanner.next();
        return str;
    }

    //ввод операции
    private void readOperation(Scanner scanner) {
        System.out.println("Введите одну из операций: +, -. * или /");
        str = "";
        String operation = scanner.next();

        if(operation.equals("+") ||
                operation.equals("-") ||
                operation.equals("/") ||
                operation.equals("*") ||
                operation.equals("s") ||
                operation.equals("c")
        ){
            str = operation;
        } else {
            System.out.println("Такая операция не предусмотрена");
            readOperation(scanner);
        }
    }
}
