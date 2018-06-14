package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.StudentBase;
import View.Main;

public class Controller {
	private Main mainFrame;
	private StudentBase studentBase;

	public Controller() {
		studentBase = new StudentBase(this);
		mainFrame = new Main(this);

	}

	public void addStudent(Student student) {
		studentBase.add(student);
	}

	public void setStudentBase(StudentBase studentBase) {
		this.studentBase = studentBase;
	}

	public List<Student> getStudentBase() {
		return studentBase.getStudentsBase();
	}

	public void setMainFrame(Main mainFrame) {
		this.mainFrame = mainFrame;
	}

	public Main getMainFrame() {
		return mainFrame;
	}

	public void setFile(File file) {
		studentBase.setFile(file);
	}

	public void removeStudent(List<Student> stud) {
		getStudentBase().removeAll(stud);
	}

	public File getFile() {
		return studentBase.getFile();
	}

	public void toFile(File file) {
		studentBase.toFile(file);
	}

	public void fromFile() {
		studentBase.fromFile();
		mainFrame.update();
	}

	public List<Student> searchStudents(Student searchStudent, String paramSearch) {
		List<Student> searchStud = new ArrayList<>();
		List<Student> allStudents = getStudentBase();

		if (paramSearch.equals("Fio And Birthday")) {
			for (Student stud : allStudents) {
				if (stud.getFirstName().equals(searchStudent.getFirstName())
						&& stud.getLastName().equals(searchStudent.getLastName())
						&& stud.getPatronymic().equals(searchStudent.getPatronymic())
						&& stud.getBirthday().equals(searchStudent.getBirthday())) {
					searchStud.add(stud);
				}
			}
		}

		if (paramSearch.equals("Position And Composition")) {
			for (Student stud : allStudents) {
				if (stud.getPosition().equals(searchStudent.getPosition())
						&& stud.getComposition().equals(searchStudent.getComposition())) {
					searchStud.add(stud);
				}
			}
		}

		if (paramSearch.equals("Fio And Team")) {
			for (Student stud : allStudents) {
				if (stud.getFirstName().equals(searchStudent.getFirstName())
						&& stud.getLastName().equals(searchStudent.getLastName())
						&& stud.getPatronymic().equals(searchStudent.getPatronymic())
						&& stud.getTeam().equals(searchStudent.getTeam())) {
					searchStud.add(stud);
				}
			}
		}

		if (paramSearch.equals("Faculty And Fio")) {
			for (Student stud : allStudents) {
				if (stud.getFaculty().equals(searchStudent.getFaculty())
						&& stud.getFirstName().equals(searchStudent.getFirstName())
						&& stud.getLastName().equals(searchStudent.getLastName())
						&& stud.getPatronymic().equals(searchStudent.getPatronymic())) {
					searchStud.add(stud);
				}
			}
		}
		// else if (paramSearch.equals("Type")) {
		// for (Student stud : allStudents) {
		// if (stud.getSurname().equals(searchStudent.getSurname())
		// && stud.equalsWork(searchStudent.getSocialWorkBase().get(0).getTypeWork())) {
		// searchStud.add(stud);
		// }
		// }
		// }

		// else if (paramSearch.equals("Number")) {
		// for (Student stud : allStudents) {
		// if (stud.getSurname().equals(searchStudent.getSurname())
		// &&
		// stud.equalsNumberOfWork(searchStudent.getSocialWorkBase().get(0).getTypeWork(),
		// searchStudent.getSocialWorkBase().get(0).getNumberWork(),
		// searchStudent.getSocialWorkBase().get(1).getNumberWork())) {
		// searchStud.add(stud);
		// }
		// }
		// }
		return searchStud;
	}

	public void alertMessage(String text) {
		mainFrame.alertMessage(text);
	}
}
