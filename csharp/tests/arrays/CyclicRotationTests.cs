using solutions;

namespace tests;

public class CyclicRotationTest
{
    [Theory(Skip = "done"), MemberData(nameof(TestData))]
    public void TestMulti(int[] inputA, int inputK, int[] expectedRotatedArray)
    {
        var instance = new CyclicRotation();

        var rotatedArray = instance.GetRotatedArray(inputA, inputK);

        Assert.Equal(expectedRotatedArray, rotatedArray);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            new int[] {0, 0, 0},
            0,
            new int[] {0, 0, 0}
        },
        new object[]
        {
            Array.Empty<int>(),
            0,
            Array.Empty<int>()
        },
        new object[]
        {
            new int[] {3, 8, 9, 7, 6},
            5,
            new int[] {3, 8, 9, 7, 6}
        },
        new object[]
        {
            new int[] {3, 8, 9, 7, 6},
            3,
            new int[] {9, 7, 6, 3, 8}
        },
        new object[]
        {
            new int[] {1, 2, 3, 4},
            4,
            new int[] {1, 2, 3, 4}
        },
        new object[]
        {
            new int[] {3, 8, 9, 7, 6},
            3,
            new int[] {9, 7, 6, 3, 8}
        },
    };
}
