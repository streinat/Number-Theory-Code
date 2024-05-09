import java.util.ArrayList;
import java.lang.*;
public class checkAllPatterns86
{
    public static ArrayList<Integer> solution = new ArrayList<Integer>();
    public static ArrayList<Integer> negatives = new ArrayList<Integer>();
    public static ArrayList<Integer> sides = new ArrayList<Integer>();
    public static int min = 0;
    public static int depth = 4;
    public static int mod = 36;
    public static int n = 14;
    
    public static void main(String[] args)
    {
        int length = 0;
        for(int a = 0; a<36;a++)
        {
            for(int b = 0; b<36;b++)
            {
                System.out.println("calculating...");
                for(int c = 0; c<36;c++)
                {
                    for(int d = 0; d<36;d++)
                    {
                        
                        for(int e = 0; e<36;e++)
                        {
                            for(int f = 0; f<36;f++)
                            {

                                int count = 0;
                                for(int i = 3; i<depth; i++)
                                {

                                    length = i*mod+n;
                                    setup(length, a, b, c, d, e, f);
                                    //System.out.println(a+" "+b+ " "+c+ " "+d + " " + e + " " + f + " "+ g);
                                    // if(length == 34)
                                    // {
                                        //  System.out.print((length) + " ");
                                        //  System.out.println(correct(length) && lengthy(length));
                                    // }
                                    if(correct(length) && lengthy(length) && length != 86)
                                    {
                                        // System.out.println(" ");
                                        // System.out.println(a+" "+b+ " "+c+ " "+d + " " + e + " " + f + " "+ g);
                                        // System.out.print((length) + " ");
                                        // System.out.println(correct(length) && lengthy(length));
                                        // count++;
                                        System.out.println("SOLUTION!");
                                        System.out.println(a+" "+b+ " "+c+ " "+d + " " + e + " " + f);
                                        System.exit(0);
                                    }
                                    //printFancy(solution);
                                    //print(solution);
                                    //print(sides);
                                    clear();

                                }
                                // if(count > depth-5){
                                //     System.out.println("SOLUTION!");
                                //     System.out.println(a+" "+b+ " "+c+ " "+d + " " + e + " " + f + " "+ g);
                                //     System.exit(0);
                                // }
                            }
                        }
                    }
                }
            }

        }
        System.out.println("End of check");
        System.exit(0);
    }

    public static void setup(int length, int a, int b, int c, int d, int e, int f)
    {
        int evens = 1;
        int odds = 1;
        for(int i =0; i<length; i++)
        {
            if(i%2==1)
            {
                solution.add(evens);
                evens++;

            }
            else if(i%2==0)
            {
                
                solution.add(length-odds);
                odds++;

            }
        }
        solution.set(solution.size()-2, -1);
     
        rule86(length, a, b, c, d, e, f);

        
    }

