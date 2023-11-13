using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Threading.Channels;

namespace solutions;

public class AvSolution
{
    public int SolutionLINQ(string[] args)
    {
        const int INVALID = -1;
        const int OK = 0;
        const int HELP = 1;

        var noValueTokens = new HashSet<string>() { "--HELP" };


        var allParams = args?.Select((s, i) => (name: s.ToUpper(), pos: i))
                             .Where(it => it.name.StartsWith("--")) ?? Enumerable.Empty<(string, int)>();


        var paramsRightPos = allParams.Skip(1)
                                      .Select(it => it.pos)
                                      .Concat(new int[] { args?.Length ?? 0 });

        var paramValueSlices = allParams.Zip(paramsRightPos, (param, rightPos) => (name: param.name, left: param.pos, right: rightPos))
                                        .Select(it => (paramName: it.name, values: args?[(it.left + 1)..it.right] ?? Enumerable.Empty<string>()));

        // FORMAT CHECKS

        var noValueParamsWithValues = paramValueSlices.Where(it => noValueTokens.Contains(it.paramName))
                                                      .Where(it => it.values.Any());

        var repeatedParams = paramValueSlices.GroupBy(it => it.paramName, it => it, (key, values) => (name: key, count: values.Count()))
                                             .Where(it => it.count > 1);

        var valueParamsWithNoValues = paramValueSlices.Where(it => !noValueTokens.Contains(it.paramName))
                                                       .Where(it => !it.values.Any());

        var paramsWithMultipleValues = paramValueSlices.Where(it => !noValueTokens.Contains(it.paramName))
                                                       .Where(it => it.values.Count() > 1);
        
        bool startsWithParam = allParams.Where( it => it.pos == 0 ).Any();
        
        if (!paramValueSlices.Any() 
                || noValueParamsWithValues.Any() 
                || repeatedParams.Any() 
                || paramsWithMultipleValues.Any() 
                || valueParamsWithNoValues.Any()
                || !startsWithParam)
        {
            return INVALID;
        }


        // VALUE CHECKS

        var rules = new Dictionary<string, Func<string, bool>>()
        {
            {"--NAME", s => s.Length >=3 && s.Length <= 10 },
            {"--COUNT", s => int.TryParse(s, out int value) && value < 20 }
        };

        var paramsWithBadValues = paramValueSlices.Where(it => !noValueTokens.Contains(it.paramName))
                                                  .Where(it => !rules.GetValueOrDefault(it.paramName, s => true)(it.values.First()));

        if (paramsWithBadValues.Any())
        {
            return INVALID;
        }

        // OK vs HELP

        if (allParams.Where(it => it.name == "--HELP").Any())
        {
            return HELP;
        }

        return OK;
    }

    public int Solution(string[] args)
    {
        const int INVALID = -1;
        const int OK = 0;
        const int HELP = 1;

        if (args == null || args.Length == 0)
        {
            return INVALID;
        }

        //
        // process to get token - value pairs
        //

        int pos = 0;
        string currentToken = "";
        var argsDict = new Dictionary<string, string>();

        while (pos < args.Length)
        {
            if (args[pos].ToUpper() == "--NAME")
            {
                currentToken = args[pos].ToUpper();
            }
            else if (args[pos].ToUpper() == "--COUNT")
            {
                currentToken = args[pos].ToUpper();
            }
            else if (args[pos].ToUpper() == "--HELP")
            {
                currentToken = args[pos].ToUpper();

                if (argsDict.ContainsKey(currentToken))
                {
                    // second appearance of the same key
                    return INVALID;
                }

                argsDict[currentToken] = "YES";
            }
            else
            {
                if (currentToken != "")
                {
                    if (argsDict.ContainsKey(currentToken))
                    {
                        // second appearance of the same key
                        return INVALID;
                    }

                    argsDict[currentToken] = args[pos];
                }
                else
                {
                    // value with no key
                    return INVALID;
                }

                currentToken = "";
            }

            pos++;
        }

        //
        // validate
        //

        // EMPTY token list
        if (argsDict.Count == 0)
        {
            return INVALID;
        }

        // COUNT
        if (argsDict.ContainsKey("--COUNT"))
        {
            if (Int32.TryParse(argsDict["--COUNT"], out int j))
            {
                if (j < 10 || j > 100)
                {
                    return INVALID;
                }
            }
            else
            {
                return INVALID;
            }
        }

        // NAME
        if (argsDict.ContainsKey("--NAME"))
        {
            if (argsDict["--NAME"].Length < 3 || argsDict["--NAME"].Length > 10)
            {
                return INVALID;
            }
        }

        // react on HELP
        if (argsDict.ContainsKey("--HELP"))
        {
            return HELP;
        }

        return OK;
    }
}
