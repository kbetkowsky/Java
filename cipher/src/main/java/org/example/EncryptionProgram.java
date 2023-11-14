package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EncryptionProgram {

    private Scanner scanner;
    private List<Character> originalKey;
    private List<Character> shuffledKey;

    public EncryptionProgram() {
        scanner = new Scanner(System.in);
        originalKey = new ArrayList<>();
        shuffledKey = new ArrayList<>();

        generateNewKey();
        askQuestion();
    }

    private void askQuestion() {
        while (true) {
            System.out.println("********************************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ew Key, (G)et Key, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'N':
                    generateNewKey();
                    break;
                case 'G':
                    displayKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid answer");
            }
        }
    }

    private void generateNewKey() {
        originalKey.clear();
        shuffledKey.clear();

        for (char ch = ' '; ch <= '~'; ch++) {
            originalKey.add(ch);
        }

        shuffledKey = new ArrayList<>(originalKey);
        Collections.shuffle(shuffledKey);

        System.out.println("*A new key has been generated*");
    }

    private void displayKey() {
        System.out.println("Original Key: ");
        displayCharacters(originalKey);

        System.out.println("Shuffled Key: ");
        displayCharacters(shuffledKey);
    }

    private void displayCharacters(List<Character> characters) {
        for (Character ch : characters) {
            System.out.print(ch);
        }
        System.out.println();
    }

    private void encrypt() {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();
        char[] messageArray = message.toCharArray();

        for (int i = 0; i < messageArray.length; i++) {
            for (int j = 0; j < originalKey.size(); j++) {
                if (messageArray[i] == originalKey.get(j)) {
                    messageArray[i] = shuffledKey.get(j);
                    break;
                }
            }
        }

        System.out.println("Encrypted Message: ");
        System.out.println(messageArray);
    }

    private void decrypt() {
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();
        char[] messageArray = message.toCharArray();

        for (int i = 0; i < messageArray.length; i++) {
            for (int j = 0; j < shuffledKey.size(); j++) {
                if (messageArray[i] == shuffledKey.get(j)) {
                    messageArray[i] = originalKey.get(j);
                    break;
                }
            }
        }

        System.out.println("Decrypted Message: ");
        System.out.println(messageArray);
    }

    private void quit() {
        System.out.println("Terminated");
        System.exit(0);
    }
}
