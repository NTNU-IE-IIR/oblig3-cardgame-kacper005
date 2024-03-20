package no.ntnu.idatx2003.oblig3.cardgame;

import no.ntnu.idatx2003.oblig3.cardgame.UI.CardGameApp;

/**
 * The main class of the application
 */
 public class Main{
    public static void main(String[] args) {
      try {
        CardGameApp.appMain(args);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }

    }
  }