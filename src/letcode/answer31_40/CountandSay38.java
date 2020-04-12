package answer31_40;

/**
 * 1:1
 * 2:11
 * 3:21
 * 4:1211
 * 5:111221
 */
public class CountandSay38 {

    public String countAndSay(int n) {
        String result= "1";
        for(int i=1;i<n;i++){
           result  = getNext(result);
        }
        return result;
    }

    public static String getNext(String last){

        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i=0;i<last.length();i++){
            if(i==last.length()-1){
                result.append(count).append(last.charAt(i));
                break;
            }
            while (last.charAt(i)==last.charAt(i+1)){
                count++;
                i++;
                if(i+1==last.length()) break;
            }
            result.append(count).append(last.charAt(i));
            count=1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String next = new CountandSay38().countAndSay(1);
        String next1 = new CountandSay38().countAndSay(2);
        String next2 = new CountandSay38().countAndSay(3);
        String next3 = new CountandSay38().countAndSay(4);
        String next4 = new CountandSay38().countAndSay(5);
        String next5 = new CountandSay38().countAndSay(6);
        System.out.println(next);
        System.out.println(next1);
        System.out.println(next2);
        System.out.println(next3);
        System.out.println(next4);
        System.out.println(next5);
    }
}
