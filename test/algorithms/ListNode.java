package algorithms;

class ListNodeTestFun {        //类名 ：Java类就是一种自定义的数据结构
    int val;            //数据 ：节点数据 
    ListNodeTestFun next;      //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似

    ListNodeTestFun(int val) {  //构造方法 ：构造方法和类名相同
        this.val = val;   //把接收的参数赋值给当前类的val变量
    }
}

class ListNodeTest {
    public static void main(String[] args) {

        ListNodeTestFun nodeSta = new ListNodeTestFun(0);          //创建首节点
        ListNodeTestFun nextNode;                           //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                            //指向首节点

        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNodeTestFun node = new ListNodeTestFun(i);         //生成新的节点
            nextNode.next = node;                      //把心节点连起来
            nextNode = nextNode.next;                  //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = nodeSta;                            //重新赋值让它指向首节点
        print(nextNode);                             //打印输出
        System.out.println("--");

        //插入节点
        while (nextNode != null) {
            if (nextNode.val == 5) {
                ListNodeTestFun newnode = new ListNodeTestFun(99);  //生成新的节点
                ListNodeTestFun node = nextNode.next;          //先保存下一个节点
                nextNode.next = newnode;                //插入新节点
                newnode.next = node;                    //新节点的下一个节点指向 之前保存的节点
            }
            nextNode = nextNode.next;
        }//循环完成之后 nextNode指向最后一个节点
        nextNode = nodeSta;                            //重新赋值让它指向首节点
        print(nextNode);                             //打印输出

    }

    static void print(ListNodeTestFun listNoed) {
        //创建链表节点
        while (listNoed != null) {
            System.out.println("节点:" + listNoed.val);
            listNoed = listNoed.next;
        }
    }
}