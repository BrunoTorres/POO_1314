import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class User extends Person
{
    private int height; // centímetros
    private float weight; // kilogramas
    private String favoriteActivity;
    private TreeSet<Activity> userActivities; 
    private TreeSet<String> friendsList;

    
    
    public User(){
        super();
        this.height=0;
        this.weight=0;
        this.favoriteActivity="";
        this.userActivities=new TreeSet<Activity>();
        this.friendsList=new TreeSet<String>(); 
        
    }
    
    public User(String email,String pass,String name,char gender,GregorianCalendar date,
            int height,float weight,String favoriteActivity,
            TreeSet<Activity> userActivities,TreeSet<String> friendsList)
    {
        super(email,pass,name,gender,date);
        this.height=height;
        this.weight=weight;
        this.favoriteActivity=favoriteActivity;
        for(Activity act:userActivities)
        this.userActivities.add((Activity) act.clone());
        this.friendsList=(TreeSet<String>)friendsList.clone(); 
    }
        public User(String email,String pass,String name,char gender,GregorianCalendar date,
            int height,float weight,String favoriteActivity)
    {
        super(email,pass,name,gender,date);
        this.height=height;
        this.weight=weight;
        this.favoriteActivity=favoriteActivity;
        this.userActivities=new TreeSet<Activity>();
        this.friendsList=new TreeSet<String>(); 
    }
       
    public User(User u){
        super(u.getEmail(), u.getPassword(), u.getName(), u.getGender(), u.getDate());
        this.height=u.getHeight();
        this.weight=u.getWeight();
        this.favoriteActivity=u.getFavoriteActivity();
        this.userActivities=(TreeSet<Activity>)u.getUserActivities();
        this.friendsList=(TreeSet<String>)u.getFriendsList();
        
    }
    
    public int getHeight(){
        return this.height;
    }
    public float getWeight(){
        return this.weight;
    }
    public String getFavoriteActivity(){
        return this.favoriteActivity;
    }
    public Set<Activity> getUserActivities(){
        TreeSet<Activity> res= new TreeSet<Activity>();
        for(Activity act : this.userActivities)
            res.add(act.clone());
    return res;
    }
    
    public Set<String> getFriendsList(){
        return (TreeSet<String>)this.friendsList.clone();
    }
    
    public void setHeight(int height){
        this.height=height;
    }
    public void setWeight(float weight){
        this.weight=weight;
    }
    public void setFavoriteActivity(String favorite){
        this.favoriteActivity=favorite;
    }
    
    
    
    
    public Activity getOneActivity(String name){
   
             Activity act;
             boolean found=false;
             Iterator<Activity> it=this.userActivities.iterator();
             act=it.next();
             while(it.hasNext() && !found)
                if(act.getName().equals(name))
                    found=true;
                 else
                    act=it.next();
                          
              
             return act;      //PODE RETURNAR NULL||||
        }
            
    


    public boolean addActivity(Activity act){ /// TEm que escolher o tipo de actividade e depois addicionar
       return this.userActivities.add(act);
    }
    
 
    
     public boolean addFriend(User u){              //Adiciona amigos a lista
       boolean flag=false,found=false;     
       flag=this.friendsList.add(u.getName());             
       
       return flag;     
    }
    
    public boolean removeActivity(String activityName){
        boolean found=false;
        boolean flag = false;
        Iterator<Activity> it=this.userActivities.iterator();
        Activity act=it.next();
        while(it.hasNext() && !found)
            if(act.getName().equals(activityName))
            {
                flag=this.userActivities.remove(act);
                found=true;
            }
        return flag;
        
    }
    
    
    
    //Metodos Para admin
    public Set<Activity> getUserActivitiesAdmin(){
        return this.userActivities;
    }
    
    public Set<String> getFriendsListAdmin(){
        
        return this.friendsList; 
    }
    
    
    
   

    
    //Equals,toString e Clone
    
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if((o==null)|| (this.getClass() !=o.getClass()))
            return false;
        else{
            User u = (User) o;
            return( super.equals(u) 
                    && this.height==u.getHeight() 
                    && this.weight==u.getWeight()
                    && this.favoriteActivity.equals(u.getFavoriteActivity()) 
                    && this.friendsList.equals(u.getFriendsList())
                    && this.userActivities.equals(u.getUserActivities()) );                   
        }
        
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        
        sb.append(super.toString());
        sb.append("Height: ");sb.append(this.height).append("\n");
        sb.append("Weight: ");sb.append(this.weight).append("\n");
        sb.append("Favorite Activity: ");sb.append(this.favoriteActivity).append("\n");
        sb.append("Friends List: ").append("\n");
        for(String s :this.getFriendsList())
            sb.append(s).append("\n");
        for(Activity act: this.userActivities)
            sb.append(act.toString());
               
        return sb.toString();      
        
        
    }
    
    @Override
    public User clone(){
        return new User(this);
    }
}


