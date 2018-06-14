package Model;

public class Student {

	private String lastName;
	private String firstName;
	private String patronymic;
	private String fio;
	private String birthday;
	private String team;
	private String faculty;
	private String composition;
	private String position;
	private Integer index;
	// private List<SocialWork> socialWorkBase;

	public Student() {
		lastName = "";
		firstName = "";
		patronymic = "";
		birthday = "";
		team = "";
		faculty = "";
		composition = "";
		position = "";
		index = 0;

		// socialWorkBase = new ArrayList<>();
		// for (int numberOfSemestr = 0; numberOfSemestr < 10; numberOfSemestr++) {
		// int num = numberOfSemestr;
		// num++;
		// socialWorkBase.add(numberOfSemestr, new SocialWork("", 0, num));
		// }
	}

	public String getTeam() {
		return team;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getComposition() {
		return composition;
	}

	public String getPosition() {
		return position;
	}

	public String getBirthday() {
		return birthday;
	}

	public Integer getIndex() {
		return index;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void createFio(String firstName, String lastName, String patronymic) {
		fio = lastName + " " + firstName + " " + patronymic;
	}

	public void createFio() {
		fio = lastName + " " + firstName + " " + patronymic;
	}

	public String getFio() {
		return fio;
	}
	//
	// public void setSocialWorkBase(List<SocialWork> socialWorkBase) {
	// this.socialWorkBase = socialWorkBase;
	// }
	//
	// public List<SocialWork> getSocialWorkBase() {
	// return socialWorkBase;
	// }
	//
	// public void addWorkInSemestr(SocialWork socialWork) {
	// socialWorkBase.add(socialWork.getSem() - 1, socialWork);
	// }

	// public void setFullName(String lastName, String name, String patronymic) {
	// this.lastName = lastName;
	// this.firstName = name;
	// this.patronymic = patronymic;
	// }

	// public boolean equalsWork(String work) {
	// for (SocialWork socialWork : socialWorkBase) {
	// if (socialWork.getTypeWork().equals(work)) {
	// return true;
	// }
	// }
	// return false;
	// }

	// public boolean equalsNumberOfWork(String work, int minNumber, int maxNumber)
	// {
	// for (SocialWork socialWork : socialWorkBase) {
	// if (socialWork.getTypeWork().equals(work) && socialWork.getNumberWork() >=
	// minNumber
	// && socialWork.getNumberWork() <= maxNumber) {
	// return true;
	// }
	// }
	// return false;
	// }

	public void clean() {
		lastName = "";
		firstName = "";
		patronymic = "";
		birthday = "";
		team = "";
		faculty = "";
		composition = "";
		position = "";
		index = 0;
		// socialWorkBase.clear();
	}
}
