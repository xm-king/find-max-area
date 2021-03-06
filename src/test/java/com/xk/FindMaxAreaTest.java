package com.xk;

import org.junit.Assert;
import org.junit.Test;

import static com.xk.FindMaxArea.findMaxArea;

/**
 * 查找最大的相邻区域个数单元测试类
 * @author tianming.xm@gmail.com
 * @since 2019/12/26
 */
public class FindMaxAreaTest {

    @Test
    public void findMaxAreaTestCase1(){
        int[][] data = {{1,0,1,1},{0,1,0,1},{0,0,0,1}};
        int sum = findMaxArea(data,0,0);
        Assert.assertEquals(sum,4);
    }

    @Test
    public void findMaxAreaTestCase2(){
        int[][] data = {{1,0,1,0,1},{0,1,0,1,1},{0,1,0,1,0}};
        int sum = findMaxArea(data,0,0);
        Assert.assertEquals(sum,5);
    }
}
