using solutions;

namespace tests;

public class CheckPermutationTests
{
    [Theory(Skip = "done"), MemberData(nameof(TestData))]
    public void TestMulti(int[] inputA, int expectedCheckValue)
    {
        var instance = new CheckPermutations();

        var isPermutation = instance.IsPermutation(inputA);

        Assert.Equal(expectedCheckValue, isPermutation);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            new int[] {1},
            1
        },
        new object[]
        {
            new int[] {2, 1},
            1
        },
        new object[]
        {
            new int[] {4, 1, 3},
            0
        },
        new object[]
        {
            new int[] {4, 1, 3, 2},
            1
        },
        new object[]
        {
            new int[] {4, 4, 1, 3, 2},
            0
        },
    };
}
