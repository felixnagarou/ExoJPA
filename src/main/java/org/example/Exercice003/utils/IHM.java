package org.example.Exercice003.utils;

import org.example.Exercice003.DAO.*;
import org.example.Exercice003.entity.Category;
import org.example.Exercice003.entity.Person;
import org.example.Exercice003.entity.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class IHM {
    private CategoryDAO categoryDAO;
    private PersonDAO personDAO;

    private TaskDAO taskDAO;

    private TaskInfoDAO infoDAO;

    public  static Scanner scanner = new Scanner(System.in);

    public IHM(CategoryDAO categoryDAO, PersonDAO personDAO, TaskDAO taskDAO, TaskInfoDAO infoDAO){
        this.categoryDAO = categoryDAO;
        this.infoDAO = infoDAO;
        this.personDAO = personDAO;
        this.taskDAO = taskDAO;
    }

    public void menuStart(){

        int input = -1;
        do {
            System.out.println("Choisir une action à effectuer");
            System.out.println("1. Ajouter une personne \n "
                    + "2. Afficher les tâches d'une personne\n"
                    +" 3. Ajouter une tâche\n"
                    +"4. Marquer une tâche comme terminée\n"
                    +"5. Supprimer une personne et toutes ses tâches\n"
                    +"6. Supprimer une tâche\n"
                    +"7. Afficher toutes les tâches\n"
                    +"8. Ajouter une catégorie\n"
                    +"9. Supprimer une catégorie\n"
                    +"10. Afficher les tâches d'une catégorie\n"
                    +"11. Ajouter une tâche à une catégorie\n"
                    +"12. Supprimer une tâche pour une catégorie donnée");
            long id;
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1 :
                    System.out.println("Entrez personne");
                    String name  = scanner.nextLine();
                    personDAO.insert(new Person());
                    break;
                case 2 :
                    System.out.println("Entrer id personne");
                    personDAO.get(scanner.nextLong()).getTaskList();
                    scanner.nextLine();
                    System.out.println("===Tâches de la personne===");
                    break;
                case 3 :
                    System.out.println("Ajouter une tâche");
                    taskDAO.insert(new Task());
                    break;
                case 4 :
                    System.out.println("Entrer l'id de la tâche terminée");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    taskDAO.update(id);
                    break;
                case 5 :
                    System.out.println("Entrer l'id de la personne à supprimer");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    personDAO.remove(id);
                    break;
                case 6 :
                    System.out.println("Entrer l'id de la tâche à supprimer");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    taskDAO.remove(id);
                    break;
                case 7 :
                    System.out.println("===Tâches en cours===");
                    taskDAO.getAll();
                    break;
                case 8 :
                    System.out.println("Entrer une catégorie");
                    categoryDAO.insert(new Category());
                    break;
                case 9 :
                    System.out.println("Id de la catégorie à supprimer");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    categoryDAO.remove(id);
                    break;
                case 10 :
                    System.out.println("===Entrer id catégorie===");
                    //REQUETE SPECIALE
                    categoryDAO.get(scanner.nextLong());
                    System.out.println("===Tâches par catégorie===");
                    break;
                case 11 :
                    System.out.println("Entrer la tâche à ajouter pour la catégorie");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    //REQUETE SPECIALE
                    break;
                case 12 :
                    System.out.println("Supprimer une tâche pour une catégorie donnée");
                    //REQUETE SPECIALE
                    id = scanner.nextLong();
                    scanner.nextLine();
                    break;
                default :
                    System.out.println("Fin du programme.");
                    break;
            }
        } while (input != 0);

    }
}
