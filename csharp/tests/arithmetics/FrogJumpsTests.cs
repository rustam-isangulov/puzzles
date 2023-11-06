using solutions;

namespace tests;

public class FrogJumpsTest
{
    [Theory, MemberData(nameof(TestData))]
    public void TestMulti(int X, int Y, int D, int expectedNumberOfJumps)
    {
        var instance = new FrogJumps();

        var numberOfJumps = instance.GetNumberOfJumps(X, Y, D);

        Assert.Equal(expectedNumberOfJumps, numberOfJumps);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            10,
            85,
            30,
            3
        },
        new object[]
        {
            0,
            0,
            30,
            0
        },
        new object[]
        {
            1,
            1000000000,
            1,
            999999999
        },
        new object[]
        {
            1,
            10,
            5,
            2
        },
        new object[]
        {
            1,
            12,
            5,
            3
        },
    };
}
