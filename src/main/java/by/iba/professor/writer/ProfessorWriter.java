package by.iba.professor.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.iba.professor.common.Professor;

public class ProfessorWriter {
	
	private final String path;
	
	public ProfessorWriter(String path) {
		this.path = path;
	}
	
	public void write(List<Professor> professors) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			if(professors != null) {
				for(Professor pr : professors) {
					String line = String.format("%s;%s;%s;%s",
							pr.getId(),
							pr.getFirstName(),
							pr.getSecondName(),
							pr.getFatherName());
					bw.write(line);
					bw.newLine();
				}
			}
		}
	}
}
