
/**
 * description:
 * java file to solve the probability of 2 people have same birhtday in n people.
 *
 * @author Mengdi Zhu
 */
public class BirthdaySolver {
    private static final int DAY_OF_YEA = 365;
    private static final int DEFAULT_TRAIL = 1000000;

    public static void main(String[] args) {
        int num;
        int numTrail;
        try {
            num = Integer.parseInt(args[0]);
        } catch (Exception e){
            System.out.println("Failed to parse the first parameter, maybe the input format is wrong");
            return;
        }
        try {
            numTrail = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Failed to parse the second parameter, maybe the input format is wrong, use the default value 100000");
            numTrail = DEFAULT_TRAIL;
        }

        System.out.println("The expirmental probability of 2 people have the same birthday is " + expCalculate(num, numTrail) + " %");
        System.out.println("The actual probability of 2 people have the same birthday is " + actCalculate(num) + " %");
    }

    /**
     * The expirmental probability of 2 people have the same birthday
     *
     * @param num      num of people
     * @param numTrail Number of experiments
     * @return expirmental probability
     */
    public static double expCalculate(int num, int numTrail) {
        long startTime = System.currentTimeMillis();
        int repeatTimes = 0;
        int count = 10;
        for (int i = 1; i < numTrail; i++) {
            long costTime = (System.currentTimeMillis() - startTime) / 1000;
            if (costTime != 0 && costTime % count == 0){
                System.out.println("The simulation experiment has taken "+costTime+" seconds");
                count+=10;
            }
            int[] birthdays = new int[DAY_OF_YEA];
            for (int j = 0; j < num; j++) {
                int randomDay = (int) (Math.random() * DAY_OF_YEA);
                if (birthdays[randomDay] == 1) {
                    repeatTimes++;
                    break;
                } else {
                    birthdays[randomDay] = 1;
                }
            }
        }
        double probability = (double) repeatTimes / numTrail;
        return (double) Math.round(probability * 1000000) / 10000;

    }

    /**
     * The actual probability of 2 people have the same birthday
     *
     * @param num      num of people
     * @return actual probability
     */
    public static double actCalculate(int num) {

        if (num > DAY_OF_YEA) {
            return 1;
        }

        double probability;
        double divide = 1;
        for (int i = 0; i < num; i++) {
            divide = divide * (DAY_OF_YEA - i);
        }
        probability = divide / Math.pow(DAY_OF_YEA, num);
        return (double)Math.round((1- probability) * 1000000) / 10000;
    }

}

