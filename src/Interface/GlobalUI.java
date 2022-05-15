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
     * Hides every sub-page, and opens MainPage
     */
    public static void getBakToMainPage() {
        GlobalUI.mainPage.setVisible(true);
        
        // in here we will be adding every page to setVisible(false)
        // so we can recycle this method for every page
        GlobalUI.newStoragePage.setVisible(false);
    }

    public static Graph getGraph() {
        return graph;
    }

    public static void setGraph(Graph grap) {
        GlobalUI.graph = grap;
    }
    
    
}
