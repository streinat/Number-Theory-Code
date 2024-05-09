import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class allSolutions 
{
    public static int length = 6;
    public static ArrayList<Integer> total = new ArrayList<Integer>();
    public static ArrayList<Integer> solution = new ArrayList<Integer>();
    public static ArrayList<Integer> negatives = new ArrayList<Integer>();
    public static ArrayList<Integer> sides = new ArrayList<Integer>();
    public static int[][] used = new int[length][length+1];
    public static int place = length-1;
    public static int min = 0;
    
    public static void main(String[] args)
    {
        setup();
        solve();
    }

    public static void setup()
    {
        for(int i =0; i<used.length; i++)
        {
            for(int j =0; j<used[i].length; j++)
            {
                used[i][j] = j;
            }
        }
        int evens = 1;
        int odds = 0;
        for(int i =0; i<length; i++)
        {
            if(i%2==1)
            {
                solution.add(i, used[i][evens]);
                evens++;

            }
            else if(i%2==0)
            {
                
                solution.add(used[i][used.length-odds]);
                odds++;

            }

        }

        
    }

    public static void solve()
    {
        while(true)
        {
            while(!correct() || !lengthy())
            {
                runUsed();
                //print(solution); 
                //print(sides);
                //System.out.println();
                //print2D(used); 
                //System.out.println(correct());
                if(correct())
                {
                    place++;
                    solution.add(place, newNumber(used[place]));

                }
                else if (newNumber(used[place])==-1)
                {
                    while(newNumber(used[place])==-1)
                    {
                        solution.remove(place);
                        place--;
                        if(place<0){
                            print();
                            System.exit(0); 
                        }
                        runUsed();
                    }
                    solution.set(place, newNumber(used[place]));
                }   
                else
                {
                    solution.set(place, newNumber(used[place]));
                }
            }
            add();
            //print(sides)
            runUsed();
            if (newNumber(used[place])==-1)
            {
                while(newNumber(used[place])==-1)
                {
                    solution.remove(place);
                    place--;
                    runUsed();
                }
                solution.set(place, newNumber(used[place]));
            }   
            else
            {
                solution.set(place, newNumber(used[place]));
            }
        }
    }
    public static void runUsed()
    {
        for(int i = place; i<used.length; i++)
        {
            for(int j=0; j<used[i].length; j++)
            {
                if(used[i][j] >=0)
                {
                    if(insolution(used[i][j]))
                    { 
                        used[i][j] += -(length+1);
                    }
                }
                else
                {
                    if(!insolution(used[i][j] +length+1) && i != place)
                    {
                        used[i][j] += length+1;
                    }
                }
            }
        }
    }

    public static boolean insolution(int x)
    {
        for(int i=0; i<solution.size();i++)
        {
            if(x==solution.get(i))
            {
                return true;
            }
        }
        return false;
    }
    public static int newNumber(int[] used)   
    {
        int even = 0;
        int odd = length;
        int negative = 0;
        for(int i =0; i<used.length; i++)
        {
            if(used[i] >= 0)
            {
                if(used[i] > even)
                {
                    even = used[i];
                }
                if(used[i] < odd)
                {
                    odd= used[i];
                }
            }
            else
            {
                negative++;
            }
        }

        
        if(negative == used.length)
        {
            return -1;
        }
        else if(place%2==0)
        {
            return even;
        }
        else
        {
            return odd;
        }
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
                    if(sides.get(j) == sides.get(i))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void print2D(int[][] used)
    {
        for(int i =0; i<used.length; i++)
        {
            for(int j =0; j<used[i].length; j++)
            {
                System.out.print(used[i][j]);
            }
            System.out.println();

        }
    }
    public static void add()
    {
        for(int i =0; i <solution.size();i++)
        {
            total.add(solution.get(i));
        }
    }

    public static void print()
    {
        int count = 0; 
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("Solutions.txt"));
            
            for(int i =0; i<total.size(); i++)
            {
                out.write(total.get(i) + " ");
                count++;
                if(count==length)
                {
                    out.write("\n");
                    count = 0;
                }
            }

            out.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        // for(int i =0; i<total.size(); i++)
        //     {
        //         System.out.print(total.get(i) + " ");
        //         count++;
        //         if(count==length)
        //         {
        //             System.out.println(" ");
        //             count=0;
        //         }
        //     }
    }
}