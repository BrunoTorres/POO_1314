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
    private double duration;
    private TreeSet<User> participantsList;
    private TreeSet<Ranking> ranking;
    private TreeSet<Ranking> desistentes;
    private TreeSet<Simulacao> simula;

    public Event() {
        this.name = "";
        this.tipoActivity = "";
        this.location = "";
        this.maxParticipants = 0;
        this.participants = 0;
        this.date=new GregorianCalendar();
        this.deadline = new GregorianCalendar();
        this.duration = 0;
        this.participantsList = new TreeSet<>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes=new TreeSet<>(new CompareRankingByKm());
        this.simula=new TreeSet<>(new CompareSimulacao());
    }

    public Event(String name, String tipoActivity, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = participants;
        this.date=(GregorianCalendar)date.clone();
        this.deadline = (GregorianCalendar)deadline.clone();
        this.duration = duration;
        this.participantsList = new TreeSet<User>(new ComparePersonByName()); 
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes=new TreeSet<>(new CompareRankingByKm());
        this.simula=new TreeSet<>(new CompareSimulacao());
       // this.participantsList.addAll(participantsList);
       // this.ranking = new TreeSet<Activity>(new CompareactivityByTime()); 
      //  this.ranking.addAll(ranking);

    }

    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.date=(GregorianCalendar)date.clone();
        this.deadline = (GregorianCalendar)deadline.clone();
        this.duration = duration;
         this.participants = 0;
        //this.participantsList = participantsList;
        this.participantsList = new TreeSet<User>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes=new TreeSet<>(new CompareRankingByKm());
        this.simula=new TreeSet<>(new CompareSimulacao());
       // this.participantsList.addAll(participantsList);
       // this.ranking = new TreeSet<Activity>(new CompareactivityByTime());
       // this.ranking.addAll(ranking);
    }

    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = 0;
        this.date=(GregorianCalendar)date.clone();
        this.deadline = (GregorianCalendar)deadline.clone();
        this.duration = duration;
        this.participantsList = new TreeSet<User>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes=new TreeSet<>(new CompareRankingByKm());
        this.simula=new TreeSet<>(new CompareSimulacao());

    }

    public Event(Event e) {
        this.name = e.getName();
        this.tipoActivity = e.getTipoActivity();
        this.location = e.getLocation();
        this.maxParticipants = e.getMaxParticipants();
        this.participants = e.getParticipants();
        this.deadline = e.getDeadline();
        this.date=e.getDate();
        this.duration = e.getDuration();
        this.participantsList = e.getParticipantsList();
        this.ranking =e.getRanking();
        this.desistentes=e.getDesistentes();
        this.simula=e.getSimulacao();
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

     public GregorianCalendar getDate() {
        return this.date;
    }
    public GregorianCalendar getDeadline() {
        return this.deadline;
    }

    public double getDuration() {
        return this.duration;
    }

    public TreeSet<User> getParticipantsList() {
        TreeSet<User> aux = new TreeSet<User>(new ComparePersonByName());
        for (User u : this.participantsList) {
            aux.add(u.clone());
        }
        return aux;
    }

    public TreeSet<Ranking> getRanking() {
        TreeSet<Ranking> aux = new TreeSet<>(new CompareRankingByTime());
        for (Ranking r : this.ranking) {
            aux.add(r.clone());
        }
        return aux;

    }
    public TreeSet<Ranking> getDesistentesAdmin() {
       return this.desistentes;
    }
    public TreeSet<Simulacao> getSimulacaoAdmin() {
        return this.simula;
    }
    
    public TreeSet<Ranking> getDesistentes() {
        TreeSet<Ranking> aux = new TreeSet<>(new CompareRankingByKm());
        for (Ranking r : this.desistentes) {
            aux.add(r.clone());
        }
        return aux;

    }
    
    public TreeSet<Simulacao> getSimulacao() {
       TreeSet<Simulacao> aux =new TreeSet<>(new CompareSimulacao());
       for(Simulacao s:this.simula)
           aux.add(s.clone());
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

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setMaxParticipants(int max) {
        this.maxParticipants = max;
    }
    
    
    public void addUser(User u) {
        this.participantsList.add(u.clone());
        this.participants+=1;
    }
    
    public void addRanking(User u,double time){
        Ranking r=new Ranking(u,time);
        this.ranking.add(r);
    }
    
    public void addDesistente(User u,int km){
        Ranking r=new Ranking(u,km);
        this.desistentes.add(r);
    }
    
    public void addSimulacao(Simulacao s){
        this.simula.add(s);
    }

    
    
    public String getClassificacaoGeral(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Classificação: ").append("\n");
        int i=0;
        for(Ranking r:this.ranking){
            sb.append(i).append(": ").append(r.toString()).append("\n");
            i++;
        }
        for(Ranking r:this.desistentes){
            sb.append(i).append(": ").append(r.toString()).append("\n");
            i++;
        }
        
          return sb.toString();  
        
    }
    //toString ,equals,clone
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do evento : ").append(this.name).append("\n");
        sb.append("Tipo do evendo : ").append(this.tipoActivity).append("\n");
        sb.append("Localização do evendo : ").append(this.location).append("\n");
        sb.append("Nº max de participantes : ").append(this.maxParticipants).append("\n");
        sb.append("Nº de participantes: ").append(this.participantsList.size()).append("\n");
        sb.append("Data do evento: ");
        sb.append(this.date.get(Calendar.DAY_OF_MONTH)).append(" / ");
        sb.append(this.date.get(Calendar.MONTH)).append(" / ");
        sb.append(this.date.get(Calendar.YEAR)).append("\n");
        sb.append("Data limite de inscrição ");
        sb.append(this.deadline.get(Calendar.DAY_OF_MONTH)).append(" / ");
        sb.append(this.deadline.get(Calendar.MONTH)).append(" / ");
        sb.append(this.deadline.get(Calendar.YEAR)).append("\n");
        sb.append("Duração do evento ");
        sb.append(this.duration).append(" (min) \n");
        for (User u : this.participantsList) {
          sb.append(u.getName()).append("\n");
        }
       // for (Ranking r : this.ranking) {
       //     sb.append(r.toString());
       // }
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
                    && this.duration==e.getDuration()
                    && this.participantsList.equals(e.getParticipantsList())
                    && this.ranking.equals(e.getRanking())
                    && this.desistentes.equals(e.getDesistentes())
                    && this.simula.equals(e.getSimulacao()));
        }
    }

    @Override
    public abstract Event clone();

   
}
