package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money are you starting with?");
		double startAmount = in.nextDouble();
		System.out.println("What is the win chance?");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many days are you playing?");
		int totalSimulations = in.nextInt();
		
		double ruin = 0;
		for (int i = 1; i <= totalSimulations; i++)
		{
			double currentMoney = startAmount;
			int totalPlays = 0;
			while (currentMoney > 0 && currentMoney < winLimit)
			{
				totalPlays++;
				double chance = Math.random();
				if (chance < winChance)
				{
					currentMoney++;
				}
				else
				{
					currentMoney--;
				}
			}
			System.out.println("Day " + i);
			System.out.println("You played " + totalPlays + " times today.");
			if (currentMoney != winLimit)
			{
				ruin++;
				System.out.println("You lost today.");
			}
			else
			{
				System.out.println("You won today.");
			}
		}
		double ruinPercent = Math.round(((ruin/totalSimulations)*100.0)*100.0)/100.0;
		System.out.println("you ruined " + ruin + " times.");
		System.out.println("You ruined " + ruinPercent + "% of the time.");
		double alpha = (1 - winChance)/winChance;
		double expectedRuin = 0;
		if (winChance == 0.5)
		{
			expectedRuin = 1 - (startAmount/winLimit);
		}
		else
		{
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1 - Math.pow(alpha, winLimit));
		}
		System.out.println("Your expected ruin rate was " + expectedRuin + ".");
	}

}
