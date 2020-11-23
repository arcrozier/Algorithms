/* 
Given a uniform distribution of slots/hashes/values for "hits", how many "hits" 
can you have before there is at less than a 50 percent probability that every hit
is on a different slot. This probability = 1- (hashes - 1)/hashes * 
(hashes -2)/hashes * ... (hashes - hits)/hashes.
Test results:
 
Half Collision
365
24

Half Collision
1000
39

Half Collision
10000
120
  
*/

public class HalfCollision implements ProblemIO {
	int numberOfHashes;

	public HalfCollision(int numberOfHashes) {
		this.numberOfHashes = numberOfHashes;
	}

	/*
	 * calculateHalfCollision() calculates the number of hits necessary so that
	 * the possibility of two hits on the same slot is at least 50% YOU MUST
	 * IMPLEMENT THIS METHOD
	 */
	public int calculateHalfCollision() {
		int hits = 1;
		double probability = (numberOfHashes - hits) / (double) numberOfHashes;
		do {
			hits++;
			probability *= (numberOfHashes - hits) / (double) numberOfHashes;
		} while (probability > .5);
		return hits + 2;
	}

	@Override
	public String problemHeader() {
		return "Half Collision";
	}

	@Override
	public String problemInput() {
		return Integer.toString(numberOfHashes);
	}

	@Override
	public String problemOutput() {
		return Integer.toString(calculateHalfCollision());
	}

}
