import java.util.ArrayList;
import java.util.Scanner;

class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phoneNumber;
    }
}

class Phonebook {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public Phonebook() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    public void updateContact() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }
        
        System.out.println("--- All Contacts ---");
        viewContact();
        
        System.out.print("Enter name of contact to update: ");
        String name = scanner.nextLine();
        
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new phone number: ");
                String newPhone = scanner.nextLine();
                c.setPhoneNumber(newPhone);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }
        
        System.out.println("--- All Contacts ---");
        viewContact();
        
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void viewContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void viewContact() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c.toString());
            System.out.println("-------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("\nPHONEBOOK MENU");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. View Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    phonebook.addContact();
                    break;
                case 2:
                    phonebook.updateContact();
                    break;
                case 3:
                    System.out.println("1. View All Contacts");
                    System.out.println("2. View Specific Contact");
                    System.out.print("Enter choice: ");
                    int viewChoice = 0;
                    
                    try {
                        viewChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        break;
                    }
                    
                    if (viewChoice == 1) {
                        phonebook.viewContact();
                    } else if (viewChoice == 2) {
                        System.out.print("Enter name: ");
                        String searchName = scanner.nextLine();
                        phonebook.viewContact(searchName);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    phonebook.deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}