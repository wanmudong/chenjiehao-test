package Java作业2;
//import org.omg.PortableInterceptor.INACTIVE;
//import sun.security.util.Length;


import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BrobInt {
    public static final BrobInt ZERO = new BrobInt("0");      /// Constant for "zero"
    public static final BrobInt ONE = new BrobInt("1");      /// Constant for "one"
    public static final BrobInt TWO = new BrobInt("2");      /// Constant for "two"
    public static final BrobInt THREE = new BrobInt("3");      /// Constant for "three"
    public static final BrobInt FOUR = new BrobInt("4");      /// Constant for "four"
    public static final BrobInt FIVE = new BrobInt("5");      /// Constant for "five"
    public static final BrobInt SIX = new BrobInt("6");      /// Constant for "six"
    public static final BrobInt SEVEN = new BrobInt("7");      /// Constant for "seven"
    public static final BrobInt EIGHT = new BrobInt("8");      /// Constant for "eight"
    public static final BrobInt NINE = new BrobInt("9");      /// Constant for "nine"
    public static final BrobInt TEN = new BrobInt("10");      /// Constant for "ten"

    /// Some constants for other intrinsic data types
    ///  these can help speed up the math if they fit into the proper memory space
    // public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
    // public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
    // public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
    // public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

    /// These are the internal fields
    public String internalValue = "";        // internal String representation of this BrobInt
    public byte sign = 0;         // "0" is positive, "1" is negative

    public String getInternalValue() {
        return internalValue;
    }

    public void setInternalValue(String internalValue) {
        this.internalValue = internalValue;
    }

    public byte getSign() {
        return sign;
    }

    public void setSign(byte sign) {
        this.sign = sign;
    }

    public String getReversed() {
        return reversed;
    }

    public void setReversed(String reversed) {
        this.reversed = reversed;
    }

    public byte[] getByteVersion() {
        return byteVersion;
    }

    public void setByteVersion(byte[] byteVersion) {
        this.byteVersion = byteVersion;
    }

    /// You can use this or not, as you see fit.  The explanation was provided in class
    private String reversed = "";        // the backwards version of the internal String representation

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final boolean DEBUG_ON = false;
    private static final boolean INFO_ON = false;
    private byte[] byteVersion;

    /**
     * Constructor takes a string and assigns it to the internal storage, checks for a sign character
     * and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
     * for later use
     *
     * @param value String value to make into a BrobInt
     */
    public BrobInt(String value) {
        // todo 构造方法无意义，仅检查字符串是否合法
        if (value.charAt(0) == '-') {
            sign = 1;
            value = value.substring(1);
        } else if (value.charAt(0) == '+') {
            sign = 0;
            value = value.substring(1);
        } else {
            sign = 0;
        }

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) < '0' || '9' < value.charAt(i)) {
                throw new IllegalArgumentException("digit " + value.charAt(i) +
                        " out of range!");
            }
        }
        this.internalValue = value;
        StringBuilder temp = new StringBuilder(value.substring(1));
        temp.reverse();
        this.reversed = temp.toString();
        //todo  参数意义不明
        this.byteVersion = reversed.getBytes();      // replace this with the appropriate code to accomplish what is in the javadoc text
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to validate that all the characters in the value are valid decimal digits
     *
     * @return boolean  true if all digits are good
     * @throws IllegalArgumentException if something is hinky
     *                                  note that there is no return false, because of throwing the exception
     *                                  note also that this must check for the '+' and '-' sign digits
     *                                  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    //todo 方法单纯校验首位是否为符号位，并且判断数字位是否在0-9之间
    public boolean validateDigits() throws IllegalArgumentException {
        boolean flag = true;
        //todo  参数value 未知 从上下文来看应该是使用internalValue
        String value = internalValue;

        if (value.contains("+")) {
            flag = value.indexOf('+') == 0;
        }
        if (value.contains("-")) {
            flag = value.indexOf('-') == 0;
        }
        for (int i = value.contains("+") || value.contains("-") ? 1 : 0; i < value.length(); i++) {
            if (!(value.charAt(i) >= '0' && value.charAt(i) <= '9')) {
                flag = false;
            }
            if (!flag) {
                // todo 报错异常有误，应该提示校验失败，而非方法未实现，抛出IllegalArgumentException才对
                throw new UnsupportedOperationException("\n         Sorry, that operation is not yet implemented.");
            }
        }
        return flag;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to reverse the value of this BrobInt
     *
     * @return BrobInt that is the reverse of the value of this BrobInt
     * NOTE: you can use this or not, as you see fit; explanation was given in class
     * @see StringBuffer API page for an easy way to do this
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt reverser() {
        //todo  使用StringBuffer 反转字符串
        StringBuffer sb = new StringBuffer(internalValue.substring(1));
        sb.reverse();
        return new BrobInt(sb.toString());
//        throw new UnsupportedOperationException("\n         Sorry, that operation is not yet implemented.");
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to reverse the value of a BrobIntk passed as argument
     * Note: static method
     *
     * @param bint BrobInt to reverse its value
     * @return BrobInt that is the reverse of the value of the BrobInt passed as argument
     * NOTE: you can use this or not, as you see fit; explanation was given in class
     * @see StringBuffer API page for an easy way to do this
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static BrobInt reverser(BrobInt bint) {
        //todo  使用StringBuffer 反转字符串
        return bint.reverser();
//        throw new UnsupportedOperationException("\n         Sorry, that operation is not yet implemented.");
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to add the value of a BrobIntk passed as argument to this BrobInt
     *
     * @param bint BrobInt to add to this
     * @return BrobInt that is the sum of the value of this BrobInt and the one passed in
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt add(BrobInt bint) {
        //todo 方法仅仅考虑了大数均为正的情况，一正一负以及皆为负数该如何？
        int[] temp1 = new int[this.internalValue.length()];
        for (int i = 0; i < temp1.length; i++) {
            temp1[i] = reversed.charAt(i) - '0';
        }
        int[] temp2 = new int[bint.internalValue.length()];
        for (int i = 0; i < temp2.length; i++) {
            temp2[i] = bint.internalValue.charAt(bint.internalValue.length() - 1 - i) - '0';
        }
        // System.out.println(Arrays.toString(temp2));
        //todo 使用最简单的运算，易于理解，但计算效率很低，按照作业，应该使用俄罗斯农民乘法
        int i = 0;
        int j = 0;
        int carryout = 0;
        StringBuilder res = new StringBuilder();
        while (i < temp1.length && j < temp2.length) {
            res.append((temp1[i] + temp2[j] + carryout) % 10);
            carryout = (temp1[i] + temp2[j]) >= 10 ? 1 : 0;
            i++;
            j++;
        }
        while (i < temp1.length) {
            res.append((temp1[i] + carryout) % 10);
            carryout = (temp1[i] + carryout) >= 10 ? 1 : 0;
            i++;
        }
        while (j < temp2.length) {
            res.append((temp2[i] + carryout) % 10);
            carryout = (temp2[j] + carryout) >= 10 ? 1 : 0;
            j++;
        }
        if (carryout != 0) {
            res.append(carryout);
        }
        return new BrobInt(res.reverse().toString());
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to subtract the value of a BrobIntk passed as argument to this BrobInt
     *
     * @param bint BrobInt to subtract from this
     * @return BrobInt that is the difference of the value of this BrobInt and the one passed in
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt subtract(BrobInt bint) {
        //todo 意义不明 先删除这个returenBint
        //BrobInt returnBint = new BrobInt();

//            if (!(this.validateDigits() && bint.validateDigits()))
//
//                throw new UnsupportedOperationException("\n         Sorry, that operation is not yet implemented.");
        // todo BrobInt对象无法通过校验会抛出异常，这里通过判断抛出异常无意义，直接调用校验方法即可
        //其实BrobInt 初始化方法时均会校验，
        // this.validateDigits();
        // bint.validateDigits();

        bint.sign = 1;
        BrobInt add = add(bint);
        bint.sign = 0;
        return add;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to multiply the value of a BrobIntk passed as argument to this BrobInt
     *
     * @param bint BrobInt to multiply this by
     * @return BrobInt that is the product of the value of this BrobInt and the one passed in
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt multiply(BrobInt bint) {
        int[] temp1 = new int[reversed.length()];
        for (int i = 0; i < temp1.length; i++) {
            temp1[i] = reversed.charAt(i) - '0';
        }
        int[] temp2 = new int[bint.internalValue.length()];
        for (int i = 0; i < temp2.length; i++) {
            temp2[i] = bint.internalValue.charAt(bint.internalValue.length() - 1 - i) - '0';
        }
        // System.out.println(Arrays.toString(temp1));
        int[] res = new int[temp1.length + temp2.length + 1];
        for (int i = 0; i < temp1.length; i++) {
            for (int j = 0; j < temp2.length; j++) {
                res[i + j] += temp1[i] * temp2[j];
            }
        }
        System.out.println(Arrays.toString(res));
        StringBuilder res_in_string = new StringBuilder();
        for (int i = 0; i < res.length - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] %= 10;
            res_in_string.append(res[i]);
        }
        // System.out.println(res[0]);
        String result = res_in_string.reverse().toString();
        if (result.charAt(0) == '0') {
            result = result.substring(1);
        }
        return new BrobInt(result);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to divide the value of this BrobIntk by the BrobInt passed as argument
     *
     * @param bint BrobInt to divide this by
     * @return BrobInt that is the dividend of this BrobInt divided by the one passed in
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt divide(BrobInt bint) {
        BrobInt returnBint = new BrobInt("0");
        // todo 无需初始化
//            BrobInt Big = new BrobInt();
//            BrobInt Small = new BrobInt();
        BrobInt Big;
        BrobInt Small;
//            if (!(this.validateDigits() && bint.validateDigits()))
//                throw new UnsupportedOperationException("\n         Sorry, that operation is not yet implemented.");
        // todo BrobInt对象无法通过校验会抛出异常，这里通过判断抛出异常无意义，直接调用校验方法即可
        this.validateDigits();
        bint.validateDigits();

        // todo 没有compare方法，只有compareTo方法
//            Integer compare = compare(this, bint);
        Integer compare = compareTo(bint);
        if (compare == -1) {
            return new BrobInt("0");
        } else {
            Small = bint;
            Big = this;
        }
        // todo BrobInter to BrobInt
//            BrobInt cnt = new BrobInter("0");
        BrobInt cnt = new BrobInt("0");
        while (Big.compareTo(new BrobInt("0")) != 0 || Big.compareTo(Small) == 1) {
            Big = Big.subtract(Small);
            // todo BrobInter to BrobInt
//                BrobInt brobInt = new BrobInter("1");
            BrobInt brobInt = new BrobInt("1");
            cnt = cnt.add(brobInt);
            if (Big.compareTo(Small) == -1) {
                break;
            }
        }
        return cnt;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to get the remainder of division of this BrobInt by the one passed as argument
     *
     * @param bint BrobInt to divide this one by
     * @return BrobInt that is the remainder of division of this BrobInt by the one passed in
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt remainder(BrobInt bint) {
        // todo returnBint 无用处
//            BrobInter returnBint = new BrobInter("0");
        // todo 无需初始化
//            BrobInt Big = new BrobInt();
//            BrobInt Small = new BrobInt();
        BrobInt Big;
        BrobInt Small;
//            if (!(this.validateDigits() && bint.validateDigits()))
//                throw new UnsupportedOperationException("\n         Sorry, that operation is not yet implemented.");
        // todo BrobInt对象无法通过校验会抛出异常，这里通过判断抛出异常无意义，直接调用校验方法即可
        this.validateDigits();
        bint.validateDigits();
        // todo 没有compare方法，只有compareTo方法
//            Integer compare = compare(this, bint);
        Integer compare = compareTo(bint);
        if (compare == -1) {
            return new BrobInt("0");
        } else {
            Small = bint;
            Big = this;
        }
        BrobInt cnt = new BrobInt("0");
        // todo 代码中通过减法实现余数的获取
        while (true) {
            Big = Big.subtract(Small);
            BrobInt brobInter = new BrobInt("1");
            cnt = cnt.add(brobInter);
            if (Big.compareTo(new BrobInt("0")) == 0 || Big.compareTo(Small) == -1) {
                break;
            }
        }
        return Big;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to compare a BrobInt passed as argument to this BrobInt
     *
     * @param bint BrobInt to compare to this
     * @return int   one of neg/0/pos if "this" BrobInt is less/equal/more than the "bint" BrobInt
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public int compareTo(BrobInt bint) {

        // remove any leading zeros because we will compare lengths
        String me = removeLeadingZeros(this).toString();
        String arg = removeLeadingZeros(bint).toString();

        // check if they are equal first, and return a zero if so
        if (this.equals(bint)) {
            return 0;
        }

        // handle the signs here
        //  if "this" is neg and "bint" is pos, "this" is smaller so return -1
        if (1 == sign && 0 == bint.sign) {
            return -1;

            // if "this" is pos and "bint" is neg, "this" is larger so return +1
        } else if (0 == sign && 1 == bint.sign) {
            return 1;
        }

        // otherwise, signs are the same, so we must check the lengths
        //  the longer one is going to be the MORE OF THAT SIGN
        //  e.g., "-1111" for "this" is more neg than "-222" for "arg" so return -1
        if ((1 == sign) && (1 == bint.sign)) {
            if (me.length() < arg.length()) {
                return 1;
            } else if (me.length() > arg.length()) {
                return -1;
            }
        } else if ((0 == sign) && (0 == bint.sign)) {
            if (me.length() < arg.length()) {
                return -1;
            } else if (me.length() > arg.length()) {
                return 1;
            }
        }

        // compare digit-by-digit
        // can only go to the length of the shortest if they are different lengths
        // int end = (me.length() < arg.length()) ? me.length() : arg.length();
        for (int i = 0; i < me.length(); i++) {
            if (me.charAt(i) < arg.charAt(i)) {
                return -1;
            } else if (me.charAt(i) > arg.charAt(i)) {
                return 1;
            }
        }
        return 0;      // if it gets here, just assume equality to fool the compiler
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to check if a BrobInt passed as argument is equal to this BrobInt
     *
     * @param bint BrobInt to compare to this
     * @return boolean  that is true if they are equal and false otherwise
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public boolean equals(BrobInt bint) {
        return ((sign == bint.sign) && (this.toString().equals(bint.toString())));
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to return a BrobInt given a long value passed as argument
     *
     * @param value long type number to make into a BrobInt
     * @return BrobInt  which is the BrobInt representation of the long
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static BrobInt valueOf(long value) throws NumberFormatException {
        BrobInt bi = null;
        try {
            bi = new BrobInt(Long.valueOf(value).toString());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("\n  Sorry, the value must be numeric of type long.");
        }
        return bi;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to return a String representation of this BrobInt
     *
     * @return String  which is the String representation of this BrobInt
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public String toString() {
        return internalValue;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to remove leading zeros from a BrobInt passed as argument
     *
     * @param bint BrobInt to remove zeros from
     * @return BrobInt that is the argument BrobInt with leading zeros removed
     * Note that the sign is preserved if it exists
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public BrobInt removeLeadingZeros(BrobInt bint) {
        Character sign = null;
        String returnString = bint.toString();
        int index = 0;

        if (allZeroDetect(bint)) {
            return bint;
        }
        if (('-' == returnString.charAt(index)) || ('+' == returnString.charAt(index))) {
            sign = returnString.charAt(index);
            index++;
        }
        if (returnString.charAt(index) != '0') {
            return bint;
        }

        while (returnString.charAt(index) == '0') {
            index++;
        }
        returnString = bint.toString().substring(index, bint.toString().length());
        if (sign != null) {
            returnString = sign.toString() + returnString;
        }
        return new BrobInt(returnString);

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to return a boolean if a BrobInt is all zeros
     *
     * @param bint BrobInt to compare to this
     * @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public boolean allZeroDetect(BrobInt bint) {
        for (int i = 0; i < bint.toString().length(); i++) {
            if (bint.toString().charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to display an Array representation of this BrobInt as its bytes
     *
     * @param d byte array from which to display the contents
     *          NOTE: may be changed to int[] or some other type based on requirements in code above
     *          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void toArray(int[] d) {
        System.out.println("Array contents: " + Arrays.toString(d));
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method to display a prompt for the user to press 'ENTER' and wait for her to do so
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void pressEnter() {
        String inputLine = null;
        try {
            System.out.print("      [Press 'ENTER' to continue]: >> ");
            inputLine = input.readLine();
        } catch (IOException ioe) {
            System.out.println("Caught IOException");
        }

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * the main method redirects the user to the test class
     *
     * @param args String array which contains command line arguments
     *             NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
     *             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static void main(String[] args) {
        System.out.println("\n  Hello, world, from the BrobInt program!!\n");
        System.out.println("\n   You should run your tests from the BrobIntTester, but here are a few...\n");

        BrobInt b1 = null;
        ;
        try {
            System.out.println("   Making a new BrobInt: ");
            b1 = new BrobInt("147258369789456123");
        } catch (Exception e) {
            System.out.println("        Exception thrown:  " + e.toString());
        }
        try {
            System.out.println("   expecting: 147258369789456123\n     and got: " + b1.toString());
        } catch (Exception e) {
            System.out.println("        Exception thrown:  " + e.toString());
        }

        System.out.println("\n    Multiplying 82832833 by 3: ");
        try {
            System.out.println("      expecting: 248498499\n        and got: " + new BrobInt("82832833").multiply(BrobInt.THREE));
        } catch (Exception e) {
            System.out.println("        Exception thrown:  " + e.toString());
        }

        System.out.println("\n    Multiplying 3 by 82832833 and adding 1: ");
        try {
            System.out.println("      expecting: 248498500\n        and got: " + BrobInt.THREE.multiply(new BrobInt("82832833")).add(BrobInt.ONE));
        } catch (Exception e) {
            System.out.println("        Exception thrown:  " + e.toString());
        }

        try {
            System.out.println("\n\n   Making a new BrobInt: ");
            b1 = new BrobInt("-99999");
        } catch (Exception e) {
            System.out.println("        Exception thrown:  ");
        }
        System.out.println("\n   Testing equals() method on b1 of -99999 and b2 of 99999: ");
        try {
            System.out.println("      expecting: false\n        and got: " + b1.equals(new BrobInt("99999")));
        } catch (Exception e) {
            System.out.println("        Exception thrown:  " + e.toString());
        }
        System.out.println("\n   Testing equals() method on b1 of -99999 and b2 of -99999: ");
        try {
            System.out.println("      expecting: true\n        and got: " + b1.equals(new BrobInt("-99999")));
        } catch (Exception e) {
            System.out.println("        Exception thrown:  " + e.toString());
        }

        System.exit(0);

    }
}



