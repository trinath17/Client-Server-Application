import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ServerOperations extends UnicastRemoteObject implements ServerOperationsInterface {

	protected ServerOperations(String serverDir) throws RemoteException {
		super();
		File serverPath = new File(serverDir);
		serverPath.mkdir();
	}

	@Override
	public void uploadFiletoServer(byte[] arr, String serverDir) throws RemoteException {
		
		try {
			File file = new File(serverDir);
			FileOutputStream out = new FileOutputStream(file);
			out.write(arr);
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("File uploaded to server");
		
	}

	@Override
	public byte[] downloadFileFromServer(String serverDir) throws RemoteException {
		
		File file = new File(serverDir);
		int len = (int) file.length();
		byte[] data = new byte[len];
		try {
			FileInputStream fin = new FileInputStream(file);
			fin.read(data, 0, len);
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public String[] listFilesInServer(String serverDir) throws RemoteException {
		File file = new File(serverDir);
		return file.list();
	}

	@Override
	public boolean deleteDirectoryInServer(String serverDir) throws RemoteException {
		File file = new File(serverDir);
		return file.delete();
	}

	@Override
	public boolean deleteFileInServer(String serverDir) throws RemoteException {
		File file = new File(serverDir);
		return file.delete();
	}

}
