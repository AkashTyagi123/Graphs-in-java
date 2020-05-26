class CountConnectedComponent{
  void dfs(int i,int j,int graph[][],boolean isVisited[][]){
       if(i<0 || j<0 || i>=graph.length || j>=graph.length)
         return;
        if(isVisited[i][j]==true || graph[i][j]==0)
          return;
       isVisited[i][j]=true;
       dfs(i+1,j,graph,isVisited);
       dfs(i-1,j,graph,isVisited);
       dfs(i,j+1,graph,isVisited);
       dfs(i,j-1,graph,isVisited);
       dfs(i-1,j-1,graph,isVisited);
       dfs(i-1,j+1,graph,isVisited);
       dfs(i+1,j+1,graph,isVisited);
       dfs(i+1,j-1,graph,isVisited);

  }
  public static void main(String[] args) {
    int graph[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };
    int count=0;
    int vertices = graph.length;
    boolean isVisited[][] = new boolean[vertices][vertices];
    CountConnectedComponent c = new CountConnectedComponent();
    for(int row=0;row<vertices;row++){
      for(int col=0;col<vertices;col++){
        if(graph[row][col]!=0 && isVisited[row][col]==false){

          count++;
          c.dfs(row,col,graph,isVisited);
        }
      }
    }
    System.out.println("The number of connected components are:-"+count);
  }
}
