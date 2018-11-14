package by.iba.group.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.iba.group.common.Group;

public class GroupWriter {
	
	private final String path;
	
	public GroupWriter(String path) {
		this.path = path;
	}
	
	public void write(List<Group> groups) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			if(groups != null) {
				for(Group pr : groups) {
					String line = String.format("%s;%s",
							pr.getGroupNumber(),
							pr.getAverageMark());
					bw.write(line);
					bw.newLine();
				}
			}
		}
	}
}

