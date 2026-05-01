// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }

//         HashMap<Character, Integer> S = new HashMap<>();
//         HashMap<Character, Integer> T = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             S.put(s.charAt(i), S.getOrDefault(s.charAt(i), 0) + 1);
//             T.put(t.charAt(i), T.getOrDefault(t.charAt(i), 0) + 1);
//         }

//         return S.equals(T);
//     }
// }
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;

//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < s.length(); i++) {
//             map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//             map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
//         }
//         for (int count : map.values()) {
//             if (count != 0) return false;
//         }
//         return true;
//     }
// }


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        return Arrays.equals(S, T);
    }
}