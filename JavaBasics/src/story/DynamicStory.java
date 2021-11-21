package story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ledger.LoggedTest;

/**
 * @author Michael Placzek
 */
public class DynamicStory extends LoggedTest
{
	private static final String CODE_FILE= "src/story/DynamicStory";

	public static void main(String[] args) throws IOException
	{
		LoggedTest.grabCode(CODE_FILE); // This logs your code in the ledger.  If you take this out the ledger will not fill!

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Once upon a time you participated in a story by telling me your name:");
		//String input = in.readLine();
		//System.out.println("Hi " + input);

		System.out.println("Hello friend! I'm going to tell you a little story...");
		System.out.println("First, what's your name?");
		System.out.print("> ");

		String name = in.readLine();
		System.out.println("So, " + name + ", your adventure awaits...");
		System.out.println("You are in a very old mansion! What part of the house would you like to go in?");
		System.out.print("> ");
		String settingName1 = in.readLine();

		System.out.println("You are in the " + settingName1 +". There is a small child in the corner.");
		System.out.println("You accidentally trip over a bottle left on the floor.");
		System.out.println("The little girl heard the bottle and turned around to notice you, what do you do? (run or say hello)");
		System.out.print("> ");

		String action = in.readLine();
		if (action.equals("run")) {
			System.out.println("You're running and the little girl starts chasing you!");
			System.out.println("She screams, 'Stop running or you're going to die!'");
			System.out.println("You don't listen and you realize that there is a man with a mask in front of you.");
		}

		if (action.equals("say hello")) {
			System.out.println("You say hello and the little girl doesn't answer you back");
			System.out.println("She screams, 'If you run you will die' ");
			System.out.println("You look confused and you realize that there is  a man with a mask in front of you");
		}
		System.out.println("What do you say?");
		System.out.println("> ");

		String message = in.readLine();
		System.out.println("You say '" + message  + "' while trembling nervously");

		System.out.println("The man with the mask slowly walks towards you, he starts to take his mask off and said, 'look into my eyes'.");
		System.out.println("Do you look? (yes or no)");
		System.out.print("> ");

		String charChoice = in.readLine();
		if(charChoice.equals("yes")) {
			System.out.println("You look into his eyes! He looks into yours and everything fades away.");
			System.out.println("Should've looked away...the end");
			System.out.println("Bad Ending | 1/3");
			System.exit(1);
		}

		if(charChoice.equals("no")) {
			System.out.println("You don't look into his eyes.");
			System.out.println("Instead, you look to your left and see that there a sword or a gun.");
		}

		System.out.println("What do you pick? (sword or gun)");
		System.out.print("> ");
		String weapon = in.readLine();
		if (weapon.equals("sword")) {
			System.out.println("You start battling the guy with the mask with the sword and you kill him!");
			System.out.println("After you have defeated the man with the mask you take his mask off...");
			System.out.println("You found out it was your dad! He was trying to prank you and you killed him!");
			System.out.println("Thank you for participating! The end.");
			System.out.println("Bad Ending | 2/3");
			System.exit(1);
		}
		System.out.println("> ");
		if (weapon.equals("gun")) {
			System.out.println("You pick up the gun and told the man with the mask...");
			System.out.println("> ");
			String message2 = in.readLine();
			System.out.println("You say:  " + message2 + " while pointing the gun at the little girl and the guy with the mask.");
			System.out.println("He ends up saying, 'Please don't hurt her that's my daughter'.");
			System.out.println("You recognize the voice then say 'Take off the mask'.");
			System.out.println("It ends up being your 8th grade teacher!");
			System.out.println("He starts explaining that he was just trying to play a prank on you.");
			System.out.println("You put the gun down and looked shocked.");
			System.out.println("Many hours pass, and he drives you home and says, 'I can't believe you were going to shoot me'");
			System.out.println("You both laugh then you leave his car.");
			System.out.println("Good Ending | 3/3");
		}
	}
}
