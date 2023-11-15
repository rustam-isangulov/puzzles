using solutions;

namespace tests;

public class AvSolutionTest
{
    [Theory(Skip = "done"), MemberData(nameof(TestData))]
    public void TestMultiLINQ(string[] inputArgs, int expectedValue)
    {
        var instance = new AvSolution();

        var resultValue = instance.SolutionLINQ(inputArgs);

        Assert.Equal(expectedValue, resultValue);
    }

    [Theory(Skip = "done"), MemberData(nameof(TestData))]
    public void TestMulti(string[] inputArgs, int expectedValue)
    {
        var instance = new AvSolution();

        var resultValue = instance.Solution(inputArgs);

        Assert.Equal(expectedValue, resultValue);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            null,
            -1
        },        
        new object[]
        {
            new string[0],
            -1
        },
        new object[]
        {
            new string[]{"--name", "SOME_NAME", "--count", "10", "--count", "10"},
            -1
        },
        new object[]
        {
            new string[]{"--name", "SOME_NAME", "--help", "--count", "10"},
            1
        },
        new object[]
        {
            new string[]{"random string at the start", "--name", "SOME_NAME", "--help", "--count", "10"},
            -1
        },
        new object[]
        {
            new string[]{"--name", "SOME_NAME", "--count", "10"},
            0
        },
        new object[]
        {
            new string[]{"--name", "SOME_NAME", "--count", "101"},
            -1
        },
        new object[]
        {
            new string[]{"--name", "SOME_NAME", "--count", "101", "something"},
            -1
        },
        new object[]
        {
            new string[]{"--count", "meh"},
            -1
        },
        new object[]
        {
            new string[]{"--help", "meh"},
            -1
        },
        new object[]
        {
            new string[]{"--help"},
            1
        },
        new object[]
        {
            new string[]{"--name"},
            -1
        },
    };
}
