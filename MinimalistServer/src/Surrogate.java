import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Surrogate implements Runnable{
	private BufferedReader readerIn;
	private PrintStream printOut;
	private Socket _socket;
	
	public Surrogate(Socket socket)
	{
		_socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			readerIn = new BufferedReader(new InputStreamReader(
					_socket.getInputStream()));
			printOut = new PrintStream(_socket.getOutputStream());
			PrintWriter output = new PrintWriter(_socket.getOutputStream(),true);
		
			boolean done = false;
			while (true) {
				String str = readerIn.readLine();
				//str = str.trim() + "\n";
				if (str == null)
				{
					done = true;
				}
				else {
					//str = str.trim();
					out("Echo: " + str.trim() + "\r");
					
					output.println("bite " + str);
					//output.write(str + " " + str);
					
					output.write("test", 0, 4);
					if (str.trim().equals("EXIT")) {
						done = true;
						break;
					}
				}
			}
			_socket.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	private void out(String str) {
		System.out.println(str.trim());
	}
}