import java.util.*;

public class SafariAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalPoints = 0;
        System.out.println("🌄 Welcome to Safari Adventure!\n");

        //for loop days
        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + ":");

            String area;
            //do...while input check
            do {
                System.out.print("Where would you like to explore? (Jungle, River, Desert, Mountains): ");
                area = sc.nextLine().trim();
                if (!area.equalsIgnoreCase("Jungle") &&
                    !area.equalsIgnoreCase("River") &&
                    !area.equalsIgnoreCase("Desert") &&
                    !area.equalsIgnoreCase("Mountains")) {
                    System.out.println("Invalid input.");
                }
            } while (!area.equalsIgnoreCase("Jungle") &&
                     !area.equalsIgnoreCase("River") &&
                     !area.equalsIgnoreCase("Desert") &&
                     !area.equalsIgnoreCase("Mountains"));

            System.out.println("\nYou chose: " + area);
            System.out.println("Exploring " + area + "...");

            int dayPoints = 0;
            int eventCount = 0;

            //while loop events
            while (eventCount < 3) {
                eventCount++;
                int event = rand.nextInt(4); //0 bird, 1 resource, 2 storm, 3 danger

                switch (event) {
                    case 0:
                        System.out.println("Event " + eventCount + ": You spotted a bird. 🐦");
                        System.out.println("Invalid input.\n"); //bird gives nothing
                        continue;

                    case 1:
                        int resourcePoints = 10 + rand.nextInt(20);
                        System.out.println("Event " + eventCount + ": You found useful resources! (+" + resourcePoints + " points)");
                        dayPoints += resourcePoints;
                        break;

                    case 2:
                        System.out.println("Event " + eventCount + ": A sudden storm hits! 🌧️");
                        System.out.println("Invalid input.\n");
                        eventCount = 3; 
                        break;

                    case 3:
                        System.out.println("Event " + eventCount + ": A wild predator appears! 😱");
                        System.out.print("Type 'run' to escape: ");
                        String action = sc.nextLine().trim();
                        if (action.equalsIgnoreCase("run")) {
                            System.out.println("You escaped safely, ending the day early.\n");
                            break;
                        } else {
                            System.out.println("Invalid input.");
                        }
                        break;
                }

                if (dayPoints >= 40) {
                    System.out.println("You collected plenty today! Heading back early.\n");
                    break;
                }
            }

            System.out.println("Day Summary: " + dayPoints + " points earned.");
            System.out.println("-----------------------------------\n");
            totalPoints += dayPoints;
        }

        //end game
        System.out.println("🎉 Safari Complete! You collected " + totalPoints + " points!");
        if (totalPoints >= 100) {
            System.out.println("You survived and completed the adventure!");
        } else {
            System.out.println("You didn’t collect enough resources... Better luck next time.");
        }

        sc.close();
    }
}
