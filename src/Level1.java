import java.util.*;
public class Level1 {
    static HashMap <Integer, String> mapCommand = new HashMap<>();
    static ArrayList <String> storyArray = new ArrayList<>();
    static HashMap <Integer, String> mapStory = new HashMap<>();
    //counts
    static  int countMapStory;
    static  int countStoryArray;
    static  int countUndo;
    static  int countRedo;
    static  int countPutAndDeleteItem;
    //memory
    static  int memoryUndo;
    static  int memoryRedo;
    static  int memoryLimitUndo;
    //flags
    static boolean flagUndo = false;
    //creat map - command
    static {
        mapCommand.put(1, "Put");
        mapCommand.put(2, "DeleteItem");
        mapCommand.put(3, "OutputItem");
        mapCommand.put(4, "Undo()");
        mapCommand.put(5, "Redo()");
    }
    //

    public static String BastShoe (String command) {
        String outString = "";
        String commandBuffer = "";
        String stringBuffer = "";
        String stringBufferForDeleteItem = "";
        String stringBufferForDrop = "";
        int countBufferForDrop = 0;
        boolean flagLimitItems = true;

        // number of items for delete
        int itemsDelete =0;
        // number of items for OutputItems
        int itemsOutput =0;

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
        // add to mapStory
        countMapStory += 1;
        mapStory.put(countMapStory,commandBuffer);


        if (countRedo == 1) {
            memoryLimitUndo = countUndo;
        }


        // add to mapStory after DROP

        if (flagUndo == true && commandBuffer.equals("Put") && mapStory.get(countMapStory - 1).equals("Undo()")) {
            memoryUndo = 0;
            countRedo = 0;
            memoryRedo = 0;
            countUndo = 1;///////
            countPutAndDeleteItem += 1;
            flagUndo = false;
        }
        if (flagUndo == true && commandBuffer.equals("DeleteItem") && mapStory.get(countMapStory - 1).equals("Undo()")) {
            memoryUndo = 0;
            countRedo = 0;
            memoryRedo = 0;
            countUndo = 1;///////
            countPutAndDeleteItem += 1;
            flagUndo = false;
        }

        //exception UNDO
        if (commandBuffer.equals("Undo()") && mapStory.size() == 1) {
            outString = "";
            stringBuffer = "";
            commandBuffer = "";
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
        }
        if (commandBuffer.equals("Undo()") && mapStory.size() == 2) {
            outString = "";
            stringBuffer = "";
            commandBuffer = "";
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
        }
        if (commandBuffer.equals("Undo()") && mapStory.size() > 2 && mapStory.get(1).contains("Put") && countPutAndDeleteItem == 1) {
            outString = "";
            stringBuffer = "";
            commandBuffer = "";
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
        }
        //exception REDO
        if (commandBuffer.equals("Redo()") && mapStory.size() == 1) {
            outString = "";
            stringBuffer = "";
            commandBuffer = "";
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
        }
        if (commandBuffer.equals("Redo()") && mapStory.size() == 2) {
            outString = "";
            stringBuffer = "";
            commandBuffer = "";
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
        }

        //block command-arrayStorage with Put ONCE
        if ((commandBuffer.equals("Put") && storyArray.isEmpty())) {
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
            stringBuffer = "";
            commandBuffer = "";
            outString = "";
            outString = storyArray.get(0);
        }
        //block command-arrayStorage with Put TWICE
        if (commandBuffer.equals("Put")) {
            storyArray.add(storyArray.get(storyArray.size() - 1) + stringBuffer);
            countStoryArray += 1;
            stringBuffer = "";
            commandBuffer = "";
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
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
            storyArray.add("");
            commandBuffer = "";
            stringBuffer = "";
            countStoryArray += 1;
        }

        for ( int i = 0 ;i < ((stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1)); i++) {
            if (commandBuffer.equals("DeleteItem")) {
                stringBuffer += stringBufferForDeleteItem.charAt(i);
            }
        }
        if (commandBuffer.equals("DeleteItem")) {
            storyArray.add(stringBuffer);
            countStoryArray += 1;
            stringBufferForDeleteItem = "";
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            commandBuffer = "";
            stringBuffer = "";
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


        //block UNDO
        int b;
        if (countUndo == 1) {
            b = countMapStory;
            memoryLimitUndo = countMapStory;
        }
        else {
            b = memoryUndo;
        }
        for (; b >= 1 ; b --) { //
            if (commandBuffer.equals("Undo()") && (mapStory.get(b).contains("Put") || mapStory.get(b).contains("DeleteItem")) && memoryUndo != 1) {
                storyArray.add(storyArray.get(b - 2));
                outString = storyArray.get((storyArray.size() - 1));
                flagUndo = true;
                memoryUndo = b - 1;
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
            if (commandBuffer.equals("Undo()") && (mapStory.get(b).contains("Put") || mapStory.get(b).contains("DeleteItem")) && memoryUndo == 1) {
                storyArray.add(storyArray.get(0));
                outString = storyArray.get((storyArray.size() - 1));
                flagUndo = true;
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }

        }


        //block Redo

        int t;
        if (countRedo == 1) {
            t = countMapStory;
        }
        else {
            t = memoryRedo;
        }

        for (; t >= 2; t--) {
            if (commandBuffer.equals("Redo()") && mapStory.get(t).contains("Undo()") && t !=2 ) {
                storyArray.add(storyArray.get(t -2));

                outString = storyArray.get((storyArray.size() - 1));
                memoryRedo = t - 1;
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
            if (commandBuffer.equals("Redo()") && !mapStory.get(t).contains("Undo()") && t == 2  ) {
                storyArray.add(storyArray.get(memoryRedo));
                outString = storyArray.get((storyArray.size() - 1));
                flagUndo = true;
                countStoryArray += 1;
                commandBuffer = "";
                stringBuffer = "";
                break;
            }
        }
        return outString;
    }
}
