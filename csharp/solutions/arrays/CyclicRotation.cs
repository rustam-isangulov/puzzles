namespace solutions;

public class CyclicRotation
{
	public int[] GetRotatedArray(int[] A, int K)
	{
        if (A.Length == 0)
        {
            return A;
        }

        if (K == 0)
        {
            return A;
        }

        int moveCount = K % A.Length;

        if (moveCount == 0)
        {
            return A;
        }

        int[] retArray = new int[A.Length];
        
        for ( var i = 0; i < A.Length; i++)
        {
            retArray[(i+moveCount) % A.Length] = A[i];
        }

        return retArray;
	}
}
