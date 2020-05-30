/*******************************************************************************
 * Copyright (c) 2020 KC Igwe
 ******************************************************************************
 */
package VAIPPLsequence;
import java.util.*;
import java.io.File;

public class vHMM {

    public static String[] multiObservationGenerator(int a, int b, int c){
        String[] obs = new String[a*b*c];
        int ind = 0;
        for(int i = 0; i < a;i++){
            for (int j = 0; j < b; j++){
                for(int k = 0; k < c; k++){
                    obs[ind] = Integer.toString(i) + j + k;
                    ind++;
                }

            }
        }
        return obs;
    }

    private static void shuffleData(String[][] o, int[][] s){
        if(o.length != s.length){
            System.out.println("Not sorted: both arrays supplied must be equal in length");
        }else {
            Integer[] arr = new Integer[o.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            List<Integer> intList = Arrays.asList(arr);
            Collections.shuffle(intList);
            intList.toArray(arr);
            for(int i = 0; i < arr.length;i++){
                int index = arr[i];
                String[] temp1 = Arrays.copyOf(o[index],o[index].length);
                int[] temp2 = Arrays.copyOf(s[index],s[index].length);

                o[index] = Arrays.copyOf(o[i],o[i].length);
                s[index]= Arrays.copyOf(s[i],s[i].length);

                o[i] = Arrays.copyOf(temp1,temp1.length);
                s[i]= Arrays.copyOf(temp2,temp2.length);

            }
        }

    }

    public static void main(String[] args) {
        final int OL = 40;// observation length
        final int NUM_PARTICIPANTS = 14;// number of participants
        final int NUM_GAMES = 4;
        String[][] o = new String[NUM_PARTICIPANTS*NUM_GAMES][OL];
        int[][] st = new int[NUM_PARTICIPANTS*NUM_GAMES][OL];
        try {
            ArrayList<String> arr = new ArrayList<>();
            File file = new File("statesObs.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();// ignore the header
            int c = 1;
            int count = 0;
            while(sc.hasNextLine()){
                arr.add(sc.nextLine());
                if(c%40 == 0){
                    count++;
                }
                c++;
            }
            c = 1;
            int row = 0;
            int col = 0;
             o = new String[NUM_PARTICIPANTS*NUM_GAMES][OL];
             st = new int[NUM_PARTICIPANTS*NUM_GAMES][OL];
            for (int i = 0; i < arr.size(); i++){
                String[] stob = arr.get(i).split("[,\"]+");
                st[row][col] = Integer.parseInt(stob[2]);
                o[row][col] = stob[3];
                //System.out.print(st[row][col] +" : "+ o[row][col]+" " );
                if(c%40 == 0){
                    c = 1;
                    col = 0;
                    row++;
                  //  System.out.println();
                }else{
                    col++;
                    c++;
                }
            }
           // sortData(o,st);
        }catch(Exception e){
            System.out.println("Unable to create states and observations:\n "+e);
        }

       for(int y = 10; y <= 50;y+=5 ) {
           int te_size = (int) (((double) y / 100.0) * st.length);
           int tr_size = st.length - te_size;
           int[][] s_tr = new int[tr_size][OL];
           int[][] s_te = new int[te_size][OL];
           String[][] o_tr = new String[tr_size][OL];
           String[][] o_te = new String[te_size][OL];
           int t_ind = 0;
           for (int i = 0; i < st.length; i++) {
               for (int j = 0; j < st[0].length; j++) {
                   if (i < tr_size) {
                       s_tr[i][j] = st[i][j];
                       o_tr[i][j] = o[i][j];
                   } else  {
                       s_te[t_ind][j] = st[i][j];
                       o_te[t_ind][j] = o[i][j];
                   }
               }
               if (i >= tr_size) {
                   t_ind++;
               }
           }
           int yes = 0, yes2 = 0;
           int all = 0, all2 = 0;
           int spe = 0 , spe2= 0;
           int allSpe = 0, allSpe2 = 0;
           HMM model = new HMM(o_tr, s_tr, multiObservationGenerator(4, 4, 3));
           model = model.learn(o_tr,100);
           //System.out.print(model.toString() + "\n\n");

           for (int k = 0; k < o_tr.length; k++) {
               for (int i = 1; i < o_tr[k].length; i++) {

                   int ans = model.predict(Arrays.copyOfRange(o_tr[k],0,i), Arrays.copyOfRange(s_tr[k],0,i));
                   // System.out.print("Predicted "+ans[i]+" : Actual"+ s_te[k][i]+ " ");
                   if (ans == s_tr[k][i]) {
                       yes++;
                       if(ans != 0){
                           spe++;
                       }
                   }
                   if(s_tr[k][i] != 0){
                       allSpe++;
                   }
                   all++;

               }
              // System.out.println();
           }
           for (int k = 0; k < o_te.length; k++) {
               for (int i = 1; i < o_te[k].length; i++) {

                   int ans = model.predict(Arrays.copyOfRange(o_te[k],0,i), Arrays.copyOfRange(s_te[k],0,i));
                   // System.out.print("Predicted "+ans[i]+" : Actual"+ s_te[k][i]+ " ");
                   if (ans == s_te[k][i]) {
                       yes2++;
                       if(ans != 0){
                           spe2++;
                       }
                   }
                   if(s_te[k][i] != 0){
                       allSpe2++;
                   }
                   all2++;

               }
               // System.out.println();
           }
  /*         for (int k = 0; k < o_te.length; k++) {
               int[] ans = model.predict(o_te[k]);
               for (int i = 0; i < ans.length; i++) {
                   // System.out.print("Predicted "+ans[i]+" : Actual"+ s_te[k][i]+ " ");
                   if (ans[i] == s_te[k][i]) {
                       yes++;
                       if(ans[i] != 0){
                           spe++;
                       }
                   }
                   if(s_te[k][i] != 0){
                       allSpe++;
                   }
                   all++;
               }
               // System.out.println();
           }
*/
           System.out.println("Using " + (100 - y) + "% for training, and " + y + "% for testing:  Percentage accuracy (Te) = " +
                   ((double) (yes) / (double) all) * 100 + " Percentage accuracy (Va) = "+ ((double) (yes2) / (double) all2) * 100);// + "%: \n% Special in Accurate Pred = "+ ((double) (spe) / (double) yes) * 100 + "%: Per Special in All Pre = "+ ((double) (spe) / (double) allSpe) * 100+"\n");
           //*****
       }
    }
}
