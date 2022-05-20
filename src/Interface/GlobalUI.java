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
    private static Graph graph = new Graph();

    /**
     *
     * Opens the main interface page
     */
    public static void openMainPage() {
        GlobalUI.mainPage.setVisible(true);
    }

    /**
     *
     * hides the main interface page and opens NewStoragePage
     */
    public static void openNewStoragePage() {
        GlobalUI.newStoragePage.setVisible(true);
        GlobalUI.mainPage.setVisible(false);
    }
    /**
     *
     * opens showInvPage not closing the main one
     */
    public static void openShowInvPage(){
        GlobalUI.showInvPage.setVisible(true);
        InterfaceFunctions.initShowInvPage();
    }

    /**
     *
     * Hides every sub-page, and opens MainPage
     */
    public static void getBakToMainPage() {
        GlobalUI.mainPage.setVisible(true);
        
        // in here we will be adding every page to setVisible(false)
        // so we can recycle this method for every page
        GlobalUI.newStoragePage.setVisible(false);
        GlobalUI.showInvPage.setVisible(false);
    }

    /**
     *
     * Getter for MainPage
     * @return MainPage
     */
    public static MainPage getMainPage() {
        return mainPage;
    }

    
    /**
     *
     * Getter for NewStoragePage
     * @return NewStoragePage
     */
    public static NewStoragePage getNewStoragePage() {
        return newStoragePage;
    }

        
    /**
     *
     * Getter for ShowInvPage
     * @return ShowInvPage
     */
    public static ShowInvPage getShowInvPage() {
        return showInvPage;
    }
    
    
    
    
    /**
     *
     * Getter for Graph
     * @return Graph
     */
    public static Graph getGraph() {
        return graph;
    }

    public static void setGraph(Graph grap) {
        GlobalUI.graph = grap;
    }
    
    
}
