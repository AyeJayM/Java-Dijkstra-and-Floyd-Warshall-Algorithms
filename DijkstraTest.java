import java.util.Random;

/*import java.util.*; 
import java.lang.*; 
import java.io.*; */
   
class DijkstraTest 
{ 
    /* Establishing the amount of vertices in our created graph helps in future loops and to ensure
    we do not go out of bounds */
    int maxVertices = 100000;

    public static void main(String[] args) 
    { 
        // We represent the graph as a matrix

        int graph[][] = new int[100000][100000];


        Random rn = new Random();

        int nodeVal = 100000;

        for (int i = 0; i < nodeVal; i++)
        {
            for (int j = 0; j < nodeVal; j++)
            {
                if(i == j)
                {
                    graph[i][j] = 0;
                }
                else
                {
                    int answer = rn.nextInt(10) + 1;
                    graph[i][j] = answer;
                }

            }
        }


        long StartTime = System.nanoTime();

        DijkstraTest DT = new DijkstraTest(); 
        DT.DijkstraFunc(graph, 0);

        long StopTime = System.nanoTime();

        long ElapsedTime = StopTime - StartTime;

        System.out.println("\nTotal time elapsed in nanoseconds: " + ElapsedTime + "\n");
    } 
     



    int minVertDis(int dijArray[], Boolean boolArray[])   
    { 
        int minVertVal = Integer.MAX_VALUE; // This is how we will represent "inf" as we do when solving dijkstra on paper
        int minIndex = -1;

        for (int i = 0; i < maxVertices; i++)
        {
            if (boolArray[i] == false && dijArray[i] <= minVertVal) 
            { 
                minVertVal = dijArray[i]; 
                minIndex = i; 
            } 
        }

        return minIndex; 
    } 
   


 
    void DijkstraFunc(int graph[][], int curNode)  
    { 
        int curPath[] = new int[maxVertices]; 
   
        
        Boolean curBoolArray[] = new Boolean[maxVertices]; 
   
        
        for (int i = 0; i < maxVertices; i++)
        { 
            curPath[i] = Integer.MAX_VALUE; // Set distance to "inf" by default as we do when solving for Dijkstra by hand.
            curBoolArray[i] = false; 
        } 
   
        // Set path from node to itself as 0
        curPath[curNode] = 0; 
       

        for (int count = 0; count < maxVertices - 1; count++)
        { 
            // Finding the node with the minimum path
            int node = minVertDis(curPath, curBoolArray);


            curBoolArray[node] = true;

            for (int i = 0; i < maxVertices; i++)
            {
   
                // If we have not yet solved for the current node, we will add it to our array.
                if (!curBoolArray[i] && graph[node][i] != 0 && curPath[node] != Integer.MAX_VALUE && curPath[node] + graph[node][i] < curPath[i])
                {
                            curPath[i] = curPath[node] + graph[node][i];
                }
            }
        } 
   
        // Print our resulting path
       // dijPrint(curPath); 
    } 

  




    void dijPrint(int shortestPathArray[])   
    { 
        System.out.print("\n");

        for (int curNode = 0; curNode < maxVertices; curNode++)
        {
            System.out.println("Shortest path from STARTING NODE to NODE " + curNode + " : " + shortestPathArray[curNode] + "\n");
        }
    }


}
