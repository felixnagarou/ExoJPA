package org.example.utils;

import org.example.EntityManagement.Management;
import org.example.entity.ToDoList;

import java.util.Scanner;

public class IHM {
    private Management management;
    public  static Scanner scanner = new Scanner(System.in);
    public IHM(Management management){
        this.management = management;
    }

    public void menuStart(){
        management = new Management();
        int input = 1;
        while (input != 0){
            System.out.println("Choisir une action à effectuer");
            System.out.println("1. Ajouter une tâche \n "
                   + "2. Afficher la liste des tâches\n"
                   +" 3. Terminer une tâche\n"
                    +"4. Quitter");
            input = scanner.nextInt();
            switch (input){
                case 1 :
                    System.out.println("Entrer un titre pour la tâche à effectuer");
                    String title  = scanner.nextLine();
                    Management.insertTask(title, false);
                case 2 :
                    System.out.println(Management.displayAllTasks());
                case 3 :
                    System.out.println("Sélectionnez la tâche terminée");
                    Long id = scanner.nextLong();
                    Management.alterTaskStatus(id);
                    Management.deleteTask(id);
                default :
                    Management.endConnection();
                    System.out.println("Fin du programme.");
            }
        }

        }
    }

