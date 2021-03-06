package Connection;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientResponse {
	
	public String Response() {
		
		// Find the server using UDP broadcast
		try {
		  //Open a random port to send the package
		DatagramSocket  c = new DatagramSocket();
		  c.setBroadcast(true);

		  byte[] sendData = "DISCOVER_FUIFSERVER_REQUEST".getBytes();

		  //Try the 255.255.255.255 first
		  try {
		    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 61533);
		    c.send(sendPacket);
		    System.out.println(ClientResponse.class.getClass().getName() + ">>> Request packet sent to: 255.255.255.255 (DEFAULT)");
		  } catch (Exception e) {
		  }

		  // Broadcast the message over all the network interfaces
		  Enumeration<?> interfaces = NetworkInterface.getNetworkInterfaces();
		  while (interfaces.hasMoreElements()) {
		    NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();

		    if (networkInterface.isLoopback() || !networkInterface.isUp()) {
		      continue; // Don't want to broadcast to the loopback interface
		    }

		    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
		      InetAddress broadcast = interfaceAddress.getBroadcast();
		      if (broadcast == null) {
		        continue;
		      }

		      // Send the broadcast package!
		      try {
		        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, broadcast, 61533);
		        c.send(sendPacket);
		      } catch (Exception e) {
		      }

		      System.out.println(ClientResponse.class.getClass().getName() + ">>> Request packet sent to: " + broadcast.getHostAddress() + "; Interface: " + networkInterface.getDisplayName());
		    }
		  }

		  System.out.println(ClientResponse.class.getClass().getName() + ">>> Done looping over all network interfaces. Now waiting for a reply!");

		  //Wait for a response
		  byte[] recvBuf = new byte[15000];
		  DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
		  c.receive(receivePacket);

		  //We have a response
		  System.out.println(ClientResponse.class.getClass().getName()+ ">>> Broadcast response from server: " + receivePacket.getAddress().getHostAddress());
		
		  //Check if the message is correct
		  String message = new String(receivePacket.getData()).trim();
		  if (message.equals("DISCOVER_FUIFSERVER_RESPONSE")) {
		    //DO SOMETHING WITH THE SERVER'S IP (for example, store it in your controller)
		 
		  }

		  //Close the port!
		  
		  c.close();
		  return receivePacket.getAddress().getHostAddress();
		} catch (IOException ex) {
		  Logger.getLogger(ClientResponse.class.getClass().getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
	}
}
