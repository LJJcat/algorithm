package base;

/**
 * java 基础知识
 *
 * @author lijingjing
 * @date 2021/6/24 19:42
 */
public class JavaBase {


    public static void main(String[] args) {
        jiaJia();
    }

    /**
     * 位运算、a++、++a
     */
    public static void jiaJia() {
        int a = 10 >> 1;
        System.out.println(a); // 5
        System.out.println("\n");
        int b = a++;
        System.out.println(a); // 6
        System.out.println(b); // 5
        System.out.println("\n");

        int c = ++a;
        System.out.println(a); // 7
        System.out.println(b); // 5
        System.out.println(c); // 7
        System.out.println("\n");

        int d = b * a++;
        System.out.println(a); // 8
        System.out.println(b); // 5
        System.out.println(c); // 7
        System.out.println(d); // 35
    }


}