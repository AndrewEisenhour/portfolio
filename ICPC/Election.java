package icpc2020;

import java.util.*;

public class Election {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		Candidate[] cans = new Candidate[n];
		for (int i = 0; i < n; i++) {
			cans[i] = new Candidate(scan.nextLine(), scan.nextLine(), 0);
		}
		int m = scan.nextInt();
		scan.nextLine();
		String[] vote = new String[m];
		int max = 0;
		String maxParty = "tie";
		for (int i = 0; i<m; i++) {
			vote[i] = scan.nextLine();
			for (Candidate c : cans) {
				if (c.name.equals(vote[i])) {
					c.votes = c.votes+1;
					if (c.votes==max && !c.party.equals(maxParty)) {
						maxParty = "tie";
						//System.out.println(maxParty);
					}
					else if (c.votes>max) {
						max = c.votes; 
						maxParty = c.party;
						//System.out.println(maxParty);
					}
					break;
				}
			}
		}
		System.out.println(maxParty);
		
		

	}

	static class Candidate {
		public String name;
		public String party;
		public int votes;

		public Candidate(String _name, String _party, int _votes) {
			name = _name;
			party = _party;
			votes = _votes;

		}
	}

}
