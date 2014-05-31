package Fitness;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;




public class FitnessUM {     

    //private DataBase db;
    private Person p;
    private String actName;
    private GregorianCalendar actDate;
    private double actTimeSpent;
    private TreeSet<Person>userList;  // admin && users
    private ArrayList<Event> events;      /// mostrar no inicio criar funcao que ver se ja foi o evento 


    public FitnessUM() {
       // this.db = new DataBase();
        this.userList= new TreeSet<Person>(new ComparePersonByName());
        this.events=new ArrayList<>();
    }
 
    
    ////////////////////////
    public List<Event> getEvents(){
        ArrayList<Event> aux=new ArrayList<>();
        for(Event e:this.events){
            aux.add(e.clone());
        }
        return aux;        
    }
    public Set<Person> getUserList(){
        TreeSet<Person> aux = new TreeSet<Person>(new ComparePersonByName());
        for(Person p : this.userList)
            aux.add(p.clone());
        return aux;
    }
    
    
    private User getUser(String email){           
        boolean found=false;
        User u=new User();
        Iterator<Person> it=this.userList.iterator();                                         
       while(it.hasNext() && !found)
       {    Person per = it.next(); 
           if((per.getEmail().equals(email)) && (per instanceof User))
           {
               u=(User)per;
               found=true; 
           }
       }       
       return u;
       
    }
    
