package tasks;

public class task2 {
    public static void main(String[] args){
        //1
        repeat("lol", 5);
        //2
        int x=2;
        int[] mas = new int[x];
        GenerateMas(mas);
        System.out.println("");
        MassCout(mas);
        int razn;
        razn = differenceMaxMin(mas, x);
        System.out.println(" ");
        System.out.println(razn);
        //3
        if (isAvgWhole(mas)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        //4
        int[] secmas = new int[x];
        cumulativeSum(mas,secmas);
        MassCout(secmas);
        System.out.println("");
        //5
        System.out.println(getDecimalPlaces("597"));
        //6
        Fibanachi(7);
        //7
        String word="58a58";
        if(INVALID(word)){
            System.out.println(word + " " + "true");
        }
        //8
        String word1="sparkling";
        String word2="groups";
        if(isStrangePair(word1, word2)){
            System.out.println(word1 + " "+ word2+ " " + "true");
        }
        //9
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        //10
        System.out.println(box(6));
    }
    //1
    public static void repeat(String word, int n){
        char[]  repeet = word.toCharArray();
        for (int i = 0; i< repeet.length; i++){
            for (int j=0;j<n;j++){
                System.out.print(repeet[i]); 
            }
        }
    }
    //2
    public static void GenerateMas(int[] mas){
        for(int i=0;i<mas.length;i++){
            mas[i]=(int)Math.round((Math.random()*100)-100);
        }
    }

    public static void MassCout(int[] mas){
        for (int i=0;i<mas.length;i++){
            System.out.print(mas[i]+" , ");
        }
    }

    public static int differenceMaxMin(int[] mas,int n){
        int max = -1000;
        int min = 10000;
        for(int i=0;i<n;i++){
            if(mas[i]>max){
                max=mas[i];
            }
            if(mas[i]<min){
                min=mas[i];
            }
        }
        return max-min;
    }
    //3
    public static boolean isAvgWhole(int[] mas){
        int sum=0;
        for (int i=0;i<mas.length;i++){
            sum=sum+mas[i];
        }
        if(sum%mas.length==0){
            return true;
        }
        
        return false;
    }
    //4
    public static void cumulativeSum(int[] mas, int[] secmas){
        for(int i=0; i< mas.length;i++){
            secmas[i]=mas[i];
        }
        for(int i=0; i< mas.length;i++){   
            for(int j=0;j<i;j++){
                secmas[i]+=mas[j];
            }
           
        }
    }
    //5
    public static int getDecimalPlaces(String Wnumb){
        int dotplace =0;
        for (int i = 0; i < Wnumb.length(); i++)
        {
            if (Wnumb.charAt(i) == '.')
            {
                dotplace = Wnumb.length() - i - 1;
            }
        }
        return dotplace;
    }
    //6
    public static void Fibanachi(int numb){
        numb+=2;
        int[] mas = new int[numb];
        mas[0]=0;
        mas[1]=1;
        for(int i=2;i<mas.length;i++){
            mas[i]=mas[i-1]+mas[i-2];
        }
        System.out.println(mas[mas.length-1]);
        
    }
    //7
    public static boolean INVALID(String word){
        String space = " ";
        char[]  repeet = word.toCharArray();
        if(repeet.length>5){
            return false;
        }
        for (int i = 0; i< repeet.length; i++){
            if(Character.isWhitespace(repeet[i])){
                return false;
            }
            if(Character.isLetter(repeet[i])){
                return false;
            }
        }
        return true;
    }
    //8
    public static boolean isStrangePair(String word1, String word2){
        char[]  repeet1 = word1.toCharArray();
        char[]  repeet2 = word2.toCharArray();
        if(repeet1[0]==repeet2[repeet2.length-1]){
            if(repeet1[repeet1.length-1]==repeet2[0]){
                return true;
            }
        }
        return false;
    }
    //9
    public static boolean isPrefix(String word, String prefix)
    {
        
        prefix = prefix.substring(0, prefix.length() - 1);
        
        if(word.matches(String.format("^(?:%s).*", prefix)))
        {
            return true;
        }
        return false;
    }
    public static boolean isSuffix(String word, String suffix)
    {
        suffix = suffix.substring(1);
        
        if(word.matches(String.format("(.*(?:%s)$)", suffix)))
        {

            return true;
        }

        return false;
    }
    //10
    public static int box(int step)
    {
        int sum = 0;

        for (int i = 1; i <= step; i++)
        {
            if (i % 2 == 0)
            {
                sum -= 1;
            }
            else
            {
                sum += 3;
            }
            
        }
        return sum;
    }
}
