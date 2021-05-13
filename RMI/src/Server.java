import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class Server {
    public static void main(String args[]) {
        try {
			// create an instance
            ServiceImplementation obj = new ServiceImplementation();
			
			// create stub
                        
            // UnicastremoteObject.exportObject -> return Remote, ServiceFromServer is extended from Remote so we can use.
            ServiceFromServer stub = (ServiceFromServer) 
			                          UnicastRemoteObject.exportObject(obj, 0);

            // Don't need to run rmiregistry in jdk/bin.
            LocateRegistry.createRegistry(1099);
            
            
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("ServicesFromServer", stub);

            System.err.println("Server ready");
			
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

