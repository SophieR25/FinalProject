public class fishCounter{
    double currency = 0;
    FishShopUIFinal fishShopUIFinal = new FishShopUIFinal();

    public double currencyUpdate(FishShopUIFinal fishShopUIFinal){
    if(fishShopUIFinal.fishShopLevel == 0){
        currency = currency + 0.001;
    }
    if(fishShopUIFinal.fishShopLevel == 1){
        currency = currency + 0.002;
    }
    if(fishShopUIFinal.fishShopLevel == 2){
        currency = currency + 0.003;
    }
    if(fishShopUIFinal.fishShopLevel == 3){
        currency = currency + 0.004;
    }
    return currency;
    }
}
