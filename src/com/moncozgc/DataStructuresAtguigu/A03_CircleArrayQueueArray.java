package com.moncozgc.DataStructuresAtguigu;

import java.util.Scanner;

/**
 * 环形队列
 *
 * 1. front 变量的含义做一个调整: front 就指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素, front的初始值= 0
 * 2. rear 变量的含义做一个调整: rear 指向队列的最后- -个元素的后一位置.因为希望空出一个空间做为约定, rear的初始值=0
 * 3. 当队列满时，条件是: (rear + 1) % maxSize= front [满]
 * 4. 对队列为空的条件，rear == front [空]
 * 5. 当我们这样分析，队列中有效的数据的个数: (rear + maxSize - front) % maxSize // eg:  rear= 1 front=0
 * 6. 我们就可以在原来的队列上修改得到，一个环形队列
 *
 * Created by MoncozGC on 2022/6/21
 */
public class A03_CircleArrayQueueArray {
    public static void main(String[] args) {
        CircleQueueArray circleQueueArray = new CircleQueueArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("s(show): 显示队列");
        System.out.println("- e(exit): 退出程序");
        System.out.println("- a(add): 添加数据到队列");
        System.out.println("- g(get): 从队列取出数据");
        System.out.println("- h(head): 查看队列头的数据");
        System.out.println("- d(delete): 清空所有数据");
        while (loop) {
            System.out.println("请继续操作...");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    circleQueueArray.queryAll();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleQueueArray.addData(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueueArray.getQueue();
                        System.out.printf("取出的数据是%d\n: ", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueueArray.headQueue();
                        System.out.printf("队列的头的数据是%d\n: ", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                    try {
                        circleQueueArray.clearAll();
                        System.out.println("数据已清空..");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}

/**
 * 创建数组模拟队列
 */
class CircleQueueArray {
    // 数组的最大容量
    private int maxSize;
    // 头部 最前方
    private int front;
    // 尾部 加入数据时指向的最后
    private int rear;
    // 存放的数据, 模拟队列
    private int[] arr;

    // 创建构造函数
    public CircleQueueArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
    }

    // 判断是否为空
    public boolean ifEmpty() {
        return rear == front;
    }

    // 判断是否满了
    public boolean ifFull() {
        return (rear + 1) % maxSize == front;
    }

    // 添加数据
    public void addData(int x) {
        if (ifFull()) {
            System.out.println("队列已满，不能加入数据...");
            return;
        }
        arr[rear] = x;
        rear = (rear + 1) % maxSize;
    }

    // 获取数据
    public int getQueue() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法加入数据...");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 获取头部数据
    public int headQueue() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法查看数据...");
        }
        return arr[front];

    }

    // 显示队列的所有数据
    public void queryAll() {
        if (ifEmpty()) {
            System.out.println("队列是空的, 无法查看数据...");
            return;
        }

        for (int i = front; i < front + number(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 获取有效个数
    public int number() {
        return (rear + maxSize - front) % maxSize;
    }

    // 清空所有数据
    public void clearAll() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法清楚数据");
        }
        rear = front;
    }

}
