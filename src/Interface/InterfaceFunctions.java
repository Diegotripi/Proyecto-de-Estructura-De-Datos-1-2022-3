/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import main.Graph;
import main.ListInv;
import main.ObjectList;
import main.ObjectNode;
import main.Product;
import main.Storage;

/**
 *
 * @author isaac
 */
public class InterfaceFunctions {

    /**
     * initializates the data needed for ShowInvPage
     *
     */
    public static void initShowInvPage() {

        Graph graph = GlobalUI.getGraph();
       
        
        ObjectList storagesDFS = graph.getStoragesByDFS();
        ObjectList storagesBFS = graph.getStoragesByBFS();
        
        GlobalUI.getShowInvPage().getTextFieldDFS().setText(buildStringTotalInv(storagesDFS));
        GlobalUI.getShowInvPage().getTextFieldBFS().setText(buildStringTotalInv(storagesBFS));


    }
    
        /**
     * 
     * From a NodeStorage list, build the string containing all 
     * of the inventory in storages
     * @param nodeStorageList
     * @return String
     */
    
    public static String buildStringTotalInv(ObjectList nodeStorageList){
        String msg = "";
        ObjectNode pointer = nodeStorageList.getHead();
        
        while(pointer != null) {
            Storage currentStorage = (Storage) pointer.getElement();
            msg += currentStorage.getName()+":\n";
            ListInv currentInv = currentStorage.getInventory();
            
            for (int i = 0; i<currentInv.getLenght(); i++) {
                Product currentProduct = currentInv.getElementInIndex(i);
                msg+= currentProduct.getName()+": "+ currentProduct.getQuantity()+"\n";
            }
            msg+="\n";
            
            
            pointer = pointer.getNext();
        }
        
        return msg;
       
    }
}
