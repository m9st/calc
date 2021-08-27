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
            default -> "error";
        };
    }
}