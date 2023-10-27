package org.example;

// *******************************************
// * Author :- Vishal Kumar Maurya (2022580) *
// *******************************************

import java.util.*;

// You must employ Object-Oriented Programming (OOP) principles, such as interfaces, inheritance,
// abstract classes, and polymorphism, to design the application effectively.
// enum Scanner scan = new Scanner(System.in);

interface DiscountInterface {
    void addDiscount(String discountCode, double percentage, int age, boolean morethan);

    void modifyDiscount(String discountCode, String newDiscountCode, double newPercentage, int age, boolean morethan);

    boolean removeDiscount(String discountCode);

    double getDiscountPercentage(String discountCode, int age);

    void printAllDiscounts();
}

interface Attraction {
    int get_attraction_serial_number();

    String get_name();

    String get_description();

    double get_price();

    void setName(String name);

    void setDescription(String description);

    void setIsOpen(boolean val);

    boolean checkIsOpen();

    String getOpeningtime();

    void setOpeningtime(String time);

    String getClosingtime();

    void setClosingtime(String time);

    void setTicketPrice(double price);

    int get_visitor_count();

    void increase_visitor_count();
}

public class Main {

    public static double calculateDiscount(double originalAmount, double discountPercentage) {
        if (originalAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            System.out.println("Invalid input values for discount or amount.");
        }
        double discount = originalAmount * (discountPercentage / 100.0);
        // return discount;
        return originalAmount - discount;
    }

