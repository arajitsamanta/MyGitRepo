/**
 * 
 */
package com.arajit.code.practise.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * @author as47775
 *
 */
public class SOAPMessageConverter {
	
	private static final String HEADER_QNAME = "http://sales.rel.citi.com/shared/header";
	 private static final String USER_ID_NAME = "UserID";
	    private static final String USER_NAMESPACE_NAME = "UserNamespace";
	    private static final String UUID_NAME = "UUID";
	
	/**
	 * 
	 */
	public SOAPMessageConverter() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws SOAPException, IOException, Exception{
		SOAPMessageConverter obj = new SOAPMessageConverter();
		String xml=obj.readXml();
		System.out.println("input:"+xml);
		SOAPMessage msg=obj.getSoapMessageFromString(xml);
		System.out.println("SOAP msg:"+msg);
		SOAPHeader soapHeader = msg.getSOAPHeader();
        if (soapHeader != null) {
            Iterator headerElements = soapHeader.examineAllHeaderElements();
            if (headerElements.hasNext()) {
                //return buildRequestContext(messageContext, headerElements);
            	 SOAPHeaderElement soapHeaderElement = (SOAPHeaderElement) headerElements.next();
                 String currentUser = extractHeaderValue(soapHeaderElement, USER_ID_NAME);
                 String currentUserNamespace = extractHeaderValue(soapHeaderElement, USER_NAMESPACE_NAME);
                 String uuid = extractHeaderValue(soapHeaderElement, UUID_NAME);
                 System.out.println("currentUser:"+currentUser);
            }
        }
		
	}

	 
	private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
	    MessageFactory factory = MessageFactory.newInstance();
	    SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
	    return message;
	}

	/**
	 * readXml
	 * @return String
	 * @throws MlaException 
	 */
	public String readXml() throws Exception {
		String str=null;
		
			InputStream is=getClass().getClassLoader().getResourceAsStream("C:/All_Workspaces_Kepler/RTC_Code_August/TestProject/src/com/arajit/util/gateWayRequest.xml");
			
			System.out.println("input stream::"+is);
			DocumentBuilderFactory dFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			
			/*Node uuid = doc.getElementsByTagName("hdr:UUID").item(0);
			uuid.setTextContent(UUID.randomUUID().toString());*/
			
			StringWriter sw = new StringWriter();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.transform(new DOMSource(doc), new StreamResult(sw));
			str = sw.toString();			
		
		return str;
	}
	
	 @SuppressWarnings("unchecked")
		private static String extractHeaderValue(SOAPHeaderElement soapHeaderElement, String headerNodeName) {
	        QName headerNodeQName = new QName(HEADER_QNAME, headerNodeName);
	        Iterator childElements = soapHeaderElement.getChildElements(headerNodeQName);
	        while (childElements.hasNext()) {
	            SOAPElement userIDElement = (SOAPElement) childElements.next();
	            if (headerNodeName.equals(userIDElement.getLocalName())) {
	                return userIDElement.getValue();
	            }
	        }
	        return null;
	    }

}
