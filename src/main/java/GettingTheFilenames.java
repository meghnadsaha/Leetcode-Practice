import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GettingTheFilenames {

	private static final String NEWLINE = "\n";

	private static final String payLoadStructurePrefix = "{href: " + 1 + ",content: ";// F:\\Movie\\The.Shape.of.Water.2017.DVDSCR.800MB.MkvCage.mkv"}
																						// "";
	private static final String payLoadStructureSuffix = "\"},";

	public static void listFilesAndFilesSubDirectories(String directoryName) throws IOException {

		StringBuilder fileDirectory = new StringBuilder();
		ArrayList<String> fileDirectoryList = new ArrayList<String>();

		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		String result="";
		for (File file : fList) {

			FileWriter myWriter = null;
			try {
				myWriter = new FileWriter("C:\\Users\\Admin\\3D Objects\\src\\paths.txt");
				if ((file.isFile())) {

					if(file.getName().contains(".mp4")||file.getName().contains(".mkv")){
						System.out.println("{href:  \""
								+ file.getAbsolutePath().length()*Math.random()
								+ "\" ,content: \"" + (file.getAbsolutePath()).replace("\\", "\\\\")
								+ payLoadStructureSuffix);
						 result = "{href:  \"" + file.getName() + "\" ,content: \""
								+ (file.getAbsolutePath()).replace("\\", "\\\\") + payLoadStructureSuffix + NEWLINE;
						fileDirectoryList.add(result);
					}
				}

				else if (file.isDirectory()) {
					listFilesAndFilesSubDirectories(file.getAbsolutePath());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {
		String directoryName = "C:\\Users\\Admin\\Downloads\\Dextar\\";
		
		listFilesAndFilesSubDirectories(directoryName);

	}

}
