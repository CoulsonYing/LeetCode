package carl.array.two_pointers;

public class No844_BackspaceStringCompare {
    public static void main(String[] args){
        String s = "abc#";
        String t = "ad#c";
        boolean result = backspaceCompare(s, t);
        System.out.println(result);
    }

    public static boolean backspaceCompare(String s, String t){
        String s1 = backspace(s);
        String s2 = backspace(t);
        return s1.equals(s2);
    }

    /**
     * 对字符串处理的方法
     * @param str
     * @return
     */
    private static String backspace(String str){
        char[] chars = str.toCharArray();
        // slow指向已处理字符串的末尾
        int slow = 0;
        for(int fast = 0; fast < chars.length; fast++){
            if(chars[fast] == '#'){
                slow = slow > 0 ? --slow : 0;
            }else{
                chars[slow++] = chars[fast];
            }
        }
        return new String(chars, 0, slow);
    }
}
