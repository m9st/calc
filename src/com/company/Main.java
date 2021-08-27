package com.company;
import java.beans.PropertyEditorSupport;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите уравнение, состоящее из операторов: +, -, /, * " +
                "используя арабские либо римские цыфры от 1 до 10 (I-X)" +
                " в формате x + y используя пробелы между символами");
        Scanner scan    = new Scanner(System.in);
        String scanString = scan.nextLine();
        Cheker chek = new Cheker(scanString);
            if (chek.checkPassed) {
                Calc calc = new Calc(chek.firstOperand, chek.secondOperand, chek.operator);
                if (chek.arabic) {
                    System.out.println(calc.openResult);
                } else if(calc.openResult > 0) {
                    System.out.println(arabicToRome(calc.openResult));
                } else {
                    System.out.println("Римляне не умели считать меньше нуля :)");
                }
            } else {
                scan.close();
            }
        scan.close();
    }

    public static class Calc {
        int openResult;
        static int result(int FirstOperand, int SecondOperand, String operator) {
            return switch (operator) {
                case "*" -> FirstOperand * SecondOperand;
                case "/" -> FirstOperand / SecondOperand;
                case "+" -> FirstOperand + SecondOperand;
                case "-" -> FirstOperand - SecondOperand;
                default -> 808;
            };
        };
        Calc(int FirstOperand, int SecondOperand, String operator) {
            openResult = result(FirstOperand, SecondOperand, operator);
        }
    }

    public static class Cheker {
        private String[] mathExpression;
        boolean checkPassed;
        boolean arabic;
        int firstOperand;
        int secondOperand;
        String operator;

        Cheker(String expression) {
            mathExpression = expression.split(" ");
            if (operandCountCheck(mathExpression)) {
                if (operandSimilarityCheck(mathExpression)) {
                    if (lowerThenTen()) {
                        operator = mathExpression[1];
                        checkPassed = true;
                    } else {
                        System.out.println("Значение операндов больше 10");
                    }
                } else {
                    System.out.println("Операнды разных систем счисления");
                }
            } else {
                System.out.println("Не является математической операцией");
            }
        }

        boolean lowerThenTen() {
            return (firstOperand < 10 & secondOperand < 10);
        }

        boolean operandSimilarityCheck(String[] expression) {
            String[] romeArray = {"I", "II", "III", "IV", "V", "VI", "VII", "IIX", "IX", "X"};
            try {
                firstOperand  = Integer.parseInt(expression[0]);
                secondOperand = Integer.parseInt(expression[2]);
                arabic        = true;
                return true;
            } catch (NumberFormatException e) {

            }
            boolean firstRome  = false;
                boolean secondRome = false;
                for (int i = 0; i < romeArray.length; i++) {
                    if (expression[0].equals(romeArray[i])) {
                        System.out.println("Nope");
                        firstOperand = romeToArabic(romeArray[i]);
                        firstRome    = true;
                    }
                }
                for (int i = 0; i < romeArray.length; i++) {
                    if (expression[2].equals(romeArray[i])) {
                        secondOperand = romeToArabic(romeArray[i]);
                        secondRome = true;
                        return firstRome & secondRome;
                    }

            }
            return false;
        }




        static boolean operandCountCheck(String[] expression) {
            if(expression.length == 3) {
                return true;
            }
            return false;
        }

    }

    public static int romeToArabic(String rome) {
        return switch (rome) {
            case "I"   -> 1;
            case "II"  -> 2;
            case "III" -> 3;
            case "IV"  -> 4;
            case "V"   -> 5;
            case "VI"  -> 6;
            case "VII" -> 7;
            case "IIX" -> 8;
            case "IX"  -> 9;
            case "X"   -> 10;
            default    -> 100;
        };
    }

    public static String arabicToRome(int arab) {
        return switch (arab) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "IIX";
            case 9 -> "IX";
            case 10 -> "X";
            case 11 -> "XI";
            case 12 -> "XII";
            case 13 -> "XIII";
            case 14 -> "XIV";
            case 15 -> "XV";
            case 16 -> "XVI";
            case 17 -> "XVII";
            case 18 -> "XIIX";
            case 19 -> "XIX";
            case 20 -> "XX";
            case 21 -> "XXI";
            case 22 -> "XXII";
            case 23 -> "XXIII";
            case 24 -> "XXIV";
            case 25 -> "XXV";
            case 26 -> "XXVI";
            case 27 -> "XXVII";
            case 28 -> "XXVIII";
            case 29 -> "XXIX";
            case 30 -> "XXX";
            case 31 -> "XXXI";
            case 32 -> "XXXII";
            case 33 -> "XXXIII";
            case 34 -> "XXXIV";
            case 35 -> "XXXV";
            case 36 -> "XXXVI";
            case 37 -> "XXXVII";
            case 38 -> "XXXVIII";
            case 39 -> "XXXIX";
            case 40 -> "XL";
            case 41 -> "XLI";
            case 42 -> "XLII";
            case 43 -> "XLIII";
            case 44 -> "XLIV";
            case 45 -> "XLV";
            case 46 -> "XLVI";
            case 47 -> "XLVII";
            case 48 -> "XLVIII";
            case 49 -> "XLIX";
            case 50 -> "L";
            case 51 -> "LI";
            case 52 -> "LII";
            case 53 -> "LIII";
            case 54 -> "LIV";
            case 55 -> "LV";
            case 56 -> "LVI";
            case 57 -> "LVII";
            case 58 -> "LVIII";
            case 59 -> "LIX";
            case 60 -> "LX";
            case 61 -> "LXI";
            case 62 -> "LXII";
            case 63 -> "LXIII";
            case 64 -> "LXIV";
            case 65 -> "LXV";
            case 66 -> "LXVI";
            case 67 -> "LXVII";
            case 68 -> "LXVIII";
            case 69 -> "LXIX";
            case 70 -> "LXX";
            case 71 -> "LXXI";
            case 72 -> "LXXII";
            case 73 -> "LXXIII";
            case 74 -> "LXXIV";
            case 75 -> "LXXV";
            case 76 -> "LXXVI";
            case 77 -> "LXXVII";
            case 78 -> "LXXVIII";
            case 79 -> "LXXIX";
            case 80 -> "LXXX";
            case 81 -> "LXXXI";
            case 82 -> "LXXXII";
            case 83 -> "LXXXIII";
            case 84 -> "LXXXIV";
            case 85 -> "LXXXV";
            case 86 -> "LXXXVI";
            case 87 -> "LXXXVII";
            case 88 -> "LXXXVIII";
            case 89 -> "LXXXIX";
            case 90 -> "XC";
            case 91 -> "XCI";
            case 92 -> "XCII";
            case 93 -> "XCIII";
            case 94 -> "XCIV";
            case 95 -> "XCV";
            case 96 -> "XCVI";
            case 97 -> "XCVII";
            case 98 -> "XCVIII";
            case 99 -> "XCIX";
            case 100 -> "C";
            default -> "error";
        };
    }
}