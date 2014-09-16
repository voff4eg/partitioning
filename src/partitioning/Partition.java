/**
 * @author Vladimir Egorov
 *
 */

package partitioning;

/**
 * ����� �������� ��������� ����� N �� k ���������
 * @param ������� ��������� ����� N �� k ��������� 
 * @param N ���� �����
 * @param k ���������� ���������
 * http://bette.ucoz.ru/_ld/0/87_wXI.pdf 2.2.4 ��������� ����� �� ��������� 
 */
public class Partition {
	int[][] P;
	
	int N,k,result;
		
	public Partition(int n, int k) {
		N = n;
		this.k = k;
		
		if(checkParams(N,this.k) == true){
			if (result == 0) {
				P = new int[N+1][N+1];

				initP();
				
				countPartition();
			}
		}
	}
	
	
	/**
	 * ��������� �������� ���������
	 * @param n >= 0 ���� 0 <= n <= 1, �� ���������� ��������� ����� ������ 1
	 * @param k > 0
	 * ���� n == k, �� ���������� ��������� ����� ������ 1
	 */
	private boolean checkParams(int n, int k){
		boolean bError = false;
		if(n > 1 && k > 1){
			if(n < k){
				 System.err.println("n ������ ���� >= k!");
				 bError = true;
			}
			if(n == k){
				setPartitionCount(1);
			}
		}else{
			if(k <= 0){
				System.err.println("k ������ ���� >= 0!");
				bError = true;
			}else{
				if(n < 0){
					System.err.println("n ������ ���� >= 0!");
					bError = true;
				}else{
					if(n < k){
						 System.err.println("n ������ ���� >= k!");
						 bError = true;
					}else{
						setPartitionCount(1);
					}
				}
			}
		}
		return !bError;
	}

	/**
	 * �������������� ������ P
	 */
	private void initP(){
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		      P[i][j] = 0;
		    }
		}
	}
	
	/**
	 * ������������ ���������� ��������� � ������������� ���������
	 */
	private void countPartition(){
		P[0][0] = 1;
		for (int i = 1; i <= N; i++){
			for(int j = 1; j <= i; j++){
				for(int kk = 0; kk <= j; kk ++){
					P[i][j] += P[i-j][kk];
				}
			}
		}
		
		setPartitionCount(P[N][k]);
	}
	
	
	/**
	 * ������������ ��������� ���������� ��������� N �� k ���������
	 */
	private void setPartitionCount(int result){
		this.result = result;
	}
	
	/**
	 * ���������� ���������� ��������� N �� k ���������
	 */
	public int getPartitionCount() {
		return result;
	}
}
