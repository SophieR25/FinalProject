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
            case "left":
                if((playerLeftBound < 250) && (playerLeftBound > 240) && (235 < player.y) && (player.y < 355)){
                    player.collisionOn = true;
                }
                break;
            case "right":
                if((playerRightBound > 95) && (playerRightBound < 105) && (235 < player.y) && (player.y < 355)){
                    player.collisionOn = true;
                }
                break;
        }

        switch(player.direction){ // Left Wall
            case "left":
                if((playerLeftBound < 30) && (playerLeftBound > 25) && (-5 < player.y) && (player.y < 580)){
                    player.collisionOn = true;
                }
                break;
        }

        switch(player.direction){ // Top Wall
            case "up":
                if((playerTopBound < 30) && (playerTopBound > 25)&& (-5 < player.x) && (player.x < 790)){
                    player.collisionOn = true;
                }
                break;
    }

    switch(player.direction){ // Right Wall
        case "right":
            if((playerRightBound > 735) && (playerRightBound < 740) && (-5 < player.y) && (player.y < 580)){
                player.collisionOn = true;
            }
            break;
    }

    switch(player.direction){ // Bottom Wall
        case "down":
            if((playerBottomBound > 545) && (playerBottomBound < 550) && (-5 < player.x) && (player.x < 790)){
                player.collisionOn = true;
            }
            break;
    }

    switch(player.direction){ // Left Water
        case "down":
            if((playerBottomBound > 420) && (playerBottomBound < 425) && (-5 < player.x) && (player.x < 130)){
                player.collisionOn = true;
            }
            break;
        case "left":
            if((playerLeftBound < 150) && (playerLeftBound > 140) && (385 < player.y) && (player.y < 580)){
                player.collisionOn = true;
            }
            break;
    }

    switch(player.direction){ // Bottom Water
        case "down":
            if((playerBottomBound > 475) && (playerBottomBound < 480) && (-5 < player.x) && (player.x < 180)){
                player.collisionOn = true;
            }
            break;
    }

    switch(player.direction){ // Right Water
        case "down":
            if((playerBottomBound > 420) && (playerBottomBound < 425) && (150 < player.x) && (player.x < 250)){
                player.collisionOn = true;
            }
            break;
        case "left":
            if((playerLeftBound < 270) && (playerLeftBound > 265) && (384 < player.y) && (player.y < 600)){
                player.collisionOn = true;
            }
            break;
        case "right":
            if((playerRightBound > 175) && (playerRightBound < 180) && (384 < player.y) && (player.y < 580)){
                player.collisionOn = true;
            }
            break;
    }
}
}