package org.example;

import org.example.EntityManagement.Management;
import org.example.utils.IHM;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IHM ihm = new IHM(new Management());
        ihm.menuStart();
        }
    }