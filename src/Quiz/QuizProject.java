package Quiz;
class Participant{
	 String name;
     int id;
     String place;
     String email;
     public void setName(String name) {
    	 this.name=name;
     }
     public String getName() {
    	 return name;
     }
     public void setId(int id) {
    	 this.id=id;
     }
     public int getId() {
    	 return id;
     }
     public void setEmail(String email) {
    	 this.email=email;
     }
     public String getEmail() {
    	 return email;
     }
     public void setPlace(String place) {
    	 this.place=place;
     }
     public String getPlace() {
    	 return place;
     }
     
     
}


public class QuizProject {

	public static void main(String[] args) {
		
		Participant p=new Participant();
		p.setName("Ali");
		p.setId(42);
		p.setEmail("sharealikhan143@gmail.com");
		p.setPlace("Madanapalle");
		
		System.out.println("name :"+p.getName());
		System.out.println("ID IS:"+p.getId());
		System.out.println("EMAIL IS:"+p.getEmail());
		System.out.println("PLACE :"+p.getPlace());
		
		System.out.println("THE PLAYER IS READY TO PLAY GAME");
		System.out.println("THE PLAYER IS  NOT READY THEN TERMINATE THE GAME ");
		 
		if(true) {
			System.out.println("rule 1:-THE PLAYER SHOULD GIVE THE CORRECT DETAILS");
			System.out.println("rule 2:-THE PLAYER MUST SELECT THE OPTION WITHIN THE TIME");
			System.out.println("rule 3:-REMEMBER THE LIFE LINES CAN BE USED ONLY ONCE ");
			System.out.println("rule 4:-THE LIFE LINES WILL BE TWO ONLY");
			System.out.println("THE PLAYER MUST HAVE TO FOLLOW THE ABOVE RULES");
		}
		
		}
		
	}


