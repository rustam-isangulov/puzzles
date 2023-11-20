using solutions;

namespace tests;

public class CartesianProductTest
{
    [Theory, MemberData(nameof(TestData))]
    public void TestMulti(IDictionary<string, IList<int>> inputs, IEnumerable<IEnumerable<(string, int)>> expectedProduct)
    {
        var instance = new CartesianProduct();

        var resultProduct = instance.Solution(inputs);

        Assert.Equal(expectedProduct, resultProduct);
    }

    public static IEnumerable<object[]> TestData =>
    new List<object[]>
    {
        new object[]
        {
            new Dictionary<string, IList<int>>()
            {
                {"A", new List<int>() { 1, 2, 3}},
                {"B", new List<int>() {10, 20}},
                {"C", new List<int>() {100}},
            },
            new (string, int)[][] 
            { 
                new (string, int) []{("A", 1),("B", 10),("C", 100)},
                new (string, int) []{("A", 1),("B", 20),("C", 100)},
                new (string, int) []{("A", 2),("B", 10),("C", 100)},
                new (string, int) []{("A", 2),("B", 20),("C", 100)},
                new (string, int) []{("A", 3),("B", 10),("C", 100)},
                new (string, int) []{("A", 3),("B", 20),("C", 100)},
            }
        },
        new object[]
        {
            new Dictionary<string, IList<int>>()
            {
                {"A", new List<int>() { 1, 2, 3}},
                {"B", new List<int>() {10, 20}},
            },
            new (string, int)[][] 
            { 
                new (string, int) []{("A", 1),("B", 10)},
                new (string, int) []{("A", 1),("B", 20)},
                new (string, int) []{("A", 2),("B", 10)},
                new (string, int) []{("A", 2),("B", 20)},
                new (string, int) []{("A", 3),("B", 10)},
                new (string, int) []{("A", 3),("B", 20)},
            }
        },
        new object[]
        {
            new Dictionary<string, IList<int>>()
            {
                {"A", new List<int>() { 1, 2, 3}},
            },
            new (string, int)[][] 
            { 
                new (string, int) []{("A", 1)},
                new (string, int) []{("A", 2)},
                new (string, int) []{("A", 3)},
            }
        },
        new object[]
        {
            new Dictionary<string, IList<int>>(),
            new (string, int)[][]{ Array.Empty<(string, int)>() }
        },
    };
}
