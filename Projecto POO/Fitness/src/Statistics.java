
public class Statistics {

	private String name;
	private float record;
	
	public Statistics(){
		this.name = "";
		this.record = 0;
	}

	public Statistics(Statistics stat) {
		this.name = stat.getName();
		this.record = stat.getRecord();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the record
	 */
	public float getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(float record) {
		this.record = record;
	}
	
	@Override
	public Statistics clone(){
		return new Statistics(this);
	}
}
