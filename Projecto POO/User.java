import java.util.TreeSet;

public class User extends Person
{
    private int height; // centímetros
    private float weight; // kilogramas
    private String favoriteActivity;
    private TreeSet<ActivityList> userActivities; // cada atividade tem uma lista de eventos
    private TreeSet<String> friendsList;
    
}
