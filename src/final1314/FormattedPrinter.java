package final1314;

import java.util.Arrays;

public class FormattedPrinter {
		protected String dataFormat;
		protected String headerFormat;
		protected String tableRow;
		protected Object[] headers;
		protected char sep;
		protected int dp;
		
		public static void main(String[] args) {
			Object[] headers = {"Hello   ","World   "};
			Object[] d1 = {"Hello123", 12.2123};
			int dp = 0;
			char sep = '|';
			FormattedPrinter fp = new FormattedPrinter(headers, d1, dp, sep);
			fp.printHeaders();
			fp.printData(d1);
			
		}
		
		public FormattedPrinter (Object[] headers, Object[] data, int dp, char sep) {
			if (headers.length != data.length) {
				throw new IllegalArgumentException("Column headers and number of data elements are not the same!");
			} else if (dp < 0) {
				throw new IllegalArgumentException("Number of decimal places cannot be negative!");
			} else {
				this.sep = sep;
				this.dp = dp;
				format(headers, data); 
			}
		}
		
		public void format(Object[] headers, Object[] data) {
			StringBuilder dataFormat = new StringBuilder(sep+" ");
			StringBuilder headerFormat = new StringBuilder(sep+" ");
			StringBuilder table = new StringBuilder("+");
			this.headers = headers;
			Double d = 0.0;
			for (int i=0; i<data.length; i++) {
				int length = headers[i].toString().length();
				headerFormat.append("%-"+length);
				headerFormat.append("s "+sep+" ");
				dataFormat.append("%-"+length);
				System.out.println(data[i].getClass());
				if (data[i].getClass() == d.getClass()) {
					if (dp > 0) {
						dataFormat.append("."+dp+"f "+sep+" ");
						for (int j=0; j<length+dp; j++) {
							table.append("-");
						}
					} else if (dp == 0) {
						dataFormat.append("s "+sep+" ");
						for (int j=0; j<length+2; j++) {
							table.append("-");
						}
					}
				} else {
					for (int j=0; j<length+2; j++) {
						table.append("-");
					}
					dataFormat.append("s "+sep+" ");
				}
				table.append("+");
			}
			headerFormat.append("%n");
			dataFormat.append("%n");
			this.headerFormat = headerFormat.toString();
			this.dataFormat = dataFormat.toString();
			tableRow = table.toString()+"\n";
		}
		
		public void advancedFormat(Object[] headers, Object[] data, int dp) {
			StringBuilder dataFormat = new StringBuilder("| ");
			StringBuilder headerFormat = new StringBuilder("| ");
			StringBuilder table = new StringBuilder("+");
			this.headers = headers;
			Double d = 0.0;
			for (int i=0; i<data.length; i++) {
				int length = (data[i].toString().length() < headers[i].toString().length() ? headers[i].toString().length() : data[i].toString().length());
				headerFormat.append("%-"+length);
				headerFormat.append("s | ");
				dataFormat.append("%-"+length);
				System.out.println(data[i].getClass());
				if (data[i].getClass() == d.getClass()) {
					dataFormat.append("."+dp+"f | ");
					for (int j=0; j<length+dp+1; j++) {
						table.append("-");
					}
				} else {
					for (int j=0; j<length+2; j++) {
						table.append("-");
					}
					dataFormat.append("s | ");
				}
				table.append("+");
			}
			headerFormat.append("%n");
			dataFormat.append("%n");
			this.headerFormat = headerFormat.toString();
			this.dataFormat = dataFormat.toString();
			tableRow = table.toString()+"\n";
		}
			
		public void printHeaders() {
			System.out.format(tableRow);
			System.out.printf(headerFormat, headers);
			System.out.format(tableRow);
		}
		
		public void printData(Object[] data) {
			System.out.printf(dataFormat, data);
		}
		
		public void endTable() {
			System.out.format(tableRow);
		}
		
}
	
	
		
		
	

