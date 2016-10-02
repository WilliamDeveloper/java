package br.com.core.string;

import com.sun.javafx.binding.StringFormatter;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class HelperStringFormatter {

    //#################################################################
    public static String doFormatarString(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }

    //#################################################################
    public static String doRemoverMascara(String pString) {

        if ((pString == null) || pString.equals("")) {
            return "";
        }

        return pString
                .replaceAll("[_]", "")
                .replaceAll("[-]", "")
                .replaceAll("[.]", "")
                .replaceAll("[/]", "")
                .replaceAll("[%]", "")
                .replaceAll("[R$]", "")
                .replaceAll("[ ]", "")
                .replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    //#################################################################
    public static String doPadLeft(String str, Integer length, String strToFill) {
        return str
                + String.format("%" + (length - str.length()) + "s", "")
                .replace(" ", strToFill);
    }

    //#################################################################
    public static String doPadRight(String str, Integer length, String strToFill) {
        return String.format("%" + (length - str.length()) + "s", "")
                .replace(" ", String.valueOf(strToFill))
                + str;
    }

    //#################################################################
    public static boolean isNotNullBlank(String pString) {

        boolean vValor = false;

        if ((pString != null) && !pString.trim().equals("")) {
            vValor = true;
        }

        return vValor;
    }

//#################################################################
    public static void main(String[] args) {
        System.out.println("doFormatarString- " + HelperStringFormatter.doFormatarString("01862853029", "###.###.###-##"));
        System.out.println("doRemoverMascara-" + HelperStringFormatter.doRemoverMascara("018.628.530-29"));
        System.out.println("isNotNullBlank-" + HelperStringFormatter.isNotNullBlank("tem-valor"));
        System.out.println("isNotNullBlank-" + HelperStringFormatter.isNotNullBlank(null));
        System.out.println("[" + HelperStringFormatter.doPadLeft(" will bom dia ", 11,"0") + "]");
        System.out.println("[" + HelperStringFormatter.doPadRight(" will bom dia ", 11,"0") + "]");
        System.out.println("[" + HelperStringFormatter.doPadLeft("will", 12,"0").length() + "]");
        System.out.println("[" + HelperStringFormatter.doPadLeft("123", 5,"*")+"]");
        System.out.println("[" + HelperStringFormatter.doPadRight(" 12   3 ", 50,"*")+"]");
       

    }

}
