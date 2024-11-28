public class CollisionChecker {
    public void checkCollision(Player player, GamePanel gamePanel){
        int playerTopBound = player.y + 20;
        int playerBottomBound = player.y + 40;
        int playerLeftBound = player.x + 9;
        int playerRightBound = player.x + 39;

        switch(player.direction){ // Fish shop
            case "up":
                if((playerTopBound < 380) && (playerTopBound > 375) && (75 < player.x) && (player.x < 235)){
                    player.collisionOn = true;
                }
                break;
            case "down":
                if((playerBottomBound > 270) && (playerBottomBound < 275) && (75 < player.x) && (player.x < 235)){
                    player.collisionOn = true;
                }
                break;
            // case "left":
            //     if((playerLeftBound < 250) && (playerLeftBound > 260) &&(200 < player.y) && (player.y < 250)){
            //         player.collisionOn = true;
            //     }
            //     break;
            // case "right":
            //     if((playerRightBound > 200) && (200 < player.y) && (player.y < 250)){
            //         player.collisionOn = true;
            //     }
            //     break;
        }
    }
}
