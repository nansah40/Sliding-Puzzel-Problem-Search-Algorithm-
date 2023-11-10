import java.util.*;


public class Main {

   

    // slolved state 
    public static int[][] alreadySolved = {
        {1,2,3},
        {8,0,4},
        {7,6,5}
    };

    // test state 
    public static int[][] easy = {
        {1,2,3},
        {0,6,4},
        {8,7,5}
    };

    // generate start board 
    public static int[][] start = generateBoard();
    
    
    public static void main(String[]args)
    {
        // get runtime 
        long startTime = System.currentTimeMillis();
        
        // UNCOMENT THE SEARCH YOU WOULD LIKE TO RUN
        runBFS();
        //runDFS();
        //runUCS();
        //runA();
        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);  

        System.out.print(duration);
    }

    // Method to run DFS
    public static void runDFS()
    {
        Node startNode = new Node(start);
        startNode.print();
        
        DFS dfs = new DFS();
        Node solvedNode = dfs.searchIterative(startNode);
        //Node solvedNode = dfs.searchRecursive(startNode);
        
        if (solvedNode==null)
        {
            System.out.println("Algorithm unable to solve puzzle.");
        }
        else
        {
            solvedNode.print();    
        }
        
    }

    // Method to run UCS
    public static void runUCS()
    {
        Node startNode = new Node(start);
        startNode.print();

        UCS ucs = new UCS();
        Node solvedNode = ucs.searchIterative(startNode);
        if (solvedNode==null)
        {
            System.out.println("Algorithm unable to solve puzzle.");
        }
        else
        {
            solvedNode.print();    
        }
    }

    // Meethod to run BFS
     public static void runBFS()
    {
        Node startNode = new Node(start);
        startNode.print();

        BFS bfs = new BFS();
        Node solvedNode = bfs.searchIterative(startNode);
        if (solvedNode==null)
        {
            System.out.println("Algorithm unable to solve puzzle.");
        }
        else
        {
            solvedNode.print();    
        }
    }

    // Method to runA
    public static void runA()
    {
        Node startNode = new Node(start);
        startNode.print();

        A a = new A();
        Node solvedNode = a.searchIterative(startNode);
        if (solvedNode==null)
        {
            System.out.println("Algorithm unable to solve puzzle.");
        }
        else
        {
            solvedNode.print();    
        }
    }

    
    
    // print board 
    public static void printBoard(int[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // generate random board
    public static int[][] generateBoard(){
        int[][] start = {
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };

        ArrayList<Integer> L = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            L.add(i);
        }
        Collections.shuffle(L);

        int lIndex = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
                
                start[i][j] = L.get(lIndex);
                lIndex++;
            }
        }
        return start;
        
    }
}
