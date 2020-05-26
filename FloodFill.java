class FloodFill{
  public void fillColor(int screen[][],int i,int j,int newColor,int color){
    if(i<0 || j<0 || i>=screen.length || j>=screen.length)
      return;
    if(screen[i][j]!=color)
      return;
    screen[i][j] = newColor;
    fillColor(screen,i+1,j,newColor,color);
    fillColor(screen,i-1,j,newColor,color);
    fillColor(screen,i,j+1,newColor,color);
    fillColor(screen,i,j-1,newColor,color);

  }
  public static void main(String[] args) {
    int screen[][]={{1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 0},
                    {1, 0, 0, 1, 1, 0, 1, 1},
                    {1, 2, 2, 2, 2, 0, 1, 0},
                    {1, 1, 1, 2, 2, 0, 1, 0},
                    {1, 1, 1, 2, 2, 2, 2, 0},
                    {1, 1, 1, 1, 1, 2, 1, 1},
                    {1, 1, 1, 1, 1, 2, 2, 1},
                    };
      int x =4;
      int y =4;
      int newColor=3;
      FloodFill f = new FloodFill();
      int color = screen[x][y];
      f.fillColor(screen,x,y,newColor,color);
      for(int i=0;i<screen.length;i++){
        for(int j=0;j<screen[i].length;j++)
        {
          System.out.print(screen[i][j]+" ");
        }
        System.out.println();
      }
  }
}
