/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author MY LAPTTOP
 */
public class Inputter {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(){
        return sc.nextLine();
    }
    
    public static String nomalize(String str) {
        str = str.trim();
        String tokens[] = str.split("\\s+");
        return String.join(" ", tokens);
    }

    public static String getNonBlankStr(String welcome) {
        String result = "";
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            result = nomalize(result);
        } while (result.length() == 0);
        return result;
    }

    public static String getString(String welcome, String msg) {
        boolean check = true;
        String result = "";
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static String getString(String welcome) {
        System.out.print(welcome);
        String result = sc.nextLine();
        return result;
    }

    public static String getStringreg(String welcome, String pattern, String msg, String msgreg) {
        boolean check = true;
        String result = "";
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else if (!result.matches(pattern)) {
                System.out.println(msgreg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static String getBlankStringreg(String welcome, String pattern, String msgreg) {
        boolean check = true;
        String result = "";
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                check = false;
            } else if (!result.matches(pattern)) {
                System.out.println(msgreg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static int getAnInteger(String welcome, String errorMsg) {
        int number;
        while (true) {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String welcome, String errorMsg, String errorMsgException, int lowerBound, int upperBound) {
        int number, tmp;

        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    System.out.println(errorMsg);
                }
                return number;
            } catch (Exception e) {
                System.out.println(errorMsgException);
            }
        }
    }

    public static int getAnInteger(String welcome, String msg, int min) {
        boolean check = true;
        int number = 0;
        do {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than " + min);
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.out.println(msg);
            }
        } while (check || number < min);
        return number;
    }
    

    public static float getFloat(String welcome, int min) {
        boolean check = true;
        float number = 0;
        do {
            try {
                System.out.print(welcome);
                number = Float.parseFloat(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than " + min);
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }

    public static boolean inputYN(String msg) {
        String choice;
        while (true) {
            System.out.print(msg);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must be Y or N");
                continue;
            }
        }
    }

    public static boolean isBlank(String str) {
        return str.trim().length() == 0;
    }
    
    public static boolean isBlank(int num) {
        return isBlank(String.valueOf(num));
    }

}
