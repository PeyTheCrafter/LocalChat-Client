package controller;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;

public class ServerScanner implements Runnable {
	
	private ArrayList<String> address;
	
	public ServerScanner() {
		this.address = new ArrayList<>();
	}

	@Override
	public void run() {
		String ip;
		String subnet = getSubnet();
		for (int i = 2; i < 255; i++) {
			ip = subnet + "." + i;
			if (isServer(ip, 6544)) {
				this.address.add(ip);
			}
		}
	}

	public boolean isServer(String ip, int port) {
		try {
			Socket s = new Socket();
			s.connect(new InetSocketAddress(ip, port), 10);
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private String getSubnet() {
		String ip = null;
		try {
			ip = getActiveInterface().getInetAddresses().nextElement().getHostAddress();
		} catch (SocketException e) {
		}
		return ip.substring(0, ip.lastIndexOf("."));
	}

	private NetworkInterface getActiveInterface() throws SocketException {
		for (NetworkInterface i : Collections.list(NetworkInterface.getNetworkInterfaces())) {
			if (!i.isLoopback() && !isVirtualMachine(i) && !i.isVirtual() && i.isUp()) {
				return i;
			}
		}

		return null;
	}
	
	private boolean isVirtualMachine(NetworkInterface i) {
		String vm = "VirtualBox";
		return i.getDisplayName().contains(vm);
	}

	public ArrayList<String> getServerAddresses() {
		return address;
	}

}
