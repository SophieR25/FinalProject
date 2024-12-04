public class fishCounter{
    GamePanel gamePanel;
    FindName findName;
    PanelWindow panelWindow;
    double currency = 0;
    FishShopUIFinal fishShopUIFinal;

    public fishCounter(GamePanel gamePanel, FishShopUIFinal fishShopUIFinal) {
        this.gamePanel = gamePanel;
        this.fishShopUIFinal = fishShopUIFinal;
        panelWindow = fishShopUIFinal.panelWindow;
    }

    public double currencyUpdate(FishShopUIFinal fishShopUIFinal){
    if(fishShopUIFinal.fishShopLevel == 0){
        currency = currency + 0.001;
        System.out.println("Level 0");
    }
    if(fishShopUIFinal.fishShopLevel == 1){
        currency = currency + 0.002;
        System.out.println("Level 1");

    }
    if(fishShopUIFinal.fishShopLevel == 2){
        currency = currency + 1;
        System.out.println("Level 2");

    }
    if(fishShopUIFinal.fishShopLevel == 3){
        currency = currency + 0.004;
    }
    return currency;
    }
}
