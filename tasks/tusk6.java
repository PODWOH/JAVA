package tasks;

import java.io.LineNumberInputStream;
import java.text.NumberFormat.Style;
import java.util.*;
import java.util.regex.*;

import javax.swing.text.AbstractDocument.LeafElement;

public class tusk6 {
    public static void main(String[] args){
        //1
        bell(4);
        //2
        System.out.println(translateWord("Apple"));
        System.out.println(translateSentence("I like to eat honey waffles."));
        //3
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        //4
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        //5
        System.out.println(Arrays.toString(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")));
        //6
        System.out.println(ulam(206));
        //7
        System.out.println(longestNonrepeatingSubstring("abcda"));
        //8
        System.out.println(convertToRoman(20));
        //9
        System.out.println(formula("6 * 4 = 24"));
        //10
        System.out.println(palindromeDescendant(11211230));

    }

    //1
    public static  int StirlingNumb(int n,int k){
        if (n >= 0 && n == k)
        {
            return 1;
        }

        if ((n > 0 && k == 0 )  ||  (k > 0 && n == 0) )
        {
            return 0;
        }

        return StirlingNumb(n - 1, k - 1) + k * StirlingNumb(n - 1, k);
    }
    public static void bell(int numb){
 
        double bellNumbers = 0;
 
        for (int k = 0; k <= numb; k++)
        {
            bellNumbers += StirlingNumb(numb, k);
        }
        System.out.println(bellNumbers);
    }
    //2
    public static String translateWord(String word){
        String temp="";
        String temp2="";
        char[] ar = word.toCharArray();
        if(ar[ar.length-1]>=33 && ar[ar.length-1]<=47){
            temp2+=ar[ar.length-1];
           ar[ar.length-1]=0;
        }
        if((Character.toLowerCase(ar[0]) !='a') && (Character.toLowerCase(ar[0]) !='o') && (Character.toLowerCase(ar[0]) !='e') && (Character.toLowerCase(ar[0])!='i') && (Character.toLowerCase(ar[0])!='u')){
            if(Character.isUpperCase(ar[0])){
                temp+=Character.toUpperCase(ar[1]);
            }
            else{
                temp+=ar[1];
            }
            for(int i=2;i<ar.length;i++){
                temp+=ar[i];
            }
            temp+=Character.toLowerCase(ar[0])+"ay";
        }
        else{
            temp=word+"yay";
        }
        temp+=temp2;
        


        return temp;
    }
    
    public static String translateSentence(String s){
        String words="";
        String[] word = s.split(" ");
        for(int i=0;i<word.length;i++){
            words+=translateWord(word[i])+" ";
   
        }
        return words;
    }
    //3
    public static boolean validColor(String rgb){
        rgb = rgb.replaceAll("[rgba()]", "");
        String[] Snumbs = rgb.split(",");
        for(int i=0;i<Snumbs.length;i++){
            if(i==3){
                double h = Double.parseDouble(Snumbs[i]);
                if(h<0 && h>1){
                    return false;
                }
            }
            else{
                double numb =  Integer.parseInt(Snumbs[i]);
                if(numb<0  && numb>255){
                    return false;
                }
            }   
        }
        return true;
    }
    //4
    
    public static String stripUrlParams(String url, String[] paramsToDelete) {
        String[] Hword = url.split("\\?");
        if (Hword.length == 1) {
            return url;
        } 
        String[] params = Hword[1].split("&");
        Map<String, String> paramsAndValuesMap = new HashMap<>();
        for (String param : params) {
            String[] keyAndValue = param.split("=");
            boolean shouldBeAdded = true;
            for (String paramToDelete : paramsToDelete) {
                if (keyAndValue[0].equals(paramToDelete)) {
                    shouldBeAdded = false;
                    break;
                }
            }
            if (shouldBeAdded) {
                paramsAndValuesMap.put(keyAndValue[0], keyAndValue[1]);
            }
        }
        StringJoiner words = new StringJoiner("&");
        for (Map.Entry<String, String> entry : paramsAndValuesMap.entrySet()) {
            words.add(entry.getKey() + "=" + entry.getValue());
        }
        return Hword[0] + "?" + words;
    }
    public static String stripUrlParams(String url) {
        return stripUrlParams(url, new String[]{});
    }
    //5
    public static int find(int[] mas){
        int temp=-1;
        int index=0;
        for(int i=0;i<mas.length;i++){
            if(mas[i]>temp){
                temp=mas[i];
                index=i;
            }

        }
        mas[index]=0;
        return index;
    }
    public static String[] getHashTags(String s){
        String[] words = s.split(" ");
        int[] mas = new int[words.length];
        for(int i=0;i<words.length;i++){
            mas[i]=words[i].length();
        }
        int first=find(mas);
        int second=find(mas);
        int third=find(mas);
        ArrayList<String> list = new ArrayList<>(3);
        list.add("#"+words[first].toLowerCase());
        list.add("#"+words[second].toLowerCase());
        list.add("#"+words[third].toLowerCase());
        return list.toArray(new String[]{});
    } 
    //6
    public static int ulam(int numb){
    Map<Integer, Integer> savedSums = new TreeMap<>();
    ArrayList<Integer> ulams = new ArrayList<>();
    ulams.add(1);
    ulams.add(2);
    ulams.add(3);
    for (int i = 2; i < numb - 1; i++) {
        Integer newSum = null;
        for (int k = 0; k < i; k++) {
            int currentSum = ulams.get(ulams.size() - 1) + ulams.get(k);
            if (newSum == null && !savedSums.containsKey(currentSum)) {
                newSum = currentSum;
            }
            savedSums.merge(currentSum, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> en : savedSums.entrySet()) {
            if (newSum > en.getKey() && en.getValue() == 1) {
                newSum = en.getKey();
                break;
            }
        }
        ulams.add(newSum);
        savedSums.remove(newSum);
    }
    return ulams.get(numb - 1);
    }
    //7
    public static String longestNonrepeatingSubstring(String word){
        String temp="";
        char[] ar = word.toCharArray();
        Map<Integer, String> longest = new TreeMap<>(); 
        for(int i=0;i<ar.length;i++){
            temp+=ar[i];
            char[] checker = temp.toCharArray();
            for(int j=0;j<checker.length && checker.length != ar.length;j++){
                if(checker[j]==ar[checker.length]){
                    longest.put(checker.length, temp);
                    temp="";
                }
            }
        }
        if(temp.length()==ar.length){
            longest.put(ar.length,temp);
        }
        int maxlength =0;
        for(Map.Entry<Integer, String> en : longest.entrySet()){
            if(maxlength<en.getKey()){
                maxlength=en.getKey();
            }
        }
        
        return longest.get(maxlength);
    }
    //8
    public enum Roum {
        MMM(3000),
        MM(2000),
        M(1000),
        CM(900),
        DCCC(800),
        DCC(700),
        DC(600),
        D(500),
        CD(400),
        CCC(300),
        CC(200),
        C(100),
        XC(90),
        LXXX(80),
        LXX(70),
        LX(60),
        L(50),
        XL(40),
        XXX(30),
        XX(20),
        X(10),
        IX(9),
        VIII(8),
        VII(7),
        VI(6),
        V(5),
        IV(4),
        III(3),
        II(2),
        I(1);

        final int arab;

        Roum(int arab) {
            this.arab = arab;
        }
    }
    private static String convertToRoman(int n) {
        Roum[] roums = Roum.values();
        StringBuilder builder = new StringBuilder();
        for (Roum roum : roums) {
            if (n - roum.arab >= 0) {
                builder.append(roum.name());
                n -= roum.arab;
            }
        }
        return builder.toString();
    }
    //9
    private static boolean formula(String s) {
        String[] expressions = s.split("=");
        Pattern patternDigit = Pattern.compile("\\d+");
        Matcher matcherDigit = patternDigit.matcher("");
        Pattern patternOperators = Pattern.compile("[*/+-]");
        Matcher matcherOperators = patternOperators.matcher("");
        Double lastResult = null;
        for (String expr : expressions) {
            ArrayList<Integer> digits = new ArrayList<>();
            ArrayList<Character> operators = new ArrayList<>();
            matcherOperators.reset(expr);
            matcherDigit.reset(expr);
            
            while (matcherDigit.find()) {
                digits.add(Integer.parseInt(matcherDigit.group()));
            }
            while (matcherOperators.find()) {
                operators.add(matcherOperators.group().charAt(0));
            }
            if (digits.size() != operators.size() + 1) {
                return false;
            }
            double currentDouble = digits.get(0);
            for (int i = 0; i < operators.size(); i++) {
                int newInt = digits.get(i + 1);
                switch (operators.get(i)) {
                    case '*': {
                        currentDouble *= newInt;
                        break;
                    }
                    case '/': {
                        currentDouble /= newInt;
                        break;
                    }
                    case '+': {
                        currentDouble += newInt;
                        break;
                    }
                    default: {
                        currentDouble -= newInt;
                        break;
                    }
                }
            }
            if (lastResult != null && currentDouble != lastResult) {
                return false;
            }
            lastResult = currentDouble;
        }
        return true;
    }
    //10
    public static boolean palindromeDescendant(int numb){
        if(numb<10){
            return false;
        }
        while (numb > 10) {
            String numberStr = "" + numb;
            String reversedStr = new StringBuilder(numberStr).reverse().toString();
            if (numberStr.equals(reversedStr)) {
                return true;
            }
            
            if (numberStr.length() % 2 != 0) {
                return false;
            }
            
            StringBuilder newStrBuilder = new StringBuilder();
            for (int i = 0; i <= numberStr.length() - 2; i += 2) {
                newStrBuilder.append(Integer.parseInt(numberStr.substring(i, i + 1)) + Integer.parseInt(numberStr.substring(i + 1, i + 2)));
            }
            numb = Integer.parseInt(newStrBuilder.toString());
        }
        return false;
    }

}

