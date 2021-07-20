package achieve;

public class MyArrayList<E> {
	/*ArrayList底层有一个元素数组，用它来存储内容*/
    private Object[] elementData; //用来存储我们的内容的

    /*数组里面有多少元素---相当于计数器*/
    private int size;

    /*定义一个常量作为数组长度的默认长度*/
    private static final int DEFAULT_CAPACITY = 10;

    /*定义一个构造器，创建数组的时候给它默认长度*/
    public MyArrayList(){
        /*为数组新建对象*/
        elementData = new Object[DEFAULT_CAPACITY]; //将新建的Object对象赋值给Object数组名
        /*
        什么都不加上去的时候默认就是elementData
         */
    }
    
    /*第二个构造器像之前一样---传数字,封装方法*/
    public MyArrayList(int capacity){
        /*数组长度=传入的数值---定义了自己的一个小内容*/
        elementData = new Object[capacity];
    }

    /*给add方法添加扩容操作*/
    public void add(E element){
        /*当size长度==elementData的时候就需要扩容了---判断*/
        if (size == elementData.length){
            /*扩容的方法---定义一个更大的数组*/
            //采用源码当中的扩容方法
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)]; //这里计算的时候会有优先级问题，先算移位算法。如果不括起来JVM会先算前面的加法
            //将原来的数组的值拷贝给新的扩容的数组
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            /*
            arraycopy方法的参数：
            原数组
            开始拷贝的索引下标
            新数组
            拷贝到新数组的起始位置的索引下标
            拷贝的长度
             */
            /*再将老数组对象内容赋值给原来的数组元素代替值，让JVM回收掉老数组对象内容---重新指向新的数组对象*/
            elementData = newArray;
        }
        /*
        重新添加的代码有问题，通过Debug调试
         */
        elementData[size++] = element; //传入的值赋给新元素索引自增
    }

    /*希望输出的结果可视化，重写toString方法*/
    @Override
    public String toString(){
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        //打印出类似[a,b,c]的形式
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');

        return sb.toString();
    }

    /*在main方法当中做测试*/
    public static void main(String[] args) {
        /*调用方法创建对象*/
//        LcfArrayList03<String> s1 = new LcfArrayList03<>(20); //调用的时候就会创建一个默认数组，如果不传值就是默认的10
    	MyArrayList s1 = new MyArrayList();

        for (int i = 0; i < 50; i++){
            s1.add("add" + i);
        }
        /*
        这样添加会报错，因为底层数组长度是10
        这个时候需要添加扩容操作
        思路：
        修改add方法---因为通过add办法去添加的
        问题：
        什么时候扩容？---size是0，数组的长度是10，当size >= elementData的时候就要加扩容了---加if判断
        怎么扩容？---定义一个更大的数组---注意控制数组的大小---扩容完了以后要拷贝内容给新的数组(使用数组的底层函数arraycopy)
         */

        System.out.println(s1); //如果没有重写toString方法的话打印出的是类名+地址的hash值
    }
}
