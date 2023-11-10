import java.util.*;

public class UCS
{ 
    public Scanner input = new Scanner(System.in);

    // goal state 
    public int[][] goal  = {
        {1,2,3},
        {8,0,4},
        {7,6,5}
    };
    // Array to track the visted nodes
    public ArrayList<Node> visited = new ArrayList<Node>();

    // Method ot check if the current node has been visited
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

    // Main search method 
    public Node searchIterative(Node rootNode)
    {
        // counter for states visited 
        int moveCounter = 0;

        // Priority Queue to track open nodes 
        ArrayList<Node> prioQue = new ArrayList<>();

        // creates goal node for comparison
        Node goalNode = new Node(this.goal);

        // list to hold possible options 
        ArrayList<ArrayList<Integer>> options;

        // add root to priQueue
        prioQue.add(rootNode);

        while(prioQue.size() > 0)
        {
            
            Node curNode = prioQue.remove(smallestCost(prioQue));
            // create child node 
            Node child;
            // get options for current node 
            options = curNode.getOptions();
            // create child for all options 
            for(var opt : options)
            {    
                child = curNode.clone();
                child.swap(opt);

                // if child is not visited add to prioQueue
                if(checkVisited(child) == false)
                {
                    
                    visited.add(child);
                    prioQue.add(child);
                    child.print();
                    moveCounter++;
                }

                // goal state reached 
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

    // method to remove smallest node from prioQueue
    public int smallestCost(ArrayList<Node> prioQue){
        int smallest = 1000;
        int smallestPos=-1;
        int index = 0;
        
        for(Node N : prioQue){
           if(N.getGn() < smallest){
               smallest = N.getGn();
               smallestPos = index;
           }
            index++;
        }

        return smallestPos;
    }
  
}
