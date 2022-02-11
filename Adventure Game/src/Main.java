/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author lunax
 */
public class Main {
    public static void main(String[] args){
        // creating scanner and random type system objects
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        
        // game variables
        String[] enemies = {"Witch", "Necromancer", "Goblin", "Vampire"};
        int maxEnemyHp = 85;
        int enemyAttackDmg = 35;
        
        // player variables
        int hp = 120; // hp stands for health points
        int attackDmg = 70; // dmg stands for damage
        int numHealthPotions = 3;
        int healthPotionHealAmt = 35;
        int healthPotionDropChance = 50; // percentage chance
        
        boolean running = true;
        
        System.out.println("Welcome to the Dungeon!");
        
        //entering the game
        GAME:
        while (running) {
            // separator
            System.out.println("--------------------------------------------------");
            
            // setting the enemy hp to a random amount
            int enemyHp = rand.nextInt(maxEnemyHp);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");
            
            // entering battle with enemy
            while(enemyHp > 0) {
                System.out.println("\t Your HP: " + hp);
                System.out.println("\t# " + enemy + "'s HP: " + enemyHp);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run");
                
                // taking user input to proceed in game through options
                String input = scnr.nextLine();
                // if you attack
                if (input.equals("1")) {
                    int dmgDealt = rand.nextInt(attackDmg);
                    int dmgTaken = rand.nextInt(enemyAttackDmg);
                    
                    enemyHp -= dmgDealt;
                    hp -= dmgTaken;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + dmgDealt + " damage.");
                    System.out.println("\t> You recieve " + dmgTaken + " in retaliation!");
                    
                    if (hp < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to keep fighting!");
                        break;
                    }
                // if you take a health potion
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        hp += healthPotionHealAmt;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion for " + healthPotionHealAmt +
                                "\n\t> You now have " + hp + " HP." +
                                "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to proceed.");
                    }
                // if you run away
                } else if (input.equals("3")) {
                    System.out.println("\t> You ran away from the " + enemy + "!");
                    continue GAME;
                // if you type anything other than 1, 2, or 3
                } else {
                    System.out.println("\tInvalid Command.");
                }
            }
            
            // breaks if your hp is low
            if (hp < 1) {
                System.out.println("You leave the dungeon injured, you are weak from battle.");
                break;
            }
            
            System.out.println("--------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + hp + " HP left. #");
            // dropping health potion from enemy based on health potion drop chance
            if (rand.nextInt(100) < healthPotionDropChance) {
                // if true, health potion drops and increments by 1
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion. #");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s)! #");
            }
            System.out.println("--------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");
            
            // taking user input to proceed in game through options
            String input = scnr.nextLine();
            
            // if the user enters a number not 1 or 2
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command.");
                input = scnr.nextLine();
            }
            
            // if the user wants to continue in the dungeon
            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            // if the user wants to exit the dungeon
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventures!");
            }
            
            System.out.println("/*********************/");
            System.out.println("# THANKS FOR PLAYING! #");
            System.out.println("/*********************/");
        }
    }
}
