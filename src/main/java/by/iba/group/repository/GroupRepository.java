package by.iba.group.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.iba.group.common.Group;

public class GroupRepository {
	
	private final Map<Integer, Group> groups = new ConcurrentHashMap<>();
	
	
	public GroupRepository(List<Group> groups) {
		if(groups != null) {
			for(Group gr : groups) {
				this.groups.put(gr.getGroupNumber(), gr);
			}
		}
	}
	public List<Group> findAll() {
		return new ArrayList<>(groups.values());
	}
	
	public Group create(Group group) {
		Random intRandom = new Random();
		Random doubleRandom = new Random();
		double id = intRandom.nextInt(10000)*doubleRandom.nextDouble();
		group.setGroupNumber((int)id);
		groups.put((int)id, group);
		return group;
	}
	
	public void remove(int id) {
		groups.remove(id);
	}
	
	public Group update(Group group) {
		groups.put(group.getGroupNumber(), group);
		return group;
	}
}

