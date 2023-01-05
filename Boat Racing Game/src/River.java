import java.util.ArrayList;

public class River {
    private String difficultyLevel;
    private Item[] riverList = new Item[100];
    private ArrayList<Item> riverItems;

    // Constructor
    public River() {
        generateTrack();
    }
    
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        generateTrack();
    }
    
    public Item[] getRiverList() {
        return riverList;
    }

    public void printRiverList() {
        System.out.print("    ");

        for (int i = 0; i < riverList.length / 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int i = 0; i < riverList.length / 10; i++) {
            System.out.print(" " + i + "  ");
            for (int j = 0; j < riverList.length / 10; j++) {
                if (riverList[i * 10 + j] instanceof Blank) {
                    System.out.print(".  ");
                } else if (riverList[i * 10 + j] instanceof Current) {
                    riverList[i * 10 + j].generateMagnitude();
                    System.out.print("C  ");
                } else if (riverList[i * 10 + j] instanceof Trap) {
                    riverList[i * 10 + j].generateMagnitude();
                    System.out.printf("T  ");
                }
            }
            if (i == riverList.length / 10 - 1) {
                System.out.print("END");
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printRiverItem() {
        for (Item riveritem : riverItems) {
            if (riveritem instanceof Blank) {
                System.out.print(".");
            } else if (riveritem instanceof Current) {
                System.out.printf("C[%d]", riveritem.getPosition());
            } else if (riveritem instanceof Trap) {
                System.out.printf("T[%d]", riveritem.getPosition());
            }
        }
        System.out.print(".");
    }

    private void generateRiverItems(int blankNum, int currentNum, int trapNum) {
        riverItems = new ArrayList<Item>();
        int total_ratio = blankNum + currentNum + trapNum;

        for (int i = 0; i < (currentNum * 100) / total_ratio; i++) {
            Item temp = new Current();
            boolean positionValid = false;

            while (!positionValid) {
                int counter = 0;
                for (Item riveritem : riverItems) {
                    if (temp.getPosition() != riveritem.getPosition()) {
                        counter++;
                    } else {
                        temp = new Current();
                        break;
                    }
                }

                if (counter == riverItems.size()) {
                    riverItems.add(temp);
                    positionValid = true;
                }
            }
        }

        for (int i = 0; i < (trapNum * 100) / total_ratio; i++) {
            Item temp = new Trap();
            boolean positionValid = false;
            while (!positionValid) {
                int counter = 0;
                for (Item riveritem : riverItems) {
                    if (temp.getPosition() != riveritem.getPosition()) {
                        counter++;
                    } else {
                        temp = new Trap();
                        break;
                    }
                }

                if (counter == riverItems.size()) {
                    riverItems.add(temp);
                    positionValid = true;
                }
            }
        }
    }

    private void generateTrack() {
        if (difficultyLevel == null) {
            generateRiverItems(1, 0, 0);
        } else if (difficultyLevel.equals("1")) {
            generateRiverItems(5, 3, 1);
        } else if (difficultyLevel.equals("2")) {
            generateRiverItems(4, 2, 1);
        } else if (difficultyLevel.equals("3")) {
            generateRiverItems(3, 1, 1);
        }

        // generate currents and traps in river
        for (int i = 0; i < riverList.length; i++) {
        	// generate river with blank items
            riverList[i] = new Blank();
        }
        // insert currents and traps into riverlist
        for (Item riveritem : riverItems) {
            riverList[riveritem.getPosition()] = riveritem;
        }

        while (!checkRiver()) {
            generateTrack();
        }
    }

    public boolean checkRiver() {
        int count = 0;
        for (int i = 0; i < riverList.length - 1; i++) {
            if (riverList[i] instanceof Trap && riverList[i + 1] instanceof Trap) {
                count++;
            } else {
                count = 0;
            }
        }
        return (count < 5) ? true : false;
    }
}