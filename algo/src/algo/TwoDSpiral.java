package algo;
/**
 * https://www.facebook.com/careers/life/sample_interview_questions/Af8BaL90PrQGVj_YuGqVdJhmgdeuj-dq1vO9gy4HAmrDRNAglybwgdtN55L5_rICwCY
 * @author rahulsinha
 * input = 3
 * x[0][0]==1   x[0][2] = 3 x[2][2] = 5 x[2][0] = 7 
123
894
765

input = 4
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07

input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15
 */
public class TwoDSpiral {
	enum DIRECTION {
		LEFT,RIGHT,UP,DOWN;
	}
  public static int[][] spiral(int n){
	  int[][] matrix = new int[n][n];
	  DIRECTION DEFAULT = DIRECTION.RIGHT;
	  int x=0,y=0;
	  for(int i =0;i<n*n;i++){
		  switch(DEFAULT){
		  case RIGHT:if(y <= n-1)
			           y++;
		             else {
		            	   y = n-1;
		            	   if(x == n-1)
		            		   //Reached bottom go left
		            		   DEFAULT = DIRECTION.LEFT;
		            	   else//Reached top right go down?
		            	       DEFAULT = DIRECTION.DOWN;
		             }
			         break;
		  case UP  : x--;
		             if(x < 0){
		            	  x = 0;
		            	  DEFAULT = DIRECTION.RIGHT;
		             }
		             if(matrix[x][y] != 0){
		            	  x -= 1;
		            	  DEFAULT = DIRECTION.RIGHT;
		             }
			         break;
		  case DOWN :if(x<=n)
			           x++;
		             else {
		            	  x = n-1;
		            	  if(y == n-1){
		            		  //Reached bottom right .
		            		  DEFAULT = DIRECTION.LEFT;
		            	  }
		             }
			         break;
		  case LEFT: y--;
		             if(y < 0){
		            	  y = 0;
		            	  DEFAULT = DIRECTION.UP;
		             }
			         break;
		  }
		  matrix[x][y] = i;
	  }
	  return matrix;
  }
}
