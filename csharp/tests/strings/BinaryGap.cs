using solutions;

namespace tests;

public class BinaryGapTest
{
    [Theory, MemberData(nameof(TestData))]
    public void TestMulti(int input, int expectedMaxBinaryGap)
    {
        var instance = new BinaryGap();

        var maxBinaryGap = instance.GetMaxBinaryGap(input);

        Assert.Equal(expectedMaxBinaryGap, maxBinaryGap);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            1041,
            5
        },
        new object[]
        {
            0,
            0
        },
        new object[]
        {
            2,
            0
        },
        new object[]
        {
            5,
            1
        },
        new object[]
        {
            2147483647,
            0
        },
    };
}
