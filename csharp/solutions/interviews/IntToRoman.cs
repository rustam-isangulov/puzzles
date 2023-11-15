namespace solutions;

public class IntToRoman
{
    readonly List<(int value, char numeral)> intToNumerals = new()
        {
            (1, 'I'),
            (5, 'V'),
            (10, 'X'),
            (50, 'L'),
            (100, 'C'),
            (500, 'D'),
            (1000, 'M')
        };

    private int PrevRomanValue(int intValue) => intToNumerals.Select(it => it.value)
                                                             .OrderDescending()
                                                             .SkipWhile(it => it > intValue)
                                                             .Take(1).First();

    private char RomanSymbol(int intValue) => intToNumerals.Where(it => it.value == intValue)
                                                           .Select(it => it.numeral)
                                                           .First();

    private int NextRomanValue(int intValue) => intToNumerals.Select(it => it.value)
                                                             .SkipWhile(it => it <= intValue)
                                                             .Take(1).FirstOrDefault(0);

    private int PrevFarRomanValue(int LD) => intToNumerals.Select(it => it.value)
                                                          .OrderDescending()
                                                          .SkipWhile(it => it >= LD)
                                                          .Where(it => LD / it > 2)
                                                          .FirstOrDefault(0);

    public string Solution(int input)
    { 
        if (input == 0)
        {
            return "";            
        }

        var nextRomanValue = NextRomanValue(input);
        var prevFar = PrevFarRomanValue(nextRomanValue);

        if (nextRomanValue != 0 && (nextRomanValue - prevFar) <= input)
        {
            return string.Concat($"{RomanSymbol(prevFar)}{RomanSymbol(nextRomanValue)}", 
                                    Solution(input - (nextRomanValue - prevFar)));            
        }

        var prevRomanValue = PrevRomanValue(input);   
        var n = input / prevRomanValue;

        if ( n < 4)
        {
            return string.Concat(new string(RomanSymbol(prevRomanValue), n), 
                                    Solution(input - n * prevRomanValue));
        }
        else
        {
            return string.Concat($"{RomanSymbol(prevRomanValue)}{RomanSymbol(NextRomanValue(input))}", 
                                    Solution(input - (NextRomanValue(input) - prevRomanValue)));
        }
    }
}