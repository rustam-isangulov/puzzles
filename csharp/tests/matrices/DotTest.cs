using solutions;

namespace tests;

public class DotTest
{
    [Theory, MemberData(nameof(TestData))]
    public void TestMulti(int[,] A, int[,] B, int[,] expectedDotAB)
    {
        var instance = new Dot();

        var resultDotAB = instance.Solution(A, B);

        Assert.Equal(expectedDotAB, resultDotAB);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            null,
            null,
            null
        },
        new object[]
        {
            new int[0,0]{},
            new int[0,0]{},
            new int[0,0]{}
        },
        new object[]
        {
            new int[1,1]{{0}},
            new int[1,1]{{0}},
            new int[1,1]{{0}}
        },
        new object[]
        {
            new int[1,2]{{0, 1}},
            new int[1,1]{{0}},
            null
        },
        new object[]
        {
            new int[1,2]{{1, 2}},
            new int[2,1]{{1}, {1}},
            new int[1,1]{{3}}
        },
        new object[]
        {
            new int[,] 
                { 
	                {1, 2, 3}, 
	                {4, 5, 6}
                },
            new int[,] 
                { 
	                {1, 2}, 
	                {4, 5},
                    {6, 7}
                },
            new int[,] 
                { 
                    {27, 33}, 
                    {60, 75}
                }
        },
        new object[]
        {
            new int[,] 
                {
                    {-1, -4, 4, 1},
                    {0, -3, 2, 3}
                },
            new int[,] 
                { 
                    {-1, -2}, 
                    {0, 5},
                    {6, 7},
                    {-4, 8}
                },
            new int[,] 
                { 
                    { 21, 18 },
                    { 0, 23 }
                }
        },
    };
}
