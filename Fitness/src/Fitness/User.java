package Fitness;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Classe referente aos utilizadores.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014no
 */
public class User extends Person implements Serializable {

	private int height; // centímetros
	private double weight; // kilogramas
	private String favoriteActivity;
	private TreeSet<Activity> userActivities;
	private TreeSet<String> friendsList;
	private TreeMap<String, ListRecords> records;
	private TreeSet<String> messageFriend;

	/**
	 * Construtor vazio
	 */
	public User() {
		super();
		this.height = 0;
		this.weight = 0;
		this.favoriteActivity = "";
		this.userActivities = new TreeSet<>(new CompareActivity());
		this.friendsList = new TreeSet<>();
		this.messageFriend = new TreeSet<>();
		this.records = new TreeMap<>();
	}

	/**
	 * Construtor parametrizado
	 *
	 * @param email Email.
	 * @param pass Palavra-passe.
	 * @param name Nome.
	 * @param gender Género.
	 * @param date Data de Nascimento.
	 * @param height Altura.
	 * @param weight Peso.
	 * @param favoriteActivity Actividade favorita.
	 * @param userActivities Set com as actividades realizadas.
	 * @param friendsList Set com o email dos amigos.
	 */
	public User(String email, String pass, String name, char gender, GregorianCalendar date, int height, double weight, String favoriteActivity, TreeSet<Activity> userActivities, TreeSet<String> friendsList) {
		super(email, pass, name, gender, date);
		this.height = height;
		this.weight = weight;
		this.favoriteActivity = favoriteActivity;
		for (Activity act : userActivities) {
			this.userActivities.add((Activity) act.clone());
		}
		this.friendsList = (TreeSet<String>) friendsList.clone();
		this.messageFriend = new TreeSet<>();
		this.records = new TreeMap<>();
	}

	/**
	 * Construtor parametrizado
	 *
	 * @param email Email.
	 * @param pass Palavra-passe.
	 * @param name Nome.
	 * @param gender Género.
	 * @param date Data de Nascimento.
	 * @param height Altura.
	 * @param weight Peso.
	 * @param favoriteActivity Actividade favorita.
	 */
	public User(String email, String pass, String name, char gender, GregorianCalendar date,
			int height, double weight, String favoriteActivity) {
		super(email, pass, name, gender, date);
		this.height = height;
		this.weight = weight;
		this.favoriteActivity = favoriteActivity;
		this.userActivities = new TreeSet<>(new CompareActivity());
		this.friendsList = new TreeSet<>();
		this.messageFriend = new TreeSet<>();
		this.records = new TreeMap<>();
	}

	/**
	 * Construtor de cópia.
	 *
	 * @param u-instância de User.
	 */
	public User(User u) {
		super(u.getEmail(), u.getPassword(), u.getName(), u.getGender(), u.getDate());
		this.height = u.getHeight();
		this.weight = u.getWeight();
		this.favoriteActivity = u.getFavoriteActivity();
		this.userActivities = (TreeSet<Activity>) u.getActivities();
		this.friendsList = (TreeSet<String>) u.getFriendsList();
		this.messageFriend = (TreeSet<String>) u.getMessage();
		this.records = (TreeMap<String, ListRecords>) u.getRecords();
	}

	/**
	 * Método que devolve um Map de String(tipo de actividade) para uma lista de recordes.
	 *
	 * @return Map de String para ListRecords.
	 */
	public Map<String, ListRecords> getRecords() {
		TreeMap<String, ListRecords> aux = new TreeMap<>();

		for (String s : this.records.keySet()) {
			aux.put(s, this.records.get(s));
		}
		return aux;
	}

	/**
	 * Método que devolve a altura.
	 *
	 * @return Inteiro.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Método que devolve o peso.
	 *
	 * @return Inteiro.
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Método que devolve a actividade favorita.
	 *
	 * @return String.
	 */
	public String getFavoriteActivity() {
		return this.favoriteActivity;
	}

