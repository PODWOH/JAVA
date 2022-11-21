package tasks;
import java.util.*;
import java.io.StreamCorruptedException;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;


public class tusk5 {
    public static void main(String[] args){
        //1
        encrypt("Sunshine");
        System.out.println("");
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        //2
        System.out.println(canMove("Queen", "C4", "D6"));
        //3
        System.out.println(canComplete("bbutl", "beautiful"));
        //4
        System.out.println(sumDigProd(new int[]{1, 2, 3, 4, 5, 6}));
        //5
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"})));
        //6
        System.out.println(validateCard(1234567890123452L));
        //7 
        System.out.println(numToEng(126));
        //8
        System.out.println(getSha256Hash("password123"));
        //9
        correctTitle("jOn SnoW, kINg IN thE noRth.");
        //10
        System.out.println(hexLattice(19));
        
    }

    //1
    public static void encrypt(String s){
        int temp=0;
        for(char c : s.toCharArray()){
                System.out.print((Character.hashCode(c)-temp)+",");
                temp = (char)Character.hashCode(c);
        }
    }
    public static String decrypt(int[] s){
        char[]  chars= new char[s.length];
        char temp =0;
        for(int i=0;i<s.length;i++){
            chars[i]=(char)(temp+s[i]);
            temp=chars[i];
        }

        return new String(chars);
    }
    //2

    public static boolean canMove(String f,String from, String to){
        String Pawn = "Pawn";
        String Rook = "Rook";
        String Horse = "Horse";
        String Bishop = "Bishop";
        String Queen = "Queen";
        String King = "King";
      
        int startY = Integer.parseInt(String.valueOf(from.charAt(1)));
        char startX = from.charAt(0);
        int toY = Integer.parseInt(String.valueOf(to.charAt(1)));
        char toX = to.charAt(0);
        
        if(startX == toX && (Math.abs(toY-startY)==1 )){
            return f.compareTo(Pawn)==0;
        }   

        if((startX==toX && startY != toY) ||  (startX != toX && startY == toY)){
            return f.compareTo(Rook)==0 || f.compareTo(Queen)==0;
        }

        if(Math.abs(startX-toX)==Math.abs(startY-toY)){
            if(f.compareTo(Queen)==0 || f.compareTo(Bishop)==0){
                return true;
            }
            if(Math.abs(startX-toX)==1){
                return f.compareTo(King)==0;
            }
        }

        if((Math.abs(startX - toX) == 1 && Math.abs(startY - toY) == 2)|| (Math.abs(startY - toY) == 1 && Math.abs(startX - toX) == 2)){
            return f.compareTo(Horse)==0;
        }

            


        return false;
    }
    //3
    
