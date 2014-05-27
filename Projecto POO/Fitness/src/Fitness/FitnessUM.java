package Fitness;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FitnessUM {

    private DataBase db;
    private Person p;

    public FitnessUM() {
        this.db = new DataBase();

    }

    public FitnessUM(DataBase db) {
        this.db = db;

    }

    public void addPerson(TreeSet<Person> persons) {
        db.addPerson(persons);
    }

        /////////Eventos///////////////////// 
        /*
     tempo define a classificação
     weather=0.1...ate 0.qq coisa quanto maior = pior tempo logo pior tempo por km;
        
     tempo por km = tempo medio -(calorias por minuto_ do utilizador na activide/1000)-
     (1*weather)+(numero de actividades feitas deste tipo/100)
        
     probabilidade de desistir:
     top de maratora homem=25 anos
     top de maratona melher=27 anos
        
     depois dos 35 anos a resistencia cai 10% por ano!
     logo aos 25 anos p=95% de acabar a prova para homem 
        
     */
    //////////EVENTS////////////////////////////////////////////
    /*
    public void addEvent(){
        Systeam.out.println("Qual o tipo")
    }*/
    public Event getEventByName(String name) {       // VER MELHOR!! SE NAO HOUVER O EVENTO RETORNAR O QUE?!
        Event event = new Trail();
        for (Event e : this.db.getEvents()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        return event;
    }

    public boolean findRunning(User u) {
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

    public boolean findMountainBiking(User u) {
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
     //So se pode registar se ja praticou actividade do tipo do evento
    public boolean userRegisterEvent(User u, Event e) { 
        String tipo = e.getTipoActivity();
        boolean flag = false;
        switch (tipo) {
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

    ////////////////////////////////////////////////
    public void menuInicial() {
        Scanner input = new Scanner(System.in);
        String email, password;
        int op;

        System.out.println("--- FitnessUM ---\n");
        System.out.println("1 - Login\n");
        System.out.println("2 - Registar\n");
        System.out.println("Opção: ");
        op = input.nextInt();
        input.close();
        switch (op) {
            case 1:
                menuLogin();
                break;
            case 2:
                menuRegistar();
                break;
            default:
                System.out.println("Escolha das opções disponníveis...\n\n");
                menuInicial();
        }
    }

    public void menuLogin() {
        Scanner input = new Scanner(System.in);
        String email, password;
        User u;
        Admin a;
        int op;

        System.out.println("--- FitnessUM ---\n");
        System.out.println("User: ");
        email = input.next();
        System.out.println("Password: ");
        password = input.next();
        input.close();
        if (existPassAndUser(email, password)) {
            if (!isAdmin(email)) {
                this.p = getUserByEmail(email);
                while (menuUser() != 0);
            }
        } else {
            System.out.println("Login incorreto...\n\n");
            menuLogin();
        }
    }

    public void menuRegistar() {
        Scanner input = new Scanner(System.in);
        String email, nome, password, pwVer, gender, actFavorita;
        int altura;
        double peso;
        String[] dataNasc;
        GregorianCalendar dateOfBirth;
        User u;

        System.out.println("--- FitnessUM ---\n");
        System.out.println("Email: ");
        email = input.next();
        System.out.println("Nome: ");
        nome = input.next();
        System.out.println("Sexo (M/F): ");
        gender = input.next();
        System.out.println("Data de Nascimento (dd-mm-aaaa): ");
        dataNasc = input.next().split("-");
        dateOfBirth = new GregorianCalendar(Integer.valueOf(dataNasc[2]), Integer.valueOf(dataNasc[1]), Integer.valueOf(dataNasc[0]));
        System.out.println("Altura (cm): ");
        altura = input.nextInt();
        System.out.println("Peso (kg): ");
        peso = input.nextDouble();
        System.out.println("Desporto favorito: ");
        actFavorita = input.next();
        System.out.println("Password: ");
        password = input.next();
        System.out.println("Confirmação de Password: ");
        pwVer = input.next();
        input.close();
        if (!existPerson(email)) {
            if (password.equals(pwVer)) {
                addUser(email, password, nome, gender.charAt(0), dateOfBirth, altura, peso, actFavorita);
            } else {
                System.out.println("Passwords não coincidem...\n\n");
                menuRegistar();
            }
        } else {
            System.out.println("Email já existente na base de dados...\n\n");
            menuRegistar();
        }

    }

    public int menuUser() {
        Scanner input = new Scanner(System.in);
        int i, op;
        System.out.println("1 - Visualizar a informaçao da últimas 10 actividades");
        System.out.println("2 - Registar uma actividade");
        System.out.println("3 - Consultar ou remover actividades");
        System.out.println("4 - Aceder às estatíticas (mensais ou anuais)");
        System.out.println("0 - Logout");
        System.out.println("Opção: ");
        i = input.nextInt();
        input.close();
        switch (i) {
            case 1:
                TreeSet<Activity> act = (TreeSet<Activity>) getLast10Activities((User) this.p);
                for (Activity a : act) {
                    System.out.println(a.toString());
                }
                break;
            case 2:
                criaActividade(registarActividade());
                break;
            case 3:
                menuListarEstatisticas();
                break;
            case 4:
                menuListarEstatisticas();
                break;
            default:
                System.out.println();
        }
        return i;
    }

    public int menuAdmin() {
        Scanner input = new Scanner(System.in);
        int i;
        System.out.println("1-ADMIN");
        System.out.println("2-ADMIN");
        System.out.println("3-ADMIN");
        System.out.println("4-ADMIN");
        System.out.println("0-Logout");
        i = input.nextInt();
        input.close();
        return i;
    }

    public void menuListarEstatisticas() {
        int op;
        String desp;
        Scanner input = new Scanner(System.in);
        System.out.println("\n1 - Estatísticas mensais");
        System.out.println("\n2 - Estatísticas anuais");
        System.out.println("\n0 - Cancelar");
        System.out.println("Opção: ");
        op = input.nextInt();
        input.close();
        switch (op) {
            case 1:
                menuPedeMes(1);
                break;
            case 2:
                menuPedeAno(2);
                break;
            case 0:
                menuUser();
                break;

        }
    }

    public void menuTiposPesquisa(int time) {
        int op;
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha o tipo de pesquisa:\n");
        System.out.println("1 - Distância:\n");
        System.out.println("2 - Tempo:\n");
        System.out.println("3 - Calorias:\n");
        System.out.println("0 - Cancelar\n");
        op = input.nextInt();
        input.close();
        if (time == 1) {
            if (op == 1 || op == 2 || op == 3) {
                menuPedeMes(op);
            } else if (op == 0) {
                menuUser();
            } else {
                menuListarEstatisticas();
            }
        } else if (time == 2) {
            if (op == 1 || op == 2 || op == 3) {
                menuPedeAno(op);
            } else if (op == 0) {
                menuUser();
            } else {
                menuListarEstatisticas();
            }

        }

    }

    public void menuPedeMes(int tipo) {
        int op, mes, ano;
        Scanner input = new Scanner(System.in);
        System.out.println("Mês: ");
        mes = input.nextInt();
        System.out.println("Ano: ");
        ano = input.nextInt();
        input.close();
        searchStatisticsMONTH((User) this.p, tipo, mes, ano);
    }

    public void menuPedeAno(int tipo) {
        int ano;
        Scanner input = new Scanner(System.in);
        System.out.println("Ano: ");
        ano = input.nextInt();
        input.close();
        searchStatisticsYear((User) this.p, tipo, ano);
    }

    public int registarActividade() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha uma actividade:");
        System.out.println("1 - Yoga");
        System.out.println("2 - Aerobics");
        System.out.println("3 - Swimming");
        System.out.println("4 - IndoorCycling");
        System.out.println("5 - Handball");
        System.out.println("6 - Basketball");
        System.out.println("7 - TableTennis");
        System.out.println("8 - Boxing");
        System.out.println("9 - Badminton");
        System.out.println("10 - VolleyBallIndoor");
        System.out.println("11 - Football");
        System.out.println("12 - VolleyBallBeach");
        System.out.println("13 - Running");
        System.out.println("14 - Skating");
        System.out.println("15 - Saling");
        System.out.println("16 - Walking");
        System.out.println("17 - Tennis");
        System.out.println("18 - Skiing");
        System.out.println("19 - Cycling");
        System.out.println("20 - MountainBiking");
        System.out.println("21 - Orienteering");
        System.out.println("22 - Snowbording");
        System.out.println("23 - Polo");

        int i = input.nextInt();
        input.close();
        return i;
    }

    public Activity criaActividade(int i) {
        Activity act;
        switch (i) {
            case 1:
                act = createActivity("Yoga");
                break;
            case 2:
                act = createActivity("Aerobics");
                break;
            case 3:
                act = createActivity("Swimming");
                break;
            case 4:
                act = createActivity("IndoorCycling");
                break;
            case 5:
                act = createActivity("Handball");
                break;
            case 6:
                act = createActivity("Basketball");
                break;
            case 7:
                act = createActivity("TableTennis");
                break;
            case 8:
                act = createActivity("Boxing");
                break;
            case 9:
                act = createActivity("Badminton");
                break;
            case 10:
                act = createActivity("VolleyBallIndoor");
                break;
            case 11:
                act = createActivity("Football");
                break;
            case 12:
                act = createActivity("VolleyBallBeach");
                break;
            case 13:
                act = createActivity("Running");
                break;
            case 14:
                act = createActivity("Skating");
                break;
            case 15:
                act = createActivity("Saling");
                break;
            case 16:
                act = createActivity("Walking");
                break;
            case 17:
                act = createActivity("Tennis");
                break;
            case 18:
                act = createActivity("Skiing");
                break;
            case 19:
                act = createActivity("Cycling");
                break;
            case 20:
                act = createActivity("MountainBiking");
                break;
            case 21:
                act = createActivity("Orienteering");
                break;
            case 22:
                act = createActivity("Snowbording");
                break;
            case 23:
                act = createActivity("Polo");
                break;
            default:
                act = criaActividade(registarActividade());
                break;

        }
        return act;

    }

    
    
    //////////////////////////     Gerenciamento da aplicação /////////////////////////////////////////////////
    public Person getActivePerson() {
        return this.p;
    }

    public void setFitnessPerson(Person p) {
        if (p instanceof User) {
            this.p = (User) p;
        } else {
            this.p = (Admin) p;
        }
    }

    public User getUserByEmail(String email) {
        User u;
        u = this.db.getUser(email);
        return u;
    }

    public boolean existPassAndUser(String email, String pass) {                               //////////////////////////////////////////////            
        TreeSet<Person> userList = (TreeSet) this.db.getUserList();

        boolean found = false;
        Iterator<Person> it = userList.iterator();

        while (it.hasNext() && !found) {
            Person p = it.next();
            if (email.equals(p.getEmail()) && pass.equals(p.getPassword())) {
                found = true;
            }
        }
        return found;
    }

    public boolean existPerson(String email) {
        TreeSet<Person> userList = (TreeSet) this.db.getUserList();
        boolean flag = false;
        boolean found = false;

        Iterator<Person> it = userList.iterator();

        while (it.hasNext() && !found) {
            Person p = it.next();
            if (p.getEmail().equals(email)) {
                found = true;
                flag = true;
            }
        }

        return flag;
    }

    public boolean isAdmin(String email) {                     // Procurar por email ou Admin admin?!
        TreeSet<Person> userList = (TreeSet) this.db.getUserList();
        boolean flag = false;
        boolean found = false;

        Iterator<Person> it = userList.iterator();

        while (it.hasNext() && !found) {
            Person p = it.next();
            if ((p.getEmail().equals(email)) && (p instanceof Admin)) {
                found = true;
                flag = true;
            }
        }

        return flag;

    }

    public boolean addUser(String email, String pass, String name, char gender, GregorianCalendar date,
            int height, double weight, String favoriteActivity) {
        boolean flag = false;
        User u = new User(email, pass, name, gender, date, height, weight, favoriteActivity);
        flag = db.getUserListAdmin().add(u);

        return flag;

    }

    public boolean addAdmin(String email, String pass, String name, char gender, GregorianCalendar date) {
        boolean flag = false;
        Admin admin = new Admin(email, pass, name, gender, date);
        flag = this.db.getUserListAdmin().add(admin);

        return flag;

    }

	/////////////////////////////////////////////////Propriedade dos Utilizadores//////////////////////////////////////
    //Aceder as estatisticas(mensais anuais) STATISTICS by distancia tempo e\calorias
    public void searchStatisticsMONTH(User u, int tipo, int mes, int ano) {
        TreeMap<GregorianCalendar, Statistics> aux = (TreeMap) u.getStats();

        GregorianCalendar data = new GregorianCalendar(ano, mes, 0);
        Statistics stats = aux.get(data);
        String s;

        switch (tipo) {
            case 1:
                System.out.println(stats.toStringDistance());
                break;
            case 2:
                System.out.println(stats.toStringTimeSpend());
                break;
            case 3:
                System.out.println(stats.toStringCalories());
                break;
            default:
                break;
        }
    }

    public void searchStatisticsYear(User u, int tipo, int ano) {
        TreeMap<GregorianCalendar, Statistics> aux = (TreeMap) u.getStats();
        Statistics nova = new Statistics();
        String s;
        for (int i = 1; i <= 12; i++) {
            GregorianCalendar date = new GregorianCalendar(ano, i, 0);
            if (aux.containsKey(date)) {
                nova.incrementsTimeDistanceCalories(aux.get(date).getTimeSpend(), aux.get(date).getDistance(), aux.get(date).getCalories());
            }

        }

        switch (tipo) {
            case 1:
                System.out.println(nova.toStringDistance());
                break;
            case 2:
                System.out.println(nova.toStringTimeSpend());
                break;
            case 3:
                System.out.println(nova.toStringCalories());
                break;
            default:
                break;
        }
    }

	////////////////////////////////!!!FRIEND!!!//////////////////////////////////////////////////
    public void sendFriendRequest(User user, User friendWhoSendsRequest) {
        user.addFrindToMessage(friendWhoSendsRequest.getEmail());
    }

    public boolean existsFriendToAdd(User u) {

        return (!((ArrayList) u.getMessage()).isEmpty());   // PARA DEVOLVER o contrario

    }

        //ArrayList.toString()
    public void acceptFriend(User u, String email) {                                                         //CLASSE MENSAGENS? UM 
      //  boolean found = false;
        
        User amigo=getUserByEmail(email);
           
        u.addFriend(amigo);                                 
        amigo.addFriend(u);
        /*
        User u2 = new User();
        TreeSet<Person> userList = (TreeSet) this.db.getUserList();

        Iterator<Person> it = userList.iterator();

        while (it.hasNext() && !found) {
            Person p = it.next();
            if ((p.getEmail().equals(email)) && (p instanceof User)) {
                u2 = (User) p;
                found = true;
            }

        }
        */
        //if (found) {

       // }

      //  return found;
    }

    //////////////////////////////////////////////////CRIAR ACTIVITIES////////////////////////////////////////////////////// 
    public Snowbording TypeToSnowbording() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance = input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);

        Snowbording aux = new Snowbording(name, date, timeSpent, distance, verticaldistance, weather);

        return aux;
    }

    public Orienteering TypeToOrienteering() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();

        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Orienteering aux = new Orienteering(name, date, timeSpent, distance, weather);

        return aux;
    }

    public MountainBiking TypeToMountainBiking() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance = input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        MountainBiking aux = new MountainBiking(name, date, timeSpent, distance, verticaldistance, weather);

        return aux;
    }

    public Cycling TypeToCycling() {
        Scanner input = new Scanner(System.in);

        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        mes-=1;
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Cycling aux = new Cycling(name, date, timeSpent, distance, weather);

        return aux;
    }

    public Skiing TypeToSkiing() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance = input.nextInt();
        System.out.println("Distancia: vertical");
        double verticaldistance = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Skiing aux = new Skiing(name, date, timeSpent, distance, verticaldistance, weather);

        return aux;
    }

    public Tennis TypeToTennis() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Tennis aux = new Tennis(name, date, timeSpent, myScore, opScore, weather);

        return aux;
    }

    public Walking TypeToWalking() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Walking aux = new Walking(name, date, timeSpent, distance, weather);

        return aux;
    }

    public Sailing TypeToSailing() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);

        Sailing aux = new Sailing(name, date, timeSpent, distance, weather);

        return aux;
    }

    public Skating TypeToSkating() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Skating aux = new Skating(name, date, timeSpent, distance, weather);

        return aux;
    }

    public Running TypeToRunning() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        mes-=1;
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Running aux = new Running(name, date, timeSpent, distance, weather);

        return aux;
    }

    public VolleyBallBeach TypeToVolleyBallBeach() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        VolleyBallBeach aux = new VolleyBallBeach(name, date, timeSpent, myScore, opScore, weather);

        return aux;
    }

    public Polo TypeToPolo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Polo aux = new Polo(name, date, timeSpent, myScore, opScore, weather);

        return aux;
    }

    public Football TypeToFootball() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Football aux = new Football(name, date, timeSpent, myScore, opScore, weather);

        return aux;
    }

    public VolleyBallIndoor TypeToVolleyBallIndoor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        VolleyBallIndoor aux = new VolleyBallIndoor(name, date, timeSpent, myScore, opScore);

        return aux;
    }

    public Badminton TypeToBadminton() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Badminton aux = new Badminton(name, date, timeSpent, myScore, opScore);

        return aux;
    }

    public Boxing TypeToBoxing() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Boxing aux = new Boxing(name, date, timeSpent, myScore, opScore);

        return aux;
    }

    public TableTennis TypeToTableTennis() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        TableTennis aux = new TableTennis(name, date, timeSpent, myScore, opScore);

        return aux;
    }

    public Basketball TypeToBasketball() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Basketball aux = new Basketball(name, date, timeSpent, myScore, opScore);

        return aux;
    }

    public Handball TypeToHandball() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Handball aux = new Handball(name, date, timeSpent, myScore, opScore);

        return aux;
    }

    public Swimming TypeToSwimming() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Distancia:");
        double distance = input.nextInt();

        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Swimming aux = new Swimming(name, date, timeSpent, distance);

        return aux;
    }

    public IndoorCycling TypeToIndoorCycling() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();

        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
        System.out.println("Distancia:");
        double distance = input.nextInt();

        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        IndoorCycling aux = new IndoorCycling(name, date, timeSpent, distance);

        return aux;

    }

    public Aerobics TypeToAerobics() {

        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();

        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Aerobics aux = new Aerobics(name, date, timeSpent);

        return aux;
    }

    public Yoga TypeToYoga() {

        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent = input.nextInt();
         mes-=1;
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        Yoga aux = new Yoga(name, date, timeSpent);

        return aux;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    public Activity createActivity(String type) {
        Activity nova;

        switch (type) {
            case "Yoga":
                nova = TypeToYoga();
                break;
            case "Aerobics":
                nova = TypeToAerobics();
                break;
            case "Swimming":
                nova = TypeToSwimming();
                break;
            case "IndoorCycling":
                nova = TypeToIndoorCycling();
                break;
            case "Handball":
                nova = TypeToHandball();
                break;
            case "Basketball":
                nova = TypeToBasketball();
                break;
            case "TableTennis":
                nova = TypeToTableTennis();
                break;
            case "Boxing":
                nova = TypeToBoxing();
                break;
            case "Badminton":
                nova = TypeToBadminton();
                break;
            case "VolleyBallIndoor":
                nova = TypeToVolleyBallIndoor();
                break;
            case "Football":
                nova = TypeToFootball();
                break;
            case "Polo":
                nova = TypeToPolo();
                break;
            case "VolleyBallBeach":
                nova = TypeToVolleyBallBeach();
                break;
            case "Running":
                nova = TypeToRunning();
                break;
            case "Skating":
                nova = TypeToSkating();
                break;
            case "Saling":
                nova = TypeToSailing();
                break;
            case "Walking":
                nova = TypeToWalking();
                break;
            case "Tennis":
                nova = TypeToTennis();
                break;
            case "Skiing":
                nova = TypeToSkiing();
                break;
            case "Cycling":
                nova = TypeToCycling();
                break;
            case "MountainBiking":
                nova = TypeToMountainBiking();
                break;
            case "Orienteering":
                nova = TypeToOrienteering();
                break;
            default://Snowbording
                nova = TypeToSnowbording();
                break;

        }
        return nova;

    }

    /*
     public boolean addActivity(Activity act,User u){
     boolean flag=false;
     if (ExistSport(act.getSportName())){                                                    
     }
     return flag;
     }
     */
    public Set<Activity> getLast10Activities(User u) {
        TreeSet<Activity> aux = new TreeSet(new CompareActivity());
        Iterator<Activity> it = u.getActivities().iterator();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            aux.add(it.next());
        }
        return aux;
    }

    /////// VE TODAS AS ACTIVIDADES DE TODOS OS AMIGOS ///////////////////////////
    public String FriendToString(TreeSet<User> users) {
        StringBuilder sb = new StringBuilder();

        for (User friend : users) {
            sb.append("Name Friend: ");
            sb.append(friend.getName()).append("\n");
            sb.append("Favorite Activity: ");
            sb.append(friend.getFavoriteActivity()).append("\n");
            sb.append("Activities").append("\n");
            sb.append(friend.getActivities().toString());                                           //toSring() METODO IMPLENTADO NA ACTIVITYLIST!!!!

        }
        return sb.toString();
    }

    public String seeAllFriend(User u) {
        TreeSet<Person> dbUsers = (TreeSet) this.db.getUserList();
      //  TreeSet<String> userActivities = (TreeSet) u.getFriendsList();
        TreeSet<User> users = new TreeSet<User>();

        for (String s : u.getFriendsList()) {
            boolean found = false;
            Iterator<Person> it = dbUsers.iterator();
            while (it.hasNext() && !found) {
                Person p = it.next();
                if (p.getName().equals(s)) {
                    users.add((User) p);
                }
            }

        }

        return (FriendToString(users));

    }

	//Ver Actividade de um dado amigo //
    //Lista amigos,escolhe amigo        --
    public String listAllFriends(User u) {
        TreeSet<String> s = (TreeSet) u.getFriendsList();

        return s.toString();
    }

    //Lista Activity do amigo 
    public String allActivitiesFriend(User u) {
        StringBuilder sb = new StringBuilder();
        for (Activity act : u.getActivities()) {
            sb.append(act.toString());
        }

        return sb.toString();

    }

	//
    // Recebe nome da activityList e User Friend procura essa activity e lista 
    public String seeOneActivityList(User u, String activity) {
        return u.getOneActivity(activity).toString();

    }

	//////////////////////////////////// Propriedade dos Administradores//////////////////////////////////////////
    public boolean removeUser(String email) {
        TreeSet<Person> userList = (TreeSet) this.db.getUserListAdmin();
        boolean flag = false;
        for (Person p : userList) {                                                             //melhorar RETIRAR FOR para Iterator!!!
            if (p instanceof User) {
                User u = (User) p;
                if (email.equals(u.getEmail())) {
                    flag = userList.remove(u);
                } else if (u.getFriendsList().contains(email)) //Remover user todas as ligas de amigos
                {
                    flag = u.getFriendsListAdmin().remove(email);
                }
            }
        }
        return flag;

    }

    public boolean removeActivity(Activity activity) {
        boolean flag = false;
        TreeSet<Person> userList = (TreeSet<Person>) this.db.getUserListAdmin();

        for (Person p : userList) {
            if (p instanceof User) {
                User u = (User) p;
                flag = u.getUserActivitiesAdmin().remove(activity);

            }
        }
        return flag;

    }

    public void removeActivityFromUser(String name) {    //remove uma actividade de todos os users name of activity

        for (Person p : this.db.getUserListAdmin()) {
            if (p instanceof User) {
                boolean found = false;
                User u = (User) p;
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