	/**
	 * Método que devolve um Set com as actividades realizadas.
	 *
	 * @return Set de Activity..
	 */
	public Set<Activity> getActivities() {
		TreeSet<Activity> res = new TreeSet<>(new CompareActivity());
		for (Activity act : this.userActivities) {
			res.add(act.clone());
		}
		return res;
	}

	/**
	 * Método que devolve um Set com os emails dos amigos.
	 *
	 * @return Set de String.
	 */
	public Set<String> getFriendsList() {
		return (TreeSet<String>) this.friendsList.clone();
	}

	/**
	 * Métdo que devolve um Set com as mensgens existentes, cada String corresponde a email de um user que fez um pedido de amizade.
	 *
	 * @return Set de String.
	 */
	public Set<String> getMessage() {
		return this.messageFriend;
	}

	/**
	 * Método que adiciona na caixa de mensagens um email de um user.
	 *
	 * @param email Email do user que fez o pedido de amizade.
	 */
	public void addFriendToMessage(String email) {
		this.messageFriend.add(email);
	}

	/**
	 * Método que remove o email de um user da caixa de mensagens.
	 *
	 * @param email email do user que fez o pedido de amizade.
	 */
	public void removeFriendFromMessage(String email) {
		this.messageFriend.remove(email);
	}

	/**
	 * Método que altera a altura do user.
	 *
	 * @param height Nova altura.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Método que altera o peso do user.
	 *
	 * @param weight Novo peso.
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * Método que altera a actividade favorita do user.
	 *
	 * @param favorite Nova actividade favorita.
	 */
	public void setFavoriteActivity(String favorite) {
		this.favoriteActivity = favorite;
	}

	/**
	 * Método que procura uma actividade realizada por nome.
	 *
	 * @param name Nome da actividade.
	 * @return Activity.
	 */
	public Activity getOneActivity(String name) {

		Activity act;
		boolean found = false;
		Iterator<Activity> it = this.userActivities.iterator();
		act = it.next();
		while (it.hasNext() && !found) {
			if (act.getName().equals(name)) {
				found = true;
			} else {
				act = it.next();
			}
		}

		return act;      //PODE RETORNAR NULL||||
	}

//////////////////////////////TO STATS                              compor NAO esta POR MES!!!!!||||||||||||||||||||||||||||||||||||\\

    /**
     *
     * Método que devolve as estatísticas do utilizador de um dado ano e mês.
     * @param ano Ano no qual se vai pesquisar.
     * @param mes Mês no qual se vai pesquisar.
     * @return Statistics, com a as estatísticas do ano.
     */
    
	public Statistics getStats(int ano, int mes) {
		Iterator<Activity> it = this.userActivities.iterator();
		Activity a;
		Statistics stat = new Statistics();
		boolean sair = false;
		GregorianCalendar date = new GregorianCalendar(ano, mes, 0);
		while (it.hasNext() && !sair) {
			a = it.next();
			int ano1 = a.getDate().get(Calendar.YEAR);
			int mes1 = a.getDate().get(Calendar.MONTH);
			if (ano1 == ano) {
				if (mes1 == mes) {
					if (a instanceof Distance) {
						Distance d = (Distance) a;
						stat.incrementsTimeDistanceCalories(a.getTimeSpent(), d.getDistance(), a.getCalories());
					} else {
						stat.incrementsTimeDistanceCalories(a.getTimeSpent(), 0, a.getCalories());
					}
				} else if (mes1 < mes) {
					sair = true;
				}
			} else if (ano1 < ano) {
				sair = true;
			}
		}

		return stat;
	}

