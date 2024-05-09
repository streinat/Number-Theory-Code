import java.util.ArrayList;
import java.lang.*;
public class solutionUsingPattern50 
{
    public static ArrayList<Integer> solution = new ArrayList<Integer>();
    public static ArrayList<Integer> negatives = new ArrayList<Integer>();
    public static ArrayList<Integer> sides = new ArrayList<Integer>();
    public static int min = 0;
    public static int depth = 1;
    public static int mod = 36;
    public static int n = 86;
    
    public static void main(String[] args)
    {
        int length = 50;
        for(int a = 0; a<length;a++)
        {
            System.out.println("calculating...");
            for(int b = 0; b<length;b++)
            {
                for(int c = 0; c<length;c++)
                {
                    for(int d = 0; d<length;d++)
                    {
                        //int count = 0;
                        // for(int i = 0; i<depth; i++)
                        // {
                        //System.out.println(a+" "+b+ " "+c+ " "+d + " " + e);
                        setup(length, a, b, c, d);
                        // if(length == 34)
                        // {
                        //     System.out.print((length) + " ");
                        //     System.out.println(correct(length) && lengthy(length));
                        // }
                        if(correct(length) && lengthy(length))
                        {
                            //System.out.println(" ");
                            System.out.println(a+" "+b+ " "+c+ " "+d);
                            //System.out.print((length) + " ");
                            //System.out.println(correct(length) && lengthy(length));
                            print(solution);
                            //print(sides);
                        }
                        //print(solution);

                        //printFancy(solution);
                        //print(sides);
                        clear();

                        // }

                    }
                }
            }

        }
        System.out.println("End of check");
        System.exit(0);
    }

    public static void setup(int length, int a, int b, int c, int d)
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
     
        rule(length, a, b, c, d);

        
    }

    public static void rule(int length, int a, int b, int c, int d)
    {
        int y = length/mod;
        int num1 = delete(solution.indexOf(a));//10
        int num2= delete(solution.indexOf(b));//11
        delete(solution.indexOf(c)); //33
        //int temp = solution.indexOf(e);
        // print(solution);
        // System.out.println(temp+2);
        // if(temp+2<length)
        // {
        //     System.out.println(solution.get(temp+2));
        // }
        // print(solution);
        insert(solution.indexOf(d), length); //30
        solution.add(num2);
        solution.add(num1);
        solution.add(0);
        while(solution.indexOf(-1)>-1)
        {
            solution.remove(solution.indexOf(-1));

        }
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

    public static void rule86(int length)
    {
        int y = length/mod;
        int temp = delete(solution.indexOf(18*y+3));//39
        insert(solution.indexOf(18*y+2), temp);//38

        temp = delete(solution.indexOf(18*y+10));//46
        insert(solution.indexOf(18*y+11), temp);//47
        
        int num3 = delete(solution.indexOf(18*y+9));//45
        int num4 = delete(solution.indexOf(18*y+4));//40
        delete(solution.indexOf(18*y+12));//48

        int num1 = delete(solution.indexOf(18*y-21)); //15
        int num2 = delete(solution.indexOf(18*y-20)); //16

        insert(solution.indexOf(18*y+21), length); //57
        insert(solution.indexOf(18*y+3), num3); //39
        insert(solution.indexOf(18*y+1), num4); //37

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