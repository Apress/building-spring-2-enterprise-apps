package com.apress.springbook.chapter01;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: 2-feb-2006
 * Time: 19:49:43
 * To change this template use File | Settings | File Templates.
 */
public class Match {

    private static GameCallback serverPointCallback;
    private static GameCallback receiverPointCallback;
    private static GameCallback aceCallback;

    private Player player1;
    private Player player2;
    private Stack<Game> games = new Stack<Game>();
    private Game currentGame;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    protected Game getCurrentGame() {
        return currentGame;
    }

    protected void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    protected Stack<Game> getGames() {
        return games;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void serverPoint() {
        execute(getServerPointCallback());
    }

    static {
        serverPointCallback = new GameCallback() {
            public Game doWithGame(Game game) {
                return game.serverPoint();
            }
        };
    }

    protected GameCallback getServerPointCallback() {
        return serverPointCallback;
    }

    public void ace() {
        execute(getAceCallback());
    }

    static {
        aceCallback = new GameCallback() {
            public Game doWithGame(Game game) {
                return game.ace();
            }
        };
    }

    protected GameCallback getAceCallback() {
        return aceCallback;
    }

    public void receiverPoint() {
        execute(getReceiverPointCallback());
    }

    static {
        receiverPointCallback = new GameCallback() {
            public Game doWithGame(Game game) {
                return game.receiverPoint();
            }
        };
    }

    protected GameCallback getReceiverPointCallback() {
        return receiverPointCallback;
    }

    protected void execute(GameCallback gameCallback) {
        verifyMatchIsActive();
        doExecuteGameCallback(gameCallback);
        checkCurrentGameAfterCallbackExecution();
    }

    protected void checkCurrentGameAfterCallbackExecution() {
        if (getCurrentGame().isGameOver()) {
            handleGameOver();
        }
    }

    protected void verifyMatchIsActive() {
        if (getCurrentGame() == null) {
            throw new IllegalStateException("Match is not active!");
        }
    }

    protected void handleGameOver() {
        addFinishedGame();
        Game newGame;
        if (!isMatchOver()) {
            newGame = createNewGame();
        } else {
            newGame = null;
        }
        setCurrentGame(newGame);
    }

    protected void addFinishedGame() {
        getGames().add(getCurrentGame());
    }

    protected Game createNewGame() {
        Game currentGame = getCurrentGame();
        if (getPlayer1() == currentGame.getServer()) {
            return new Game(getPlayer2(), currentGame.getOrder() + 1);
        } else {
            return new Game(getPlayer1(), currentGame.getOrder() + 1);
        }
    }

    protected void doExecuteGameCallback(GameCallback gameCallback) {
        Game result = gameCallback.doWithGame(getCurrentGame());
        setCurrentGame(result);
    }

    protected boolean isMatchOver() {
        throw new UnsupportedOperationException();
    }

    protected interface GameCallback {
        Game doWithGame(Game game);
    }
}
