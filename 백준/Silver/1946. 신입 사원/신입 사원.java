import java.io.*;
import java.util.*;

class Main {
	static class Applicant {
		int documentRank;
		int interviewRank;
		public Applicant(int documentRank, int interviewRank){
			this.documentRank = documentRank;
			this.interviewRank = interviewRank;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		for(int i =0 ; i < test ; i++){
			int n = Integer.parseInt(br.readLine());
			Applicant[] applicants = new Applicant[n];

			for(int j = 0; j < n; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int resumeRank = Integer.parseInt(st.nextToken());
				int interviewRank = Integer.parseInt(st.nextToken());
				applicants[j] = new Applicant(resumeRank, interviewRank);
			}
			Arrays.sort(applicants, Comparator.comparingInt(a -> a.documentRank));
			int pass = 0;
			int bestInterviewRank = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++){
				if(applicants[j].interviewRank < bestInterviewRank) {
					pass++;
					bestInterviewRank = applicants[j].interviewRank;
				}
			}
			System.out.println(pass);
		}
	}
}
