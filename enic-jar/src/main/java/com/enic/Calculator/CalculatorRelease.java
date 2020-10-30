package com.enic.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalculatorRelease {

    private float MemoryValue;

    private int flag = 0;

    public static void main(String[] args) {
        CalculatorRelease calculator = new CalculatorRelease();
        List<Float> MemoryValueArr = new ArrayList<>();
        String line = null;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Calculator Test, Please Enter Operator:");
            String name = sc.nextLine();  //读取字符串型输入
            if (calculator.getFlag() > 0 && name.equals("mr")) {
                System.out.println(calculator.getMemoryValue());
                continue;
            }
            if (calculator.getFlag() > 0 && name.equals("h")) {
                MemoryValueArr.stream().forEach(item -> {
                    System.out.print(item + " ");
                });
                System.out.println();
                continue;
            }
            if (calculator.getFlag() > 0 && name.equals("c")) {
                calculator.clearMemory();
                System.out.println("Clear Memory Success!");
                continue;
            }
            float res = calculator.getCurrentValue(name);
            System.out.println("[" + name + "]=" + res);
            MemoryValueArr.add(res);
            System.out.println("Is Con Y/N:");
            line = sc.nextLine();
        } while (!(line.equals("N") || line.equals("n")));
    }

    public float getCurrentValue(String expressions) {
        try {
            int leftIndex = expressions.lastIndexOf("(");
            //无括号情况
            if (leftIndex == -1) {
                return evaluate(expressions);
            } else {
                int rightIndex = expressions.substring(leftIndex).indexOf(")") + leftIndex;
                float res = evaluate(expressions.substring(leftIndex + 1, rightIndex));
                //重新组装表达式
                expressions = expressions.substring(0, leftIndex) + res + expressions.substring(rightIndex + 1);
                return getCurrentValue(expressions);
            }
        } catch (Exception e) {
            System.out.println("!!!Invalid input:[" + expressions + "]");
        }
        return Float.MIN_VALUE;
    }

    public float evaluate(String expression) throws Exception {
        //1. 获取所有四则运算的数字
        List<Float> numbers = sliptNumbers(expression);
        // 2. 获取所有四则运算的操作符号
        List<Character> ops = sliptOps(expression);
        //3.先进行乘除运算
        // 遍历运算符中的*和/
        for (int i = 0; i < ops.size(); i++) {
            // * /
            //获取运算符
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                // 从运算符的容器中移除
                ops.remove(i);// 移除当前位置
                // 从数字容器中获取对应该运算符位置的两个数字（移除）
                Float f1 = numbers.remove(i);
                Float f2 = numbers.remove(i);

                f1 = op == '*' ? f1 * f2 : f1 / f2;
                // 把运算结果插入到数字容器中的i位置
                numbers.add(i, f1);// 插入到i的位置 原来从i位置一直到最后的数据，都要往后瞬移一位
                i--;// 移除后，后面所有运算符往前移动，为了保证下一个运算符不被遗漏，所以i--
            }
        }
        // 4. 再加减运算
        while (!ops.isEmpty()) {
            // 每次去运算容器中第一个运算符
            char op = ops.remove(0);
            // 每次从数字容器中两次取第一个数字
            float f1 = numbers.remove(0);
            float f2 = numbers.remove(0);

            // 计算
            f1 = op == '+' ? f1 + f2 : f1 - f2;

            // 把结果插入到数字容器中的第一个位置
            numbers.add(0, f1);
        }
        //标识位++
        flag++;
        // 5. 返回结果
        return numbers.get(0);
    }


    /**
     * 从表达式中分离所有的运算符
     *
     * @param expression
     */
    private List<Character> sliptOps(String expression) {
        List<Character> ops = new ArrayList<Character>();
        // -8*-2+3/-1-5*-2-5
        // 把真实表达式变成下面的表达式
        String formaterExp = formaterExp(expression);
        // @8*@2+3/@1-5*@2-5
        StringTokenizer st = new StringTokenizer(formaterExp, "@0123456789.");
        while (st.hasMoreTokens()) {
            String opStr = st.nextElement() + ""; // 取出分割符号之间的数据
            ops.add(opStr.charAt(0));
        }
        return ops;
    }

    /**
     * 从表达式分离出所有数字
     *
     * @param expression
     * @return
     */
    private List<Float> sliptNumbers(String expression) {
        List<Float> numbers = new ArrayList<>();
        // -8*-2+3/-1-5*-2-5
        // 把真实表达式变成下面的表达式
        String formaterExp = formaterExp(expression);
        // @8*@2+3/@1-5*@2-5
        StringTokenizer st = new StringTokenizer(formaterExp, "+-*/");
        while (st.hasMoreTokens()) {
            String numStr = st.nextElement() + "";
            //如果前面是@则为负数
            if (numStr.charAt(0) == '@') {
                numStr = "-" + numStr.substring(1);
            }
            numbers.add(Float.parseFloat(numStr));
        }
        return numbers;
    }

    private String formaterExp(String expression) {
        int index = 0;
        while (index < expression.length()) {
            char c = expression.charAt(index);
            // 判断是否是-符号
            // -代表的是负数 第一个，前一字符*/
            if (c == '-') {
                if (index == 0) {
                    expression = "@" + expression.substring(1);
                } else {
                    if (expression.charAt(index - 1) == '*' || expression.charAt(index - 1) == '/') {
                        expression = expression.substring(0, index) + "@" + expression.substring(index + 1);
                    }
                }
            }
            index++;
        }
        return expression;
    }

    //clearMemory
    public void clearMemory() {
        MemoryValue = 0;
    }

    public float getMemoryValue() {
        return MemoryValue;
    }

    public void setMemoryValue(float memoryValue) {
        MemoryValue = memoryValue;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
