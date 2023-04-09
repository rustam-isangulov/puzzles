package strings;

public class MultiplyStrings {
    public String multiply( String num1, String num2 ) {
        // basic checks
        if (null == num1 || null == num2) {
            return "";
        }

        // turn both strings into an int arrays
        // with reversed order of digits
        int[] num1Array = new int[num1.length()];
        int[] num2Array = new int[num2.length()];

        // num1 = "1234" ==> num1Array = {4, 3, 2, 1}
        for (int pos = num1.length() - 1; pos >= 0; pos--) {
            num1Array[num1.length() - 1 - pos] = num1.charAt(pos) - '0';
        }

        // num2 = "5600" ==> num2Array = {0, 0, 6, 5}
        for (int pos = num2.length() - 1; pos >= 0; pos--) {
            num2Array[num2.length() - 1 - pos] = num2.charAt(pos) - '0';
        }

        // let's multiply longer number by a shorter one
        // this helps with multiplying by "0"
        int[] resultArray = new int[]{0};

        int[] longerArray;
        int[] shorterArray;

        if (num1Array.length > num2Array.length) {
            longerArray = num1Array;
            shorterArray = num2Array;
        } else {
            longerArray = num2Array;
            shorterArray = num1Array;
        }

        // traverse shorter array and multiply longer one by each digit
        // taking care of zero's and final sum
        for (int pos = 0; pos < shorterArray.length; pos++) {
            // create a shifted (by pos zeros) array for num1
            var shiftedNum1Array = new int[longerArray.length + pos];
            for (int i = pos; i < shiftedNum1Array.length; i++) {
                shiftedNum1Array[i] = longerArray[i - pos];
            }

            // sum the shifted arrays by num2Array value
            int[] sum = new int[]{0};
            for (int n = 0; n < shorterArray[pos]; n++) {
                sum = sum(sum, shiftedNum1Array);
            }

            // update the result
            resultArray = sum(resultArray, sum);
        }

        // turn reverse digit array on to a sensible string
        var retString = new StringBuilder(resultArray.length);

        for (int pos = resultArray.length - 1; pos >= 0; pos--) {
            retString.append(resultArray[pos]);
        }

        return retString.toString();
    }

    // sum two numbers represented as a reverse int arrays
    public static int[] sum( int[] n1, int[] n2 ) {
        int maxLength = Math.max(n1.length, n2.length);
        int[] ans = new int[maxLength];

        int carryOver = 0;
        int val;

        for (int pos = 0; pos < maxLength; pos++) {
            val =
                    ((pos < n1.length) ? n1[pos] : 0)
                            + ((pos < n2.length) ? n2[pos] : 0)
                            + carryOver;

            if (val > 9) {
                carryOver = 1;
                ans[pos] = val % 10;
            } else {
                carryOver = 0;
                ans[pos] = val;
            }
        }

        // in case if need more space
        // create a new array and append extra carryOver value
        if (carryOver != 0) {
            int[] extAns = new int[maxLength + 1];

            for (int i = 0; i < maxLength; i++) {
                extAns[i] = ans[i];
            }

            extAns[maxLength] = carryOver;
            ans = extAns;
        }

        return ans;
    }
}
