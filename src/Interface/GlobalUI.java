/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import main.Graph;

/**
 *
 * @author isaac
 */
public class GlobalUI {

    private static final MainPage mainPage = new MainPage();
    private static final AddNewRutesPage addNewRutesPage = new AddNewRutesPage();
    private static final NewStoragePage newStoragePage = new NewStoragePage();
    private static final ShowInvPage showInvPage = new ShowInvPage();
    private static final NewOrderPage newOrderPage = new NewOrderPage();
    private static final UploadDataPage uploadDataPage = new UploadDataPage();
    private static Graph graph = new Graph();
    private static String direction;

    /**
     *
     * Opens the main interface page
     */
    public static void openMainPage() {
        getMainPage().setVisible(true);
    }

    /**
     *
     * hides the main interface page and opens NewStoragePage
     */
    public static void openNewStoragePage() {
        getNewStoragePage().setVisible(true);
        getMainPage().setVisible(false);
        getNewStoragePage().createGprah(graph);
    }

    /**
     *
     * opens showInvPage
     */
    public static void openShowInvPage() {
        getShowInvPage().setVisible(true);

        InterfaceFunctions.initShowInvPage();

        getMainPage().setVisible(false);
    }
    
    /**
     *
     * opens show AddNewRutes
     */
    public static void openAddNewRutes() {
        getAddNewRutesPage().setVisible(true);
        
        getMainPage().setVisible(false);
        getAddNewRutesPage().createGprah(getGraph());
    }

    /**
     *
     * Hides every sub-page, and opens MainPage
     */
    public static void getBackToMainPage() {
        getMainPage().setVisible(true);

        // in here we will be adding every page to setVisible(false)
        // so we can recycle this method for every page
        getNewStoragePage().setVisible(false);
        getShowInvPage().setVisible(false);
        getNewOrderPage().setVisible(false);
        getUploadDataPage().setVisible(false);
        getAddNewRutesPage().setVisible(false);

    }

    /**
     *
     * opens NewOrderPage
     */
    public static void openNewOrderPage() {
        getMainPage().setVisible(false);
        
        InterfaceFunctions.initNewOrderPage();
        getNewOrderPage().setVisible(true);
    }

    
      /**
     *
     * opens UploadDataPage
     */
    public static void openUploadDataPage() {
        getMainPage().setVisible(false);
        getUploadDataPage().setVisible(true);
    }

    /**
     * Shows the graphic for the main graph
     */
    public static void showGraphMap() {
        InterfaceFunctions.createGraphMap();
    }

    /**
     *
     * Getter for MainPage
     *
     * @return MainPage
     */
    public static MainPage getMainPage() {
        return mainPage;
    }

    /**
     *
     * Getter for NewStoragePage
     *
     * @return NewStoragePage
     */
    public static NewStoragePage getNewStoragePage() {
        return newStoragePage;
    }

    /**
     *
     * Getter for ShowInvPage
     *
     * @return ShowInvPage
     */
    public static ShowInvPage getShowInvPage() {
        return showInvPage;
    }

    /**
     *
     * Getter for Graph
     *
     * @return Graph
     */
    public static Graph getGraph() {
        return graph;
    }

    /**
     *
     * Setter for Graph
     *
     * @param graph
     */
    public static void setGraph(Graph graph) {
        GlobalUI.graph = graph;
    }

    /**
     *
     * Getter for NewOrderPage
     *
     * @return NewOrderPage
     */
    public static NewOrderPage getNewOrderPage() {
        return newOrderPage;
    }
    
    /**
     * Getter for direction
     * @return 
     */

    public static String getDirection() {
        return direction;
    }
    
    /**
     * setter for Direction
     * @param direction 
     */

    public static void setDirection(String direction) {
        GlobalUI.direction = direction;
    }
    /**
     *
     * Getter for UploadDataPage
     *
     * @return UploadDataPage
     */
    public static UploadDataPage getUploadDataPage() {
        return uploadDataPage;
    }
    
    /**
     * Getter for AddNewRutesPage
     * @return 
     */

    public static AddNewRutesPage getAddNewRutesPage() {
        return addNewRutesPage;
    }
    
    
    

}
