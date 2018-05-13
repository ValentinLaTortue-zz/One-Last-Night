import static java.lang.Math.*;

public class Perso //Ouvre le fichier perso
{
  
  String name;

  byte hp; //Byte pour optimiser la RAM. Variable associer au perso
  byte hunger;
  byte thirst;
  byte mentalHealth;
  byte bodyTemp;
  
  byte wood;
  byte water;
  byte food;
  byte entertainment;
  byte traps;
  
  public Perso(){
    System.out.println("Creation du perso !");
    
    name = "Michel";
    
    hp =  100;
    hunger = 0;
    thirst = 0;
    mentalHealth = 100;
    bodyTemp = 37;
    
    wood = 50;
    water = 100;
    food = 100;
    traps = 0;
    entertainment = 40;
  }
  
  public void printInfos(){ // Premiere fonction, qui affiche les infos dans la console
    System.out.println("\n========== " + name + " ==========" + "\nHP: " + hp + "    Faim:" + hunger);
    System.out.println("Soif: " + thirst + "    Sante Mentale:" + mentalHealth + "\nTemperature corporelle: " + bodyTemp + "    Piege: " + traps);
    System.out.println("\nBois: " + wood + "    Eau:" + water + "\nNourriture: " + food + "    Divertissement:" + entertainment);
  }
  
  public void cutWood(){
    wood += 10;
  }
  
  public void hunt(){
    food += 10;
  }
  
  public void getWater(){
    water += 10;
  }
  
  public void nothing(){
    mentalHealth += 10;
  }
  
//   public void artisanat(){
//     //Objet aleatoire
//   }
  
  public void night(int nbDays, int usedWood, int usedFood, int usedWater){
    System.out.println("Passage au jour " + (nbDays+1));
    hunger +=  10 - usedFood;
    hunger = checkOOB(hunger);
    thirst += 10 - usedWater;
    thirst =  checkOOB(thirst);
    
    food -= usedFood;
    food = checkOOB(food);
    water -= usedWater;
    water = checkOOB(water);
    
    bodyTemp += (byte)(usedWood/5)  - 2;
    
    wood -= usedWood;
    wood = checkOOB(wood);
    
    hp -= (byte)(pow(hunger/15,2));
    hp -= (byte)(pow(thirst/15,2));  
    hp -= (byte)(pow((100 - mentalHealth)/40,2));//pow=power=exposant/abs=valeur absolue
    
    if (bodyTemp <= 28){
      hp  -= 10;
    }else {
        if (bodyTemp <= 32){
          hp  -= 3;
      }
    }
    hp = checkOOB(hp);

    mentalHealth -= (byte)(pow(hunger/20,2) + pow(thirst/20,2)) - 2;
    mentalHealth = checkOOB(mentalHealth);
  }
  
  private byte checkOOB(byte toCheck){//pour verifier si aucune des valeurs ne depasse 100 ou 0. OOB --> out of bound --> en dehors des valeurs possibles
    if(toCheck > 100) toCheck = 100;
    if(toCheck < 0) toCheck = 0;
    return toCheck;
  }
}