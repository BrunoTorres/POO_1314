package Fitness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe principal da actividade.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class FitnessUM implements Serializable {

	//private DataBase db;
	private Person p;
	private TreeSet<Person> userList;  // admin && users
	private ArrayList<Event> events;      /// mostrar no inicio criar funcao que ver se ja foi o evento 

	/**
	 * Construtor vazio.
	 */
	public FitnessUM() {
		// this.db = new DataBase();
		this.userList = new TreeSet<Person>(new ComparePersonByName());
		this.events = new ArrayList<>();
	}

	/**
	 * Construtor de cópia.
	 *
	 * @param um instância de FitnessUm.
	 */
	public FitnessUM(FitnessUM um) {
		this.p = um.getActivePerson();
		this.userList = (TreeSet<Person>) um.getUserList();
		this.events = (ArrayList<Event>) um.getEvents();
	}

	/**
	 * Método que devolve um administrador.
	 *
     * @param email
	 * @return Administrador procurado.
	 */
	public Admin getAdminByEmail(String email) {
		boolean found = false;
		Admin a = new Admin();
		Iterator<Person> it = this.userList.iterator();
		while (it.hasNext() && !found) {
			Person per = it.next();
			if ((per.getEmail().equals(email)) && (per instanceof Admin)) {
				a = (Admin) per;
				found = true;
			}
		}
		return a;
	}

	/**
	 * Método que devolve a lista de eventos.
	 *
	 * @return List de Event.
	 */
	public List<Event> getEvents() {
		ArrayList<Event> aux = new ArrayList<>();
		for (Event e : this.events) {
			aux.add(e);
		}
		return aux;
	}

	/**
	 * Método que devolve a lista de eventos que ainda não ocorreram e ainda têm vagas disponíveis.
	 *
	 * @return List de Event.
	 */
	public List<Event> getOpenEvents() {
		ArrayList<Event> aux = new ArrayList<>();
		GregorianCalendar now = new GregorianCalendar();
		for (Event e : this.events) {
			if (e.getDate().after(now) && e.getParticipants() < e.getMaxParticipants()) {
				aux.add(e);
			}
		}
		return aux;
	}

	/**
	 * Método que devolve a lista de eventos que já ocorreram.
	 *
	 * @return List de Event.
	 */
	public List<Event> getOccurredEvents() {
		ArrayList<Event> aux = new ArrayList<>();
		GregorianCalendar now = new GregorianCalendar();
		for (Event e : this.events) {
			if (e.getDate().before(now) && !e.getSimulacao().isEmpty()) {
				aux.add(e.clone());
			}
		}
		return aux;
	}

	/**
	 * Método que devolve a lista de eventos que precisam de simulação.
	 *
	 * @return List de Event.
	 */
	public List<Event> getSimulaEvents() {
		ArrayList<Event> aux = new ArrayList<>();
		GregorianCalendar now = new GregorianCalendar();
		for (Event e : this.events) {
			if (e.getDate().before(now) && e.getSimulacao().isEmpty()) {
				aux.add(e);
			}
		}
		return aux;
	}

	/**
	 * Método que devolve um set contendo todos os utilizadores e administradores.
	 *
	 * @return Set de Person.
	 */
	public Set<Person> getUserList() {
		TreeSet<Person> aux = new TreeSet<Person>(new ComparePersonByName());
		for (Person p : this.userList) {
			aux.add(p.clone());
		}
		return aux;
	}

	/**
	 * Método que devolve quantas atividades estão registadas na aplicação.
	 *
	 * @return número de atividades registadas.
	 */
	public int getNumActivities() {
		int num = 0;
		TreeSet<Person> persons = new TreeSet<>(new ComparePersonByName());
		persons.addAll(this.getUserList());
		for (Person p : persons) {
			if (p instanceof User) {
				User u = (User) p;
				num += u.getActivities().size();
			}
		}

		return num;
	}

	/**
	 * Método que devolve quantos Users estão registados na aplicação.
	 *
	 * @return número de Users registados.
	 */
	public int getNumUsers() {
		int num = 0;
		ArrayList<Person> persons = new ArrayList<>(this.getUserList());
		for (Person p : persons) {
			if (p instanceof User) {
				num++;
			}
		}

		return num;
	}

	/**
	 * Método que devolve quantos Events precisam de ser simulados.
	 *
	 * @return número de Events a ser simulados.
	 */
	public int getNumSimulaEvents() {
		int num = 0;
		GregorianCalendar now = new GregorianCalendar();
		for (Event e : this.events) {
			if (e.getDate().before(now) && e.getSimulacao().isEmpty()) {
				num++;
			}
		}

		return num;
	}

	/**
	 * Método que adiciona um user a lista de user e administradores.
	 *
	 * @param u Utilizador a ser adicionado
	 * @return true ou false,caso consiga ou não adicionar o user.
	 */
	public boolean addUserByUser(User u) {
		return this.userList.add(u);
	}

	@Override
	public FitnessUM clone() {
		return new FitnessUM(this);
	}

	//////////////SIMULAÇAO//////////////////////
	/**
	 * Método que simula um evento,km a km e mostrando no fim a classificação final.
	 *
	 * @param e Evento.
	 * @param weather Clima.
	 * @param temperatura Temperatura no evento.
	 * @return string com a descrição da simulação do evento
	 */
	public String simulaEvent(Event e, String weather, double temperatura) {
		double distance = 0;
		String tipo = "";
		int tipoEvento = 0;
		boolean desistentes = false;

		if (e instanceof Marathon) {
			distance = 42.195;
			tipo = "Marathon";
			tipoEvento = 1;
		} else if (e instanceof Halfmarathon) {
			distance = 21.1;
			tipo = "Halfmarathon";
			tipoEvento = 2;
		} else if (e instanceof MarathonBTT) {
			MarathonBTT btt = (MarathonBTT) e;
			distance = btt.getDistance();
			tipo = "MarathonBTT";
			tipoEvento = 3;
		} else if (e instanceof Trail) {
			Trail trail = (Trail) e;
			distance = trail.getDistance();
			tipo = "Trail";
			tipoEvento = 4;
		}
		for (User u : e.getParticipantsList()) {
			double tempo = u.formula(weather, temperatura, tipo, distance);
			int km = (int) u.kmDesisteM(distance) + 1;
			Simulacao s = new Simulacao(u, tempo, km);
			e.addSimulacao(s);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= (int) distance && !desistentes; i++) {
			for (Simulacao s : e.getSimulacao()) {
				if (s.getKmDesiste() == i) {
					Ranking r = new Ranking(s.getUser(), i);
					e.getDesistentesAdmin().add(r);
					e.getSimulacaoAdmin().remove(s);
				} else {
					e.getSimulacaoAdmin().remove(s);
					s.actualiza(1);
					e.getSimulacaoAdmin().add(s);
				}
			}
			int j = 1;
			sb.append("Km: ").append(i).append("\n");
			sb.append("Classificaçao: ").append("\n");
			for (Simulacao s : e.getSimulacao()) {
				sb.append(j).append(": ").append(s.toString()).append("\n");
				j++;
			}
			for (Ranking r : e.getDesistentes()) {
				if (r.getKm() == i) {
					sb.append(j).append(": ").append(r.toStringDesiste()).append("\n");
				}
			}

			if (e.getSimulacao().isEmpty()) {
				desistentes = true;
			}
		}
		for (Simulacao s : e.getSimulacaoAdmin()) {
			if (tipoEvento == 1) {
				double aux = s.getTempoMedio() * 0.195;
				aux += s.getTempoGeral();
				e.addRanking(s.getUser(), aux);
			} else if (tipoEvento == 2) {
				double aux = s.getTempoMedio() * 0.1;
				aux += s.getTempoGeral();
				e.addRanking(s.getUser(), aux);
			} else {
				e.addRanking(s.getUser(), s.getTempoGeral());
			}

		}

		sb.append(e.getClassificacaoGeral());
		return sb.toString();

	}

	//////////EVENTS////////////////////////////////////////////
	/**
	 * Método que adiciona um evento a lista de eventos.
	 *
	 * @param e Evento a adicionar.
	 */
	public void addEvent(Event e) {
		this.events.add(e);
	}

	/**
	 * Método que adiciona um evento do tipo Marathon a lista de eventos.
	 *
	 * @param name Nome do evento.
	 * @param location Localização do evento.
	 * @param maxParticipants Número máximo de participantes.
	 * @param deadline Data limite de inscrição.
	 * @param date Data do evento.
	 */
	public void addMarathon(String name, String location, int maxParticipants,
			GregorianCalendar deadline, GregorianCalendar date) {

		Event e = new Marathon(name, location, maxParticipants, deadline, date);
		this.events.add(e);
	}

	/**
	 *
	 * Método que adiciona um evento do tipo Halfmarathon a lista de eventos.
	 *
	 * @param name Nome do evento.
	 * @param location Localização do evento.
	 * @param maxParticipants Número máximo de participantes.
	 * @param deadline Data limite de inscrição.
	 * @param date Data do evento.
	 */
	public void addHalfmarathon(String name, String location, int maxParticipants,
			GregorianCalendar deadline, GregorianCalendar date) {

		Event e = new Halfmarathon(name, location, maxParticipants, deadline, date);
		this.events.add(e);
	}

	/**
	 * Método que adiciona um evento do tipo MarathonBTT a lista de eventos.
	 *
	 * @param name Nome do evento.
	 * @param location Localização do evento.
	 * @param maxParticipants Número máximo de participantes.
	 * @param deadline Data limite de inscrição.
	 * @param date Data do evento.
	 * @param distance Distancia do evento.
	 */
	public void addMarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline,
			GregorianCalendar date, double distance) {

		Event e = new MarathonBTT(name, location, maxParticipants, deadline, date, distance);
		this.events.add(e);
	}

	/**
	 * Método que adiciona um evento do tipo Trail a lista de eventos.
	 *
	 * @param name Nome do evento.
	 * @param location Localização do evento.
	 * @param maxParticipants Número máximo de participantes.
	 * @param deadline Data limite de inscrição.
	 * @param date Data do evento.
	 * @param distance Distancia do evento.
	 */
	public void addTrail(String name, String location, int maxParticipants, GregorianCalendar deadline,
			GregorianCalendar date, double distance) {

		Event e = new Trail(name, location, maxParticipants, deadline, date, distance);
		this.events.add(e);
	}

	/**
	 * Método que procura um evento pelo seu nome.
	 *
	 * @param name Nome do evento a procurar.
	 * @return Event.
     * @throws Fitness.EventNotFoundException lança exceção se o evento não existe.
	 */
	public Event getEventByName(String name) throws EventNotFoundException {       // VER MELHOR!! SE NAO HOUVER O EVENTO RETORNAR O QUE?!
		for (Event e : this.getEvents()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}

		throw new EventNotFoundException(name);
	}

	private boolean findRunning(User u) {
		boolean flag, found;
		flag = found = false;

		Iterator<Activity> it = u.getActivities().iterator();
		while (it.hasNext() && !found) {
			if (it.next() instanceof Running) {
				flag = true;
				found = true;
			}
		}
		return flag;
	}

	private boolean findMountainBiking(User u) {
		boolean flag, found;
		flag = found = false;

		Iterator<Activity> it = u.getActivities().iterator();
		while (it.hasNext() && !found) {
			if (it.next() instanceof MountainBiking) {
				flag = true;
				found = true;
			}
		}
		return flag;
	}
	//adiciona um user a um evento se ja praticou se a data de termino ainda nao foi atingida e se o nº max de par ainda nao foi atingido 

	/**
	 * Método que adiciona um user a um evento se: já tiver praticado,se a data de termino e o número máximo de participantes ainda não tiverem sido atingidos.
	 *
	 * @param u Utilizador a registar.
	 * @param e Evento onde se vai registar o user.
	 * @return true se adicionou o user,false caso contrário.
	 */
	public boolean userRegistEvent(User u, Event e) {
		GregorianCalendar date = new GregorianCalendar();
		String tipo = e.getTipoActivity();

		if ((userRegistaEventoSeFezActivity(u, tipo)) && (e.getDeadline().after(date))
				&& (e.getMaxParticipants() > (e.getParticipants() + 1))) {
			e.addUser(u);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que verifica se o user já praticou o tipo de actividade "Running" ou " MountainBiking".
	 *
	 * @param u User
	 * @param tipoEvento Tipo do evento
	 * @return true se o user já particou o tipo de actividade do evento,false caso contrário.
	 */
	private boolean userRegistaEventoSeFezActivity(User u, String tipoEvento) {

		boolean flag;
		switch (tipoEvento) {
			case "Running":
				flag = findRunning(u);
				break;
			case "MountainBiking":
				flag = findMountainBiking(u);
				break;
			default:
				return false;
		}
		return flag;
	}

	/**
	 * Método que remove um user de um evento se pertencer à lista de participantes.
	 *
	 * @param u Utilizador a remover.
	 * @param e Evento onde de onde User será removido.
	 * @return true se removeu o user, false caso contrário.
	 */
	public boolean removeRegistEvent(User u, Event e) {
		return e.removeUser(u);
	}

	//////////////////////////     Gerenciamento da aplicação /////////////////////////////////////////////////
	/**
	 * Método que devolve a referencia de uma pessoa,(pessoa que está logada na aplicação)
	 *
	 * @return Person logada.
	 */
	public Person getActivePerson() {
		return this.p;
	}

    /**
     * Método para alterar o utilizador logado.
     * @param p Pessoa nova a ser logada.
     */
    public void setFitnessPerson(Person p) {
		if (p instanceof User) {
			this.p = (User) p;
		} else {
			this.p = (Admin) p;
		}
	}

	/**
	 * Método que procura um utilizador pelo email.
	 *
	 * @param email Email.
	 * @return User.
	 */
	public User getUserByEmail(String email) {
		boolean found = false;
		User u = new User();
		Iterator<Person> it = this.userList.iterator();
		while (it.hasNext() && !found) {
			Person per = it.next();
			if ((per.getEmail().equals(email)) && (per instanceof User)) {
				u = (User) per;
				found = true;
			}
		}
		return u;
	}

	/**
	 * Método que procura utilizadores e administradores pelo email e palavra-passe.
	 *
	 * @param email Email
	 * @param pass Palavra-passe.
	 * @return true se encontrou,false caso contrário.
	 */
	public boolean existPassAndUser(String email, String pass) {                               //////////////////////////////////////////////            

		boolean found = false;
		Iterator<Person> it = this.userList.iterator();

		while (it.hasNext() && !found) {
			Person per = it.next();
			if (email.equals(per.getEmail()) && pass.equals(per.getPassword())) {
				found = true;
			}
		}
		return found;
	}

	/**
	 * Método que procura a existência de um utilizador ou administrador pelo email.
	 *
	 * @param email Email.
	 * @return true se encontrou , false caso contrário.
	 */
	public boolean existPerson(String email) {
		boolean flag = false;
		boolean found = false;

		Iterator<Person> it = this.userList.iterator();

		while (it.hasNext() && !found) {
			Person per = it.next();
			if (per.getEmail().equals(email)) {
				found = true;
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * Método que procura por email se uma dada pessoa é administrador.
	 *
	 * @param email email.
	 * @return true caso seja,false caso não seja.
	 */
	public boolean isAdmin(String email) {

		boolean flag = false;
		boolean found = false;

		Iterator<Person> it = this.userList.iterator();

		while (it.hasNext() && !found) {
			Person per = it.next();
			if ((per.getEmail().equals(email)) && (per instanceof Admin)) {
				found = true;
				flag = true;
			}
		}

		return flag;

	}

	/**
	 * Método que adiciona um user a lista.
	 *
	 * @param email Email.
	 * @param pass Palavra-passe.
	 * @param name Nome.
	 * @param gender Género.
	 * @param date Data de Nascimento.
	 * @param height Altura.
	 * @param weight Peso.
	 * @param favoriteActivity Actividade favorita.
	 * @return true se conseguiu adicionar,false caso contrário.
	 */
	public boolean addUser(String email, String pass, String name, char gender, GregorianCalendar date,
			int height, double weight, String favoriteActivity) {
		boolean flag;
		User u = new User(email, pass, name, gender, date, height, weight, favoriteActivity);
		flag = this.userList.add(u);

		return flag;

	}

	/**
	 * Método que adiciona um administrador a lista.
	 *
	 * @param email Email.
	 * @param pass Palavra-passe.
	 * @param name Nome.
	 * @param gender Género.
	 * @param date Data de Nascimento.
	 * @return true se conseguiu adicionar,false caso contrário.
	 */
	public boolean addAdmin(String email, String pass, String name, char gender, GregorianCalendar date) {
		boolean flag;
		Admin admin = new Admin(email, pass, name, gender, date);
		flag = this.userList.add(admin);

		return flag;

	}

    /////////////////////////////////////////////////Propriedade dos Utilizadores//////////////////////////////////////
	////////////////////////////////!!!FRIEND!!!//////////////////////////////////////////////////
	/**
	 * Método para enviar um pedido de amizade.
	 *
	 * @param user User a qual se envia o pedido.
	 * @param friendWhoSendsRequest User que envia o pedido.
	 */
	public void sendFriendRequest(User user, User friendWhoSendsRequest) {
		user.addFriendToMessage(friendWhoSendsRequest.getEmail());

	}

	/**
	 * Método que procura se existe algum pedido de amizade.
	 *
	 * @param u User.
	 * @return true se exite,false caso contrário.
	 */
	public boolean existsFriendToAdd(User u) {

		return (!((ArrayList<String>) u.getMessage()).isEmpty());

	}

	/**
	 * Método para aceitar um user como amigo.
	 *
	 * @param u User que vai aceitar.
	 * @param email Email do amigo que enviou o pedido de amizade.
	 */
	public void acceptFriend(User u, String email) {

		User amigo = getUserByEmail(email);
		u.addFriend(amigo);
		amigo.addFriend(u);

	}

	/**
	 * Método que devolve as ultimas 10 actividades de um user.
	 *
	 * @param u User.
	 * @return Set de Activity.
	 */
	public Set<Activity> getLast10ActivitiesByActivity(User u) {
		TreeSet<Activity> aux = new TreeSet<>(new CompareActivity());
		Iterator<Activity> it = u.getActivities().iterator();
		for (int i = 0; i < 10 && it.hasNext(); i++) {
			aux.add(it.next());
		}
		return aux;
	}

	/**
	 * Método que devolve o nome das últimas 10 actividades de um user.
	 *
	 * @param u Utilizador a qual se vai pesquisar as ultimas 10 actividades.
	 * @return Set de string com o nome das actividades.
	 */
	public Set<String> getLast10Activities(User u) {
		TreeSet<String> aux = new TreeSet<>();
		Iterator<Activity> it = u.getActivities().iterator();
		for (int i = 0; i < 10 && it.hasNext(); i++) {
			aux.add(it.next().getName());
		}
		return aux;
	}

	/////// VE TODAS AS ACTIVIDADES DE TODOS OS AMIGOS ///////////////////////////
	/**
	 * Método que constrói uma String com a informação dos amigos de uma lista de utilizadores.
	 *
	 * @param users Set de user.
	 * @return String.
	 */
	public String FriendToString(Set<User> users) {
		StringBuilder sb = new StringBuilder();

		for (User friend : users) {
			sb.append("Name Friend: ");
			sb.append(friend.getName()).append("\n");
			sb.append("Favorite Activity: ");
			sb.append(friend.getFavoriteActivity()).append("\n");
			sb.append("Activities").append("\n");
			sb.append(friend.getActivities().toString());

		}
		return sb.toString();
	}

    /**
     * Método para procurar por todos os amigos do utilizador.
     * @param u Utilizador a qual se vai pesquisar os amigos.
     * @return String com todos os amigos.
     */
    public String seeAllFriend(User u) {
		TreeSet<Person> dbUsers = (TreeSet<Person>) this.getUserList();
		TreeSet<User> users = new TreeSet<>();

		for (String s : u.getFriendsList()) {
			boolean found = false;
			Iterator<Person> it = dbUsers.iterator();
			while (it.hasNext() && !found) {
				Person per = it.next();
				if (per.getName().equals(s)) {
					users.add((User) per);
				}
			}

		}

		return (FriendToString(users));

	}

    //Ver Actividade de um dado amigo //
	//Lista amigos,escolhe amigo        --
	/**
	 * Método que cria uma string com todos os emails dos amigos.
	 *
	 * @param u User.
	 * @return String.
	 */
	public String listAllFriends(User u) {
		TreeSet<String> s = (TreeSet<String>) u.getFriendsList();

		return s.toString();
	}

	//Lista Activity do amigo 
	/**
	 * Método que cria uma string com as actividades dos amigos.
	 *
	 * @param u User.
	 * @return String.
	 */
	public String allActivitiesFriend(User u) {
		StringBuilder sb = new StringBuilder();
		for (Activity act : u.getActivities()) {
			sb.append(act.toString());
		}

		return sb.toString();

	}

    //
	// Recebe nome da activityList e User Friend procura essa activity e lista 
	/**
	 * Método que cria uma string com a informação de uma dada actividade.
	 *
	 * @param u User.
	 * @param activity Actividade.
	 * @return String.
	 */
	public String seeOneActivityList(User u, String activity) {
		return u.getOneActivity(activity).toString();

	}

	//////////////////////////////////// Propriedade dos Administradores//////////////////////////////////////////
	/**
	 * Método que remove um user da lista.
	 *
	 * @param email Email do user.
	 * @return true se conseguir eliminar,false caso contrario.
	 */
	public boolean removeUser(String email) {

		boolean flag = false;
		Iterator<Person> it = this.userList.iterator();
		while (it.hasNext()) {                                                          //melhorar RETIRAR FOR para Iterator!!!
			Person per = it.next();
			if (per instanceof User) {
				User u = (User) per;
				if (email.equals(u.getEmail())) {
					it.remove();
					flag = true;
				} else if (u.getFriendsList().contains(email)) //Remover user todas as ligas de amigos
				{
					flag = u.getFriendsListAdmin().remove(email);
				}
			}
		}
		return flag;

	}

	/**
	 * Método que remove uma actividade de todos os utilizadores.
	 *
	 * @param activity Actividade.
	 * @return true se removeu,false caso contrário.
	 */
	public boolean removeActivity(Activity activity) {
		boolean flag = false;

		for (Person per : this.userList) {
			if (per instanceof User) {
				User u = (User) per;
				flag = u.getUserActivitiesAdmin().remove(activity);

			}
		}
		return flag;

	}

	/**
	 * Método que remove uma actividade de todos os users.
	 *
	 * @param name Nome da actividade.
	 */
	public void removeActivityFromUser(String name) {

		for (Person per : this.userList) {
			if (per instanceof User) {
				boolean found = false;
				User u = (User) per;
				Iterator<Activity> it = u.getActivities().iterator();

				while (it.hasNext() && !found) {
					Activity aux = it.next();
					if (aux.getName().equals(name)) {
						found = true;
						u.getUserActivitiesAdmin().remove(aux);
					}
				}
			}
		}
	}
}