    public static boolean canComplete(String s, String s1){
        char[] ar = s.toCharArray();
        char[]  arg = s1.toCharArray();
        int[] mas = new int[s.length()];
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<arg.length;j++){
                if(s.charAt(i)==s1.charAt(j)){
                    mas[i]=j;
                    break;
                }
            }
        }
        for(int i=0;i<mas.length;i++){
            for(int j=i+1;j<mas.length;j++){
                if(mas[i] >= mas[j]){
                    return false;
                }
            }
        }

        return true;
    }
    //4
    public static int skdfsdkf(int pr){
        int temp=1;
        while (pr>0){
            temp*=(pr%10);
            pr/=10;
        }
        pr=temp;
        return pr;
    }
    public static int sumDigProd(int[] mas){
        int pr=0;
        int temp =1;
        for(int i=0;i<mas.length;i++){
            pr+=mas[i];
        }
        while (pr>10){
            pr=skdfsdkf(pr);
        }

        return pr;
    }
    //5
    public static String[] sameVowelGroup(String[] s){
        HashSet<Character> main = new HashSet<>();
        String first = s[0].replaceAll("[qwrtpsdfghjklzxcvbnm]", "");
        for(char ar : first.toCharArray()){
            main.add(ar);
        }

        ArrayList<String> list =  new ArrayList<>();
        list.add(s[0]);
        for(int i=1;i<s.length;i++){
            HashSet<Character> temp = new HashSet<>();
            String second = s[i].replaceAll("[qwrtpsdfghjklzxcvbnm]", "");
            for(char arg : second.toCharArray()){
                temp.add(arg);
            }
            if(main.equals(temp)){
                list.add(s[i]);
            }

        }

        return list.toArray(new String[list.size()]);
    }
    //6
    public static boolean validateCard(Long numb){

        if (numb< Math.pow(10, 14) || numb > Math.pow(10, 19)) {
            return false;
        }

        int controlNumb = (int)(numb%10);
        String number = numb.toString();
        number = number.substring(0, number.length()-1);
        int sum = 0;
        for (int i = number.length()-1; i >= 0; i--) {
            int doubledInteger = Integer.parseInt(number.substring(i, i+1));
            if ((number.length()- i)%2 == 1) {
                doubledInteger*=2;
                if (doubledInteger > 9) {
                    doubledInteger = doubledInteger % 10 + (doubledInteger / 10) % 10;
                }
            }
            sum+= doubledInteger;
        }
        return (10 - (sum%10)) == controlNumb;
    } 
    //7
    public static String onenumb(int n){
        switch (n) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return null;
        }
    }
    public static String tento(int n){
        switch (n) {
            case 0:
                return "ten";
            case 1:
                return "eleven";
            case 2:
                return "twelve";
            case 3:
                return "thirteen";
            case 4:
                return "fourteen";
            case 5:
                return "fifteen";
            case 6:
                return "sixteen";
            case 7:
                return "seventeen";
            case 8:
                return "eighteen";
            case 9:
                return "nineteen";
            default:
                return null;
        }
    }
    public static String sTwenty(int n){
        switch (n) {
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
            default:
                return null;
        }
    }
    public static String numToEng(int numb){
        int hundred = (numb / 100)%10;
        int dec = (numb / 10) %10;
        int n = numb % 10;
        String hundr = onenumb(hundred);
        String solo="";
        String decs="";
        if(dec!=1){
            solo=onenumb(n);
            if(n==0){
                solo="zero";
            }
            decs=sTwenty(dec);
        }
        else{
            decs=tento(n);
        }
        String temp="";
        if(hundr != null){
            temp+=hundr+ " "+"hundred" +" ";
        }   
        if(decs != null){
            temp+=decs+" ";
        }
        if(solo != null){
            temp+=solo;
        }



        return temp;
    }  
    //8
    private static String getSha256Hash(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }

    //9

    public static void correctTitle(String s){
        String[] word = s.split(" ");
        String temp="";
        for(int i=0;i<word.length;i++){
            if(i>2 && i<word.length-1){
                temp+=word[i].substring(0).toLowerCase()+" ";
            }
            else{
                temp+=word[i].substring(0,1).toUpperCase()+word[i].substring(1).toLowerCase()+" ";
            }
            
        }
        System.out.println(temp);
    }   

    //10
    public static String hexLattice(int n) {
        int Cycle = 1;
        int currentElements = 1;
        while (currentElements < n) {
            currentElements+= 6*Cycle;
            Cycle+=1;
        }
        if (currentElements != n) {
            return "invalid";
        }
        int Size = Cycle* 2 - 1;
        int SizeWithSpaces = Size* 2 - 1;
        String[] hex = new String[Size];
        for (int i = Cycle - 1; i >= 0; i--) {
            int rowSizeWithSpaces = (Cycle + i)*2 - 1;
            int spaceInLeft = (SizeWithSpaces - rowSizeWithSpaces)/2;
            hex[i] = " ".repeat(spaceInLeft) + "o".repeat(Cycle + i).replaceAll(".(?=.)", "$0 ") + " ".repeat(spaceInLeft);
            if (i <= Cycle - 1) {
                hex[Size - i - 1] = hex[i];
            }
        }
        StringJoiner joiner = new StringJoiner("\n");
        for (String h: hex) {
            joiner.add(h);
        }
        return joiner.toString();
    }
}   

