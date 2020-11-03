package RubiksCube;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = "";
        RubiksCube theCube = new RubiksCube();
        CubeRenderer.initialize(theCube);
        System.out.print(

                    "Commands are clockwise by default\n" +
                    "Add \" ' \" to make command counterclockwise\n" +
                    "Add \" 2 \" to make command twice\n" +
                    "Commands:\n" +
                    "F: Turn front side\n" +
                    "U: Turn top side\n" +
                    "D: Turn bottom side\n" +
                    "R: Turn right side\n" +
                    "L: Turn left side clockwise\n" +
                    "B: Turn back side\n");

        while (!input.toLowerCase().equals("exit")) {
            System.out.print(theCube.printCube());
            System.out.println("Print 'exit' to exit");
            System.out.print("Command: ");
            input = kb.nextLine();

            if (input.toLowerCase().equals("f")) {
                theCube.turnF();
            } else if (input.toLowerCase().equals("f'")) {
                theCube.turnFP();
            } else if (input.toLowerCase().equals("f2")) {
                theCube.turnF2();
            } else if (input.toLowerCase().equals("u")) {
                theCube.turnU();
            } else if (input.toLowerCase().equals("u'")) {
                theCube.turnUP();
            } else if (input.toLowerCase().equals("u2")) {
                theCube.turnU2();
            } else if (input.toLowerCase().equals("d")) {
                theCube.turnD();
            } else if (input.toLowerCase().equals("d'")) {
                theCube.turnDP();
            } else if (input.toLowerCase().equals("d2")) {
                theCube.turnD2();
            } else if (input.toLowerCase().equals("r")) {
                theCube.turnR();
            } else if (input.toLowerCase().equals("r'")) {
                theCube.turnRP();
            } else if (input.toLowerCase().equals("r2")) {
                theCube.turnR2();
            } else if (input.toLowerCase().equals("l")) {
                theCube.turnL();
            } else if (input.toLowerCase().equals("l'")) {
                theCube.turnLP();
            } else if (input.toLowerCase().equals("l2")) {
                theCube.turnL2();
            } else if (input.toLowerCase().equals("b")) {
                theCube.turnB();
            } else if (input.toLowerCase().equals("b'")) {
                theCube.turnBP();
            } else if (input.toLowerCase().equals("b2")) {
                theCube.turnB2();
            } else if (input.toLowerCase().equals("scramble")) {
                theCube.scramble();
            }

        }

    }

}
