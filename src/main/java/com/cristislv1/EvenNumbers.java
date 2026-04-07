package com.cristislv1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EvenNumbers {
   private static final int LIM = 30;

   private static int readVector(int[] var0) throws FileNotFoundException {
      Scanner var2 = new Scanner(new File("in.txt"));

      int var1;
      try {
         var1 = var2.nextInt();

         for(int var3 = 0; var3 < var1; ++var3) {
            var0[var3] = var2.nextInt();
         }
      } catch (Throwable var6) {
         try {
            var2.close();
         } catch (Throwable var5) {
            var6.addSuppressed(var5);
         }

         throw var6;
      }

      var2.close();
      return var1;
   }

   private static void printVector(int var0, int[] var1) {
      for(int var2 = 0; var2 < var0; ++var2) {
         System.out.print(var1[var2] + " ");
      }

      System.out.println();
   }

   static int determinaNrPare(int var0, int[] var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0; ++var3) {
         if (var1[var3] % 2 == 0) {
            ++var2;
         }
      }

      return var2;
   }

   public static void main(String[] var0) throws Exception {
      int[] var1 = new int[30];
      int var2 = readVector(var1);
      printVector(var2, var1);
      int var3 = determinaNrPare(var2, var1);
      System.out.println("Number of even numbers in the vector=" + var3);
   }
}
