using solutions;

namespace tests;

public class OddValueInArrayTest
{
    [Theory, MemberData(nameof(TestData))]
    public void TestMulti(int[] inputA, int expectedOddValue)
    {
        var instance = new OddValueInArray();

        var oddValue = instance.GetOddValue(inputA);

        Assert.Equal(expectedOddValue, oddValue);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            new int[] {0},
            0
        },
        new object[]
        {
            new int[] {0, 1, 0},
            1
        },
        new object[]
        {
            new int[] {9, 3, 9, 3, 9, 7, 9},
            7
        },
        new object[]
        {
            new int[] {9, 3, 9, 3, 9, 1000000000, 9},
            1000000000
        },
    };
}
