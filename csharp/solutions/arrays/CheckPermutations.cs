using System.Collections.Generic;

namespace solutions;

public class CheckPermutations
{
	public int IsPermutation(int[] A)
	{
        var refHashSet = new HashSet<int>(Enumerable.Range(1, A.Length));

        foreach (var it in A)
        {
            if (!refHashSet.Remove(it))
            {
                return 0;
            }
        }

        return refHashSet.Count == 0 ? 1 : 0;
	}
}
