package com.xk;

import java.util.stream.IntStream;

/**
 * 查找最大的相邻区域个数
 * @author tianming.xm@gmail.com
 * @since 2019/12/26
 * @version 1.0.0
 */
public class FindMaxArea {

    /**
     * 查找最大的相邻区域个数
     * @param data  二维数据数组
     * @param rowIndex  行索引
     * @param columnIndex 列索引
     * @return 连续数据的最长长度
     */
    public static int findMaxArea(int[][] data,int rowIndex,int columnIndex){
        //根据数组长度，构造一个Int流，并转为并发流，开始遍历数组,筛选最大值
        return IntStream.range(rowIndex,data.length)
                .map(index -> doCompute(data,index,columnIndex))
                .max().orElse(0);
    }

    /**
     * 按照数组从上到下进行遍历计算
     * 尽最大努力进行搜索遍历，类似于二叉树的广度优先搜索
     * @param data 二维数据数组
     * @param rowIndex 行索引
     * @param columnIndex 列索引
     * @return 连续数据的长度
     */
    private static int doCompute(int[][] data,int rowIndex,int columnIndex){

        //初始化计数
        int sum = 0;

        //越界检查,已经到数据的最后一行或者最后一列，结束递归
        if(rowIndex >= data.length || columnIndex >= data[rowIndex].length){
            return 0;
        }

        //当前遍历到的节点是否为黑色节点
        boolean isCurrentBlackNode = (data[rowIndex][columnIndex] == 1);

        //当前节点元素非黑色，从当前行的下一列进行重新递归计算
        if(!isCurrentBlackNode){
            return doCompute(data,rowIndex,columnIndex+1);
        }else{
            sum += 1;
        }

        //当前节点元素为黑色,递归上一列，向上一列递归时，需要检测是否为黑色节点，避免出现左右节点出现死循环的问题
        if( isCurrentBlackNode && (columnIndex-1 > 0 ) && data[rowIndex][columnIndex-1] == 1 ) {
            sum += doCompute(data, rowIndex, columnIndex - 1);
        }

        //当前节点元素为黑色,递归下一列
        if(isCurrentBlackNode && (columnIndex+1 < data[rowIndex].length-1 )){
            sum += doCompute(data,rowIndex,columnIndex+1);
        }

        //下一行元素标记为黑色,递归到下一行
        if(isCurrentBlackNode && (columnIndex+1 < data.length -1)){
            sum += doCompute(data,rowIndex+1,columnIndex);
        }

        return sum;
    }
}
