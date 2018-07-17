import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientApplication {
	
	static String server;
	static String client;
	static String fileName;
	
	public static void main(String args[]){
		
		try {
			
			ServerOperationsInterface stub =  (ServerOperationsInterface) Naming.lookup("rmi://localhost:5500/remote");
			
			if(Integer.parseInt(args[0]) == 1){
				server = args[1];
				client = args[2];
				fileName = args[3];
				
				String totalFilePath = client+"\\"+fileName;
				
				String totalServerPath = server+"\\"+fileName;
				
				File file = new File(totalFilePath);
				int len = (int) file.length();
				byte[] data = new byte[len];
				@SuppressWarnings("resource")
				FileInputStream fin = new FileInputStream(file);
				System.out.println("File is uploading to server.....");
				fin.read(data,0,len);
				stub.uploadFiletoServer(data, totalServerPath);
                                System.out.println("File is uploaded to the server");
			}
			
			if(Integer.parseInt(args[0]) == 2){
				server = args[1];
				client = args[2];
				fileName = args[3];
				
				String totalFilePath = server+"\\"+fileName;
				
				String totalClientPath = client+"\\"+fileName;
				
				//System.out.println(totalFilePath);
				
				byte[] data = stub.downloadFileFromServer(totalFilePath);
				File file = new File(totalClientPath);
				FileOutputStream fout = new FileOutputStream(file);
				System.out.println("File is downloading.....");
				fout.write(data);
				fout.flush();
				fout.close();
				System.out.println("File is downloaded");
			}
			
			if(Integer.parseInt(args[0]) == 3){
				server = args[1];
				
				String[] files = stub.listFilesInServer(server);
				
				System.out.println("list of files in server :");
				
				for(String file : files){
					System.out.println(file);
				}
			}
			
			if(Integer.parseInt(args[0])==4){
				server = args[1];
				
				@SuppressWarnings("unused")
				boolean isDeleted = stub.deleteDirectoryInServer(server);
				
				System.out.println("Server Directory deleted.");
				
			}
			
			if(Integer.parseInt(args[0])==5){
				server = args[1];
				fileName = args[2];
				
				String totalFilePath = server+"\\"+fileName;
				
				@SuppressWarnings("unused")
				boolean isDeleted = stub.deleteFileInServer(totalFilePath);
				
				System.out.println("Server File deleted.");
			}
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
