package by.iba.group.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.iba.group.common.Group;

public class GroupReader {
	
	private String path;
	
	public GroupReader(String path) {
		this.path = path;
	}
	
	public List<Group> read() throws IOException {
		List<Group> groups = new ArrayList<Group>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] data = line.split(";");
				Group group = new Group();
				group.setGroupNumber(new Integer(data[0]));
				group.setAverageMark(new Double(data[1]));
				groups.add(group);
			}
		}finally {
			if(br != null) {
				br.close();
			}
			
		}
		return groups;
	}
}


