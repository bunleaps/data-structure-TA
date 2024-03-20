package Session04.ContactBook;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email;
    }
}

public class ContactBook {

    private static LinkedList<Contact> contacts = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            char choice = getCharInput();
            switch (choice) {
                case 'A':
                    addContact();
                    break;
                case 'D':
                    deleteContact();
                    break;
                case 'E':
                    searchByEmail();
                    break;
                case 'P':
                    printContacts();
                    break;
                case 'S':
                    searchByName();
                    break;
                case 'Q':
                    System.out.println("Quiting ...");
                    return;
                default:
                    System.out.println("Unknown Entry");
            }
        }
    }

    private static char getCharInput() {
        System.out.print("Please Enter a command: ");
        while (true) {
            try {
                String input = scanner.nextLine().toUpperCase();
                return input.charAt(0);
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the buffer
                System.out.print("Invalid input. Please enter a character (A-D, E, P, S, or Q): ");
            }
        }
    }

    private static void printMenu() {
        System.out.println("**********************");
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail Search");
        System.out.println("(P)rint List");
        System.out.println("(S)earch");
        System.out.println("(Q)uit");
        System.out.println("**********************");
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private static void deleteContact() {
        System.out.print("Enter name of contact to delete: ");
        String name = scanner.nextLine();
        Contact toDelete = null;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                toDelete = contact;
                break;
            }
        }

        if (toDelete != null) {
            contacts.remove(toDelete);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void searchByEmail() {
        System.out.print("Enter email address to search: ");
        String email = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                System.out.println(contact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("*** Contact List ***");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}
