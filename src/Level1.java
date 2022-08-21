import  java.util.*;
public class Level1 {
    static LinkedList <String> allStoryStrings = new LinkedList<>();
    static LinkedList <Integer> memoryUndo = new LinkedList<>();
    static LinkedList <Integer> memoryRedo = new LinkedList<>();
    static HashMap <Integer, String> mapCommand = new HashMap<>();
    // flags
    static boolean flagUndo = false;
    static boolean flagReUndo = false;
    static boolean flagRedo = false;
    // create allStoryStrings
    static {
        allStoryStrings.add("");
    }
    // filling memoryUndo for zero string
    static {
        memoryUndo.add(0);
    }
    // create map command
    static final String ACTION_1 = "Put";
    static final String ACTION_2 = "DeleteItem";
    static final String ACTION_3 = "OutputItem";
    static final String ACTION_4 = "Undo()";
    static final String ACTION_5 = "Redo()";
    static {
        mapCommand.put(1, ACTION_1);
        mapCommand.put(2, ACTION_2);
        mapCommand.put(3, ACTION_3);
        mapCommand.put(4, ACTION_4);
        mapCommand.put(5, ACTION_5);
    }
    public static String BastShoe (String command) {
        String outString = "";
        String commandBuffer = "";
        StringBuilder stringBuffer = new StringBuilder();
        String stringBufferForDeleteItem = "";
        String stringBufferForDrop = "";
        boolean flagLimitItems = true;
        boolean flagCorrect = true;
        // number of items for delete
        int itemsDelete =0;
        // number of items for OutputItems
        int itemsOutput =0;
        //
        int zeroNumber = 0;
        //
        char [] ca;
        String outBuf;
        // reading incoming string
        if (!Character.isDigit(command.charAt(0))) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect) {
            zeroNumber = (Integer.parseInt(String.valueOf(command.charAt(0))));
        }
        if (flagCorrect && zeroNumber < 1) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && zeroNumber > 5) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 1 || zeroNumber == 2 || zeroNumber == 3) && command.length() == 1) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 1 || zeroNumber == 2 || zeroNumber == 3) && command.charAt(1) != ' ') {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 4 || zeroNumber == 5) && command.length() > 1) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect) {
            commandBuffer = (String.valueOf(command.charAt(0)));
            commandBuffer = mapCommand.get(Integer.parseInt(commandBuffer));
        }
        for (int i = 0; i < command.length() && flagCorrect; i++) {
            if (i > 1) {
                stringBuffer.append(command.charAt(i));
            }
        }

        // checks of the correct entry
        for (int i = 0; i < stringBuffer.length(); i++) {
            if ((commandBuffer.equals(ACTION_2) || commandBuffer.equals(ACTION_3)) && (stringBuffer.charAt(0) == '-') && stringBuffer.length() > 1) {
                continue;
            }
            if ((commandBuffer.equals(ACTION_2) || commandBuffer.equals(ACTION_3)) && (!Character.isDigit(stringBuffer.charAt(i)))) {
                outString = allStoryStrings.get(allStoryStrings.size() - 1);
                commandBuffer = "";
                stringBuffer = new StringBuilder();
            }
        }
        if ((commandBuffer.equals(ACTION_5) || commandBuffer.equals(ACTION_4)) && stringBuffer.length() != 0) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }

        // condition to flagUndo
        if (commandBuffer.contains(ACTION_5) && flagUndo) {
            flagUndo = false;
        }
        //condition for Reload Undo
        if (flagUndo && (commandBuffer.equals(ACTION_2) || commandBuffer.equals(ACTION_1)) ) {
            stringBufferForDrop = allStoryStrings.get(memoryUndo.size() - 1);
            allStoryStrings = new LinkedList<>();
            allStoryStrings.add(stringBufferForDrop);
            memoryUndo = new LinkedList<>();
            memoryUndo.add(0);
            memoryRedo = new LinkedList<>();
            flagUndo = false;
        }
        //filling allStoryStrings
        //block command-arrayStorage with Put
        if (commandBuffer.equals(ACTION_1)) {
            allStoryStrings.add(allStoryStrings.get(allStoryStrings.size() - 1) + stringBuffer);
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
        }
        //block command-arrayStorage with DeleteItem
        if (commandBuffer.equals(ACTION_2)) {
            itemsDelete = Integer.parseInt(stringBuffer.toString());
            stringBuffer = new StringBuilder();
        }
        if (itemsDelete < 0) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }

        if (commandBuffer.equals(ACTION_2) && itemsDelete <= (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            stringBufferForDeleteItem += allStoryStrings.get(allStoryStrings.size() - 1);
        }
        if (commandBuffer.equals(ACTION_2) && itemsDelete > (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            allStoryStrings.add("");
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }

        for ( int i = 0 ;i < ((stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1)); i++) {
            if (commandBuffer.equals(ACTION_2)) {
                stringBuffer.append(stringBufferForDeleteItem.charAt(i));
            }
        }
        if (commandBuffer.equals(ACTION_2)) {
            allStoryStrings.add(stringBuffer.toString());
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }
        //block output string with OutputItem
        if (commandBuffer.equals(ACTION_3)) {
            itemsOutput = Integer.parseInt(stringBuffer.toString());
        }
        if (commandBuffer.equals(ACTION_3) && (itemsOutput > (allStoryStrings.get(allStoryStrings.size() - 1).length() - 1) || itemsOutput < 0)) {
            outString = "";
            commandBuffer = "";
            flagLimitItems = false;
        }
        if (flagLimitItems && commandBuffer.equals(ACTION_3)) {
            outBuf = allStoryStrings.get(allStoryStrings.size() - 1);
            ca = outBuf.toCharArray();
            outBuf = String.valueOf(ca[itemsOutput]);
            allStoryStrings.add(outBuf);
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
        }
        //block Undo
        if (commandBuffer.equals(ACTION_4) && memoryUndo.size() > 1 && !flagUndo) {
            flagUndo = true;
            memoryRedo.add(memoryUndo.get(memoryUndo.size() - 1));
            memoryUndo.remove(memoryUndo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_4) && memoryUndo.size() > 1) {
            memoryRedo.add(memoryUndo.get(memoryUndo.size() - 1));
            memoryUndo.remove(memoryUndo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_4) && memoryUndo.size() == 1 && !flagReUndo) {
            flagReUndo = true;
            memoryRedo.add(memoryUndo.get(0));
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_4) && memoryUndo.size() == 1) {
            allStoryStrings.add(allStoryStrings.get(memoryUndo.get(0)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_4) && memoryRedo.size() == 1 && flagRedo) {
            memoryUndo.remove(memoryUndo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }

        // block Redo
        if (commandBuffer.equals(ACTION_5) && memoryUndo.size() == 1 && flagReUndo) {
            flagReUndo = false;
            memoryRedo.remove(memoryRedo.size() - 1);
            allStoryStrings.add(allStoryStrings.get((memoryUndo.get(memoryUndo.size() - 1))));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_5) && memoryRedo.size() == 1 && !flagRedo) {
            flagRedo = true;
            memoryUndo.add(0);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_5) && memoryRedo.size() == 1) {
            allStoryStrings.add(allStoryStrings.get(memoryRedo.get(0)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_5) && memoryRedo.size() > 1) {
            memoryUndo.add(memoryRedo.get(memoryRedo.size() - 1));
            memoryRedo.remove(memoryRedo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
        }
        return outString;
    }
    public static void main(String[] args) {
        String da1 = "1 Привет";
        String da2 = "3 0";
        String da3 = "3";
        String da4 = "3 -1";
        String da5 = "4";
        String da6 = "5";
        String da7 = "4";
        String da8 = "5";
        String da9 = "5";
        String da10 = "5";
        String da11 = "5";
        String da12 = "4";
        String da13 = "4";
        String da14 = "2 2";
        String da15 = "4";
        String da16 = "5";
        String da17 = "5";
        String da18 = "5";


        System.out.println(BastShoe(da1));
        System.out.println(BastShoe(da2));
        System.out.println(BastShoe(da3));
        System.out.println(BastShoe(da4));
        System.out.println(BastShoe(da5));
        System.out.println(BastShoe(da6));
        System.out.println(BastShoe(da7));
        System.out.println(BastShoe(da8));

        System.out.println(BastShoe(da9));
        System.out.println(BastShoe(da10));
        System.out.println(BastShoe(da11));
        System.out.println(BastShoe(da12));
        System.out.println(BastShoe(da13));
        System.out.println(BastShoe(da14));
        System.out.println(BastShoe(da15));
        System.out.println(BastShoe(da16));
        System.out.println(BastShoe(da17));
        System.out.println(BastShoe(da18));

    }
}
