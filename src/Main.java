import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        Solver solver = new Solver(x);
        String magicWord = input.next();
        if (magicWord.equals("save")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("solver.txt"))) {
                oos.writeObject(solver);
                System.out.println("Saved");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        String anotherMagicWord = input.next();
        if (anotherMagicWord.equals("upload")) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("solver.txt"))) {
                Solver uploadedSolver = (Solver)ois.readObject();
                System.out.println("x = " + uploadedSolver.x);
                System.out.println("y = " + uploadedSolver.solveFunc());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
class Solver implements Serializable {
    double x;
    Solver(double x){
        this.x = x;
    }
    public double solveFunc(){
        double y = x - Math.sin(x);
        return y;
    }
}