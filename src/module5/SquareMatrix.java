package module5;
import java.util.*;
// Written by Aditya Mukherjee for PHAS 3459 Module 5

// SquareMatrix class stores elements of 2D array and performs matrix arithmetic 
public class SquareMatrix {
	// Instance variables 
	private int size;
	private double[][] matrix;
	
	/* Constructor */ 
	public SquareMatrix(double[][] elements) throws IllegalArgumentException {	
		// Number of rows in matrix
		size = elements.length;
		// Check if number of columns = number of rows
		for(int i=0; i<getSize(); i++) {
			// Set matrix elements to input elements
			if (elements[i].length ==  getSize()) { matrix = elements; }
			// Throw error if not square matrix
			else { 
				throw new IllegalArgumentException("Input is not square matrix.");
			} 
		}
	}
	
	/* Getters */
	public int getSize() {
		return size;
	}
	
	public double[][] getMatrix() {
		return matrix;
	}

	/* Methods */
	
	// Returns identity matrix of specified size
	public static SquareMatrix unitMatrix(int size) {
		// New square double array of specified size
		double[][] elements = new double[size][size];
			// Iterate through all rows
	    	for(int i = 0; i < size; i++)
	    		// Iterate through all columns
	    		for(int j = 0; j < size; j++) 
	    			// For elements with same index in both dimensions, set value to 1
	    			elements[i][j] = (i == j) ? 1 : 0;
	    // New SquareMatrix from double array
		SquareMatrix I = new SquareMatrix(elements);
		return I;
	}
		
	// Add two SquareMatricies 
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws IllegalArgumentException {
		// Check if same size
		if (sm1.getSize() != sm2.getSize()) {
			throw new IllegalArgumentException("Inputs are not of same size.");
		} 
		else {
			int size = sm1.getSize();
			// New square double array of same size as inputs
			double[][] added = new double[size][size];
			// Iterate through all elements, add elements with same index in both dimensions
			for(int i=0; i<size ; i++) 
				for(int j=0; j<size; j++) {
					added[i][j] = sm1.matrix[i][j] + sm2.matrix[i][j]; 
    		}
			return new SquareMatrix(added);
		}
	}
	
	// Subtract two SquareMatricies
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws IllegalArgumentException {
		// Check if same size
		if (sm1.getSize() != sm2.getSize()) {
			throw new IllegalArgumentException("Inputs are not of same size.");
		} 
		else {
			int size = sm1.getSize();
			double[][] subtracted = new double[size][size];
			// Iterate through all elements, subtract elements with same index in both dimensions
			for(int i=0; i<size ; i++) 
				for(int j=0; j<size; j++) {
					subtracted[i][j] = sm1.matrix[i][j] - sm2.matrix[i][j]; 
    		}
			return new SquareMatrix(subtracted);
		}
	}
	
	// Multiply two SquareMatricies
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws IllegalArgumentException {
		// Check if same size
		if (sm1.getSize() != sm2.getSize()) {
			throw new IllegalArgumentException("Inputs are not of same size.");
		} 
		else {
			int size = sm1.getSize();
			double[][] multiplied = new double[size][size];
			// Perform matrix multiplication where P{i,j} = Sum(A{i,k}*B{k,j}) where i,j,k denote position of element in 2D matrix
			for(int i=0; i<size ; i++) 
				for(int j=0; j<size; j++) 
					for(int k=0; k<size; k++) {
						// Add all elements in row of sm1 multiplied by corresponding elements in column of sm2
						multiplied[i][j] += sm1.matrix[i][k]*sm2.matrix[k][j]; 
    		}
			return new SquareMatrix(multiplied);
		}
	}
	
	/* Non-static versions of arithmetic methods */
	
	SquareMatrix add(SquareMatrix sm) throws Exception {
        return SquareMatrix.add(this, sm);
    }
	
	SquareMatrix multiply(SquareMatrix sm) throws Exception {
        return SquareMatrix.multiply(this, sm);
    }
	
    SquareMatrix subtract(SquareMatrix sm) throws Exception {
        return SquareMatrix.subtract(this, sm);
    }
	
    /* Utility methods */
    
    // Allows printing of matrix as string
	public String toString() {
		StringBuilder sbMatrix = new StringBuilder();
		// Get each row of matrix as 1D double array, append to StringBuilder separated by new line
		for (double[] row : matrix) {
			sbMatrix.append(Arrays.toString(row)+'\n');
		}
		return sbMatrix.toString();
	}

	/* Eclipse auto generated methods */
	
	// Override annotation to show these methods override existing ones
	@Override
	// Returns value based on memory address of object
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(matrix);
		result = prime * result + getSize();
		return result;
	}

	@Override
	//  Checks if two SquareMatricies are equal	
	public boolean equals(Object obj) {
		// Check if argument is object having equals method called
		if (this == obj)
			return true;
		// Check if argument is null
		if (obj == null)
			return false;
		// Check if both objects being compared belong to SquareMatrix class
		if (getClass() != obj.getClass())
			return false;
		// Compare all member variables of both SquareMatricies
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		if (getSize() != other.getSize())
			return false;
		return true;
	}
	
	
}
