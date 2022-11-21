package tasks;
public class tusk {
    public static void main(){
        System.out.println(proverka(24, 15, 9));
        
    }

    public static String proverka(int N,int  a,int b){
        String itog = "";
        if (a+b==N){
            itog ="Sum";
           
        }
        else if (a-b==N){
            itog ="razn";
           
        }
        else if(a/b==N){
            itog="del";
           
        }
        else if(a*b==N){
            itog="proz";
        }

        return itog;
    }
}
