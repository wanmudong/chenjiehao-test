package Java作业2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
public class BrobIntTester {
    /**
     *  test BrobInt
     */
    @Test
    public void constructTest(){
        BrobInt brobInt  =new BrobInt("9090202019020");
        System.out.println(brobInt.internalValue);
        System.out.println(Arrays.toString(brobInt.getByteVersion()));
        System.out.println(brobInt.getByteVersion().length);
        System.out.println(brobInt.getSign());
        System.out.println(brobInt.getReversed());
    }
    /**
     *  test validateDe\igits
     */
    @Test
    public void validateDigits(){
        try{
            //这个测试用例 +123456
            assertEquals(true,new BrobInt("+123456").validateDigits());
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(true,new BrobInt("123456").validateDigits());
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(false,new BrobInt("-023456").validateDigits());
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(true,new BrobInt("023456").validateDigits());
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(true,new BrobInt("-123456").validateDigits());
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
    }


    /**
     * test Compareto
     *
     */
    @Test
    public void compareToTest(){
        try{
            assertEquals(1,new BrobInt("123456").compareTo(new BrobInt("-123456")));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(1,new BrobInt("-1234567").compareTo(new BrobInt("-12345678")));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(1,new BrobInt("123456").compareTo(new BrobInt("123455")));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addTest(){
        try{
            assertEquals(0,new BrobInt("0").compareTo(new BrobInt("-12344").add(new BrobInt("12344"))));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }

        try{
            assertEquals(0,new BrobInt("-29930").compareTo(new BrobInt("-15600").add(new BrobInt("-14330"))));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
    }


    @Test
    public void multi(){
        try{
            assertEquals(0,new BrobInt("1726596").compareTo(new BrobInt("-1314").multiply(new BrobInt("-1314"))));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(0,new BrobInt("-1726596").compareTo(new BrobInt("1314").multiply(new BrobInt("-1314"))));
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
    }
    @Test
    public void divideTest(){
        try{
            assertEquals(0,new BrobInt("1").compareTo(new BrobInt("1726596").divide(new BrobInt("-1314").multiply(new BrobInt("-1314")))) );
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        try{
            assertEquals(0,new BrobInt("").compareTo(new BrobInt("200").divide(new BrobInt("2").multiply(new BrobInt("50")))) );
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
    }

    @Test
    public void remainderTest(){
        try{
            assertEquals(0,new BrobInt("1").compareTo(new BrobInt("5").remainder(new BrobInt("1").multiply(new BrobInt("2")))) );
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
    }





}
