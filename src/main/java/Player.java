public class Player {
    private final String name;
    private Statistic[] lifetimeStats;

    public Player(String name) {
        this.name = name;
    }

    public void updateStat(Statistic statistic) {
        for (Statistic stat : lifetimeStats) {
            if (stat.getName().equals(statistic.getName())) {
                stat.updateValue(statistic.getValue());
            }
        }
    }
}
