import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class TK4 {
    static public void main(String[] args)
    {
        String calculateAgain = "";
        Scanner scan = new Scanner(System.in);
        do
        {
            Calculate.input();
            System.out.print("\nMau simulasikan lagi? Tekan Y untuk masuk menu atau yang lain untuk Keluar: ");
            calculateAgain = scan.nextLine();
        }
        while(calculateAgain.equalsIgnoreCase("Y"));
        System.out.println("Terima Kasih :)");
    }
    private static Scanner input = new Scanner(System.in);
    public static int min, max, temp_min, temp_max, i,j,k,
            random_number []=new int [5];
    static boolean check = false;
    private String word;
    public static class Calculate
    {
        static public void input()
        {

            Scanner input = new Scanner(System.in);
            System.out.println("Selamat Datang di Program Simulasi");
            System.out.println("Menu");
            System.out.println("1. Random Data");
            System.out.println("2. Simulasi Bubble Sort - Ascending");
            System.out.println("3. Simulasi Bubble Sort - Descending");
            System.out.println("4. Simulasi Selection Sort - Ascending");
            System.out.println("5. Simulasi Selection Sort - Descending");
            System.out.println("6. Keluar ");
            System.out.print("Masukkan Pilihan Anda : ");
            int pilihan = input.nextInt();

            switch(pilihan){
                case 1: Generate();break;
                case 2: bubblesortAsc();break;
                case 3: bubblesortDesc();break;
                case 4: selectionsortAsc();break;
                case 5: selectionsortDesc();break;
                case 6: Exit();break;
                default:
                    System.out.println("Tolong pilih angka yang ada di menu !!!");
                    break;
            }
        }
        public static void Generate()
        {
            System.out.print("\nBatas Bawah : ");
            min = input.nextInt();
            System.out.print("Batas Atas : ");
            max = input.nextInt();
            while(min>max)
            {
                System.out.println("\nBatas Atas tidak boleh lebih besar dari Batas Bawah");
                System.out.println("Mohon Ulangi Input");
                System.out.print("\nBatas Bawah: "); min = input.nextInt();
                System.out.print("Batas Atas: "); max = input.nextInt();
            }

            for(int i = 0;i<=random_number.length-1;i++)
            {
                if(max-min+1<5)
                {
                    random_number[i]=(int)(min+Math.random()*(max-min+1));
                }
                else
                {
                    random_number[i]=(int)(min+Math.random()*(max-min+1));
                    j=0;
                    do
                    {
                        if(random_number[i]==random_number[j] &&
                                i!=j)
                        {
                            random_number[i]=(int)(min+Math.random()*(max-min+1));
                            j=0;
                        }
                        else
                        {
                            j=j+1;
                        }
                    }
                    while(j<i);
                }
            }
            System.out.print("Bilangan yang dihasilkan: ");
            displayNumber(random_number);
            check = true;
        }
        public static void bubblesortAsc() {
            if(!check)
            {
                System.out.println("\nBelum Masukkan Bilangan, Silahkan Pilih Menu Nomor 1");
                System.out.println(" ");
                        input();
            }

            for(int i=1; i <= random_number.length-1; i++)
            {
                System.out.println("\nPass " +i);
                displayNumber(random_number);

                for(int j=0; j <= random_number.length-1-i; j++)
                {
                    if(random_number[j]>=random_number[j+1])
                    {
                        swap(random_number,j,j+1);
                    }
                    displayNumber(random_number);
                }
                System.out.println(" ");
                System.out.println("Result of Pass " +i +": ");
                displayNumber(random_number);
            }
        }
        public static void bubblesortDesc() {
            if(!check)
            {
                System.out.println("\nBelum Masukkan Bilangan, Silahkan Pilih Menu Nomor 1");
                System.out.println(" ");
                        input();
            }

            for(int i=1; i <= random_number.length-1; i++)
            {
                System.out.println("\nPass " +i);
                displayNumber(random_number);
                for(int j=0; j<= random_number.length-1-i; j++)
                {
                    if(random_number[j]<=random_number[j+1])
                    {
                        swap(random_number,j,j+1);
                    }
                    displayNumber(random_number);
                }
                System.out.println(" ");
                System.out.println("Result of Pass " +i +": ");
                displayNumber(random_number);
            }
        }
        public static void selectionsortAsc() {
            if(!check)
            {
                System.out.println("\nBelum Masukkan Bilangan, Silahkan Pilih Menu Nomor 1");
                System.out.println(" ");
                        input();
            }
            String extreme = "Minimum";
            for(int i=0; i <= random_number.length-2; i++)
            {
                temp_max = i;

                k = i+1;
                System.out.println("\nPass " +k);

                for(int j=1+i; j <= random_number.length-1; j++)
                {
                    selectDisplay(random_number,extreme,j,temp_max);
                    if(random_number[j]>=random_number[temp_max])
                    {
                        temp_min = j;
                    }
                }
                selectDisplay(random_number,extreme,temp_min,temp_min);

                swap(random_number,i,temp_min);
                System.out.println(" ");
                System.out.println("Result of Pass " +k +": ");
                displayNumber(random_number);
            }
        }
        public static void selectionsortDesc() {
            if(!check)
            {
                System.out.println("\nBelum Masukkan Bilangan, Silahkan Pilih Menu Nomor 1");
                System.out.println(" ");
                        input();
            }
            String extreme = "Maximum";
            for(int i=0; i <= random_number.length-2; i++)
            {
                temp_max = i;

                k = i+1;
                System.out.println("\nPass " +k);

                for(int j=1+i; j <= random_number.length-1; j++)
                {
                    selectDisplay(random_number,extreme,j,temp_max);
                    if(random_number[j]>=random_number[temp_max])
                    {
                        temp_max = j;
                    }
                }
                selectDisplay(random_number,extreme,temp_max,temp_max);

                swap(random_number,i,temp_max);
                System.out.println(" ");
                System.out.println("Result of Pass " +k +": ");
                displayNumber(random_number);
            }
        }

        public static void displayNumber(int[] random_number)
        {
            for (int k=0; k <= random_number.length-1; k++){
                System.out.print(random_number[k]+" ");
            }
            System.out.println();
        }

        public static void Exit(){
            System.out.println("Terima kasih :)");
            System.exit(0);
        }

        public static void selectDisplay(int[] random_number, String
                extreme, int b, int temp_min) //printing selection method
        {
            for(int k=0; k<=random_number.length-1; k++)
            {
                if(k == temp_min)
                {
                    System.out.print("Current " +extreme +" ("
                            +random_number[k] +") ");
                }
                else if(k == j)
                {
                    System.out.print("(" +random_number[k] +") ");
                }
                else
                {
                    System.out.print(random_number[k] +" ");
                }
            }
            System.out.println();
        }
        public static void swap(int[] random_number, int var1, int
                var2)
        {
            int temp;
            temp=random_number[var1];
            random_number[var1]=random_number[var2];
            random_number[var2]=temp;
        }
    }
}