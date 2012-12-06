package achievement;

import statistic.StatSet;

public interface Achievement {
    boolean evaluate(StatSet aStatSet);

    void claim();
}