    /**
     * Método que devolve as estatísticas do utilizador de um dado ano.
     * @param ano Ano no qual se vai pesquisar.
     * @return Statistics, com a as estatísticas do ano.
     */
    public Statistics getStats(int ano) {
		Iterator<Activity> it = this.userActivities.iterator();
		Activity a;
		Statistics stat = new Statistics();
		boolean sair = false;
		GregorianCalendar date = new GregorianCalendar(ano, 0, 0);
		while (it.hasNext() && !sair) {
			a = it.next();
			int ano1 = a.getDate().get(Calendar.YEAR);
			if (ano1 == ano) {
				if (a instanceof Distance) {
					Distance d = (Distance) a;
					stat.incrementsTimeDistanceCalories(a.getTimeSpent(), d.getDistance(), a.getCalories());
				} else {
					stat.incrementsTimeDistanceCalories(a.getTimeSpent(), 0, a.getCalories());
				}

			} else if (ano1 < ano) {
				sair = true;
			}
		}

		return stat;
	}

	/**
	 * Método que adiciona uma actividade a lista de actividades,e actualiza os recordes caso essa actividade tenha recordes.
	 *
	 * @param act Activity a adicionar.
	 * @param tipoActividade Tipo de actividade.
	 * @return 1 ou 0 caso consiga ou não adicionar a actividade.
	 */
	public boolean addActivity(Activity act, String tipoActividade) {
		if ((act instanceof Running) || (act instanceof Walking)
				|| (act instanceof Cycling) || (act instanceof MountainBiking) || (act instanceof Swimming)) {
			updateRecords(tipoActividade, act);
		}
		act.setCalories(this.weight);
		return this.userActivities.add(act);
	}

	/**
	 * Método que adiciona um user a lista de amigos.
	 *
	 * @param u Utilizador a adicionar.
	 * @return 1 ou 0 caso consigo ou não adicionar o user.
	 */
	public boolean addFriend(User u) {
		boolean flag = false, found = false;
		flag = this.friendsList.add(u.getEmail());

		return flag;
	}

	/**
	 * Método que remove um actividade da lista de actividades.
	 *
	 * @param activityName Nome da actividade a ser removida.
	 * @return true ou false,caso consiga ou não remover a actividade.
	 */
	public boolean removeActivity(String activityName) {
		boolean found = false;
		boolean flag = false;
		/*
		 TreeSet actAux = new TreeSet<>(new CompareActivity());
		 for (Activity a : this.userActivities) {
		 actAux.add(a);
		 }*/
		Iterator<Activity> it = this.userActivities.iterator();
		while (it.hasNext() && !found) {
			Activity act = it.next();
			if (act.getName().equals(activityName)) {
				it.remove();
				flag = true;
				found = true;
			}
		}
		return flag;

	}

	//////////////////Records///////////////
	/**
	 * Método que adiciona um uma lista de recordes de um tipo de actividade.
	 *
	 * @param tipoActividade Tipo de actividade a qual se referem os recordes.
	 * @param act Actividade com a lista de recordes.
	 * @return true se tudo correu bem.
	 */
	public boolean addRecord(String tipoActividade, Activity act) {
		RecordsActivity a;
		if (act instanceof RecordsActivity) {
			a = (RecordsActivity) act;
			this.records.put(tipoActividade, a.getListRecords());
		}
		return true;

	}

	/**
	 * Método que actualiza os recordes de um tipo de actividade.
	 *
	 * @param tipoActividade Tipo de actividade
	 * @param act Actividade com os recordes.
	 * @return true se act é do tipo RecodsActivity(se tem recordes) false caso contrário.
	 */
	public boolean updateRecords(String tipoActividade, Activity act) {

		if (!this.records.containsKey(tipoActividade)) {
			return addRecord(tipoActividade, act);
		} else {

			ListRecords recUser = this.records.get(tipoActividade);
			ListRecords recAct;
			boolean flag = false;
			RecordsActivity a;
			if (act instanceof RecordsActivity) {
				a = (RecordsActivity) act;
				recAct = a.getListRecords();
				recUser.updateList(recAct);
				flag = true;

			}

			return flag;
		}

	}

