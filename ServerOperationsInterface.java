import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerOperationsInterface extends Remote {

	public void uploadFiletoServer(byte[] arr,String serverDir) throws RemoteException;
	public byte[] downloadFileFromServer(String serverDir) throws RemoteException;
	public String[] listFilesInServer(String serverDir) throws RemoteException;
	public boolean deleteDirectoryInServer(String serverDir) throws RemoteException;
	public boolean deleteFileInServer(String serverDir) throws RemoteException;
	
}
