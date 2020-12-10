package Java作业2;

import java.util.Scanner;

public class Neptune {
    public static void main(String[] args) {
        String next = "";
        Scanner cin =new Scanner(System.in);
        String str = cin.nextLine();
        BrobInt a = new BrobInt(str);
        BrobInt n = new BrobInt("2");
        BrobInt LightHalf = new BrobInt("150000000");
        BrobInt startSpeed = new BrobInt("11186");
        BrobInt endSpeed = new BrobInt("23500");
        BrobInt distance = new BrobInt("88000000000000");
        // t is the time which is light arrive
        BrobInt t = LightHalf.subtract(startSpeed).divide(a);
        //x is the distance which using half of time 
        BrobInt x = startSpeed.add(LightHalf).divide(new BrobInt("2")).multiply(t);
        //the rest distance
        BrobInt lx = distance.subtract(x);
        // the average velocity
        BrobInt v = LightHalf.add(endSpeed).divide(new BrobInt("2"));
        BrobInt lt = lx.divide(v);
        //t tt is thew time which is light arrive 
        BrobInt llt = LightHalf.subtract(endSpeed).divide(a);
        // xx is the distance which using half of time.
        BrobInt xx = endSpeed.add(LightHalf).divide(new BrobInt("2")).multiply(llt);
        // llx is the last time.
        BrobInt llx = distance.subtract(xx);
        // vv is velocity
        BrobInt vv = LightHalf.add(startSpeed).divide(new BrobInt("2"));
        //lltt   is time
        BrobInt lllt = llx.divide(vv);

        BrobInt time = t.add(lt).add(llt).add(lllt);
        BrobInt hours = time.divide(new BrobInt("3600"));
        time = time.remainder(new BrobInt("3600"));
        BrobInt minutes = time.divide(new BrobInt("60"));
        BrobInt seconds = time.remainder(new BrobInt("60"));
        System.out.println("time："+hours+"hours"+minutes+"minutes"+seconds+"seconds");
        System.out.println("a:"+a.toString());


    }
}
