package com.epam.task.second.data;

import com.epam.task.second.logic.DeveloperCreator;
import com.epam.task.second.logic.SoftwareDeveloper;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleDataAcquirer implements DataAcquirer{
    public SoftwareDeveloper getDeveloper(){

        int daysRequired = 0;
        DeveloperCreator developerCreator = new DeveloperCreator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Days required: ");

        try {
            if(scanner.hasNextInt()) {
                daysRequired = scanner.nextInt();
              } else {
               throw new IOException("Wrong input ");
              }
        } catch (IOException e) {
          System.out.print(e.getMessage());
        } finally {
          scanner.close();
        }

            return developerCreator.create(name, daysRequired);

    }

}

