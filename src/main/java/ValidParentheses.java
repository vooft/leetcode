import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    enum Bracket {
        CURLY('{', '}'),
        ROUND('(', ')'),
        SQUARE('[', ']');

        public final char open;
        public final char close;

        Bracket(char open, char close) {
            this.open = open;
            this.close = close;
        }
    }

    private final Map<Character, Bracket> opens = Arrays.stream(Bracket.values())
            .collect(Collectors.toMap(it -> it.open, Function.identity()));

    private final Map<Character, Bracket> closes = Arrays.stream(Bracket.values())
            .collect(Collectors.toMap(it -> it.close, Function.identity()));

    public boolean isValid(String s) {
        var stack = new LinkedList<Bracket>();

        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            Bracket openBracket = opens.get(c);
            if (openBracket != null) {
                stack.push(openBracket);
            } else {
                Bracket closeBracket = closes.get(c);
                if (stack.isEmpty() || stack.pop() != closeBracket) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
