import java.util.Random;

public class FloydWarshall
{
    static int noPath = 1000000;



    int numOfNodes = 10000; // Set this equal to nodeVal

    public static void main(String[] args)
    {
        int graph[][] = new int[10000][10000];

        int nodeVal = 10000; // Here determines n x n size

        Random rn = new Random();

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

        FloydWarshall Floyd = new FloydWarshall();

        long StartTime = System.nanoTime();

        Floyd.FloydWarshallFunc(graph);

        long StopTime = System.nanoTime();

        long ElapsedTime = StopTime - StartTime;

        System.out.println("\nTotal time elapsed in nanoseconds: " + ElapsedTime + "\n");
    }

    


    public void FloydWarshallFunc(int graph[][])
    {
      int matrix[][] = new int[numOfNodes][numOfNodes];
      int i, j, k;
  
      for (i = 0; i < numOfNodes; i++)
      {
        for (j = 0; j < numOfNodes; j++)
        {
          matrix[i][j] = graph[i][j];
        }
      }


      for (k = 0; k < numOfNodes; k++)
      {

        for (i = 0; i < numOfNodes; i++)
        {

          for (j = 0; j < numOfNodes; j++)

          {

            if (matrix[i][k] + matrix[k][j] < matrix[i][j])
            {
              matrix[i][j] = matrix[i][k] + matrix[k][j];   // Access our nodes
            }

          }

        }

      }

      //printFloyd(matrix);

    }
  



    void printFloyd(int matrix[][])
    {
      for (int i = 0; i < numOfNodes; ++i)
      {

        for (int j = 0; j < numOfNodes; ++j)
        {

          if (matrix[i][j] == noPath)
          {
            System.out.print("Inf "); // This is how we represent no possible path
          }

          else
          {
            System.out.print(matrix[i][j] + "  ");
          }

        }

        System.out.println();

      }
    }
  
    
}
