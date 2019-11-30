
public class WhoWon {

	public static void main(String[] args) {
		int[] demVotes = {23464, 78987, 90987, 32434, 87678};
		int[] repVotes = {32342, 454353, 23232,233323, 234242};
		int demVotesC = 0;
		int repVotesC = 0;
		for(int i=0;i<demVotes.length;i++)
		{
			demVotesC += demVotes[i];
			repVotesC += repVotes[i];
		}
		System.out.println("Democrats Total Votes : "+demVotesC);
		System.out.println("Republican Total Votes : "+repVotesC);
		System.out.println(demVotesC>repVotesC?"Democrats Won the Election":"Republicans won the Election");
		
		int a[] = new int[10];
		// new is a keyword / an operator which creates Array Dynamically i.e. in the Heap at runtime.
	}

}
