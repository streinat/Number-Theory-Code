import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;


public class checkSolution 
{
    public static int length;
    public static ArrayList<Integer> solution = new ArrayList<Integer>();
    public static ArrayList<Integer> negatives = new ArrayList<Integer>();
    public static ArrayList<Integer> sides = new ArrayList<Integer>();
    public static int min = 0;
    
    public static void main(String[] args)
    {
        length = setup();
        if(correct() && lengthy())
        {
            System.out.println("correct");
            // System.out.println(solution.size());
            // print(solution);
            // print(sides);
        }
        else
        {
            System.out.println("incorrect");
            // System.out.println(solution.size());
            // print(solution);
            // print(sides);
        }

    }

    public static int setup()
    {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Input solution of length " + length);
        String temp = "49 1 48 2 47 3 46 4 45 5 44 6 43 7 42 8 41 9 40 12 39 13 38 14 37 15 36 16 35 17 34 18 32 19 31 20 50 21 30 22 29 23 28 24 27 25 26 11 10 0 ";
        int count = 0;
        for(int i = 0; i<temp.length(); i++)
        {
            if(temp.substring(i,i+1).trim().isEmpty())
            {
                solution.add(Integer.parseInt(temp.substring(i-count,i)));
                count = 0;
            }
            else
            {
                count++;
            }
        }
        return solution.size();
    }
    
    public static boolean lengthy()   
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

    public static boolean correct()
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

    public static void print(ArrayList<Integer> arr)
    {
        for(int i =0; i<arr.size(); i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(" ");

    }
}