    public static void main(String[] args) {
        double revenue_count = 0;
        int total_visitors_count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println(" \n *******************************************\n" + " * Author :- Vishal Kumar Maurya (2022580) * \n" + " *******************************************");
        System.out.println("__________________________________________________ ");
        System.out.print("               Welcome to ZOOtopia!\n");
        System.out.print("__________________________________________________ \n\n");
        // =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=
        // All Objects Defined here.
        VisitorManager visitorManager = new VisitorManager();
        // i am registering a default visitor for easy debugging
        // visitorManager.registerVisitor("Vishal Maurya", 15, "778", 200, "2", "2");
        // visitorManager.registerVisitor("Ravi", 18, "778", 200.0, "3", "3");
        AttractionManager attractionManager = new InitiateAttractionManager();
        // adding some default attractions for debugging
        attractionManager.addAttraction("Jungle Safari", "you will enjoy here with your friends in a jeep.", 80.36);
        attractionManager.addAttraction("Zoo Special", "showcase of all reptiles and amphibians with a guide helping you throughout.", 56.2);
        attractionManager.addAttraction("moha-maya!", "you will literally see the real life adventure with real animals in real environment.", 180.66);
        DiscountManager discountManager = new DiscountManager();
        // i am also adding some inbuilt discounts bydefault
        discountManager.addDiscount("minor10", 10, 18, false);
        discountManager.addDiscount("senior20", 20, 60, true);
        // i am also adding some default special deals.
        SpecialDealManager specialDealManager = new SpecialDealManager();
        specialDealManager.addSpecialDeal(2, 15);
        specialDealManager.addSpecialDeal(3, 30);
        // i had to create atleast 2 animals for each type.
        AnimalManagement animalManagement = new AnimalManagement();
        Mammal lion = new Mammal("Lion", "The king of the jungle. This animal is so powerful and weights around 190kg.", "Roar!");
        Mammal seals = new Mammal("Seals", "Seals are semi-aquatic mammals that are in a group called pinnipeds, which means fin-footed. There are 32 species of web-footed aquatic mammals that live chiefly in cold seas and whose body shape is round at the middle and tapered at the ends. ", "click---clickkkkk");
        Amphibian salamander = new Amphibian("Salamander", "Salamanders are a group of amphibians typically characterized by their lizard-like appearance, with slender bodies, blunt snouts, short limbs projecting at right angles to the body, and the presence of a tail in both larvae and adults.", "Silence!(actually they remain silent.)");
        Amphibian frog = new Amphibian("Frog", "A frog is any member of a diverse and largely carnivorous group of short-bodied, tailless amphibians composing the order Anur", "turrrr-turrrrrrr!");
        Reptile turtle = new Reptile("Turtle", "Turtles are reptiles of the order Testudines, characterized by a special shell developed mainly from their ribs. Modern turtles are divided into two major groups, the Pleurodira and Cryptodira, which differ in the way the head retracts.", "croaks! croaks!");
        Reptile snake = new Reptile("Snake", "Snakes are elongated, limbless, carnivorous reptiles of the suborder Serpentes. Like all other squamates, snakes are ectothermic, amniote vertebrates covered in overlapping scales", "phissss-phisss! go away from meee...");
        animalManagement.addAnimal(lion);
        animalManagement.addAnimal(seals);
        animalManagement.addAnimal(salamander);
        animalManagement.addAnimal(frog);
        animalManagement.addAnimal(turtle);
        animalManagement.addAnimal(snake);
        // =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=
        // Initializtion starts ------
        while (true) {
            try {
                System.out.println(" Enter your choice ;- ");
                System.out.println(" (1) To Enter as Admin.  \n");
                System.out.println(" (2) To Enter as Visiter.  \n");
                System.out.println(" (3) To view special Deals.  \n");
                System.out.println(" (4) To Exit from the Application.  \n");
                System.out.print("Enter your choice here :- ");
                int taken_input = scan.nextInt();
                scan.nextLine();
                if (taken_input == 1) {
                    System.out.print("\nEnter Admin Username :- ");
                    String admin_username = scan.nextLine();
                    System.out.print("\nEnter Admin Password :- ");
                    String admin_password = scan.nextLine();
                    if ((admin_password).equals("admin123") && (admin_username).equals("admin")) {
                        // if ((admin_password).equals("1") && (admin_username).equals("1")) {
                        while (true) {
                            try {
                                System.out.println("Logged in as Admin.\n");
                                System.out.println("Now choose what would you like to do ? \n");
                                System.out.println("Admin Menu:");
                                System.out.println("  (1) Manage Attractions");
                                System.out.println("  (2) Manage Animals");
                                System.out.println("  (3) Schedule Events");
                                System.out.println("  (4) Set Discounts");
                                System.out.println("  (5) Set Special Deal");
                                System.out.println("  (6) View Visitor Stats");
                                System.out.println("  (7) View Feedback");
                                System.out.println("  (8) Logout");
                                System.out.print("Enter your choice here :- ");
                                int admin_response = scan.nextInt();
                                scan.nextLine();
                                if (admin_response == 1) {
                                    while (true) {
                                        try {
                                            System.out.println("\nManage Attractions :-");
                                            System.out.println("  (1) Add Attraction");
                                            System.out.println("  (2) View Attractions");
                                            System.out.println("  (3) Modify Attraction");
                                            System.out.println("  (4) Remove Attraction");
                                            System.out.println("  (5) Return to previous Menu..");
                                            System.out.print("Enter your choice here :- ");
                                            int manage_attraction_response = scan.nextInt();
                                            scan.nextLine();
                                            if (manage_attraction_response == 1) {
                                                System.out.print("Enter Attraction Name :- ");
                                                String attraction_name = scan.nextLine();
                                                System.out.print("Enter Attraction Description :- ");
                                                String attraction_description = scan.nextLine();
                                                System.out.print("Enter Attraction ticket price :- ");
                                                double attraction_ticket_price = scan.nextDouble();
                                                scan.nextLine();
                                                attractionManager.addAttraction(attraction_name, attraction_description, attraction_ticket_price);
                                                System.out.println("\nAttraction added successfully.\n");
                                            } else if (manage_attraction_response == 2) {
                                                attractionManager.viewAttractions();
                                            } else if (manage_attraction_response == 3) {
                                                attractionManager.viewAttractions();
                                                System.out.print("\nEnter the ID of the attraction you want to modify :- ");
                                                int id_selected_to_modify = scan.nextInt();
                                                scan.nextLine();
                                                // Attraction attractionToModify = attractions.get(modifyAttractionId);
                                                System.out.println("Now what will you like to do ?\n");
                                                System.out.println("  (1) Modify attraction name");
                                                System.out.println("  (2) Modify attraction description");
                                                System.out.println("  (3) Modify attraction's ticket price");
                                                System.out.println("  (4) Modify all details");
                                                System.out.print("Enter your choice here :- ");
                                                int modify_attraction_response = scan.nextInt();
                                                scan.nextLine();
                                                if (modify_attraction_response == 1) {
                                                    System.out.print("Enter new name :- ");
                                                    String newName = scan.nextLine();
                                                    attractionManager.modifyAttraction(id_selected_to_modify, modify_attraction_response, newName);
                                                } else if (modify_attraction_response == 2) {
                                                    System.out.print("Enter new description :- ");
                                                    String newDescription = scan.nextLine();
                                                    attractionManager.modifyAttraction(id_selected_to_modify, modify_attraction_response, newDescription);
                                                } else if (modify_attraction_response == 3) {
                                                    System.out.print("Enter new ticket price :- ");
                                                    String newPrice = scan.nextLine();
                                                    attractionManager.modifyAttraction(id_selected_to_modify, modify_attraction_response, newPrice);
                                                } else if (modify_attraction_response == 4) {
                                                    System.out.print("Enter New Name :- ");
                                                    String newName = scan.nextLine();
                                                    System.out.print("Enter new description :- ");
                                                    String newDescription = scan.nextLine();
                                                    System.out.print("Enter new ticket price :- ");
                                                    String newPrice = scan.nextLine();
                                                    attractionManager.modifyAllAttraction(id_selected_to_modify, newName, newDescription, newPrice);
                                                }
                                                System.out.println("\nDetails were modified successfully\n");
                                            } else if (manage_attraction_response == 4) {
                                                attractionManager.viewAttractions();
                                                System.out.print("\nEnter the ID of the attraction you want to remove :- ");
                                                int id_selected_to_remove = scan.nextInt();
                                                scan.nextLine();
                                                attractionManager.removeAttraction(id_selected_to_remove);
                                                System.out.print("\nAttraction with ID :- " + id_selected_to_remove + " is removed successfully.\n");
                                            } else if (manage_attraction_response == 5) {
                                                System.out.println("Going to previous Menu..\n");
                                                break;
                                            } else {
                                                System.out.println("\nError Not a Command Retry....\n");
                                                continue;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                            scan.nextLine();
                                            continue;
                                        }
                                    }
                                } else if (admin_response == 2) {
                                    while (true) {
                                        try {
                                            System.out.println("\nManage Animals :- ");
                                            System.out.println("  (1) Add Animal");
                                            System.out.println("  (2) Update Animal Details");
                                            System.out.println("  (3) Remove Animal");
                                            System.out.println("  (4) View all animals.");
                                            System.out.println("  (5) Return to previous Menu..");
                                            System.out.print("Enter your choice here :- ");
                                            int manage_animal_response = scan.nextInt();
                                            scan.nextLine();
                                            if (manage_animal_response == 1) {
                                                System.out.println("\nChoose Animal type to be added :- ");
                                                System.out.println("    (1) Mammal");
                                                System.out.println("    (2)  Amphibian");
                                                System.out.println("    (3) Reptile");
                                                System.out.print("Enter your choice here :- ");
                                                int animal_type = scan.nextInt();
                                                scan.nextLine();
                                                if (animal_type == 1) {
                                                    System.out.print("Enter Mammal's name :- ");
                                                    String mammal_name = scan.nextLine();
                                                    System.out.print("Enter Mammal's noise :- ");
                                                    String mammal_noise = scan.nextLine();
                                                    System.out.print("Enter Mammal's short description :- ");
                                                    String mammal_desc = scan.nextLine();
                                                    Mammal newMammal = new Mammal(mammal_name, mammal_desc, mammal_noise);
                                                    animalManagement.addAnimal(newMammal);
                                                    System.out.println("\nAnimal has been added successfully to the zoo!\n");
                                                } else if (animal_type == 2) {
                                                    System.out.print("Enter Amphibian's name :- ");
                                                    String mammal_name = scan.nextLine();
                                                    System.out.print("Enter Amphibian's noise :- ");
                                                    String mammal_noise = scan.nextLine();
                                                    System.out.print("Enter Amphibian's short description :- ");
                                                    String mammal_desc = scan.nextLine();
                                                    Mammal newMammal = new Mammal(mammal_name, mammal_desc, mammal_noise);
                                                    animalManagement.addAnimal(newMammal);
                                                    System.out.println("\nAnimal has been added successfully to the zoo!\n");
                                                } else if (animal_type == 3) {
                                                    System.out.print("Enter Reptile's name :- ");
                                                    String mammal_name = scan.nextLine();
                                                    System.out.print("Enter Reptile's noise :- ");
                                                    String mammal_noise = scan.nextLine();
                                                    System.out.print("Enter Reptile's short description :- ");
                                                    String mammal_desc = scan.nextLine();
                                                    Mammal newMammal = new Mammal(mammal_name, mammal_desc, mammal_noise);
                                                    animalManagement.addAnimal(newMammal);
                                                    System.out.println("\nAnimal has been added successfully to the zoo!\n");
                                                } else {
                                                    System.out.println("\nError Not a Command Retry....\n");
                                                    continue;
                                                }
                                            } else if (manage_animal_response == 2) {
                                                animalManagement.viewAnimals();
                                                System.out.print("\nEnter the ID of Animal to modify its details :- ");
                                                int chosenIDToModify = scan.nextInt();
                                                scan.nextLine();
                                                System.out.println("Enter (1) for Mammal Category. ");
                                                System.out.println("Enter (2) for Amphibian Category. ");
                                                System.out.println("Enter (3) for Reptile Category. ");
                                                System.out.print("Enter new Animal's category :- ");
                                                int newCategory = scan.nextInt();
                                                scan.nextLine();
                                                System.out.print("Enter new Animal's name :- ");
                                                String newName = scan.nextLine();
                                                System.out.print("Enter new Animal's noise :- ");
                                                String newNoise = scan.nextLine();
                                                System.out.print("Enter new Animal's description :- ");
                                                String newDescription = scan.nextLine();
                                                animalManagement.modifyAnimalDetails(chosenIDToModify, newName, newDescription, newNoise, newCategory);
                                            } else if (manage_animal_response == 3) {
                                                animalManagement.viewAnimals();
                                                System.out.print("\nEnter the ID of animal to remove it :- ");
                                                int chosenIDToRemove = scan.nextInt();
                                                scan.nextLine();
                                                if (animalManagement.removeAnimal(chosenIDToRemove)) {
                                                    System.out.println("\nAnimal with ID :- " + chosenIDToRemove + " has been removed from the database.\n");
                                                } else {
                                                    System.out.println("\nAnimal not found or not registered YET.\n");
                                                }
                                            } else if (manage_animal_response == 4) {
                                                animalManagement.viewAnimals();
                                            } else if (manage_animal_response == 5) {
                                                System.out.println("Going to previous Menu..\n");
                                                break;
                                            } else {
                                                System.out.println("\nError Not a Command Retry....\n");
                                                continue;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                            scan.nextLine();
                                            continue;
                                        }
                                    }
                                } else if (admin_response == 3) {
                                    while (true) {
                                        try {
                                            System.out.println("\nEnter your choice from below :- ");
                                            System.out.println("  (1) Print more details about all available events.");
                                            System.out.println("  (2) Modify event Details.");
                                            System.out.println("  (3) Return to the previous menu.");
                                            System.out.print("Enter your choice here :- ");
                                            int manage_event_response = scan.nextInt();
                                            scan.nextLine();
                                            if (manage_event_response == 1) {
                                                attractionManager.viewEvents();
                                            } else if (manage_event_response == 2) {
                                                attractionManager.viewEvents();
                                                System.out.print("\nEnter the ID of the Event you want to manage :- ");
                                                int id_selected_to_manage = scan.nextInt();
                                                scan.nextLine();
                                                System.out.print("Enter Opening time of event in 24hr format (eg.17:30) :- ");
                                                String opening_time = scan.nextLine();
                                                System.out.print("Enter Closing time of event in 24hr format (eg.19:45) :- ");
                                                String closing_time = scan.nextLine();
                                                System.out.print("Enter the Price of the Scheduled attraction :- ");
                                                double scheduled_price = scan.nextDouble();
                                                scan.nextLine();
                                                System.out.print("If you want to open the event Enter : '1' else Enter : '0'  :- ");
                                                int openorclose_input = scan.nextInt();
                                                scan.nextLine();
                                                if (attractionManager.manageEvent(id_selected_to_manage, opening_time, closing_time, openorclose_input, scheduled_price)) {
                                                    System.out.println("\nEvent Updated Successfully!.\n");
                                                }
                                            } else if (manage_event_response == 3) {
                                                System.out.println("Going to previous Menu..\n");
                                                break;
                                            } else {
                                                System.out.println("\nError Not a Command Retry....\n");
                                                continue;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                            scan.nextLine();
                                            continue;
                                        }
                                    }
                                } else if (admin_response == 4) {
                                    while (true) {
                                        try {
                                            System.out.println("\nSet Discounts :-");
                                            System.out.println("  (1) Add Discount");
                                            System.out.println("  (2) Modify Discount");
                                            System.out.println("  (3) Remove Discount");
                                            System.out.println("  (4) view Available Discounts");
                                            System.out.println("  (5) Return to previous Menu..");
                                            System.out.print("Enter your choice here :- ");
                                            int set_discount_response = scan.nextInt();
                                            scan.nextLine();
                                            if (set_discount_response == 1) {
                                                System.out.print("\nEnter Discount name :- ");
                                                String discount_category = scan.nextLine();
                                                System.out.print("Enter Discount Percentage (e.g., Enter -> 20 for 20%) :- ");
                                                String discountPercentage = scan.nextLine();
                                                System.out.print("Enter age at which Discount is given :- ");
                                                int age = scan.nextInt();
                                                scan.nextLine();
                                                System.out.print("Enter 1 if you want to provide discount to age >= " + age + " else enter 2. :- ");
                                                int cc = scan.nextInt();
                                                scan.nextLine();
                                                String discount_code = discount_category.concat(discountPercentage);
                                                if (cc == 1) {
                                                    discountManager.addDiscount(discount_code, Double.parseDouble(discountPercentage), age, true);
                                                } else if (cc == 2) {
                                                    discountManager.addDiscount(discount_code, Double.parseDouble(discountPercentage), age, false);
                                                } else {
                                                    System.out.println("\nError Not a Command Retry....\n");
                                                    continue;
                                                }
                                                System.out.println("Discount with code '" + discount_code + "' added successfully.");
                                            } else if (set_discount_response == 2) {
                                                discountManager.printAllDiscounts();
                                                System.out.print("Enter the Discount Code to Modify the Discount :- ");
                                                String discountcode = scan.nextLine();
                                                System.out.print("Enter new Discount Name :- ");
                                                String newDisName = scan.nextLine();
                                                System.out.print("Enter new age at which Discount is given :- ");
                                                int newage = scan.nextInt();
                                                scan.nextLine();
                                                System.out.print("Enter New Discount Percentage (e.g., Enter -> 20 for 20%) :- ");
                                                String newdiscountPercentage = scan.nextLine();
                                                System.out.print("Enter 1 if you want to provide discount to age >= " + newage + " else enter 2. :- ");
                                                int cc = scan.nextInt();
                                                scan.nextLine();
                                                String new_code = newDisName.concat(newdiscountPercentage);
                                                if (cc == 1) {
                                                    discountManager.modifyDiscount(discountcode, new_code, Double.parseDouble(newdiscountPercentage), newage, true);
                                                } else if (cc == 2) {
                                                    discountManager.modifyDiscount(discountcode, new_code, Double.parseDouble(newdiscountPercentage), newage, false);
                                                } else {
                                                    System.out.println("\nError Not a Command Retry....\n");
                                                    continue;
                                                }
                                            } else if (set_discount_response == 3) {
                                                discountManager.printAllDiscounts();
                                                System.out.println("Enter the Discount Code to remove the Discount :- ");
                                                String discount_code = scan.nextLine();
                                                if (discountManager.removeDiscount(discount_code)) {
                                                    System.out.print("\nDiscount Code :- " + discount_code + " has been removed from database.\n");
                                                } else {
                                                    System.out.println("\nDiscount not in database or not registered YET.\n");
                                                }
                                            } else if (set_discount_response == 4) {
                                                discountManager.printAllDiscounts();
                                            } else if (set_discount_response == 5) {
                                                System.out.println("Going to previous Menu..\n");
                                                break;
                                            } else {
                                                System.out.println("\nError Not a Command Retry....\n");
                                                continue;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                            scan.nextLine();
                                            continue;
                                        }
                                    }
                                } else if (admin_response == 5) {
                                    while (true) {
                                        try {
                                            System.out.println("\nManage Special Deals");
                                            System.out.println(" (1) view all special Deals.");
                                            System.out.println(" (2) Add a special Deal.");
                                            System.out.println(" (3) Remove a special Deals.");
                                            System.out.println(" (4) Return to previous menu.");
                                            System.out.print("Enter your choice here :- ");
                                            int manage_special_deal_response = scan.nextInt();
                                            scan.nextLine();
                                            if (manage_special_deal_response == 1) {
                                                specialDealManager.viewAllSpecialDeals();
                                            } else if (manage_special_deal_response == 2) {
                                                System.out.print("Enter the Number of tickets needed to buy :- ");
                                                int number_of_tickets = scan.nextInt();
                                                scan.nextLine();
                                                System.out.print("Enter the discount Percentage (Enter -> 15 for 15%) :- ");
                                                double discount_provided = scan.nextDouble();
                                                scan.nextLine();
                                                specialDealManager.addSpecialDeal(number_of_tickets, discount_provided);
                                                System.out.print("\nSpecial deal added successfully. ");
                                                System.out.print("\n\ninfo : buy " + number_of_tickets + "tickets and get " + discount_provided + "% discount.\n");
                                            } else if (manage_special_deal_response == 3) {
                                                specialDealManager.viewAllSpecialDeals();
                                                System.out.println("\nEnter the Special Deal ID to be removed :- ");
                                                int special_id = scan.nextInt();
                                                scan.nextLine();
                                                specialDealManager.removeSpecialDeal(special_id);
                                            } else if (manage_special_deal_response == 4) {
                                                System.out.println("Going to previous Menu..\n");
                                                break;
                                            } else {
                                                System.out.println("\nError Not a Command Retry....\n");
                                                continue;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                            scan.nextLine();
                                            continue;
                                        }
                                    }
                                } else if (admin_response == 6) {
                                    System.out.println("\nVisitor Statistics :- ");
                                    System.out.println(" --> Total Visitors :- " + visitorManager.getVisitorCount());
                                    System.out.println(" --> Total Revenue :- ₹" + revenue_count);
                                    System.out.println(" --> Most Popular Attraction was :- " + attractionManager.getMostPopularAttraction() + "\n");
                                } else if (admin_response == 7) {
                                    visitorManager.printFeedbacks();
                                } else if (admin_response == 8) {
                                    System.out.println("Logged Out successfully... \n");
                                    break;
                                } else {
                                    System.out.println("\nError Not a Command Retry....\n");
                                    continue;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                scan.nextLine();
                                continue;
                            }
                        }
                    } else {
                        System.out.println("\nYou have provided wrong credentials for Admin Details.\n\n retry...\n");
                        continue;
                    }
                } else if (taken_input == 2) {
                    while (true) {
                        try {
                            System.out.println("\nWhat would you like to do ?");
                            System.out.println("    (1) Register yourself");
                            System.out.println("    (2) Login as visitor");
                            System.out.println("    (3) Return to the previous menu");
                            System.out.print("Enter your choice here :- ");
                            int register_or_login = scan.nextInt();
                            scan.nextLine();
                            if (register_or_login == 1) {
                                System.out.print("Enter Visitor Name :- ");
                                String visitor_name = scan.nextLine();
                                System.out.print("Enter Visitor Age :- ");
                                int visitor_age = scan.nextInt();
                                scan.nextLine();
                                System.out.print("Enter Visitor Phone Number :- ");
                                String visitor_phno = scan.nextLine();
                                System.out.print("Enter Visitor Balance :- ");
                                double visitor_bal = scan.nextDouble();
                                scan.nextLine();
                                System.out.print("Enter Visitor Email :- ");
                                String visitor_email = scan.nextLine();
                                System.out.print("Enter Visitor Password :- ");
                                String visitor_password = scan.nextLine();
                                visitorManager.registerVisitor(visitor_name, visitor_age, visitor_phno, visitor_bal, visitor_email, visitor_password);
                                System.out.println("User" + visitor_name + "has been registered successfully!");
                            } else if (register_or_login == 2) {
                                System.out.print("Enter Visitor Email :- ");
                                String check_username = scan.nextLine();
                                System.out.print("Enter Visitor password :- ");
                                String check_password = scan.nextLine();
                                Visitor loggedInVisitor = visitorManager.loginVisitor(check_username, check_password);
                                while (true) {
                                    try {
                                        if (loggedInVisitor != null) {
                                            System.out.println("\nLogged in as " + loggedInVisitor.getName() + ".\n");
                                            System.out.println("Now choose what would you like to do ? \n");
                                            System.out.println("Visitor Menu :- ");
                                            System.out.println(" (1) Explore the Zoo");
                                            System.out.println(" (2) Buy Membership");
                                            System.out.println(" (3) Buy Tickets");
                                            System.out.println(" (4) View Discounts");
                                            System.out.println(" (5) View Special Deals For you.");
                                            System.out.println(" (6) Visit Animals");
                                            System.out.println(" (7) Visit Attractions");
                                            System.out.println(" (8) Check Balance and View My Information");
                                            System.out.println(" (9) Leave Feedback");
                                            System.out.println(" (0) Logout");
                                            System.out.print("Enter your choice here :- ");
                                            int visitor_response = scan.nextInt();
                                            scan.nextLine();
                                            if (visitor_response == 1) {
                                                while (true) {
                                                    try {
                                                        System.out.println("\nExplore the Zoo :-");
                                                        System.out.println(" (1) View Attractions");
                                                        System.out.println(" (2) View Animals");
                                                        System.out.println(" (3) Return to previous Menu..");
                                                        System.out.print("Enter your choice here :- ");
                                                        int explore_attraction_input = scan.nextInt();
                                                        scan.nextLine();
                                                        if (explore_attraction_input == 1) {
                                                            attractionManager.viewAttractions();
                                                        } else if (explore_attraction_input == 2) {
                                                            animalManagement.viewAnimalsforVisitors();
                                                        } else if (explore_attraction_input == 3) {
                                                            System.out.println("Going to previous Menu..\n");
                                                            break;
                                                        } else {
                                                            System.out.println("\nError Not a Command Retry....\n");
                                                            continue;
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                                        scan.nextLine();
                                                        continue;
                                                    }
                                                }
                                            } else if (visitor_response == 2) {
                                                System.out.println("\nBuy Membership :-");
                                                System.out.println(" (1) Basic Membership (₹20)");
                                                System.out.println(" (2) Premium Membership (₹50)");
                                                System.out.print("Enter your choice here :- ");
                                                int membership_selected = scan.nextInt();
                                                scan.nextLine();
                                                if (membership_selected == 1 && loggedInVisitor.getMembership() == -1) {
                                                    System.out.println("\nYou selected to buy Basic Membership");
                                                    System.out.print("wanna apply Discount Code? (y/n) : ");
                                                    String codecheck = scan.nextLine();
                                                    if (codecheck.equals("y")) {
                                                        System.out.print("Enter your Discount code here :- ");
                                                        String discount_code = scan.nextLine();
                                                        double to_pay = calculateDiscount(20, discountManager.getDiscountPercentage(discount_code, loggedInVisitor.getAge()));
                                                        double got_discount = (20.0 - to_pay) < 0 ? 0.0 : 20.0 - to_pay;
                                                        System.out.println("\nYou have got a Discount of ₹" + got_discount);
                                                        if (loggedInVisitor.getBalance() < to_pay) { // check for low balance??
                                                            System.out.println("\nSorry! You do not have Sufficient balance to complete the purchase.\n");
                                                        } else {
                                                            System.out.println("Please Pay ₹" + to_pay + " to grab it...");
                                                            System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                            String check = scan.nextLine();
                                                            if (check.equals("y")) {
                                                                loggedInVisitor.setBalance((loggedInVisitor.getBalance() - to_pay));
                                                                revenue_count += to_pay;
                                                                loggedInVisitor.setMembership(0);
                                                                System.out.println("\nPayment of ₹" + to_pay + " Done Successfully and now you are a 'Basic' user\n");
                                                            } else {
                                                                System.out.println("Payment Aborted by the user.");
                                                            }
                                                        }
                                                    } else {
                                                        if (loggedInVisitor.getBalance() < 20.0) { // check for low balance??
                                                            System.out.println("\nSorry! You do not have Sufficient balance to complete the purchase.\n");
                                                        } else {
                                                            System.out.println("Please Pay ₹20 to grab it...");
                                                            System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                            String check = scan.nextLine();
                                                            if (check.equals("y")) {
                                                                loggedInVisitor.setBalance((loggedInVisitor.getBalance() - 20));
                                                                revenue_count += 20;
                                                                loggedInVisitor.setMembership(0);
                                                                System.out.println("\nPayment of ₹" + 20 + " Done Successfully and now you are a 'Basic' user\n");
                                                            } else {
                                                                System.out.println("Payment Aborted by the user.");
                                                            }
                                                        }
                                                    }
                                                } else if ((membership_selected == 2 && (loggedInVisitor.getMembership() == -1)) || (membership_selected == 2 && loggedInVisitor.getMembership() == 0)) {
                                                    System.out.println("\nyou selected to buy Premium Membership");
                                                    System.out.print("wanna apply Discount Code? (y/n) : ");
                                                    String codecheck = scan.nextLine();
                                                    if (codecheck.equals("y")) {
                                                        System.out.print("Enter your Discount code here :- ");
                                                        String discount_code = scan.nextLine();
                                                        double to_pay = calculateDiscount(50, discountManager.getDiscountPercentage(discount_code, loggedInVisitor.getAge()));
                                                        double got_discount = (20.0 - to_pay) < 0 ? 0.0 : 20.0 - to_pay;
                                                        System.out.println("\nYou have got a Discount of ₹" + got_discount);
                                                        if (loggedInVisitor.getBalance() < to_pay) { // check for low balance??
                                                            System.out.println("\nSorry! You do not have Sufficient balance to complete the purchase.\n");
                                                        } else {
                                                            System.out.println("Please Pay ₹" + to_pay + " to grab it...");
                                                            System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                            String check = scan.nextLine();
                                                            if (check.equals("y")) {
                                                                loggedInVisitor.setBalance((loggedInVisitor.getBalance() - to_pay));
                                                                revenue_count += to_pay;
                                                                loggedInVisitor.setMembership(1);
                                                                System.out.println("\nPayment of ₹" + to_pay + " Done Successfully and now you are a 'Premium' user\n");
                                                            } else {
                                                                System.out.println("Payment Aborted by the user.");
                                                            }
                                                        }
                                                    } else {
                                                        if (loggedInVisitor.getBalance() < 50.0) { // check for low balance ??
                                                            System.out.println("\nSorry! You do not have Sufficient balance to complete the purchase.\n");
                                                        } else {
                                                            System.out.println("Please Pay ₹50 to grab it...");
                                                            System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                            String check = scan.nextLine();
                                                            if (check.equals("y")) {
                                                                loggedInVisitor.setBalance((loggedInVisitor.getBalance() - 50));
                                                                revenue_count += 50;
                                                                loggedInVisitor.setMembership(1);
                                                                System.out.println("\nPayment of ₹" + 50 + " Done Successfully and now you are a 'Premium' user\n");
                                                            } else {
                                                                System.out.println("Payment Aborted by the user.");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("\nYou already have selected membership or you have premium membership.\n");
                                                }
                                            } else if (visitor_response == 3) {
                                                while (true) {
                                                    try {
                                                        System.out.println("\nBuy tickets options :- \n");
                                                        System.out.println("  (1) View special deals for you.\n");
                                                        System.out.println("  (2) View special Discounts for you.\n");
                                                        System.out.println("  (3) jump to buy-ticket interface.\n");
                                                        System.out.println("  (4) Return to the previous menu");
                                                        System.out.print("Enter your choice here :- ");
                                                        int buy_ticket_response = scan.nextInt();
                                                        scan.nextLine();
                                                        if (buy_ticket_response == 1) {
                                                            specialDealManager.viewAllSpecialDeals();
                                                        } else if (buy_ticket_response == 2) {
                                                            discountManager.printAllDiscounts();
                                                        } else if (buy_ticket_response == 3) {
                                                            if (loggedInVisitor.getMembership() == 0) {
                                                                attractionManager.viewAttractions();
                                                                System.out.print("Enter the attraction ID for which you want ticket :- ");
                                                                int id_selected = scan.nextInt();
                                                                scan.nextLine();
                                                                Attraction attraction_buyer;
                                                                try {
                                                                    attraction_buyer = attractionManager.getAttractionById(id_selected);
                                                                } catch (NullPointerException e) {
                                                                    System.out.println("\nAttraction not found in database.\n");
                                                                    continue;
                                                                }
                                                                if (attraction_buyer.checkIsOpen()) // checking if attraction is open or closed
                                                                {
                                                                    System.out.print("\nEnter the Number of tickets you want to buy :- ");
                                                                    int number_of_tickets_tobuy = scan.nextInt();
                                                                    scan.nextLine();
                                                                    double costprice = (attraction_buyer.get_price() * number_of_tickets_tobuy);
                                                                    if (specialDealManager.best_special_deal(number_of_tickets_tobuy) != -1) {
                                                                        System.out.println("you are discounted with a special deal ID :- " + specialDealManager.best_special_deal(number_of_tickets_tobuy));
                                                                        System.out.print("wanna apply Discount Code? (y/n) : ");
                                                                        String codecheck = scan.nextLine();
                                                                        if (codecheck.equals("y")) {
                                                                            System.out.print("Enter your Discount code here :- ");
                                                                            String discount_code = scan.nextLine();
                                                                            double to_pay = calculateDiscount(costprice, discountManager.getDiscountPercentage(discount_code, loggedInVisitor.getAge()));
                                                                            System.out.println("Price without any discount :- ₹" + costprice);
                                                                            to_pay = calculateDiscount(to_pay, specialDealManager.getPercentageById(specialDealManager.best_special_deal(number_of_tickets_tobuy)));
                                                                            double got_discount = (costprice - to_pay) < 0 ? 0.0 : costprice - to_pay;
                                                                            System.out.println("\nYou have got a Discount of ₹" + got_discount);
                                                                            if (loggedInVisitor.getBalance() >= to_pay) {
                                                                                System.out.println("Please Pay ₹" + to_pay + " to grab it...");
                                                                                System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                                                String check = scan.nextLine();
                                                                                if (check.equals("y")) {
                                                                                    loggedInVisitor.setBalance((loggedInVisitor.getBalance() - to_pay));
                                                                                    revenue_count += to_pay;
                                                                                    loggedInVisitor.purchaseAttraction(id_selected, number_of_tickets_tobuy);
                                                                                    System.out.println("\nPayment of ₹" + to_pay + " Done Successfully to buy " + number_of_tickets_tobuy + " tickets for " + attraction_buyer.get_name() + " attraction\n");
                                                                                } else {
                                                                                    System.out.println("\nPayment Aborted by the user.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nPurchase aborted as your account balance was low.\n");
                                                                            }
                                                                        } else {
                                                                            // not applied discount code
                                                                            System.out.println("you are discounted with a special deal ID :- " + specialDealManager.best_special_deal(number_of_tickets_tobuy));
                                                                            System.out.println("Price without any discount :- ₹" + costprice);
                                                                            double to_pay = calculateDiscount(costprice, specialDealManager.getPercentageById(specialDealManager.best_special_deal(number_of_tickets_tobuy)));
                                                                            double got_discount = (costprice - to_pay) < 0 ? 0.0 : costprice - to_pay;
                                                                            System.out.println("\nYou have got a Discount of ₹" + got_discount);
                                                                            if (loggedInVisitor.getBalance() >= to_pay) {
                                                                                System.out.println("Please Pay ₹" + to_pay + " to grab it...");
                                                                                System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                                                String check = scan.nextLine();
                                                                                if (check.equals("y")) {
                                                                                    loggedInVisitor.setBalance((loggedInVisitor.getBalance() - to_pay));
                                                                                    revenue_count += to_pay;
                                                                                    loggedInVisitor.purchaseAttraction(id_selected, number_of_tickets_tobuy);
                                                                                    System.out.println("\nPayment of ₹" + to_pay + " Done Successfully to buy " + number_of_tickets_tobuy + " tickets for " + attraction_buyer.get_name() + " attraction\n");
                                                                                } else {
                                                                                    System.out.println("\nPayment Aborted by the user.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nPurchase aborted as your account balance was low.\n");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        System.out.println("No special Deals were applied!.");
                                                                        System.out.print("wanna apply Discount Code? (y/n) : ");
                                                                        String codecheck = scan.nextLine();
                                                                        if (codecheck.equals("y")) {
                                                                            System.out.print("Enter your Discount code here :- ");
                                                                            String discount_code = scan.nextLine();
                                                                            double to_pay = calculateDiscount(costprice, discountManager.getDiscountPercentage(discount_code, loggedInVisitor.getAge()));
                                                                            System.out.println("Price without any discount :- ₹" + costprice);
                                                                            double got_discount = (costprice - to_pay) < 0 ? 0.0 : costprice - to_pay;
                                                                            System.out.println("\nYou have got a Discount of ₹" + got_discount);
                                                                            if (loggedInVisitor.getBalance() >= to_pay) {
                                                                                System.out.println("Please Pay ₹" + to_pay + " to grab it...");
                                                                                System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                                                String check = scan.nextLine();
                                                                                if (check.equals("y")) {
                                                                                    loggedInVisitor.setBalance((loggedInVisitor.getBalance() - to_pay));
                                                                                    revenue_count += to_pay;
                                                                                    loggedInVisitor.purchaseAttraction(id_selected, number_of_tickets_tobuy);
                                                                                    System.out.println("\nPayment of ₹" + to_pay + " Done Successfully to buy " + number_of_tickets_tobuy + " tickets for " + attraction_buyer.get_name() + " attraction\n");
                                                                                } else {
                                                                                    System.out.println("\nPayment Aborted by the user.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nPurchase aborted as your account balance was low.\n");
                                                                            }

                                                                        } else {
                                                                            // no special deal no discount code.
                                                                            double to_pay = costprice;
                                                                            System.out.println("Price without any discount :- ₹" + costprice);
                                                                            double got_discount = (costprice - to_pay) < 0 ? 0.0 : costprice - to_pay;
                                                                            System.out.println("\nYou have got a Discount of ₹" + got_discount);
                                                                            if (loggedInVisitor.getBalance() >= to_pay) {
                                                                                System.out.println("Please Pay ₹" + to_pay + " to grab it...");
                                                                                System.out.print("if paid enter 'y' else 'n' (y/n) :- ");
                                                                                String check = scan.nextLine();
                                                                                if (check.equals("y")) {
                                                                                    loggedInVisitor.setBalance((loggedInVisitor.getBalance() - to_pay));
                                                                                    revenue_count += to_pay;
                                                                                    loggedInVisitor.purchaseAttraction(id_selected, number_of_tickets_tobuy);
                                                                                    System.out.println("\nPayment of ₹" + to_pay + " Done Successfully to buy " + number_of_tickets_tobuy + " tickets for " + attraction_buyer.get_name() + " attraction\n");
                                                                                } else {
                                                                                    System.out.println("\nPayment Aborted by the user.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nPurchase aborted as your account balance was low.\n");
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    System.out.println("\nSorry :-( the selected attraction is Closed.\n");
                                                                }

                                                            } else {
                                                                System.out.println("\nSorry! you can buy ticket only as a Basic user.\n");
                                                                continue;
                                                            }
                                                        } else if (buy_ticket_response == 4) {
                                                            System.out.println("Going Back to the previous menu\n");
                                                            break;
                                                        } else {
                                                            System.out.println("\nError Not a Command Retry....\n");
                                                            continue;
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                                        scan.nextLine();
                                                        continue;
                                                    }
                                                }
                                            } else if (visitor_response == 4) {
                                                discountManager.printAllDiscounts();
                                            } else if (visitor_response == 5) {
                                                specialDealManager.viewAllSpecialDeals();
                                            } else if (visitor_response == 6) {
                                                System.out.println("\nZootopia welcomes you to VISIT ANIMALS.\n");
                                                animalManagement.viewAnimals();
                                                System.out.print("\nEnter the ID of the Animal you want to visit :- ");
                                                int animal_id_selected = scan.nextInt();
                                                scan.nextLine();
                                                System.out.println("\nWhat would you like to do?");
                                                System.out.println("  (1) feed the " + animalManagement.getAnimalName(animal_id_selected));
                                                System.out.println("  (2) Read about " + animalManagement.getAnimalName(animal_id_selected));
                                                System.out.print("Enter Interaction type here :- ");
                                                int interact_response = scan.nextInt();
                                                scan.nextLine();
                                                Animal AnimalChosen = animalManagement.getAnimalById(animal_id_selected);
                                                if (interact_response == 1) {
                                                    AnimalChosen.interactWithAnimal("feed");
                                                } else if (interact_response == 2) {
                                                    AnimalChosen.interactWithAnimal("read");
                                                } else {
                                                    System.out.println("\nError Not a Command Retry....\n");
                                                    continue;
                                                }
                                            } else if (visitor_response == 7) {
                                                if (loggedInVisitor.getMembership() == 1) { //premium members can visit attractions free of cost
                                                    System.out.println("\nZootopia welcomes you to VISIT ATTRACTIONS.\n");
                                                    attractionManager.viewAttractions();
                                                    System.out.print("Enter the Attraction ID to visit :- ");
                                                    int ch = scan.nextInt();
                                                    scan.nextLine();
                                                    Attraction selectedAttraction = attractionManager.getAttractionById(ch);
                                                    if (selectedAttraction != null && selectedAttraction.checkIsOpen()) {
                                                        System.out.println("You are now visiting Attraction ID :- " + selectedAttraction.get_attraction_serial_number());
                                                        System.out.println("Name :-  " + selectedAttraction.get_name());
                                                        System.out.println("Description: " + selectedAttraction.get_description());
                                                        selectedAttraction.increase_visitor_count();
                                                        System.out.println("Visit to attraction was ended \n\nThankyou...\n");
                                                    } else {
                                                        System.out.println("Attraction with ID " + ch + " not found or closed now.");
                                                    }
                                                } else {
                                                    Map<Integer, Integer> purchasedAttractionTickets = loggedInVisitor.getPurchasedAttractionTickets();
                                                    if (!purchasedAttractionTickets.isEmpty()) {
                                                        System.out.println("\nZootopia welcomes you to VISIT ATTRACTIONS.\n");
                                                        System.out.println("Attractions purchased by visitor " + loggedInVisitor.getName() + " :-");
                                                        for (Map.Entry<Integer, Integer> entry : purchasedAttractionTickets.entrySet()) {
                                                            int attractionId = entry.getKey();
                                                            int numberOfTickets = entry.getValue();
                                                            System.out.println("Attraction ID :- " + attractionId + ", Number of Tickets :- " + numberOfTickets + "\n");
                                                        }
                                                        System.out.print("Enter the Attraction ID to Visit there :- ");
                                                        int selectedAttractionId = scan.nextInt();
                                                        scan.nextLine();
                                                        if (purchasedAttractionTickets.containsKey(selectedAttractionId) && purchasedAttractionTickets.get(selectedAttractionId) > 0) {
                                                            Attraction selectedAttraction = attractionManager.getAttractionById(selectedAttractionId);
                                                            System.out.println("\nYou are now visiting Attraction ID :-  " + selectedAttractionId + ":");
                                                            System.out.println("Name: " + selectedAttraction.get_name());
                                                            System.out.println("Description: " + selectedAttraction.get_description());
                                                            selectedAttraction.increase_visitor_count();
                                                            System.out.println("Visit to attraction was ended \n\nThankyou...\n");
                                                            // Decrease the ticket count for the selected attraction
                                                            purchasedAttractionTickets.put(selectedAttractionId, purchasedAttractionTickets.get(selectedAttractionId) - 1);
                                                        } else {
                                                            System.out.println("Attraction with ID " + selectedAttractionId + " have no available tickets.");
                                                        }
                                                    } else {
                                                        System.out.println("\n" + loggedInVisitor.getName() + " has not purchased any attractions.");
                                                    }
                                                }
                                            } else if (visitor_response == 8) {
                                                visitorManager.printVisitorInformation(loggedInVisitor);
                                            } else if (visitor_response == 9) {
                                                System.out.print("\nEnter your short feedback here :- ");
                                                String feed = scan.nextLine();
                                                loggedInVisitor.setFeedback(feed);
                                                System.out.print("\n Your feedback has been submitted successfully.\nyour feedback is more precious than gold to us.\n");
                                            } else if (visitor_response == 0) {
                                                System.out.println("Logged Out successfully... \n");
                                                break;
                                            } else {
                                                System.out.println("\nError Not a Command Retry....\n");
                                                continue;
                                            }
                                        } else {
                                            System.out.println("\nLogin credentials not correct.");
                                            System.out.println("please register first or login again with right details.");
                                            break;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                                        scan.nextLine();
                                        continue;
                                    }
                                }
                            } else if (register_or_login == 3) {
                                System.out.println("Going Back to the previous menu\n");
                                break;
                            } else {
                                System.out.println("\nError Not a Command Retry....\n");
                                continue;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                            scan.nextLine();
                            continue;
                        }
                    }
                } else if (taken_input == 3) {
                    System.out.println("\nViewing Spacial Deals for you Only......\n");
                    specialDealManager.viewAllSpecialDeals();
                } else if (taken_input == 4) {
                    System.out.println("\n Exiting....Thanks For Visiting ZOOtopia!\n");
                    scan.close();
                    break;
                } else {
                    System.out.println("\nError Not a Command Retry....\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Invalid input! Enter valid Integer Only. Retry...\n");
                scan.nextLine();
                continue;
            }
        }
    }
}

abstract class Animal {

    protected int id;
    protected String name;
    protected String category;
    protected String description;
    protected String noise;

    public Animal(String name, String category, String description, String noise) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.noise = noise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public abstract void interactWithAnimal(String interactionType);
}

class Mammal extends Animal {

    public Mammal(String name, String description, String noise) {
        super(name, "Mammal", description, noise);
    }

    @Override
    public void interactWithAnimal(String interactionType) {
        System.out.println();
        if (interactionType.equalsIgnoreCase("feed")) {
            System.out.println("Animal " + name + " belongs to " + category + " category.");
            System.out.println(name + " makes a noise :- " + noise);
        } else if (interactionType.equalsIgnoreCase("read")) {
            System.out.println("Animal " + name + " belongs to " + category + " category.");
            System.out.println("This animal has history :- " + description);
        }
    }
}

class Amphibian extends Animal {

    public Amphibian(String name, String description, String noise) {
        super(name, "Amphibian", description, noise);
    }

    @Override
    public void interactWithAnimal(String interactionType) {
        System.out.println();
        if (interactionType.equalsIgnoreCase("feed")) {
            System.out.println("Animal " + name + " belongs to " + category + " category.");
            System.out.println(name + " makes a noise :- " + noise);
        } else if (interactionType.equalsIgnoreCase("read")) {
            System.out.println("Animal " + name + " belongs to " + category + " category.");
            System.out.println("This animal has history :- " + description);
        }
    }
}

class Reptile extends Animal {

    public Reptile(String name, String description, String noise) {
        super(name, "Reptile", description, noise);
    }

    @Override
    public void interactWithAnimal(String interactionType) {
        System.out.println();
        if (interactionType.equalsIgnoreCase("feed")) {
            System.out.println("Animal " + name + " belongs to " + category + " category.");
            System.out.println(name + " makes a noise :- " + noise);
        } else if (interactionType.equalsIgnoreCase("read")) {
            System.out.println("Animal " + name + " belongs to " + category + " category.");
            System.out.println("This animal has history :- " + description);
        }
    }
}

class AnimalManagement {

    private final List<Animal> animals;
    private int nextAnimalId;

    public AnimalManagement() {
        animals = new ArrayList<>();
        nextAnimalId = 1;
    }

    public void addAnimal(Animal animal) {
        animal.setId(nextAnimalId++);
        animals.add(animal);
    }

    public Animal getAnimalById(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null; // Animal ID not found
    }

    public String getAnimalName(int id) {
        Animal animalname = null;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animalname = animal;
                break;
            }
        }
        return animalname.getName();
    }

    public boolean removeAnimal(int id) {
        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            animals.remove(animalToRemove);
            return true; // Animal was removed
        }
        return false; // Animal was not found and not removed
    }

    public void viewAnimals() {
        System.out.println("\nPrinting all the animal details :-\n");
        for (Animal animal : animals) {
            System.out.println("Animal ID :- " + animal.getId());
            System.out.println("Name :- " + animal.getName());
            System.out.println("Category :- " + animal.getCategory());
            System.out.println("Description :- " + animal.getDescription());
            System.out.println("Noise :- " + animal.getNoise());
            System.out.println();
        }
        System.out.println();
    }

    public void viewAnimalsforVisitors() {
        System.out.println("\nThese are the animals you can visit :-\n");
        for (Animal animal : animals) {
            System.out.println("Name :- " + animal.getName());
            System.out.println("Category :- " + animal.getCategory());
            System.out.println("Description :- " + animal.getDescription());
            System.out.println();
        }
        System.out.println();
    }

    public void modifyAnimalDetails(int id, String name, String description, String noise, int category) {
        boolean isfound = false;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                if (category == 1) {
                    animal.setCategory("Mammal");
                } else if (category == 2) {
                    animal.setCategory("Amphibian");
                } else if (category == 3) {
                    animal.setCategory("Reptile");
                } else {
                    System.out.println("\nWrong Inputs to modify animal type.\n");
                    return;
                }
                isfound = true;
                animal.setName(name);
                animal.setDescription(description);
                animal.setNoise(noise);
                System.out.println("\n Animal's Detials were upgraded Successfully!\n");
                break;
            }
        }
        if (!isfound) {
            System.out.println("\nAnimal not found with ID :- " + id + "\n");
        }
    }
}

class DiscountData {

    private String discountCode;
    private double percentage;
    private int age;
    private boolean morethan;

    public DiscountData(String discountCode, double percentage, int age, boolean morethan) {
        this.discountCode = discountCode;
        this.percentage = percentage;
        this.age = age;
        this.morethan = morethan;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public boolean getAgeCondition() {
        return morethan;
    }

    public void setMorethan(boolean morethan) {
        this.morethan = morethan;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class DiscountManager implements DiscountInterface {

    private final Map<String, DiscountData> discounts;

    public DiscountManager() {
        this.discounts = new HashMap<>();
    }

    @Override
    public void addDiscount(String discountCode, double percentage, int age, boolean morethan) {
        discounts.put(discountCode, new DiscountData(discountCode, percentage, age, morethan));
    }

    @Override
    public boolean removeDiscount(String discountCode) {
        if (discounts.containsKey(discountCode)) {
            discounts.remove(discountCode);
            return true;
        }
        return false;
    }

    @Override
    public double getDiscountPercentage(String discountCode, int visitorAge) {
        if (discounts.containsKey(discountCode)) {
            DiscountData discount = discounts.get(discountCode);
            if (discount.getAgeCondition() && visitorAge >= discount.getAge()) {
                System.out.println("Discount code :- " + discountCode + " applied successfully.");
                return discount.getPercentage();
            } else if (!discount.getAgeCondition() && visitorAge <= discount.getAge()) {
                System.out.println("Discount code :- " + discountCode + " applied successfully.");
                return discount.getPercentage();
            } else { // visitor is not eligible
                System.out.println("You are Not eligible for the discount by age.");
                return 0.0;
            }
        }
        System.out.println("Sorry! Discount code not found.");
        return 0.0; // Default to 0% if discount not found
    }

    @Override
    public void printAllDiscounts() {
        System.out.println("\nPrinting all Available Discounts :- \n");
        for (Map.Entry<String, DiscountData> entry : discounts.entrySet()) {
            System.out.println("Discount Code: " + entry.getKey());
            System.out.println("Discount Percentage: " + entry.getValue().getPercentage() + "%");
            System.out.println("Age: " + entry.getValue().getAge());
            if (entry.getValue().getAgeCondition()) {
                System.out.println("Discount is valid for all ages >= (greater than or equal to) " + entry.getValue().getAge());
            } else {
                System.out.println("Discount is valid for all ages <= (less than or equal to) " + entry.getValue().getAge());
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void modifyDiscount(String discountCode, String newDiscountCode, double newPercentage, int newAge, boolean newMoreThan) {
        if (discounts.containsKey(discountCode)) {
            DiscountData discount = discounts.get(discountCode);
            discount.setDiscountCode(newDiscountCode);
            discount.setPercentage(newPercentage);
            discount.setAge(newAge);
            discount.setMorethan(newMoreThan);
            discounts.remove(discountCode);
            discounts.put(newDiscountCode, discount);
            System.out.println("\nDiscount updated Successfully!");
            return;
        }
        System.out.println("\nDiscount Not found in database.\n");
    }
}

class SpecialDeal {

    private final int id;
    private int minimumRequired;
    private double discountPercentage;

    public SpecialDeal(int id, int minimumRequired, double discountPercentage) {
        this.id = id;
        this.minimumRequired = minimumRequired;
        this.discountPercentage = discountPercentage;
    }

    public int getId() {
        return id;
    }

    public int getMinimumRequired() {
        return minimumRequired;
    }

    public void setMinimumRequired(int minimumRequired) {
        this.minimumRequired = minimumRequired;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}

class SpecialDealManager {

    private final Map<Integer, SpecialDeal> specialDeals;
    private int nextDealId;

    public SpecialDealManager() {
        this.specialDeals = new HashMap<>();
        this.nextDealId = 1;
    }

    public void addSpecialDeal(int minimumRequired, double discountPercentage) {
        int id = nextDealId++;
        specialDeals.put(id, new SpecialDeal(id, minimumRequired, discountPercentage));
    }

    public void removeSpecialDeal(int id) {
        specialDeals.remove(id);
    }

    public double calculateSpecialDiscount(int totalAttractions) {
        double totalDiscount = 0.0;
        for (Map.Entry<Integer, SpecialDeal> entry : specialDeals.entrySet()) {
            if (totalAttractions > entry.getValue().getMinimumRequired()) {
                totalDiscount += entry.getValue().getDiscountPercentage(); // will all be considered or only one
                // code
            }
        }
        return totalDiscount;
    }

    public void viewAllSpecialDeals() {
        System.out.println("\nPrinting Special Deals:\n");
        for (Map.Entry<Integer, SpecialDeal> entry : specialDeals.entrySet()) {
            System.out.println("Special Deal ID :- " + entry.getValue().getId());
            System.out.println("Minimum tickets Required :- " + entry.getValue().getMinimumRequired() + " tickets");
            System.out.println("Discount Percentage provided :- " + (entry.getValue().getDiscountPercentage()) + "%");
            System.out.println();
        }
        System.out.println();
    }

    public double getPercentageById(int id) {
        for (Map.Entry<Integer, SpecialDeal> entry : specialDeals.entrySet()) {
            if (entry.getKey() == id) {
                // SpecialDeal specialDeal = entry.getValue();
                return entry.getValue().getDiscountPercentage();
            }
        }
        return 0.0;
    }

    public int best_special_deal(int total_tickets) {
        int best_id = -1; // Initialize with an invalid ID, e.g., -1
        double maxDiscount = 0;
        for (Map.Entry<Integer, SpecialDeal> entry : specialDeals.entrySet()) {
            SpecialDeal specialDeal = entry.getValue();
            if (total_tickets > specialDeal.getMinimumRequired()) {
                double discount = specialDeal.getDiscountPercentage();
                if (discount > maxDiscount) {
                    maxDiscount = discount;
                    best_id = entry.getKey();
                }
            }
        }
        return best_id;
    }
}

class Visitor {

    private final String name;
    private final int age;
    private final String phone;
    private final String email;
    private final String password;
    Map<Integer, Integer> purchasedAttractionTickets = new HashMap<>();
    private double balance;
    private int membership = -1; // 0 for basic and 1 for premium and -1 for none.
    private String feedback = "";

    public Visitor(String name, int age, String phone, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership = -1;
    }

    public int getMembership() {
        return membership;
    }

    public void setMembership(int n) {
        this.membership = n;
    }

    public void purchaseAttraction(int attractionId, int numberOfTickets) {
        if (purchasedAttractionTickets.containsKey(attractionId)) {
            // Attraction was previously purchased, so update the number of tickets
            int existingTickets = purchasedAttractionTickets.get(attractionId);
            purchasedAttractionTickets.put(attractionId, existingTickets + numberOfTickets);
        } else {
            // Attraction is being purchased for the first time
            purchasedAttractionTickets.put(attractionId, numberOfTickets);
        }
    }

    public Map<Integer, Integer> getPurchasedAttractionTickets() {
        return purchasedAttractionTickets;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

class VisitorManager {

    private final List<Visitor> visitors;
    private int visitor_count = 0;

    public VisitorManager() {
        this.visitors = new ArrayList<>();
    }

    public void registerVisitor(String name, int age, String phone, double balance, String email, String password) {
        Visitor visitor = new Visitor(name, age, phone, balance, email, password);
        visitor_count++;
        visitors.add(visitor);
    }

    public Visitor loginVisitor(String email, String password) {
        for (Visitor visitor : visitors) {
            if ((visitor.getEmail()).equals(email) && (visitor.getPassword()).equals(password)) {
                return visitor;
            }
        }
        return null; // Visitor not found
    }

    public int getVisitorCount() {
        return visitor_count;
    }

    public void printVisitorInformation(Visitor visitor) {
        System.out.println("\nPrinting all Information about " + visitor.getName() + ".\n");
        if (visitor != null) {
            System.out.println("Visitor's name :- " + visitor.getName());
            System.out.println("Visitor's Age :- " + visitor.getAge());
            System.out.println("Visitor's Phone no. :- " + visitor.getPhone());
            if (visitor.getMembership() == -1) {
                System.out.println("Visitors's Membership :- NONE");
            } else if (visitor.getMembership() == 0) {
                System.out.println("Visitors's Membership :- Basic");
            } else if (visitor.getMembership() == 1) {
                System.out.println("Visitors's Membership :- Premium");
            }
            System.out.println("Visitor's Balance Available :- " + visitor.getBalance());
            System.out.println("Visitor's E-Mail ID :- " + visitor.getEmail());
            System.out.println("Visitor's Password :- " + visitor.getPassword());
            System.out.println("Visitor's Feedback :- " + visitor.getFeedback());
        }
        System.out.println();
        Map<Integer, Integer> purchasedAttractionTickets = visitor.getPurchasedAttractionTickets();
        System.out.println("\nPurchased Attractions :- ");
        for (Map.Entry<Integer, Integer> entry : purchasedAttractionTickets.entrySet()) {
            int attractionId = entry.getKey();
            int numberOfTickets = entry.getValue();
            System.out.println("Attraction ID :- " + attractionId + ", Number of Tickets :- " + numberOfTickets);
            System.out.println();
        }
    }

    public void printFeedbacks() {
        System.out.println("\nPrinting all the visitor Feedbacks :- \n");
        for (Visitor visitor : visitors) {
            System.out.println("Visitor Name: " + visitor.getName());
            System.out.println("Visitor Feedback: " + visitor.getFeedback());
            System.out.println();
        }
        System.out.println();
    }
}

class ZooAttraction implements Attraction {

    private final int attractionId;
    private String name;
    private String description;
    private double ticketPrice;
    private boolean isOpen;
    private String openingTime;
    private String closingTime;
    private int ticketedVisitorsCount;

    public ZooAttraction(int attractionId, String name, String description, double ticketPrice) {
        this.attractionId = attractionId;
        this.name = name;
        this.description = description;
        this.ticketPrice = ticketPrice;
        this.isOpen = false;
        this.ticketedVisitorsCount = 0;
    }

    @Override
    public int get_visitor_count() {
        return ticketedVisitorsCount;
    }

    @Override
    public void increase_visitor_count() {
        ticketedVisitorsCount++;
    }

    @Override
    public int get_attraction_serial_number() {
        return attractionId;
    }

    @Override
    public String get_name() {
        return name;
    }

    @Override
    public String getOpeningtime() {
        return openingTime;
    }

    @Override
    public void setOpeningtime(String time) {
        this.openingTime = time;
    }

    @Override
    public String getClosingtime() {
        return closingTime;
    }

    @Override
    public void setClosingtime(String time) {
        this.closingTime = time;
    }

    @Override
    public void setIsOpen(boolean input) {
        this.isOpen = input;
    }

    @Override
    public boolean checkIsOpen() {
        return isOpen;
    }

    @Override
    public String get_description() {
        return description;
    }

    @Override
    public double get_price() {
        return ticketPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

abstract class AttractionManager {

    private final Map<Integer, Attraction> attractions;
    private int attractionCounter;

    public AttractionManager() {
        attractions = new HashMap<>();
        attractionCounter = 1;
    }

    public void addAttraction(String name, String description, double ticketPrice) {
        attractions.put(attractionCounter, createAttraction(attractionCounter, name, description, ticketPrice));
        attractionCounter++;
    }

    public void viewAttractions() {
        System.out.println("\nPrinting all the attractions available :- \n");
        for (Map.Entry<Integer, Attraction> entry : attractions.entrySet()) {
            Attraction attraction = entry.getValue();
            System.out.println("Attraction ID :- " + attraction.get_attraction_serial_number());
            System.out.println("Name :- " + attraction.get_name());
            System.out.println("Description :- " + attraction.get_description());
            System.out.println("Ticket Price :- ₹" + attraction.get_price());
            System.out.println("Total visitors visited yet :- " + attraction.get_visitor_count());
            if (attraction.checkIsOpen()) {
                System.out.println("This Attraction is OPEN now.");
            } else {
                System.out.println("This Attraction is CLOSED now.");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getMostPopularAttraction() {
        Attraction mostPopular = null;
        int maxVisitorCount = -1;
        for (Map.Entry<Integer, Attraction> entry : attractions.entrySet()) {
            Attraction attraction = entry.getValue();
            int visitorCount = attraction.get_visitor_count();
            if (visitorCount > maxVisitorCount) { // calculating the maximum visitor count across all attractions
                mostPopular = attraction;
                maxVisitorCount = visitorCount;
            }
        }
        return mostPopular.get_name();
    }

    public void viewEvents() {
        System.out.println("\nPrinting all the Infromation about Events available :- \n");
        for (Map.Entry<Integer, Attraction> entry : attractions.entrySet()) {
            Attraction attraction = entry.getValue();
            System.out.println("Event ID :- " + attraction.get_attraction_serial_number());
            System.out.println("Name :- " + attraction.get_name());
            System.out.println("Description :- " + attraction.get_description());
            System.out.println("Ticket Price :- ₹" + attraction.get_price());
            if (attraction.checkIsOpen()) {
                System.out.println("Event is OPEN.");
            } else {
                System.out.println("Event is CLOSED.");
            }
            System.out.println("Opening Time :- " + attraction.getOpeningtime());
            System.out.println("Closing Time :- " + attraction.getClosingtime());
            System.out.println("Total Ticketed Visitors :- " + attraction.get_visitor_count());
            System.out.println();
        }
        System.out.println();
    }

    public void removeAttraction(int id) {
        attractions.remove(id);
    }

    public boolean manageEvent(int id, String open_time, String close_time, int openorclose, double price) {
        if (attractions.containsKey(id)) {
            Attraction attraction = attractions.get(id);
            if (openorclose == 0) {
                attraction.setIsOpen(false);
                attraction.setOpeningtime(open_time);
                attraction.setClosingtime(close_time);
                attraction.setTicketPrice(price);
                return true;
            } else if (openorclose == 1) {
                attraction.setIsOpen(true);
                attraction.setOpeningtime(open_time);
                attraction.setClosingtime(close_time);
                attraction.setTicketPrice(price);
                return true;
            } else {
                System.out.println("\nInvalid Choice Enter 0 or 1 ONLY.\n");
                return false;
            }
        }
        System.out.println("Chosen attraction is invalid or not in database.");
        return false; // Attraction not found
    }

    public Attraction getAttractionById(int attractionId) {
        for (Map.Entry<Integer, Attraction> entry : attractions.entrySet()) {
            if (entry.getKey() == attractionId) {
                return entry.getValue();
            }
        }
        return null; // Attraction not found
    }

    public boolean modifyAllAttraction(int id, String newName, String description, String price) {
        if (attractions.containsKey(id)) {
            Attraction attraction = attractions.get(id);
            attraction.setName(newName);
            attraction.setDescription(description);
            attraction.setTicketPrice(Double.parseDouble(price));
            return true;
        }
        System.out.println("Chosen attraction is invalid or not in database.");
        return false; // Attraction not found
    }

    public boolean modifyAttraction(int id, int modify_attraction_response, String newName) {
        if (attractions.containsKey(id)) {
            Attraction attraction = attractions.get(id);
            switch (modify_attraction_response) {
                case 1:
                    attraction.setName(newName);
                    break;
                case 2:
                    attraction.setDescription(newName);
                    break;
                case 3:
                    attraction.setTicketPrice(Double.parseDouble(newName));
                    break;
                default:
                    System.out.println("Invalid modification choice.");
                    return false;
            }
            return true;
        }
        System.out.println("Chosen attraction is invalid or not in database.");
        return false; // Attraction not found
    }

    protected abstract Attraction createAttraction(int id, String name, String description, double ticketPrice);
}

class InitiateAttractionManager extends AttractionManager {

    @Override
    protected Attraction createAttraction(int id, String name, String description, double ticketPrice) {
        return new ZooAttraction(id, name, description, ticketPrice);
    }
}
