package examples;

import java.util.function.Supplier;

public class MessageWriter {
	boolean messageRequired = false;
	private void doWrite(String msg){
		System.out.println(msg);
	}
	
	public void writeMessage(String message){
		if (messageRequired){
			doWrite(message);
		}
	}
	
	public void writeMessage(Supplier<String> messageSupplier){
		if (messageRequired){
			doWrite(messageSupplier.get());
		}
	}
	
	public static String generateMessage(){
		System.out.println("doing some expensive processing");
		return "big message";
	}
	
	public static void main(String args[]){
		MessageWriter messageWriter= new MessageWriter();
		System.out.println("old style");
		messageWriter.writeMessage(generateMessage());
		System.out.println("new style");
		messageWriter.writeMessage(() -> generateMessage() );
	}
	
}
