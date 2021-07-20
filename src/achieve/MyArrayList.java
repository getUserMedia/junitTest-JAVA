package achieve;

public class MyArrayList<E> {
	/*ArrayList�ײ���һ��Ԫ�����飬�������洢����*/
    private Object[] elementData; //�����洢���ǵ����ݵ�

    /*���������ж���Ԫ��---�൱�ڼ�����*/
    private int size;

    /*����һ��������Ϊ���鳤�ȵ�Ĭ�ϳ���*/
    private static final int DEFAULT_CAPACITY = 10;

    /*����һ�������������������ʱ�����Ĭ�ϳ���*/
    public MyArrayList(){
        /*Ϊ�����½�����*/
        elementData = new Object[DEFAULT_CAPACITY]; //���½���Object����ֵ��Object������
        /*
        ʲô��������ȥ��ʱ��Ĭ�Ͼ���elementData
         */
    }
    
    /*�ڶ�����������֮ǰһ��---������,��װ����*/
    public MyArrayList(int capacity){
        /*���鳤��=�������ֵ---�������Լ���һ��С����*/
        elementData = new Object[capacity];
    }

    /*��add����������ݲ���*/
    public void add(E element){
        /*��size����==elementData��ʱ�����Ҫ������---�ж�*/
        if (size == elementData.length){
            /*���ݵķ���---����һ�����������*/
            //����Դ�뵱�е����ݷ���
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)]; //��������ʱ��������ȼ����⣬������λ�㷨�������������JVM������ǰ��ļӷ�
            //��ԭ���������ֵ�������µ����ݵ�����
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            /*
            arraycopy�����Ĳ�����
            ԭ����
            ��ʼ�����������±�
            ������
            ���������������ʼλ�õ������±�
            �����ĳ���
             */
            /*�ٽ�������������ݸ�ֵ��ԭ��������Ԫ�ش���ֵ����JVM���յ��������������---����ָ���µ��������*/
            elementData = newArray;
        }
        /*
        ������ӵĴ��������⣬ͨ��Debug����
         */
        elementData[size++] = element; //�����ֵ������Ԫ����������
    }

    /*ϣ������Ľ�����ӻ�����дtoString����*/
    @Override
    public String toString(){
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        //��ӡ������[a,b,c]����ʽ
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');

        return sb.toString();
    }

    /*��main��������������*/
    public static void main(String[] args) {
        /*���÷�����������*/
//        LcfArrayList03<String> s1 = new LcfArrayList03<>(20); //���õ�ʱ��ͻᴴ��һ��Ĭ�����飬�������ֵ����Ĭ�ϵ�10
    	MyArrayList s1 = new MyArrayList();

        for (int i = 0; i < 50; i++){
            s1.add("add" + i);
        }
        /*
        ������ӻᱨ����Ϊ�ײ����鳤����10
        ���ʱ����Ҫ������ݲ���
        ˼·��
        �޸�add����---��Ϊͨ��add�취ȥ��ӵ�
        ���⣺
        ʲôʱ�����ݣ�---size��0������ĳ�����10����size >= elementData��ʱ���Ҫ��������---��if�ж�
        ��ô���ݣ�---����һ�����������---ע���������Ĵ�С---���������Ժ�Ҫ�������ݸ��µ�����(ʹ������ĵײ㺯��arraycopy)
         */

        System.out.println(s1); //���û����дtoString�����Ļ���ӡ����������+��ַ��hashֵ
    }
}
