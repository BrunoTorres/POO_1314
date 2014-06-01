
//LIXO

 //////////////////////////////////////////////////CRIAR ACTIVITIES////////////////////////////////////////////////////// 
/*    public void TypeToAll(){
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
//////////////////////////////////////////////////////////////////////////////////////////////////////

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
              //  act = criaActividade(registarActividade());
                break;

        }
        return act;

    }

    
    */