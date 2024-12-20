/*package Quiz;
import java.util.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
class Participant1{
	
}
class Question {
    String questionText;
    String[] options;
    int correctAnswer;
    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public void displayQuestion(boolean[] showOptions) {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            if (showOptions[i]) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }
    public boolean isCorrect(int userChoice) {
        return userChoice == correctAnswer;
    }
}
public class QuizProject1 extends Thread {
    public static void main(String[] args) throws InterruptedException {
    	Scanner scanner = new Scanner(System.in);
    	Participant1 p=new Participant1();
		
    	
    	System.out.println("WELCOME TO OUR QUIZ COMPETATION");
    	Thread.sleep(2000);
    	
    	System.out.println("Enter the name:");
    	String name=scanner.nextLine();
    	Thread.sleep(1000);
    	
    	System.out.println("Enter the id:");
        int id=scanner.nextInt();
        Thread.sleep(1000);
        
        System.out.println("Enter the mail id:");
        String email=scanner.next();
        Thread.sleep(1000);

        System.out.println("Enter your place name:");
        String place=scanner.next();
        Thread.sleep(1000);
        
        System.out.println("Enter your pincode:");
        int pincode=scanner.nextInt();
        Thread.sleep(1000);
		
        
        
		System.out.println("name :"+name);
		System.out.println("ID :"+id);
		System.out.println("EMAIL :"+email);
		System.out.println("PLACE :"+place);
		System.out.println("PINCODE :"+pincode);
		System.out.println("THE PLAYER IS READY OR NOT TO TAKE THE QUIZ");
		
		String playerchoice=scanner.next();
		if(playerchoice.equals("YES")) {
			System.out.println("           RULES          ");

			System.out.println("rule 1:-THE PLAYER SHOULD GIVE THE CORRECT DETAILS");
			System.out.println("rule 2:-THE PLAYER MUST SELECT THE OPTION WITHIN THE TIME");
			System.out.println("rule 3:-REMEMBER THE LIFE LINES CAN BE USED ONLY ONCE ");
			System.out.println("rule 4:-THE LIFE LINES WILL BE TWO ONLY");
			System.out.println("THE PLAYER MUST HAVE TO FOLLOW THE ABOVE RULES");
		
			
		
		
		
		
		
        ArrayList<Question> quiz = new ArrayList<>();
        quiz.add(new Question("Who is the primeminister of INDIA?",
                new String[]{"Chandra babu", "Jagan", "Narendra modi", "Pawan kalayan", "Quit", "Lifeline"}, 3));
        quiz.add(new Question("In bahubali movie who is the main actor?",
                new String[]{"Rana", "Prabhas", "Katappa", "Anushka", "Quit", "Lifeline"}, 2));
        quiz.add(new Question("Who is representing the India in International level?",
                new String[]{"Salman khan", "Akshay kumar", "Amir khan", "Shah rukh khan", "Quit", "Lifeline"}, 4));
        quiz.add(new Question("Who is the director of Bahubali Movie?",
                new String[]{"SS rajmouli", "Trivikram", "Sukumar", "RGV", "Quit", "Lifeline"}, 1));
        int score =0;
        boolean lifelineUsed = false;
        
        Random random = new Random();
        try {
        for (int i = 0; i < quiz.size(); i++) {
            Question currentQuestion = quiz.get(i);
            boolean[] showOptions = {true, true, true, true, true, true}; // Show all options initially

            System.out.println("\nQuestion " + (i + 1) + ":");
            currentQuestion.displayQuestion(showOptions);

            System.out.print("Enter your choice (1-6): ");
            int userChoice = scanner.nextInt();

            if (userChoice == 5) {
                System.out.println("Exiting...... Thank you for playing!");
                break;
            }

            if (userChoice == 6) {
                if (lifelineUsed) {
                    System.out.println("Lifeline already used! Choose a valid option.");
                    i--;
                    continue;
                }
                System.out.println("Lifeline Options:");
                System.out.println("1. Swap the question");
                System.out.println("2. Rating (percentage chance of the correct answer)");
                System.out.println("3. 50-50");
                System.out.print("Choose a lifeline (1-3): ");
                int lifelineChoice = scanner.nextInt();
               
                switch (lifelineChoice) {
                case 1: 
                    // Swap the question
                    int randomIndex = random.nextInt(quiz.size());
                    System.out.println("You can swap the Question");
                    i = randomIndex - 1; 
                    break;
                    
                case 2: 
                    // Audience poll
                    int correctOption = currentQuestion.correctAnswer;

                    // Generate random percentages for audience poll
                    int[] audiencePoll = new int[4];
                    int remainingPercentage = 100;

                    for (int j = 0; j < 3; j++) {
                        if (j == correctOption - 1) {
                            audiencePoll[j] = random.nextInt(41) + 60; // Correct option: 60% to 100%
                        } else {
                            audiencePoll[j] = random.nextInt(remainingPercentage / (3 - j));
                        }
                        remainingPercentage -= audiencePoll[j];
                    }
                    audiencePoll[3] = remainingPercentage; // Assign remaining percentage to the last option

                    // Shuffle percentages for randomness (except the correct one)
                    for (int j = 0; j < 4; j++) {
                        if (j != correctOption - 1) {
                            int swapIndex = random.nextInt(4);
                            int temp = audiencePoll[j];
                            audiencePoll[j] = audiencePoll[swapIndex];
                            audiencePoll[swapIndex] = temp;
                        }
                    }

                    System.out.println("Audience poll results:");
                    for (int j = 0; j < audiencePoll.length; j++) {
                        System.out.println("Option " + (j + 1) + ": " + audiencePoll[j] + "%");
                    }
                    i--;
                    break;

                case 3: 
                    // 50-50 Lifeline
                    System.out.println("It may be 50-50 chances the selected option is correct or not...");
                    boolean[] fiftyFiftyOptions = new boolean[]{false, false, false, false};
                    fiftyFiftyOptions[currentQuestion.correctAnswer - 1] = true;

                    // Select one random incorrect option to keep
                    int randomIncorrectOption;
                    do {
                        randomIncorrectOption = random.nextInt(4);
                    } while (randomIncorrectOption == currentQuestion.correctAnswer - 1);
                    fiftyFiftyOptions[randomIncorrectOption] = true;

                    currentQuestion.displayQuestion(fiftyFiftyOptions);
                    i--;
                    break;

                default:
                    System.out.println("Invalid lifeline choice.");
                    i--;
                    break;
            }

           
            lifelineUsed = true;
            continue;

            if (currentQuestion.isCorrect(userChoice)) {
                System.out.println("Correct!");
                
                score++;
                System.out.println("Score is :"+score);
            } else {
                System.out.println("You selected option is Wrong!! The correct answer is " + currentQuestion.correctAnswer + ".");
                System.out.println("Game over. Your final score is: " + score);
                break;
            }

            if (i == quiz.size() - 1) {
                System.out.println("Congratulations! You completed the quiz.");
                System.out.println("Your total score is: " + score);
                System.out.println("Congratulations on being certified in the quiz competition! ");
                System.out.println("name :"+name);
        		System.out.println("ID :"+id);
        		System.out.println("EMAIL :"+email);
        		System.out.println("PLACE :"+place);
        		System.out.println("PINCODE :"+pincode);
                
                
            }}
        
        catch(Exception e) {
        	System.out.println(e);
        }
		}
		else {
			System.out.println("Terminating the game");
			}
		
		
    
        
    }
}*/
package Quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion(boolean[] showOptions) {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            if (showOptions[i]) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctAnswer;
    }
}

