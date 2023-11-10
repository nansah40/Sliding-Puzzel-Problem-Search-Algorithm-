import java.util.*;

public class A
{
     
    public Scanner input = new Scanner(System.in);

    // goal state 
    public int[][] goal  = {
        {1,2,3},
        {8,0,4},
        {7,6,5}
    };
    // array to hold visited nodes
    public ArrayList<Node> visited = new ArrayList<Node>();

    // check if node has been visisted 
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

    // Method to search. Uses fn = gn + hn as the heuristic 
    public Node searchIterative(Node rootNode)
    {   
        //counter to hold the number of visited states
        int moveCounter = 0;

        // priority queue
        ArrayList<Node> prioQue = new ArrayList<>();
        // goal node
        Node goalNode = new Node(this.goal);
        // list of options 
        ArrayList<ArrayList<Integer>> options;
        // add root node
        prioQue.add(rootNode);

        // search tree 
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
                // goal found
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

    // remove node with smallest cost from prioQueue
    public int smallestCost(ArrayList<Node> prioQue){
        int smallest = 1000;
        int smallestPos=-1;
        int index = 0;
        
        for(Node N : prioQue){
           if(N.getFn() < smallest){
               smallest = N.getFn();
               smallestPos = index;
           }
            index++;
        }

        return smallestPos;
    }
}
