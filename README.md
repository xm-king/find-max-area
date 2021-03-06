# 需求
寻找数据最大的连续区域
给定一个二维数组array[M][N]，二维数组每个元素的取值为0或1，0表示白色，1表示黑色，现在需要实现一个查找最大黑色区域的功能，元素位置相邻可以连接成为一个区域，例如array[0][1]和array[0][2]相邻，array[0][1]和array[1][1]相邻，则可以连接成为一个大小为3个元素的区域。请实现一个方法，如参为上述的数组，出参为最大黑色区域的大小（包含的元素个数）。

# 解决思路
使用递归算法，首先创建一个二维的的数组，用于数据。
利用广度优先+深度搜索算法，从二维数组的第一个起点开始遍历，遇到白色节点则跳到下一列上，重新
发起搜索遍历，否则黑色节点，则开始按照从左到右(广度)，从上到下(深度)的顺序进行搜索遍历，
递归退出的条件是到达数组的边界或者遇到白色节点为止。

# 测试用例
### case 1
##### Input Data
{{1,0,1,1},{0,1,0,1},{0,0,0,1}} 
##### expect Value
4
* * *
### case 2
##### Input Data
{{1,0,1,0,1},{0,1,0,1,1},{0,1,0,1,0}}
##### expect Value
5
