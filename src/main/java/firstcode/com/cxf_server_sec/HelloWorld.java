package firstcode.com.cxf_server_sec;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-10-14T18:15:48.673+01:00
 * Generated source version: 3.2.6
 *
 */
@WebService(targetNamespace = "http://cxf_server_sec.com.firstcode/", name = "HelloWorld")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWorld {

    @WebMethod
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://cxf_server_sec.com.firstcode/", className = "firstcode.com.cxf_server_sec.SayHi")
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://cxf_server_sec.com.firstcode/", className = "firstcode.com.cxf_server_sec.SayHiResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayHi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
