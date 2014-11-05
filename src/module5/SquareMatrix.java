package module5;
import java.util.*;

public class SquareMatrix {
	int numRows;
	double[][] matrix;
	
	public SquareMatrix(double[][] elementsI) throws IllegalArgumentException {	
		numRows = elementsI.length;
		for(int i=0; i<numRows; i++) {
			if (elementsI[i].length ==  numRows) {}
			else { throw new IllegalArgumentException("Input is not square matrix.");
			}
		}
		matrix = elementsI;
	}
	
	public static SquareMatrix unitMatrix(int size) {
		double[][] elements = new double[size][size];
	    	for(int i = 0; i < size; i++) 
	    		for(int j = 0; j < size; j++) 
	    			elements[i][j] = (i == j) ? 1 : 0;
		SquareMatrix I = new SquareMatrix(elements);
		return I;
	}
	
	public String toString() {
		StringBuilder sbMatrix = new StringBuilder();
		for (double[] row : matrix) {
			sbMatrix.append(Arrays.toString(row)+'\n');
		}
		return sbMatrix.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(matrix);
		result = prime * result + numRows;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		if (numRows != other.numRows)
			return false;
		return true;
	}
	
	
}
