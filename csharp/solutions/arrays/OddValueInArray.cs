using System.Collections.Generic;

namespace solutions;

public class OddValueInArray
{
	public int GetOddValue(int[] A)
	{
        if (A.Length == 1)
        {
            return A[0];
        }

        var hashSet = new HashSet<int>();

        foreach (var it in A)
        {
            if (hashSet.Contains(it))
            {
                hashSet.Remove(it);
            }
            else
            {
                hashSet.Add(it);
            }
        }

        return hashSet.First();
	}
}
