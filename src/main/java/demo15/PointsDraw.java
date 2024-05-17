package demo15;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/17  19:58
 */
@Slf4j
public class PointsDraw {




        // 方法：根据积分权重随机抽取中奖用户
        public static int pickWinner(int[] points) {
            // 计算总积分，使用 long 类型以防止溢出
            long totalPoints = 0;
            for (int point : points) {
                totalPoints += point;
            }

            // 检查总积分是否为正数
            if (totalPoints <= 0) {
                throw new IllegalArgumentException("总积分必须是正数。");
            }

            // 在 [0, totalPoints) 范围内生成一个随机数，在 [0, 1) 范围内的浮点数，然后乘以 totalPoints
            Random random = new Random();
            long randomPoint = (long) (random.nextDouble() * totalPoints);

            // 根据随机数找到中奖用户
            long cumulativeSum = 0;
            for (int i = 0; i < points.length; i++) {
                cumulativeSum += points[i];
                if (randomPoint < cumulativeSum) {
                    return i; // 返回中奖用户的ID
                }
            }

            // 如果发生错误（不应该发生）
            throw new RuntimeException("抽奖过程中出现意外错误。");
        }

        // 单元测试
        public static void main(String[] args) {
            try {
                // 测试用例1：简单测试
                //int[] points1 = {20, 34, 160, 2};
                //testPickWinner(points1, 1000);

                // 测试用例2：所有值都为最小值的边界情况
                //int[] points2 = {1, 1, 1, 1};
                //testPickWinner(points2, 1000);

                // 测试用例3：所有值都为最大值的边界情况
                //int[] points3 = new int[50000];
                //for (int i = 0; i < 50000; i++) {
                //    points3[i] = 50000;
                //}
                //testPickWinner(points3, 1000);

                // 测试用例4：随机大规模测试
                int[] points4 = new int[100];
                Random rand = new Random();
                for (int i = 0; i < 100; i++) {
                    points4[i] = rand.nextInt(50000) + 1;
                }
                testPickWinner(points4, 1000);

            } catch (IllegalArgumentException e) {
                System.err.println("输入参数错误：" + e.getMessage());
            } catch (Exception e) {
                System.err.println("发生错误：" + e.getMessage());
            }
        }

        // 方法：测试 pickWinner 函数
        public static void testPickWinner(int[] points, int trials) {
            if (points == null || points.length == 0) {
                throw new IllegalArgumentException("积分数组不能为空。");
            }

            int[] results = new int[points.length]; // 创建一个数组来记录每个用户的中奖次数
            for (int i = 0; i < trials; i++) {
                int winner = pickWinner(points); // 抽取一次中奖用户
                results[winner]++; // 记录中奖用户的中奖次数
            }

            // 输出测试结果
            System.out.println("测试结果：");
            for (int i = 0; i < results.length; i++) {
                System.out.println("用户 " + i + " 中奖 " + results[i] + " 次。");
            }
        }
    }


/*
* 借用dubbo负载均衡其中一种加权随机思想：
* 假设我们有一组服务器 servers = [A, B, C]，他们对应的权重为
weights = [5, 3, 2]，权重总和为 10。现在把这些权重值平铺在一维坐标值上，[0, 5) 区
间属于服务器 A，[5, 8) 区间属于服务器 B，[8, 10) 区间属于服务器 C。接下来通过
随机数生成器生成一个范围在 [0, 10) 之间的随机数，然后计算这个随机数会落到哪个
区间上就可以了。
* */

/**
 * 计算总积分的时间复杂度为O(n)，其中n是数组的长度。
 * 根据随机数找到中奖用户的时间复杂度为O(n)。
 * **/
