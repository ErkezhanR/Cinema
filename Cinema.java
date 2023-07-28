import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Cinema {

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int twoDm[][] = new int[5][7];
        int i, j, k = 1, m = 2;
        int ab = 0;
        int firstticket;
        int secondticket;
        boolean firstTicketFlag = false;
        boolean secondTicketFlag = false;

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 7; j++) {
                twoDm[i][j] = k;
                k++;
            }
        }

        for (int[] row : twoDm) {
            printRow(row);
        }

        // this loop repeats the reserving process (and printing seats) 5 times
        for (int l = 0; l < 5; l++) {

            System.out.print("Enter the Seats number to reserve: ");
            firstticket = Integer.parseInt(br.readLine());
            secondticket = Integer.parseInt(br.readLine());

            firstTicketFlag = containsCheck(twoDm, firstticket);
            secondTicketFlag = containsCheck(twoDm, firstticket);

            if (firstTicketFlag && secondTicketFlag) {

                if (firstticket == (secondticket - 1)) {

                    k = 1;
                    m = 2;
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j < 7; j++) {

                            if (k == firstticket && m == secondticket) {
                                // here we check if the seat has already been
                                // reserved
                                ab = m - 1;
                                if (twoDm[i][j] == 0 && twoDm[i][j+1] == 0) {
                                    throw new Exception("That seat has already been reserved");
                                }
                                // if its not reserved then reserve it
                                else {
                                    //ab = m - 1;
                                    twoDm[i][j] = 0;
                                    twoDm[i][j+1] = 0;
                                }
                            }
                            k++;
                            m++;
                        }
                    }
                    // print updated array of seats
                    for (int[] row : twoDm) {
                        printRow(row);
                    }

                } else {
                    throw new Exception(" select two seats in the same row");
                }

            } else {
                System.out.println("Please enter the available seat numbers");
            }
        }
    }

    private static boolean containsCheck(int[][] twoDm, int ticket) {
        // TODO Auto-generated method stub
        boolean flag = false;
        for (int[] a : twoDm) {
            if (a.equals(ticket)) {
                flag = true;
            }
        }
        return flag;
    }
}
