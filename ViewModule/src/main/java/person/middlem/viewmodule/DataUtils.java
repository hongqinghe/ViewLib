package person.middlem.viewmodule;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.listview.StringData;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/23 09:48
 ***********************************************/

public class DataUtils {
    static int length;
    static String scr;
    public static List<StringData> getStringList(int page) {
        if (page==1){
            length=20;
            scr="first";
        }else {
            length+=10;
            scr="more";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<StringData> stringList = new ArrayList<>();
        for (int i=0;i<=length;i++){
            if (i==1||i==3||i==5){
                StringData stringData=new StringData();
                stringData.setType("1");
                stringData.setTitle("title1"+scr);
                stringData.setContent("content1"+scr);
                stringList.add(stringData);
            } else {
                StringData stringData=new StringData();
                stringData.setType("2");
                stringData.setTitle("title2"+scr);
                stringData.setContent("content2"+scr);
                stringList.add(stringData);
            }
        }
        return stringList;
    }

}
