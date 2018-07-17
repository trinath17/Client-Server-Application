import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerApplication {
	
	public static void main(String args[]){
		
		if(args.length<1){
			System.out.println("Please server directory as cmd argument");
			System.exit(0);
		}
		
		//port = Integer.parseInt(args[0]);
		try {
			//Registry registry = LocateRegistry.createRegistry(port);
			ServerOperations stub = new ServerOperations(args[0]);
			Naming.rebind("rmi://localhost:5500/remote", stub);
			
			System.out.println("Server started");
			System.out.println("Server running on port : 5500");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
