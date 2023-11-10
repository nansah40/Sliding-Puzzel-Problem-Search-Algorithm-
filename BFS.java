import java.util.*;

public class BFS
{
     
    public Scanner input = new Scanner(System.in);

    // goal state
    public int[][] goal  = {
        {1,2,3},
        {8,0,4},
        {7,6,5}
    };

    // list to hold visted nodes
    public ArrayList<Node> visited = new ArrayList<Node>();

    public boolean checkVisited(Node curNode)
    {
        for (Node n : visited)
        {
            if (curNode.isEqual(n))
            {
                return true;
            }
        }
        return false;
    }

    // Main search method using priprity que to process nodes with lowest cost first 
    public Node searchIterative(Node rootNode)
    {   
        int moveCounter = 0;
        ArrayList<Node> prioQue = new ArrayList<>();
        Node goalNode = new Node(this.goal);
        ArrayList<ArrayList<Integer>> options;
       
        prioQue.add(rootNode);

        while(prioQue.size() > 0)
        {
    
            Node curNode = prioQue.remove(smallestCost(prioQue));
            Node child;
            options = curNode.getOptions();
            for(var opt : options)
            {    
                child = curNode.clone();
                child.swap(opt);
                if(checkVisited(child) == false)
                {
                    visited.add(child);
                    prioQue.add(child);
                    child.print();
                    moveCounter++;
                }
                if (child.isEqual(goalNode))
                {
                    System.out.println("States visited:" + moveCounter);
                    System.out.println();
                    return child;
                }
            }
        }
         return null;
    }

    // remove smallest node from prioqueue
    public int smallestCost(ArrayList<Node> prioQue){
        int smallest = 1000;
        int smallestPos=-1;
        int index = 0;
        
        for(Node N : prioQue){
           if(N.getHn() < smallest){
               smallest = N.getHn();
               smallestPos = index;
           }
            index++;
        }

        return smallestPos;
    }  
}
