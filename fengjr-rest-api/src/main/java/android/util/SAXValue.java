package android.util;
/*
 * The Apache Software License, Version 1.1
 *
 *
 * Copyright (c) 2000-2002 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Crimson" and "Apache Software Foundation" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation and was
 * originally based on software copyright (c) 1999, Sun Microsystems, Inc., 
 * http://www.sun.com.  For more information on the Apache Software 
 * Foundation, please see <http://www.apache.org/>.
 */

// JAXP packages
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Program to count the number of elements using only the localName
 * component of the element, in an XML document.  Namespace names are
 * ignored for simplicity.  This example also shows one way to turn on
 * validation and how to use a SAX ErrorHandler.
 *
 * Notes: DefaultHandler is a SAX helper class that implements the SAX
 * ContentHandler interface by providing no-op methods.  This class
 * overrides some of the methods by extending DefaultHandler.  This program
 * turns on namespace processing and uses SAX2 interfaces to process XML
 * documents which may or may not be using namespaces.
 *
 * Update 2002-04-18: Added code that shows how to use JAXP 1.2 features to
 * support W3C XML Schema validation.  See the JAXP 1.2 maintenance review
 * specification for more information on these features.
 *
 * @author Edwin Goei
 */
public class SAXValue extends DefaultHandler {
    /** Constants used for JAXP 1.2 */
    static final String JAXP_SCHEMA_LANGUAGE =
        "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String W3C_XML_SCHEMA =
        "http://www.w3.org/2001/XMLSchema";
    static final String JAXP_SCHEMA_SOURCE =
        "http://java.sun.com/xml/jaxp/properties/schemaSource";

    /** A Hashtable with tag names as keys and Integers as values */
    private static Hashtable<String, String> tags;
    
    private static String FILE_NAME = "apis.xml";

    // Parser calls this once at the beginning of a document
    public void startDocument() throws SAXException {
        tags = new Hashtable<String, String>();
    }
    
    StringBuffer accumulator = new StringBuffer(); // Accumulate parsed text
    String currentKey = null;

    // Parser calls this for each element in a document
    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException
    {
    	accumulator.setLength(0);
    	if ("string".equals(localName)) {
    		currentKey = atts.getValue("name");
    	}
    }

    // When the parser encounters plain text (not XML elements), it calls
    // this method, which accumulates them in a string buffer
    public void characters(char[] buffer, int start, int length) {
      accumulator.append(buffer, start, length);
    }
    
    // When the parser encounters the end of an element, it calls this method
    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException {
    	
    	if ("string".equals(localName)) {
    		tags.put(currentKey, accumulator.toString());
    	}
    }

    // Parser calls this once after parsing a document
    public void endDocument() throws SAXException {
        Enumeration<String> e = tags.keys();
        while (e.hasMoreElements()) {
            String tag = (String)e.nextElement();
            String count = tags.get(tag);
            System.out.println(tag  + ":"+ count);
        }
    }

    /**
     * Convert from a filename to a file URL.
     */
    private static InputSource convertToSource(String filename) {
    	ClassLoader classLoader = SAXValue.class.getClassLoader();
    	InputSource result = new InputSource();
    	result.setByteStream(classLoader.getResourceAsStream(filename));
    	return result;
    }
    
    public static String getValue(String key) {
    	return tags.get(key);
    }
    
    public static void parser() throws Exception {
        boolean dtdValidate = false;
        boolean xsdValidate = false;

        // There are several ways to parse a document using SAX and JAXP.
        // We show one approach here.  The first step is to bootstrap a
        // parser.  There are two ways: one is to use only the SAX API, the
        // other is to use the JAXP utility classes in the
        // javax.xml.parsers package.  We use the second approach here
        // because at the time of this writing it probably is the most
        // portable solution for a JAXP compatible parser.  After
        // bootstrapping a parser/XMLReader, there are several ways to
        // begin a parse.  In this example, we use the SAX API.

        // Create a JAXP SAXParserFactory and configure it
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Set namespaceAware to true to get a parser that corresponds to
        // the default SAX2 namespace feature setting.  This is necessary
        // because the default value from JAXP 1.0 was defined to be false.
        spf.setNamespaceAware(true);

        // Validation part 1: set whether validation is on
        spf.setValidating(dtdValidate || xsdValidate);

        // Create a JAXP SAXParser
        SAXParser saxParser = spf.newSAXParser();

        // Validation part 2a: set the schema language if necessary
        if (xsdValidate) {
            try {
                saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            } catch (SAXNotRecognizedException x) {
                // This can happen if the parser does not support JAXP 1.2
                System.err.println(
                    "Error: JAXP SAXParser property not recognized: "
                    + JAXP_SCHEMA_LANGUAGE);
                System.err.println(
                    "Check to see if parser conforms to JAXP 1.2 spec.");
                System.exit(1);
            }
        }

        // Get the encapsulated SAX XMLReader
        XMLReader xmlReader = saxParser.getXMLReader();

        // Set the ContentHandler of the XMLReader
        xmlReader.setContentHandler(new SAXValue());

        // Set an ErrorHandler before parsing
        xmlReader.setErrorHandler(new MyErrorHandler(System.err));

        // Tell the XMLReader to parse the XML document
        xmlReader.parse(convertToSource(FILE_NAME));
    }

    // Error handler to report errors and warnings
    private static class MyErrorHandler implements ErrorHandler {
        /** Error handler output goes here */
        private PrintStream out;

        MyErrorHandler(PrintStream out) {
            this.out = out;
        }

        /**
         * Returns a string describing parse exception details
         */
        private String getParseExceptionInfo(SAXParseException spe) {
            String systemId = spe.getSystemId();
            if (systemId == null) {
                systemId = "null";
            }
            String info = "URI=" + systemId +
                " Line=" + spe.getLineNumber() +
                ": " + spe.getMessage();
            return info;
        }

        // The following methods are standard SAX ErrorHandler methods.
        // See SAX documentation for more info.

        public void warning(SAXParseException spe) throws SAXException {
            out.println("Warning: " + getParseExceptionInfo(spe));
        }
        
        public void error(SAXParseException spe) throws SAXException {
            String message = "Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException spe) throws SAXException {
            String message = "Fatal Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }
    }
//    
//    public static void main(String[] args) throws Exception {
//    	SAXValue count = new SAXValue();
//
//    	System.out.println(loc);
//    	count.parser(loc);
//    	
//    }
}
