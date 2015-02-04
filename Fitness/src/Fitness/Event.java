package Fitness;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe abstracta para todos os eventos.
 *
 * @author Bruno Pereiras
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Event implements Serializable {

    private String name;
    private String tipoActivity;
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
	//private String 

    /**
     * Construtor vazio.
     */
    public Event() {
        this.name = "";
        this.tipoActivity = "";
        this.location = "";
        this.maxParticipants = 0;
        this.participants = 0;
        this.date = new GregorianCalendar();
        this.deadline = new GregorianCalendar();
        this.duration = 0;
        this.participantsList = new TreeSet<>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes = new TreeSet<>(new CompareRankingByKm());
        this.simula = new TreeSet<>(new CompareSimulacao());
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param tipoActivity - Tipo de Activity a que o evento pertence.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param participants - Numero de participantes inscritos.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - classificação final do Evento.
     */
    public Event(String name, String tipoActivity, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = participants;
        this.date = (GregorianCalendar) date.clone();
        this.deadline = (GregorianCalendar) deadline.clone();
        this.duration = duration;
        this.participantsList = new TreeSet<User>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes = new TreeSet<>(new CompareRankingByKm());
        this.simula = new TreeSet<>(new CompareSimulacao());

    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param tipoActivity - Tipo de Activity a que o evento pertence.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - classificação final do Evento.
     */
    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.date = (GregorianCalendar) date.clone();
        this.deadline = (GregorianCalendar) deadline.clone();
        this.duration = duration;
        this.participants = 0;
        this.participantsList = new TreeSet<User>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes = new TreeSet<>(new CompareRankingByKm());
        this.simula = new TreeSet<>(new CompareSimulacao());

    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param tipoActivity - Tipo de Activity a que o evento pertence.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - duração.
     */
    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = 0;
        this.date = (GregorianCalendar) date.clone();
        this.deadline = (GregorianCalendar) deadline.clone();
        this.duration = duration;
        this.participantsList = new TreeSet<User>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes = new TreeSet<>(new CompareRankingByKm());
        this.simula = new TreeSet<>(new CompareSimulacao());

    }

    /**
     * Construtor parametrizado.
     * @param name - Nome do Evento.
     * @param tipoActivity - Tipo de Activity a que o evento pertence.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     */
    public Event(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date) {
        this.name = name;
        this.tipoActivity = tipoActivity;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = 0;
        this.date = (GregorianCalendar) date.clone();
        this.deadline = (GregorianCalendar) deadline.clone();
        this.duration = 0;
        this.participantsList = new TreeSet<>(new ComparePersonByName());
        this.ranking = new TreeSet<>(new CompareRankingByTime());
        this.desistentes = new TreeSet<>(new CompareRankingByKm());
        this.simula = new TreeSet<>(new CompareSimulacao());

    }

    /**
     * Construtor de cópia.
     *
     * @param e - Objecto do tipo Evento.
     */
    public Event(Event e) {
        this.name = e.getName();
        this.tipoActivity = e.getTipoActivity();
        this.location = e.getLocation();
        this.maxParticipants = e.getMaxParticipants();
        this.participants = e.getParticipants();
        this.deadline = e.getDeadline();
        this.date = e.getDate();
        this.duration = e.getDuration();
        this.participantsList = (TreeSet<User>) e.getParticipantsList();
        this.ranking = (TreeSet<Ranking>) e.getRanking();
        this.desistentes = (TreeSet<Ranking>) e.getDesistentes();
        this.simula = (TreeSet<Simulacao>) e.getSimulacao();
    }

    /**
     * Método que devolve o nome do evento.
     *
     * @return String como nome.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve o tipo da actividade a que o evento pertence.
     *
     * @return String com o tipo.
     */
    public String getTipoActivity() {
        return this.tipoActivity;
    }

    /**
     * Método que devolve a localização do evento.
     *
     * @return String com a localização.
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Método que devolve o número máximo de participantes.
     *
     * @return Número máximo de participantes, inteiro.
     */
    public int getMaxParticipants() {
        return this.maxParticipants;
    }

    /**
     * Método que devolve o número de participantes registados no evento.
     *
     * @return Número de participantes, inteiro.
     */
    public int getParticipants() {
        return this.participants;
    }

    /**
     * Método que devolve a data do evento.
     *
     * @return GregorianCalendar.
     */
    public GregorianCalendar getDate() {
        return this.date;
    }

    /**
     * Método que devolve a data limite para as inscrições no evento.
     *
     * @return Data limite, GregorianCalendar.
     */
    public GregorianCalendar getDeadline() {
        return this.deadline;
    }

    /**
     * Método que devolve a duração do evento em minutos.
     *
     * @return Minutos, double.
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     * Método que devolve um set dos participantes inscritos no evento.
     *
     * @return Set de user.
     */
    public Set<User> getParticipantsList() {
        TreeSet<User> aux = new TreeSet<User>(new ComparePersonByName());
        for (User u : this.participantsList) {
            aux.add(u.clone());
        }
        return aux;
    }

    /**
     * Método que devolve um set com as classificações dos participantes, que não desistiram.
     *
     * @return Set de Ranking.
     */
    public Set<Ranking> getRanking() {
        TreeSet<Ranking> aux = new TreeSet<>(new CompareRankingByTime());
        for (Ranking r : this.ranking) {
            aux.add(r.clone());
        }
        return aux;

    }

    /**
     * Método que devolve a referência para o set com os participantes que desistiram.
     *
     * @return Set de Ranking.
     */
    public Set<Ranking> getDesistentesAdmin() {
        return this.desistentes;
    }

    /**
     * Método que devolve a referência para o set com as classificações dos participantes, que não desistiram.
     *
     * @return Set de Simulacao.
     */
    public Set<Simulacao> getSimulacaoAdmin() {
        return this.simula;
    }

    /**
     * Método que devolve um set com os participantes que desistiram.
     *
     * @return set de Ranking.
     */
    public Set<Ranking> getDesistentes() {
        TreeSet<Ranking> aux = new TreeSet<>(new CompareRankingByKm());
        for (Ranking r : this.desistentes) {
            aux.add(r.clone());
        }
        return aux;

    }

    /**
     * Método que devolve um set com o resultado de uma simulação do evento.
     *
     * @return set de Simulacao.
     */
    public Set<Simulacao> getSimulacao() {
        TreeSet<Simulacao> aux = new TreeSet<>(new CompareSimulacao());
        for (Simulacao s : this.simula) {
            aux.add(s.clone());
        }
        return aux;
    }

    /**
     * Método que altera a localização do evento.
     *
     * @param location String com a nova localização.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Método que altera a data limite do registo no evento.
     *
     * @param deadline - GregorianCalendar com a nova data limite.
     */
    public void setDeadline(GregorianCalendar deadline) {
        this.deadline = deadline;
    }

    /**
     * Método que altera a data do evento.
     *
     * @param date - GregorianCalendar com a nova data do evento.
     */
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    /**
     * Método que altera o número máximo de participantes.
     *
     * @param max- Inteiro com o novo máximo.
     */
    public void setMaxParticipants(int max) {
        this.maxParticipants = max;
    }

    /**
     * Método que adiciona um User ao evento.
     *
     * @param u- User a ser adicionado.
     */
    public void addUser(User u) {
        this.participantsList.add(u.clone());
        this.participants += 1;
    }
	
	/**
     * Método que remove um User ao evento.
     *
     * @param u- User a ser removido.
	 * @return true caso utilizador seja removido do evento, false caso contrário
     */
    public boolean removeUser(User u) {
        if (this.participantsList.remove(u)){
			this.participants--;
			return true;
		} else
			return false;
    }

    /**
     * Método que adiciona um user à lista de classificações do evento. Cria um novo Ranking com a informação, e adiciona a lista.
     *
     * @param u- User
     * @param time - Double do tempo em minutos.
     */
    public void addRanking(User u, double time) {
        Ranking r = new Ranking(u, time);
        this.ranking.add(r);
    }

    /**
     * Método adiciona um user ao set de desististes. Cria um novo Ranking com a informação, e adiciona ao set dos desistentes.
     *
     * @param u- User.
     * @param km- Km em que user desiste.
     */
    public void addDesistente(User u, int km) {
        Ranking r = new Ranking(u, km);
        this.desistentes.add(r);
    }

    /**
     * Método adiciona uma simulação ao evento.
     *
     * @param s - Simulacao
     */
    public void addSimulacao(Simulacao s) {
        this.simula.add(s);
    }

    /**
     * Método que devolve a classificação geral do evento.
     *
     * @return String com a classificação.
     */
    public String getClassificacaoGeral() {
        StringBuilder sb = new StringBuilder();

        sb.append("Classificação: ").append("\n");
        int i = 1;
        for (Ranking r : this.ranking) {

            sb.append(i).append(": ").append(r.toStringTime());
            i++;
        }
        for (Ranking r : this.desistentes) {
            sb.append(i).append(": ").append(r.toStringDesiste()).append("\n");
            i++;
        }

        return sb.toString();

    }

    //toString ,equals,clone
    @Override
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
        for (User u : this.participantsList) {
            sb.append(u.getName()).append("\n");
        }

        return sb.toString();
    }

    @Override
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
                    && this.participantsList.equals(e.getParticipantsList())
                    && this.ranking.equals(e.getRanking())
                    && this.desistentes.equals(e.getDesistentes())
                    && this.simula.equals(e.getSimulacao()));
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.tipoActivity);
        hash = 67 * hash + Objects.hashCode(this.location);
        hash = 67 * hash + this.maxParticipants;
        hash = 67 * hash + this.participants;
        hash = 67 * hash + Objects.hashCode(this.deadline);
        hash = 67 * hash + Objects.hashCode(this.participantsList);
        hash = 67 * hash + Objects.hashCode(this.ranking);
        hash = 67 * hash + Objects.hashCode(this.desistentes);
        hash = 67 * hash + Objects.hashCode(this.simula);
        return hash;
    }

    @Override
    public abstract Event clone();

}
