import java.io.*;


class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		StringBuilder kingPos = new StringBuilder(temp[0]);
		StringBuilder stonePos = new StringBuilder(temp[1]);
		int commandNum = Integer.parseInt(temp[2]);

		for (int i = 0; i < commandNum; i++) {
			String command = br.readLine();
			StringBuilder newKingPos = move(new StringBuilder(kingPos.toString()), command);

			if (newKingPos.compareTo(stonePos) == 0) {
				StringBuilder newStonePos = move(new StringBuilder(stonePos.toString()), command);
				if (newStonePos.compareTo(stonePos) != 0) {
					kingPos = newKingPos;
					stonePos = newStonePos;
				}
			} else {
				kingPos = newKingPos;
			}
		}
		System.out.println(kingPos);
		System.out.println(stonePos);
	}

	public static StringBuilder move (StringBuilder pos, String command) {
		switch (command) {
			case "R": {
				if (pos.charAt(0) == 'H') return pos;
				pos.setCharAt(0, (char) (pos.charAt(0) + 1));
				break;
			}
			case "L": {
				if (pos.charAt(0) == 'A') return pos;
				pos.setCharAt(0, (char) (pos.charAt(0) - 1));
				break;
			}
			case "B": {
				if (pos.charAt(1) == '1') return pos;
				pos.setCharAt(1, (char) (pos.charAt(1) - 1));
				break;
			}
			case "T": {
				if (pos.charAt(1) == '8') return pos;
				pos.setCharAt(1, (char) (pos.charAt(1) + 1));
				break;
			}
			case "RT": {
				if (pos.charAt(0) == 'H' || pos.charAt(1) == '8') return pos;
				pos.setCharAt(0, (char) (pos.charAt(0) + 1));
				pos.setCharAt(1, (char) (pos.charAt(1) + 1));
				break;
			}
			case "LT": {
				if (pos.charAt(0) == 'A' || pos.charAt(1) == '8') return pos;
				pos.setCharAt(0, (char) (pos.charAt(0) - 1));
				pos.setCharAt(1, (char) (pos.charAt(1) + 1));
				break;
			}

			case "RB": {
				if (pos.charAt(0) == 'H' || pos.charAt(1) == '1') return pos;
				pos.setCharAt(0, (char) (pos.charAt(0) + 1));
				pos.setCharAt(1, (char) (pos.charAt(1) - 1));
				break;
			}

			case "LB": {
				if (pos.charAt(0) == 'A' || pos.charAt(1) == '1') return pos;
				pos.setCharAt(0, (char) (pos.charAt(0) - 1));
				pos.setCharAt(1, (char) (pos.charAt(1) - 1));
				break;
			}
		}
		return pos;
	}
}