class FloydWarshall{
  static int INF=999,V=4;
  void runFloydWarshall(int mat[][]){
      int dp[][]=new int[V][V];
      //Initializing the Dp matrix
      for(int i=0;i<V;i++)
      {
        for(int j=0;j<V;j++){
          dp[i][j]=mat[i][j];
        }
      }
      //Checking whether using an ntermediate node is fruitful or not
      for(int k=0;k<V;k++){
        for(int i=0;i<V;i++){
          for(int j=0;j<V;j++){
            if(dp[i][k] + dp[k][j] < dp[i][j]){
              dp[i][j]=dp[i][k] + dp[k][j];
            }
          }
        }
      }
      //printing the matrix
      for(int i=0;i<V;i++)
      {
        for(int j=0;j<V;j++){
          System.out.print(dp[i][j]+" ");
        }
        System.out.println();
      }
  }

  public static void main(String[] args) {
    int graph[][] = { {0,   5,  INF, 10},
                        {INF, 0,   3, INF},
                        {INF, INF, 0,   1},
                        {INF, INF, INF, 0}
                      };
     FloydWarshall f = new FloydWarshall();
     f.runFloydWarshall(graph);

  }
}
