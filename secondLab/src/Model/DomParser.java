package Model;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomParser {
	private File file;
	private Document document;
	private StudentBase studentBase;
	Element socialWorkBase;

	public void write(File file, StudentBase studentBase) {
		this.file = file;
		this.studentBase = studentBase;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element list = document.createElement("students");

			for (int numOfStudent = 0; numOfStudent < studentBase.getStudentsBase().size(); numOfStudent++) {
				Element student = document.createElement("stud_info");

				Element index = document.createElement("index");
				index.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getFio());
				student.appendChild(index);

				Element lastName = document.createElement("lastName");
				lastName.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getLastName());
				student.appendChild(lastName);

				Element firstName = document.createElement("firstName");
				firstName.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getFirstName());
				student.appendChild(firstName);

				Element patronymic = document.createElement("patronymic");
				patronymic.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getPatronymic());
				student.appendChild(patronymic);

				Element birthday = document.createElement("birthday");
				birthday.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getBirthday());
				student.appendChild(birthday);

				Element team = document.createElement("team");
				team.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getTeam());
				student.appendChild(team);

				Element faculty = document.createElement("faculty");
				faculty.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getFaculty());
				student.appendChild(faculty);

				Element composition = document.createElement("composition");
				composition.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getComposition());
				student.appendChild(composition);

				Element position = document.createElement("position");
				position.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getPosition());
				student.appendChild(position);

				list.appendChild(student);
			}

			document.appendChild(list);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult streamResult = new StreamResult(file);
			transformer.transform(source, streamResult);
		} catch (ParserConfigurationException ex) {
			String exText = ex.getMessage();
			studentBase.getController().alertMessage(exText);
		} catch (TransformerConfigurationException ex) {
			String exText = ex.getMessage();
			studentBase.getController().alertMessage(exText);
		} catch (TransformerException ex) {
			String exText = ex.getMessage();
			studentBase.getController().alertMessage(exText);
		}
	}

	// public void addSemToFile(List<SocialWork> list) {
	// for (SocialWork sw : list) {
	// if (sw.getSem() != 0) {
	// Element socialWork = document.createElement("socialWork");
	//
	// Element typeWork = document.createElement("typeWork");
	// typeWork.setTextContent(sw.getTypeWork());
	// socialWork.appendChild(typeWork);
	//
	// Element numberWork = document.createElement("numberWork");
	// numberWork.setTextContent(sw.getNumberWork() + "");
	// socialWork.appendChild(numberWork);
	//
	// Element sem = document.createElement("sem");
	// sem.setTextContent(sw.getSem() + "");
	// socialWork.appendChild(sem);
	//
	// socialWorkBase.appendChild(socialWork);
	// }
	// }
	// }
}
