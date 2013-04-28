package com.ldd.uqam.minicontrapt 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.utils.ByteArray;
	/**
	 * ...
	 * @author Squelos
	 */
	public class FakeClient extends Sprite
	{
		public function FakeClient() 
		{
			var module:NetworkModule  = new NetworkModule(new Client("127.0.0.1", 8080));
			module.addEventListener(NetworkModule.MSG_RECV, onReceivedMessage);
			module.addEventListener(NetworkModule.NETWORK_ERROR, onNetworkError);
			
			var msg:Message = new Message("GEFEG", "Lucas", 23);
			
			module.SendMessage("Hello world1\n");
			module.SendMessage("Hello world\n");
			module.SendMessage("Hello world3\n");
			var bytes:ByteArray = new ByteArray();
			bytes.writeObject(msg);
			module.SendObject(bytes);
			//module.SendMessage("EXIT\n");
			
			//module.addEventListener(NetworkModule.MSG_RECV, onReceivedMessage);
			//module.addEventListener(NetworkModule.NETWORK_ERROR, onNetworkError);
		}
		
		private function onReceivedMessage(e:CommunicationEvent):void
		{
				trace(e.Data);
		}
		
		private function onNetworkError(e:Event):void
		{
			
		}
	}
}