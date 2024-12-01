public class FindName {
    String foundName;
    PanelWindow panelWindow;
    
    public String FindName(PanelWindow panelWindow){
        this.panelWindow = panelWindow;
        foundName = panelWindow.inputName;
        return foundName;
    }

}
