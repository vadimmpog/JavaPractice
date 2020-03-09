import java.util.HashMap;
import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next(),s2 = in.next();
        HashMap<String,Integer> map = new HashMap();
        HashMap<String,Integer> map2 = new HashMap();
        if(s1.length()!=s2.length()){
            System.out.print("NO");
        }
        else {
            for (int i = 0; i < s1.length(); i++) {
                if (map.get(Character.toString(s1.charAt(i))) == null) {
                    map.put(Character.toString(s1.charAt(i)), 0);
                }
                map.put(Character.toString(s1.charAt(i)), map.get(Character.toString(s1.charAt(i))) + 1);

                if (map2.get(Character.toString(s2.charAt(i))) == null) {
                    map2.put(Character.toString(s2.charAt(i)), 0);
                }
                map2.put(Character.toString(s2.charAt(i)), map2.get(Character.toString(s2.charAt(i))) + 1);
            }
            if (map.equals(map2) && !map.isEmpty()) {
                System.out.print("YES");
            } else {
                System.out.print("NO");
            }
        }

    }
}
