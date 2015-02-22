import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class MatchData {

	public class writeXML {

		public void write(String matchNumber, String teamNumber,
				String alliance, String indvPts, String totalPts,
				String AVGTimeBtw, String bin, String Automode, String vision,
				String litter, String highest, String humanPlay,
				String malfunctions, String reliability) {
			
			File xmlFile = new File("C:\\data.xml");
			if (xmlFile.exists() && !xmlFile.isDirectory()) {
				try{
					// setup
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document data = builder.parse("C:\\data.xml");
					
					// root
					Node rootElement = data.getFirstChild();
					
					// record container element
					Element record = data.createElement("record");
					rootElement.appendChild(record);

					// match number element
					Element Mn = data.createElement("MatchNumber");
					Mn.appendChild(data.createTextNode(matchNumber));
					record.appendChild(Mn);

					// Team Number element
					Element Tn = data.createElement("TeamNumber");
					Tn.appendChild(data.createTextNode(teamNumber));
					record.appendChild(Tn);

					// Alliance element
					Element a = data.createElement("Alliance");
					Tn.appendChild(data.createTextNode(alliance));
					record.appendChild(a);

					// IndvPts element
					Element ip = data.createElement("IndvPts");
					ip.appendChild(data.createTextNode(indvPts));
					record.appendChild(ip);

					// Total Points element
					Element tp = data.createElement("TotalPts");
					tp.appendChild(data.createTextNode(totalPts));
					record.appendChild(tp);

					// Average Time between stacks element
					Element avgs = data.createElement("AVGTimeBtw");
					avgs.appendChild(data.createTextNode(AVGTimeBtw));
					record.appendChild(avgs);

					// Can do the bin element
					Element b = data.createElement("Bin");
					Tn.appendChild(data.createTextNode(bin));
					record.appendChild(b);

					// Automode element
					Element auto = data.createElement("Automode");
					Tn.appendChild(data.createTextNode(Automode));
					record.appendChild(auto);

					// Vision capable element
					Element v = data.createElement("Vision");
					Tn.appendChild(data.createTextNode(vision));
					record.appendChild(v);

					// Litter use element
					Element l = data.createElement("Litter");
					Tn.appendChild(data.createTextNode(litter));
					record.appendChild(l);

					// Highest stack element
					Element hs = data.createElement("Highest");
					hs.appendChild(data.createTextNode(highest));
					record.appendChild(hs);

					// Human player rating element
					Element hp = data.createElement("HumanPlay");
					hp.appendChild(data.createTextNode(humanPlay));
					record.appendChild(hp);

					// any malfunctions element
					Element m = data.createElement("Malfunctions");
					m.appendChild(data.createTextNode(malfunctions));
					record.appendChild(m);

					// reliability rating element
					Element r = data.createElement("reliability");
					r.appendChild(data.createTextNode(reliability));
					record.appendChild(r);
					
					// write xml file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(data);
					StreamResult result = new StreamResult(xmlFile);
					transformer.transform(source, result);
					
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerException te) {
					te.printStackTrace();
				} catch (IOException ioe){
					ioe.printStackTrace();
				} catch (SAXException saxe){ // the saxe-est exception :)
					saxe.printStackTrace();
				}
				
			} else {
				try {
					// setup
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();

					// root
					Document data = builder.newDocument();
					Element rootElement = data.createElement("data-set");
					Attr schemaInit = data.createAttribute("schema");
					schemaInit.setValue("xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'");
					rootElement.setAttributeNode(schemaInit);
					data.appendChild(rootElement);

					// record container element
					Element record = data.createElement("record");
					rootElement.appendChild(record);

					// match number element
					Element Mn = data.createElement("MatchNumber");
					Mn.appendChild(data.createTextNode(matchNumber));
					record.appendChild(Mn);

					// Team Number element
					Element Tn = data.createElement("TeamNumber");
					Tn.appendChild(data.createTextNode(teamNumber));
					record.appendChild(Tn);

					// Alliance element
					Element a = data.createElement("Alliance");
					Tn.appendChild(data.createTextNode(alliance));
					record.appendChild(a);

					// IndvPts element
					Element ip = data.createElement("IndvPts");
					ip.appendChild(data.createTextNode(indvPts));
					record.appendChild(ip);

					// Total Points element
					Element tp = data.createElement("TotalPts");
					tp.appendChild(data.createTextNode(totalPts));
					record.appendChild(tp);

					// Average Time between stacks element
					Element avgs = data.createElement("AVGTimeBtw");
					avgs.appendChild(data.createTextNode(AVGTimeBtw));
					record.appendChild(avgs);

					// Can do the bin element
					Element b = data.createElement("Bin");
					Tn.appendChild(data.createTextNode(bin));
					record.appendChild(b);

					// Automode element
					Element auto = data.createElement("Automode");
					Tn.appendChild(data.createTextNode(Automode));
					record.appendChild(auto);

					// Vision capable element
					Element v = data.createElement("Vision");
					Tn.appendChild(data.createTextNode(vision));
					record.appendChild(v);

					// Litter use element
					Element l = data.createElement("Litter");
					Tn.appendChild(data.createTextNode(litter));
					record.appendChild(l);

					// Highest stack element
					Element hs = data.createElement("Highest");
					hs.appendChild(data.createTextNode(highest));
					record.appendChild(hs);

					// Human player rating element
					Element hp = data.createElement("HumanPlay");
					hp.appendChild(data.createTextNode(humanPlay));
					record.appendChild(hp);

					// any malfunctions element
					Element m = data.createElement("Malfunctions");
					m.appendChild(data.createTextNode(malfunctions));
					record.appendChild(m);

					// reliability rating element
					Element r = data.createElement("reliability");
					r.appendChild(data.createTextNode(reliability));
					record.appendChild(r);

					// write content
					TransformerFactory transformerFactory = TransformerFactory
							.newInstance();
					Transformer transformer = transformerFactory
							.newTransformer();
					DOMSource source = new DOMSource(data);
					// TODO: create new directory Match_Data in C:\\ and put
					// file in that directory
					StreamResult result = new StreamResult(xmlFile);

					transformer.transform(source, result);
					System.out.println("File Saved!");

				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerException te) {
					te.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}