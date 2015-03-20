/*
 * NumberGuessGame.java 1 03/12/2015
 */
import java.util.Scanner;

/**
 * This class guesses the number whatever you think in our mind minimum 10
 * attempts
 * 
 * @author Suribabu Jatla
 * 
 */
public class NumberGuessGame {
	/**
	 * Lower bound value
	 */
	private static final int MIN = 0;
	/**
	 * Upper bound value
	 */
	private static final int MAX = 1000;

	/* Enum for user inputs */
	private static enum UserResp {
		higher, lower, yes, end
	};

	/* This is used to take user inputs from console */
	private static Scanner scanner = new Scanner(System.in);

	/* This gives value to find guess in no of attemts */
	private int attemptCount = 0;

	/**
	 * Using the logic of binary search so we can find the guess maximum in logn
	 * base 2 attempts . For thiscode we can find the guess in maximum 10
	 * attempts(1000 <2 pow 10).
	 * 
	 * @param lower
	 * @param higher
	 */
	public void play(int lower, int higher) {
		
		/* calculating the mid value */
		int guess = (lower + higher) / 2;
		attemptCount++;
		System.out.print("Is the number " + guess
				+ "?\n(Valid options :higher,lower,yes or end):");
		try{
		String userRsp = scanner.nextLine();
		userRsp = userRsp.toLowerCase();
		UserResp userResp = UserResp.valueOf(userRsp);
		switch (userResp) {
		case higher:
			play(guess + 1, higher);
			break;
		case lower:
			play(lower, guess - 1);
			break;
		case yes:
			System.out.println("Thanks! I could guess it in " + attemptCount
					+ " attempts!");
			break;
		case end:
			System.out.println("The program has been ended");
			break;
		}
		}
		catch(Exception e){
			System.out
			.print("Invalid response... Respond with higher, lower, yes or end: ");
		}
	}

	public static void main(String[] args) throws Exception {
		NumberGuessGame game = new NumberGuessGame();
		System.out.println("Choose number in your mind between " + MIN
				+ " and " + MAX);
		System.out.print("Enter READY to start the game: ");
		String userInput = scanner.nextLine();
		if ("READY".equalsIgnoreCase(userInput.trim())) {
			game.play(MIN, MAX);
		} else {
			System.out.print("Invalid input!");
		}
		}

}
