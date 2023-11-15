namespace solutions;

public class Dot
{
    public int[,]? Solution(int[,] A, int[,] B)
    {
        if ( A == null || B == null)
        {
            return null;            
        }

        if ( A.GetLength(1) != B.GetLength(0))
        {
            return null;            
        }


        var rowsOfA = Enumerable.Range(0, A.GetLength(0))
                .Select( r => Enumerable.Range(0, A.GetLength(1)).Select( c => A[r, c] ) );

        var colsOfB = Enumerable.Range(0, B.GetLength(1))
                .Select( c => Enumerable.Range(0, B.GetLength(0)).Select( r => B[r, c] ) );

        var dot = rowsOfA.Select( ai => colsOfB.Select( bi => ai.Zip(bi, (a,b)=> a*b).Sum() ) );


        int i = 0;
        int j = 0;
        var result = new int[A.GetLength(0), B.GetLength(1)];

        foreach (var row in dot)
        {
            foreach (var col in row)
            {
                result[i, j++] = col;
            }
            i++;
            j = 0;
        }

        return result;
    }
}