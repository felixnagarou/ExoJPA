package org.example.Exercice002.utils;



import org.example.Exercice002.entity.Task;
import org.example.Exercice002.entity.TaskDAO;

import java.util.Scanner;

public class IHM {
    public static TaskDAO management;
    public  static Scanner scanner = new Scanner(System.in);
    public IHM(TaskDAO management){
        this.management = management;
    }

    public void menuStart(){
        management = new TaskDAO();
        int input = -1;
        do {
            System.out.println("Choisir une action à effectuer");
            System.out.println("1. Ajouter une tâche \n "
                    + "2. Afficher la liste des tâches\n"
                    +" 3. Terminer une tâche\n"
                    +"4. Afficher les informations respectives à la tâche\n"
                    +"5. Afficher les tâches par priorité"
                    +"6. Afficher les tâches par deadline");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1 :
                    System.out.println("Entrer un titre pour la tâche à effectuer");
                    String title  = scanner.nextLine();
                    management.insertTask(new Task());
                    break;
                case 2 :
                    System.out.println(management.displayAllTasks());
                    break;
                case 3 :
                    System.out.println("Sélectionnez la tâche terminée");
                    Long id = scanner.nextLong();
                    management.alterTaskStatus(id);
                    management.deleteTask(id);
                    break;
                default :
                    management.endConnection();
                    System.out.println("Fin du programme.");
                    break;
            }
        } while (input != 0);

    }
}
