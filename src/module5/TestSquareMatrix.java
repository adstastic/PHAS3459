package module5;
import java.util.Arrays;
//Written by Aditya Mukherjee for PHAS 3459 Module 5

// Tests SquareMatrix class
public class TestSquareMatrix {

	public static void main(String[] args) {
		// Initialise SquareMatricies
		SquareMatrix A = new SquareMatrix(new double[][] {{1,0,2},{3,1,0},{-3,0,-1}});
		SquareMatrix B = new SquareMatrix(new double[][] {{0,0,1},{0,1,0},{-1,0,1}});
		SquareMatrix C = new SquareMatrix(new double[][] {{4,3},{3,2}});
		SquareMatrix D = new SquareMatrix(new double[][] {{-2,3},{3,-4}});
		
		// Perform matrix arithmetic
		try {
			System.out.println("A+B = \n"+A.add(B));
			System.out.println("A-B = \n"+A.subtract(B));
			
			SquareMatrix AB = A.multiply(B);
			SquareMatrix BA = B.multiply(A);
			System.out.println("AB = \n"+AB);
			System.out.println("BA = \n"+BA);
			
			System.out.println("[A,B] = \n"+SquareMatrix.subtract(AB,BA));
			
			SquareMatrix CD = C.multiply(D);
			System.out.println("CD = \n"+CD);
			// unitMatrix(2) gives 2x2 identity matrix
			System.out.println("CD = I: "+SquareMatrix.unitMatrix(2).equals(CD));
		}
		catch (Exception e) {
			System.out.println(e.getMessage()); e.printStackTrace();
		}
	}

}
