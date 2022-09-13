import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Brackets {

    static boolean is_right_brackets(String expression){
        String brackets = _get_brackets(expression);
        Deque<String> deque = new ArrayDeque<>();
        ArrayList<String> opened_brackets = new ArrayList<>(Arrays.asList("{", "(", "[", "<"));
        ArrayList<String> closed_brackets = new ArrayList<>(Arrays.asList("}", ")", "]", ">"));

        for (Character symbol : brackets.toCharArray()) {
            String bracket = symbol.toString();
            if (opened_brackets.contains(bracket)){
                deque.addLast(bracket);
            }
            else{
                String open_bracket = opened_brackets.get(closed_brackets.indexOf(bracket));
                if (deque.size() != 0){
                    String last_deque = deque.removeLast();
                    if (!open_bracket.equals(last_deque)){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        if (deque.peek() == null){
            return true;
        }
        else{
            return false;
        }
    }


    static String _get_brackets(String expression){
        String regex = "[\\{\\}\\[\\]\\(\\)\\<\\>]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        String result = "";
        while (matcher.find()){
            result = String.format("%S%S", result, matcher.group());
        }
        return result.strip();
    }


    public static void main(String[] args) {
        String ex001 = "a+(d*3)";
        String ex002 = "[a+(1*3";
        String ex003 = "[6+(3*3)]";
        String ex004 = "{a}[+]{(d*3)}";
        String ex005 = "<{a}+{(d*3)}>";
        String ex006 = "{a+]}{(d*3)}";
        System.out.printf("TRUE -> %S\n", is_right_brackets(ex001));
        System.out.printf("FALSE -> %S\n", is_right_brackets(ex002));
        System.out.printf("TRUE -> %S\n", is_right_brackets(ex003));
        System.out.printf("TRUE -> %S\n", is_right_brackets(ex004));
        System.out.printf("TRUE -> %S\n", is_right_brackets(ex005));
        System.out.printf("FALSE -> %S\n", is_right_brackets(ex006));
    }
}