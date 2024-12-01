public class AddToCurrency {
    fishCounter fishCounter;
    public AddToCurrency(fishCounter fishCounter){
        this.fishCounter = fishCounter;
        fishCounter.currency = fishCounter.currency + 1;
    }
}
