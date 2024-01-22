import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
    public static class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
        }
    }

    private ArrayList<Contact> contacts;

    public AddressBookSystem() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void removeContact(String contactName) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                contacts.remove(contact);
                System.out.println(contactName + " removed from the address book.");
                return;
            }
        }
        System.out.println("No contact found with the name " + contactName + ".");
    }

    public ArrayList<Contact> searchContact(String query) {
        ArrayList<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("-".repeat(30));
        }
    }

    public static void main(String[] args) {
        AddressBookSystem addressBook = new AddressBookSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book System Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    String name = scanner.next();
                    System.out.println("Enter the phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.println("Enter the email address: ");
                    String email = scanner.next();

                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to remove: ");
                    String contactToRemove = scanner.next();
                    addressBook.removeContact(contactToRemove);
                    break;
                case 3:
                    System.out.print("Enter the name or part of the name to search for: ");
                    String searchQuery = scanner.next();
                    ArrayList<Contact> searchResults = addressBook.searchContact(searchQuery);
                    if (searchResults.isEmpty()) {
                        System.out.println("No contacts found matching '" + searchQuery + "'.");
                    } else {
                        System.out.println("\nSearch Results:");
                        for (Contact result : searchResults) {
                            System.out.println(result);
                        }
                    }
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting Address Book System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}


