package br.com.core.string;

public class ValidCharacter {

    public static boolean isOnlyNumber(String str) {
        return str.matches("[0-9]+");
    }

    public static boolean isOnlyLetterA_Z(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static boolean isOnlyNumberAndLetterA_Z(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }

    public static void main(String[] args) {
        System.out.println(ValidCharacter.isOnlyLetterA_Z("87"));
        System.out.println(ValidCharacter.isOnlyLetterA_Z("Asd"));
        
    }

}