	//Metodos Para admin
	/**
	 * Método que devolve a referência da lista de actividades.
	 *
	 * @return Set de activity.
	 */
	public Set<Activity> getUserActivitiesAdmin() {
		return this.userActivities;
	}

	/**
	 * Método que devolve a referência da lista de amigos.
	 *
	 * @return Set de String.
	 */
	public Set<String> getFriendsListAdmin() {

		return this.friendsList;
	}

	private double calculaTmMarathon(double distancia) {
		double tempo = 0;
		int numero = 0;
		double distance = 0;
		for (Activity act : this.getActivities()) {
			if (act instanceof Running) {
				Running run = (Running) act;
				distance += run.getDistance();
				tempo += (run.getTimeSpent() / run.getDistance());
				numero++;
			}
		}

		tempo = tempo / numero;
		distance = distance / numero;
		distance = distance / distancia;
		tempo = (tempo / numero);
		tempo /= (distance);
		return tempo;

	}

	private double calculaTmMarathonBTT(double distancia) {
		double tempo = 0;
		int numero = 0;

		double distance = 0;
		double factor = 0;
		for (Activity act : this.getActivities()) {
			if (act instanceof MountainBiking) {
				MountainBiking run = (MountainBiking) act;
				distance += run.getDistance();
				tempo += (run.getTimeSpent() / run.getDistance());
				if ((run.getVerticalDistance() > 0) && (run.getVerticalDistance() < 0.100)) {
					factor += 0.1;
				} else if ((run.getVerticalDistance() >= 0.100) && (run.getVerticalDistance() < 0.300)) {
					factor += 0.3;
				} else if ((run.getVerticalDistance() >= 0.300) && (run.getVerticalDistance() < 0.500)) {
					factor += 0.5;
				} else if ((run.getVerticalDistance() >= 0.500) && (run.getVerticalDistance() < 1)) {
					factor += 0.7;
				} else if (run.getVerticalDistance() >= 1) {
					factor += 0.8;
				}
				numero++;
			}
		}
		distance /= numero;
		distance /= distancia;
		factor /= numero;
		tempo /= numero;
		tempo -= (factor * tempo);

		tempo /= (distance);

		return tempo;

	}

	private int numeroActividadesM() {
		int num = 0;
		for (Activity act : this.getActivities()) {
			if (act instanceof Running) {
				num++;
			}
		}
		return num;
	}

	private int numeroActividadesMbtt() {
		int num = 0;
		for (Activity act : this.getActivities()) {
			if (act instanceof MountainBiking) {
				num++;
			}
		}
		return num;
	}

	private double tabelaWeather(String weather) {
		double factor = 0;
		switch (weather) {
			case "Sol":
				factor = 0.2;
				break;
			case "Sol intenso":
				factor = 0.7;
				break;
			case "Sol intenso com ventos fortes":
				factor = 0.8;
				break;
			case "Chuva":
				factor = 0.4;
				break;
			case "Chuva com ventos fortes":
				factor = 0.6;
				break;
			case "Chuva intensa":
				factor = 0.7;
				break;
			case "Chuva intensa com ventos fortes":
				factor = 0.9;
				break;
			case "Trovoada":
				factor = 0.3;
				break;
			case "Trovoada com ventos fortes":
				factor = 0.5;
				break;
			case "Nublado":
				factor = 0.6;
				break;
		}
		return factor;
	}

	private double tabelaTemperatura(double temperatura) {
		double factor;
		if (temperatura < 10) {
			factor = 0.70;
		} else if (temperatura < 20) {
			factor = 0.60;
		} else if (temperatura > 39) {
			factor = 0.95;
		} else if (temperatura > 30) {
			factor = 0.80;
		} else {
			factor = 0.2;
		}

		return factor;
	}

