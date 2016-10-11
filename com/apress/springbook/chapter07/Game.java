package com.apress.springbook.chapter07;

import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: 2-feb-2006
 * Time: 20:40:22
 * To change this template use File | Settings | File Templates.
 */
public class Game implements Ordered {

    private Player server;
    private Stack<Point> points = new Stack<Point>();
    private int order = 1;

    public Game(Player server) {
        this.server = server;
    }

    public Game(Player server, int order) {
        this.server = server;
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public Game serverPoint() {
        Game newGame = copy();
        newGame.points.add(new Point());
        return newGame;
    }

    public boolean isGameOver() {
        GameStats stats = new GameStats(points);

        if (stats.serverPoints < 4 && stats.receiverPoints < 4) {
            return false;
        } else if (stats.serverPoints == 4 && stats.receiverPoints < 3) {
            return true;
        } else if (stats.serverPoints < 3 && stats.receiverPoints == 4) {
            return true;
        } else if (Math.abs(stats.serverPoints - stats.receiverPoints) == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isServerWon() {
        GameStats stats = new GameStats(points);

        if (stats.serverPoints < 4) {
            return false;
        } else if (stats.serverPoints == 4 && stats.receiverPoints < 3) {
            return true;
        } else if (stats.serverPoints > stats.receiverPoints && stats.serverPoints - stats.receiverPoints == 2) {
            return true;
        } else {
            return false;
        }
    }

    public Game receiverPoint() {
        Game newGame = copy();
        newGame.points.add(new Point(false));
        return newGame;
    }

    public boolean isAdvantageServer() {
        GameStats stats = new GameStats(points);

        if (stats.serverPoints <= 4 && stats.receiverPoints <= 4) {
            return false;
        } else if (stats.serverPoints - stats.receiverPoints == 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isAdvantageReceiver() {
        GameStats stats = new GameStats(points);

        if (stats.serverPoints <= 4 && stats.receiverPoints <= 4) {
            return false;
        } else if (stats.receiverPoints - stats.serverPoints == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Game ace() {
        Game newGame = copy();
        newGame.points.add(new Ace());
        return newGame;
    }

    public int getNumberOfAces() {
        int numberOfAces = 0;
        for (Point point : points) {
            if (point instanceof Ace) {
                numberOfAces++;
            }
        }
        return numberOfAces;
    }

    public Player getServer() {
        return server;
    }

    public Game undo() {
        Game newGame = copy();
        newGame.points.pop();
        return newGame;
    }

    private Game copy() {
        Game newGame = new Game(server);
        newGame.points.addAll(points);
        return newGame;
    }

    protected static class GameStats {
        private int serverPoints = 0;
        private int receiverPoints = 0;

        protected int getServerPoints() {
            return serverPoints;
        }

        protected int getReceiverPoints() {
            return receiverPoints;
        }

        private GameStats(List<Point> points) {
            for (Point point  : points) {
                if (point.isServerPoint()) {
                    serverPoints++;
                } else {
                    receiverPoints++;
                }
            }
        }
    }

    protected static interface GameStatsSpecification {
        boolean isSatisfiedBy(GameStats gameStats);
    }

    protected static class GameOverSpecification implements GameStatsSpecification {
        public boolean isSatisfiedBy(GameStats gameStats) {
            if (gameStats.getServerPoints() < 4 && gameStats.getReceiverPoints() < 4) {
                return false;
            } else if (gameStats.getServerPoints() == 4 && gameStats.getReceiverPoints() < 3) {
                return true;
            } else if (gameStats.getServerPoints() < 3 && gameStats.getReceiverPoints() == 4) {
                return true;
            } else if (Math.abs(gameStats.getServerPoints() - gameStats.getReceiverPoints()) == 2) {
                return true;
            } else {
                return false;
            }
        }
    }

    protected static class ServerWonSpecification implements GameStatsSpecification {
        public boolean isSatisfiedBy(GameStats gameStats) {
            throw new UnsupportedOperationException();
        }
    }

    protected static class AdvantageServerSpecification implements GameStatsSpecification {
        public boolean isSatisfiedBy(GameStats gameStats) {
            throw new UnsupportedOperationException();
        }
    }

    protected static class AdvantageReceiverSpecification implements GameStatsSpecification {
        public boolean isSatisfiedBy(GameStats gameStats) {
            throw new UnsupportedOperationException();
        }
    }
}
