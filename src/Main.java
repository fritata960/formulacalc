import java.util.Scanner;
public class Main {
    public static void main(String args[]){//this is all in main for some reason dont @ me
        Scanner reader = new Scanner(System.in);
        int inN = 0;
        float finalW = 0;
        System.out.println("Enter a comma separated list of weights. The FIRST weight will be the base from which edits are drawn.");
        String cSL = reader.nextLine();

        /*System.out.println("Enter final weight in g");//get final weight to create % values for
        finalW = reader.nextFloat();
        System.out.println("Enter number of ingredients (first ingredient is BASE ingredient; all edited weight values will be pulled from this one: ");//enter number of ingredients to be stored
        inN = reader.nextInt();*/
        int useSel = 3;
        float[] weightArr = uInParse(cSL);
        float[] percArr = new float[weightArr.length];
        finalW = Sum(weightArr);
        /*for(int i=0; i<inN ;i++){ //this takes user input for each individual weight value for the ordered ingredients (currently by number)
            System.out.println("Enter weight value " + (i+1) + "");
            float n = reader.nextFloat();
            weightArr[i] = n;
        }*/
        for(int i=0; i<weightArr.length;i++){ //prints each individual weight value in order
            System.out.print(weightArr[i] + " ");
        }
        System.out.println();
        float percT = 0;
        for(int i = 0; i<weightArr.length; i++){ //generates corresponding percentage array
            percT = (weightArr[i]/finalW)*100;
            percArr[i] = percT;
        }

        for(int i=0; i<percArr.length;i++){ //prints each individual percentage value in order
            System.out.print(percArr[i] + "%, ");
        }

        while (useSel != 0){
            System.out.println("next selection: 1(editPercent) 2(editWeight) 0(exit)");
            useSel = reader.nextInt();
            System.out.println("selected: " + useSel);
            if(useSel == 1){
                System.out.println("ingredient percent index to edit:");
                int epI = reader.nextInt();
                System.out.println("enter replacement value (as decimal):");
                percArr[epI-1] = reader.nextFloat();
                percArr[0] = 100 - nonBaseSum(percArr);
                weightArr[epI-1] = (percArr[epI-1]/100)*finalW;
                weightArr[0] = (percArr[0]/100)*finalW;
                for(int i=0; i<percArr.length;i++){ //prints each individual percentage value in order
                    System.out.print(percArr[i] + "%, ");
                }
                System.out.println();
                for(int i=0; i<weightArr.length;i++){ //prints each individual weight value in order
                    System.out.print(weightArr[i] + ", ");
                }
                System.out.println();
            }
            if(useSel == 2){
                System.out.println("ingredient weight index to edit:");
                int ewI = reader.nextInt();
                System.out.println("enter replacement value (as decimal):");
                weightArr[ewI-1] = reader.nextFloat();
                weightArr[0] = finalW-nonBaseSum(weightArr);
                for(int i = 0; i<percArr.length; i++){ //overwrite percentage array w/ new values
                    percT = (weightArr[i]/finalW)*100;
                    percArr[i] = percT;
                }
                for(int i=0; i<percArr.length;i++){ //prints each individual percentage value in order
                    System.out.print(percArr[i] + "%, ");
                }
                System.out.println();
                for(int i=0; i<weightArr.length;i++){ //prints each individual weight value in order
                    System.out.print(weightArr[i] + " ");
                }
                System.out.println();
            }


        }


        }
    public static float nonBaseSum(float[] a){//returns sum of every element but 0
        float s = 0;
        for(int i = 1; i< a.length; i++){
            s = s+a[i];
        }
        System.out.println("sumdebug" + s);
        return s;
    }
    public static float Sum(float[] a){//returns sum of every element
        float s = 0;
        for(int i = 0; i< a.length; i++){
            s = s+a[i];
        }
        return s;
    }
    public static float[] baseValEdit(float nV, float fW, float[] perc, float[] weight){
        float[] r = new float[weight.length];
        float nBP = (nV/fW)*100;//declare inscope values and set equal to edited values, % and W
        float nBW = nBP * fW;
        float nDif = nBP/perc.length;
        for(int i = 1; i< perc.length; i++){
            perc[i] += nDif;
        }
        


        return r;
    }
    public static float[] uInParse(String a){//parses input from comma separated string to float array
        int inc = 0;
        String[] preConVal = a.split(",");
        float[] r = new float[preConVal.length];
        for(int i = 0; i<preConVal.length;i++){
            r[i] = Float.parseFloat(preConVal[i]);
        }
        return r;
    }
}