    public void addUserByUser(User u){
        this.userList.add(u);
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
    
    
    
    //////////////SIMULAÇAO//////////////////////
    private double tabelaWeather(String weather){
        double factor=0;
        switch(weather){
            case "Sol":
                factor=0.2;
                break;
            case "Sol intenso":
                factor=0.7;
                break;
            case "Sol intenso com ventos fortes":
                factor=0.8;
                break;
            case "Chuva":
                factor=0.4;
                break;
            case "Chuva com Ventos fortes":
                factor=0.6;
                break;
            case "Chuva intensa":
                factor=0.7;
                break;
            case "Chuva intensa com ventos fortes":
                factor=0.9;
                break;
            case "Trovoada":
                factor=0.3;
                break;
            case "Trovoada com ventos fortes":
                factor=0.5;
                break;
            case "Nublado":
                factor=0.6;
                break;
        }
        return factor;
    }
    
    private double tabelaTemperatura(double temperatura){
        double factor;
        if(temperatura <10)
            factor=0.70;
        else if(temperatura<20)
            factor = 0.60;
        else if(temperatura>39)
            factor = 0.95;
        else if(temperatura >30 )
            factor = 0.80;
        else
            factor = 0.2;
        
        return factor;
    }
    
    private double calculaTmMarathon(User u,double distancia){
        double tempo=0;
        int numero=0;
        double distance=0;
        for(Activity act:u.getActivities())
            if(act instanceof Running){
                Running run=(Running) act;
              distance+=run.getDistance();
              tempo+= (run.getTimeSpent()/run.getDistance());
               numero++;
            } 
        
        tempo=tempo/numero;
        distance=distance/numero;
        distance=distance/distancia;
        tempo=(tempo/numero);
        tempo/=(distance);
      return tempo;  
      
    }
    private double calculaTmMarathonBTT(User u,double distancia){
        double tempo=0;
        int numero=0;
        
        double distance=0;
        double factor=0;
        for(Activity act:u.getActivities()){
            if(act instanceof MountainBiking){
                MountainBiking run=(MountainBiking) act;
               distance+=run.getDistance();
               tempo+= (run.getTimeSpent()/run.getDistance());
               if((run.getVerticalDistance()>0) &&(run.getVerticalDistance()<0.100))
                   factor+=0.1;
               else if((run.getVerticalDistance()>=0.100) &&(run.getVerticalDistance()<0.300))
                   factor+=0.3;
               else if((run.getVerticalDistance()>=0.300) &&(run.getVerticalDistance()<0.500))
                   factor+=0.5;
               else if((run.getVerticalDistance()>=0.500) &&(run.getVerticalDistance()<1))
                   factor+=0.7;
               else if(run.getVerticalDistance()>=1)
                   factor+=0.8;
               numero++;
            }
        }
        distance/=numero;
        distance/=distancia;
        factor/=numero;
        tempo/=numero;
        tempo-=(factor*tempo);
        
        tempo/=(distance);
        
            
      return tempo;  
      
    }
     
    private int numeroActividadesM(User u){
        int num=0;
        for(Activity act:u.getActivities())
            if(act instanceof Running)
                num++;
        return num;
    }
    private int numeroActividadesMbtt(User u){
        int num=0;
        for(Activity act:u.getActivities())
            if(act instanceof MountainBiking)
                num++;
        return num;
    }
    
    public double formula(User u,String weather,double temperatura,String tipo,double distance){
        double tempo;
        double tempoMedio=0;
        double age,numero=0;
        GregorianCalendar date = new GregorianCalendar();
         switch (tipo) {
            case "Marathon":
               tempoMedio= calculaTmMarathon(u,42.195);
               numero=numeroActividadesM(u);
                break;
            case "Halfmarathon":
               tempoMedio= calculaTmMarathon(u,21.1); 
               numero=numeroActividadesM(u);
                break;
            case "MarathonBTT":
                tempoMedio=calculaTmMarathonBTT(u,distance);
                numero=numeroActividadesMbtt(u);
                break;
                      }
        age=date.get(Calendar.YEAR)-u.getDate().get(Calendar.YEAR);
        tempo=tempoMedio+(1*tabelaWeather(weather))+(1*tabelaTemperatura(temperatura))-(numero/100)+(age/100);
        return tempo;
     
     
    }
    
    private double kmDesisteM(User u,double tempo){
        
         double calories = 10* u.getWeight()*tempo;
        GregorianCalendar date=new GregorianCalendar();
        int age=date.get(Calendar.YEAR)-u.getDate().get(Calendar.YEAR);
        double probabilidade;
        if(age<15)
                     
            
        
        
        return 0;
    }
    
    
    public void simulaEvent(Event e, String weather,double temperatura){
        //cia A formula
        double distance;
        if(e instanceof Marathon){
            Marathon m=(Marathon)e;
            distance=m.getDistance();
        }
        else if(e instanceof Halfmarathon) 
            distance =21.1;
        else if(e instanceof MarathonBTT){
            MarathonBTT btt=(MarathonBTT)e;
            distance=btt.getDistance();
        }
        
        
    }
    
    
    
    //////////EVENTS////////////////////////////////////////////
    /*
    public void addEvent(){
        Systeam.out.println("Qual o tipo")
    }*/
    
    public void addEvent(Event e){
        this.events.add(e);
    }
    
    public void addMarathon(String name, String location, int maxParticipants, 
            GregorianCalendar deadline, GregorianCalendar date, double duration){
        
        Event e= new  Marathon( name,  location,  maxParticipants, deadline,  date,  duration);
        this.events.add(e);
    }
    public void addHalfmarathon(String name, String location, int maxParticipants, 
            GregorianCalendar deadline, GregorianCalendar date, double duration){
        
        Event e= new  Halfmarathon( name,  location,  maxParticipants, deadline,  date,  duration);
        this.events.add(e);
    }
    
     public void addMarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline,
             GregorianCalendar date, double duration,double distance){
        
        Event e= new  MarathonBTT(name, location, maxParticipants, deadline, date, duration, distance);
        this.events.add(e);
    }
    
