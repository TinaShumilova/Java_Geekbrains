package java_projects;

import java.util.Random;
import java.io.*;
/**
 * Задана натуральная степень k. Сформировать случайным образом список коэффициентов 
(значения от 0 до 100) многочлена многочлен степени k. 
*Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
 */
public class program1 {
    public static void main(String[] args) {
        String first = Task1(2);
        String second = Task1(2);
        PutInFile(first, "first.txt");
        PutInFile(second, "second.txt");
        System.out.println("first: " + first);
        System.out.println("second: " + second);

    }
    static String Task1(int k){
        Random number = new Random();
        int a = number.nextInt(101);
        int b = number.nextInt(101);
        int c = number.nextInt(101);
        //int a = 0;
        //nt b = 0;
        //int a = 1;
        //int b = 1;
        //int c = 0;
        String answer = null;
        if (c > 0){
            if (a == 1 | a == 0){
                switch (a) {
                    case 1:
                        if (b > 1) answer = String.format("x^%d + %dx + %d = 0", k, b, c);
                        if (b == 1) answer = String.format("x^%d + x + %d = 0", k, c);
                        if (b == 0) answer = String.format("x^%d + %d = 0", k, c);
                        break;
                    case 0:
                        if (b > 1) answer = String.format("%dx + %d = 0", b, c);
                        if (b == 1) answer = String.format("x + %d = 0", c);
                        if (b == 0) answer = "Неверно";
                        break;
                }
            }
            if (b == 1 | b == 0){
                switch (b) {
                    case 1:
                        if (a > 1)  answer = String.format("%d*x^%d + x + %d = 0", a, k, c);
                        if (a == 1) answer = String.format("x^%d + x + %d = 0", k, c);
                        if (a == 0) answer = String.format("x + %d = 0", c); 
                        break;
                    case 0:
                        if (a > 1) answer = String.format("%d*x^%d + %d = 0", a, k, c);
                        if (a == 1) answer = String.format("x^%d + %d = 0", k, c);
                        if (a == 0) answer = "Неверно";
                        break;
                }
            }
            if (a > 1 & b > 1) {
                answer = String.format("%d*x^%d + %dx + %d = 0", a, k, b, c); 
            }
        }
        if (c == 0){
            if (a == 1 | a == 0){
                switch (a) {
                    case 1:
                        if (b > 1) answer = String.format("x^%d + %dx = 0", k, b);
                        if (b == 1) answer = String.format("x^%d + x = 0", k);
                        if (b == 0) answer = String.format("x^%d = 0", k);
                        break;
                    case 0:
                        if (b > 1) answer = String.format("%dx = 0", b);
                        if (b == 1) answer = "x = 0";
                        if (b == 0) answer = "Неверно";
                        break;
                }
            }
            if (b == 1 | b == 0){
                switch (b) {
                    case 1:
                        if (a > 1)  answer = String.format("%d*x^%d + x = 0", a, k);
                        if (a == 1) answer = String.format("x^%d + x = 0", k);
                        if (a == 0) answer = "x = 0"; 
                        break;
                    case 0:
                        if (a > 1) answer = String.format("%d*x^%d = 0", a, k);
                        if (a == 1) answer = String.format("x^%d = 0", k);
                        if (a == 0) answer = "Неверно";
                        break;
                }
            }
            if (a > 1 & b > 1) {
                answer = String.format("%d*x^%d + %dx = 0", a, k, b); 
            }
        }
        return answer;   
    }

    static void PutInFile(String task1, String fileName){
        try(FileWriter fw = new FileWriter(fileName, false)){
            fw.write(task1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}