using System.Collections.Generic;

namespace solutions;

public class FrogJumps
{
	public int GetNumberOfJumps(int X, int Y, int D)
	{
        int retValue = (Y - X) / D;

        if ((Y - X) % D > 0)
        {
            retValue++;
        }
        
        return  retValue;
	}
}
