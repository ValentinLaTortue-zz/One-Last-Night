public class main
{
	public static void main(String[] args) {
		int day = 0; //Temps qui passe, ici 0
		
		System.out.println("Bienvenue dans La Derniere Nuit!\n");
		
		Perso main = new Perso(); //Creation d'un objet
		
		String input;//String=chaine de caratere
		int usedWood, usedFood, usedWater; 
		boolean whileEnder = false;
		
		while(main != null){ // Boucle principale, actif quand main diff de null
			main.printInfos();
			System.out.println("Vous etes a l'aube du jour " + day + ". Que souhaitez vous faire?"); //Texte indiquant le numero du jour
			System.out.println("1 - Couper du bois\n2 - Chasser\n3 - Chercher de l'eau\n4 - Se reposer");
			while(!whileEnder){
				input = System.console().readLine();
				switch(input){
					case "1": main.cutWood();
						whileEnder = true;
						break;
					case "2": main.hunt();
						whileEnder = true;
						break;
					case "3": main.getWater();
						whileEnder = true;
						break;
					case "4": main.nothing();
						whileEnder = true;
						break;
				}
			}
			whileEnder = false;
			
			while(!whileEnder){
			input = System.console().readLine();//Demande ce que le joueur veut faire a ecrire
				switch(input){ //verifie ce que le joueur fait et actionne les actions en consequence
					case "q": case "quit": main = null; //Ferme le jeu...
						System.out.println("Fermez le jeu");
						break;
					case "nextDay": case "nd": 
						usedWood = Integer.parseInt(System.console().readLine());//System.console().readLine=> demande a l'utilisateur/Integer.parseInt=>change en nmbre entier
						usedFood = Integer.parseInt(System.console().readLine());
						usedWater = Integer.parseInt(System.console().readLine());
						main.night(day, usedWood, usedFood, usedWater);//Va au jour suivant
						if(main.hp == 0){
							main = null;
							System.out.println("Vous etes mort");
						}
						day++;
						whileEnder = true;
						break;
				}
			}
			whileEnder = false;
		}
	}
}