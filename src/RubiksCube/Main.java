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
            } else if (input.toLowerCase().equals("fw")) {
                theCube.turnFW();
            } else if (input.toLowerCase().equals("fw'")) {
                theCube.turnFWP();
            } else if (input.toLowerCase().equals("fw2")) {
                theCube.turnFW2();
            } else if (input.toLowerCase().equals("u")) {
                theCube.turnU();
            } else if (input.toLowerCase().equals("u'")) {
                theCube.turnUP();
            } else if (input.toLowerCase().equals("u2")) {
                theCube.turnU2();
            } else if (input.toLowerCase().equals("uw")) {
                theCube.turnUW();
            } else if (input.toLowerCase().equals("uw'")) {
                theCube.turnUWP();
            } else if (input.toLowerCase().equals("uw2")) {
                theCube.turnUW2();
            } else if (input.toLowerCase().equals("d")) {
                theCube.turnD();
            } else if (input.toLowerCase().equals("d'")) {
                theCube.turnDP();
            } else if (input.toLowerCase().equals("d2")) {
                theCube.turnD2();
            } else if (input.toLowerCase().equals("dw")) {
                theCube.turnDW();
            } else if (input.toLowerCase().equals("dw'")) {
                theCube.turnDWP();
            } else if (input.toLowerCase().equals("dw2")) {
                theCube.turnDW2();
            } else if (input.toLowerCase().equals("r")) {
                theCube.turnR();
            } else if (input.toLowerCase().equals("r'")) {
                theCube.turnRP();
            } else if (input.toLowerCase().equals("r2")) {
                theCube.turnR2();
            } else if (input.toLowerCase().equals("rw")) {
                theCube.turnRW();
            } else if (input.toLowerCase().equals("rw'")) {
                theCube.turnRWP();
            } else if (input.toLowerCase().equals("rw2")) {
                theCube.turnRW2();
            } else if (input.toLowerCase().equals("l")) {
                theCube.turnL();
            } else if (input.toLowerCase().equals("l'")) {
                theCube.turnLP();
            } else if (input.toLowerCase().equals("l2")) {
                theCube.turnL2();
            } else if (input.toLowerCase().equals("lw")) {
                theCube.turnLW();
            } else if (input.toLowerCase().equals("lw'")) {
                theCube.turnLWP();
            } else if (input.toLowerCase().equals("lw2")) {
                theCube.turnLW2();
            } else if (input.toLowerCase().equals("b")) {
                theCube.turnB();
            } else if (input.toLowerCase().equals("b'")) {
                theCube.turnBP();
            } else if (input.toLowerCase().equals("b2")) {
                theCube.turnB2();
            } else if (input.toLowerCase().equals("bw")) {
                theCube.turnBW();
            } else if (input.toLowerCase().equals("bw'")) {
                theCube.turnBWP();
            } else if (input.toLowerCase().equals("bw2")) {
                theCube.turnBW2();
            } else if (input.toLowerCase().equals("m")) {
                theCube.turnM();
            } else if (input.toLowerCase().equals("m'")) {
                theCube.turnMP();
            } else if (input.toLowerCase().equals("m2")) {
                theCube.turnM2();
            } else if (input.toLowerCase().equals("e")) {
                theCube.turnE();
            } else if (input.toLowerCase().equals("e'")) {
                theCube.turnEP();
            } else if (input.toLowerCase().equals("e2")) {
                theCube.turnE2();
            } else if (input.toLowerCase().equals("s")) {
                theCube.turnS();
            } else if (input.toLowerCase().equals("s'")) {
                theCube.turnSP();
            } else if (input.toLowerCase().equals("s2")) {
                theCube.turnS2();
            } else if (input.toLowerCase().equals("x")) {
                theCube.turnX();
            } else if (input.toLowerCase().equals("x'")) {
                theCube.turnXP();
            } else if (input.toLowerCase().equals("x2")) {
                theCube.turnX2();
            } else if (input.toLowerCase().equals("y")) {
                theCube.turnY();
            } else if (input.toLowerCase().equals("y'")) {
                theCube.turnYP();
            } else if (input.toLowerCase().equals("y2")) {
                theCube.turnY2();
            } else if (input.toLowerCase().equals("z")) {
                theCube.turnZ();
            } else if (input.toLowerCase().equals("z'")) {
                theCube.turnZP();
            } else if (input.toLowerCase().equals("z2")) {
                theCube.turnZ2();
            } else if (input.toLowerCase().equals("scramble")) {
                theCube.scramble();
            }
        }
    }
}
