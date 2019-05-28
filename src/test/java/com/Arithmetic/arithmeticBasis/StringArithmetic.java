package com.Arithmetic.arithmeticBasis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lyh on 2019/5/25
 */
public class StringArithmetic {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 线性的时间复杂度
     * 快排
     * 0左1右 交换次数
     * 00...0001...0111...1
     */
    @Test
    public void StringArithmetic1(){
        String str = "010101";
        char[] strArray = str.toCharArray();
        int len = strArray.length;
        int answer = 0;//交换次数
        for (int i=0,j=len-1;i<j;++i,--j){
            for (;(i<j)&&(strArray[i]=='0');++i);
            for (;(j>i)&&(strArray[j]=='1');--j);
            if(i<j){
                ++answer;
            }
        }
        logger.info("交换次数:"+answer);
    }

    /**
     * 删除一个字符串所有的a，并复制所有的b 字符串足够大(返回用同一个字符串，不需要另开辟空间)
     *
     */
    @Test
    public void StringArithmetic2(){
        String str = "abcbacbacabcabcacbacaabcabcabcabababbababcabccccbccc";
        char[] strChars = str.toCharArray();
        //删除a,可以利用原来字符串的空间
        int n=0,numb=0;
        for (int i=0;i<strChars.length-1;++i){
            if(strChars[i]!='a'){
                strChars[n++] = strChars[i];
            }
            if(strChars[i]=='b'){
                numb++;
            }
        }
        strChars[n]='0';
        logger.info(numb+"strChars="+new String(strChars));
        //在复制所有的b，注意字符串的长度
        //先得到b的长度，需要复制长度
        //倒着复制
        int newLength =  strChars.length + numb;
        char[] resultArray=new char[newLength];//因为数组长度固定 创建一个更长的数组
        //数组复制
        //src: 源数组
        //srcPos: 从源数组复制数据的起始位置
        //dest: 目标数组
        //destPos: 复制到目标数组的起始位置
        //length: 复制的长度
        System.arraycopy(strChars, 0, resultArray, 0, strChars.length-1);
        resultArray[newLength]=0;
        for (int i=newLength-1,j=n-1;j>=0;--j){
            resultArray[i--]=resultArray[j];
            if(resultArray[j]=='b'){
                resultArray[i--]='b';
            }
        }

        logger.info(resultArray.toString());


    }





















}
