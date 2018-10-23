package com.javabase.g6.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huixiaolv on 19/10/2018.
 */
public class RegTest {

    static public final String poem = "";

    public static void demo1(){

        String line = "This order was placed for QT3000! O00K?";
        String pattern = "(.*)(\\d+)(.*)";

        Matcher matcher = Pattern.compile(pattern).matcher(line);
        if(matcher.find()){
            int len = matcher.groupCount();
            System.out.println("len:"+len);
            for(int i=0;i<len;i++){
                System.out.println(matcher.group(i));
            }
        }
    }

    public static void test(){
        Pattern pattern = Pattern.compile("\\d{3,5}");
        String charSequence = "123-34345-234-00";
        Matcher matcher = pattern.matcher(charSequence);

        //虽然匹配失败，但由于charSequence里面的"123"和pattern是匹配的,所以下次的匹配从位置4开始
        System.out.println(matcher.matches());
        //测试匹配位置
        matcher.find();
        System.out.println(matcher.start());

        //使用reset方法重置匹配位置
        matcher.reset();

        //第一次find匹配以及匹配的目标和匹配的起始位置
        System.out.println(matcher.find());
        System.out.println(matcher.group()+" - "+matcher.start());
        //第二次find匹配以及匹配的目标和匹配的起始位置
        System.out.println(matcher.find());
        System.out.println(matcher.group()+" - "+matcher.start());

        //第一次lookingAt匹配以及匹配的目标和匹配的起始位置
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.group()+" - "+matcher.start());

        //第二次lookingAt匹配以及匹配的目标和匹配的起始位置
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.group()+" - "+matcher.start());
    }

    public static void regMatch(String line,String reg){
        Matcher matcher = Pattern.compile(reg).matcher(line);
        if(matcher.find()){
            System.out.println("find:true");
            int i = matcher.groupCount();
            System.out.println("groupCount:"+i);
            for (int j = 0; j <i ; j++) {
                System.out.println(matcher.group(j));
            }
        }
        System.out.println("isMatch:"+matcher.matches());
    }



    public static void main(String[] args){
//        demo1();
//        regMatch("Windows 2003","Windows\\s+(.*)");
//        System.out.println("----------");
//        regMatch("Centos","Cento");
        regMatch("\\d{3,5}","123-34345-234-00");
        System.out.println("----------");
        regMatch("foood oood","o{2,3}");
        System.out.println("----------");
        regMatch("Solaris 9.0 H3C","Solaris\\s*(.*)\\s");
        System.out.println("----------");
        regMatch("Sun SunOS 4.1.3 (SPARC)","Sun SunOS\\s(.*)\\s");
        System.out.println("----------");
        regMatch("HP-UX B.11.00 - B.11.31 HUAWEI ","HP-UX\\s*(.*)");
        Matcher matcher = Pattern.compile("^[1-9]\\d{4,10}$").matcher("153806178222222222");
        if(matcher.find()){
            for (int i=0;i<matcher.groupCount();i++)
                System.out.println("......"+matcher.group(i));
        }
        System.out.println(matcher.matches());
        System.out.println("----------");
        demo1();
//        test();
    }

}
