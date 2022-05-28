import java.util.Scanner;

public class AirplaneQueue {
        static int arriv_counter1=0,arriv_counter2=0,emerg_counter=0,arriv_til=0,arriv_til1=0;
        static int avg_land=0;
		static int dep_counter1=0,dep_counter2=0,avg_dep=0;
        static Arrival arrivQueue1[] = new Arrival[10];
        static Arrival arrivQueue2[] = new Arrival[10];
        static Arrival EmergQueue[] = new Arrival[10];
        static Departure depQueue1[] = new Departure[10];
        static Departure depQueue2[] = new Departure[10];
    
    public static void main(String[] args) 
	{
        int temp=0;
        Scanner input = new Scanner(System.in);
        String user_id,location,arriv_time,dep_time;
        int fuel,flightstatus;
        
        while(temp!=-1)
        {
            System.out.println("\n");
			System.out.println("		Enter the number:");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("		1:Arrival Information");
			System.out.println("		2:Departure Information");
			System.out.println("		3:Emergency Landing");
			System.out.println("		4:View Reports");
			System.out.println("		-1:Exit");
			System.out.println("\n");
                temp = input.nextInt();
                switch(temp)
                {
                    case 1:
                        System.out.println("Enter Flight user_id");
                        user_id=input.next();
                        System.out.println("Enter Flight location");
                        location=input.next();
                        System.out.println("Enter Arrival Time");
                        arriv_time=input.next();
                        System.out.println("Enter Fuel");
                        fuel=input.nextInt();
             
                        if(arriv_counter1>arriv_counter2)
						{
                            arrivQueue2[arriv_til1++]= new Arrival(user_id,fuel,location,arriv_time);
							arriv_counter2++;
						}
                        else
						{
                        arrivQueue1[arriv_til++]= new Arrival(user_id,fuel,location,arriv_time);
						arriv_counter1++;
						}
                        landTime(fuel);
                        break;   
                    case 2:
                        System.out.println("Enter Flight user_id");
                        user_id=input.next();
                        System.out.println("Enter Flight location");
                        location=input.next();
                        System.out.println("Enter Departure TIme");
                        dep_time=input.next();
                        System.out.println("Enter Flight Status : 1 for OnTime -1 for Cancelled");
                        flightstatus=input.nextInt();
                           
                        if(dep_counter1>dep_counter2)
                            depQueue2[dep_counter2++]= new Departure(user_id,location,flightstatus,dep_time);
                        else
                            depQueue1[dep_counter1++]= new Departure(user_id,location,flightstatus,dep_time);
						depTime();
                        break;
                    case 3:
                        for(int i = 0 ; i<arriv_counter1;i++)
		                System.out.printf("%s\n",arrivQueue1[i]);
		                System.out.println("2nd Queue");
		                for(int i = 0 ; i<arriv_counter2;i++)
		                System.out.printf("%s\n",arrivQueue2[i]);
	                    System.out.printf("\nEnter the flight user_id for Emergency Landing\n");
	                    user_id=input.next();
                        emergencyLand(user_id);
                        break;
                    case 4:
                            System.out.println("Detail of emergency landing");
                            for(int y =0 ; y < emerg_counter;y++)
                            System.out.printf("%s\n",EmergQueue[y]);
						    System.out.printf("Average Landing Time %d Minutes\n",avg_land);
						    System.out.printf("Average Departure Time %d Minutes\n",avg_dep);
							System.out.println("Cancelled Flight");
							cancelFlight();
                        break;
                }
        }
                 
    }
 static void emergencyLand(String user_id)
    {           
        for(int i =0 ; i<arriv_counter1;i++)
        {
            if(arrivQueue1[i].flightId.equals(user_id))
            {
               EmergQueue[emerg_counter++]=arrivQueue1[i];
			   while(i<arriv_counter1)
		    {
			arrivQueue1[i]=arrivQueue1[i++];
		    }
		arriv_counter1--;
            }
        }
         for(int y =0 ; y<arriv_counter2;y++)
        {
            if(arrivQueue2[y].flightId.equals(user_id))
            {
			   System.out.println(emerg_counter);
               EmergQueue[emerg_counter++]=arrivQueue2[y];
			while(y<arriv_counter2)
		   {
			arrivQueue2[y]=arrivQueue2[y++];
		   }
		 arriv_counter2--;
            }
        }
    }
	
