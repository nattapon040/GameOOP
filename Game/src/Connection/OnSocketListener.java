package Connection;

public interface OnSocketListener {
	void onConnected(Channel channel);
	void onDisconnected(Channel channel);
	void onReceived(Channel channel, Player msg);
}
