import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static String calc(String input){
//Создаем список арабских цифр 1..10 и римских 1..100
        List<String> arab = Arrays.asList("1","2","3","4","5","6","7","8","9","10");
        List<String> otric = Arrays.asList("0","-1","-2","-3","-4","-5","-6","-7","-8","-9");
        List<String> rome = Arrays.asList("I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C");
        String str = input;
        String numb1, numb2;
        numb1 = numb2  = "";
        char oper;
        int i = 0;

        int k = str.indexOf("+");
        if (k < 0) {
            k = str.indexOf("+");
            if (k < 0) {
                k = str.indexOf("-");
                if (k < 0) {
                    k = str.indexOf("*");
                    if (k < 0) {
                        k = str.indexOf("/");
                    }
                }
            }
        }

        while (i != k) {
            numb1 += str.charAt(i);
            i++;
        }

        oper = str.charAt(k);
        k++;

        while (k != str.length()) {
            numb2 += str.charAt(k);
            k++;
        }
        boolean rim = true;
// Перевод римских в арабские и проверка условия №5
        if ((rome.lastIndexOf(numb1) >= 0) & (rome.lastIndexOf(numb2) >= 0)) {
            numb1 = arab.get(rome.lastIndexOf(numb1));
            numb2 = arab.get(rome.lastIndexOf(numb2));
        }  else if ((arab.lastIndexOf(numb1) >= 0) & (arab.lastIndexOf(numb2) >= 0)) {
            rim = false;
        } else {
            System.out.println("throws Exception");
            return "throws Exception";
        }

        int n1 = Integer.parseInt(numb1), n2 = Integer.parseInt(numb2);

// Проверка условий
        if (((n1 < 1) | (n1 > 10)) & ((n2 < 1) | (n2 > 10))) {
            System.out.println("throws Exception");
            return "throws Exception";
        }

//КАЛЬКУЛЯТОР
        int res = 0;
        if (oper == '+') {
            res = n1 + n2;
        } else if (oper == '-') {
            res = n1 - n2;
        } else if (oper == '*') {
            res = n1 * n2;
        } else if (oper == '/') {
            res = n1 / n2;
        }

// Проверка условия №10
        if ((rim) & (res < 1)) {
            System.out.println("throws Exception");
            return "throws Exception";
        } else if (rim) {
            System.out.println(rome.get(res-1));
            return rome.get(res - 1);
        } else  {
            if (res <= 0) {
                System.out.println(otric.get(Math.abs(res)));
                return otric.get(Math.abs(res));
            } else {
                System.out.println(Integer.toString(res));
                return ("res");
            }

//            System.out.println(res);

        }

    }
    public static void main (String[] args) {
        Scanner Scanner = new Scanner(System.in);
        String str = Scanner.next();
        calc(str);
    }

}
