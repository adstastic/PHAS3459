package module5;

import java.util.Arrays;

public class TestSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [][] e1 = {{1,2,3},{4,5,6},{7,8,9}};
		SquareMatrix sm = new SquareMatrix(e1);
		System.out.println(sm);
		System.out.println(SquareMatrix.unitMatrix(3));
		
		
	}

}
