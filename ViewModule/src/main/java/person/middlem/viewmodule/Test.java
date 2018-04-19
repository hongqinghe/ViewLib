package person.middlem.viewmodule;

import java.util.Stack;

/***********************************************
 * <P> desc:
 * <P> Author: gongTong
 * <P> Date: 2018/4/19 15:53
 ***********************************************/

public class Test {
    public  static void main(String []args){
        Stack<String> strings=new Stack<>();
        strings.push("1");
        strings.push("11");
        strings.push("12");
        strings.push("13");
        strings.push("14");
        String peek = strings.peek();
        System.out.println("栈顶元素为" + peek);
        int size = strings.size();
        System.out.println("入栈大小" +size);
        String pop = strings.pop();
        System.out.println("移除的元素为 " + pop);
        int search = strings.search("14");
        System.out.println("元素位置"+search);
//        for (int i = size; i >  1; i--) {
//        }
//        strings.remove(-1);
//        strings.remove(-2);
//        strings.remove(-3);
        String s = strings.firstElement();
        String peek2 = strings.peek();
        System.out.println("最后的栈顶元素为" + peek2);
    }
}
