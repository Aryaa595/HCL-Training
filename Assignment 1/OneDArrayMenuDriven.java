import java.util.Scanner;

public class OneDArrayMenuDriven {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] arr = new int[50];   // one dimensional array
        int size, choice;

        // INITIAL ARRAY INPUT
        System.out.print("Enter number of elements: ");
        size = input.nextInt();

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Insert element");
            System.out.println("2. Delete element");
            System.out.println("3. Linear search");
            System.out.println("4. Binary search");
            System.out.println("5. Find maximum value");
            System.out.println("6. Count even and odd numbers");
            System.out.println("7. Insertion sort");
            System.out.println("8. Display array");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                // INSERTION
                case 1:
                    System.out.print("Enter element to insert: ");
                    arr[size] = input.nextInt();
                    size++;
                    System.out.println("Element inserted successfully");
                    break;

                // DELETION
                case 2:
                    System.out.print("Enter element to delete: ");
                    int del = input.nextInt();
                    boolean found = false;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] == del) {
                            for (int j = i; j < size - 1; j++) {
                                arr[j] = arr[j + 1];
                            }
                            size--;
                            found = true;
                            break;
                        }
                    }

                    if (found)
                        System.out.println("Element deleted");
                    else
                        System.out.println("Element not found");
                    break;

                // LINEAR SEARCH
                case 3:
                    System.out.print("Enter element to search: ");
                    int key = input.nextInt();
                    found = false;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] == key) {
                            System.out.println("Element found at position " + (i + 1));
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Element not found");
                    break;

                // BINARY SEARCH (Array must be sorted)
                case 4:
                    System.out.print("Enter element to search: ");
                    key = input.nextInt();
                    int low = 0, high = size - 1;
                    found = false;

                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (arr[mid] == key) {
                            System.out.println("Element found at position " + (mid + 1));
                            found = true;
                            break;
                        } else if (arr[mid] < key) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }

                    if (!found)
                        System.out.println("Element not found");
                    break;

                // FIND MAXIMUM
                case 5:
                    int max = arr[0];
                    for (int i = 1; i < size; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                    }
                    System.out.println("Maximum value = " + max);
                    break;

                // COUNT EVEN & ODD
                case 6:
                    int even = 0, odd = 0;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] % 2 == 0)
                            even++;
                        else
                            odd++;
                    }

                    System.out.println("Even numbers = " + even);
                    System.out.println("Odd numbers = " + odd);
                    break;

                // INSERTION SORT
                case 7:
                    for (int i = 1; i < size; i++) {
                        int temp = arr[i];
                        int j = i - 1;

                        while (j >= 0 && arr[j] > temp) {
                            arr[j + 1] = arr[j];
                            j--;
                        }
                        arr[j + 1] = temp;
                    }
                    System.out.println("Array sorted using Insertion Sort");
                    break;

                // DISPLAY ARRAY
                case 8:
                    System.out.print("Array elements: ");
                    for (int i = 0; i < size; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 9:
                    System.out.println("Program exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);

        input.close();
    }
}
