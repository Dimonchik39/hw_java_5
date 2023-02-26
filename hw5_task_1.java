import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Написать метод, определяющую правильность расстановки скобок в выражении.
// Могут содержаться следующие скобки: ()[]{}<>

public class hw5_task_1 {
    
    public static void main (String[] args) {
        System.out.println(boolStaples("()"));
        System.out.println(boolStaples("[]{}((<>))"));
        System.out.println(boolStaples(")"));
        System.out.println(boolStaples("[)"));
        System.out.println(boolStaples("[]{}(<)>"));
    }

    private static boolean boolStaples(String input) {
        Map<Character, Character> staples = new HashMap<>();
        staples.put('>', '<');
        staples.put(')', '(');
        staples.put('}', '{');
        staples.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (staples.containsValue(c)) {
                stack.push(c);
            } 
            else if (staples.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != staples.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}  