    public Event getEventByName(String name) {       // VER MELHOR!! SE NAO HOUVER O EVENTO RETORNAR O QUE?!
        Event event = new Trail();
        for (Event e : this.getEvents()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        return event;
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
    public boolean userRegistEvent(User u, Event e){
         GregorianCalendar date=new GregorianCalendar();
         String tipo = e.getTipoActivity();
         
         if((userRegistaEventoSeFezActivity(u,tipo))&& (e.getDeadline().after(date)) &&
                 (e.getMaxParticipants() > (e.getParticipants()+1))){
             e.addUser(u);
             return true;
         }
         else
             return false;         
    }
     //So se pode registar se ja praticou actividade do tipo do evento
    public boolean userRegistaEventoSeFezActivity(User u, String tipoEvento) { 
       
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
                TreeSet<String> act = (TreeSet<String>) getLast10Activities((User) this.p);               
                    System.out.println(act.toString());
                
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
        System.out.println("22 - Snowboarding");
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
                act = createActivity("Snowboarding");
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
        u = this.getUser(email);
        return u;
    }

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

    public boolean isAdmin(String email) {                     // Procurar por email ou Admin admin?!
      
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

    public boolean addUser(String email, String pass, String name, char gender, GregorianCalendar date,
            int height, double weight, String favoriteActivity) {
        boolean flag;
        User u = new User(email, pass, name, gender, date, height, weight, favoriteActivity);
        flag = this.userList.add(u);

        return flag;

    }

    public boolean addAdmin(String email, String pass, String name, char gender, GregorianCalendar date) {
        boolean flag;
        Admin admin = new Admin(email, pass, name, gender, date);
        flag = this.userList.add(admin);

        return flag;

    }

	/////////////////////////////////////////////////Propriedade dos Utilizadores//////////////////////////////////////
    //Aceder as estatisticas(mensais anuais) STATISTICS by distancia tempo e\calorias
    public void searchStatisticsMONTH(User u, int tipo, int mes, int ano) {
        TreeMap<GregorianCalendar, Statistics> aux = (TreeMap<GregorianCalendar, Statistics>) u.getStats();

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
        TreeMap<GregorianCalendar, Statistics> aux = (TreeMap<GregorianCalendar, Statistics>) u.getStats();
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
        user.addFriendToMessage(friendWhoSendsRequest.getEmail());
      
    }

    public boolean existsFriendToAdd(User u) {

        return (!((ArrayList<String>) u.getMessage()).isEmpty());   // PARA DEVOLVER o contrario

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
    public void TypeToAll(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        this.actName = input.next();
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mes:");
        int mes = input.nextInt();
        mes--;
        System.out.println("Ano:");
        int ano = input.nextInt();
        this.actDate = new GregorianCalendar(ano, mes, dia);
        System.out.println("Tempo despendido (em minutos):");
        this.actTimeSpent = input.nextInt();
    }

    public Snowboarding TypeToSnowboarding() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance = input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance = input.nextInt();
        Snowboarding aux = new Snowboarding(this.actName, this.actDate, this.actTimeSpent, distance, verticaldistance, weather);

        return aux;
    }

    public Orienteering TypeToOrienteering() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Orienteering aux = new Orienteering(this.actName, this.actDate, this.actTimeSpent, distance, weather);

        return aux;
    }

    public MountainBiking TypeToMountainBiking() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance = input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance = input.nextInt();
        MountainBiking aux = new MountainBiking(this.actName, this.actDate, this.actTimeSpent, distance, verticaldistance, weather);

        return aux;
    }

    public Cycling TypeToCycling() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Cycling aux = new Cycling(this.actName, this.actDate, this.actTimeSpent, distance, weather);

        return aux;
    }

    public Skiing TypeToSkiing() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance = input.nextInt();
        System.out.println("Distancia: vertical");
        double verticaldistance = input.nextInt();
        Skiing aux = new Skiing(this.actName, this.actDate, this.actTimeSpent, distance, verticaldistance, weather);

