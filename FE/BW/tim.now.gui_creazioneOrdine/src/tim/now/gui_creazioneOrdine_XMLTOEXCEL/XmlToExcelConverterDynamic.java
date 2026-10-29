package tim.now.gui_creazioneOrdine_XMLTOEXCEL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("deprecation")
public class XmlToExcelConverterDynamic {

	private static Workbook workbook;
	private static int rowNum;
	private byte[] excelData;

	public byte[] getExcelData() {
		return excelData;
	}

	public void setExcelData(byte[] excelData) {
		this.excelData = excelData;
	}

	public static void main(String[] args) throws Exception {

	}

	public XmlToExcelConverterDynamic() {

	}

	public void getAndReadXml(String xml, String outputRoot, String childRoot,
			String passedlistofElements, String nameOfFile,
			String pathOfPropertieFile) throws Exception {
		if (xml == null || outputRoot == null || passedlistofElements == null) {
			System.out.println("empty");
		} else {

			ClassLoader cl = null;

			cl = Thread.currentThread().getContextClassLoader();
			try {
				Thread.currentThread().setContextClassLoader(
						getClass().getClassLoader());

				try {
					System.out.println("getAndReadXml");
					String[] listOfElements = passedlistofElements.split(",",
							-1);
					System.out.println("Length :" + listOfElements.length);
					initXls(listOfElements, pathOfPropertieFile, nameOfFile);

					Sheet sheet = workbook.getSheetAt(0);

					ByteArrayInputStream input = new ByteArrayInputStream(
							xml.getBytes());

					DocumentBuilderFactory dbFactory = DocumentBuilderFactory
							.newInstance();
					dbFactory.setNamespaceAware(true);
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(input);

					Node rootNamespace = doc.getFirstChild();

					NodeList nList = doc.getElementsByTagNameNS(
							rootNamespace.getNamespaceURI(), outputRoot);

					System.out.println("name space :- "
							+ rootNamespace.getNamespaceURI() + " And "
							+ rootNamespace.getPrefix());
					for (int i = 0; i < nList.getLength(); i++) {
						System.out.println("Processing element " + (i + 1)
								+ "/" + nList.getLength());
						Node node = nList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element element = (Element) node;

							NodeList Output_root = element
									.getElementsByTagNameNS(
											rootNamespace.getNamespaceURI(),
											childRoot);
							for (int j = 0; j < Output_root.getLength(); j++) {
								Node Output_child = Output_root.item(j);

								if (Output_child.getNodeType() == Node.ELEMENT_NODE) {

									Row row = sheet.createRow(rowNum++);
									String tempValue = "";
									for (int k = 0; k < listOfElements.length; k++) {

										Element tempElmt = (Element) Output_child;

										try {
											if (tempElmt
													.getElementsByTagNameNS(
															rootNamespace
																	.getNamespaceURI(),
															listOfElements[k])
													.item(0).getTextContent() == null)
												continue;
											else {
												tempValue = tempElmt
														.getElementsByTagNameNS(
																rootNamespace
																		.getNamespaceURI(),
																listOfElements[k])
														.item(0)
														.getTextContent();

												Cell cell = row.createCell(k);
												cell.setCellValue(tempValue);
											}
										} catch (Exception e) {

										}

									}

								}
							}
						}
					}
					int lastrow = sheet.getPhysicalNumberOfRows();
					Row row2 = sheet.createRow(lastrow + 5);

					sheet.addMergedRegion(new CellRangeAddress(lastrow + 5,
							lastrow + 8, 3, 18));
					Cell row2Cell = row2.createCell(3);
					CellStyle cellStyle = workbook.createCellStyle();
					cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
					row2Cell.setCellStyle(cellStyle);
					// row2Cell.setAlignment();
					row2.createCell(3)
							.setCellValue(
									" « Attenzione: i dati contenuti nel sistema sono classificati Fibercop - Confidenziale e sono soggetti ai vincoli imposti dalla Delibera 152/02/CONS. Nel trattare i dati l'operatore deve attenersi alle disposizioni contenute nel \"Codice di Comportamento per la riservatezza dei dati relativi alla Clientela degli OLO\", nonché a tutte le normative di sicurezza vigenti in Azienda » ");
					// Clob tempExcelData = (Clob) workbook;

					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					try {
						workbook.write(bos);
					} finally {
						bos.close();
					}

					excelData = bos.toByteArray();

					workbook.close();

				} catch (NullPointerException npe) {
					npe.printStackTrace();
				}

			} finally {
				Thread.currentThread().setContextClassLoader(cl);
			}

		}
		// return excelData;
	}

	/**
	 * Initializes the POI workbook and writes the header row
	 */
	private static void initXls(String[] listOfHeader,
			String pathOfPropertieFile, String nameOfFile) {

		// first check name of list is modified
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		workbook = new XSSFWorkbook();

		CellStyle style = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		style.setFont(boldFont);
		style.setAlignment(CellStyle.ALIGN_CENTER);

		Sheet sheet = workbook.createSheet();

		rowNum = 0;
		Row row = sheet.createRow(rowNum++);
		FileReader reader = null;
		Properties properties = null;
		try {
			reader = new FileReader(pathOfPropertieFile);
			properties = new Properties();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			properties.load(reader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int k = 0; k < listOfHeader.length; k++) {
			Cell cell = row.createCell(k);
			try {
				;
				if (listOfHeader[k] != properties
						.getProperty((nameOfFile + "." + listOfHeader[k]))) {
					cell.setCellValue(properties
							.getProperty((nameOfFile + "." + listOfHeader[k])));
				} else if (listOfHeader[k].equals("Tot-TimestampAggRichOlo")) {
					Calendar cal = Calendar.getInstance();
					cell.setCellValue(dateFormat.format(cal.getTime())
							.toString());
				} else if (listOfHeader[k].equals("Tot-DataEstrazione-1")) {
					Calendar calBefore1Day = Calendar.getInstance();
					calBefore1Day.add(Calendar.DATE, -1);
					cell.setCellValue(dateFormat
							.format(calBefore1Day.getTime()).toString());
				} else if (listOfHeader[k].equals("Tot-DataEstrazione-2")) {
					Calendar calBefore2Day = Calendar.getInstance();
					calBefore2Day.add(Calendar.DATE, -2);
					cell.setCellValue(dateFormat
							.format(calBefore2Day.getTime()).toString());
				} else if (listOfHeader[k].equals("Tot-DataEstrazione-3")) {
					Calendar calBefore3Day = Calendar.getInstance();
					calBefore3Day.add(Calendar.DATE, -3);
					cell.setCellValue(dateFormat
							.format(calBefore3Day.getTime()).toString());
				} else if (listOfHeader[k].equals("Tot-DataEstrazione-4")) {
					Calendar calBefore4Day = Calendar.getInstance();
					calBefore4Day.add(Calendar.DATE, -4);
					cell.setCellValue(dateFormat
							.format(calBefore4Day.getTime()).toString());
				} else if (listOfHeader[k].equals("Tot-DataEstrazione-5")) {
					Calendar calBefore5Day = Calendar.getInstance();
					calBefore5Day.add(Calendar.DATE, -5);
					cell.setCellValue(dateFormat
							.format(calBefore5Day.getTime()).toString());
				} else if (listOfHeader[k].equals("Tot-DataEstrazione-6")) {
					Calendar calBefore6Day = Calendar.getInstance();
					calBefore6Day.add(Calendar.DATE, -6);
					cell.setCellValue(dateFormat
							.format(calBefore6Day.getTime()).toString());
				}

				else {
					cell.setCellValue(listOfHeader[k]);
				}
			} catch (Exception e) {
				// crm_olo@newName
			}

			cell.setCellStyle(style);
		}

	}

}
