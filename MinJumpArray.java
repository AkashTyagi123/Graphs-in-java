import java.util.*;
class MinJumpArray{
  private int getMinSteps(int i,int arr[]){
    int n=arr.length;
    if(i>=arr.length){
      return 0;
    }
    if(i==n-1)
      return 1;
    if(arr[i]==0)
      return Integer.MAX_VALUE;
    int maxSteps = arr[i];
    int steps =Integer.MAX_VALUE;
    for(int j=1;j<=maxSteps;j++){
      steps = Math.min(steps,getMinSteps(i+j,arr));
    }
    return 1+steps;
  }
  public static void main(String[] args) {
    int arr[]={1,3,5,8,9,2,6,7,6,8,9};
    MinJumpArray m = new MinJumpArray();
    int minSteps = m.getMinSteps(0,arr);
    System.out.println(minSteps);
  }
}
