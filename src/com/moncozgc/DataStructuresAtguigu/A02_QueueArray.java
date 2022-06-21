package com.moncozgc.DataStructuresAtguigu;

import java.util.Scanner;

/**
 * 使用数组模拟队列
 *
 * Created by MoncozGC on 2022/6/20
 */
public class A02_QueueArray {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(3);
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
                    queueArray.queryAll();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queueArray.addData(value);
                    break;
                case 'g':
                    try {
                        int res = queueArray.getQueue();
                        System.out.printf("取出的数据是%d\n: ", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queueArray.headQueue();
                        System.out.printf("队列的头的数据是%d\n: ", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                    try {
                        queueArray.clearAll();
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
class QueueArray {
    // 数组的最大容量
    private int maxSize;
    // 头部 最前方
    private int front;
    // 尾部 加入数据时指向的最后
    private int rear;
    // 存放的数据, 模拟队列
    private int[] arr;

    // 创建构造函数
    public QueueArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }

    // 判断是否为空
    public boolean ifEmpty() {
        return rear == front;
    }

    // 判断是否满了
    public boolean ifFull() {
        return rear == maxSize - 1;
    }

    // 添加数据
    public void addData(int x) {
        if (ifFull()) {
            System.out.println("队列已满, 无法添加数据....");
        }
        // 尾部指向加一
        rear++;
        // 并且在该位置存放数据
        arr[rear] = x;
    }

    // 获取数据
    public int getQueue() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法加入数据...");
        }
        front++;
        return arr[front];
    }

    public int headQueue() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法查看数据...");
        }
        return arr[front + 1];

    }

    // 显示队列的所有数据
    public void queryAll() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法查看所有数据...");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    // 清空所有数据
    public void clearAll() {
        if (ifEmpty()) {
            throw new RuntimeException("队列是空的, 无法清楚数据");
        }
        rear = front;
    }

}