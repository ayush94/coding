// 0/1 knapsack problem
// T[i][j] = max(val[i]+T[i-1][j-wt(i)],t[i-1][j]) if j>=i
//           T[i-1][j]							otherwise
import java.util.* ;
public class knapsack{
	
	public static int knapsack(int[] wt,int[] val,int maxLimit)
	{
		int[][] DP = new int[val.length][maxLimit+1];

		if(maxLimit == 0)
			return 0;		

		for(int i = 0; i < val.length ; i++)
		{
			for(int j=0; j<maxLimit+1;j++)
			{	
				if(i == 0 || j == 0)
					DP[i][j] = 0;
				else if(j < wt[i])
					DP[i][j] = DP[i-1][j];
				else
					DP[i][j] = Math.max(val[i]+DP[i-1][j-wt[i]],DP[i-1][j]);	
			}
		}
		List<Integer> selected = new ArrayList<Integer>();
		for(int i = val.length-1; i > 0; i--)
		{
			for(int j = maxLimit ;j>=0;j--)
			{
				if(DP[i][j] != DP[i-1][j])
					selected.add(wt[i]);
				break;
			}
		}

		for(int c:selected)
		{
			System.out.println("Selected item is of weight "+c);
		}

		return DP[val.length-1][maxLimit];
	}

	public static void main(String args[])
	{
		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int l = 7;
		System.out.println("Max Value is "+knapsack(wt,val,l));

	}

	
}