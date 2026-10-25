import java.time.LocalDateTime;
import java.util.*;

class Vechile{
    int vecno;
    String vechiletype;
    int licno;
    Vechile(int vecno,String vechiletype,int licno){
        this.vecno=vecno;
        this.vechiletype=vechiletype;
        this.licno=licno;
    }
    public  int getvechileno(){
        return vecno;
    }
    public String getvechiletype(){
        return vechiletype;
    }
}
class Bike extends Vechile{
    Bike(int vecno,String vechiletype,int licno){
        super(vecno,vechiletype, licno);
    }
}
class Car extends Vechile{
    Car(int vecno,String vechiletype,int licno){
        super(vecno,vechiletype, licno);
    }
}
class Truck extends Vechile{
    Truck(int vecno,String vechiletype,int licno){
        super(vecno,vechiletype, licno);
    }
}
class Slot{
    int slotid;
    String slottype;
    boolean isocupied;
    Vechile vechile;
    Slot(int slotid,String slottype){
        this.slotid=slotid;
        this.slottype=slottype;
        this.isocupied=false;
    }
    public void parkvechile(Vechile vechile){
        if(!isocupied){
            this.vechile=vechile;
            isocupied=true;
        }
    }
    public void removevechile(Vechile vechile){
        vechile=null;
        isocupied=false;
    }
}
class Floors{
    int floorid;
    ArrayList<Slot> slots;
    Floors(int floorid){
        this.floorid=floorid;
        slots=new ArrayList<>();
    }

    public void addslot(Slot slot){
        slots.add(slot);
    }
    public void removeslot(Slot slot){
    slots.remove(slot);
    }
    public Slot availableslot(){
        for(Slot slot:slots){
            if(!slot.isocupied){
                return slot;
            }
        }
        return null;
    }
}
class Parkinglot{
    String name;
    String address;
    ArrayList<Floors> floors;
    Parkinglot(String name,String address){
        this.name=name;
        this.address=address;
        floors=new ArrayList<>();
    }
    public void addfloor(Floors floor){
        floors.add(floor);
    }
    public void removefloor(Floors floor){
        floors.remove(floor);
    }
}
class Ticket{
    int ticketid;
    Vechile vechile;
    Slot slot;
    LocalDateTime entrytime;
    LocalDateTime exittime;
    Ticket(int ticketid,Vechile vechile,Slot slot){
        this.ticketid = ticketid;
        this.vechile = vechile;
        this.slot = slot;
        this.entrytime = LocalDateTime.now();
    }
    public int  generateticket(){
        return ticketid;
    }
    public long duration(){
       exittime=LocalDateTime.now();
       return java.time.Duration
                .between(entrytime, exittime)
                .getSeconds();
    }
}
class Fee{
    double amount;
    String vechiletype;
    Fee(String vechiletype){
        this.vechiletype=vechiletype;
    }
    public double calculatefee(long hours){
        if(vechiletype.equals("bike")){
            amount=1*hours;
        }else if(vechiletype.equals("Car")){
            amount=2*hours;
        }else if(vechiletype.equals("Truck")){
            amount=3*hours;
        }
        return amount;
    }
}
interface Payment{
      void payment();

}
class  upi implements Payment{
     public void payment(){
        System.out.print("Payment paid through UPI");
     }
}
class cash implements Payment{
    public void payment(){
        System.out.print("Payment paid through cash");
    }
}

class Main{
      public static void main(String[] args) throws InterruptedException{
        Parkinglot lot=new Parkinglot("Sr University","Warangal");
        Floors floor=new Floors(1);
        Slot bikeslot=new Slot(101,"Bike");
        Slot carslot=new Slot(102,"Car");
        floor.addslot(bikeslot);
        floor.addslot(carslot);
        lot.addfloor(floor);
        Vechile bike=new Vechile(1476, "bike",2303);
        Vechile car=new Vechile(1479, "Car",2304);
        carslot.parkvechile(car);
        bikeslot.parkvechile(bike);
        
        Ticket tic=new Ticket(10, car, carslot);
        System.out.println("Vechile No "+bike.getvechileno());
        System.out.println("ticket id  "+tic.generateticket());
        System.out.println("Vechile type  "+bike.getvechiletype());
        Thread.sleep(5000);
        long duration=tic.duration();
        Fee feec=new Fee(car.getvechiletype());
        Fee feeb=new Fee(bike.getvechiletype());
        double amountb=feeb.calculatefee(duration);
        double amountc=feec.calculatefee(duration);
        Scanner sc=new Scanner(System.in);
        System.out.println("Duration "+duration);
        System.out.println("amount to be payed "+amountb);
        System.out.println("amount to be payed "+amountc);
        int n=sc.nextInt();
        if (n == 1) {
    Payment p = new upi();
    p.payment();
//    removevechile(bike);
}
else {
    Payment p = new cash();
    p.payment();
    // removevechile(car);
}
      }
}