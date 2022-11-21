package tasks;
public class task1 {
    public static void main(String[] args){
        System.out.println(reminders(1, 3));
        System.out.println(triAngles(10, 20));
        System.out.println(animal(2, 3, 5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(proverka(24, 15, 9));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(3));
        System.out.println(nextEdge(9,8));
        int numb[] = new int[]{1,5,9};
        System.out.println(sumofCubes(numb));
        System.out.println(abcmatch(5,2,2));
        
    }

    public static int reminders (int a, int b)
    {
        return a%b;
    }


    public static double triAngles (float height, float length)
    {
        return (0.5 * height * length);
    }

    public static int animal (int chickens, int cows, int pigs)
    {
        return chickens * 2 + cows * 4 + pigs * 4;
    }

    public static boolean profitableGamble(double prob, double prize, double pay)
    {
        return (prob * prize > pay);
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
    public static int ctoa (char a)
    {
        return a;
    }
    public static int addUpTo (int a)
    {
        int sum = 0;
        for (int i = 1; i <= a; i++)
        {
            sum += i;
        }
        return sum;
    }
    public static int nextEdge(int a, int b){
        return a+b-1;
    }
    public static int sumofCubes(int cubes[]){
        int sum=0;
        for (int i=0;i<cubes.length;i++){
            sum = sum + cubes[i] * cubes[i] * cubes[i];
        }
        return sum;
    }
    public static boolean abcmatch(int a, int b, int c){
        int sum = 0;
        for (int i = 0;i<b;i++){
            sum += a;
        }
        if(sum%c==0){
            return true;
        }
        return false;
    }
}
