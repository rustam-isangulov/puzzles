using System.Collections.Generic;

namespace solutions;

public class PermMissingElement
{
	public int GetMissinValue(int[] A)
	{
        var refHashSet = new HashSet<int>(Enumerable.Range(1, A.Length+1));

        foreach (var it in A)
        {
            refHashSet.Remove(it);
        }

        return refHashSet.First();
	}
}
