import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name, phone;
    Contact(String name, String phone) { this.name = name; this.phone = phone; }
    public String toString() { return "Name: " + name + "\nPhone: " + phone; }
}

public class Main {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static String ask(String prompt) { System.out.print(prompt); return scanner.nextLine().trim(); }

    static Contact find(String name) {
        for (Contact c : contacts)
            if (c.name.equalsIgnoreCase(name)) return c;
        return null;
    }

    static void viewAll() {
        if (contacts.isEmpty()) { System.out.println("Phonebook is empty."); return; }
        System.out.println("Total contacts: " + contacts.size());
        for (int i = 0; i < contacts.size(); i++)
            System.out.println("-------------------\n[" + (i + 1) + "]\n" + contacts.get(i));
        System.out.println("-------------------");
    }

    static void addContact() {
        String name = ask("Enter Name: ");
        if (name.isEmpty()) { System.out.println("Name cannot be empty."); return; }
        if (find(name) != null) { System.out.println("A contact with that name already exists."); return; }
        String phone = ask("Enter Phone Number: ");
        if (phone.isEmpty()) { System.out.println("Phone number cannot be empty."); return; }
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    static void updateContact() {
        if (contacts.isEmpty()) { System.out.println("Phonebook is empty."); return; }
        viewAll();
        Contact c = find(ask("Enter name of contact to update: "));
        if (c == null) { System.out.println("Contact not found."); return; }
        System.out.println("Update: 1. Name  2. Phone Number  3. Both");
        int ch = Integer.parseInt(ask("Enter choice: "));
        if (ch == 1 || ch == 3) { String n = ask("Enter new name: "); if (!n.isEmpty()) c.name = n; }
        if (ch == 2 || ch == 3) { String p = ask("Enter new phone number: "); if (!p.isEmpty()) c.phone = p; }
        System.out.println(ch >= 1 && ch <= 3 ? "Contact updated successfully." : "Invalid choice.");
    }

    static void deleteContact() {
        if (contacts.isEmpty()) { System.out.println("Phonebook is empty."); return; }
        viewAll();
        String name = ask("Enter name to delete: ");
        Contact c = find(name);
        if (c == null) { System.out.println("Contact not found."); return; }
        if (ask("Are you sure you want to delete " + c.name + "? (y/n): ").equalsIgnoreCase("y")) {
            contacts.remove(c);
            System.out.println("Contact deleted successfully.");
        } else System.out.println("Deletion cancelled.");
    }

    static void searchContact() {
        if (contacts.isEmpty()) { System.out.println("Phonebook is empty."); return; }
        String term = ask("Enter search term: ").toLowerCase();
        boolean found = false;
        for (Contact c : contacts) {
            if (c.name.toLowerCase().contains(term) || c.phone.contains(term)) {
                System.out.println(c + "\n-------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No contacts matched \"" + term + "\".");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== PHONEBOOK MENU =====");
            System.out.println("1. Add  2. Update  3. View  4. Search  5. Delete  6. Exit");
            System.out.println("==========================");
            int choice;
            try { choice = Integer.parseInt(ask("Enter choice: ")); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }
            switch (choice) {
                case 1: addContact(); break;
                case 2: updateContact(); break;
                case 3:
                    int v;
                    try { v = Integer.parseInt(ask("1. View All  2. View Specific — Enter choice: ")); }
                    catch (NumberFormatException e) { System.out.println("Invalid input."); break; }
                    if (v == 1) viewAll();
                    else if (v == 2) { Contact c = find(ask("Enter name: ")); System.out.println(c != null ? c : "Contact not found."); }
                    else System.out.println("Invalid choice.");
                    break;
                case 4: searchContact(); break;
                case 5: deleteContact(); break;
                case 6: System.out.println("Exiting program..."); scanner.close(); System.exit(0);
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
