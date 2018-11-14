package by.iba.professor.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import by.iba.professor.common.Professor;

public class ProfessorRepository {
	
	private final Map<String, Professor> professors = new ConcurrentHashMap<>();
	
	
	public ProfessorRepository(List<Professor> professors) {
		if(professors != null) {
			for(Professor pr : professors) {
				this.professors.put(pr.getId(), pr);
			}
		}
	}
	public List<Professor> findAll() {
		return new ArrayList<>(professors.values());
	}
	
	public Professor create(Professor professor) {
		String id = UUID.randomUUID().toString();
		professor.setId(id);
		professors.put(id, professor);
		return professor;
	}
	
	public void remove(String id) {
		professors.remove(id);
	}
	
	public Professor update(Professor professor) {
		professors.put(professor.getId(), professor);
		return professor;
	}
}
