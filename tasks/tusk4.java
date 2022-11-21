package tasks;

import javax.imageio.ImageReadParam;
import javax.print.DocFlavor.STRING;
import javax.print.attribute.standard.PrinterLocation;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.util.*;


public class tusk4 {
    public static void main(String[] args){
        //1
        System.out.println(esse(10,7,"hello my name is Bessie and this is my essay"));
        //2
        split("(((()))) ()");
        //3
        toCamelCase("hello_edabit");
        toSnakeCase("helloEdabit");
        //4
        System.out.println(overTime(13.25, 15, 30, 1.5));
        //5
        System.out.println(BMI("205 pounds", "73 inches"));
        //6
        System.out.println(bugger(999));
        //7
        
        toStarShorthand("77777geff");
        //8
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        //9
        System.out.println(trouble(666789, 12345667));
        //10
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
    }
        //1
    public static String esse(int n, int k, String word){
        String[] words = word.split(" ");
        if(words.length>n){
            return "not correct data";
        }
        String s="";
        int spaces=0;
        System.out.println(s.length()+" "+words[1].length());
        for(int i=0;i<n;i+=0){

            while(s.length()+words[i].length()-spaces<=k){
                s+=words[i]+" ";
                spaces++;
                i++;
                if(i>=n){
                    return s.strip();
                }
                
            }
            s.strip();
            System.out.println(s);
            s="";
            spaces=0;
        }
           
        
        return "pivo";
    }
    //2
    public static void split(String word){
        char[] ar = word.toCharArray();
        String s="";
        String temp="";
        int left=0;
        int right=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]!=' '){
                if(ar[i]=='('){
                    left++;
                    s+=ar[i];
                }
                else if(ar[i]==')'){
                    right++;
                    s+=ar[i];
                }
                if(left==right){
                    temp+=s+",";
                    s="";
                    left=0;
                    right=0;
                }
            }
        }
        temp.strip();
        System.out.println(temp);

  
    }
    //3
    public static void toCamelCase(String word){
        String[] words = word.split("_");
        String s=words[0];
        for(int i=1;i<words.length;i++){
            s+=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
        }
        System.out.println(s);
    }
    public static void toSnakeCase(String word){
        char[] words = word.toCharArray();
        String s="";
        String temp="";
        for(int i=0;i<words.length;i++){
            temp+=words[i];
            if(Character.isUpperCase(words[i])){
                s+="_"+temp.substring(0).toLowerCase();
            }
            else{
                s+=temp;
            }
            temp="";
        }
        System.out.println(s);
    }
    //4
    public static String overTime(double start,double end,double Dperhour,double multiply){
        double normal;
        double multyplymoney=0;
        if(start<9 || start>24 || end>24){
            return "not correct data";
        }
        if(end>17){
            multyplymoney = (end-17)*Dperhour*multiply;
            normal=(17-start)*Dperhour;
        }
        else{
            normal=(end-start)*Dperhour;
        }
        System.out.println(normal+multyplymoney);
        return "";
    }
    //5
    public static String BMI(String p1,String p2){
        String[] parametr1 = p1.split(" ");
        String[] parametr2 = p2.split(" ");
        if(parametr1.length>2 || parametr2.length>2){
            return "not correct data";
        }
        double weight=Double.parseDouble(parametr1[0]);
        double height=Double.parseDouble(parametr2[0]);
        if(parametr1[1].compareTo("pounds")==0){
            weight*=0.45;
        }
        if(parametr2[1].compareTo("inches")==0){
            height*=0.025;
        }
        if(weight/(height*2)<18.5){
            return "Underwaight";
        }
        if(weight/(height*2)>18.5 && weight/(height*2)<25){
            return "Normal Weight";
        }
        if(weight/(height*2)>25){
            return "Overweight";

        }

        return "";
    }
    //6
    public static int findlenght(int numb){
        int i=1;
        while(numb/10!=0){
            numb/=10;
            i++;
        }
        return i;
    }
    public static int bugger(int numb){
        int iteration=0;
        int temp=1;
        if(numb/10==0){
            return 0;
        }
        while(numb/10!=0){
            int length = findlenght(numb);
            for(int i=0;i<length;i++){
                temp*=numb%10;
                numb/=10;
            }
            iteration++;
            numb= temp;
            temp=1;
        }
        return iteration;
    }
    //7
    public static void toStarShorthand(String word){
        char[] words = word.toCharArray();
        int iteration=1;
        String temp="";
        String s1="";
        String s2="";
        for(int i=0;i<words.length-1;i++){
            s1+=words[i];
            s2+=words[i+1];
            if(words[i]==words[i+1] || s1.compareTo(s2)==0){
                iteration++;
                s1="";
                s2="";
            }
            else{
                temp+=words[i];
                s1="";
                s2="";
            }
          
            if((words[i]!=words[i+1] || s1.compareTo(s2)!=0 || i==words.length-2) && iteration>1){
                if(i==words.length-2){
                    temp+=words[i];
                }
                temp+="*"+iteration;
                iteration=1;
                s1="";
                s2="";
            }
            
            
        }
        System.out.println(temp);
    }


    //8
    
    public static boolean doesRhyme(String w1, String w2){
        String temp="";
        String temp2="";
        String[] words1 = w1.split(" ");
        String[] words2 = w2.split(" ");
        char[] ar = words1[words1.length-1].toCharArray();
        char[] ar2 = words2[words2.length-1].toCharArray();
        for(int i=0;i<ar.length;i++){
            if(ar[i]=='a' || ar[i]=='o' || ar[i]=='e' || ar[i]=='i' || ar[i]=='u'){
                temp+=ar[i];
            }
        }
        for(int i=0;i<ar2.length;i++){
            if(ar2[i]=='a' || ar2[i]=='o' || ar2[i]=='e' || ar2[i]=='i' || ar2[i]=='u'){
                temp2+=ar2[i];
            }
        }

        return temp.compareTo(temp2)==0;
    }

    //9
    public static boolean trouble(int n1, int n2){
        int temp1, temp2, num1, num2, max1, max2, min1,min2;
        num1=num2=0;
        temp1=temp2=-10;
        min1=min2=1;
        max1=max2=0;
        for(int i=0;n1/10!=0 || n1>0;i++){
            if(n1/10==0){
                temp1=n1;
            }
            temp1=n1%10;
            n1/=10;
            if(temp2==temp1){
                min1++;
            }
            if(min1>max1){
                num1=temp1;
                max1=min1;
            }
            temp2=temp1;

        }
        if(max1<3){
            return false;
        }
        System.out.println(num1+" "+max1);
        temp1=temp2=-10;
        for(int i=0;n2/10!=0 || n2>0;i++){
            if(n2/10==0){
                temp1=n2;
            }
            temp1=n2%10;
            n2/=10;
            if(temp2==temp1){
                min2++;
            }
            if(min2>max2){
                num2=temp1;
                max2=min2;
            }
            temp2=temp1;

        }
        System.out.println(num2+" "+max2);
        if(max2<2 || max2>2){
            return false;
        }
        return num1==num2;
    }
    //10
    
    public static int countUniqueBooks(String s,char srW){
        HashSet<Character> Charakters = new HashSet<>();
        boolean open=false;
        for(char ar : s.toCharArray()){
            if(ar == srW){
                open= !open;
            }
            else if(open){
                Charakters.add(ar);
            }
        }

        return Charakters.size();
    }
}
