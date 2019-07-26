package com.java8.java8ActualCombat.TestDisperse;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @author lyh on 2019/7/17
 */
public class FilUseMethod {

    @Test
    public void isHiddenTest(){
        //Java8 打印隐藏的文件
        File[] files = new File(".").listFiles(File::isHidden);

        //Java7
        File[] files1 = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        Arrays.asList(files).stream()
                .forEach(x->System.out.println(x.getPath()));
        System.out.println();
        Arrays.asList(files1).stream()
                .forEach(x->System.out.println(x.getPath()));

    }


}
