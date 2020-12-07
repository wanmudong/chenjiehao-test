package 生日问题;

import java.util.Scanner;

/**
 * 描述:
 * 生日问题
 *
 * @author
 * @create 2020-12-07
 */
public class BirthdaySolver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N：");
        // 人数
        int N = sc.nextInt();
        System.out.print("实验次数为：");
        //试验次数
        int number = sc.nextInt();

        // 公式概率
        double formulaProbability = calculationFormulaProbability(N);
        // 模拟概率
        double simulationProbability = calculateSimulationProbability(N, number);

        // 公式概率
        System.out.println("公式概率：" + formulaProbability);
        // 模拟概率
        System.out.println("模拟概率：" + simulationProbability);
    }

    /**
     * 计算公式概率
     *
     * @param N 同一个环境中的人的数量
     * @return 公式概率
     */
    private static double calculationFormulaProbability(int N) {
        if (N > 365) {
            return 1;
        }

        double probability;
        double divide = 1;
        for (int i = 0; i < N; i++) {
            divide = divide * (365 - i);
        }
        probability = divide / Math.pow(365, N);
        return 1 - probability;
    }


    /**
     * 计算模拟概率
     *
     * @param N     同一个环境中的人的数量
     * @param times 需要模拟的次数
     * @return 模拟概率
     */
    private static double calculateSimulationProbability(int N, int times) {
        //重复次数
        int repeatTimes = 0;
        for (int i = 1; i < times; i++) {
            //代表365天
            int[] days = new int[365];
            for (int j = 0; j < N; j++) {
                //生成0-365之间任意数字并取整
                int p = (int) (Math.random() * 365);
                if (days[p] == 1) {
                    repeatTimes++;
                    break;
                } else {
                    days[p] = 1;
                }
            }
        }
        return (double) repeatTimes / times;
    }
}
