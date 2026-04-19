# 1021. Remove Outermost Parentheses

## Problem Statement

A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B` are valid parentheses strings, and `+` represents string concatenation.

- For example, `""`, `"()"`, `"(())()"`, and `"(()(()))"` are all valid parentheses strings.

A valid parentheses string `s` is primitive if it is nonempty, and there does not exist a way to split it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.

Given a valid parentheses string `s`, consider its primitive decomposition: `s = P_1 + P_2 + ... + P_k`, where `P_i` are primitive valid parentheses strings.

Return `s` after removing the outermost parentheses of every primitive string in the primitive decomposition of `s`.

## Examples

### Example 1

**Input:** `s = "(()())(())"`
**Output:** `"()()()"`
**Explanation:**
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

### Example 2

**Input:** `s = "(()())(())(()(()))"`
**Output:** `"()()()()(())"`
**Explanation:**
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is either `'('` or `')'`.
- `s` is a valid parentheses string.

## Approaches

### Approach 1: Using Stack

We can iterate through the string and use a `Stack` (or `Deque`) to keep track of the parentheses.

- When we encounter an open parenthesis `'('`, if the stack is already non-empty, it means this parenthesis is _not_ an outermost parenthesis, so we add it to our result. Then we push it onto the stack.
- When we encounter a close parenthesis `')'`, we first pop from the stack. If the stack is still non-empty after popping, it means this was _not_ an outermost parenthesis, so we add it to our result.
- **Time Complexity:** `O(N)` — We iterate through the string once.
- **Space Complexity:** `O(N)` — In the worst-case scenario, the stack will store `N/2` characters.

### Approach 2: Using a Counter (Optimal)

Instead of using a Stack, we can achieve `O(1)` auxiliary space by keeping a `counter` of open parentheses.

- As we iterate through the characters:
  - For `'('`: If `counter != 0`, it means this is not the first (outermost) parenthesis of the current primitive string, so we append it to our answer. Then we increment the `counter`.
  - For `')'`: We decrement the `counter` first. If `counter != 0` after decrementing, it means this is not the last (outermost) parenthesis, so we append it to our answer.
- **Time Complexity:** `O(N)` — Single pass through the string.
- **Space Complexity:** `O(1)` — We only use a single integer counter for tracking (excluding the space used for the output string).

_Note: Using a `StringBuilder` instead of standard `String +=` concatenation prevents unnecessary object creation and ensures the time complexity remains strictly `O(N)`._

## Solution (Java)

```java
class Solution {
    public String removeOuterParentheses(String s) {
        // StringBuilder is used to optimize concatenation time complexity to O(N)
        StringBuilder ans = new StringBuilder();
        int counter = 0;

        for (char i : s.toCharArray()) {
            if (i == '(') {
                if (counter != 0) {
                    ans.append(i);
                }
                counter++;
            } else {
                counter--;
                if (counter != 0) {
                    ans.append(i);
                }
            }
        }

        return ans.toString();
    }
}
```
