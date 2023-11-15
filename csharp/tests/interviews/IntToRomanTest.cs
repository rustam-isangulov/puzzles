using solutions;

namespace tests;

public class IntToRomanTest
{
    [Theory(Skip = "done"), MemberData(nameof(TestData))]
    public void TestMulti(int inputInt, string expectedRoman)
    {
        var instance = new IntToRoman();

        var resultRoman = instance.Solution(inputInt);

        Assert.Equal(expectedRoman, resultRoman);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            1,
            "I"
        },
        new object[]
        {
            2,
            "II"
        },
        new object[]
        {
            3,
            "III"
        },
        new object[]
        {
            4,
            "IV"
        },
        new object[]
        {
            5,
            "V"
        },
        new object[]
        {
            6,
            "VI"
        },
        new object[]
        {
            9,
            "IX"
        },
        new object[]
        {
            10,
            "X"
        },
        new object[]
        {
            19,
            "XIX"
        },
        new object[]
        {
            40,
            "XL"
        },
        new object[]
        {
            57,
            "LVII"
        },
        new object[]
        {
            80,
            "LXXX"
        },
        new object[]
        {
            89,
            "LXXXIX"
        },
        new object[]
        {
            90,
            "XC"
        },
        new object[]
        {
            160 ,
            "CLX"
        },
        new object[]
        {
            300,
            "CCC"
        },
        new object[]
        {
            891,
            "DCCCXCI"
        },
        new object[]
        {
            1009,
            "MIX"
        },
        new object[]
        {
            1066,
            "MLXVI"
        },
        new object[]
        {
            1944,
            "MCMXLIV"
        },
        new object[]
        {
            2023,
            "MMXXIII"
        },
        new object[]
        {
            2421,
            "MMCDXXI"
        },
        new object[]
        {
            3000,
            "MMM"
        },
    };
}
