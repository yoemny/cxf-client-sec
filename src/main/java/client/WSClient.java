package client;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import firstcode.com.cxf_server_sec.HelloWorldImplService;

public class WSClient {
	public static void main(String[] args) {
		System.out.println("Comenzando...");
		
		HelloWorldImplService service = new HelloWorldImplService();
		
		Client client = ClientProxy.getClient(service.getHelloWorldImplPort());
		//Endpoint endpoint = client.getEndpoint();
		
		Map<String,Object> outProps = new HashMap<String,Object>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		outProps.put(WSHandlerConstants.USER, "joe");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallback.class.getName());
		
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		
		client.getOutInterceptors().add(wssOut);
		

		//((BindingProvider)service.getHelloWorldImplPort()).getRequestContext().put("password", "joespassword");
		
		System.out.println(service.getHelloWorldImplPort().sayHi("Pepe"));
		
		System.out.println("Terminando...");
    }
}
