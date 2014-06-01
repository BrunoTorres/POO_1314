package Fitness;

import java.io.Serializable;

public abstract class Record implements Serializable {

	private String name; //10 km|| Maratona...
    
	
	public Record(){
		this.name = "";
	}
    
    public Record(String name){
        this.name = name;
    }

	public Record(Record stat) {
		this.name = stat.getName();
	}
    
 	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public abstract boolean isEmpty();

    public abstract void update(Record act);
     
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        //sb.append("Nome: ").append("\n");
        sb.append(this.name).append(":\n");
        return sb.toString();      
    }
    
	@Override
	public abstract Record clone();
    
    
}

   