package by.iba.professor.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.iba.professor.common.Professor;

public class ProfessorReader {
	
	private String path;
	
	public ProfessorReader(String path) {
		this.path = path;
	}
	
	public List<Professor> read() throws IOException {
		List<Professor> professors = new ArrayList<Professor>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] data = line.split(";");
				Professor professor = new Professor();
				professor.setId(data[0]);
				professor.setFirstName(data[1]);
				professor.setSecondName(data[2]);
				professor.setFatherName(data[3]);
				professors.add(professor);
			}
		}finally {
			if(br != null) {
				br.close();
			}
			
		}
		return professors;
	}
}