    public static void ruleA(int length)
    {  
        int y = (length-4)/2;
        delete(1);
        insert(0, 2*y+4);
        solution.add(0);
        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));
        }
    }

    public static void rule4(int length)
    {   
        int y = (length-4)/2;
        delete(solution.indexOf(2*y+1));
        solution.add(2*y+4);
        solution.add(0);

        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));
        }

    }

    public static void rule14(int length, int a, int b, int c, int d)
    {
        int y = length/mod;
        int temp = delete(solution.indexOf(a*y+8));
        insert(solution.indexOf(b*y+9), temp);
        int num1 = delete(solution.indexOf(c*y+5));
        int num2 = delete(solution.indexOf(d*y+6));
        solution.add(num2);
        solution.add(num1);
        solution.add(0);

        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));
        }

    }

    public static void rule86(int length, int a, int b, int c, int d, int e, int f)
    {
        int y = length/mod;
        int temp = delete(solution.indexOf(a*y+(39-2*a)));//39
        insert(solution.indexOf(a*y+(38-2*a)), temp);//38

        temp = delete(solution.indexOf(b*y+(46-2*b)));//46
        insert(solution.indexOf(b*y+(47-2*b)), temp);//47
        
        int num3 = delete(solution.indexOf(c*y+(45-2*c)));//45
        int num4 = delete(solution.indexOf(d*y+(40-2*d)));//40
        delete(solution.indexOf(b*y+(48-2*b)));//48

        int num1 = delete(solution.indexOf(e*y+(15-2*e))); //15
        int num2 = delete(solution.indexOf(e*y+(16-2*e))); //16

        insert(solution.indexOf(f*y+(57-2*f)), length); //57
        insert(solution.indexOf(a*y+(39-2*a)), num3); //39
        insert(solution.indexOf(a*y+(37-2*a)), num4); //37

        solution.add(num2);
        solution.add(num1);
        solution.add(0);

        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));
        }

    }

    public static void rule86place(int length)
    {
        int temp = delete(length-9);
        insert(length-9, solution.get(length-11));
        delete(length-11);
        insert(length-11, temp);

        temp = delete(length-8);
        insert(length-8, solution.get(length-10));
        delete(length-10);
        insert(length-10, temp);

        int num3 = delete(length-6);
        int num4 = delete(length-7);
        delete(length-12);

        int num1 = delete(length-57);
        int num2 = delete(length-57);

        insert(length-30, length);
        insert(length-15, num3);
        insert(length-17, num4);

        solution.add(num2);
        solution.add(num1);
        solution.add(0);

        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));
        }

    }

    public static void rule50(int length, int a, int b, int c, int d)
    {
        int y = length/mod;
        int num1 = delete(solution.indexOf(a*y+(10-a)));//10
        int num2= delete(solution.indexOf(b*y+(11-b)));//11
        delete(solution.indexOf(c*y + (33-c))); //33
        insert(solution.indexOf(d *y +(30-d)), length); //30
        solution.add(num2);
        solution.add(num1);
        solution.add(0);
        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));

        }
    }

    public static void ruleTest(int length, int a, int b, int c, int d)
    {
        solution.add(-1);
        solution.add(solution.get(length-4));
        delete(length-4);
        int y = length/12;
        int num1 = delete(solution.indexOf(a*y+(5-2*a)));//5
        int num2= delete(solution.indexOf(b*y+(6-2*b)));//6
        delete(solution.indexOf(c*y + (14-2*c))); //14
        insert(solution.indexOf(d *y +(21-2*d)), length); //21
        solution.add(num2);
        solution.add(num1);
        solution.add(0);
        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));

        }
        
    }


    public static void ruleTest2(int length, int a, int b, int c, int d)
    {
        //solution.add(-1);
        //solution.add(solution.get(length-4));
        //delete(length-4);
        int y = length/12;
        int num1 = delete(solution.indexOf(a*y+(6-2*a)));//6
        int num2= delete(solution.indexOf(b*y+(7-2*b)));//7
        delete(solution.indexOf(c*y + (21-2*c))); //21
        insert(solution.indexOf(d *y +(23-2*d)), length); //23
        solution.add(num2);
        solution.add(num1);
        solution.add(0);
        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));

        }
        
    }

    public static void rule50place(int length)
    {
        int num1 = delete(length-31);
        int num2 = delete(length-31);
        insert(length-12, length);
        delete(length-18);
        solution.add(num2);
        solution.add(num1);
        solution.add(0);
        if(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));
        }
    }

    public static void insert(int index, int num)
    {
        if(!(index<0))
        {
            int temp = solution.remove(index);
            solution.add(index, num);
            for(int i = index; i+2<solution.size(); i++)
            {
                solution.add(i+2, temp);
                temp = solution.remove(i+3);
                i++;
            }
        }

    }

    public static int delete(int index)
    {
        if(index<0)
        {
            return -1;
        }
        int temp = solution.remove(index);
        for(int i = index-1; i+2<solution.size(); i++)
        {
            solution.add(i+1, solution.get(i+2));
            solution.remove(i+3);
            i++;
        }
        solution.add(solution.size()-1, -1);
        return temp;

    }

    public static void clear()
    {
        int temp = solution.size();
        for(int i = 0; i<temp; i++)
        {
            solution.remove(0);
        }
    }
    public static void print(ArrayList<Integer> arr)
    {
        for(int i =0; i<arr.size(); i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(" ");

    }

    public static void printFancy(ArrayList<Integer> arr)
    {
        System.out.println(" ");
                System.out.print(" ");
        for(int i =0; i+1<arr.size(); i++)
        {
            i++;
            if(arr.get(i)<10&& arr.get(i)>-1)
            {
                System.out.print(" ");
            }
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(" ");
        for(int i =0; i<arr.size(); i++)
        {
            if(arr.get(i)<10&& arr.get(i)>-1)
            {
                System.out.print(" ");
            }
            System.out.print(arr.get(i) + " ");
            i++;
        }
        System.out.println(" ");


    }

    public static boolean correct(int length)
    {
        int temp = sides.size();
        for(int i = 0; i<temp; i++)
        {   
            sides.remove(0);
        }
        for(int i = 1; i<solution.size()-1; i++)
        {
            sides.add(solution.get(i-1) - solution.get(i));
            sides.add(solution.get(i+1) - solution.get(i));
            i++;
        }
        if(solution.size()%2==0)
        {    
            sides.add(solution.get(solution.size()-2) - solution.get(solution.size()-1));
        }
        if(solution.size() == length)
        {
            sides.add(solution.get(0) - solution.get(solution.size()-1));
        }

        if(solution.size() == length)
        {
            min = 0;
            int tempor = negatives.size();
            for(int i = 0; i<tempor; i++)
            {   
                negatives.remove(0);
            }
            for(int i = 0; i<sides.size(); i++)
            {
                if(sides.get(i)<min)
                {
                    min = sides.get(i);
                }
            }  
            for(int j = min; j<0; j++)
            {
                negatives.add(j);
            }
            for(int i = 0; i<sides.size(); i++)
            {
                if(sides.get(i)<0)
                {
                    if(negatives.indexOf(sides.get(i)) != -1)
                    {
                        negatives.remove(negatives.indexOf(sides.get(i)));
                    }
                }   
            }  
            if(negatives.size() > 0)
            {
                for(int i =0; i<sides.size(); i++)
                {
                    if(sides.get(i) <0)
                    {
                        sides.set(i, sides.get(i)+length+1);
                    }
                }
                return false;
            }
        }
        
        for(int i =0; i<sides.size(); i++)
        {
            if(sides.get(i) <0)
            {
                sides.set(i, sides.get(i)+length+1);
            }
        }
        for(int i =0; i<sides.size(); i++)
        {
            for(int j =0; j<sides.size(); j++)
            {
                if(i!=j)
                {
                    if(sides.get(j).equals(sides.get(i)))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean lengthy(int length)   
    {
        if(sides.size()==length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}