package com.apress.springbook.chapter04;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: 19-feb-2006
 * Time: 19:13:09
 * To change this template use File | Settings | File Templates.
 */
public class Players {
    private Player player1;
    private Player player2;

    public Players(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
