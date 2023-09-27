import java.io.*;


public class CSVFile {

	public static void main(String[] args) {
		String filePath = CSVFile.class.getClassLoader().getResource("data.txt").getPath();
		printCSVFile(filePath);
	}

	public static void printCSVFile(String filePath){
		try {
			FileReader reader = new FileReader(filePath);
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			String[] list;
			System.out.println("Last    First    Salary");
			while ((line = br.readLine()) != null){
				list = line.split(",");
				for (int i = 0; i < list.length; i++) {
					if (i < list.length - 1){
						System.out.printf("%s    ", list[i]);
					} else
						System.out.println(list[i]);
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		//add code here
	}


}
