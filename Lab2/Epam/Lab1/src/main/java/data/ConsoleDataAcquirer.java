package data;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleDataAcquirer implements DataAcquirer {

   public double GetNumber() {
      double result = 0;
      Scanner scanner = new Scanner(System.in);
      try {
         if(scanner.hasNextDouble()) {
            result = scanner.nextDouble();
         } else {
           throw new IOException("Wrong input ");
         }
      } catch (IOException e) {
         System.out.print(e.getMessage());
      } finally {
         scanner.close();
      }
      return result;
   }

}
