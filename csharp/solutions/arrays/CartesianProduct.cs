namespace solutions;

/*

source for the approach: https://www.interact-sw.co.uk/iangblog/2010/07/28/linq-cartesian-1

generic version:

public static IEnumerable<IEnumerable<T>> CartesianProduct<T>(
    IEnumerable<IEnumerable<T>> inputs)
{
    return inputs.Aggregate(
        (IEnumerable<IEnumerable<T>>) new T[][] { new T[0] },
        (soFar, input) =>
            from prevProductItem in soFar
            from item in input
            select prevProductItem.Concat(new T[] { item }));
}

// Enable variable argument list.
public static IEnumerable<IEnumerable<T>> CartesianProduct<T>(
    params IEnumerable<T>[] inputs)
{
    IEnumerable<IEnumerable<T>> e = inputs;
    return CartesianProduct(e);
}

*/
public class CartesianProduct
{
    public IEnumerable<IEnumerable<(string, int)>> Solution(IDictionary<string, IList<int>> inputs)
    {
        var cartesianProduct = inputs.Select(it => it.Value.Select(item => (it.Key, item)))
                                     .Aggregate(
                                          (IEnumerable<IEnumerable<(string, int)>>)new (string, int)[][] { Array.Empty<(string, int)>() },
                                          (agg, input) => agg.SelectMany(
                                                            prev => input.Select(
                                                                        it => prev.Concat(new (string, int)[] { it })
                                                                        )
                                                            )
                                        );

        return cartesianProduct;
    }
}