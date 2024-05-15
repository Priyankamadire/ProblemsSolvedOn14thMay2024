/*
1219. Path with Maximum Gold
Solved
Medium
Topics
Companies
Hint
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.

*/
class POTD {
    public int getMaximumGold(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]!=0){
                   ans=Math.max(ans,helper(i,j,grid));
               }
            }
        }
        return ans;
        
    }
    public int helper(int x,int y,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(x<0 || x>n-1 || y<0 || y>m-1 || grid[x][y]==0){
            return 0;
        }
        int temp = grid[x][y];
        grid[x][y]=0;
        int left = helper(x-1,y,grid);
        int right = helper(x,y+1,grid);
        int up = helper(x+1,y,grid);
        int down = helper(x,y-1,grid);
        grid[x][y]=temp;
        return Math.max(Math.max(Math.max(left,right),up),down)+temp;

    }
}