public class QuizProject1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("WELCOME TO OUR QUIZ COMPETITION");
        Thread.sleep(2000);

        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        Thread.sleep(1000);

        System.out.println("Enter the ID:");
        int id = scanner.nextInt();
        Thread.sleep(1000);

        System.out.println("Enter the mail ID:");
        String email = scanner.next();
        Thread.sleep(1000);

        System.out.println("Enter your place name:");
        String place = scanner.next();
        Thread.sleep(1000);

        System.out.println("Enter your pincode:");
        int pincode = scanner.nextInt();
        Thread.sleep(1000);

        System.out.println("\nPlayer Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Place: " + place);
        System.out.println("Pincode: " + pincode);

        System.out.println("\nDo you agree to participate in the quiz? (YES/NO):");
        String playerChoice = scanner.next();
        if (!playerChoice.equalsIgnoreCase("YES")) {
            System.out.println("Terminating the game. Thank you!");
            return;
        }

        System.out.println("\n           RULES          ");
        System.out.println("1. Provide correct details.");
        System.out.println("2. Select an option within the time.");
        System.out.println("3. Lifelines can be used only once.");
        System.out.println("4. There are three lifelines available.");
        System.out.println("Follow the rules and enjoy the game!");
try {
        // Questions
        ArrayList<Question> quiz = new ArrayList<>();
        quiz.add(new Question("Who is the Prime Minister of India?",
                new String[]{"Chandra Babu", "Jagan", "Narendra Modi", "Pawan Kalyan", "Quit", "Lifeline"}, 3));
        quiz.add(new Question("In Bahubali movie, who is the main actor?",
                new String[]{"Rana", "Prabhas", "Kattappa", "Anushka", "Quit", "Lifeline"}, 2));
        quiz.add(new Question("Who represents India internationally?",
                new String[]{"Salman Khan", "Akshay Kumar", "Aamir Khan", "Shah Rukh Khan", "Quit", "Lifeline"}, 4));
        quiz.add(new Question("Who is the director of the Bahubali movie?",
                new String[]{"SS Rajamouli", "Trivikram", "Sukumar", "RGV", "Quit", "Lifeline"}, 1));

        int score = 0;
        boolean lifelineUsed = false;

                for (int i = 0; i < quiz.size(); i++) {
            Question currentQuestion = quiz.get(i);
            boolean[] showOptions = {true, true, true, true, true, true};

            System.out.println("\nQuestion " + (i + 1) + ":");
            currentQuestion.displayQuestion(showOptions);

            System.out.print("Enter your choice (1-6): ");
            int userChoice = scanner.nextInt();

            if (userChoice == 5) {
                System.out.println("Exiting... Thank you for playing!");
                break;
            }

            if (userChoice == 6) {
                if (lifelineUsed) {
                    System.out.println("Lifeline already used! Choose a valid option.");
                    i--;
                    continue;
                }
                System.out.println("Lifeline Options:");
                System.out.println("1. Swap the question");
                System.out.println("2. Audience Poll");
                System.out.println("3. 50-50");
                System.out.print("Choose a lifeline (1-3): ");
                int lifelineChoice = scanner.nextInt();

                switch (lifelineChoice) {
                    case 1:
                        int randomIndex = random.nextInt(quiz.size());
                        System.out.println("Question swapped!");
                        i = randomIndex - 1;
                        break;

                    case 2:
                        int[] poll = new int[4];
                        poll[currentQuestion.correctAnswer - 1] = random.nextInt(41) + 60; // 60-100% for correct
                        int remaining = 100 - poll[currentQuestion.correctAnswer - 1];
                        int allocated = 0;

                        for (int j = 0; j < poll.length; j++) {
                            if (j != currentQuestion.correctAnswer - 1) {
                                int allocation = j < 2 ? random.nextInt(Math.min(remaining - allocated, 30)) : remaining - allocated;
                                poll[j] = allocation;
                                allocated += allocation;
                            }
                        }

                        System.out.println("Audience poll results:");
                        for (int j = 0; j < poll.length; j++) {
                            System.out.println("Option " + (j + 1) + ": " + poll[j] + "%");
                        }
                        break;
                    case 3:
                       System.out.println("50-50 Lifeline Activated!");
                        boolean[] fiftyOptions = {false, false, false, false};
                        fiftyOptions[currentQuestion.correctAnswer - 1] = true;
                        int randomWrong;
                        do {
                            randomWrong = random.nextInt(4);
                        } while (randomWrong == currentQuestion.correctAnswer - 1);
                        fiftyOptions[randomWrong] = true;
                        currentQuestion.displayQuestion(fiftyOptions);
                        break;

                    default:
                        System.out.println("Invalid lifeline choice.");
                        i--;
                        break;
                }
                lifelineUsed = true;
                i--;
                continue;
            }

            if (currentQuestion.isCorrect(userChoice)) {
                System.out.println("Correct!");
                score++;
                System.out.println("Score is :"+score);
            } else {
                System.out.println("Wrong! The correct answer is Option " + currentQuestion.correctAnswer + ".");
                System.out.println("Game over. Your final score is: " + score);
                break;
            }

            if (i == quiz.size() - 1) {
                System.out.println("\nCongratulations! You completed the quiz.");
                System.out.println("Your total score is: " + score);
                System.out.println("Congratulations on being certified!");
                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Email: " + email);
                System.out.println("Place: " + place);
                System.out.println("Pincode: " + pincode);
                
                System.out.println("**********THANK YOU***********");
            }
        }
}
catch(Exception e) {
	System.out.println(e+"Exception occured");
}
        scanner.close();
    }
}