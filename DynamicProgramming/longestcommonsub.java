/*
LCS abcdaf & abcef = abcf

*/
import java.util.* ;
class longestcommonsub
{	
	public static void actualSequence(int[][] table,String s1,String s2)
	{
		List<Character> res = new ArrayList<Character>();
		for(int i = s1.length(); i > 0;  )
		{
			for(int j =s2.length(); j > 0 & i > 0;)
			{
						
						if(table[i][j] == table[i-1][j])
							i--;
						else if(table[i][j] == table[i][j-1])	
							j--;
						else
						{
							res.add(s1.charAt(i-1));
						i--;
						j--;
						}
					
			}
		}
		for(char c : res)
		{
			System.out.println(c);
		}
		//return res;
	}

	public static int lcs(String s1,String s2)
	{
		int[][] table = new int[s1.length()+1][s2.length()+1];
		int max = 0;
		for(int i = 0; i<=s2.length();i++)
		{
			table[0][i] = 0;
		} 
		for(int i = 0; i<=s1.length();i++)
		{
			table[i][0] = 0;
		} 

		for(int i = 1; i <= s1.length(); i++ )
		{
			for(int j =1; j <= s2.length(); j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					table[i][j] = table[i-1][j-1] + 1;
				}
				else
				{
					table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
				}
				if(table[i][j] > max){
                    max = table[i][j];
                }

			}
		}
		System.out.println("LCS is  ");
		actualSequence(table,s1,s2); 
		return max;

	}

	public static void main(String args[])
	{
		
		
		System.out.println("LCS is of size "+lcs("ABCDGHLQR","AEDPHR"));
	

	}
}