package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import Controller.Controller;

public class StudentBase {
	private Controller controller;
	private List<Student> studentsBase = new ArrayList();
	private File file;

	public StudentBase(Controller controller) {
		this.controller = controller;
	}

	public void add(Student student) {
		studentsBase.add(student);

	}

	public void setStudentsBase(List<Student> studentsBase) {
		this.studentsBase = studentsBase;
	}

	public List<Student> getStudentsBase() {
		return studentsBase;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void toFile(File file) {
		DomParser domParser = new DomParser();
		domParser.write(file, this);
	}

	public void fromFile() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SaxParser saxParser = new SaxParser();
		saxParser.setBase(this);
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(file, saxParser);
			for (Student stud : saxParser.getStudentList()) {
				controller.addStudent(stud);
			}
			controller.getMainFrame().update();
		} catch (SAXException | ParserConfigurationException | IOException ex) {
			String exText = ex.getMessage();
			controller.alertMessage(exText);
		}
	}
}