using System.Collections.Generic;
using System.Diagnostics;
using System.Threading.Channels;

namespace solutions;

public class AvSolution
{
    public int solution(string[] args)
    {
        const int INVALID = -1;
        const int OK = 0;
        const int HELP = 1;

        try
        {
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
                    currentToken = args[pos].ToUpper() ;
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

            // EMTRY token list
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
            if ( argsDict.ContainsKey("--HELP"))
            {
                return HELP;
            }

            return OK;
        }
        finally
        {}

        return INVALID;
    }
}
