package Fitness;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public abstract class Event {

    private String name;
    private String tipoActivity;                //running ....
    private String location;
    private int maxParticipants;
    private int participants;
    private GregorianCalendar deadline;
    private GregorianCalendar date;
    private GregorianCalendar duration;
    private TreeSet<User> participantsList;
    private TreeSet<Ranking> ranking;

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

    public Event(String name, String tipoActivity, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date,
            GregorianCalendar duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {

        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = participants;
        this.deadline = deadline;
        this.duration = duration;
        this.participantsList = participantsList;
        this.ranking = ranking;

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

    private String getName() {
        return this.name;
    }

    private String getTipoActivity() {
        return this.tipoActivity;
    }

    private String getLocation() {
        return this.location;
    }

    private int getMaxParticipants() {
        return this.maxParticipants;
    }

    private int getParticipants() {
        return this.participants;
    }

    private GregorianCalendar getDeadline() {
        return this.deadline;
    }

    private GregorianCalendar getDuration() {
        return this.duration;
    }

    private TreeSet<User> getParticipantsList() {
        TreeSet<User> aux = new TreeSet();
        for (User u : this.participantsList) {
            aux.add(u.clone());
        }
        return aux;
    }

    private TreeSet<Ranking> getRanking() {
        TreeSet<Ranking> aux = new TreeSet();
        for (Ranking r : this.ranking) {
            aux.add(r.clone());
        }
        return aux;

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
