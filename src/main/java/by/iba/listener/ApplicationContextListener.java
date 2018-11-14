package by.iba.listener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.iba.group.common.Group;
import by.iba.group.reader.GroupReader;
import by.iba.group.repository.GroupRepository;
import by.iba.group.writer.GroupWriter;
import by.iba.professor.common.Professor;
import by.iba.professor.reader.ProfessorReader;
import by.iba.professor.repository.ProfessorRepository;
import by.iba.professor.writer.ProfessorWriter;
import by.iba.student.common.Student;
import by.iba.student.reader.StudentReader;
import by.iba.student.repository.StudentRepository;
import by.iba.student.writer.StudentWriter;

public class ApplicationContextListener implements ServletContextListener {
	
	private Properties prop = new Properties();
	private InputStream input = null;
	private GroupRepository groupRepository;
	private StudentRepository studentRepository;
	private ProfessorRepository professorRepository;
	private String filePathStudents;
	private String filePathProfessors;
	private String filePathGroups;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		getEntitiesFilePaths();
		readStudents(sc);
		readProfessors(sc);
		readGroups(sc);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		getEntitiesFilePaths();
		writeStudents();
		writeProfessors();
		writeGroups();
	}

	private void getEntitiesFilePaths() {
		try {
			input = new FileInputStream("C:\\Users\\Никита\\eclipse-workspace\\student-app\\application.properties");
			prop.load(input);
			filePathStudents = prop.getProperty("studentsFilePath");
			filePathProfessors = prop.getProperty("professorsFilePath");
			filePathGroups = prop.getProperty("groupsFilePath");
			input.close();
		} catch (IOException e) {
			System.out.println("Can't read property file");
		}
	}
	
	private void readStudents(ServletContext sc) {
		try {
			List<Student> students = new StudentReader(filePathStudents).read();
			studentRepository = new StudentRepository(students);
			sc.setAttribute("studentRepository", studentRepository);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void writeStudents() {
		try{
			List<Student> students = studentRepository.findAll();
			new StudentWriter(filePathStudents).write(students);
		} catch (IOException e) {
			System.out.println("Can't save students");
		}
	}
	
	private void readProfessors(ServletContext sc) {
		try {
			List<Professor> professors = new ProfessorReader(filePathProfessors).read();
			professorRepository = new ProfessorRepository(professors);
			sc.setAttribute("professorRepository", professorRepository);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void writeProfessors() {
		try{
			List<Professor> professors = professorRepository.findAll();
			new ProfessorWriter(filePathProfessors).write(professors);
		} catch (IOException e) {
			System.out.println("Can't save professors");
		}
	}
	
	private void readGroups(ServletContext sc) {
		try {
			List<Group> groups = new GroupReader(filePathGroups).read();
			groupRepository = new GroupRepository(groups);
			sc.setAttribute("groupRepository", groupRepository);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void writeGroups() {
		try{
			List<Group> groups = groupRepository.findAll();
			new GroupWriter(filePathGroups).write(groups);
		} catch (IOException e) {
			System.out.println("Can't save groups");
		}
	}
	
}
