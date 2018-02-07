package leetCode;

public class uniqueBST_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numTrees(int n) {
		
		if(n==0||n==1) return n;
		int[] memory= new int[n+1];
		memory[0]=1;
		memory[1]=1;
		for (int i=2; i<n+1; i++) {
			int sum=0;
			for (int j=1;j<=i/2;j++) {
				sum+=memory[j-1]*memory[i-j];
			}
			if(i%2==0) memory[i]=2*sum;
			else memory[i]=2*sum+memory[i/2]*memory[i/2];	
		}
		return memory[n];
	        
	}

}
