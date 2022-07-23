import java.util.*;
public class Level1 {
    //input string
    static String commandNow;
    //current string
    static  String currentString = "";
    //Array - storage
    static ArrayList<String> arrayStorage = new ArrayList<>();
    //count array storage
    static int countArrayStorage = 0;
    //Array - saving all command
    static ArrayList<String> arraySavingAllCommand = new ArrayList<>();
    //Array saving Put and Delete
    static  ArrayList <String> savingPutAndDelete = new ArrayList<>();
    //Array store Delete
    static ArrayList <String> storeDelete = new ArrayList<>();
    //Count saving Put and Del
    static int countSavingPutAndDelete = 0;
    //Count for store Delete
    static int countStoreDelete = 0;
    // Array store Put
    static ArrayList <String> storePut = new ArrayList<>();
    // count array store put
    static int countStorePut = 0;
    //Array store for escape will Undo its use in Redo
    static ArrayList <String> storeForRedo = new ArrayList<>();
    //count storeRedo
    static int countStoreRedo = 0;
    // Array store DeleteItems for Redo
    static ArrayList <String> storeDeleteItemsForRedo = new ArrayList<>();
    //count store DeleteItems for Redo
    static  int countStoreDeleteItemsForRedo = 0;
    public static String BastShoe(String command) {

        commandNow += command;

        // my code

        HashMap <Integer, String> mapCommand = new HashMap<>();
        //creat map - command
        mapCommand.put(1, "Put");
        mapCommand.put(2, "DeleteItem");
        mapCommand.put(3, "OutputItem");
        mapCommand.put(4, "Undo");
        mapCommand.put(5, "Redo");
        //
        ArrayList<String> arrayStorage = new ArrayList<>();

        //command buffer
        String commandBuffer = "";
        // strings buffer
        StringBuilder stringBuffer = new StringBuilder();
        //flag commandBuffer - is empty
        boolean flagCommandBuffer = false;
        // buffer for items delete
        String bufferDelete = "";
        // number of items for delete
        int itemsDelete =0;
        //flag for running Delete
        boolean runningDelete = false;
        //flag for OutputItem
        boolean flagOutputItem = false;
        //buffer for get arrayStorage string
        String getArrayStorageString = "";
        // number of items for OutputItem
        int itemsOutput =0;
        // OutputItem string
        String stringOutputItem = "";
        //flag saving command Undo()
        boolean flagSavingUndo = false;
        //Buffer string for store Delete
        String bufSoreDelete = "";
        // command buffer for Undo
        String commandBufUndo = "";
        //command buffer for Redo
        String commandBufferRedo = "";





        //loop - reader incoming string
        for (int i = 0; i < command.length(); i++) {

            if (i == 0 && mapCommand.containsKey(Integer.parseInt(String.valueOf(command.charAt(i))))) {
                commandBuffer = mapCommand.get(Integer.parseInt(String.valueOf(command.charAt(i))));
                continue;
            }
            if (i == 0 && !mapCommand.containsKey(Integer.parseInt(String.valueOf(command.charAt(i))))) {
                System.out.println(currentString);
            }
            if (commandBuffer.contains("Undo") && command.length() > 1) {  // condition for UNDO
                System.out.println(currentString);
            }
            if (commandBuffer.contains("Redo") && command.length() > 1) {  // condition for REDO
                System.out.println(currentString);
            }
            if (i == 1 && command.charAt(i) == ' ') {
                continue;
            }

            stringBuffer.append(command.charAt(i));
        }
        //block saving all command
        if (commandBuffer.length() > 0) {
            arraySavingAllCommand.add(commandBuffer);
        }
        if (commandBuffer.equals("Undo")) {
            flagSavingUndo = true;
        }
        //block saving Put and Delete
        if (commandBuffer.equals("Put")) {
            savingPutAndDelete.add(commandBuffer);
            countSavingPutAndDelete += 1;
        }
        if (commandBuffer.equals("DeleteItem")) {
            savingPutAndDelete.add(commandBuffer);
            countSavingPutAndDelete += 1;
        }
        //block saving store Delete
        for (int i = 0; i < arrayStorage.size() && commandBuffer.equals("DeleteItem"); i++) {
            bufSoreDelete += arrayStorage.get(i);
        }
        if (bufSoreDelete.length() > 0) {
            storeDelete.add(bufSoreDelete);
            countStoreDelete += 1;
        }
        bufferDelete = "";
        //block command-arrayStorage with Put
        if (commandBuffer.equals("Put")) {
            arrayStorage.add(String.valueOf(stringBuffer));
            countArrayStorage += 1;
            // add saving to array store put
            storePut.add(String.valueOf(stringBuffer));
            countStorePut += 1;
            stringBuffer = new StringBuilder("");
        }
        //block output string with Put
        if (commandBuffer.equals("Put")) {
            currentString = "";
        }
        for (int i = 0; i < arrayStorage.size(); i++) {

            if (commandBuffer.equals("Put")) {
                currentString += arrayStorage.get(i);
            }
        }
        if (commandBuffer.equals("Put")) {
            commandBuffer = "";
            flagCommandBuffer = true; // command buffer is empty!!!
        }
        //block command-arrayStorage with DeleteItem
        if (commandBuffer.equals("DeleteItem") && Integer.parseInt(String.valueOf(stringBuffer)) <= (String.valueOf(arrayStorage.get(arrayStorage.size() - 1))).length()) {
            itemsDelete = Integer.parseInt(String.valueOf(stringBuffer));
            stringBuffer = new StringBuilder(String.valueOf(arrayStorage.get(arrayStorage.size() - 1)));
            arrayStorage.remove(arrayStorage.size() - 1);
            runningDelete = true;
        }

        for ( int i = 0 ;i < (stringBuffer.length() - 1) - (itemsDelete - 1) ; i++) {
            if (runningDelete) {
                bufferDelete += stringBuffer.charAt(i);
            }
        }
        if (runningDelete) {
            arrayStorage.add(bufferDelete);

        }
        //block output string with DELETE
        if (commandBuffer.equals("DeleteItem")) {
            currentString = "";
        }
        for (int i = 0; i < arrayStorage.size(); i++) {
            if (commandBuffer.equals("DeleteItem")) {
                currentString += arrayStorage.get(i);
            }
        }
        if (commandBuffer.equals("DeleteItem")) {
            itemsDelete = 0;
            stringBuffer = new StringBuilder("");
            bufferDelete = "";
            runningDelete = false; // bufferDelete is empty!!!
            commandBuffer = "";
            flagCommandBuffer = true; // command buffer is empty!!!
        }
        //block output string with OutputItem
        if (commandBuffer.equals("OutputItem")) {
            itemsOutput = Integer.parseInt(String.valueOf(stringBuffer));
            flagOutputItem = true;
            stringBuffer = new StringBuilder("");
        }
        for (int i = 0; i < arrayStorage.size() && flagOutputItem; i++) {
            getArrayStorageString += String.valueOf(arrayStorage.get(i));
        }
        for (int i = 0; i < getArrayStorageString.length(); i++) {
            if (flagOutputItem && itemsOutput <= getArrayStorageString.length() - 1) {
                stringOutputItem = String.valueOf(getArrayStorageString.charAt(itemsOutput));
                currentString = stringOutputItem; // здесь не обнулил строку т.к. это конечный вывод
                //обнули буфе ры что в этом блоке ЗДЕСЬЬ!!!
                itemsOutput = 0;
                flagOutputItem = false;
                getArrayStorageString = "";
                stringBuffer = new StringBuilder("");
                break;
            }
        }
        if (flagOutputItem && itemsOutput > stringBuffer.length() - 1) {
            currentString = "";
            //обнули буфе ры что в этом блоке ЗДЕСЬЬ ТОЖЕ т.к. это другая ветка события!!!
            itemsOutput = 0;
            flagOutputItem = false;
            getArrayStorageString = "";
            stringBuffer = new StringBuilder("");
        }
        //block Undo()

        if (commandBuffer.equals("Undo") && countStoreDelete > 0) {
            System.out.println(savingPutAndDelete);
            commandBufUndo = savingPutAndDelete.get(countSavingPutAndDelete -1);
            countSavingPutAndDelete -= 1;
        }
        // if in block Undo contains Put
        if (commandBufUndo.contains("Put")) {
            //add in store Redo
            storeForRedo.add(arrayStorage.get(arrayStorage.size() - 1));
            countStoreRedo += 1;
            arrayStorage.remove(arrayStorage.size() - 1); //удаляем из Арр СТОРЕ послед ячейку, а если надо будет ее вернуть? Когда буд делать РеДо предусм буфер для удаленных
            currentString = "";
        }
        for (int i = 0; i < arrayStorage.size() && commandBufUndo.contains("Put"); i++) {
            currentString += arrayStorage.get(i);
        }
        if (commandBufUndo.contains("Put")) {
            commandBufUndo = "";
        }
        // if in block Undo contains DeleteItems
        if (commandBufUndo.contains("DeleteItem")) {
            //add in store Redo
            storeForRedo.add(arrayStorage.get(arrayStorage.size() - 1));
            countStoreRedo += 1;
            currentString = storeDelete.get(countStoreDelete - 1);
            countStoreDelete -= 1;
        }
        //block Redo
        if (commandBuffer.equals("Redo") && countStorePut > 0 && countStoreRedo > 0) {
            System.out.println(savingPutAndDelete);
            System.out.println(storeForRedo);
            System.out.println(savingPutAndDelete.get(storeForRedo.size() -1));
            commandBufferRedo = savingPutAndDelete.get(storeForRedo.size() -1);
        }
        if (commandBufferRedo.contains("Put")) {
            currentString = "";
            //currentString = String.valueOf(storeForRedo);
            System.out.println(arrayStorage);
            countStorePut -= 1;
            countStoreRedo -= 1;
        }
        for (int i = 0; i < arrayStorage.size() && commandBufferRedo.contains("Put"); i++) {
            currentString += arrayStorage.get(i);
        }
        if (commandBufferRedo.contains("DeleteItem")) {
            arrayStorage.add(storeDelete.get(countStoreDelete -1));
            countStoreDelete -= 1;
            countStoreRedo -= 1;
        }
        for (int i = 0; i < arrayStorage.size() && commandBufferRedo.contains("DeleteItem"); i++) {
            currentString += arrayStorage.get(i);
        }
        commandBufferRedo = "";
        return currentString;
    }

}
