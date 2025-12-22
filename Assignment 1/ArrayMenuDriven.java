import java.util.Scanner;

public class ArrayMenuDriven {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = new int[100]; // maximum size
        int size = 0;
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                // 1. INSERT
                case 1:
                    System.out.print("Enter element to insert: ");
                    arr[size] = input.nextInt();
                    size++;
                    System.out.println("Element inserted successfully.");
                    break;

                // 2. DELETE
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
                        System.out.println("Element deleted.");
                    else
                        System.out.println("Element not found.");
                    break;

                // 3. LINEAR SEARCH
                case 3:
                    System.out.print("Enter element to search: ");
                    int key = input.nextInt();
                    found = false;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] == key) {
                            System.out.println("Element found at position: " + (i + 1));
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Element not found.");
                    break;

                // 4. BINARY SEARCH
                case 4:
                    System.out.print("Enter element to search: ");
                    key = input.nextInt();
                    int low = 0, high = size - 1;
                    found = false;

                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (arr[mid] == key) {
                            System.out.println("Element found at position: " + (mid + 1));
                            found = true;
                            break;
                        } else if (arr[mid] < key) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }

                    if (!found)
                        System.out.println("Element not found.");
                    break;

                // 5. MAXIMUM VALUE
                case 5:
                    int max = arr[0];
                    for (int i = 1; i < size; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                    }
                    System.out.println("Maximum value: " + max);
                    break;

                // 6. COUNT EVEN & ODD
                case 6:
                    int even = 0, odd = 0;
                    for (int i = 0; i < size; i++) {
                        if (arr[i] % 2 == 0)
                            even++;
                        else
                            odd++;
                    }
                    System.out.println("Even numbers: " + even);
                    System.out.println("Odd numbers: " + odd);
                    break;

                // 7. INSERTION SORT
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
                    System.out.println("Array sorted using Insertion Sort.");
                    break;

                // 8. DISPLAY ARRAY
                case 8:
                    System.out.print("Array elements: ");
                    for (int i = 0; i < size; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 9:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        input.close();
    }
}
