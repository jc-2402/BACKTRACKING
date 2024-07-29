//find permutations
public class Backtracking3{
    public static void findpermuntation(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            //"abcde" = "ab" + "de" = "abde" .. c removed
            String newstr = str.substring(0,i) + str.substring((i+1),(str.length())); 
            findpermuntation(newstr, ans+curr);
        }
    }
    public static void main(String[] args) {
        String str ="abc";
        findpermuntation(str, "");
    }
}