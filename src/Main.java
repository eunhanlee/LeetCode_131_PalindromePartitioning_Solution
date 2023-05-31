import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution tt= new Solution();
        String s="aab";
        List<List<String>> substrings = tt.partition(s);
        for (List<String> substringList : substrings) {
            System.out.println(substringList);
        }
    }
}