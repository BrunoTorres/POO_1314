package Fitness;


public abstract class Records {

	private String name;

	
	public Records(){
		this.name = "";
	}
    
    public Records(String name){
        this.name = name;
    }

	public Records(Records stat) {
		this.name = stat.getName();
	}
    
 	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public abstract boolean isEmpty();

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");sb.append(this.name).append("\n");
        return sb.toString();      
    }
    
	@Override
	public abstract Records clone();
}
