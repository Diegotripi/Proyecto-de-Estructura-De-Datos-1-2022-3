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
    private static final NewStoragePage newStoragePage = new NewStoragePage();
    private static final ShowInvPage showInvPage = new ShowInvPage();
    private static final NewOrderPage newOrderPage = new NewOrderPage();
    private static Graph graph = new Graph();

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
     * opens showInvPage not closing the main one
     */
    public static void openShowInvPage() {
        getShowInvPage().setVisible(true);

        InterfaceFunctions.initShowInvPage();
        
        getMainPage().setVisible(false);
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

    }

    public static void openNewOrderPage() {
        getMainPage().setVisible(false);
        InterfaceFunctions.initNewOrderPage();
        getNewOrderPage().setVisible(true);
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
     * @return Graph
     */
    public static NewOrderPage getNewOrderPage() {
        return newOrderPage;
    }

}
