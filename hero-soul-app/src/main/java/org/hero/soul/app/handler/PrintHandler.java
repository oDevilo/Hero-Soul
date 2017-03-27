package org.hero.soul.app.handler;

public class PrintHandler {
    static String tab = "    ";
    static String select = "  ->";
    static int s = 0;
    static String point = ".";

    public static String getOptions(String[] options) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < options.length; i++) {
            if (i == s)
                sb.append(select + (i + 1) + point + options[i]);
            else
                sb.append(tab + (i + 1) + point + options[i]);
        }
        return sb.toString();
    }
    
    public static void turnLeft(){
        s--;
    }
    
    public static void turnRight(){
        s++;
    }
}
