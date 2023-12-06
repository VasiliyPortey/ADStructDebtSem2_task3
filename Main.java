import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Table{
    int[][] masses;
    Table(String[] massesArray){
        masses = new int[massesArray.length][2];
        for (int i = 0; i<massesArray.length;i++){
            masses[i][0] = Integer.parseInt(massesArray[i]);
            masses[i][1] = toSumOfNumbers(String.valueOf(masses[i][0]));
        }
    }

    private int toSumOfNumbers(String number){
        int result = 0;
        for (int i = 0; i<number.length(); i++)
            result = result + Character.getNumericValue(number.charAt(i));
        return result;
    }

    public String toString(int index){
        return String.valueOf(masses[index][0]);
    }

    String sort(){
        StringBuilder result = new StringBuilder();
        Arrays.sort(masses, Comparator.comparingDouble(a -> a[1]));
        for (int i = 0; i < masses.length; i++)
            result.append(toString(i).concat("\n"));
        return result.toString();
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку с массами посетителей (разделитель = пробел): ");
        String massesString = sc.nextLine();
        String[] massesArray = massesString.split(" ");
        Table table = new Table(massesArray);
        System.out.println("Отсортированный список: \n" + table.sort());
    }
}