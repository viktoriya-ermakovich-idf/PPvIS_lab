package Model;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {
	private Student student;
	private StudentBase studentBase;
	private List<Student> studentList;
	// private List<SocialWork> socialWorkList;
	private String currentElement;
	// private SocialWork socialWork;
	private StringBuilder content;
	private Integer studentCount = 1;

	public SaxParser() {
		studentList = new ArrayList<>();
		currentElement = "";
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attr) {
		currentElement = qName;
		if (currentElement.equals("stud_info")) {
			student = new Student();
			student.setIndex(studentCount);
			studentCount++;
			studentList.add(student);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		content = new StringBuilder(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (currentElement.equals("stud_info")) {

			return;
		}
		if (currentElement.equals("lastName")) {
			student.setLastName(content.toString());
			return;
		}
		if (currentElement.equals("firstName")) {
			student.setFirstName(content.toString());
			return;
		}
		if (currentElement.equals("patronymic")) {
			student.setPatronymic(content.toString());
			student.createFio();
			return;
		}
		if (currentElement.equals("birthday")) {
			student.setBirthday(content.toString());
			return;
		}
		if (currentElement.equals("team")) {
			student.setTeam(content.toString());
			return;
		}
		if (currentElement.equals("faculty")) {
			student.setFaculty(content.toString());
			return;
		}
		if (currentElement.equals("composition")) {
			student.setComposition(content.toString());
			return;
		}
		if (currentElement.equals("position")) {
			student.setPosition(content.toString());
			return;
		}
		if (qName.equals("students")) {
			studentBase.setStudentsBase(studentList);
		}
	}

	public void setBase(StudentBase studentBase) {
		this.studentBase = studentBase;
	}

}