	/**
	 * Método que calcula o km em que o user pode desistir.
	 *
	 * @param kmTotal Total de km do evento.
	 * @return double com o km de desistência.
	 */
	public double kmDesisteM(double kmTotal) {
		//double calories = 10* u.getWeight()*tempo;
		double factor = 0;
		GregorianCalendar date = new GregorianCalendar();
		int age = date.get(Calendar.YEAR) - this.getDate().get(Calendar.YEAR);
		double probabilidade;
		if (age < 15) {
			factor = Math.random()*1.5 + 0.1;
		} else if (age < 20) {
			factor = Math.random()*1.5 + 0.5;
		} else if (age < 25) {
			factor = Math.random()*1.5+ 0.7;
		} else if (age < 30) {
			factor = Math.random()*1.5 + 0.85;
		} else if (age < 35) {
			factor = Math.random()*1.5 + 0.9;
		} else if (age < 40) {
			factor = Math.random()*1.5 + 0.6;
		} else if (age < 45) {
			factor = Math.random()*1.5 + 0.5;
		} else if (age < 50) {
			factor = Math.random()*1.5 + 0.4;
		} else if (age < 55) {
			factor = Math.random()*1.5 + 0.3;
		} else if (age < 60) {
			factor = Math.random()*1.5 + 0.2;
		} else if (age < 65) {
			factor = Math.random()*1.5 + 0.1;
		} else if (age >= 65) {
			factor = Math.random()*1.5 + 0.05;
		}

		kmTotal *= factor;

		return kmTotal;
	}

	/**
	 *
	 * Método que calcula o tempo médio do user para um evento,tendo em conta a idade,clima temperatura e numero de actividades realizadas do tipo do evento.
	 *
	 * @param weather Clima.
	 * @param temperatura Temperatura.
	 * @param tipo Tipo do evento.
	 * @param distance Distancia do evento.
	 * @return double com o tempo médio.
	 */
	public double formula(String weather, double temperatura, String tipo, double distance) {
		double tempo;
		double tempoMedio = 0;
		double age, numero = 0;
		GregorianCalendar date = new GregorianCalendar();
		switch (tipo) {
			case "Marathon":
				tempoMedio = calculaTmMarathon(42.195);
				numero = numeroActividadesM();
				break;
			case "Halfmarathon":
				tempoMedio = calculaTmMarathon(21.1);
				numero = numeroActividadesM();
				break;
			case "MarathonBTT":
				tempoMedio = calculaTmMarathonBTT(distance);
				numero = numeroActividadesMbtt();
				break;
			case "Trail":
				tempoMedio = calculaTmMarathon(distance);
				tempoMedio = tempoMedio + (tempoMedio * 0.3);
				numero = numeroActividadesM();
				break;
		}
		age = date.get(Calendar.YEAR) - this.getDate().get(Calendar.YEAR);
		tempo = tempoMedio + (1 * tabelaWeather(weather)) + (1 * tabelaTemperatura(temperatura)) - (numero / 100) + (age / 100);
		return tempo;
	}

	//Equals,toString e Clone
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		} else {
			User u = (User) o;
			return (super.equals(u)
					&& this.height == u.getHeight()
					&& this.weight == u.getWeight()
					&& this.favoriteActivity.equals(u.getFavoriteActivity())
					&& this.friendsList.equals(u.getFriendsList())
					&& this.userActivities.equals(u.getActivities()));
		}

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 83 * hash + this.height;
		hash = 83 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
		hash = 83 * hash + Objects.hashCode(this.favoriteActivity);
		hash = 83 * hash + Objects.hashCode(this.userActivities);
		hash = 83 * hash + Objects.hashCode(this.friendsList);
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Height: ");
		sb.append(this.height).append("\n");
		sb.append("Weight: ");
		sb.append(this.weight).append("\n");
		sb.append("Favorite Activity: ");
		sb.append(this.favoriteActivity).append("\n");
		sb.append("Friends List: ").append("\n");
		for (String s : this.getFriendsList()) {
			sb.append(s).append("\n");
		}
		for (Activity act : this.userActivities) {
			sb.append(act.toString());
		}

		return sb.toString();

	}

	@Override
	public User clone() {
		return new User(this);
	}
}
