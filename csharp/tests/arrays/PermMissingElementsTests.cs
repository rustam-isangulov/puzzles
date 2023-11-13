using solutions;

namespace tests;

public class PermMissingElementTest
{
    [Theory(Skip ="done"), MemberData(nameof(TestData))]
    public void TestMulti(int[] inputA, int expectedMissingValue)
    {
        var instance = new PermMissingElement();

        var missingValue = instance.GetMissinValue(inputA);

        Assert.Equal(expectedMissingValue, missingValue);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            new int[0],
            1
        },
        new object[]
        {
            new int[] {1},
            2
        },
        new object[]
        {
            new int[] {2, 3, 1, 5},
            4
        },
    };
}
