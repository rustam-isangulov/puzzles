using solutions;

namespace tests;

public class PrintDuplicateCharsTest
{
    [Theory, MemberData(nameof(DuplicateCountData))]
    public void TestMulti(string input, IList<(char c, int count)> expectedOutput)
    {
        var instance = new PrintDuplicateChars();

        var duplicateCounts = instance.GetDuplicateCounts(input);

        Assert.Equal(expectedOutput, duplicateCounts);
    }

    public static IEnumerable<object[]> DuplicateCountData =>
    new List<object[]>
    {
        new object[]
        {
            "Hello World!",
            new List<(char c, int count)>(){('l', 3), ('o', 2)}
        },
        new object[]
        {
            "Hello Universe!",
            new List<(char c, int count)>(){('e', 3), ('l', 2)}
        }
    };
    }
