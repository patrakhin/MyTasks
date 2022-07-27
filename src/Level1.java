import java.util.*;
public class Level1 {
    static HashMap <Integer, String> mapCommand = new HashMap<>();
    //creat map - command
    static {
        mapCommand.put(1, "Put");
        mapCommand.put(2, "DeleteItem");
        mapCommand.put(3, "OutputItem");
        mapCommand.put(4, "Undo()");
        mapCommand.put(5, "Redo()");
    }
    //
    static ArrayList <String> storyArray = new ArrayList<>();
    static int countStoryArray = 0;
    static HashMap <Integer, String> mapStory = new HashMap<>();
    static int countMapStory = -1;
    static int countPutAndDeleteItem = 0;
    static int countPut = 0;
    static int countUndo = 0;
    static int countRedo = 0;
    static int memoryUndo = 0;
    static int memoryRedo = 0;
    static boolean flagUndo = false;
    static String outString = "";
    static int countDeleteItem = 0;
    static int countOutputItem = 0;
    static int memoryOfStoryCountStory;
    static int flagKickUndo = 0;
    static int d;
    static int countUndo2 = 0;

    public static String BastShoe (String command) {
        String commandBuffer = "";
        String stringBuffer = "";
        String stringBufferForDeleteItem = "";
        String stringBufferForDrop = "";
        int countBufferForDrop = 0;
        boolean flagLimitItems = true;

        boolean flagZeroPut = false;
        // number of items for delete
        int itemsDelete =0;
        // number of items for OutputItems
        int itemsOutput =0;
        String drop = "";
        //loop - reader incoming string
        for (int i = 0; i < command.length(); i++) {
            if (i == 0 && (!Character.isDigit(command.charAt(i))) ) {
                outString = "";
                outString = storyArray.get(storyArray.size() - 1);
                commandBuffer = "";
                stringBuffer = "";
            }
            if (i == 0 ) {
                commandBuffer += mapCommand.get(Integer.parseInt(String.valueOf(command.charAt(i))));
                continue;
            }
            if (i == 1 && command.charAt(i) != ' ') {
                outString = "";
                outString = storyArray.get(storyArray.size() - 1);
                commandBuffer = "";
                stringBuffer = "";
            }
            if ((commandBuffer.contains("4") || commandBuffer.contains("5")) && command.length() > 1) {
                outString = "";
                outString = storyArray.get(storyArray.size() - 1);
                commandBuffer = "";
                stringBuffer = "";
            }
            if (i == 1 && command.charAt(i) == ' ') {
                continue;
            }
            stringBuffer += command.charAt(i);
        }

        //block all counters

        if (commandBuffer.equals("Put") || commandBuffer.equals("DeleteItem")) {
            countPutAndDeleteItem += 1;
        }
        if (commandBuffer.equals("Undo()")) {
            countUndo += 1;
        }
        if (commandBuffer.equals("Redo()")) {
            countRedo += 1;
        }

        // drop flagUNDO
        if ((commandBuffer.equals("Put") || commandBuffer.equals("DeleteItem")) && flagUndo) {
            stringBufferForDrop = storyArray.get(storyArray.size() - 1);
            storyArray = new ArrayList<>();
            storyArray.add(stringBufferForDrop);
            stringBufferForDrop = "";
            countBufferForDrop = countStoryArray;
            stringBufferForDrop = mapStory.get(countBufferForDrop);
            countBufferForDrop = 0;
            countStoryArray = 0;
            countMapStory = -1;
            mapStory = new HashMap<>();
            mapStory.put(countStoryArray, stringBufferForDrop);
            stringBufferForDrop = "";
            countPut = 0;
            flagUndo = false;
            countDeleteItem = 0;
            countOutputItem = 0;
            countUndo = 0;
            memoryOfStoryCountStory = 0; // :)
            memoryUndo = 0;
            memoryRedo = 0;
            flagKickUndo = 0;
            countUndo2  = 0;
        }
        // add to mapStory
        countMapStory += 1;
        mapStory.put(countMapStory,commandBuffer);
        // add mapStory if ZeroPut


        //catcher for Redo
        if (commandBuffer.equals("Redo()") && countUndo <= 0) {
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            storyArray.add(storyArray.get(storyArray.size() - 1));
            countStoryArray += 1;
            commandBuffer = "";
            stringBuffer = "";
        }

        //if after Redo is Undo
        if (commandBuffer.equals("Undo()") && mapStory.containsValue("Redo()")) {
            memoryRedo = 0;
            countRedo = 0;
        }

        // catcher for Undo
        if (commandBuffer.equals("Undo()") && memoryUndo == 0 && countUndo > 1) {
            outString = "";
            outString = storyArray.get(0);
            storyArray.add(storyArray.get(0));
            countStoryArray += 1;
            commandBuffer = "";
            stringBuffer = "";
        }

        //block command-arrayStorage with Put ONCE
        if ((commandBuffer.equals("Put") && storyArray.isEmpty())) {
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
            countPut += 1;
            stringBuffer = "";
            commandBuffer = "";
            outString += storyArray.get(0);
        }
        //block command-arrayStorage with Put TWICE
        if (commandBuffer.equals("Put")) {
            storyArray.add(storyArray.get(storyArray.size() - 1) + stringBuffer);
            countStoryArray += 1;
            countPut += 1;
            stringBuffer = "";
        }
        //block output string with Put

        if (commandBuffer.equals("Put")) {
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            commandBuffer = "";
        }



        //block command-arrayStorage with DeleteItem
        if (commandBuffer.equals("DeleteItem")) {
            itemsDelete = Integer.parseInt(String.valueOf(stringBuffer));
            stringBuffer = "";
        }

        if (commandBuffer.equals("DeleteItem") && itemsDelete <= (String.valueOf(storyArray.get(storyArray.size() - 1))).length()) {
            stringBufferForDeleteItem += storyArray.get(storyArray.size() - 1);
        }
        if (commandBuffer.equals("DeleteItem") && itemsDelete > (String.valueOf(storyArray.get(storyArray.size() - 1))).length()) {
            outString = "";
            storyArray.add("DeleteItem");
            commandBuffer = "";
            stringBuffer = "";
            countStoryArray += 1;
        }

        for ( int i = 0 ;i < (stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1) ; i++) {
            if (commandBuffer.equals("DeleteItem")) {
                stringBuffer += stringBufferForDeleteItem.charAt(i);
            }
        }
        if (commandBuffer.equals("DeleteItem")) {
            storyArray.add(stringBuffer);
            countDeleteItem += 1;
            countStoryArray += 1;
            stringBufferForDeleteItem = "";
            stringBuffer = "";
        }
        //block output string with DeleteItem
        if (commandBuffer.equals("DeleteItem")) {
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            commandBuffer = "";
        }
        //block output string with OutputItem
        if (commandBuffer.equals("OutputItem")) {
            itemsOutput = Integer.parseInt(String.valueOf(stringBuffer));
            stringBuffer = "";
        }
        if (commandBuffer.equals("OutputItem") && itemsOutput > storyArray.get(storyArray.size() - 1).length()) {
            outString = "";
            storyArray.add("");
            countStoryArray += 1;
            commandBuffer = "";
            flagLimitItems = false;
            stringBuffer = "";
        }
        for (int i = 0; i < storyArray.get(storyArray.size() - 1).length(); i++) {
            if (flagLimitItems && commandBuffer.equals("OutputItem")) {
                stringBuffer = String.valueOf(storyArray.get(storyArray.size() - 1).charAt(itemsOutput));
                itemsOutput = 0;
                storyArray.add(stringBuffer);
                stringBuffer = "";
                outString = storyArray.get(storyArray.size() - 1);
                countStoryArray += 1;
                stringBuffer = "";
                break;
            }
        }

        //block Undo()

        int b;
        if (countUndo == 1) {
            b = mapStory.size() - 2;
        }
        else {
            b = memoryUndo;
        }
        for (; b >= 0 ; b --) { //

            if (commandBuffer.equals("Undo()") && (mapStory.get(b - 1).contains("Put") || mapStory.get(b - 1).contains("DeleteItem")) && countUndo == 1) {
                storyArray.add(storyArray.get(b - 1));

                outString = storyArray.get((storyArray.size() - 1));
                flagUndo = true;
                memoryUndo = (b - 1);
                countStoryArray += 1;
                countPutAndDeleteItem -= 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
            if (commandBuffer.equals("Undo()") && (mapStory.get(b - 1).contains("Put") || mapStory.get(b - 1).contains("DeleteItem")) && countUndo > 1) {
                storyArray.add(storyArray.get(b - 1));

                outString = storyArray.get((storyArray.size() - 1));
                flagUndo = true;
                memoryUndo = (b-1);
                countStoryArray += 1;
                countPutAndDeleteItem -= 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
        }




        //block Redo
        int t;
        if (countRedo == 1) {
            t = mapStory.size() -2;
        }
        else {
            t = memoryRedo;
        }

        for (; t >= 0; t--) {
            if (commandBuffer.equals("Redo()") && mapStory.get(t - 1).contains("Undo()") && countRedo == 1) {
                storyArray.add(storyArray.get(t - 1));
                outString = storyArray.get((storyArray.size() - 1));
                memoryRedo = (t - 1);
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
            if (commandBuffer.equals("Redo()") && mapStory.get(t - 1).contains("Undo()") && countRedo > 1) {
                storyArray.add(storyArray.get(t - 1));
                outString = storyArray.get((storyArray.size() - 1));
                memoryRedo = (t - 1);
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
            if (commandBuffer.equals("Redo()") && mapStory.get(t - 1).contains("Redo()") && countRedo == 1) {
                storyArray.add(storyArray.get(t -1 ));
                outString = storyArray.get((storyArray.size() - 1));
                memoryRedo = (t - 1);
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }

        }
        return outString;
    }
}
