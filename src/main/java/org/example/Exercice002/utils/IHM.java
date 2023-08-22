package org.example.Exercice002.utils;



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
                    +"4. Quitter");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1 :
                    System.out.println("Entrer un titre pour la tâche à effectuer");
                    String title  = scanner.nextLine();
                    TaskDAO.insertTask(title, false);
                    break;
                case 2 :
                    System.out.println(TaskDAO.displayAllTasks());
                    break;
                case 3 :
                    System.out.println("Sélectionnez la tâche terminée");
                    Long id = scanner.nextLong();
                    TaskDAO.alterTaskStatus(id);
                    TaskDAO.deleteTask(id);
                    break;
                default :
                    TaskDAO.endConnection();
                    System.out.println("Fin du programme.");
                    break;
            }
        } while (input != 0);

    }
}
