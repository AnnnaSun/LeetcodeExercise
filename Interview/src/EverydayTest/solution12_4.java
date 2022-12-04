package src.EverydayTest;

import java.util.Arrays;

//你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
//
//必须选择 一种 冰激凌基料。
//可以添加 一种或多种 配料，也可以不添加任何配料。
//每种类型的配料 最多两份 。
//给你以下三个输入：
//
//baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
//toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
//target ，一个整数，表示你制作甜点的目标价格。
//你希望自己做的甜点总成本尽可能接近目标价格 target 。
//
//返回最接近 target 的甜点成本。如果有多种方案，返回成本相对较低 的一种。
public class solution12_4 {
    int res;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = Arrays.stream(baseCosts).min().getAsInt();//初始化res取basecost中的最小值
        for (int b : baseCosts) {
            dfs(toppingCosts, 0, b, target);
        }
        return res;
    }

    public void dfs(int[] toppingCosts, int p, int curCost, int target) {
        if (Math.abs(res - target) < curCost - target) {
            return;//差值比当前花费差值更小的时候说明已经取到了最小值，返回
        } else if (Math.abs(res - target) >= Math.abs(curCost - target)) {
            if (Math.abs(res - target) > Math.abs(curCost - target)) {
                res = curCost;//当前比上一次记录的差值更小，当前花销取代记录的最小值
            } else {
                res = Math.min(res, curCost);//因为是abs，取两值中的最小值
            }
        }
        if (p == toppingCosts.length) {
            return;//正好相等直接返回
        }
        //三种填料方式：双倍，加一次，不加
        dfs(toppingCosts, p + 1, curCost + toppingCosts[p] * 2, target);
        dfs(toppingCosts, p + 1, curCost + toppingCosts[p], target);
        dfs(toppingCosts, p + 1, curCost, target);
    }
}

class solution12_4_1{
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int x = Arrays.stream(baseCosts).min().getAsInt();
        if (x >= target) {
            return x;//获取到的basecost直接大于target就返回
        }
        boolean[] can = new boolean[target + 1];//初始化动态数组
//        当最小的基料开销小于target 时，我们可以对超过target 的制作开销方案只保存其最小的一份即可，
//        并可以初始化为 2×target−x，因为大于该开销的方案与目标价格target 的距离一定大于仅选最小基料的情况，所以一定不会是最优解

//        解释：因为大于该开销的方案与目标价格 target 的距离一定大于仅选最小基料的情况，所以一定不会是最优解。
//        这里临界值和目标价格差值为2*target-x-target=target-x，只选基料的价格为abs(x-target)=target-x (题解基料价格小于目标价格)，
//        也就是如果你的方案比2*target-x还大的话就不如只选基料了。
        int res = 2 * target - x;
        for (int b : baseCosts) {
            if (b <= target) {
                can[b] = true;
            } else {
                res = Math.min(res, b);
            }
        }
        for (int t : toppingCosts) {
            for (int count = 0; count < 2; ++count) {
                for (int i = target; i > 0; --i) {
                    if (can[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    if (i - t > 0) {
                        can[i] = can[i] | can[i - t];
                    }
                }
            }
        }
        for (int i = 0; i <= res - target; ++i) {
            if (can[target - i]) {
                return target - i;
            }
        }
        return res;
    }
}