  static void landTime(int fuel)
  {
      int waitingtime=0,counter=0;
      for(int i=0 ; i<arriv_counter1;i++)
     { 
     arrivQueue1[i].setFuel(arrivQueue1[i].fuel-100);
     arrivQueue1[i].setWaitingTime(waitingtime=waitingtime+10);
     if(arrivQueue1[i].fuel<500)
       {
        emergencyLand(arrivQueue1[i].flightId);
	   }                    
     }
	 
    avg_land=waitingtime;
    for(int i=0 ; i<arriv_counter2;i++)
     {
        arrivQueue2[i].setFuel(arrivQueue2[i].fuel-100);
        arrivQueue2[i].setWaitingTime(waitingtime=waitingtime+10);
		 
           if(arrivQueue2[i].fuel<500)
       {  
            emergencyLand(arrivQueue2[i].flightId);
	   
       }
	   
	    counter=arriv_counter1+arriv_counter2;
		avg_land=(avg_land+waitingtime)/counter;                   
    }
 }
   static void depTime()
   {
	  int waitingtime=0,counter=0;
	   for(int i = 0 ; i<dep_counter1;i++)
	   {
		   depQueue1[i].setWaitingTime(waitingtime=waitingtime+10);
	   }
	   for(int i = 0 ; i<dep_counter2;i++)
	   {
		   depQueue2[i].setWaitingTime(waitingtime=waitingtime+10);
	   }
	   counter=dep_counter1+dep_counter2;
	   avg_dep=(avg_dep+waitingtime)/counter;  
   }
      static void cancelFlight()
   {
        for(int i = 0 ; i<dep_counter1;i++)
	   {
	     if(depQueue1[i].flightStatus==-1)
                 System.out.printf("%s\n",depQueue1[i]);
                 
             
	   }
	   for(int i = 0 ; i<dep_counter2;i++)
	   {
	       if(depQueue2[i].flightStatus==-1)
                   System.out.printf("%s\n",depQueue2[i]);
	   }
   }
}
class Arrival
{
    String flightId,location,arrivalTime;
    int fuel,landTime,waitingTime;
    
    Arrival(String flightId ,int fuel,String location,String arrivalTime)
    {
        this.flightId=flightId;
        this.fuel=fuel;
        this.location=location;
        this.arrivalTime=arrivalTime;   
    } 
    public void setFuel(int fuel)
    {
        this.fuel=fuel;
    }
	public void setWaitingTime(int time)
	{
		this.waitingTime=time;
	}
    public String toString()
    {
        return String.format("Flight user_id: %s , Flight Fuel:%d Gallon , Flight location: %s , Flight Arrival Time : %s , Waiting time %d Minutes",flightId,fuel,location,arrivalTime,waitingTime);
    }
	
}
class Departure
{
    String flightId;
    String location;
    int flightStatus;
    String depTime;
    int waitingTime;
    
    Departure(String flightid , String location , int flightStatus,String depTime)
    {
        this.flightId=flightid;
        this.location=location;
        this.flightStatus=flightStatus;
        this.depTime=depTime;
    }
	public void setWaitingTime(int time)
	{
		this.waitingTime=time;
	}
	
	 public String toString()
    {
        return String.format("Flight Id: %s , Flight Status : Cancelled , Flight location: %s , Flight Departure Time : %s , Waiting time %d Minutes",flightId,location,depTime,waitingTime);
    }
	
}
