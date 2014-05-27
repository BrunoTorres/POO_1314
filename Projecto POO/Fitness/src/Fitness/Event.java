package Fitness;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public abstract class Event {

    private String name;
    private String tipoActivity;                //running ....  passar os tipos "Running" em trail e assim?!
    private String location;
    private int maxParticipants;
    private int participants;
    private GregorianCalendar deadline;
    private GregorianCalendar date;
    private GregorianCalendar duration;
    private TreeSet<User> participantsList;
    private TreeSet<Activity> ranking;

    public Event() {
        this.name = "";
        this.tipoActivity = "";
        this.location = "";
        this.maxParticipants = 0;
        this.participants = 0;
        this.deadline = new GregorianCalendar();
        this.duration = new GregorianCalendar();
        this.participantsList = new TreeSet();
        this.ranking = new TreeSet();

    }

    public Event(String name, String tipoActivity, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, GregorianCalendar duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {

        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = participants;
        this.deadline = deadline.clone();
        this.duration = duration.clone();
        this.participantsList = new TreeSet<User>(new ComparePersonByName()); this.participantsList.addAll(participantsList);
        this.ranking = new TreeSet<Activity>(new ComparePersonByTime()); this.ranking.addAll(ranking);

    }

    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, GregorianCalendar duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.deadline = deadline;
        this.duration = duration;
        this.participantsList = participantsList;
        this.participantsList = new TreeSet<User>(participantsList);
        this.ranking = new TreeSet<Activity>(ranking);
    }

    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date,
            GregorianCalendar duration) {

        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = 0;
        this.deadline = deadline;
        this.duration = duration;
        this.participantsList = new TreeSet();
        this.ranking = new TreeSet();

    }

    public Event(Event e) {

        this.name = e.getName();
        this.tipoActivity = e.getTipoActivity();
        this.location = e.getLocation();
        this.maxParticipants = e.getMaxParticipants();
        this.participants = e.getParticipants();
        this.deadline = e.getDeadline();
        this.duration = e.getDuration();
        this.participantsList = e.getParticipantsList();
        this.ranking = e.getRanking();

    }

    public String getName() {
        return this.name;
    }

    public String getTipoActivity() {
        return this.tipoActivity;
    }

    public String getLocation() {
        return this.location;
    }

    public int getMaxParticipants() {
        return this.maxParticipants;
    }

    public int getParticipants() {
        return this.participants;
    }

    public GregorianCalendar getDeadline() {
        return this.deadline;
    }

    public GregorianCalendar getDuration() {
        return this.duration;
    }

    public TreeSet<User> getParticipantsList() {
        TreeSet<User> aux = new TreeSet();
        for (User u : this.participantsList) {
            aux.add(u.clone());
        }
        return aux;
    }

    public TreeSet<Ranking> getRanking() {
        TreeSet<Ranking> aux = new TreeSet();
        for (Ranking r : this.ranking) {
            aux.add(r.clone());
        }
        return aux;

    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDeadline(GregorianCalendar deadline) {
        this.deadline = deadline;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setDuration(GregorianCalendar duration) {
        this.duration = duration;
    }

    public void addUser(User u) {
        this.participantsList.add(u);
    }

    public void setMaxParticipants(int max) {
        this.maxParticipants = max;
    }

    //toString ,equals,clone
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome do evento : ").append(this.name).append("\n");
        sb.append("Tipo do evendo : ").append(this.tipoActivity).append("\n");
        sb.append("Localização do evendo : ").append(this.location).append("\n");
        sb.append("Nº max de participantes : ").append(this.maxParticipants).append("\n");
        sb.append("Nº de participantes: ").append(this.participants).append("\n");
        sb.append("Data do evento: ");
        sb.append(this.date.get(Calendar.DAY_OF_MONTH)).append(" / ");;
        sb.append(this.date.get(Calendar.MONTH)).append(" / ");
        sb.append(this.date.get(Calendar.YEAR)).append("\n");
        sb.append("Data limite de inscrição ");
        sb.append(this.deadline.get(Calendar.DAY_OF_MONTH)).append(" / ");;
        sb.append(this.deadline.get(Calendar.MONTH)).append(" / ");
        sb.append(this.deadline.get(Calendar.YEAR)).append("\n");
        sb.append("Duração do evento ");
        sb.append(this.duration.get(Calendar.HOUR)).append(" / ");;
        sb.append(this.duration.get(Calendar.MINUTE)).append(" / ");
        sb.append(this.duration.get(Calendar.SECOND)).append("\n");

        for (User u : this.participantsList) {
            sb.append(u.getName()).append("\n");
        }
        for (Ranking r : this.ranking) {
            sb.append(r.toString());
        }

        return sb.toString();

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        } else {
            Event e = (Event) o;
            return (this.name.equals(e.getName())
                    && this.tipoActivity.equals(e.getTipoActivity())
                    && this.location.equals(e.getLocation())
                    && this.maxParticipants == e.getMaxParticipants()
                    && this.participants == e.getParticipants()
                    && this.deadline.equals(e.getDeadline())
                    && this.duration.equals(e.getDuration())
                    && this.participantsList.equals(e.getParticipantsList())
                    && this.ranking.equals(this.getRanking()));

        }

    }

    @Override
   public abstract Event clone();
   
}