        return aux;
    }

    public Tennis TypeToTennis() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        Tennis aux = new Tennis(this.actName, this.actDate, this.actTimeSpent, myScore, opScore, weather);

        return aux;
    }

    public Walking TypeToWalking() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Walking aux = new Walking(this.actName, this.actDate, this.actTimeSpent, distance, weather);

        return aux;
    }

    public Sailing TypeToSailing() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Sailing aux = new Sailing(this.actName, this.actDate, this.actTimeSpent, distance, weather);

        return aux;
    }

    public Skating TypeToSkating() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Skating aux = new Skating(this.actName, this.actDate, this.actTimeSpent, distance, weather);

        return aux;
    }

    public Running TypeToRunning() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Running aux = new Running(this.actName, this.actDate, this.actTimeSpent, distance, weather);

        return aux;
    }

    public VolleyBallBeach TypeToVolleyBallBeach() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        VolleyBallBeach aux = new VolleyBallBeach(this.actName, this.actDate, this.actTimeSpent, myScore, opScore, weather);

        return aux;
    }

    public Polo TypeToPolo() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        Polo aux = new Polo(this.actName, this.actDate, this.actTimeSpent, myScore, opScore, weather);

        return aux;
    }

    public Football TypeToFootball() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        Football aux = new Football(this.actName, this.actDate, this.actTimeSpent, myScore, opScore, weather);

        return aux;
    }

    public VolleyBallIndoor TypeToVolleyBallIndoor() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        VolleyBallIndoor aux = new VolleyBallIndoor(this.actName, this.actDate, this.actTimeSpent, myScore, opScore);

        return aux;
    }

    public Badminton TypeToBadminton() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        Badminton aux = new Badminton(this.actName, this.actDate, this.actTimeSpent, myScore, opScore);

        return aux;
    }

    public Boxing TypeToBoxing() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        Boxing aux = new Boxing(this.actName, this.actDate, this.actTimeSpent, myScore, opScore);

        return aux;
    }

    public TableTennis TypeToTableTennis() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        TableTennis aux = new TableTennis(this.actName, this.actDate, this.actTimeSpent, myScore, opScore);

        return aux;
    }

    public Basketball TypeToBasketball() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        Basketball aux = new Basketball(this.actName, this.actDate, this.actTimeSpent, myScore, opScore);

        return aux;
    }

    public Handball TypeToHandball() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Score proprio");
        int myScore = input.nextInt();
        System.out.println("Score do adeversario:");
        int opScore = input.nextInt();
        Handball aux = new Handball(this.actName, this.actDate, this.actTimeSpent, myScore, opScore);

        return aux;
    }

    public Swimming TypeToSwimming() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Distancia:");
        double distance = input.nextInt();
        Swimming aux = new Swimming(this.actName, this.actDate, this.actTimeSpent, distance);

        return aux;
    }

    public IndoorCycling TypeToIndoorCycling() {
        this.TypeToAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Distancia:");
        double distance = input.nextInt();
        IndoorCycling aux = new IndoorCycling(this.actName, this.actDate, this.actTimeSpent, distance);

        return aux;
    }

    public Aerobics TypeToAerobics() {
        this.TypeToAll();
        Aerobics aux = new Aerobics(this.actName, this.actDate, this.actTimeSpent);

        return aux;
    }

    public Yoga TypeToYoga() {
        this.TypeToAll();
        Yoga aux = new Yoga(this.actName, this.actDate, this.actTimeSpent);

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
            default://Snowboarding
                nova = TypeToSnowboarding();
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
    public Set<Activity> getLast10ActivitiesByActivity(User u) {
        TreeSet<Activity> aux = new TreeSet<>(new CompareActivity());
        Iterator<Activity> it = u.getActivities().iterator();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            aux.add(it.next());
        }
        return aux;
    }
    
      public Set<String> getLast10Activities(User u) {
        TreeSet<String> aux = new TreeSet<>();
        Iterator<Activity> it = u.getActivities().iterator();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            aux.add(it.next().getName());
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
        TreeSet<Person> dbUsers = (TreeSet<Person>) this.getUserList();
      //  TreeSet<String> userActivities = (TreeSet) u.getFriendsList();
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
    public String listAllFriends(User u) {
        TreeSet<String> s = (TreeSet<String>) u.getFriendsList();

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
    
        boolean flag = false;
        for (Person per : this.userList) {                                                             //melhorar RETIRAR FOR para Iterator!!!
            if (per instanceof User) {
                User u = (User) per;
                if (email.equals(u.getEmail())) {
                    flag = this.userList.remove(u);
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

        for (Person per : this.userList) {
            if (per instanceof User) {
                User u = (User) per;
                flag = u.getUserActivitiesAdmin().remove(activity);

            }
        }
        return flag;

    }

    public void removeActivityFromUser(String name) {    //remove uma actividade de todos os users name of activity

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
