GregorianCalendar dateu3,dateu1,dateu2;
        dateu1 =new GregorianCalendar(1988,2,12);
        dateu2 =new GregorianCalendar(1900,2,12);
        dateu3 =new GregorianCalendar(1990,2,12);
      u1=new User("user1@gmail.com","2211","jose",'M',dateu1,12,14,"correr");
      u2=new User("user3@gmail.com","1122","Manela",'F',dateu2,11,15,"FAzer nada");  
      u3= new User("user4@gmail.com","3322","Raul",'M',dateu3,10,13,"Fazer NADa");
      
       um.addUserByUser(u1);                  //VER GregorianCALENDAR!!!!
       um.addUserByUser(u2);
       um.addUserByUser(u3);
       //um.addAdmin("user4222@gmail.com","3322","Joselinaa",'M',date);
      
        Activity act11 = new MountainBiking("MountainBiking", date3,20, 2, 0.1, "chuva");
        Activity act12 = new MountainBiking("MountainBiking",date3, 100, 50, 0.2,"chuva");
        Activity act21 = new MountainBiking("MountainBiking", date3, 500, 60,1, "chuva");
        
       u1.addActivity(act11, "MountainBiking");
       u1.addActivity(act12, "MountainBiking");
       u1.addActivity(act21, "MountainBiking");     
       
        Activity act = new MountainBiking("MountainBiking", date3,300, 40, 0.1, "chuva");
        Activity act1 = new MountainBiking("MountainBiking",date3, 350,50, 0.2,"chuva");
        Activity act2 = new MountainBiking("MountainBiking", date3, 10,2,0.5, "chuva");
        
       u2.addActivity(act, "MountainBiking");
       u2.addActivity(act1, "MountainBiking");
       u2.addActivity(act2, "MountainBiking");     
       //String name, GregorianCalendar date, double timeSpent,double distance, double verticaldistance,String weather)
        Activity actbtt1 = new MountainBiking("MountainBiking", date3,120, 40, 0.1, "chuva");
        Activity act1bbt2 = new MountainBiking("MountainBiking",date3, 150, 50, 0.2,"chuva");
        Activity act2btt3 = new MountainBiking("MountainBiking", date3, 250, 60,1, "chuva");
      // TreeSet activi=(TreeSet)um.getLast10Activities(u);
      //System.out.println(activi.toString()); 
       u3.addActivity(actbtt1, "MountainBiking");
       u3.addActivity(act1bbt2, "MountainBiking");
       u3.addActivity(act2btt3, "MountainBiking");
       
       GregorianCalendar limite=new GregorianCalendar(2014,11,2);
       GregorianCalendar datacome= new GregorianCalendar(2014,11,4);
       
       um.addMarathonBTT("serra", "barcelos", 40, datacome,limite, 155,90);
       Event e= um.getEventByName("serra");
       e.addUser(u1);
       e.addUser(u2);
       e.addUser(u3);
       um.simulaEvent(e, "Chuva com ventos fortes", 29);