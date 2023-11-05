namespace solutions;

public class BinaryGap
{
	public int GetMaxBinaryGap(int N)
	{
        string binaryString = Convert.ToString(N,2);

        int maxGap = 0;
        int currentGap = 0;

        foreach (var c in binaryString)
        {
            switch (c)
            {
                case '1':
                    if (currentGap != 0)
                    {
                        maxGap = Math.Max(maxGap, currentGap);
                        currentGap = 0;
                    }
                    break;
                case '0':
                    currentGap++;
                    break;
                default:
                    throw new Exception("Unexpected character in binary representation!");
            }
        }

		return maxGap;
	}
}
