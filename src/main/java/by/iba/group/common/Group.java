package by.iba.group.common;

public class Group {
	
	private int groupNumber;
	
	private double averageMark;

	public Group() {
		super();
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}

	public Group(double averegeMark) {
		super();
		this.averageMark = averegeMark;
	}
	
	

}
