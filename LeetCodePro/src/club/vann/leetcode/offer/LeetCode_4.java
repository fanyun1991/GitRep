package club.vann.leetcode.offer;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：二维数组中的查找
 * <p>
 * 描述：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * <p>
 * 示例:
 * 
 * 现有矩阵 matrix 如下：
 * 
 * [ 
 *  [1, 4, 7, 11, 15], 
 *  [2, 5, 8, 12, 19], 
 *  [3, 6, 9, 16, 22], 
 *  [10, 13, 14, 17,24], 
 *  [18, 21, 23, 26, 30] 
 * ] 
 * 
 * 给定 target = 5，返回 true。
 * 
 * 给定 target = 20，返回 false。
 * 
 * 
 * 限制：
 * 
 * 0 <= n <= 1000
 * 
 * 0 <= m <= 1000
 * 
 * 通过次数8,621提交次数21,033
 * 
 * @author fanyu
 *
 */
public class LeetCode_4 {

	public static void main(String[] args) {
		LeetCode_4 leetCode = new LeetCode_4();
		boolean result = false;
		
//		int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17,24}, {18, 21, 23, 26, 30}};
//		result = leetCode.findNumberIn2DArray(matrix, 5);
//		System.out.println("Result:[true] : " + result);
		
//		int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17,24}, {18, 21, 23, 26, 30}};
//		result = leetCode.findNumberIn2DArray(matrix, 20);
//		System.out.println("Result:[false] : " + result);
//		
//		
//		int[][] matrix1 = {{-1, 3}};
//		result = leetCode.findNumberIn2DArray(matrix1, 3);
//		System.out.println("Result:[true] : " + result);
//		
//		int[][] matrix2 = {{-1, 3, 4}};
//		result = leetCode.findNumberIn2DArray(matrix2, 4);
//		System.out.println("Result:[true] : " + result);
//		
//		int[][] matrix3 = {{-1, 4, 5}};
//		result = leetCode.findNumberIn2DArray(matrix3, 3);
//		System.out.println("Result:[false] : " + result);
//		
//		int[][] matrix4 = {{}};
//		result = leetCode.findNumberIn2DArray(matrix4, 1);
//		System.out.println("Result:[false] : " + result);
		
//		int[][] matrix5 = {{-1}, {1}, {3}};
//		result = leetCode.findNumberIn2DArray(matrix5, 3);
//		System.out.println("Result:[true] : " + result);
		
//		int[][] matrix6 = {{1,4}, {2,5}};
//		result = leetCode.findNumberIn2DArray(matrix6, 4);
//		System.out.println("Result:[true] : " + result);
		
		int[][] matrix7 = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
		result = leetCode.findNumberIn2DArray(matrix7, 15);
		System.out.println("Result:[true] : " + result);
		
//		int[][] matrix8 = {{-5}};
//		result = leetCode.findNumberIn2DArray(matrix8, -10);
//		System.out.println("Result:[false] : " + result);
//		
//		int[][] matrix9 = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
//		result = leetCode.findNumberIn2DArray(matrix9, 5);
//		System.out.println("Result:[true] : " + result);
		
	}
	
	/**
	 * 
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	private boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		//解法一：暴力解法，递归方法判断（LeetCode测试后超时）
//		return findNumberIn2DArray1(matrix, target, 0, 0);
		
		return findNumberIn2DArray2(matrix, target, 0, 0, matrix[0].length, matrix.length);
    }
	
	private boolean findNumberIn2DArray1(int[][] matrix, int target, int xIndex, int yIndex) {
		if(xIndex < matrix[0].length && yIndex < matrix.length) {
			int value = matrix[yIndex][xIndex];
			if(value < target) {
				return findNumberIn2DArray1(matrix, target, xIndex+1, yIndex) || findNumberIn2DArray1(matrix, target, xIndex, yIndex+1);
			} else if(value == target) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	/**
	 * 解法二：
	 *       
	 * @param matrix
	 * @param target
	 * @return
	 */
	private boolean findNumberIn2DArray2(int[][] matrix, int target, int x, int y, int max_x, int max_y) {
		int point_x = matrix[0].length-1;
		int point_y = matrix.length-1;
		
		while(x >= 0 && x < max_x && y >= 0 && y < max_y) {
			int value = matrix[y][x];
			
			if(value == target) {
				return true;
			} else if (value < target) {
				if(max_x - x < max_y - y) {
					y ++;
				} else if(max_x - x == max_y - y) {
					x ++;
					y ++;
				} else {
					x ++;
				}
				
			} else {
				return findNumberIn2DArray2(matrix, target, x, 0, point_x, y-1) || findNumberIn2DArray2(matrix, target, 0, y, x-1, point_y);
			}
		}
		
		return false;
	}

}
