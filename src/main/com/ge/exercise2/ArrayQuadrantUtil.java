package com.ge.exercise2;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    char[][] data;
    private int quadrantSize;

    public ArrayQuadrantUtil(char[][] data) {
        this.data = data;
        this.quadrantSize = data.length/2;
    }

    public char[] getQuadrantValues(int row, int column) {
    	
    	char[][] twoDimArray= arrayConversion(row,column);
    	char[] quadrantData = new char[data.length];
    	 for (int quadrow = 0, count = 0; quadrow < quadrantSize; quadrow++) {
    	        for (int quadcol = 0; quadcol < twoDimArray[0].length; quadcol++) {
    	        	quadrantData[count] = twoDimArray[quadrow][quadcol];
    	            count++;
    	        }
    	    }
    	
        return quadrantData;
    }
    
    public char[][] arrayConversion(int row, int column)
    {
    	char[][] twoDimArray = new char[quadrantSize][];
    	
    	if(row==1)
    	{
    		if(column==1)
    		{
    		 for (int r = 0; r < quadrantSize; r++) {
    		      twoDimArray[r] = Arrays.copyOfRange(data[row+1 + r], column+1, column +1+quadrantSize);
    		  }
    		}
    		else if(column==0)
    		{
    			for (int r = 0; r < quadrantSize; r++) {
    	   		      twoDimArray[r] = Arrays.copyOfRange(data[row+1 + r], column, column+quadrantSize);
    	   		  }
    		}
    	}
    	else if(row==0)
    	{
    		if(column==1)
    		{
    			 for (int r = 0; r < quadrantSize; r++) {
    	   		      twoDimArray[r] = Arrays.copyOfRange(data[row + r], column+1, column+1+quadrantSize);
    	   		  }
    		}
    		else if(column==0)
    		{
    			 for (int r = 0; r <quadrantSize; r++) {
    	   		      twoDimArray[r] = Arrays.copyOfRange(data[row + r], column, column+quadrantSize);
    	   		  }
    		}
    	}
    	return twoDimArray;
    }
    
    public ArrayQuadrantUtil getQuadrows(int startRow) {
		  char[][] quadArray = new char[quadrantSize][];
		    for(int i=0; i<quadArray.length; i++){
		    	quadArray[i] = data[startRow];
		    }
			return new ArrayQuadrantUtil(quadArray);
	    }
    
    public ArrayQuadrantUtil getQuadCol(int column) {
		  char[][] twoDimArray = new char[data.length][];
		    int x = 0;
		        for (int j = 0; j < twoDimArray.length; j++) {
		            x = j + 1;
		            if(x == column) {
		            	twoDimArray[j]=data[x];
		            }
		    }
			return new ArrayQuadrantUtil(twoDimArray);
	    
	    }
    
    public ArrayQuadrantUtil(int[][] intArray) {
		  String [][] convArray = new String[intArray.length][];
		  for(int i=0; i<intArray.length; i++) {
		    int [] row = intArray[i];
		    convArray[i] = new String[row.length];
		    for(int j=0; j<row.length; j++) {
		    	convArray[i][j] = Integer.toString(row[j]);
		    }
		  }			  
	  }
  
}
